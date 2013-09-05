package jp.co.hiroshimaj2p.audit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jp.co.hiroshimaj2p.audit.dto.AuditReportingDTO;
import jp.co.hiroshimaj2p.audit.utility.DBConnectionManager;

public class AuditorReportingDAOImpl {
	
	public AuditReportingDTO getAuditorReportingData(Integer id){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		AuditReportingDTO tempAd = null;
 		try {
			conn=DBConnectionManager.getConnection();
			String sqlQuery = "select corporate_name,ad_product_name,agency_name,location_name,ad_description, audit.audit_plan_id "+ 
			"from audit_plan audit, ad ad,corporate corp,ad_agency agency,location loc "+
			"where audit.audit_plan_ad_id = ad.ad_id "+ 
			"and ad.ad_corporate_id = corp.corporate_id "+ 
			"and ad.ad_location = loc.location_id "+ 
			"and ad.ad_agency_id = agency.agency_id "+
			"and audit.audit_plan_id = ? ";
			
			stmt = conn.prepareStatement(sqlQuery);
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			tempAd=new AuditReportingDTO();
			while(rs.next()) {
				tempAd.setAuditPlaneId(rs.getInt("audit_plan_id"));
				tempAd.setCompany(rs.getString("corporate_name"));
				tempAd.setProduct(rs.getString("ad_product_name"));
				tempAd.setAgency(rs.getString("agency_name"));
				tempAd.setLocation(rs.getString("location_name"));
				tempAd.setDiscription(rs.getString("ad_description"));
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
		return tempAd;
	}
	
	public void insertAuditorReportingData(
			Integer auditPlanId, Integer statusId, String comment){
		Connection conn = null;
		PreparedStatement stmt = null;
 		try {
			conn=DBConnectionManager.getConnection();
			String sqlQuery = "INSERT INTO audit_plan_detail(apd_plan_id,apd_verified_status,apd_comment,apd_time)"+
						" values (?,?,?,?)";
			stmt = conn.prepareStatement(sqlQuery);
			stmt.setInt(1, auditPlanId);
			stmt.setInt(2, statusId);
			stmt.setString(3, comment);
			stmt.setTimestamp(4, new Timestamp(new Date().getTime()));
			stmt.executeUpdate();
			conn.commit();
			conn.close();	
 		} catch (SQLException e){
 			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
