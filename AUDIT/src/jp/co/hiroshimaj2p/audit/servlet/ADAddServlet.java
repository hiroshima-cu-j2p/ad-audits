package jp.co.hiroshimaj2p.audit.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.hiroshimaj2p.audit.dao.ADAddFormDAOImpl;
import jp.co.hiroshimaj2p.audit.dao.AgencyDAO;
import jp.co.hiroshimaj2p.audit.dao.CorporateDAO;
import jp.co.hiroshimaj2p.audit.dao.LocationDAO;
import jp.co.hiroshimaj2p.audit.dto.ADAddFormDTO;
import jp.co.hiroshimaj2p.audit.dto.AgencyDTO;
import jp.co.hiroshimaj2p.audit.dto.CorporateDTO;
import jp.co.hiroshimaj2p.audit.dto.LocationDTO;
import jp.co.hiroshimaj2p.audit.form.ADAddForm;
import jp.co.hiroshimaj2p.audit.form.AssignAuditerForm;
import jp.co.hiroshimaj2p.audit.utility.DBConnectionManager;

/**
 * Servlet implementation class ADAddF
 */
public class ADAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ADAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CorporateDAO corpDAO = new CorporateDAO();
		List<CorporateDTO> lstOfCorporates = corpDAO.getAllCorporateData();
		ADAddForm form = new ADAddForm();
		form.setListOfCorporates(lstOfCorporates);
		
		AgencyDAO agencyDAO = new AgencyDAO();
		List<AgencyDTO> lstOfAgencies = agencyDAO.getAllAgencyData();
		form.setListOfAgencies(lstOfAgencies);

		LocationDAO locDAO = new LocationDAO();
		List<LocationDTO> lstOfLocations = locDAO.getAllLocationData();
		form.setListOfLocations(lstOfLocations);

		
		request.setAttribute("ADADDFORM", form);
		request.getRequestDispatcher("ad_add.jsp").forward(request, response);
		

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String corporateIDStr = request.getParameter("corporate");
		String agencyIDStr = request.getParameter("agency");
		String productName = request.getParameter("product_name");
		String productDescription = request.getParameter("product_description");
		String locationIDStr = request.getParameter("location");

		Integer corporateId = Integer.parseInt(corporateIDStr);
		Integer agencyId = Integer.parseInt(agencyIDStr);
		Integer locationId = Integer.parseInt(locationIDStr);
		
		ADAddFormDTO adAddDTO= new ADAddFormDTO();
		adAddDTO.setCorporateId(corporateId);
		adAddDTO.setAgencyId(agencyId);
		adAddDTO.setProductName(productName);
		adAddDTO.setDescription(productDescription);
		adAddDTO.setLocationId(locationId);
		
		ADAddFormDAOImpl daoImpl = new ADAddFormDAOImpl();
		daoImpl.insertAd(adAddDTO);
		response.sendRedirect("CorporateAgencyServlet");
	

	}
		
		
		//System.out.println("corporate ID: " + corporateIDStr);
		//System.out.println("Agency ID: " + agencyIDStr);
		//System.out.println("product_name: " + productName);
		//System.out.println("product_description: " + productDescription);
		//System.out.println("Agency: " + locationIDStr);
				
		//Integer corporateID = Integer.parseInt(corporateIDStr);
		//Integer agencyID = Integer.parseInt(agencyIDStr);
		//Integer locationID = Integer.parseInt(locationIDStr);			

		//ADAddForm addForm = new ADAddForm();
		//addForm.setCorporateID(corporateID);
		//addForm.setAgencyID(agencyID);
		//addForm.setLocationID(locationID);
		//addForm.setProductName(productName);
		//addForm.setProductDescription(productDescription);
	

}
