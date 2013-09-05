package jp.co.hiroshimaj2p.audit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.hiroshimaj2p.audit.dao.ManagerDAO;
import jp.co.hiroshimaj2p.audit.dto.ManagerDTO;
import jp.co.hiroshimaj2p.audit.form.ManagerForm;

/**
 * Servlet implementation class ManagerServlet
 */
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("***** In the doGet Method of ManagerAgencyServlet********");
		//get Data from the dao layer.
		ManagerDAO dao = new ManagerDAO();
		List<ManagerDTO> dtoList = dao.getManagerData(1);
		//List<ManagerDTO> dtoList = dao.getManagerData(3);
		
		//Pass data to the screen.
		request.setAttribute("adlist", dtoList);
		//System.out.println("dtoList :: "+dtoList);
		RequestDispatcher rs = request.getRequestDispatcher("/newmanager.jsp");
		rs.forward(request, response);
		
//		String productName=request.getParameter("product_name");
//		Integer location=Integer.parseInt(request.getParameter("location"));
//		Integer corporate=Integer.parseInt(request.getParameter("corporate"));
//		Integer agency=Integer.parseInt(request.getParameter("agency"));
//		Integer status=Integer.parseInt(request.getParameter("status"));
//				
//		CorporateAgencyForm form=new CorporateAgencyForm();
//		form.setProductName(productName);
//		form.setLocationID(location);
//		form.setCorprateID(corporate);
//		form.setAgencyID(agency);
//		form.setStatusID(status);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
