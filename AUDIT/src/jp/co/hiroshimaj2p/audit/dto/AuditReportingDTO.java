package jp.co.hiroshimaj2p.audit.dto;

public class AuditReportingDTO {
	private Integer auditPlaneId=null;
	private String location=null;
	private String company=null;
	private String agency=null;
	private String product=null;
	private String discription=null;
	
	private int size=6;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public void setAuditPlaneId(Integer auditPlaneId) {
		this.auditPlaneId = auditPlaneId;
	}
	public Integer getAuditPlaneId() {
		return auditPlaneId;
	}
	
	public int size(){
		return this.size;
	}
}
