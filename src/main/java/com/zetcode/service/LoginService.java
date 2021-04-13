package com.zetcode.service;

import java.util.List;

import com.citytech.basicsecurity.SimpleEncryption;
import com.jbbwebsolutions.dao.IQuery;
import com.zetcode.bean.Login;
import com.zetcode.persistence.LoginDAO;

public class LoginService {

	public static boolean login(String userId, String password) {
		
		IQuery<Login> loginDAO = new LoginDAO();
		List<Login> logins = loginDAO.findAll();
		for(int x = 0;x<logins.size();x++)
		{
			String testUser = logins.get(x).getUsername();
			if(testUser.contentEquals(userId))
			{
				String encryptPass = logins.get(x).getPassword();
				String unencryptPass = SimpleEncryption.decrypt(encryptPass);
				if(unencryptPass.contentEquals(password))
				{
					return true;
				}
				else
				{
					return false;
				}	
			}
		}
		return false;
	}

}
