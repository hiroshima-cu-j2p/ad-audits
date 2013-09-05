package jp.co.hiroshimaj2p.audit.form;

import java.util.List;

import jp.co.hiroshimaj2p.audit.dto.AuditorDTO;

public class AssignAuditerForm {
	private String companyName = null;
	private String agencyName = null;
	private String descripution = null;
	private String location = null;
	private String auditDate = null;
	private Integer auditerNameId = null;
	private String auditerName = null;
	private Integer adId = null;
	private List<AuditorDTO> auditors = null;

	public List<AuditorDTO> getAuditors() {
		return auditors;
	}

	public void setAuditors(List<AuditorDTO> auditors) {
		this.auditors = auditors;
	}

	public Integer getAdId() {
		return adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getDescripution() {
		return descripution;
	}

	public void setDescripution(String descripution) {
		this.descripution = descripution;
	}

	public String getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate;
	}

	public Integer getAuditerNameId() {
		return auditerNameId;
	}

	public void setAuditerNameId(Integer auditerNameId) {
		this.auditerNameId = auditerNameId;
	}

	public String getAuditerName() {
		return auditerName;
	}

	public void setAuditerName(String auditerName) {
		this.auditerName = auditerName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}