package realEstateCompany.classes;

public class Apartment extends RentalCompanyBuildings {
	protected String civicAddress;

	@Override
	public RentalCompanyBuildings addProperty(RentalCompanyBuildingWrapper r) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCivicAddress() {
		return civicAddress;
	}

	public void setCivicAddress(String civicAddress) {
		this.civicAddress = civicAddress;
	}
	
}
