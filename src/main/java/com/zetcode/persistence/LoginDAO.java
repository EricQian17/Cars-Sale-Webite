package com.zetcode.persistence;

import static com.zetcode.util.GLOBAL.DATA_SOURCE;

import java.util.List;

import com.jbbwebsolutions.dao.IQuery;
import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLExecutable;
import com.jbbwebsolutions.utility.SQLUtility;
import com.zetcode.bean.Login;

public class LoginDAO implements IQuery<Login> {

	@Override
	public List<Login> findAll() {

		String sql = " SELECT USERID, ENCRYPTEDPASSWORD " + " FROM USERIDANDENCRYPTEDPASSWORD ";

		SQLExecutable<Login> executable = rs -> {

			String username = rs.getString("USERID");
			String password = rs.getString("ENCRYPTEDPASSWORD");

			return new Login(username, password);

		};
		List<Login> logins = SQLUtility.execute(sql, DATA_SOURCE, ESQL.DATASOURCE, executable);

		return logins;
	}

}
