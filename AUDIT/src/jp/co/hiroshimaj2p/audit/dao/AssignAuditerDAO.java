package jp.co.hiroshimaj2p.audit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.xml.soap.Detail;

import jp.co.hiroshimaj2p.audit.dto.AssignDTO;
import jp.co.hiroshimaj2p.audit.form.AssignAuditerForm;
import jp.co.hiroshimaj2p.audit.utility.DBConnectionManager;



public class AssignAuditerDAO {

	public AssignDTO getAuditPlanData(Integer adId){
		AssignDTO dto=null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn=DBConnectionManager.getConnection();
			String sqlQuery ="select ad_id, corporate_name,agency_name,ad_description,location_name,audit_plan_date, auditor_name "
				+"from ad,location loc, corporate corp,ad_agency agency,audit_plan plan, auditor "
				+"where ad.ad_location = loc.location_id and ad.ad_corporate_id = corp.corporate_id and "
				+"ad.ad_agency_id = agency.agency_id and plan.audit_plan_ad_id=ad.ad_id and ad.ad_id = ? and "
				+"auditor.auditor_id = plan.audit_plan_auditor_id";
			stmt = conn.prepareStatement(sqlQuery);
			stmt.setInt(1, adId);
			rs = stmt.executeQuery();		
			while(rs.next()) {
				dto=new AssignDTO();
				dto.setCompany(rs.getString("corporate_name"));
				dto.setAgency(rs.getString("agency_name"));
				dto.setDiscription(rs.getString("ad_description"));
				dto.setLocation(rs.getString("location_name"));
				dto.setAuditDate(rs.getDate("audit_plan_date"));
				dto.setAuditorName(rs.getString("auditor_name"));
				dto.setAdId(rs.getInt("ad_id"));
			}
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			conn.close();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	public Integer updateAuditPlan(AssignDTO dto) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rs = 0;
		try {
			conn = DBConnectionManager.getConnection();
			String sqlQuery = "update audit_plan "
					+ "set audit_plan_date =?,audit_plan_auditor_id =?  "
					+ "where audit_plan_id =? ";
			stmt = conn.prepareStatement(sqlQuery);
			stmt.setDate(1,new java.sql.Date((dto.getAuditDate()).getTime()));
			stmt.setInt(2,dto.getAuditorId());
			stmt.setInt(3,dto.getAdId());
			rs = stmt.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
}