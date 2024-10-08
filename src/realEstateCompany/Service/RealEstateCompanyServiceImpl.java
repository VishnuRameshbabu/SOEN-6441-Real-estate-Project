package realEstateCompany.Service;

import java.util.ArrayList;
import java.util.List;

import realEstateCompany.Dao.RealEstateCompanyDaoImpl;
import realEstateCompany.classes.ApartmentUnit;
import realEstateCompany.classes.Condo;
import realEstateCompany.classes.House;
import realEstateCompany.classes.LeaseInformation;
import realEstateCompany.classes.RentalCompanyBuildingWrapper;
import realEstateCompany.classes.RentalCompanyBuildings;
import realEstateCompany.classes.TenantInformation;

public class RealEstateCompanyServiceImpl extends RealEstateCompanyService {
	RealEstateCompanyDaoImpl daoimpl = new RealEstateCompanyDaoImpl();
	@Override
	public boolean addTenant(TenantInformation tenantInfo) {
		
		return daoimpl.addTenant(tenantInfo);
	}

	@Override
	public boolean addProperty(RentalCompanyBuildingWrapper rentalWrapper) {
		return RentalBuildingFactory(rentalWrapper);
		 
	}

	@Override
	public List<TenantInformation> getTenant() {
		return daoimpl.getTenant();
	}	
	@Override
	public TenantInformation getTenantByPhoneNumber(long PhoneNumber) {
		return daoimpl.getTenantByPhoneNumber(PhoneNumber);
	}

	@Override
	public RentalCompanyBuildings commonAttributeSetting(RentalCompanyBuildingWrapper rentalWrapper,
			RentalCompanyBuildings rentalCompanyBuilding) {
		rentalCompanyBuilding.setCity(rentalWrapper.getCity());
		rentalCompanyBuilding.setNoOfBathrooms(rentalWrapper.getNoOfBathrooms());
		rentalCompanyBuilding.setNoOfBedrooms(rentalWrapper.getNoOfBedrooms());
		rentalCompanyBuilding.setPostalCode(rentalWrapper.getPostalCode());
		rentalCompanyBuilding.setProvince(rentalWrapper.getProvince());
		rentalCompanyBuilding.setRented(rentalWrapper.isRented());
		rentalCompanyBuilding.setSqFt(rentalWrapper.getSqFt());
		rentalCompanyBuilding.setStreetName(rentalWrapper.getStreetName());
		rentalCompanyBuilding.setBuildingId(rentalWrapper.getBuildingId());
		return rentalCompanyBuilding;
	}

	@Override
	public boolean RentalBuildingFactory(RentalCompanyBuildingWrapper rentalWrapper) {
		
		RentalCompanyBuildings rentalBuilding = null;
		if (rentalWrapper.getBuildingType() == 1) {
			rentalBuilding = new ApartmentUnit();
			RentalCompanyBuildings rentalBuildingObject = rentalBuilding.addProperty(rentalWrapper);
			rentalBuildingObject = commonAttributeSetting(rentalWrapper, rentalBuildingObject);
			return daoimpl.addApartment(rentalBuildingObject);
			// System.out.println(rentalBuildingObject.toString());
		}
		if (rentalWrapper.getBuildingType() == 2) {
			rentalBuilding = new Condo();
			RentalCompanyBuildings rentalBuildingObject = rentalBuilding.addProperty(rentalWrapper);
			rentalBuildingObject = commonAttributeSetting(rentalWrapper, rentalBuildingObject);
			return daoimpl.addCondo(rentalBuildingObject);
			// System.out.println(rentalBuildingObject.toString());
		}
		if (rentalWrapper.getBuildingType() == 3) {
			rentalBuilding = new House();
			RentalCompanyBuildings rentalBuildingObject = rentalBuilding.addProperty(rentalWrapper);
			rentalBuildingObject = commonAttributeSetting(rentalWrapper, rentalBuildingObject);
			return daoimpl.addHouse(rentalBuildingObject);
		}

		return false;
	}

	@Override
	public List<ApartmentUnit> getApartments() {

		return daoimpl.getApartments();
	}

	@Override
	public List<Condo> getCondos() {

		return daoimpl.getCondos();
	}

	@Override
	public List<House> getHouses() {

		return daoimpl.getHouses();
	}

	@Override
	public ApartmentUnit checkAptAvailability(String apartmentCivicAddress, int apartmentUnitNumber) {
		return daoimpl.checkAptAvailability(apartmentCivicAddress, apartmentUnitNumber);
	}

	@Override
	public Condo checkCondoAvailability(int condoStreetNumber, int condoUnitNumber) {
		return daoimpl.checkCondoAvailability(condoStreetNumber, condoUnitNumber);

	}

	@Override
	public House checkHouseAvailability(int houseStreetNumber) {

		return daoimpl.checkHouseAvailability(houseStreetNumber);
	}
	public long getBuildingId(int buildingType) {
		
		if (buildingType == 1) {
			long defaultBuildingId = 10000L;
			List<ApartmentUnit> apts = daoimpl.getApartments();
			if(apts.isEmpty()) {
				return defaultBuildingId;
			}
			else {
				ApartmentUnit apartmentUnit = apts.get(apts.size() -1 );
				return apartmentUnit.getBuildingId();
			}
			
		}
		if (buildingType == 3) {
			long defaultBuildingId = 30000L;
			List<House> houses = daoimpl.getHouses();
			if(houses.isEmpty()) {
				return defaultBuildingId;
			}
			else {
			House house = houses.get(houses.size() -1 );
			return house.getBuildingId();
			}
		}
		if (buildingType == 2) {
			long defaultBuildingId = 20000L;
			List<Condo> condos = daoimpl.getCondos();
			if(condos.isEmpty()) {
				return defaultBuildingId;
			}
			else {
				Condo condo = condos.get(condos.size() -1 );
				return condo.getBuildingId();
			}
			
		}
return -1L;
	}
	public LeaseInformation setLeaseApartmentfields(LeaseInformation leaseInformation, long buildingId) {
		ApartmentUnit apartmentUnit = checkAptAvailability(leaseInformation.getCivicAddress(),leaseInformation.getApartmentNumber());
		leaseInformation.setApartmentNumber(apartmentUnit.getApartmentNumber());
		leaseInformation.setCivicAddress(apartmentUnit.getCivicAddress());
		leaseInformation.setStreetName(apartmentUnit.getStreetName());
		leaseInformation.setCity(apartmentUnit.getCity());
		leaseInformation.setProvince(apartmentUnit.getProvince());
		leaseInformation.setPostalCode(apartmentUnit.getPostalCode());
		leaseInformation.setNoOfBedrooms(apartmentUnit.getNoOfBedrooms());
		leaseInformation.setNoOfBathrooms(apartmentUnit.getNoOfBathrooms());
		leaseInformation.setSqFt(apartmentUnit.getSqFt());
		leaseInformation.setBuildingId(apartmentUnit.getBuildingId());
		leaseInformation.setBuildingType(1);
		leaseInformation.setActiveFlag(Boolean.TRUE);

		return leaseInformation;
		
	}
	public LeaseInformation setLeaseHousefields(LeaseInformation leaseInformation, long buildingId) {
		House houseUnit = checkHouseAvailability(leaseInformation.getStreetNumber());
		leaseInformation.setStreetNumber(houseUnit.getStreetNumber());
		leaseInformation.setStreetName(houseUnit.getStreetName());
		leaseInformation.setCity(houseUnit.getCity());
		leaseInformation.setProvince(houseUnit.getProvince());
		leaseInformation.setPostalCode(houseUnit.getPostalCode());
		leaseInformation.setNoOfBedrooms(houseUnit.getNoOfBedrooms());
		leaseInformation.setNoOfBathrooms(houseUnit.getNoOfBathrooms());
		leaseInformation.setSqFt(houseUnit.getSqFt());
		leaseInformation.setBuildingType(3);
		leaseInformation.setBuildingId(houseUnit.getBuildingId());
		leaseInformation.setActiveFlag(Boolean.TRUE);

		return leaseInformation;

	}
	public LeaseInformation setLeaseCondofields(LeaseInformation leaseInformation, long buildingId) {
		Condo condo = checkCondoAvailability(leaseInformation.getStreetNumber(),leaseInformation.getUnitNumber());
		leaseInformation.setStreetNumber(condo.getStreetNumber());
		leaseInformation.setUnitNumber(condo.getUnitNumber());
		leaseInformation.setStreetName(condo.getStreetName());
		leaseInformation.setCity(condo.getCity());
		leaseInformation.setProvince(condo.getProvince());
		leaseInformation.setPostalCode(condo.getPostalCode());
		leaseInformation.setNoOfBedrooms(condo.getNoOfBedrooms());
		leaseInformation.setNoOfBathrooms(condo.getNoOfBathrooms());
		leaseInformation.setSqFt(condo.getSqFt());
		leaseInformation.setBuildingType(2);
		leaseInformation.setBuildingId(condo.getBuildingId());
		leaseInformation.setActiveFlag(Boolean.TRUE);

		return leaseInformation;
	}
	public boolean addLease(LeaseInformation leaseInformation, int buildingType, long buildingId) {
		if (buildingType == 1) {
			leaseInformation = setLeaseApartmentfields(leaseInformation, buildingId);
		}
		if (buildingType == 3) {
			leaseInformation = setLeaseHousefields(leaseInformation, buildingId);
		}
		if (buildingType == 2) {
			leaseInformation = setLeaseCondofields(leaseInformation, buildingId);
		}
		
		if(leaseInformation.getPostalCode() != null) {
			
			return daoimpl.addLease(leaseInformation,buildingType,buildingId);	
		}
		
	
			return false;
		
	}
	@Override
	public long getLeaseId() {
		long defaultLeaseId = 90000L;
		List<LeaseInformation> leaseInfo = daoimpl.getLeases();
		if(leaseInfo.isEmpty()) {
			return defaultLeaseId;
		}
		else {
			LeaseInformation lease = leaseInfo.get(leaseInfo.size() -1 );
			return lease.getLeaseId();
		}
		}
	@Override
	public long getTenantId() {
		long defaultTenantId = 40000L;
			List<TenantInformation> tenantInfo = daoimpl.getTenant();
			if(tenantInfo.isEmpty()) {
				return defaultTenantId;
			}
			else {
				TenantInformation tenant = tenantInfo.get(tenantInfo.size() -1 );
				return tenant.getTenantId() + 1;
			}
		
	}
	@Override
	public List<ApartmentUnit> getVacantApartments() {
		List<ApartmentUnit> apartmentUnitList = daoimpl.getApartments();
		List<ApartmentUnit> apartmentUnitListFinal = new ArrayList<ApartmentUnit>();
		for(ApartmentUnit apartment : apartmentUnitList) {
			if(!apartment.isRented()) {
				apartmentUnitListFinal.add(apartment);
			}
		}
		return apartmentUnitListFinal;
	}
	@Override
	public List<ApartmentUnit> getRentedApartments() {
		List<ApartmentUnit> apartmentUnitList = daoimpl.getApartments();
		List<ApartmentUnit> apartmentUnitListFinal = new ArrayList<ApartmentUnit>();
		for(ApartmentUnit apartment : apartmentUnitList) {
			if(apartment.isRented()) {
				apartmentUnitListFinal.add(apartment);
			}
		}
		return apartmentUnitListFinal;
	}
	@Override
	public List<Condo> getRentedCondos() {
		List<Condo> condoUnitList = daoimpl.getCondos();
		List<Condo> condoUnitListFinal = new ArrayList<Condo>();
		for(Condo condo : condoUnitList) {
			if(condo.isRented()) {
				condoUnitListFinal.add(condo);
			}
		}
		return condoUnitListFinal;
	}
	@Override
	public List<Condo> getVacantCondos() {
		List<Condo> condoUnitList = daoimpl.getCondos();
		List<Condo> condoUnitListFinal = new ArrayList<Condo>();
		for(Condo condo : condoUnitList) {
			if(!condo.isRented()) {
				condoUnitListFinal.add(condo);
			}
		}
		return condoUnitListFinal;
	}
	@Override
	public List<House> getRentedHouses() {
		List<House> houseUnitList = daoimpl.getHouses();
		List<House> houseUnitListFinal = new ArrayList<House>();
		for(House house : houseUnitList) {
			if(house.isRented()) {
				houseUnitListFinal.add(house);
			}
		}
		return houseUnitListFinal;
	}
	@Override
	public List<House> getVacantHouses() {
		List<House> houseUnitList = daoimpl.getHouses();
		List<House> houseUnitListFinal = new ArrayList<House>();
		for(House house : houseUnitList) {
			if(!house.isRented()) {
				houseUnitListFinal.add(house);
			}
		}
		return houseUnitListFinal;
	}
	@Override
	public List<LeaseInformation> getLeases() {
		List<LeaseInformation> leaseInformationList = daoimpl.getLeases();
		return leaseInformationList;

	}
	@Override
	public boolean setRentStatus(Boolean rentStatus, long buildingId, int buildingType, long leaseId) {
		if(buildingType == 1) {
			return daoimpl.setApartmentRentStatus(rentStatus, buildingId,leaseId);
		}
if(buildingType == 2) {
	return daoimpl.setCondoRentStatus(rentStatus, buildingId,leaseId);
		}
if(buildingType == 3) {
	return daoimpl.setHouseRentStatus(rentStatus, buildingId,leaseId);
}
		return Boolean.FALSE;
	}
	@Override
	public List<LeaseInformation> getTenantDues() {
		List<LeaseInformation> leaseInformationList = daoimpl.getLeases();
		List<LeaseInformation> leaseInformationListFinal = new ArrayList<LeaseInformation>();
		for(LeaseInformation leaseInformation : leaseInformationList) {
			if(!leaseInformation.isRentPaid()) {
				leaseInformationListFinal.add(leaseInformation);
			}
		}
		return leaseInformationListFinal;
	}
	@Override
	public boolean payDues(long leaseId) {
		
		return daoimpl.payDues(leaseId);
	}

	public boolean cancelLease(long leaseId) {

		return daoimpl.cancelLease(leaseId);
	}

	public List<String> notifyPotentialTenants(Long leaseId) {
		
		return daoimpl.notifyPotentialTenants(leaseId);
	}
	

}
