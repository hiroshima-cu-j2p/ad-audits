package jp.co.hiroshimaj2p.audit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.hiroshimaj2p.audit.dto.AgencyDTO;
import jp.co.hiroshimaj2p.audit.utility.DBConnectionManager;

public class AgencyDAO {
	public List<AgencyDTO> getAllAgencyData(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AgencyDTO> lstAgen=new ArrayList<AgencyDTO>();
			try {
				conn=DBConnectionManager.getConnection();
				String sqlQuery = "select agency_id, agency_name from ad_agency";
							
				stmt = conn.prepareStatement(sqlQuery);
				rs = stmt.executeQuery();		
				AgencyDTO dto=null;
				while(rs.next()) {
					dto =new AgencyDTO();
					dto.setId(rs.getInt(1));
					dto.setName(rs.getString(2));
					lstAgen.add(dto);
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lstAgen;
			
	}

}
