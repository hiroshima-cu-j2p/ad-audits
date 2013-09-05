package jp.co.hiroshimaj2p.audit.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import sun.misc.BASE64Decoder;

public class DBConnectionManager {

	private static String server = null;
	private static String port = null;
	private static String scheme = null;
	private static String username = null;
	private static String password = null;
	private static String url = null;
	static {
		try {
			// loading the driver class
			Class.forName("org.postgresql.Driver");

			ResourceBundle bundle = ResourceBundle.getBundle("dbconnection");
			server = bundle.getString("server");
			port = bundle.getString("port");
			scheme = bundle.getString("scheme");
			username = bundle.getString("username");
			password = bundle.getString("password");
			BASE64Decoder decorder = new BASE64Decoder();
			password = new String(decorder.decodeBuffer(password));
			url = "jdbc:postgresql://" + server + ":" + port + "/" + scheme;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

/*
 * This method is written to test the connection to database.
 */
	 
	public static void main(String[] args) throws Exception {
		// BASE64Encoder enc = new BASE64Encoder();
		// System.out.println(enc.encode("postgres".getBytes()));

		Connection con = DBConnectionManager.getConnection();
		
		//conn=DBConnectionManager.getConnection();
		String sqlQuery = "select location_name,corporate_name,agency_name,ad_product_name,ad_description from ad ad,location loc, corporate corp,ad_agency agency"+
			" where ad.ad_location = loc.location_id and ad.ad_corporate_id = corp.corporate_id and ad.ad_agency_id = agency.agency_id";
		PreparedStatement stmt = con.prepareStatement(sqlQuery);
		ResultSet rs = stmt.executeQuery();
		
		//Statement stmt = con.createStatement();
		//ResultSet rs = stmt.executeQuery("select verified_status_id, verified_status_name from verified_status");
		
		while(rs.next()) {
			System.out.println("location_name: " + rs.getString("location_name"));
			System.out.println("corporate_name: " + rs.getString("corporate_name"));
			System.out.println("agency_name: " + rs.getString("agency_name"));
			System.out.println("ad_product_name: " + rs.getString("ad_product_name"));
			System.out.println("ad_description: " + rs.getString("ad_description"));
			System.out.println("--------");
		}
		//con.commit();
		con.close();
		
		
	}

	public static Connection getConnection() {
		// getting the connection
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, username, password);
			// setting for explicit commit call.
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

}
