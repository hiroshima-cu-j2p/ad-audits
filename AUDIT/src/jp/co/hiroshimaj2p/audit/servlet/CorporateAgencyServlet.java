package jp.co.hiroshimaj2p.audit.servlet;

import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.hiroshimaj2p.audit.form.CorporateAgencyForm;
import jp.co.hiroshimaj2p.audit.dao.CorporateAgencyDAO;
import jp.co.hiroshimaj2p.audit.dto.CorporateAgencyDTO;

/**
 * Servlet implementation class CorporateAgencyFormServlet
 */
public class CorporateAgencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CorporateAgencyServlet() {
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
		System.out.println("***** In the doGet Method of CorporateAgencyServlet********");
		
		//get Data from the dao layer.
		CorporateAgencyDAO dao = new CorporateAgencyDAO();
		List<CorporateAgencyDTO> dtoList = dao.getCorporateAgencyData();
		
		//Pass data to the screen.
		request.setAttribute("adlist", dtoList);
		//System.out.println("dtoList :: "+dtoList);
		RequestDispatcher rs = request.getRequestDispatcher("/newa_c.jsp");
		rs.forward(request, response);
		
		/*String productName=request.getParameter("product_name");
		Integer location=Integer.parseInt(request.getParameter("location"));
		Integer corporate=Integer.parseInt(request.getParameter("corporate"));
		Integer agency=Integer.parseInt(request.getParameter("agency"));
		Integer status=Integer.parseInt(request.getParameter("status"));
				
		CorporateAgencyForm form=new CorporateAgencyForm();
		form.setProductName(productName);
		form.setLocationID(location);
		form.setCorprateID(corporate);
		form.setAgencyID(agency);
		form.setStatusID(status);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
