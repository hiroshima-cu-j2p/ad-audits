package jp.co.hiroshimaj2p.audit.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import jp.co.hiroshimaj2p.audit.dao.LoginDAO;
import jp.co.hiroshimaj2p.audit.dto.LoginDTO;
import jp.co.hiroshimaj2p.audit.utility.DBConnectionManager;

public class LoginServlet extends HttpServlet{
		private static final long serialVersionUID = 1L;

		public LoginServlet() {
			// TODO Auto-generated constructor stub
		}

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			String loginIdStr = request.getParameter("login_id");
			String loginPassStr = request.getParameter("login_password");
			String loginType = request.getParameter("loginType");
			

			LoginDTO loginDTO= new LoginDTO();
			loginDTO.setLoginId(loginIdStr);
			loginDTO.setLoginPassword(loginPassStr);
			loginDTO.setLoginType(loginType)	;		
			
			LoginDAO dao = new LoginDAO();
			loginDTO = dao.checkLogin(loginDTO);
			
			if(null != loginDTO) {
				if(loginDTO.isManager()) {
					response.sendRedirect("ManagerServlet");
				} else if ("U".equals(loginDTO.getLoginType())){
					response.sendRedirect("AuditorView");
				} else {
					response.sendRedirect("CorporateAgencyServlet");
				}
			} else {
				response.sendRedirect("login.html");
			}

		}		
		
		
}
