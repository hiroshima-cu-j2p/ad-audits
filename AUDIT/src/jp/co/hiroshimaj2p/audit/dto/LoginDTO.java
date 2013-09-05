package jp.co.hiroshimaj2p.audit.dto;

public class LoginDTO {
	private String loginId=null;
	private String loginPassword=null;
	private String loginType = null;
	private boolean manager = false;
	
	public String getLoginId() {
		return loginId;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public boolean isManager() {
		return manager;
	}
	public void setManager(boolean manager) {
		this.manager = manager;
	}
	
	
	
	
}
