package jp.co.hiroshimaj2p.audit.form;

import java.util.List;

import jp.co.hiroshimaj2p.audit.dto.AuditPlanViewDTO;

public class AuditorViewForm {
	List<AuditPlanViewDTO> viewList = null;
	public List<AuditPlanViewDTO> getViewList() {
		return viewList;
	}
	public void setViewList(List<AuditPlanViewDTO> viewList) {
		this.viewList = viewList;
	}
}