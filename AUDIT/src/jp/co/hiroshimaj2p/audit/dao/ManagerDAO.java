package jp.co.hiroshimaj2p.audit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.hiroshimaj2p.audit.dto.ManagerDTO;
import jp.co.hiroshimaj2p.audit.utility.DBConnectionManager;

public class ManagerDAO {
	
	public List<ManagerDTO> getManagerData(){
		List<ManagerDTO> dto=null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn=DBConnectionManager.getConnection();
			String sqlQuery = "select loc.location_name,corp.corporate_name,agency.agency_name,ad.ad_product_name, "+
						"auditor.auditor_name,aplan.audit_plan_date,apd.apd_time,apd.apd_comment,ad.ad_description "+
						"from ad ad,location loc, corporate corp,ad_agency agency,auditor auditor, "+
						"audit_plan aplan, audit_plan_detail apd "+
						"where ad.ad_location = loc.location_id "+
						"and ad.ad_corporate_id = corp.corporate_id "+
						"and ad.ad_agency_id = agency.agency_id";

			stmt = conn.prepareStatement(sqlQuery);
			rs = stmt.executeQuery();		
			dto = new ArrayList<ManagerDTO>();
			while(rs.next()) {
				ManagerDTO tempAd=new ManagerDTO();
				tempAd.setLocation(rs.getString("location_name"));
				tempAd.setCompany(rs.getString("corporate_name"));
				tempAd.setAgency(rs.getString("agency_name"));
				tempAd.setProduct(rs.getString("ad_product_name"));
				tempAd.setAuditorName(rs.getString("auditor_name"));
				tempAd.setDiscription(rs.getString("ad_description"));
				tempAd.setAssignDate(rs.getDate("audit_plan_date"));
				tempAd.setCommentTime(rs.getTimestamp("apd_time"));
				tempAd.setComment(rs.getString("apd_comment"));
				
				dto.add(tempAd);
			}
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			conn.close();	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public List<ManagerDTO> getManagerData(Integer statusID){
		List<ManagerDTO> dto=null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlQuery = "select loc.location_name,corp.corporate_name,agency.agency_name,ad.ad_product_name, "+
			"auditor.auditor_name,aplan.audit_plan_date,apd.apd_time,apd.apd_comment,ad.ad_description, "+
			"status.verified_status_name "+
			"from location loc, corporate corp,ad_agency agency,verified_status status, "+
			"ad ad "+
			"left join audit_plan aplan "+
			"on ad.ad_id = aplan.audit_plan_ad_id "+
			"left join audit_plan_detail apd "+ 
			"on aplan.audit_plan_id = apd.apd_plan_id "+
			"left join auditor auditor "+
			"on aplan.audit_plan_auditor_id = auditor.auditor_id "+
			"where ad.ad_location = loc.location_id "+
			"and ad.ad_corporate_id = corp.corporate_id "+
			"and ad.ad_agency_id = agency.agency_id "+
			"and status.verified_status_id = ad.ad_verified_status ";
		
		try {
			conn=DBConnectionManager.getConnection();			

			stmt = conn.prepareStatement(sqlQuery);
			rs = stmt.executeQuery();		
			dto = new ArrayList<ManagerDTO>();
			while(rs.next()) {
				ManagerDTO tempAd=new ManagerDTO();
				tempAd.setLocation(rs.getString("location_name"));
				tempAd.setCompany(rs.getString("corporate_name"));
				tempAd.setAgency(rs.getString("agency_name"));
				tempAd.setProduct(rs.getString("ad_product_name"));
				
				tempAd.setAuditorName(rs.getString("auditor_name"));
				tempAd.setDiscription(rs.getString("ad_description"));
				tempAd.setAssignDate(rs.getDate("audit_plan_date"));
				tempAd.setCommentTime(rs.getTimestamp("apd_time"));
				tempAd.setComment(rs.getString("apd_comment"));
				
				dto.add(tempAd);
			}
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			conn.close();	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
}

