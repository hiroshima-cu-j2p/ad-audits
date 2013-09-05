package jp.co.hiroshimaj2p.audit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.hiroshimaj2p.audit.dto.AuditorDTO;
import jp.co.hiroshimaj2p.audit.utility.DBConnectionManager;

public class AuditorDAO {
	private String SELECT_ALL = "select auditor_id, auditor_name, auditor_email from auditor where auditor_is_mgr is false";

	public List<AuditorDTO> getAllAuditors() {
		
		
		List<AuditorDTO> lstAuditors = new ArrayList<AuditorDTO>();

		Connection conn = DBConnectionManager.getConnection();

		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rs = stmt.executeQuery();
			AuditorDTO dto = null;
			while (rs.next()) {
				dto = new AuditorDTO();
				dto.setId(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setEmail(rs.getString(3));
				dto.setManager(Boolean.FALSE);

				lstAuditors.add(dto);
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
		return lstAuditors;
	}

}
