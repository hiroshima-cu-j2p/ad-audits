package jp.co.hiroshimaj2p.audit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sun.misc.BASE64Encoder;


import jp.co.hiroshimaj2p.audit.dto.LoginDTO;
import jp.co.hiroshimaj2p.audit.utility.DBConnectionManager;

public class LoginDAO {
	private static String SELECT_ALL = "select auditor_id, auditor_name, auditor_email, auditor_pwd, auditor_is_mgr from auditor where auditor_email = ?";
	
	public LoginDTO checkLogin(LoginDTO input){
		LoginDTO login = null;
		
		if("C".equals(input.getLoginType())) {
			return input;
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
			try {
				conn=DBConnectionManager.getConnection();
				stmt = conn.prepareStatement(SELECT_ALL);
				stmt.setString(1, input.getLoginId());
				rs = stmt.executeQuery();		
				while(rs.next()) {
					
					String passwd = rs.getString("auditor_pwd");
					String inpPasswd = input.getLoginPassword();
					BASE64Encoder encode = new BASE64Encoder();
					inpPasswd = encode.encode(inpPasswd.getBytes());
					if(null != passwd && passwd.equals(inpPasswd)) {
						login = new LoginDTO();
						login.setLoginId(rs.getString("auditor_email"));
						login.setLoginType(input.getLoginType());
						login.setManager(rs.getBoolean("auditor_is_mgr"));
					}
					
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return login;
			
	}

}
