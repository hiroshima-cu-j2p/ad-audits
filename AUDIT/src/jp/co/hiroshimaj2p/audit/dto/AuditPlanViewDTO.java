package jp.co.hiroshimaj2p.audit.dto;

import java.util.List;

public class AuditPlanViewDTO {
	private String location = null;
	private String companyName = null;
	private String agencyName = null;
	private String productName =null;
	private String description = null;
	private Integer planId = null;
	
	private List<PlanDetailDTO> planDetails = null;
	
	
	public List<PlanDetailDTO> getPlanDetails() {
		return planDetails;
	}
	public void setPlanDetails(List<PlanDetailDTO> planDetails) {
		this.planDetails = planDetails;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}



}
