package jp.co.hiroshimaj2p.audit.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.hiroshimaj2p.audit.dao.AssignAuditerDAO;
import jp.co.hiroshimaj2p.audit.dao.AuditorDAO;
import jp.co.hiroshimaj2p.audit.dto.AssignDTO;
import jp.co.hiroshimaj2p.audit.form.AssignAuditerForm;

/**
 * Servlet implementation class AssignAuditerServlet
 */
public class AssignAuditerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AssignAuditerServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AssignAuditerDAO auditDAO = new AssignAuditerDAO();
		Integer adId = Integer.parseInt(request.getParameter("id"));

		AssignDTO dto = auditDAO.getAuditPlanData(adId);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		AssignAuditerForm form = new AssignAuditerForm();
		form.setAgencyName(dto.getAuditorName());
		form.setCompanyName(dto.getCompany());
		form.setLocation(dto.getLocation());
		form.setDescripution(dto.getDiscription());
		form.setAuditerName(dto.getAuditorName());
		form.setAuditDate(format.format(dto.getAuditDate()));
		form.setAdId(dto.getAdId());

		AuditorDAO auditorDAO = new AuditorDAO();
		form.setAuditors(auditorDAO.getAllAuditors());
		
		request.setAttribute("ASSIGNAUDITORFORM", form);
		request.getRequestDispatcher("assignAuditor.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String auditorIdStr = request.getParameter("auditer_name");
		String auditDateStr = request.getParameter("auditdate");
		String adIdStr = request.getParameter("id");

		System.out.println("Auditor ID: " + auditorIdStr);
		System.out.println("Audit Date: " + auditDateStr);
		System.out.println("Ad ID: " + adIdStr);

		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

		Integer auditorId = Integer.parseInt(auditorIdStr);
		Integer adId = Integer.parseInt(adIdStr);
		
		AssignDTO dto = new AssignDTO();
		dto.setAdId(adId);
		dto.setAuditorId(auditorId);
		try {
			dto.setAuditDate(date.parse(auditDateStr));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AssignAuditerDAO auditDAO = new AssignAuditerDAO();
		auditDAO.updateAuditPlan(dto);
		
		AssignAuditerForm assignForm = new AssignAuditerForm();
		assignForm.setAuditerNameId(auditorId);
		assignForm.setAuditDate(auditDateStr);
		assignForm.setAdId(Integer.parseInt(adIdStr));
		

	}
}
