package jp.co.hiroshimaj2p.audit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.hiroshimaj2p.audit.dto.CorporateDTO;
import jp.co.hiroshimaj2p.audit.utility.DBConnectionManager;

public class CorporateDAO {
	public List<CorporateDTO> getAllCorporateData(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<CorporateDTO> lstCorp=new ArrayList<CorporateDTO>();
			try {
				conn=DBConnectionManager.getConnection();
				String sqlQuery = "select corporate_id, corporate_name from corporate";
				
				stmt = conn.prepareStatement(sqlQuery);
				rs = stmt.executeQuery();		
				CorporateDTO dto=null;
				while(rs.next()) {
					dto =new CorporateDTO();
					dto.setId(rs.getInt(1));
					dto.setName(rs.getString(2));
					lstCorp.add(dto);
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lstCorp;
			
	}

}
