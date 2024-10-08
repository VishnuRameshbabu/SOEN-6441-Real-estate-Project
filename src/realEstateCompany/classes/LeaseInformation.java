package realEstateCompany.classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeaseInformation {
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	TenantInformation tenantInfo;
	long LeaseId;
	LocalDate leaseStartDate;
	LocalDate leaseEndDate;
	int noOfBedrooms;
	int noOfBathrooms;
	double sqFt;
	int buildingType;
	int unitNumber;
	int streetNumber;
	String	civicAddress;
	int apartmentNumber;
	double rentAmount;
	long buildingId;
	String streetName;
	String City;
	String province;
	String postalCode;
	public boolean activeFlag;
	boolean rentPaid;
	public TenantInformation getTenantInfo() {
		return tenantInfo;
	}
	public void setTenantInfo(TenantInformation tenantInfo) {
		this.tenantInfo = tenantInfo;
	}
	public long getLeaseId() {
		return LeaseId;
	}
	public void setLeaseId(long leaseId) {
		LeaseId = leaseId;
	}
	public LocalDate getLeaseStartDate() {
		return leaseStartDate;
	}
	public void setLeaseStartDate(LocalDate leaseStartDate2) {
		this.leaseStartDate = leaseStartDate2;
	}
	public LocalDate getLeaseEndDate() {
		return leaseEndDate;
	}
	public void setLeaseEndDate(LocalDate leaseEndDate) {
		this.leaseEndDate = leaseEndDate;
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
	public int getBuildingType() {
		return buildingType;
	}
	public void setBuildingType(int buildingType) {
		this.buildingType = buildingType;
	}
	public int getUnitNumber() {
		return unitNumber;
	}
	public void setUnitNumber(int unitNumber) {
		this.unitNumber = unitNumber;
	}
	public int getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getCivicAddress() {
		return civicAddress;
	}
	public void setCivicAddress(String civicAddress) {
		this.civicAddress = civicAddress;
	}
	public double getRentAmount() {
		return rentAmount;
	}
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	public int getApartmentNumber() {
		return apartmentNumber;
	}
	public void setApartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	
	public long getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(long buildingId) {
		this.buildingId = buildingId;
	}
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
	public boolean isActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	
	public boolean isRentPaid() {
		return rentPaid;
	}
	public void setRentPaid(boolean rentPaid) {
		this.rentPaid = rentPaid;
	}
	@Override
	public String toString() {
		return 	LeaseId +"-"+ leaseStartDate.format(formatter) +"-"+ leaseEndDate.format(formatter) +"-"+ rentAmount +"-"+tenantInfo.getTenantId() +"-"+ tenantInfo.getName() +"-"+ tenantInfo.getAge() +"-"+ tenantInfo.getPhoneNumber()+"-"+ tenantInfo.getEmailId() +"-"+buildingType +"-"+ buildingId +"-"+ unitNumber +"-"+streetNumber+"-"+apartmentNumber +"-"+civicAddress +"-"+streetName +"-"+ City +"-"+ province +
				"-" +postalCode+"-"+noOfBedrooms +"-"+noOfBathrooms +"-"+ sqFt +"-"+ activeFlag+"-"+rentPaid;
	}

}
