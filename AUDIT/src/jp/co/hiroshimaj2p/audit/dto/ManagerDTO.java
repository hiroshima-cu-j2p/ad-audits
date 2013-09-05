package jp.co.hiroshimaj2p.audit.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class ManagerDTO {
//	private Integer auditPlaneId=null;
	private String location=null;
	private String company=null;
	private String agency=null;
	private String product=null;
	private String discription=null;
	private String auditorName=null;
	private Date assignDate=null;
	private Timestamp commentTime=null;
	private String comment=null;	
	
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
//	public void setAuditPlaneId(Integer auditPlaneId) {
//		this.auditPlaneId = auditPlaneId;
//	}
//	public Integer getAuditPlaneId() {
//		return auditPlaneId;
//	}
	
	public String getAuditorName() {
		return auditorName;
	}
	public void setAuditorName(String auditorName) {
		this.auditorName = auditorName;
	}
	public Date getAssignDate() {
		return assignDate;
	}
	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
	}
	public Timestamp getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int size(){
		return this.size;
	}
}
