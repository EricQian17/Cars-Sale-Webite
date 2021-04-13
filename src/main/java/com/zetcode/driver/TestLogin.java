package com.zetcode.driver;

import java.util.List;

import com.citytech.basicsecurity.SimpleEncryption;
import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLExecutable;
import com.jbbwebsolutions.utility.SQLUtility;
import com.zetcode.bean.Login;

public class TestLogin {
	
	public static void main(String[] args)
	{
		String user = "user-130";
		String pass = "password1264";
		
		String url = "jdbc:derby://localhost:1527/carsDB"
				  + ";user=app;password=password1234";
		String sql = " SELECT USERID, ENCRYPTEDPASSWORD " + " FROM USERIDANDENCRYPTEDPASSWORD ";

		SQLExecutable<Login> executable = rs -> {

			String username = rs.getString("USERID");
			String password = rs.getString("ENCRYPTEDPASSWORD");

			return new Login(username, password);

		};
		List<Login> logins = SQLUtility.execute(sql, url, ESQL.CONNECTION, executable);
		System.out.println("Test");
		for(int x = 0;x<logins.size();x++)
		{
			String testUser = logins.get(x).getUsername();
			if(testUser.contentEquals(user))
			{
				String encryptPass = logins.get(x).getPassword();
				String unencryptPass = SimpleEncryption.decrypt(encryptPass);
				if(unencryptPass.contentEquals(pass))
				{
					return;
				}
				else
				{
					return;
				}
					
				
					
			}
		}
	}



}
