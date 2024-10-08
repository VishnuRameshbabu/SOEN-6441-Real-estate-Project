package realEstateCompany;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import realEstateCompany.classes.ApartmentUnit;
import realEstateCompany.classes.Condo;
import realEstateCompany.classes.House;
import realEstateCompany.classes.LeaseInformation;
import realEstateCompany.classes.RentalCompanyBuildingWrapper;
import realEstateCompany.classes.TenantInformation;
import realEstateCompany.controller.Controller;

public class DriverProgram {
	public static final Scanner sc = new Scanner(System.in);
	static Controller rentController = new Controller();
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public void displayTenants() {
		List<TenantInformation> tenantInfoList = rentController.displayTenants();
		for (TenantInformation tenantInfo : tenantInfoList) {
			System.out.println("TENANT INFORMATION");
			System.out.println(" NAME : " + tenantInfo.getName());
			System.out.println(" AGE : " + tenantInfo.getAge());
			System.out.println(" EMAILID : " + tenantInfo.getEmailId());
			System.out.println(" PHONENUMBER : " + tenantInfo.getPhoneNumber());
			System.out.println("\n");
		}
	}

	public void rentAUnit() {
		DriverProgram driver = new DriverProgram();
		int option;
		String leaseStart, leaseEnd;
		long phoneNumber;
		boolean isPresent = false;
		float rentAmount;
		long buildingId = 0;
		int buildingType = 0;
		boolean isRented = false;
		ApartmentUnit apartmentUnit = new ApartmentUnit();
		Condo condoUnit = new Condo();
		House houseUnit = new House();
		LeaseInformation leaseInformation = new LeaseInformation();
		System.out.println("Enter the option of property type which you want to rent?");
		System.out.println("1.APARTMENT\n2.CONDO\n3.HOUSE");
		option = sc.nextInt();
		sc.nextLine();

		switch (option) {
		case 1: {
			System.out.println("Enter the apartment civic address");
			String aptCivicAddress = sc.nextLine();
			System.out.println("Enter the apartment number");
			int aptNumber = sc.nextInt();
			apartmentUnit = rentController.checkAptAvailability(aptCivicAddress, aptNumber);
			if (apartmentUnit.isRented() == false) {
				isPresent = true;
				buildingType = 1;
				buildingId = apartmentUnit.getBuildingId();
				leaseInformation.setCivicAddress(apartmentUnit.getCivicAddress());
				leaseInformation.setApartmentNumber(apartmentUnit.getApartmentNumber());
			} else {
				isRented = true;
				System.out.println("Requested apartment is currently unavailable");
			}
			break;
		}
		case 2: {
			System.out.println("Enter the condo's street number");
			int condoStreetNumber = sc.nextInt();
			System.out.println("Enter the condo's unit number");
			int condoUnitNumber = sc.nextInt();
			condoUnit = rentController.checkCondoAvailability(condoStreetNumber, condoUnitNumber);
			if (condoUnit.isRented() == false) {
				isPresent = true;
				buildingType = 2;
				leaseInformation.setStreetNumber(condoUnit.getStreetNumber());
				leaseInformation.setUnitNumber(condoUnit.getUnitNumber());
				buildingId = condoUnit.getBuildingId();
			}
			break;
		}
		case 3: {
			System.out.println("Enter the house's street number");
			int houseStreetNumber = sc.nextInt();
			houseUnit = rentController.checkHouseAvailability(houseStreetNumber);
			if (houseUnit.isRented() == false) {
				isPresent = true;
				buildingType = 3;
				leaseInformation.setStreetNumber(houseUnit.getStreetNumber());
				buildingId = houseUnit.getBuildingId();
			}
			break;
		}
		}
		if (isPresent == true && isRented == false) {
			System.out.println("Enter the tenant phone number whom you want to rent");
			phoneNumber = sc.nextLong();
			TenantInformation tenantInfo = null;
			tenantInfo = rentController.getTenantByPhoneNumber(phoneNumber);
			if (tenantInfo != null) {
				System.out.println("Enter date in dd/MM/yyyy format: ");
				System.out.println("Lease Start Date: ");
				sc.nextLine();
				leaseStart = sc.nextLine();
				LocalDate LeaseStartDate = LocalDate.parse(leaseStart, formatter);
				System.out.println("Enter the lease end date");
				leaseEnd = sc.nextLine();
				LocalDate LeaseEndDate = LocalDate.parse(leaseEnd, formatter);
				Long leaseId = rentController.getLeaseId();
				tenantInfo.setPreferredBuildingId(0);
				tenantInfo.setLeaseId(leaseId);
				leaseInformation.setTenantInfo(tenantInfo);
				System.out.println("Enter the rent amount");
				rentAmount = sc.nextFloat();
				leaseInformation.setLeaseId(leaseId);
				leaseInformation.setLeaseStartDate(LeaseStartDate);
				leaseInformation.setLeaseEndDate(LeaseEndDate);
				leaseInformation.setRentAmount(rentAmount);
				rentController.addLease(leaseInformation, buildingType, buildingId);
				rentController.setRentStatus(Boolean.TRUE, buildingId, buildingType, leaseInformation.getLeaseId());
			} else {
				System.out.println("Entered tenant does not exists");
				System.out.println("Please add the tenant before renting");
				System.out.println("Redirecting to add tenant");
				driver.addTenant();
			}
			System.out.println();
		} else if (isRented == false && isPresent == false) {
			System.out.println("The entered property does not exists.\nPlease add the property first!"
					+ "\nRedirecting to add a property functionality");
			driver.addProperty();

		}
	}

	private void displayProperties() {
		List<ApartmentUnit> apartmentUnitList = rentController.displayApartments();
		for (ApartmentUnit apartmentUnit : apartmentUnitList) {
			System.out.println("");
			System.out.println("APARTMENTS");
			System.out.println("===========");
			System.out.println("APARTMENT NUMBER : " + apartmentUnit.getApartmentNumber());
			System.out.println("BUILDING ID : " + apartmentUnit.getBuildingId());
			System.out.println("CIVIC ADDRESS : " + apartmentUnit.getCivicAddress());
			System.out.println("CITY : " + apartmentUnit.getCity());
			System.out.println("BATHROOMS AVAILABLE : " + apartmentUnit.getNoOfBathrooms());
			System.out.println("BEDROOMS AVAILABLE : " + apartmentUnit.getNoOfBedrooms());
			System.out.println("POSTAL CODE : " + apartmentUnit.getPostalCode());
			System.out.println("PROVINCE : " + apartmentUnit.getProvince());
			System.out.println("SQUARE FEET : " + apartmentUnit.getSqFt());

		}
		List<Condo> CondoList = rentController.displayCondos();
		for (Condo CondoUnit : CondoList) {
			System.out.println("");
			System.out.println("CONDO");
			System.out.println("===========");
			System.out.println("BUILDING ID : " + CondoUnit.getBuildingId());
			System.out.println("STREET NUMBER : " + CondoUnit.getStreetNumber());
			System.out.println("UNIT NUMBER : " + CondoUnit.getStreetNumber());
			System.out.println("CITY : " + CondoUnit.getCity());
			System.out.println("BATHROOMS AVAILABLE : " + CondoUnit.getNoOfBathrooms());
			System.out.println("BEDROOMS AVAILABLE : " + CondoUnit.getNoOfBedrooms());
			System.out.println("POSTAL CODE : " + CondoUnit.getPostalCode());
			System.out.println("PROVINCE : " + CondoUnit.getProvince());
			System.out.println("SQUARE FEET : " + CondoUnit.getSqFt());
		}
		List<House> HouseList = rentController.displayHouses();
		for (House HouseUnit : HouseList) {
			System.out.println("");
			System.out.println("HOUSE");
			System.out.println("===========");
			System.out.println("BUILDING ID : " + HouseUnit.getBuildingId());
			System.out.println("STREET NUMBER : " + HouseUnit.getStreetNumber());
			System.out.println("CITY : " + HouseUnit.getCity());
			System.out.println("BATHROOMS AVAILABLE : " + HouseUnit.getNoOfBathrooms());
			System.out.println("BEDROOMS AVAILABLE : " + HouseUnit.getNoOfBedrooms());
			System.out.println("POSTAL CODE : " + HouseUnit.getPostalCode());
			System.out.println("PROVINCE : " + HouseUnit.getProvince());
			System.out.println("SQUARE FEET : " + HouseUnit.getSqFt());
		}

	}

	private void addTenant() {
		boolean flag = true;
		while (flag) {
			try {
				System.out.println("PLEASE ENTER THE FOLLOWING DETAILS\n");
				sc.nextLine();
				String Name;
				int Age;
				long phoneNumber;
				String emailId;
				long preferredBuildingId;
				TenantInformation tenantInfo = new TenantInformation();
				System.out.println("NAME : ");
				Name = sc.nextLine();
				System.out.println("AGE ");
				Age = sc.nextInt();
				sc.nextLine();
				System.out.println("PHONENUMBER ");
				phoneNumber = sc.nextLong();
				sc.nextLine();
				System.out.println("EMAIL ID ");
				emailId = sc.nextLine();
				System.out.println("PREFERRED  BUILDING");
				preferredBuildingId = sc.nextLong();
				tenantInfo.setName(Name);
				tenantInfo.setAge(Age);
				tenantInfo.setPhoneNumber(phoneNumber);
				tenantInfo.setEmailId(emailId);
				long tenantId = rentController.getTenantId();
				tenantInfo.setTenantId(tenantId);
				tenantInfo.setPreferredBuildingId(preferredBuildingId);
				tenantInfo.setLeaseId(0); // default id
				if (rentController.addTenant(tenantInfo)) {
					System.out.println("Information entered successfully");
				}
				flag = false;
			} catch (Exception e) {
				System.out.println("Exception" + e.getMessage());
			}
		}
	}

	public void addProperty() {
		boolean flag = true;
		while (flag) {
			try {
				RentalCompanyBuildingWrapper rentalWrapper = new RentalCompanyBuildingWrapper();
				String streetName;
				String city;
				String province;
				String postalCode;
				int noOfBedrooms;
				int noOfBathrooms;
				double sqFt;
				int streetNumber = 0;
				int unitNumber = 0;
				int apartmentNumber = 0;
				String civicAddress = null;
				int buildingType = 0;
				long buildingId = 0;
				System.out
						.println("PLEASE ENTER THE NUMBER TYPE  OF BUILDING TO ADD\n 1.APARTMENT\n 2.CONDO\n 3.HOUSE");
				int option = sc.nextInt();
				if (option == 1) {
					buildingType = 1;
					sc.nextLine();
					System.out.println("CIVICADDRESS : ");
					civicAddress = sc.nextLine();
					rentalWrapper.setCivicAddress(civicAddress);
					System.out.println("APARTMENTNUMBER");
					apartmentNumber = sc.nextInt();
					rentalWrapper.setApartmentNumber(apartmentNumber);
					buildingId = rentController.getBuildingId(buildingType) + 1;
					rentalWrapper.setBuildingId(buildingId);
				} else if (option == 2) {
					buildingType = 2;
					System.out.println("STREETNUMBER : ");
					streetNumber = sc.nextInt();
					rentalWrapper.setStreetNumber(streetNumber);
					System.out.println("UNITNUMBER");
					unitNumber = sc.nextInt();
					buildingId = rentController.getBuildingId(buildingType) + 1;
					rentalWrapper.setBuildingId(buildingId);
					rentalWrapper.setUnitNumber(unitNumber);
				} else if (option == 3) {
					buildingType = 3;
					System.out.println("STREETNUMBER : ");
					streetNumber = sc.nextInt();
					buildingId = rentController.getBuildingId(buildingType) + 1;
					rentalWrapper.setBuildingId(buildingId);
					rentalWrapper.setStreetNumber(streetNumber);
				}
				System.out.println("PLEASE ENTER THE OTHER FOLLOWING DETAILS\n");
				sc.nextLine();
				System.out.println("STREETNAME : ");
				streetName = sc.nextLine();
				System.out.println("CITY : ");
				city = sc.nextLine();
				System.out.println("PROVINCE : ");
				province = sc.nextLine();
				System.out.println("POSTALCODE : ");
				postalCode = sc.nextLine();
				System.out.println("NOOFBEDROOMS : ");
				noOfBedrooms = sc.nextInt();
				System.out.println("SQFT : ");
				sqFt = sc.nextDouble();
				System.out.println("NOOFBATHROOMS : ");
				noOfBathrooms = sc.nextInt();
				rentalWrapper.setUnitNumber(unitNumber);
				rentalWrapper.setBuildingId(buildingId);
				rentalWrapper.setCity(city);
				rentalWrapper.setNoOfBathrooms(noOfBathrooms);
				rentalWrapper.setNoOfBedrooms(noOfBedrooms);
				rentalWrapper.setPostalCode(postalCode);
				rentalWrapper.setProvince(province);
				rentalWrapper.setRented(Boolean.FALSE);
				rentalWrapper.setSqFt(sqFt);
				rentalWrapper.setStreetName(streetName);
				rentalWrapper.setStreetNumber(streetNumber);
				rentalWrapper.setCity(city);
				rentalWrapper.setBuildingType(buildingType);
				if (rentController.addProperty(rentalWrapper)) {
					System.out.println("INFORMATION ENTERED SUCCESSFULLY");
				}
				flag = false;
			} catch (Exception e) {

			}
		}
	}

	public static void printMenu() {
		System.out.println("\n\tVIRTUAL RENTAL COMPANY\n"
				+ "\n\t1. ADD A PROPERTY\n\t2. ADD A TENANT\n\t3. RENT A UNIT\n\t4. DISPLAY PROPERTIES"
				+ "\n\t5. DISPLAY TENANTS\n\t6. DISPLAY RENTED UNITS\n\t7. DISPLAY VACANT UNITS\n\t"
				+ "8. DISPLAY ALL LEASES \n\t9. PAID AND UNPAID TENANTS List \n\t10. LEASE CANCEL");
		System.out.print("\nPLEASE ENTER YOUR CHOICE >");
	}

	public static void main(String[] args) {
		DriverProgram driver = new DriverProgram();
		while (true) {
			try {
				printMenu();
				int option = sc.nextInt();
				switch (option) {
				case 1:
					driver.addProperty();
					break;
				case 2:
					driver.addTenant();
					break;
				case 3:
					driver.rentAUnit();
					break;
				case 4:
					driver.displayProperties();
					break;
				case 5:
					driver.displayTenants();
					break;
				case 6:
					driver.displayRentedUnits();
					break;
				case 7:
					driver.displayVacantUnits();
					break;
				case 8:
					driver.displayLeases();
					break;
				case 9:
					driver.RentalPaymentDues();
					break;
				case 10:
					driver.leaseCancel();
					break;
				default:
					System.out.println("Please enter correct number");
					break;
				}
			} catch (Exception e) {

			}
		}

	}


	private void leaseCancel() {
		System.out.println("Enter lease Id to Cancel");
		long leaseId = sc.nextLong();
		if (rentController.cancelLease(leaseId)) {
			List<String> emailIdList = rentController.notifyPotentialTenants(leaseId);
			for (String emailId : emailIdList) {
				System.out.println(
						"An email has been sent to " + emailId + " regarding your preference with our Rental units");
			}
		}

	}

	private void RentalPaymentDues() {
		System.out.println("To view rental dues press 1 or to pay for a specific rental unit press 2");
		int option = sc.nextInt();
		if (option == 1) {
			System.out.println(" TENANTS WHO HAVENT PAID THEIR DUES ");
			System.out.println();
			List<LeaseInformation> leaseInfoList = rentController.getTenantDues();
			for (LeaseInformation leaseInfo : leaseInfoList) {
				if (leaseInfo.isActiveFlag()) {
					System.out.println(" NAME : " + leaseInfo.getTenantInfo().getName());
					System.out.println(" AGE : " + leaseInfo.getTenantInfo().getAge());
					System.out.println(" EMAILID : " + leaseInfo.getTenantInfo().getEmailId());
					System.out.println(" PHONENUMBER : " + leaseInfo.getTenantInfo().getPhoneNumber());
					System.out.println(" RENT DUE : " + leaseInfo.getRentAmount());
					System.out.println();
				}
			}
		} else if (option == 2) {
			System.out.println("Enter Lease id :");
			long leaseId = sc.nextLong();
			if (rentController.payDues(leaseId)) {
				System.out.println("Rent Payment Succeeded");
			} else {
				System.out.println(" Rent Payment failure.. Try again");
			}
		}
	}

	private void displayLeases() {
		List<LeaseInformation> leaseInformationList = rentController.displayLeases();
		for (LeaseInformation leaseInformation : leaseInformationList) {
			if (leaseInformation.isActiveFlag()) {
				System.out.println("LEASE INFORMATION");
				System.out.println(" NAME : " + leaseInformation.getTenantInfo().getName());
				System.out.println(" AGE : " + leaseInformation.getTenantInfo().getAge());
				System.out.println(" EMAILID : " + leaseInformation.getTenantInfo().getEmailId());
				System.out.println(" PHONENUMBER : " + leaseInformation.getTenantInfo().getPhoneNumber());
				System.out.println(" LEASE START DATE : " + leaseInformation.getLeaseStartDate());
				System.out.println(" LEASE END DATE : " + leaseInformation.getLeaseEndDate());
				if (leaseInformation.getBuildingType() == 1) {
					System.out.println(" BUILDING TYPE : " + " APARTMENT");
					System.out.println(" CIVIC ADDRESS : " + leaseInformation.getCivicAddress());
					System.out.println(" APARTMENT NUMBER : " + leaseInformation.getApartmentNumber());
				} else if (leaseInformation.getBuildingType() == 2) {
					System.out.println(" UNIT NUMBER : " + leaseInformation.getUnitNumber());
					System.out.println(" STREET NUMBER : " + leaseInformation.getStreetNumber());
				} else if (leaseInformation.getBuildingType() == 3) {
					System.out.println(" STREET NUMBER : " + leaseInformation.getStreetNumber());
				}
				System.out.println();
			}
		}
	}

	private void displayVacantUnits() {
		List<ApartmentUnit> apartmentUnitList = rentController.displayVacantApartments();
		for (ApartmentUnit apartmentUnit : apartmentUnitList) {
			System.out.println("");
			System.out.println("APARTMENTS");
			System.out.println("===========");
			System.out.println("APARTMENT NUMBER : " + apartmentUnit.getApartmentNumber());
			System.out.println("BUILDING ID : " + apartmentUnit.getBuildingId());
			System.out.println("CIVIC ADDRESS : " + apartmentUnit.getCivicAddress());
			System.out.println("CITY : " + apartmentUnit.getCity());
			System.out.println("BATHROOMS AVAILABLE : " + apartmentUnit.getNoOfBathrooms());
			System.out.println("BEDROOMS AVAILABLE : " + apartmentUnit.getNoOfBedrooms());
			System.out.println("POSTAL CODE : " + apartmentUnit.getPostalCode());
			System.out.println("PROVINCE : " + apartmentUnit.getProvince());
			System.out.println("SQUARE FEET : " + apartmentUnit.getSqFt());

		}
		List<Condo> CondoList = rentController.displayVacantCondos();
		for (Condo CondoUnit : CondoList) {
			System.out.println("");
			System.out.println("CONDO");
			System.out.println("===========");
			System.out.println("BUILDING ID : " + CondoUnit.getBuildingId());
			System.out.println("STREET NUMBER : " + CondoUnit.getStreetNumber());
			System.out.println("UNIT NUMBER : " + CondoUnit.getStreetNumber());
			System.out.println("CITY : " + CondoUnit.getCity());
			System.out.println("BATHROOMS AVAILABLE : " + CondoUnit.getNoOfBathrooms());
			System.out.println("BEDROOMS AVAILABLE : " + CondoUnit.getNoOfBedrooms());
			System.out.println("POSTAL CODE : " + CondoUnit.getPostalCode());
			System.out.println("PROVINCE : " + CondoUnit.getProvince());
			System.out.println("SQUARE FEET : " + CondoUnit.getSqFt());
		}
		List<House> HouseList = rentController.displayVacantHouses();
		for (House HouseUnit : HouseList) {
			System.out.println("");
			System.out.println("HOUSE");
			System.out.println("===========");
			System.out.println("BUILDING ID : " + HouseUnit.getBuildingId());
			System.out.println("STREET NUMBER : " + HouseUnit.getStreetNumber());
			System.out.println("CITY : " + HouseUnit.getCity());
			System.out.println("BATHROOMS AVAILABLE : " + HouseUnit.getNoOfBathrooms());
			System.out.println("BEDROOMS AVAILABLE : " + HouseUnit.getNoOfBedrooms());
			System.out.println("POSTAL CODE : " + HouseUnit.getPostalCode());
			System.out.println("PROVINCE : " + HouseUnit.getProvince());
			System.out.println("SQUARE FEET : " + HouseUnit.getSqFt());
		}
	}

	private void displayRentedUnits() {
		List<ApartmentUnit> apartmentUnitList = rentController.displayRentedApartments();
		for (ApartmentUnit apartmentUnit : apartmentUnitList) {
			System.out.println("");
			System.out.println("APARTMENTS");
			System.out.println("===========");
			System.out.println("APARTMENT NUMBER : " + apartmentUnit.getApartmentNumber());
			System.out.println("BUILDING ID : " + apartmentUnit.getBuildingId());
			System.out.println("CIVIC ADDRESS : " + apartmentUnit.getCivicAddress());
			System.out.println("CITY : " + apartmentUnit.getCity());
			System.out.println("BATHROOMS AVAILABLE : " + apartmentUnit.getNoOfBathrooms());
			System.out.println("BEDROOMS AVAILABLE : " + apartmentUnit.getNoOfBedrooms());
			System.out.println("POSTAL CODE : " + apartmentUnit.getPostalCode());
			System.out.println("PROVINCE : " + apartmentUnit.getProvince());
			System.out.println("SQUARE FEET : " + apartmentUnit.getSqFt());

		}
		List<Condo> CondoList = rentController.displayRentedCondos();
		for (Condo CondoUnit : CondoList) {
			System.out.println("");
			System.out.println("CONDO");
			System.out.println("===========");
			System.out.println("BUILDING ID : " + CondoUnit.getBuildingId());
			System.out.println("STREET NUMBER : " + CondoUnit.getStreetNumber());
			System.out.println("UNIT NUMBER : " + CondoUnit.getStreetNumber());
			System.out.println("CITY : " + CondoUnit.getCity());
			System.out.println("BATHROOMS AVAILABLE : " + CondoUnit.getNoOfBathrooms());
			System.out.println("BEDROOMS AVAILABLE : " + CondoUnit.getNoOfBedrooms());
			System.out.println("POSTAL CODE : " + CondoUnit.getPostalCode());
			System.out.println("PROVINCE : " + CondoUnit.getProvince());
			System.out.println("SQUARE FEET : " + CondoUnit.getSqFt());
		}
		List<House> HouseList = rentController.displayRentedHouses();
		for (House HouseUnit : HouseList) {
			System.out.println("");
			System.out.println("HOUSE");
			System.out.println("===========");
			System.out.println("BUILDING ID : " + HouseUnit.getBuildingId());
			System.out.println("STREET NUMBER : " + HouseUnit.getStreetNumber());
			System.out.println("CITY : " + HouseUnit.getCity());
			System.out.println("BATHROOMS AVAILABLE : " + HouseUnit.getNoOfBathrooms());
			System.out.println("BEDROOMS AVAILABLE : " + HouseUnit.getNoOfBedrooms());
			System.out.println("POSTAL CODE : " + HouseUnit.getPostalCode());
			System.out.println("PROVINCE : " + HouseUnit.getProvince());
			System.out.println("SQUARE FEET : " + HouseUnit.getSqFt());
		}
	}
}
