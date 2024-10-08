package realEstateCompany.Service;

import java.util.List;

import realEstateCompany.classes.ApartmentUnit;
import realEstateCompany.classes.Condo;
import realEstateCompany.classes.House;
import realEstateCompany.classes.LeaseInformation;
import realEstateCompany.classes.RentalCompanyBuildingWrapper;
import realEstateCompany.classes.RentalCompanyBuildings;
import realEstateCompany.classes.TenantInformation;

public abstract class  RealEstateCompanyService {
		public abstract boolean addTenant(TenantInformation tenantInfo);
		public abstract boolean addProperty(RentalCompanyBuildingWrapper rentalWrapper);
		public abstract List<TenantInformation> getTenant();
		public abstract TenantInformation getTenantByPhoneNumber(long PhoneNumber);
		public abstract boolean RentalBuildingFactory(RentalCompanyBuildingWrapper rentalWrapper);
		public abstract RentalCompanyBuildings commonAttributeSetting(RentalCompanyBuildingWrapper rentalWrapper,RentalCompanyBuildings rentalCompanyBuilding);
		public abstract List<ApartmentUnit> getApartments();
		public abstract List<Condo> getCondos();
		public abstract List<House> getHouses();
		public abstract ApartmentUnit checkAptAvailability(String apartmentCivicAddress, int apartmentUnitNumber);
		public abstract Condo checkCondoAvailability(int condoStreetNumber, int condoUnitNumber); 
		public abstract House checkHouseAvailability(int houseStreetNumber);
		public abstract boolean addLease(LeaseInformation leaseInformation, int buildingType, long buildingId);
		public abstract long getLeaseId();
		public abstract long getTenantId();
		public abstract List<ApartmentUnit> getVacantApartments();
		public abstract List<ApartmentUnit> getRentedApartments();
		public abstract List<Condo> getRentedCondos();
		public abstract List<House> getVacantHouses();
		public abstract List<House> getRentedHouses();
		public abstract List<Condo> getVacantCondos();
		public abstract List<LeaseInformation> getLeases();
		public abstract boolean setRentStatus(Boolean rentStatus, long buildingId, int buildingType, long leaseId);
		public abstract List<LeaseInformation> getTenantDues();
		public  abstract boolean payDues(long leaseId); 
}