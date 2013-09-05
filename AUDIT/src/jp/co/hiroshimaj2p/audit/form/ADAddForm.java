package jp.co.hiroshimaj2p.audit.form;

import java.util.List;

import jp.co.hiroshimaj2p.audit.dto.AgencyDTO;
import jp.co.hiroshimaj2p.audit.dto.CorporateDTO;
import jp.co.hiroshimaj2p.audit.dto.LocationDTO;

public class ADAddForm {
	private Integer corporateID=null;
	private Integer agencyID=null;
	private String productName=null;
	private String productDescription=null;
	private Integer locationID;
	
	private List<CorporateDTO> listOfCorporates = null;
	private List<AgencyDTO> listOfAgencies = null;
	private List<LocationDTO> listOfLocations = null;
	
	public List<CorporateDTO> getListOfCorporates() {
		return listOfCorporates;
	}

	public void setListOfCorporates(List<CorporateDTO> listOfCorporates) {
		this.listOfCorporates = listOfCorporates;
	}

	public List<AgencyDTO> getListOfAgencies() {
		return listOfAgencies;
	}

	public void setListOfAgencies(List<AgencyDTO> listOfAgencies) {
		this.listOfAgencies = listOfAgencies;
	}

	public List<LocationDTO> getListOfLocations() {
		return listOfLocations;
	}

	public void setListOfLocations(List<LocationDTO> listOfLocations) {
		this.listOfLocations = listOfLocations;
	}

	public Integer getCorporateID() {
		return corporateID;
	}
	
	public void setCorporateID(Integer corporateID) {
		this.corporateID = corporateID;
	}
	public Integer getAgencyID() {
		return agencyID;
	}
	public void setAgencyID(Integer agencyID) {
		this.agencyID = agencyID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Integer getLocationID() {
		return locationID;
	}
	public void setLocationID(Integer locationID) {
		this.locationID = locationID;
	}
	
	
	
	
	  
	
	
}
