package jp.co.hiroshimaj2p.audit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.hiroshimaj2p.audit.dao.AuditorReportingDAOImpl;
import jp.co.hiroshimaj2p.audit.dto.AuditReportingDTO;
import jp.co.hiroshimaj2p.audit.dto.CorporateAgencyDTO;
import jp.co.hiroshimaj2p.audit.form.AuditorReportingForm;

/**
 * Servlet implementation class AuditorReportingServlet
 */
public class AuditorReportingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AuditorReportingServlet() {
     	
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	if (request.getMethod().equals("get") || request.getMethod().equals("GET")) {
    		doGet(request, response);
    	} else {
    		doPost(request, response);
    	}
    	
    
    	String statusStr = request.getParameter("status");
    	String commentStr = request.getParameter("comment");
    	
    	System.out.println("Status :" + statusStr);
    	System.out.println("Comment :" + commentStr);
    	
    	AuditorReportingForm form =  new AuditorReportingForm();
    	/*form.setStatusId(Integer.parseInt(statusStr));
    	form.setComment(commentStr);*/
    	
    	
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("***** In the doGet Method of AuditorReportingServlet ****");
		//Step 1 : write a code for fetching data from database using DAO file.
		AuditorReportingDAOImpl auditReportingDAOImpl = new AuditorReportingDAOImpl();
		String auditPlanId = request.getParameter("planid");
		AuditReportingDTO displayAdList = auditReportingDAOImpl.getAuditorReportingData(Integer.parseInt(auditPlanId));
		
		//Step 2 : write a code for set list of data in the request.
		request.setAttribute("displayAdList", displayAdList);
		
		
		//Step 3 : write a code for setting the view name (Audit Reporting Screen.jsp file)
		RequestDispatcher rd=request.getRequestDispatcher("/Audit_Reporting.jsp");
		rd.include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("***** In the doPost Method of AuditorReportingServlet ****");
		System.out.println("comment :: "+request.getParameter("comment"));
		System.out.println("status :: "+request.getParameter("status"));
		System.out.println("auditPlainId :: "+request.getParameter("auditPlainId"));
		
		AuditorReportingDAOImpl auditReportingDAOImpl = new AuditorReportingDAOImpl();
		auditReportingDAOImpl.insertAuditorReportingData(Integer.valueOf(request.getParameter("auditPlainId"))
				,Integer.valueOf(request.getParameter("status")),
				request.getParameter("comment"));
		//get parameter from request object e.g. comment and status.
		response.sendRedirect("AuditorView");
	}

}
