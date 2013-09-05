package jp.co.hiroshimaj2p.audit.dto;

import java.sql.Timestamp;

public class PlanDetailDTO {
	private Integer planId = null;
	private String status = null;
	private String comment = null;
	private Timestamp commentTime = null;

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}

}
