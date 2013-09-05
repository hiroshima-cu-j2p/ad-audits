package jp.co.hiroshimaj2p.audit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jp.co.hiroshimaj2p.audit.dto.ADAddFormDTO;
import jp.co.hiroshimaj2p.audit.utility.DBConnectionManager;

public class ADAddFormDAOImpl {
	public Integer insertAd(ADAddFormDTO dto) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rs = 0;
		try {
			conn = DBConnectionManager.getConnection();
			String sqlQuery = "insert into ad (ad_corporate_id, ad_agency_id, ad_product_name, ad_description, ad_location)" +
					"values (?,?,?,?,?)";
			
			stmt = conn.prepareStatement(sqlQuery);
			stmt.setInt(1, dto.getCorporateId());
			stmt.setInt(2, dto.getAgencyId());
			stmt.setString(3, dto.getProductName());
			stmt.setString(4, dto.getDescription());
			stmt.setInt(5, dto.getLocationId());
			
			rs = stmt.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Error Closing Connection:");
				e.printStackTrace();
			}
		}
		return rs;
	}
}
