package realEstateCompany.controller;

import java.util.List;

import realEstateCompany.Service.RealEstateCompanyServiceImpl;
import realEstateCompany.classes.ApartmentUnit;
import realEstateCompany.classes.Condo;
import realEstateCompany.classes.House;
import realEstateCompany.classes.LeaseInformation;
import realEstateCompany.classes.RentalCompanyBuildingWrapper;
import realEstateCompany.classes.TenantInformation;
public class Controller {
static RealEstateCompanyServiceImpl service = new RealEstateCompanyServiceImpl();

public boolean addTenant(TenantInformation tenantInfo) {
	return service.addTenant(tenantInfo);
}
public boolean addProperty(RentalCompanyBuildingWrapper rentalWrapper) {
	
	return service.addProperty(rentalWrapper);
}
public List<TenantInformation> displayTenants() {
	
	return service.getTenant();
}
public List<ApartmentUnit> displayVacantApartments() {
	
	return service.getVacantApartments();
}
public List<ApartmentUnit> displayRentedApartments() {
	
	return service.getRentedApartments();
}
public List<ApartmentUnit> displayApartments() {
	
	return service.getApartments();
}
public List<House> displayHouses() {
	
	return service.getHouses();
}
public List<Condo> displayCondos() {
	
	return service.getCondos();
}
public TenantInformation getTenantByPhoneNumber(long phoneNumber) {
	
	return service.getTenantByPhoneNumber(phoneNumber);
}
public ApartmentUnit checkAptAvailability(String aptCivicAddress, int aptNumber) {
	
	return service.checkAptAvailability(aptCivicAddress, aptNumber);
}
public Condo checkCondoAvailability(int condoStreetNumber, int condoUnitNumber) {
	// TODO Auto-generated method stub
	return service.checkCondoAvailability(condoStreetNumber, condoUnitNumber);
}
public House checkHouseAvailability(int houseStreetNumber) {
	// TODO Auto-generated method stub
	return service.checkHouseAvailability(houseStreetNumber);
}
public long getBuildingId(int buildingType) {
	// TODO Auto-generated method stub
	return service.getBuildingId(buildingType);
}
public boolean addLease(LeaseInformation leaseInformation, int buildingType, long buildingId) {
	return service.addLease(leaseInformation,buildingType,buildingId);
}
public long getTenantId() {
	return service.getTenantId();
}
public long getLeaseId() {
	return service.getLeaseId();
}
public List<LeaseInformation> displayLeases() {
	return service.getLeases();
}
public List<Condo> displayRentedCondos() {
	// TODO Auto-generated method stub
	return service.getRentedCondos();
}
public List<House> displayRentedHouses() {
	// TODO Auto-generated method stub
	return service.getRentedHouses();
}
public List<Condo> displayVacantCondos() {
	// TODO Auto-generated method stub
	return service.getVacantCondos();
}
public List<House> displayVacantHouses() {
	// TODO Auto-generated method stub
	return  service.getVacantHouses();
}
public boolean setRentStatus(Boolean rentStatus, long buildingId, int buildingType, long leaseId) {
	return service.setRentStatus(rentStatus, buildingId, buildingType, leaseId);
}
public boolean payDues(long leaseId) {
	 return service.payDues(leaseId);
	
}
public List<LeaseInformation> getTenantDues() {
	// TODO Auto-generated method stub
	return service.getTenantDues();
}
public boolean cancelLease(long leaseId) {
	
	return service.cancelLease(leaseId);
	
}
public List<String> notifyPotentialTenants(Long leaseId) {
	return service.notifyPotentialTenants(leaseId);
}

}
