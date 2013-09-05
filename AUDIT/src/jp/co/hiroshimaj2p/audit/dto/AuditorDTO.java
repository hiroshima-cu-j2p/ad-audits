package jp.co.hiroshimaj2p.audit.dto;

public class AuditorDTO {
	private Integer id = null;
	private String name = null;
	private String email = null;
	private String password = null;
	private Boolean manager = null;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean isManager() {
		return manager;
	}
	public void setManager(Boolean manager) {
		this.manager = manager;
	}
}
