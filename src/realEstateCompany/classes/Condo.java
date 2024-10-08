package realEstateCompany.classes;

public class Condo extends RentalCompanyBuildings{
	int streetNumber;
	int unitNumber;
	public int getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
	public int getUnitNumber() {
		return unitNumber;
	}
	public void setUnitNumber(int unitNumber) {
		this.unitNumber = unitNumber;
	}	 
	public Condo addProperty(RentalCompanyBuildingWrapper r) {
		Condo condoBuilding = new Condo();
		condoBuilding.setStreetNumber(r.streetNumber);
		condoBuilding.setUnitNumber(r.unitNumber);
		return condoBuilding;			
	}
	@Override
	public String toString() {
		return 	streetNumber +"-"+unitNumber +"-"+streetName +"-"+ City +"-"+ province +"-" +postalCode+"-"+noOfBedrooms +"-"+noOfBathrooms +"-"+ sqFt +"-"+ rented+"-"+buildingId;
	}
}
