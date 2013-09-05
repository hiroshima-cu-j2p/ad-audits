package jp.co.hiroshimaj2p.audit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import jp.co.hiroshimaj2p.audit.dto.LocationDTO;
import jp.co.hiroshimaj2p.audit.utility.DBConnectionManager;

public class LocationDAO {
	public List<LocationDTO> getAllLocationData(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<LocationDTO> lstLoca=new ArrayList<LocationDTO>();
			try {
				conn=DBConnectionManager.getConnection();
				String sqlQuery = "select location_id, location_name from location";
							
				stmt = conn.prepareStatement(sqlQuery);
				rs = stmt.executeQuery();		
				LocationDTO dto=null;
				while(rs.next()) {
					dto =new LocationDTO();
					dto.setId(rs.getInt(1));
					dto.setName(rs.getString(2));
					lstLoca.add(dto);
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lstLoca;
			
	}

}
