package realEstateCompany.classes;

public class ApartmentUnit extends Apartment {
	 int apartmentNumber;

	public int getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	public RentalCompanyBuildings addProperty(RentalCompanyBuildingWrapper r) {
		ApartmentUnit apartment = new ApartmentUnit();
		apartment.apartmentNumber=r.apartmentNumber;
		apartment.civicAddress = r.civicAddress;
		apartment.buildingId = r.buildingId;
		return apartment;
		
	}

	@Override
	public String toString() {
		return 	apartmentNumber +"-"+civicAddress +"-"+streetName +"-"+ City +"-"+ province +"-" +postalCode+"-"+noOfBedrooms +"-"+noOfBathrooms +"-"+ sqFt +"-"+ rented+"-"+buildingId;   
	}
	
	
}
