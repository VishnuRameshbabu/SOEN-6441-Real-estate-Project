package realEstateCompany.classes;

public abstract class RentalCompanyBuildings {
	public String streetName;
	public String City;
	public String province;
	public String postalCode;
	int noOfBedrooms;
	int noOfBathrooms;
	double sqFt;
	boolean rented;
	long buildingId;
	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public int getNoOfBedrooms() {
		return noOfBedrooms;
	}

	public void setNoOfBedrooms(int noOfBedrooms) {
		this.noOfBedrooms = noOfBedrooms;
	}

	public int getNoOfBathrooms() {
		return noOfBathrooms;
	}

	public void setNoOfBathrooms(int noOfBathrooms) {
		this.noOfBathrooms = noOfBathrooms;
	}

	public double getSqFt() {
		return sqFt;
	}

	public void setSqFt(double sqFt) {
		this.sqFt = sqFt;
	}
	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}
	
	public long getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(long buildingId) {
		this.buildingId = buildingId;
	}

	public abstract RentalCompanyBuildings addProperty(RentalCompanyBuildingWrapper r);

}
