package jp.co.hiroshimaj2p.audit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.hiroshimaj2p.audit.dto.AuditPlanViewDTO;
import jp.co.hiroshimaj2p.audit.utility.DBConnectionManager;



public class AuditorViewDAO {

	public List<AuditPlanViewDTO> getAuditPlanData(Integer auditorId){
		AuditPlanViewDTO dto=null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AuditPlanViewDTO> lstDTOs = new ArrayList<AuditPlanViewDTO>();
		try {
			conn=DBConnectionManager.getConnection();
			String sqlQuery =
				"select ad_id,audit_plan_id, corporate_name,agency_name,ad_product_name,ad_description,location_name,audit_plan_date, auditor_name "
				+"from ad,location loc, corporate corp,ad_agency agency,audit_plan plan, auditor "
				+"where ad.ad_location = loc.location_id and ad.ad_corporate_id = corp.corporate_id "
				+"and ad.ad_agency_id = agency.agency_id and plan.audit_plan_ad_id=ad.ad_id "
				+"and ad.ad_id = plan.audit_plan_ad_id and  audit_plan_auditor_id = ? "
				+"and auditor.auditor_id = plan.audit_plan_auditor_id";

			stmt = conn.prepareStatement(sqlQuery);
			stmt.setInt(1, auditorId);
			rs = stmt.executeQuery();		
			while(rs.next()) {
				dto = new AuditPlanViewDTO();
				dto.setLocation(rs.getString("location_name"));
				dto.setCompanyName(rs.getString("corporate_name"));
				dto.setAgencyName(rs.getString("agency_name"));
				dto.setProductName(rs.getString("ad_product_name"));
				dto.setDescription(rs.getString("ad_description"));
				dto.setPlanId(rs.getInt("audit_plan_id"));
				lstDTOs.add(dto);
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
		return lstDTOs;
	}
	
}