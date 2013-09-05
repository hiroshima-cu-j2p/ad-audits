package jp.co.hiroshimaj2p.audit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.hiroshimaj2p.audit.dto.PlanDetailDTO;
import jp.co.hiroshimaj2p.audit.utility.DBConnectionManager;

public class AuditPlanDetailDAO {
	private static String SQL_QUERY = "select 	apd_plan_id, apd_comment, verified_status_name, apd_time"
			+ " from 	audit_plan_detail , verified_status where "
			+ " apd_verified_status = verified_status_id and apd_plan_id = ? order by apd_time asc";
	public List<PlanDetailDTO> getDetails(Integer planId)
	{
		List<PlanDetailDTO> lstDetail = new ArrayList<PlanDetailDTO>();
		
		Connection conn = DBConnectionManager.getConnection();
		
		try {
			PreparedStatement stmt = conn.prepareStatement(SQL_QUERY);
			stmt.setInt(1, planId);
			ResultSet rs = stmt.executeQuery();
			PlanDetailDTO dto = null;
			while (rs.next()) {
				dto = new PlanDetailDTO();
				dto.setPlanId(rs.getInt(1));
				dto.setComment(rs.getString(2));
				dto.setStatus(rs.getString(3));
				dto.setCommentTime(rs.getTimestamp(4));

				lstDetail.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			conn.close();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		return lstDetail;
	}
}
