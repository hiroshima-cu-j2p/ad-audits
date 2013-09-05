package jp.co.hiroshimaj2p.audit.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.hiroshimaj2p.audit.dao.AuditPlanDetailDAO;
import jp.co.hiroshimaj2p.audit.dao.AuditorViewDAO;
import jp.co.hiroshimaj2p.audit.dto.AuditPlanViewDTO;
import jp.co.hiroshimaj2p.audit.form.AuditorViewForm;
import jp.co.hiroshimaj2p.audit.utility.DBConnectionManager;

/**
 * Servlet implementation class AssignAuditerServlet
 */
public class AuditorViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * Default constructor.
	 */
	public AuditorViewServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		AuditorViewDAO auditorDAO = new AuditorViewDAO();
		AuditorViewForm form = new AuditorViewForm();
		 List<AuditPlanViewDTO> lstPlanView =  auditorDAO.getAuditPlanData(1);
		form.setViewList(lstPlanView);
		
		AuditPlanDetailDAO planDetailDAO = new AuditPlanDetailDAO();
		for(AuditPlanViewDTO dto : lstPlanView) {
			dto.setPlanDetails(planDetailDAO.getDetails(dto.getPlanId()));
		}
		
		
		request.setAttribute("AUDITORVIEWFORM", form);
		request.getRequestDispatcher("AuditorView.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
