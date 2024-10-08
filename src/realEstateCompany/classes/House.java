package realEstateCompany.classes;

public class House extends RentalCompanyBuildings {
	public int streetNumber;

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
	public House addProperty(RentalCompanyBuildingWrapper r) {
		House housebuilding = new House();
		housebuilding.setStreetNumber(r.getStreetNumber());
		return housebuilding;
		
	}
	@Override
	public String toString() {
		return 	streetNumber +"-"+streetName +"-"+ City +"-"+ province +"-" +postalCode+"-"+noOfBedrooms +"-"+noOfBathrooms +"-"+ sqFt +"-"+ rented+"-"+buildingId;
	}
}
