package realEstateCompany.Dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import realEstateCompany.classes.ApartmentUnit;
import realEstateCompany.classes.Condo;
import realEstateCompany.classes.House;
import realEstateCompany.classes.LeaseInformation;
import realEstateCompany.classes.RentalCompanyBuildings;
import realEstateCompany.classes.TenantInformation;

public class RealEstateCompanyDaoImpl extends RealEstateCompanyDao {

	static String tenantInformationFile = "TenantInformation.txt";
	static String apartmentInformationFile = "ApartmentInformation.txt";
	static String condoInformationFile = "CondoInformation.txt";
	static String houseInformationFile = "HouseInformation.txt";
	static String leaseInformationFile = "LeaseInformation.txt";
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Override
	public List<TenantInformation> getTenant() {
		Scanner scFile = null;
		List<TenantInformation> tenantInformationList = new ArrayList<TenantInformation>();
		try {
			scFile = new Scanner(new FileInputStream(tenantInformationFile));
			while (scFile.hasNext()) {
				String strRecord = scFile.nextLine();
				String strArr[] = strRecord.split("-");
				TenantInformation tenantInfo = new TenantInformation();
				List<String> strArrayList = Arrays.asList(strArr);
				tenantInfo.setTenantId(Long.parseLong(strArrayList.get(0)));
				tenantInfo.setName(strArrayList.get(1));
				tenantInfo.setAge(Integer.parseInt(strArrayList.get(2)));
				tenantInfo.setPhoneNumber(Long.parseLong(strArrayList.get(3)));
				tenantInfo.setEmailId(strArrayList.get(4));
				tenantInfo.setPreferredBuildingId(Integer.parseInt(strArrayList.get(5)));
				tenantInformationList.add(tenantInfo);
			}
			scFile.close();
		} catch (Exception e) {

		}
		return tenantInformationList;

	}

	@Override
	public List<ApartmentUnit> getApartments() {
		Scanner scFile = null;
		List<ApartmentUnit> apartmentUnitList = new ArrayList<ApartmentUnit>();
		try {
			scFile = new Scanner(new FileInputStream(apartmentInformationFile));
			while (scFile.hasNext()) {
				String strRecord = scFile.nextLine();
				String strArr[] = strRecord.split("-");
				ApartmentUnit apartment = new ApartmentUnit();
				List<String> strArrayList = Arrays.asList(strArr);
				apartment.setCivicAddress(strArrayList.get(1));
				apartment.setApartmentNumber(Integer.parseInt(strArrayList.get(0)));
				apartment.setStreetName(strArrayList.get(2));
				apartment.setCity(strArrayList.get(3));
				apartment.setProvince(strArrayList.get(4));
				apartment.setPostalCode(strArrayList.get(5));
				apartment.setNoOfBedrooms(Integer.parseInt(strArrayList.get(6)));
				apartment.setNoOfBathrooms(Integer.parseInt(strArrayList.get(7)));
				apartment.setSqFt(Double.parseDouble(strArrayList.get(8)));
				apartment.setRented(Boolean.parseBoolean(strArrayList.get(9)));
				apartment.setBuildingId(Long.parseLong(strArrayList.get(10)));
				apartmentUnitList.add(apartment);

			}

			scFile.close();
		} catch (Exception e) {

		}
		return apartmentUnitList;

	}

	@Override
	public List<Condo> getCondos() {
		Scanner scFile = null;
		List<Condo> condoList = new ArrayList<Condo>();
		try {
			scFile = new Scanner(new FileInputStream(condoInformationFile));
			while (scFile.hasNext()) {
				String strRecord = scFile.nextLine();
				String strArr[] = strRecord.split("-");
				Condo condoBuilding = new Condo();
				List<String> strArrayList = Arrays.asList(strArr);

				condoBuilding.setUnitNumber(Integer.parseInt(strArrayList.get(0)));
				condoBuilding.setStreetNumber(Integer.parseInt(strArrayList.get(1)));
				condoBuilding.setStreetName(strArrayList.get(2));
				condoBuilding.setCity(strArrayList.get(3));
				condoBuilding.setProvince(strArrayList.get(4));
				condoBuilding.setPostalCode(strArrayList.get(5));
				condoBuilding.setNoOfBedrooms(Integer.parseInt(strArrayList.get(6)));
				condoBuilding.setNoOfBathrooms(Integer.parseInt(strArrayList.get(7)));
				condoBuilding.setSqFt(Double.parseDouble(strArrayList.get(8)));
				condoBuilding.setRented(Boolean.parseBoolean(strArrayList.get(9)));
				condoBuilding.setBuildingId(Long.parseLong(strArrayList.get(10)));
				condoList.add(condoBuilding);

			}

			scFile.close();
		} catch (Exception e) {

		}
		return condoList;
	}

	@Override
	public List<House> getHouses() {
		Scanner scFile = null;
		List<House> houseList = new ArrayList<House>();
		try {
			scFile = new Scanner(new FileInputStream(houseInformationFile));
			while (scFile.hasNext()) {
				String strRecord = scFile.nextLine();
				String strArr[] = strRecord.split("-");
				House houseInfo = new House();
				List<String> strArrayList = Arrays.asList(strArr);

				houseInfo.setStreetNumber(Integer.parseInt(strArrayList.get(0)));
				houseInfo.setStreetName(strArrayList.get(1));
				houseInfo.setCity(strArrayList.get(2));
				houseInfo.setProvince(strArrayList.get(3));
				houseInfo.setPostalCode(strArrayList.get(4));
				houseInfo.setNoOfBedrooms(Integer.parseInt(strArrayList.get(5)));
				houseInfo.setNoOfBathrooms(Integer.parseInt(strArrayList.get(6)));
				houseInfo.setSqFt(Double.parseDouble(strArrayList.get(7)));
				houseInfo.setRented(Boolean.parseBoolean(strArrayList.get(8)));
				houseInfo.setBuildingId(Long.parseLong(strArrayList.get(9)));
				houseList.add(houseInfo);

			}

			scFile.close();
		} catch (Exception e) {

		}
		return houseList;

	}

	@Override
	public TenantInformation getTenantByPhoneNumber(long PhoneNumber) {
		Scanner scFile = null;
		TenantInformation tenantInfo = new TenantInformation();
		try {
			scFile = new Scanner(new FileInputStream(tenantInformationFile));
			while (scFile.hasNext()) {
				String strRecord = scFile.nextLine();
				String strArr[] = strRecord.split("-");
				List<String> strArrayList = Arrays.asList(strArr);
				if (strArrayList.get(3).equals(Long.toString(PhoneNumber))) {
					tenantInfo.setTenantId(Integer.parseInt(strArrayList.get(0)));
					tenantInfo.setName(strArrayList.get(1));
					tenantInfo.setAge(Integer.parseInt(strArrayList.get(2)));
					tenantInfo.setPhoneNumber(Long.parseLong(strArrayList.get(3)));
					tenantInfo.setEmailId(strArrayList.get(4));
					tenantInfo.setPreferredBuildingId(Integer.parseInt(strArrayList.get(5)));
				}

			}

			scFile.close();
		} catch (Exception e) {

		}
		return tenantInfo;
	}

	@Override
	public boolean addTenant(TenantInformation tenantInfo) {
		boolean Flag = false;
		try {
			FileWriter fw = new FileWriter(tenantInformationFile, true);
			fw.append(tenantInfo.toFile());
			fw.append("\n");
			fw.close();
			Flag = true;
		} catch (Exception e) {

		}
		return Flag;
	}

	@Override
	public boolean addApartment(RentalCompanyBuildings rentalBuilding) {
		boolean flag = Boolean.FALSE;
		try {
			FileWriter fw = new FileWriter(apartmentInformationFile, true);
			fw.append(rentalBuilding.toString());
			fw.append("\n");
			fw.close();
			flag = true;
		} catch (Exception e) {

		}
		return flag;
	}

	@Override
	public boolean addCondo(RentalCompanyBuildings rentalBuilding) {
		boolean flag = Boolean.FALSE;
		try {
			FileWriter fw = new FileWriter(condoInformationFile, true);
			fw.append(rentalBuilding.toString());
			fw.append("\n");
			fw.close();
			flag = true;
		} catch (Exception e) {

		}
		return flag;
	}

	@Override
	public boolean addHouse(RentalCompanyBuildings rentalBuilding) {
		boolean flag = Boolean.FALSE;
		try {
			FileWriter fw = new FileWriter(houseInformationFile, true);
			fw.append(rentalBuilding.toString());
			fw.append("\n");
			fw.close();
			flag = true;
		} catch (Exception e) {

		}
		return flag;
	}

	@Override
	public ApartmentUnit checkAptAvailability(String apartmentCivicAddress, int apartmentUnitNumber) {

		Scanner scFile = null;
		ApartmentUnit apartmentUnit = new ApartmentUnit();
		boolean flag = Boolean.FALSE;
		try {
			scFile = new Scanner(new FileInputStream(apartmentInformationFile));

			while (scFile.hasNext()) {
				String strRecord = scFile.nextLine();
				String strArr[] = strRecord.split("-");
				List<String> strArrayList = Arrays.asList(strArr);
				if (strArrayList.contains(apartmentCivicAddress)
						&& strArrayList.contains(Integer.toString(apartmentUnitNumber))) {
					flag = true;
					apartmentUnit.setCivicAddress(strArrayList.get(1));
					apartmentUnit.setApartmentNumber(Integer.parseInt(strArrayList.get(0)));
					apartmentUnit.setStreetName(strArrayList.get(2));
					apartmentUnit.setCity(strArrayList.get(3));
					apartmentUnit.setProvince(strArrayList.get(4));
					apartmentUnit.setPostalCode(strArrayList.get(5));
					apartmentUnit.setNoOfBedrooms(Integer.parseInt(strArrayList.get(6)));
					apartmentUnit.setNoOfBathrooms(Integer.parseInt(strArrayList.get(7)));
					apartmentUnit.setSqFt(Double.parseDouble(strArrayList.get(8)));
					apartmentUnit.setRented(Boolean.parseBoolean(strArrayList.get(9)));
					apartmentUnit.setBuildingId(Long.parseLong(strArrayList.get(10)));

				}

			}

			scFile.close();
		} catch (Exception e) {

		}
		return apartmentUnit;
	}

	@Override
	public Condo checkCondoAvailability(int condoStreetNumber, int condoUnitNumber) {
		Scanner scFile = null;
		Condo condoInfo = new Condo();
		try {
			scFile = new Scanner(new FileInputStream(condoInformationFile));

			while (scFile.hasNext()) {
				String strRecord = scFile.nextLine();
				String strArr[] = strRecord.split("-");
				List<String> strArrayList = Arrays.asList(strArr);
				if (strArrayList.contains(Integer.toString(condoStreetNumber))
						&& strArrayList.contains(Integer.toString(condoUnitNumber))) {
					condoInfo.setUnitNumber(Integer.parseInt(strArrayList.get(0)));
					condoInfo.setStreetNumber(Integer.parseInt(strArrayList.get(1)));
					condoInfo.setStreetName(strArrayList.get(2));
					condoInfo.setCity(strArrayList.get(3));
					condoInfo.setProvince(strArrayList.get(4));
					condoInfo.setPostalCode(strArrayList.get(5));
					condoInfo.setNoOfBedrooms(Integer.parseInt(strArrayList.get(6)));
					condoInfo.setNoOfBathrooms(Integer.parseInt(strArrayList.get(7)));
					condoInfo.setSqFt(Double.parseDouble(strArrayList.get(8)));
					condoInfo.setRented(Boolean.parseBoolean(strArrayList.get(9)));
					condoInfo.setBuildingId(Long.parseLong(strArrayList.get(10)));
				}
			}

			scFile.close();
		} catch (Exception e) {

		}
		return condoInfo;

	}

	@Override
	public House checkHouseAvailability(int houseStreetNumber) {
		Scanner scFile = null;
		House houseInfo = new House();

		try {
			scFile = new Scanner(new FileInputStream(houseInformationFile));

			while (scFile.hasNext()) {
				String strRecord = scFile.nextLine();
				String strArr[] = strRecord.split("-");
				List<String> strArrayList = Arrays.asList(strArr);
				if (strArrayList.contains(Integer.toString(houseStreetNumber))) {
				houseInfo.setStreetNumber(Integer.parseInt(strArrayList.get(0)));
				houseInfo.setStreetName(strArrayList.get(1));
				houseInfo.setCity(strArrayList.get(2));
				houseInfo.setProvince(strArrayList.get(3));
				houseInfo.setPostalCode(strArrayList.get(4));
				houseInfo.setNoOfBedrooms(Integer.parseInt(strArrayList.get(5)));
				houseInfo.setNoOfBathrooms(Integer.parseInt(strArrayList.get(6)));
				houseInfo.setSqFt(Double.parseDouble(strArrayList.get(7)));
				houseInfo.setRented(Boolean.parseBoolean(strArrayList.get(8)));
				houseInfo.setBuildingId(Long.parseLong(strArrayList.get(9)));
			}
			}
			scFile.close();
		} catch (Exception e) {

		}
		return houseInfo;

	}

	@Override
	public boolean checkTenant(long phoneNumber) {
		return false;
	}

	@Override
	public boolean addLease(LeaseInformation leaseInformation, int buildingType, long buildingId) {
		boolean updatedflag = Boolean.FALSE;
		setLeaseIdAgainstTenant(leaseInformation);
		try {
			FileWriter fw = new FileWriter(leaseInformationFile, true);
			fw.append(leaseInformation.toString());
			fw.append("\n");
			fw.close();
			updatedflag = Boolean.TRUE;
		} catch (Exception e) {

		}
		return updatedflag;

	}

//	static String apartmentInformationFile = "ApartmentInformation.txt";
//	static String condoInformationFile = "CondoInformation.txt";
//	static String houseInformationFile = "HouseInformation.txt";
	@Override
	public boolean setApartmentRentStatus(boolean RentStatus, long buildingId, long leaseId) {
		boolean updatedflag = Boolean.FALSE;
		try {
			FileReader fileReader = new FileReader(apartmentInformationFile);
			List<String> lines = new ArrayList<String>();
			Boolean lineSet = false;
			int length = 0;

			BufferedReader bufferedReader = new BufferedReader(fileReader, 40000);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}
			ApartmentUnit apartment = new ApartmentUnit();
			for (String str : lines) {
				String strArr[] = str.split("-");
				List<String> strArrayList = Arrays.asList(strArr);
				if (strArrayList.contains(Long.toString(buildingId))) {
					lineSet = true;
					apartment.setCivicAddress(strArrayList.get(1));
					apartment.setApartmentNumber(Integer.parseInt(strArrayList.get(0)));
					apartment.setStreetName(strArrayList.get(2));
					apartment.setCity(strArrayList.get(3));
					apartment.setProvince(strArrayList.get(4));
					apartment.setPostalCode(strArrayList.get(5));
					apartment.setNoOfBedrooms(Integer.parseInt(strArrayList.get(6)));
					apartment.setNoOfBathrooms(Integer.parseInt(strArrayList.get(7)));
					apartment.setSqFt(Double.parseDouble(strArrayList.get(8)));
					apartment.setRented(RentStatus);
					apartment.setBuildingId(Long.parseLong(strArrayList.get(10)));
					break;
				}
				length++;
			}
			if (lineSet == true) {
				lines.set(length, apartment.toString());
			}
			bufferedReader.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(apartmentInformationFile));
			for (String lineWrite : lines) {
				writer.write(lineWrite);
				writer.newLine();
			}
			updatedflag = true;
			writer.close();

		}

		catch (Exception e) {

		}
		return updatedflag;
	}

	@Override
	public boolean setCondoRentStatus(boolean RentStatus, long buildingId, long leaseId) {
		boolean updatedflag = Boolean.FALSE;
		try {
			FileReader fileReader = new FileReader(condoInformationFile);
			List<String> lines = new ArrayList<String>();
			Boolean lineSet = false;
			int length = 0;
			BufferedReader bufferedReader = new BufferedReader(fileReader, 40000);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}
			Condo condoBuilding = new Condo();

			for (String str : lines) {
				String strArr[] = str.split("-");
				List<String> strArrayList = Arrays.asList(strArr);
				if (strArrayList.contains(Long.toString(buildingId))) {
					lineSet = true;
					condoBuilding.setUnitNumber(Integer.parseInt(strArrayList.get(0)));
					condoBuilding.setStreetNumber(Integer.parseInt(strArrayList.get(1)));
					condoBuilding.setStreetName(strArrayList.get(2));
					condoBuilding.setCity(strArrayList.get(3));
					condoBuilding.setProvince(strArrayList.get(4));
					condoBuilding.setPostalCode(strArrayList.get(5));
					condoBuilding.setNoOfBedrooms(Integer.parseInt(strArrayList.get(6)));
					condoBuilding.setNoOfBathrooms(Integer.parseInt(strArrayList.get(7)));
					condoBuilding.setSqFt(Double.parseDouble(strArrayList.get(8)));
					condoBuilding.setRented(RentStatus);
					condoBuilding.setBuildingId(Long.parseLong(strArrayList.get(10)));
					break;
				}
				length++;
			}

			if (lineSet == true) {
				lines.set(length, condoBuilding.toString());
			}
			bufferedReader.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(condoInformationFile));
			for (String lineWrite : lines) {
				writer.write(lineWrite);
				writer.newLine();

			}
			updatedflag = true;
			writer.close();
		} catch (Exception e) {

		}
		return updatedflag;

	}

	@Override
	public boolean setHouseRentStatus(boolean RentStatus, long buildingId, long leaseId) {
		boolean updatedflag = Boolean.FALSE;
		try {
			FileReader fileReader = new FileReader(houseInformationFile);
			List<String> lines = new ArrayList<String>();
			Boolean lineSet = false;
			int length = 0;
			BufferedReader bufferedReader = new BufferedReader(fileReader, 40000);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}
			House houseInfo = new House();
			for (String str : lines) {
				String strArr[] = str.split("-");
				List<String> strArrayList = Arrays.asList(strArr);
				if (strArrayList.contains(Long.toString(buildingId))) {
					lineSet = true;
					houseInfo.setStreetNumber(Integer.parseInt(strArrayList.get(0)));
					houseInfo.setStreetName(strArrayList.get(1));
					houseInfo.setCity(strArrayList.get(2));
					houseInfo.setProvince(strArrayList.get(3));
					houseInfo.setPostalCode(strArrayList.get(4));
					houseInfo.setNoOfBedrooms(Integer.parseInt(strArrayList.get(5)));
					houseInfo.setNoOfBathrooms(Integer.parseInt(strArrayList.get(6)));
					houseInfo.setSqFt(Double.parseDouble(strArrayList.get(7)));
					houseInfo.setRented(RentStatus);
					houseInfo.setBuildingId(Long.parseLong(strArrayList.get(9)));
					break;
				}
				length++;
			}
			if (lineSet == true) {
				lines.set(length, houseInfo.toString());
			}
			bufferedReader.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(houseInformationFile));
			for (String lineWrite : lines) {
				writer.write(lineWrite);
				writer.newLine();
			}
			updatedflag = true;
			writer.close();
		}

		catch (Exception e) {

		}
		return updatedflag;

	}

	@Override
	public List<LeaseInformation> getLeases() {
		Scanner scFile = null;
		List<LeaseInformation> LeaseInformationList = new ArrayList<LeaseInformation>();
		try {
			scFile = new Scanner(new FileInputStream(leaseInformationFile));
			while (scFile.hasNext()) {
				String strRecord = scFile.nextLine();
				String strArr[] = strRecord.split("-");
				List<String> strArrayList = Arrays.asList(strArr);
				TenantInformation tenantInfo = new TenantInformation();
				LeaseInformation leaseInfo = new LeaseInformation();
				tenantInfo.setTenantId(Integer.parseInt(strArrayList.get(4)));
				tenantInfo.setName(strArrayList.get(5));
				tenantInfo.setAge(Integer.parseInt(strArrayList.get(6)));
				tenantInfo.setPhoneNumber(Long.parseLong(strArrayList.get(7)));
				tenantInfo.setEmailId(strArrayList.get(8));
				String leaseStart = strArrayList.get(1);
				String leaseEnd = strArrayList.get(2);
				LocalDate LeaseStartDate = LocalDate.parse(leaseStart, formatter);
				LocalDate LeaseEndDate = LocalDate.parse(leaseEnd, formatter);
				leaseInfo.setLeaseId(Integer.parseInt(strArrayList.get(0)));
				leaseInfo.setRentAmount(Double.parseDouble(strArrayList.get(3)));
				leaseInfo.setLeaseEndDate(LeaseStartDate);
				leaseInfo.setLeaseStartDate(LeaseEndDate);
				leaseInfo.setBuildingType(Integer.parseInt(strArrayList.get(9)));
				leaseInfo.setBuildingId(Integer.parseInt(strArrayList.get(10)));
				leaseInfo.setUnitNumber(Integer.parseInt(strArrayList.get(11)));
				leaseInfo.setStreetNumber(Integer.parseInt(strArrayList.get(12)));
				leaseInfo.setApartmentNumber(Integer.parseInt(strArrayList.get(13)));
				leaseInfo.setCivicAddress(strArrayList.get(14));
				leaseInfo.setStreetName(strArrayList.get(15));
				leaseInfo.setCity(strArrayList.get(16));
				leaseInfo.setProvince(strArrayList.get(17));
				leaseInfo.setPostalCode(strArrayList.get(18));
				leaseInfo.setNoOfBedrooms(Integer.parseInt(strArrayList.get(19)));
				leaseInfo.setNoOfBathrooms(Integer.parseInt(strArrayList.get(20)));
				leaseInfo.setSqFt(Double.parseDouble(strArrayList.get(21)));
				leaseInfo.setActiveFlag(Boolean.parseBoolean(strArrayList.get(22)));
				leaseInfo.setRentPaid(Boolean.parseBoolean(strArrayList.get(23)));
				leaseInfo.setTenantInfo(tenantInfo);
				LeaseInformationList.add(leaseInfo);

			}

			scFile.close();
		} catch (Exception e) {

		}
		return LeaseInformationList;
	}

	@Override
	public LeaseInformation getSingleLease(long leaseId) {
		Scanner scFile = null;
		LeaseInformation leaseInfo = new LeaseInformation();
		try {
			scFile = new Scanner(new FileInputStream(leaseInformationFile));
			while (scFile.hasNext()) {
				String strRecord = scFile.nextLine();
				String strArr[] = strRecord.split("-");
				List<String> strArrayList = Arrays.asList(strArr);
				if (strArrayList.contains(Long.toString(leaseId))) {
					TenantInformation tenantInfo = new TenantInformation();
					tenantInfo.setTenantId(Integer.parseInt(strArrayList.get(4)));
					tenantInfo.setName(strArrayList.get(5));
					tenantInfo.setAge(Integer.parseInt(strArrayList.get(6)));
					tenantInfo.setPhoneNumber(Long.parseLong(strArrayList.get(7)));
					tenantInfo.setEmailId(strArrayList.get(8));
					String leaseStart = strArrayList.get(1);
					String leaseEnd = strArrayList.get(2);
					LocalDate LeaseStartDate = LocalDate.parse(leaseStart, formatter);
					LocalDate LeaseEndDate = LocalDate.parse(leaseEnd, formatter);
					leaseInfo.setLeaseId(Integer.parseInt(strArrayList.get(0)));
					leaseInfo.setRentAmount(Double.parseDouble(strArrayList.get(3)));
					leaseInfo.setLeaseEndDate(LeaseStartDate);
					leaseInfo.setLeaseStartDate(LeaseEndDate);
					leaseInfo.setBuildingType(Integer.parseInt(strArrayList.get(9)));
					leaseInfo.setBuildingId(Integer.parseInt(strArrayList.get(10)));
					leaseInfo.setUnitNumber(Integer.parseInt(strArrayList.get(11)));
					leaseInfo.setStreetNumber(Integer.parseInt(strArrayList.get(12)));
					leaseInfo.setApartmentNumber(Integer.parseInt(strArrayList.get(13)));
					leaseInfo.setCivicAddress(strArrayList.get(14));
					leaseInfo.setStreetName(strArrayList.get(15));
					leaseInfo.setCity(strArrayList.get(16));
					leaseInfo.setProvince(strArrayList.get(17));
					leaseInfo.setPostalCode(strArrayList.get(18));
					leaseInfo.setNoOfBedrooms(Integer.parseInt(strArrayList.get(19)));
					leaseInfo.setNoOfBathrooms(Integer.parseInt(strArrayList.get(20)));
					leaseInfo.setSqFt(Double.parseDouble(strArrayList.get(21)));
					leaseInfo.setActiveFlag(Boolean.parseBoolean(strArrayList.get(22)));
					leaseInfo.setRentPaid(Boolean.parseBoolean(strArrayList.get(23)));
					leaseInfo.setTenantInfo(tenantInfo);
					break;
				}
			}

			scFile.close();
		} catch (Exception e) {

		}
		return leaseInfo;
	}

	@Override
	public boolean setLeaseIdAgainstTenant(LeaseInformation leaseInformation) {
		TenantInformation tenantInfo = new TenantInformation();
		boolean updatedflag = Boolean.FALSE;
		try {
			FileReader fileReader = new FileReader(tenantInformationFile);
			List<String> lines = new ArrayList<String>();
			Boolean lineSet = false;
			int length = 0;
			BufferedReader bufferedReader = new BufferedReader(fileReader, 40000);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}
			for (String str : lines) {
				String strArr[] = str.split("-");
				List<String> strArrayList = Arrays.asList(strArr);
				if (strArrayList.contains(Long.toString(leaseInformation.getTenantInfo().getTenantId()))) {
					tenantInfo.setTenantId(leaseInformation.getTenantInfo().getTenantId());
					tenantInfo.setName(leaseInformation.getTenantInfo().getName());
					tenantInfo.setAge(leaseInformation.getTenantInfo().getAge());
					tenantInfo.setPhoneNumber(leaseInformation.getTenantInfo().getPhoneNumber());
					tenantInfo.setEmailId(leaseInformation.getTenantInfo().getEmailId());
					tenantInfo.setPreferredBuildingId(0);
					tenantInfo.setLeaseId(leaseInformation.getTenantInfo().getLeaseId());
					lineSet = true;
					break;
				}
				length++;
			}
			if (lineSet == true) {
				lines.set(length, tenantInfo.toFile());
				BufferedWriter writer = new BufferedWriter(new FileWriter(tenantInformationFile));
				for (String lineWrite : lines) {
					writer.write(lineWrite);
					writer.newLine();
				}
				updatedflag = true;
				writer.close();
			}
			bufferedReader.close();

		}

		catch (Exception e) {

		}
		return updatedflag;

	}

	@Override
	public boolean payDues(long leaseId) {
		boolean updatedflag = Boolean.FALSE;
		try {
			FileReader fileReader = new FileReader(leaseInformationFile);
			List<String> lines = new ArrayList<String>();
			Boolean lineSet = false;
			int length = 0;
			BufferedReader bufferedReader = new BufferedReader(fileReader, 40000);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}
			LeaseInformation leaseInfo = new LeaseInformation();
			for (String str : lines) {
				String strArr[] = str.split("-");
				List<String> strArrayList = Arrays.asList(strArr);
				if (strArrayList.contains(Long.toString(leaseId))) {
					leaseInfo = getSingleLease(leaseId);
					leaseInfo.setRentPaid(Boolean.TRUE);
					lineSet = true;
					break;
				}
				length++;
			}
			if (lineSet == true) {
				lines.set(length, leaseInfo.toString());
				BufferedWriter writer = new BufferedWriter(new FileWriter(leaseInformationFile));
				for (String lineWrite : lines) {
					writer.write(lineWrite);
					writer.newLine();
				}
				updatedflag = true;
				writer.close();
			}
			bufferedReader.close();
		} catch (Exception e) {

		}
		return updatedflag;

	}

	public boolean cancelLease(long leaseId) {
		boolean updatedflag = Boolean.FALSE;
		try {
			FileReader fileReader = new FileReader(leaseInformationFile);
			List<String> lines = new ArrayList<String>();
			Boolean lineSet = false;
			int length = 0;
			BufferedReader bufferedReader = new BufferedReader(fileReader, 40000);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}
			LeaseInformation leaseInfo = new LeaseInformation();
			for (String str : lines) {
				String strArr[] = str.split("-");
				List<String> strArrayList = Arrays.asList(strArr);
				if (strArrayList.get(0).contains(Long.toString(leaseId))) {
					leaseInfo = getSingleLease(leaseId);
					if (leaseInfo.isActiveFlag() != Boolean.FALSE) {
						leaseInfo.setActiveFlag(Boolean.FALSE);
						leaseInfo.setRentPaid(Boolean.FALSE);
						if (leaseInfo.getBuildingType() == 1) {
							setApartmentRentStatus(Boolean.FALSE, leaseInfo.getBuildingId(), leaseInfo.getLeaseId());
						}
						if (leaseInfo.getBuildingType() == 2) {
							setCondoRentStatus(Boolean.FALSE, leaseInfo.getBuildingId(), leaseInfo.getLeaseId());
						}
						if (leaseInfo.getBuildingType() == 3) {
							setHouseRentStatus(Boolean.FALSE, leaseInfo.getBuildingId(), leaseInfo.getLeaseId());
						}
					}
					else {
						System.out.println(" Lease Already canceled");
						break;
					}
					lineSet = true;
					break;
				}
				length++;
			}
			if (lineSet == true) {
				lines.set(length, leaseInfo.toString());
				BufferedWriter writer = new BufferedWriter(new FileWriter(leaseInformationFile));
				for (String lineWrite : lines) {
					writer.write(lineWrite);
					writer.newLine();
				}
				updatedflag = true;
				writer.close();
			}
			bufferedReader.close();
		} catch (Exception e) {

		}
		return updatedflag;

	}

	public List<String> notifyPotentialTenants(Long leaseId) {
		List<String> emailList = new ArrayList<String>();
		LeaseInformation singleLease = new LeaseInformation();
		singleLease = getSingleLease(leaseId);
		List<TenantInformation> tenantInfo = getTenant();
		if (singleLease.getBuildingType() == 1) {
			setApartmentRentStatus(Boolean.FALSE, singleLease.getBuildingId(), leaseId);
			for (TenantInformation tenant : tenantInfo) {
				if (tenant.getPreferredBuildingId() == singleLease.getBuildingId()) {
					emailList.add(tenant.getEmailId());
				}
			}
		} else if (singleLease.getBuildingType() == 2) {
			setCondoRentStatus(Boolean.FALSE, singleLease.getBuildingId(), leaseId);
			for (TenantInformation tenant : tenantInfo) {
				if (tenant.getPreferredBuildingId() == singleLease.getBuildingId()) {
					emailList.add(tenant.getEmailId());
				}

			}
		} else if (singleLease.getBuildingType() == 3) {
			setHouseRentStatus(Boolean.FALSE, singleLease.getBuildingId(), leaseId);
			for (TenantInformation tenant : tenantInfo) {
				if (tenant.getPreferredBuildingId() == singleLease.getBuildingId()) {
					emailList.add(tenant.getEmailId());
				}
			}
		}

		return emailList;
	}
}
