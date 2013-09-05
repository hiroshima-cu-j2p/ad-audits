package jp.co.hiroshimaj2p.audit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.hiroshimaj2p.audit.dto.CorporateAgencyDTO;
import jp.co.hiroshimaj2p.audit.utility.DBConnectionManager;

public class CorporateAgencyDAO {
	
	public List<CorporateAgencyDTO> getCorporateAgencyData(){
		List<CorporateAgencyDTO> dto=null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn=DBConnectionManager.getConnection();
			String sqlQuery = "select location_name,corporate_name,agency_name,ad_product_name,ad_description "+
				"from ad ad,location loc, corporate corp,ad_agency agency "+
				"where ad.ad_location = loc.location_id "+
				"and ad.ad_corporate_id = corp.corporate_id "+
				"and ad.ad_agency_id = agency.agency_id";
			stmt = conn.prepareStatement(sqlQuery);
			rs = stmt.executeQuery();		
			dto = new ArrayList<CorporateAgencyDTO>();
			while(rs.next()) {
				CorporateAgencyDTO tempAd=new CorporateAgencyDTO();
				tempAd.setLocation(rs.getString("location_name"));
				tempAd.setCompany(rs.getString("corporate_name"));
				tempAd.setAgency(rs.getString("agency_name"));
				tempAd.setProduct(rs.getString("ad_product_name"));
				tempAd.setDiscription(rs.getString("ad_description"));
				dto.add(tempAd);
				
			}
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			conn.close();	
		
		} catch (SQLException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
}
