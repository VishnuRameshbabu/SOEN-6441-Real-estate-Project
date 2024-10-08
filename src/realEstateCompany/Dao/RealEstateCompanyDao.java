package realEstateCompany.Dao;

import java.util.List;

import realEstateCompany.classes.ApartmentUnit;
import realEstateCompany.classes.Condo;
import realEstateCompany.classes.House;
import realEstateCompany.classes.LeaseInformation;
import realEstateCompany.classes.RentalCompanyBuildings;
import realEstateCompany.classes.TenantInformation;

public abstract class RealEstateCompanyDao {
	public abstract boolean addTenant(TenantInformation tenantInfo);
	public abstract TenantInformation getTenantByPhoneNumber(long PhoneNumber);
	public abstract List<TenantInformation> getTenant();
	public abstract boolean addApartment(RentalCompanyBuildings rentalBuilding);
	public abstract boolean addCondo(RentalCompanyBuildings rentalBuilding);
	public abstract boolean addHouse(RentalCompanyBuildings rentalBuilding);
	public abstract List<House> getHouses();
	public abstract List<Condo> getCondos();
	public abstract List<ApartmentUnit> getApartments();
	public abstract ApartmentUnit checkAptAvailability(String apartmentCivicAddress, int apartmentUnitNumber);
	public abstract Condo checkCondoAvailability(int condoStreetNumber, int condoUnitNumber); 
	public abstract House checkHouseAvailability(int houseStreetNumber);
	public abstract boolean checkTenant(long phoneNumber);
	public abstract boolean addLease(LeaseInformation leaseInformation, int buildingType, long buildingId);
	public abstract List<LeaseInformation> getLeases();
	public abstract boolean setApartmentRentStatus(boolean RentStatus, long buildingId,long leaseId);
	public abstract boolean setHouseRentStatus(boolean RentStatus, long buildingId,long leaseId);
	public abstract boolean setCondoRentStatus(boolean RentStatus, long buildingId,long leaseId);
	public abstract boolean setLeaseIdAgainstTenant(LeaseInformation leaseInformation);
	public abstract boolean payDues(long leaseId);
	public abstract LeaseInformation getSingleLease(long leaseId);
}
