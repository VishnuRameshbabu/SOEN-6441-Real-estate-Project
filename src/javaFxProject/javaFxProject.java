package javaFxProject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import realEstateCompany.classes.ApartmentUnit;
import realEstateCompany.classes.Condo;
import realEstateCompany.classes.House;
import realEstateCompany.classes.LeaseInformation;
import realEstateCompany.classes.RentalCompanyBuildingWrapper;
import realEstateCompany.classes.TenantInformation;
import realEstateCompany.controller.Controller;

public class javaFxProject extends Application {
	final int MAX_WIDTH = 200;
	private Pagination pagination;
	Button addPropertyButton;
	Button addTenantButton;
	Button rentalButton;
	Button button4;
	Button button5;
	Button button6;
	Button button7;
	Button button8;
	Button button9;
	Button button10;
	Button backToMainmenu;
	Button submit;
	Scene mainMenuScene;
	List<House> houseList;
	List<ApartmentUnit> apartmentList;
	List<Condo> condoList;
	List<LeaseInformation> leaseInfoList;
	List<TenantInformation> tenantInfoList;
	int apartmentSizeStarting = 0;
	int condoSizeStarting = 0;
	int houseSizeStarting = 0;
	int leaseSize = 0;
	final int MenuHeight = 800;
	final int MenuWidth = 600;
	final int ApartmentTypeID = 1;
	final int CondoTypeID = 2;
	final int HouseTypeID = 3;
	static Controller rentController = new Controller();
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
	String leaseStart, leaseEnd;
	long tenantPhoneNumber;
	float rentAmount;
	long buildingId = 0;
	boolean isPresent = false;
	boolean isRented = false;
	ApartmentUnit apartmentUnit;
	Condo condoUnit;
	House houseUnit;
	LeaseInformation leaseInformation;
	TenantInformation tenantInfo;
	String Name;
	int Age;
	long phoneNumber;
	String emailId;
	long preferredBuildingId;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage mainMenu) throws Exception {
		mainMenu.setTitle("VIRTUAL RENTAL COMPANY");
//		button1 =  new Button("WELCOME TO VIRTUAL RENTAL COMPANY");
		VBox layout = new VBox(25);
		layout.setSpacing(10);
		// layout.setPadding(new Insets(0, 20, 10, 20));
		addPropertyButton = new Button("Add a Property");
		addTenantButton = new Button("Add a Tenant");
		rentalButton = new Button("Rent a Unit");
		button4 = new Button("Display Properties");
		button5 = new Button("Display Vacant Properties");
		button6 = new Button("Display Rented Properties");
		button7 = new Button("Display Tenants");
		button8 = new Button("Display Leases");
		button9 = new Button("Display Rental Payment Dues");
		button10 = new Button("Lease Cancellation");
		addPropertyButton.setMaxWidth(MAX_WIDTH);
		addTenantButton.setMaxWidth(MAX_WIDTH);
		rentalButton.setMaxWidth(MAX_WIDTH);
		button4.setMaxWidth(MAX_WIDTH);
		button5.setMaxWidth(MAX_WIDTH);
		button6.setMaxWidth(MAX_WIDTH);
		button7.setMaxWidth(MAX_WIDTH);
		button8.setMaxWidth(MAX_WIDTH);
		button9.setMaxWidth(MAX_WIDTH);
		button10.setMaxWidth(MAX_WIDTH);
		Button buttonTest = new Button("TEST BUTTON");
		Label welcomeMessage = new Label();
		welcomeMessage.setText("WELCOME TO VIRTUAL RENTAL COMPANY");
		addPropertyButton.setOnAction(e -> {
			try {
				addProperty(mainMenu, addPropertyButton);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		addTenantButton.setOnAction(e -> {
			try {
				addTenant(mainMenu);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		rentalButton.setOnAction(e -> {
			try {
				addProperty(mainMenu, rentalButton);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		button4.setOnAction(e -> {
			try {
				displayproperties(mainMenu);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		button5.setOnAction(e -> {
			try {
				displayVacantUnits(mainMenu);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		button6.setOnAction(e -> {
			try {
				displayRentedUnits(mainMenu);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		button7.setOnAction(e -> {
			try {
				displayTenants(mainMenu);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		button8.setOnAction(e -> {
			try {
				displayLeases(mainMenu);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		button9.setOnAction(e -> {
			try {
				RentalPaymentDues(mainMenu);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		button10.setOnAction(e -> {
			try {
				leaseCancel(mainMenu);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		buttonTest.setOnAction(e -> {
			try {
				testPageProperties(mainMenu);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		layout.setPrefWidth(100);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(welcomeMessage, addPropertyButton, addTenantButton, rentalButton, button4, button5,
				button6, button7, button8, button9, button10, buttonTest);
		mainMenuScene = new Scene(layout, 800, 600);
		mainMenu.setScene(mainMenuScene);
		mainMenu.show();
	}

	public void displayproperties(Stage mainMenu) throws Exception {
		mainMenu.setTitle("Display Properties");
		Runnable task = new Runnable() {
			@Override
			public void run() {
				String s = Platform.isFxApplicationThread() ? " JavaFx Thread"
						: " Background Display Properties Thread";
				System.out.println("Current thread is" + s);
				apartmentList = rentController.displayApartments();
				condoList = rentController.displayCondos();
				houseList = rentController.displayHouses();
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						try {
							String s = Platform.isFxApplicationThread() ? " JavaFx Thread"
									: "Background Display Properties Thread";
							System.out.println("Current thread is" + s);
							testPageProperties(mainMenu);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});

			}
		};
		new Thread(task).start();
	}

	public void addProperty(Stage mainMenu, Button button) throws Exception {
		BorderPane border = new BorderPane();
		Button apartmentButton = new Button("Apartment");
		Button condoButton = new Button("Condo");
		Button houseButton = new Button("House");
		backToMainmenu = new Button("Back to Main Menu");
		apartmentButton.setMaxWidth(MAX_WIDTH);
		condoButton.setMaxWidth(MAX_WIDTH);
		houseButton.setMaxWidth(MAX_WIDTH);
		backToMainmenu.setMaxWidth(MAX_WIDTH);
		backToMainmenu.setAlignment(Pos.BOTTOM_LEFT);
		apartmentButton.setOnAction(e -> {
			try {
				if (button.equals(rentalButton)) {
					rentAUnit(mainMenu, ApartmentTypeID);
				} else if (button.equals(addPropertyButton)) {
					addPropertyDetails(mainMenu, ApartmentTypeID);
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		condoButton.setOnAction(e -> {
			try {
				if (button.equals(rentalButton)) {
					rentAUnit(mainMenu, CondoTypeID);
				} else if (button.equals(addPropertyButton)) {
					addPropertyDetails(mainMenu, CondoTypeID);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		houseButton.setOnAction(e -> {
			try {
				if (button.equals(rentalButton)) {
					rentAUnit(mainMenu, HouseTypeID);
				} else if (button.equals(addPropertyButton)) {
					addPropertyDetails(mainMenu, HouseTypeID);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		backToMainmenu.setOnAction(e -> {
			mainMenu.setScene(mainMenuScene);
			mainMenu.setTitle("VIRTUAL RENTAL COMPANY");
		});
		GridPane gridbottom = new GridPane();
		gridbottom.setPadding(new Insets(20, 20, 20, 20));
		gridbottom.setVgap(8);
		gridbottom.setHgap(10);
		gridbottom.setConstraints(backToMainmenu, 0, 0);
		VBox layout = new VBox(25);
		layout.setSpacing(10);
		mainMenu.setTitle("Adding a Property");
		Label welcomeMessage = new Label();
		welcomeMessage.setText("What kind of a Property you want to add?");
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(welcomeMessage, apartmentButton, condoButton, houseButton);
		gridbottom.getChildren().addAll(backToMainmenu);
		border.setCenter(layout);
		border.setBottom(gridbottom);
		Scene scene = new Scene(border, MenuHeight, MenuWidth);
		mainMenu.setScene(scene);
		mainMenu.show();
	}

	public void addPropertyDetails(Stage mainMenu, int buildingType) throws Exception {
		mainMenu.setTitle("Adding a Property");
		BorderPane border = new BorderPane();
		Label helpingTextLabel = new Label();
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setVgap(8);
		grid.setHgap(10);
		RentalCompanyBuildingWrapper rentalWrapper = new RentalCompanyBuildingWrapper();
		int gridSizePanning = 1;
		Label streetNameLabel = new Label("STREET NAME");
		Label cityLabel = new Label("CITY");
		Label provinceLabel = new Label("PROVINCE");
		Label postalCodeLabel = new Label("POSTAL CODE");
		Label squareFeetLabel = new Label("SQUARE FEET");
		Label totalBathroomsLabel = new Label("TOTAL BATHROOMS");
		Label totalBedroomsLabel = new Label("TOTAL BEDROOMS");
		TextField streetNameField = new TextField();
		streetNameField.setPromptText("CIVIC ADDRESS");
		TextField cityField = new TextField();
		cityField.setPromptText("CITY");
		TextField provinceField = new TextField();
		provinceField.setPromptText("PROVINCE");
		TextField postalCodeField = new TextField();
		postalCodeField.setPromptText("POSTAL CODE");
		TextField squareFeetField = new TextField();
		squareFeetField.setPromptText("SQUARE FEET");
		TextField totalBathroomsField = new TextField();
		totalBathroomsField.setPromptText("NO OF BATHROOMS");
		TextField totalBedroomsField = new TextField();
		totalBedroomsField.setPromptText("NO OF BEDROOMS");
		TextField civicAddressField = new TextField();
		civicAddressField.setPromptText("CIVIC ADDRESS");
		TextField apartmentNumberField = new TextField();
		apartmentNumberField.setPromptText("APARTMENT NUMBER");
		TextField streetNumberField = new TextField();
		streetNumberField.setPromptText("STREET NUMBER");
		TextField unitNumberField = new TextField();
		unitNumberField.setPromptText("UNIT NUMBER");
		Label streetNumberLabel = new Label("STREET NUMBER");
		Label unitNumberLabel = new Label("UNIT NUMBER");
		Label civicAddressLabel = new Label("CIVIC ADDRESS");
		Label apartmentNumberLabel = new Label("APARTMENT NUMBER");
		civicAddressField.setDisable(true);
		civicAddressField.setEditable(false);
		apartmentNumberField.setEditable(false);
		apartmentNumberField.setDisable(true);
		streetNumberField.setEditable(false);
		streetNumberField.setDisable(true);
		unitNumberField.setDisable(true);
		unitNumberField.setEditable(false);
		grid.setConstraints(civicAddressLabel, 0, gridSizePanning);
		grid.setConstraints(civicAddressField, 1, gridSizePanning++);
		grid.setConstraints(apartmentNumberLabel, 0, gridSizePanning);
		grid.setConstraints(apartmentNumberField, 1, gridSizePanning++);
		grid.setConstraints(streetNumberLabel, 0, gridSizePanning);
		grid.setConstraints(streetNumberField, 1, gridSizePanning++);
		grid.setConstraints(unitNumberLabel, 0, gridSizePanning);
		grid.setConstraints(unitNumberField, 1, gridSizePanning++);
		if (buildingType == ApartmentTypeID) {
			helpingTextLabel.setText("Please enter the following details for the Apartment");
			civicAddressField.setEditable(true);
			civicAddressField.setDisable(false);
			apartmentNumberField.setEditable(true);
			apartmentNumberField.setDisable(false);
			rentalWrapper.setBuildingType(buildingType);
			grid.setConstraints(helpingTextLabel, 0, 0);
			grid.getChildren().addAll(helpingTextLabel);
		} else if (buildingType == CondoTypeID) {
			helpingTextLabel.setText("Please enter the following details for the Condo");
			streetNumberField.setEditable(true);
			streetNumberField.setDisable(false);
			unitNumberField.setDisable(false);
			unitNumberField.setEditable(true);
			rentalWrapper.setBuildingType(buildingType);

			grid.setConstraints(helpingTextLabel, 0, 0);
			grid.getChildren().addAll(helpingTextLabel);
		} else if (buildingType == HouseTypeID) {
			helpingTextLabel.setText("Please enter the following details for the House");
			streetNumberField.setEditable(true);
			streetNumberField.setDisable(false);
			rentalWrapper.setBuildingType(buildingType);
			grid.setConstraints(helpingTextLabel, 0, 0);
			grid.getChildren().addAll(helpingTextLabel);
		}
		grid.setConstraints(streetNameLabel, 0, gridSizePanning);
		grid.setConstraints(streetNameField, 1, gridSizePanning++);
		grid.setConstraints(cityLabel, 0, gridSizePanning);
		grid.setConstraints(cityField, 1, gridSizePanning++);
		grid.setConstraints(provinceLabel, 0, gridSizePanning);
		grid.setConstraints(provinceField, 1, gridSizePanning++);
		grid.setConstraints(postalCodeLabel, 0, gridSizePanning);
		grid.setConstraints(postalCodeField, 1, gridSizePanning++);
		grid.setConstraints(squareFeetLabel, 0, gridSizePanning);
		grid.setConstraints(squareFeetField, 1, gridSizePanning++);
		grid.setConstraints(totalBathroomsLabel, 0, gridSizePanning);
		grid.setConstraints(totalBathroomsField, 1, gridSizePanning++);
		grid.setConstraints(totalBedroomsLabel, 0, gridSizePanning);
		grid.setConstraints(totalBedroomsField, 1, gridSizePanning++);

		grid.getChildren().addAll(civicAddressLabel, civicAddressField, apartmentNumberLabel, apartmentNumberField,
				streetNumberLabel, streetNumberField, unitNumberLabel, unitNumberField, streetNameLabel,
				streetNameField, cityLabel, cityField, provinceLabel, provinceField, postalCodeLabel, postalCodeField,
				squareFeetLabel, squareFeetField, totalBathroomsLabel, totalBathroomsField, totalBedroomsLabel,
				totalBedroomsField);
		submit = new Button("Submit");
		backToMainmenu = new Button("Back to Main Menu");
		backToMainmenu.setMaxWidth(MAX_WIDTH);
		backToMainmenu.setAlignment(Pos.BOTTOM_LEFT);
		backToMainmenu.setOnAction(e -> {
			mainMenu.setScene(mainMenuScene);
		});
		submit.setMaxWidth(MAX_WIDTH);
		submit.setAlignment(Pos.BOTTOM_RIGHT);
		submit.setOnAction(e -> {
			streetName = streetNameField.getText();
			city = cityField.getText();
			province = provinceField.getText();
			postalCode = postalCodeField.getText();
			noOfBedrooms = Integer.parseInt(totalBedroomsField.getText());
			noOfBathrooms = Integer.parseInt(totalBathroomsField.getText());
			sqFt = Double.parseDouble(squareFeetField.getText());
			if (buildingType == HouseTypeID) {
				rentalWrapper.setStreetNumber(Integer.parseInt(streetNumberField.getText()));
			}
			if (buildingType == ApartmentTypeID) {
				rentalWrapper.setCivicAddress(civicAddressField.getText());
				rentalWrapper.setApartmentNumber(Integer.parseInt(apartmentNumberField.getText()));
			}
			if (buildingType == CondoTypeID) {
				rentalWrapper.setStreetNumber(Integer.parseInt(streetNumberField.getText()));
				rentalWrapper.setUnitNumber(Integer.parseInt(unitNumberField.getText()));
			}
			try {Runnable task1=new Runnable() {
				@Override
				public void run() {
					
					String s=Platform.isFxApplicationThread()?" JavaFx Thread":" Background Add Properties Thread";
					System.out.println("Current thread is"+s);
					buildingId = rentController.getBuildingId(buildingType) + 1;
					rentalWrapper.setBuildingId(buildingId);
					rentalWrapper.setCity(city);
					rentalWrapper.setNoOfBathrooms(noOfBathrooms);
					rentalWrapper.setNoOfBedrooms(noOfBedrooms);
					rentalWrapper.setPostalCode(postalCode);
					rentalWrapper.setProvince(province);
					rentalWrapper.setRented(Boolean.FALSE);
					rentalWrapper.setSqFt(sqFt);
					rentalWrapper.setStreetName(streetName);
					rentalWrapper.setCity(city);
					rentalWrapper.setBuildingType(buildingType);
					boolean result=rentController.addProperty(rentalWrapper);
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							try {
								String s=Platform.isFxApplicationThread()?" JavaFx Thread":"Background Add Properties Thread";
								System.out.println("Current thread is"+s);
								if(result) {
									alertBoxes.displayAlert("Alert!", "Successfully submitted");
									resetValues();
									mainMenu.setScene(mainMenuScene);
								}else {
									alertBoxes.displayAlert("Alert!", "Something went wrong  :( ");
									resetValues();
									mainMenu.setScene(mainMenuScene);
									
								}
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
			
				}};
				new Thread(task1).start();
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
		GridPane gridbottom = new GridPane();
		gridbottom.setPadding(new Insets(20, 20, 20, 20));
		gridbottom.setVgap(8);
		gridbottom.setHgap(10);
		gridbottom.setConstraints(backToMainmenu, 0, 0);
		gridbottom.setConstraints(submit, 55, 0);
//		StackPane stackPaneBottomRight = new StackPane();
//		stackPaneBottomRight.setMaxWidth(200);
//		stackPaneBottomRight.setMaxHeight(20);
//		stackPaneBottomRight.setAlignment(Pos.BOTTOM_RIGHT);
//		VBox layout = new VBox(25);
//		layout.setSpacing(10);
//		layout.setAlignment(Pos.CENTER);
//		stackPane.getChildren().addAll(backToMainmenu);
//		stackPaneBottomRight.getChildren().addAll(submit);
		gridbottom.getChildren().addAll(backToMainmenu, submit);
		border.setCenter(grid);
		border.setBottom(gridbottom);
		Scene scene = new Scene(border, MenuHeight, MenuWidth);

		mainMenu.setScene(scene);
		mainMenu.show();
	}

	public void addTenant(Stage mainMenu) throws Exception {
		BorderPane border = new BorderPane();
		Label helpingTextLabel = new Label();
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setVgap(8);
		grid.setHgap(10);

		int gridSizePanning = 1;
		Label nameLabel = new Label("FULL NAME");
		Label ageLabel = new Label("AGE");
		Label phoneNumberLabel = new Label("PHONE NUMBER");
		Label emailIdLabel = new Label("EMAIL ID");
		Label preferredBuildingLabel = new Label("PREFERRED BUILDING");
		helpingTextLabel.setText("Please enter the following details for adding a new Tenant");
		grid.setConstraints(helpingTextLabel, 0, gridSizePanning++);
		TextField nameField = new TextField();
		nameField.setPromptText("FULL NAME");
		TextField ageField = new TextField();
		ageField.setPromptText("AGE");
		TextField phoneNumberField = new TextField();
		phoneNumberField.setPromptText("PHONE NUMBER");
		TextField emailIdField = new TextField();
		emailIdField.setPromptText("EMAIL ID");
		TextField preferredBuildingField = new TextField();
		preferredBuildingField.setPromptText("BUILDING ID");
		grid.setConstraints(nameLabel, 0, gridSizePanning);
		grid.setConstraints(nameField, 1, gridSizePanning++);
		grid.setConstraints(ageLabel, 0, gridSizePanning);
		grid.setConstraints(ageField, 1, gridSizePanning++);
		grid.setConstraints(phoneNumberLabel, 0, gridSizePanning);
		grid.setConstraints(phoneNumberField, 1, gridSizePanning++);
		grid.setConstraints(emailIdLabel, 0, gridSizePanning);
		grid.setConstraints(emailIdField, 1, gridSizePanning++);
		grid.setConstraints(preferredBuildingLabel, 0, gridSizePanning);
		grid.setConstraints(preferredBuildingField, 1, gridSizePanning++);
		grid.getChildren().addAll(helpingTextLabel, nameLabel, nameField, ageLabel, ageField, phoneNumberLabel,
				phoneNumberField, emailIdLabel, emailIdField, preferredBuildingLabel, preferredBuildingField);
		mainMenu.setTitle("ADDING A TENANT");

		backToMainmenu = new Button("Back to Main Menu");
		backToMainmenu.setMaxWidth(MAX_WIDTH);
		backToMainmenu.setAlignment(Pos.BOTTOM_LEFT);
		backToMainmenu.setOnAction(e -> {
			mainMenu.setScene(mainMenuScene);
		});
		submit = new Button("Submit");
		submit.setMaxWidth(MAX_WIDTH);
		submit.setAlignment(Pos.BOTTOM_RIGHT);
		submit.setOnAction(e -> {
			
			tenantInfo = new TenantInformation();
			Runnable task=new Runnable() {
				@Override
				public void run() {
					String s=Platform.isFxApplicationThread()?" JavaFx Thread":" Background Add Tenant Thread";
					System.out.println("Current thread is"+s);
			Long tenantId = rentController.getTenantId();
			  Name = nameField.getText() ;
			  Age = Integer.parseInt(ageField.getText());
			  phoneNumber = Long.parseLong(phoneNumberField.getText());
			  emailId = emailIdField.getText();
			  preferredBuildingId = Long.parseLong(preferredBuildingField.getText());
			tenantInfo.setTenantId(tenantId);
			tenantInfo.setName(Name);
			tenantInfo.setAge(Age);
			tenantInfo.setPhoneNumber(phoneNumber);
			tenantInfo.setEmailId(emailId);
			tenantInfo.setPreferredBuildingId(preferredBuildingId);
			
			
			boolean result=rentController.addTenant(tenantInfo);
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					try {
						String s=Platform.isFxApplicationThread()?" JavaFx Thread":"Background Add Tenant Thread";
						System.out.println("Current thread is"+s);
						if (result) {

							alertBoxes.displayAlert("Alert!", "Successfully submitted");
							mainMenu.setScene(mainMenuScene);
						} else {
							
							alertBoxes.displayAlert("Alert!", "Tenant not Added");
							mainMenu.setScene(mainMenuScene);
						}
						;
					
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
		}
	};
	new Thread(task).start();

			
		});
		GridPane gridbottom = new GridPane();
		gridbottom.setPadding(new Insets(20, 20, 20, 20));
		gridbottom.setVgap(8);
		gridbottom.setHgap(10);
		gridbottom.setConstraints(backToMainmenu, 0, 0);
		gridbottom.setConstraints(submit, 55, 0);
		gridbottom.getChildren().addAll(backToMainmenu, submit);
		border.setCenter(grid);
		border.setBottom(gridbottom);

		Scene scene = new Scene(border, MenuHeight, MenuWidth);

		mainMenu.setScene(scene);
		mainMenu.show();
	}

	public void rentAUnit(Stage mainMenu, int buildingType) throws Exception {
		BorderPane border = new BorderPane();
		Label helpingTextLabel = new Label();
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setVgap(8);
		grid.setHgap(10);
		int gridSizePanning = 1;
		TextField civicAddressField = new TextField();
		civicAddressField.setPromptText("CIVIC ADDRESS");
		TextField apartmentNumberField = new TextField();
		apartmentNumberField.setPromptText("APARTMENT NUMBER");
		TextField  streetNumberField = new TextField();
		streetNumberField.setPromptText("STREET NUMBER");
		TextField  unitNumberField = new TextField();
		unitNumberField.setPromptText("UNIT NUMBER");
		Label streetNumberLabel = new Label("STREET NUMBER");
		Label unitNumberLabel = new Label("UNIT NUMBER");
		Label civicAddressLabel = new Label("CIVIC ADDRESS");
		Label apartmentNumberLabel = new Label("APARTMENT NUMBER");
		civicAddressField.setDisable(true);
		civicAddressField.setEditable(false);
		apartmentNumberField.setEditable(false);
		apartmentNumberField.setDisable(true);
		streetNumberField.setEditable(false);
		streetNumberField.setDisable(true);
		unitNumberField.setDisable(true);
		unitNumberField.setEditable(false);
		Label tenantPhoneNumberLabel = new Label("TENANT PHONE NUMBER");
		Label leaseStartLabel = new Label("LEASE START DATE");
		Label leaseEndLabel = new Label("LEASE END DATE");
		Label rentAmountLabel = new Label("RENT AMOUNT");
		TextField tenantPhoneNumberField = new TextField();
		tenantPhoneNumberField.setPromptText("TENANT PHONE NUMBER");
		TextField leaseStartField = new TextField();
		leaseStartField.setPromptText("DD/MM/YYYY");
		TextField leaseEndField = new TextField();
		leaseEndField.setPromptText("DD/MM/YYYY");
		TextField rentAmountField = new TextField();
		rentAmountField.setPromptText("RENT AMOUNT");
		tenantPhoneNumberLabel.setVisible(false);
		tenantPhoneNumberField.setVisible(false);
		leaseEndField.setVisible(false);
		leaseEndLabel.setVisible(false);
		leaseStartField.setVisible(false);
		leaseStartLabel.setVisible(false);
		rentAmountLabel.setVisible(false);
		rentAmountField.setVisible(false);
		grid.setConstraints(civicAddressLabel, 0, gridSizePanning);
		grid.setConstraints(civicAddressField, 1, gridSizePanning++);
		grid.setConstraints(apartmentNumberLabel, 0, gridSizePanning);
		grid.setConstraints(apartmentNumberField, 1, gridSizePanning++);
		grid.setConstraints(streetNumberLabel, 0, gridSizePanning);
		grid.setConstraints(streetNumberField, 1, gridSizePanning++);
		grid.setConstraints(unitNumberLabel, 0, gridSizePanning);
		grid.setConstraints(unitNumberField, 1, gridSizePanning++);
		grid.setConstraints(tenantPhoneNumberLabel, 0, gridSizePanning);
		grid.setConstraints(tenantPhoneNumberField, 1, gridSizePanning++);
		grid.setConstraints(leaseStartLabel, 0, gridSizePanning);
		grid.setConstraints(leaseStartField, 1, gridSizePanning++);
		grid.setConstraints(leaseEndLabel, 0, gridSizePanning);
		grid.setConstraints(leaseEndField, 1, gridSizePanning++);
		grid.setConstraints(rentAmountLabel, 0, gridSizePanning);
		grid.setConstraints(rentAmountField, 1, gridSizePanning++);

		mainMenu.setTitle("Renting Properties");
		if (buildingType == ApartmentTypeID) {
			helpingTextLabel.setText("Please enter the following details for the Apartment");
			civicAddressField.setDisable(false);
			civicAddressField.setEditable(true);
			apartmentNumberField.setEditable(true);
			apartmentNumberField.setDisable(false);
			grid.setConstraints(helpingTextLabel, 0, 0);
			grid.getChildren().addAll();
		} else if (buildingType == CondoTypeID) {
			helpingTextLabel.setText("Please enter the following details for the Condo");
			streetNumberField.setEditable(true);
			streetNumberField.setDisable(false);
			unitNumberField.setDisable(false);
			unitNumberField.setEditable(true);
			grid.setConstraints(helpingTextLabel, 0, 0);
		} else if (buildingType == HouseTypeID) {
			helpingTextLabel.setText("Please enter the following details for the House");
			streetNumberField.setEditable(true);
			streetNumberField.setDisable(false);
			grid.setConstraints(helpingTextLabel, 0, 0);
		}


		grid.getChildren().addAll(helpingTextLabel, civicAddressLabel, civicAddressField, apartmentNumberLabel,
				apartmentNumberField,streetNumberLabel, streetNumberField, unitNumberLabel,
				unitNumberField,tenantPhoneNumberLabel, tenantPhoneNumberField, leaseStartLabel, leaseStartField,
				leaseEndLabel, leaseEndField, rentAmountLabel, rentAmountField);
		leaseInformation = new LeaseInformation();
		mainMenu.setTitle("RENTING A TENANT");
		submit = new Button("Submit");
		submit.setDisable(true);
		backToMainmenu = new Button("Back to Main Menu");
		backToMainmenu.setMaxWidth(200);
		backToMainmenu.setAlignment(Pos.BOTTOM_LEFT);
		backToMainmenu.setOnAction(e -> {
			mainMenu.setScene(mainMenuScene);
		});
		Button checkTenantButton = new Button("Check Tenant");
		checkTenantButton.setMaxWidth(200);
		checkTenantButton.setAlignment(Pos.BOTTOM_LEFT);
		checkTenantButton.setDisable(true);
		Button checkAvailabilityButton = new Button("Check Availability");
		checkAvailabilityButton.setMaxWidth(200);
		checkAvailabilityButton.setAlignment(Pos.BOTTOM_LEFT);
		
		checkAvailabilityButton.setOnAction(e -> {
			
			if (buildingType == ApartmentTypeID) {
				Runnable task=new Runnable() {
					@Override
					public void run() {
						String s=Platform.isFxApplicationThread()?" JavaFx Thread":" Background Rent Unit check Avail btn Thread";
						System.out.println("Current thread is"+s);
				apartmentUnit = rentController.checkAptAvailability( civicAddressField.getText() ,Integer.parseInt(apartmentNumberField.getText()));
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						try {
							String s=Platform.isFxApplicationThread()?" JavaFx Thread":"Background Rent Unit check Avail btn Thread";
							System.out.println("Current thread is"+s);
				if (apartmentUnit.getCivicAddress() != null ) {
					if(apartmentUnit.isRented() == false) {
					isPresent = true;
					buildingId = apartmentUnit.getBuildingId();
					leaseInformation.setCivicAddress(apartmentUnit.getCivicAddress());
					leaseInformation.setApartmentNumber(apartmentUnit.getApartmentNumber());
				} else {
					isRented = true;
					alertBoxes.displayAlert("Failure", "Requested apartment is currently unavailable");
					mainMenu.setScene(mainMenuScene);
				}
				}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						 if (isPresent == true && isRented == false) {
								tenantPhoneNumberLabel.setVisible(true);
								tenantPhoneNumberField.setVisible(true);
								checkTenantButton.setDisable(false);
							}else if((isPresent == false && isRented == false)) {
								alertBoxes.displayAlert("Failure", "Requested Unit is not in our Directory");
								mainMenu.setScene(mainMenuScene);
							}	
					}
				});
				
			}
				};
				new Thread(task).start();
		}
		
					
						
			 if (buildingType == CondoTypeID) {
				 Runnable taskCondo=new Runnable() {
						@Override
						public void run() {
							String s=Platform.isFxApplicationThread()?" JavaFx Thread":" Background Rent Unit check Avail btn Thread";
							System.out.println("Current thread is"+s);
				condoUnit = rentController.checkCondoAvailability(Integer.parseInt(streetNumberField.getText()),Integer.parseInt(unitNumberField.getText()));
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						try {
							String s=Platform.isFxApplicationThread()?" JavaFx Thread":"Background Rent Unit check Avail btn Thread";
							System.out.println("Current thread is"+s);
				if (condoUnit.getPostalCode() != null ) {
				if(condoUnit.isRented() == false) {
					isPresent = true;
					leaseInformation.setStreetNumber(condoUnit.getStreetNumber());
					leaseInformation.setUnitNumber(condoUnit.getUnitNumber());
					buildingId = condoUnit.getBuildingId();
				} else {
					isRented = true;
					alertBoxes.displayAlert("Failure", "Requested condo is currently unavailable");
					mainMenu.setScene(mainMenuScene);
				}
				}
			 }
					 catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						 if (isPresent == true && isRented == false) {
								tenantPhoneNumberLabel.setVisible(true);
								tenantPhoneNumberField.setVisible(true);
								checkTenantButton.setDisable(false);
							}else if((isPresent == false && isRented == false)) {
								alertBoxes.displayAlert("Failure", "Requested Unit is not in our Directory");
								mainMenu.setScene(mainMenuScene);
							}	
				}
			});
			
		}
			};
			new Thread(taskCondo).start();
	}
				
					
			 if (buildingType == HouseTypeID) {

					Runnable taskHouse=new Runnable() {
						@Override
						public void run() {
							String s=Platform.isFxApplicationThread()?" JavaFx Thread":" Background Rent Unit check Avail btn Thread";
							System.out.println("Current thread is"+s);
				 houseUnit = rentController.checkHouseAvailability(Integer.parseInt(streetNumberField.getText()));
				 Platform.runLater(new Runnable() {
						@Override
						public void run() {
							try {
								String s=Platform.isFxApplicationThread()?" JavaFx Thread":"Background Rent Unit check Avail btn Thread";
								System.out.println("Current thread is"+s);
				if (houseUnit.getPostalCode() != null ) {	
			 if (houseUnit.isRented() == false) {
					isPresent = true;
					leaseInformation.setStreetNumber(houseUnit.getStreetNumber());
					buildingId = houseUnit.getBuildingId();
				}
			 else {
					isRented = true;
					alertBoxes.displayAlert("Failure", "Requested house is currently unavailable");
					mainMenu.setScene(mainMenuScene);
				}
				}
			 }catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
							 if (isPresent == true && isRented == false) {
									tenantPhoneNumberLabel.setVisible(true);
									tenantPhoneNumberField.setVisible(true);
									checkTenantButton.setDisable(false);
								}else if((isPresent == false && isRented == false)) {
									alertBoxes.displayAlert("Failure", "Requested Unit is not in our Directory");
									mainMenu.setScene(mainMenuScene);
								}	
						}
					});
					
				}
			};
			Thread t = new  Thread();
					
			new Thread(taskHouse).start();
					}

				
		});
		
		checkTenantButton.setOnAction(e -> {
			Runnable task=new Runnable() {
				@Override
				public void run() {
					String s=Platform.isFxApplicationThread()?" JavaFx Thread":" Background Unit Renting Check Tenant Thread";
					System.out.println("Current thread is"+s);
			tenantInfo = rentController.getTenantByPhoneNumber(Long.parseLong(tenantPhoneNumberField.getText()));
			
			 Platform.runLater(new Runnable() {
			@Override
			public void run() {
				String s=Platform.isFxApplicationThread()?" JavaFx Thread":" Background Unit Renting Check Tenant Thread";
				System.out.println("Current thread is"+s);
						try {
			if (isPresent == true && isRented == false) {
					if(tenantInfo.getName() != null) {
					leaseEndField.setVisible(true);
					leaseEndLabel.setVisible(true);
					leaseStartField.setVisible(true);
					leaseStartLabel.setVisible(true);
					rentAmountLabel.setVisible(true);
					rentAmountField.setVisible(true);
					submit.setDisable(false);
				} else {
					
					alertBoxes.displayAlert("Failure", "Entered tenant does not exist. Please add the tenant before renting");
					mainMenu.setScene(mainMenuScene);
				}
				System.out.println();
			} else if (isRented == false && isPresent == false) {
				alertBoxes.displayAlert("Failure", "Entered property does not exist. Please add the property before renting");
				mainMenu.setScene(mainMenuScene);
			
			} 
						}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	});
	
}
};
new Thread(task).start();	
});
		submit.setMaxWidth(200);
		submit.setAlignment(Pos.BOTTOM_RIGHT);
		// lease id not updated
		submit.setOnAction(e -> {
			Runnable task=new Runnable() {
				@Override
				public void run() {
					String s=Platform.isFxApplicationThread()?" JavaFx Thread":" Background Unit Rent Submit Button Thread";
					System.out.println("Current thread is"+s);
			Long leaseId = rentController.getLeaseId();
			leaseStart = leaseStartField.getText();
			leaseEnd = leaseEndField.getText();
			rentAmount = Float.parseFloat(rentAmountField.getText());
			LocalDate LeaseStartDate = LocalDate.parse(leaseStart, formatter);

			LocalDate LeaseEndDate = LocalDate.parse(leaseEnd, formatter);
			
			tenantInfo.setPreferredBuildingId(0);
			tenantInfo.setLeaseId(leaseId);
			leaseInformation.setTenantInfo(tenantInfo);

			leaseInformation.setLeaseId(leaseId);
			leaseInformation.setLeaseStartDate(LeaseStartDate);
			leaseInformation.setLeaseEndDate(LeaseEndDate);
			leaseInformation.setRentAmount(rentAmount);
			boolean result=rentController.addLease(leaseInformation, buildingType, buildingId);
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					try {
						String s=Platform.isFxApplicationThread()?" JavaFx Thread":"Background Unit Rent Submit Button Thread";
						System.out.println("Current thread is"+s);
			if(result) {
				alertBoxes.displayAlert("Successful", "Lease successfully created");
				Runnable innerTask=new Runnable() {
					@Override
					public void run() {
						String s=Platform.isFxApplicationThread()?" JavaFx Thread":" Background Unit Rent Submit Btn Inner Thread";
						System.out.println("Current thread is"+s);
				rentController.setRentStatus(Boolean.TRUE, buildingId, buildingType, leaseInformation.getLeaseId());
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						try {
							String s=Platform.isFxApplicationThread()?" JavaFx Thread":"Background Unit Rent Submit Btn Inner Thread";
							System.out.println("Current thread is"+s);
				mainMenu.setScene(mainMenuScene);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
			}
		};
		new Thread(innerTask).start();
			}
			else {
				alertBoxes.displayAlert("Failure", "Lease was not created");
				mainMenu.setScene(mainMenuScene);
			}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
		}
	};
	new Thread(task).start();
			
		});
		GridPane gridbottom = new GridPane();
		gridbottom.setPadding(new Insets(20, 20, 20, 20));
		gridbottom.setVgap(8);
		gridbottom.setHgap(10);
		gridbottom.setConstraints(backToMainmenu, 0, 0);
		gridbottom.setConstraints(checkAvailabilityButton, 6, 0);
		gridbottom.setConstraints(checkTenantButton,12 , 0);		
		gridbottom.setConstraints(submit, 31, 0);
		gridbottom.getChildren().addAll(backToMainmenu,checkAvailabilityButton,checkTenantButton,submit);
		border.setCenter(grid);
		border.setBottom(gridbottom);

		Scene scene = new Scene(border, MenuHeight, MenuWidth);

		mainMenu.setScene(scene);
		mainMenu.show();
	}

	public void displayTenants(Stage mainMenu) throws Exception {
		mainMenu.setTitle("Display Tenants");
		Runnable task=new Runnable() {
			@Override
			public void run() {
				String s=Platform.isFxApplicationThread()?" JavaFx Thread":" Background Display Tenants Thread";
				System.out.println("Current thread is"+s);
				tenantInfoList = rentController.displayTenants();
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						try {
							String s=Platform.isFxApplicationThread()?" JavaFx Thread":"Background Display Tenants Thread";
							System.out.println("Current thread is"+s);
							tenantsProperties(mainMenu);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
			}
		};
		new Thread(task).start();
	}

	public void displayRentedUnits(Stage mainMenu) throws Exception {
		mainMenu.setTitle("Display Rented Properties");
		Runnable task=new Runnable() {
			@Override
			public void run() {
				String s=Platform.isFxApplicationThread()?" JavaFx Thread":" Background Display Rented Units Thread";
				System.out.println("Current thread is"+s);
				List<House> houseListTemp;
				List<ApartmentUnit> apartmentListTemp;
				List<Condo> condoListTemp;
				apartmentListTemp = rentController.displayRentedApartments();
				condoListTemp = rentController.displayRentedCondos();
				houseListTemp = rentController.displayRentedHouses();
				houseList = new ArrayList<House>();
				condoList = new ArrayList<Condo>();
				apartmentList = new ArrayList<ApartmentUnit>();
				for(House house : houseListTemp) {
					if(house.isRented()) {
						houseList.add(house);
					}
				}
				for(Condo condo : condoListTemp) {
					if(condo.isRented()) {
						condoList.add(condo);
					}
				}
				for(ApartmentUnit apt : apartmentListTemp) {
					if(apt.isRented()) {
						apartmentList.add(apt);
					}
				}
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						try {
							String s=Platform.isFxApplicationThread()?" JavaFx Thread":"Background Display Rented Units Thread";
							System.out.println("Current thread is"+s);
							testPageProperties(mainMenu);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
			}
		};
		new Thread(task).start();
	}

	public void displayVacantUnits(Stage mainMenu) throws Exception {
		mainMenu.setTitle("Display Vacant Properties");
		Runnable task=new Runnable() {
			@Override
			public void run() {
				String s=Platform.isFxApplicationThread()?" JavaFx Thread":" Background Display Vancant Properties Thread";
				System.out.println("Current thread is"+s);
				List<House> houseListTemp;
				List<ApartmentUnit> apartmentListTemp;
				List<Condo> condoListTemp;
				apartmentListTemp = rentController.displayVacantApartments();
				condoListTemp = rentController.displayVacantCondos();
				houseListTemp = rentController.displayVacantHouses();
				houseList = new ArrayList<House>();
				condoList = new ArrayList<Condo>();
				apartmentList = new ArrayList<ApartmentUnit>();
				for(House house : houseListTemp) {
					if(!house.isRented()) {
						houseList.add(house);
					}
				}
				for(Condo condo : condoListTemp) {
					if(!condo.isRented()) {
						condoList.add(condo);
					}
				}
				for(ApartmentUnit apt : apartmentListTemp) {
					if(!apt.isRented()) {
						apartmentList.add(apt);
					}
				}
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						try {
							String s=Platform.isFxApplicationThread()?" JavaFx Thread":"Background Display Vacant Properties Thread";
							System.out.println("Current thread is"+s);
							testPageProperties(mainMenu);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
			}
		};
		new Thread(task).start();

	}

	public synchronized void displayLeases(Stage mainMenu) throws Exception {
		mainMenu.setTitle("Display Leases");
//		List<LeaseInformation> 
		
		Runnable task=new Runnable() {
			@Override
			public void run() {
				String s=Platform.isFxApplicationThread()?" JavaFx Thread":" Background Display Leases Thread";
				System.out.println("Current thread is"+s);
				List<LeaseInformation> leaseInfoListTemp =  rentController.displayLeases();
				leaseInfoList = new ArrayList<LeaseInformation>();
				for (LeaseInformation leaseInformation : leaseInfoListTemp) {
					if (leaseInformation.isActiveFlag()) {
						leaseInfoList.add(leaseInformation);}
					}
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						try {
							String s=Platform.isFxApplicationThread()?" JavaFx Thread":"Background Display Leases Thread";
							System.out.println("Current thread is"+s);
							leaseProperties(mainMenu);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
			}
		};
		new Thread(task).start();
//		button1 =  new Button("WELCOME TO VIRTUAL RENTAL COMPANY");

	}

	public void RentalPaymentDues(Stage mainMenu) throws Exception {
		mainMenu.setTitle("Rental Payment Dues");
		BorderPane border = new BorderPane();
		Label helpingTextLabel = new Label();
		// GridPane grid = new GridPane();
//		grid.setPadding(new Insets(20, 20, 20, 20));
//		grid.setVgap(8);
//		grid.setHgap(10);
		Label welcomeMessage = new Label();
		welcomeMessage.setText("Please select an option");
		Button viewRentalDuesButton = new Button("View Rental Dues");
		Button payDuesButton = new Button("Pay Dues");
		viewRentalDuesButton.setMaxWidth(MAX_WIDTH);
		payDuesButton.setMaxWidth(MAX_WIDTH);
		submit = new Button("Submit");
		backToMainmenu = new Button("Back to Main Menu");
		backToMainmenu.setMaxWidth(MAX_WIDTH);
		backToMainmenu.setAlignment(Pos.BOTTOM_LEFT);
		backToMainmenu.setOnAction(e -> {
			mainMenu.setScene(mainMenuScene);
		});
//		submit.setMaxWidth(MAX_WIDTH);
//		submit.setAlignment(Pos.BOTTOM_RIGHT);
//		submit.setOnAction(e -> {
//			alertBoxes.displayAlert("Alert!", "Successfully submitssted");
//		});
		viewRentalDuesButton.setOnAction(e -> {
			try {
				viewRentalDues(mainMenu);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		payDuesButton.setOnAction(e -> {
			try {
				rentalPayment(mainMenu);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		VBox layout = new VBox(25);
		layout.setSpacing(10);
		mainMenu.setTitle("Viewing/Paying Rental Dues");
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(welcomeMessage, viewRentalDuesButton, payDuesButton);
		GridPane gridbottom = new GridPane();
		gridbottom.setPadding(new Insets(20, 20, 20, 20));
		gridbottom.setVgap(8);
		gridbottom.setHgap(10);
		gridbottom.setConstraints(backToMainmenu, 0, 0);
//		gridbottom.setConstraints(submit, 55, 0);
		gridbottom.getChildren().addAll(backToMainmenu );
		border.setCenter(layout);
		border.setBottom(gridbottom);

		Scene scene = new Scene(border, MenuHeight, MenuWidth);

		mainMenu.setScene(scene);
		mainMenu.show();

	}

	public void rentalPayment(Stage mainMenu) throws Exception {
		BorderPane border = new BorderPane();
		Label helpingTextLabel = new Label();
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setVgap(8);
		grid.setHgap(10);
		int gridSizePanning = 1;
		helpingTextLabel.setText("Please enter the following details to pay for rental unit");
		Label LeaseIdLabel = new Label("LEASE ID");
		TextField LeaseIdField = new TextField();
		LeaseIdField.setPromptText("LEASE ID");

		grid.setConstraints(helpingTextLabel, 0, 0);
		grid.setConstraints(LeaseIdLabel, 0, gridSizePanning);
		grid.setConstraints(LeaseIdField, 1, gridSizePanning++);
		grid.getChildren().addAll(helpingTextLabel, LeaseIdLabel, LeaseIdField);

		mainMenu.setTitle("Payment of Rent");
		// grid.setAlignment(Pos.CENTER);
		GridPane gridbottom = new GridPane();
		gridbottom.setPadding(new Insets(20, 20, 20, 20));
		gridbottom.setVgap(8);
		gridbottom.setHgap(10);

		backToMainmenu = new Button("Back to Main Menu");
		backToMainmenu.setMaxWidth(MAX_WIDTH);
		backToMainmenu.setAlignment(Pos.BOTTOM_LEFT);
		backToMainmenu.setOnAction(e -> {
			mainMenu.setScene(mainMenuScene);
		});

		submit = new Button("Submit");
		submit.setMaxWidth(MAX_WIDTH);
		submit.setAlignment(Pos.BOTTOM_RIGHT);
		submit.setOnAction(e -> {
			long leaseId = Long.parseLong(LeaseIdField.getText());
			Runnable task=new Runnable() {
				@Override
				public void run() {
					String s=Platform.isFxApplicationThread()?" JavaFx Thread":" Background Rental Payment Thread";
					System.out.println("Current thread is"+s);
			boolean result=rentController.payDues(leaseId);
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					try {
						String s=Platform.isFxApplicationThread()?" JavaFx Thread":"Background Rental Payment Thread";
						System.out.println("Current thread is"+s);
						if (result) {

							alertBoxes.displayAlert("Payment Successful", "Payment has been successful");
						} else {
							alertBoxes.displayAlert("Payment Failure", "Payment has failed");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
		}
	};
	new Thread(task).start();
		});
		gridbottom.setConstraints(backToMainmenu, 0, 0);
		gridbottom.setConstraints(submit, 55, 0);
		border.setCenter(grid);
		border.setBottom(gridbottom);
		gridbottom.getChildren().addAll(backToMainmenu, submit);
		Scene scene = new Scene(border, MenuHeight, MenuWidth);

		mainMenu.setScene(scene);
		mainMenu.show();

	}

	public void viewRentalDues(Stage mainMenu) throws Exception {
		
		Runnable task=new Runnable() {
			@Override
			public void run() {
				String s=Platform.isFxApplicationThread()?" JavaFx Thread":" Background Display Rental Dues Thread";
				
				System.out.println("Current thread is : "+s);
				List<LeaseInformation> leaseInfoListTemp =  rentController.displayLeases();
				leaseInfoList = new ArrayList<LeaseInformation>();
				for (LeaseInformation leaseInformation : leaseInfoListTemp) {
					if (!leaseInformation.isRentPaid()) {
						leaseInfoList.add(leaseInformation);}
					}
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						try {
							String s=Platform.isFxApplicationThread()?" JavaFx Thread":"Background Display Rental Dues Thread";
							System.out.println("Current thread is : "+s);
							rentalDuesProperties(mainMenu);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
			}
		};
		new Thread(task).start();
	}

	public void leaseCancel(Stage mainMenu) throws Exception {
		mainMenu.setTitle("Display Properties");
		BorderPane border = new BorderPane();
		Label helpingTextLabel = new Label();
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setVgap(8);
		grid.setHgap(10);
		int gridSizePanning = 1;
		helpingTextLabel.setText("Please enter the following details to cancel the lease");
		Label LeaseIdLabel = new Label("LEASE ID");
		TextField LeaseIdField = new TextField();
		LeaseIdField.setPromptText("LEASE ID");

		grid.setConstraints(helpingTextLabel, 0, 0);
		grid.setConstraints(LeaseIdLabel, 0, gridSizePanning);
		grid.setConstraints(LeaseIdField, 1, gridSizePanning++);
		grid.getChildren().addAll(helpingTextLabel, LeaseIdLabel, LeaseIdField);

		mainMenu.setTitle("Cancelling Lease");
		// grid.setAlignment(Pos.CENTER);
		GridPane gridbottom = new GridPane();
		gridbottom.setPadding(new Insets(20, 20, 20, 20));
		gridbottom.setVgap(8);
		gridbottom.setHgap(10);

		backToMainmenu = new Button("Back to Main Menu");
		backToMainmenu.setMaxWidth(MAX_WIDTH);
		backToMainmenu.setAlignment(Pos.BOTTOM_LEFT);
		backToMainmenu.setOnAction(e -> {
			mainMenu.setScene(mainMenuScene);
		});

		submit = new Button("Submit");
		submit.setMaxWidth(MAX_WIDTH);
		submit.setAlignment(Pos.BOTTOM_RIGHT);
		submit.setOnAction(e -> {
			long leaseId = Long.parseLong(LeaseIdField.getText());
			Runnable task=new Runnable() {
				@Override
				public void run() {
					String s=Platform.isFxApplicationThread()?" JavaFx Thread":" Background Cancel Lease Thread";
					System.out.println("Current thread is"+s);
			boolean result=rentController.cancelLease(leaseId);
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					try {
						String s=Platform.isFxApplicationThread()?" JavaFx Thread":"Background Cancel Lease Thread";
						System.out.println("Current thread is"+s);
						if (result) {

							alertBoxes.displayAlert("Successful", "Lease has been cancelled successfully.");
							Runnable innerLease=new Runnable() {
								@Override
								public void run() {
									String s=Platform.isFxApplicationThread()?" JavaFx Thread":" Background Inner Lease Thread";
									System.out.println("Current thread is"+s);
							List<String> emailIdList = rentController.notifyPotentialTenants(leaseId);
							Platform.runLater(new Runnable() {
								@Override
								public void run() {
									try {
										String s=Platform.isFxApplicationThread()?" JavaFx Thread":"Background Inner Lease Thread";
										System.out.println("Current thread is"+s);
							for(String email : emailIdList) {
								alertBoxes.displayAlert("Successful", "Email has been sent to " + email + " regarding your Rental Preference.");
							}
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							});
							
						}
					};
					new Thread(innerLease).start();
						} else {
							alertBoxes.displayAlert("Failure", "Lease cancel has failed.");
						}
						;
					
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
		}
	};
	new Thread(task).start();
		});
		gridbottom.setConstraints(backToMainmenu, 0, 0);
		gridbottom.setConstraints(submit, 55, 0);
		gridbottom.getChildren().addAll(backToMainmenu, submit);
		border.setCenter(grid);
		border.setBottom(gridbottom);

		Scene scene = new Scene(border, MenuHeight, MenuWidth);

		mainMenu.setScene(scene);
		mainMenu.show();

	}

	public VBox createPageProperties(int pageIndex) {
		BorderPane border = new BorderPane();
		Label helpingTextLabel = new Label();
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setVgap(8);
		grid.setHgap(10);

		int gridSizePanning = 1;
		VBox box = new VBox(5);
		Label streetNameLabel = new Label("STREET NAME");
		Label cityLabel = new Label("CITY");
		Label provinceLabel = new Label("PROVINCE");
		Label postalCodeLabel = new Label("POSTAL CODE");
		Label squareFeetLabel = new Label("SQUARE FEET");
		Label totalBathroomsLabel = new Label("TOTAL BATHROOMS");
		Label buildingIdLabel = new Label("BUILDING ID");
		Label totalBedroomsLabel = new Label("TOTAL BEDROOMS");

		if (pageIndex < apartmentList.size() && apartmentList.size() > 0) {
			VBox element = new VBox();
			ApartmentUnit aptUnit = apartmentList.get(pageIndex);
			helpingTextLabel.setText("APARTMENT");
			Label cityResult = new Label(aptUnit.getCity());
			Label civicAddressResult = new Label(aptUnit.getCivicAddress());
			Label postalCodeResult = new Label(aptUnit.getPostalCode());
			Label provinceResult = new Label(aptUnit.getProvince());
			Label streetNameResult = new Label(aptUnit.getStreetName());
			Label apartmentNumberResult = new Label(Integer.toString(aptUnit.getApartmentNumber()));
			Label buildingIdResult = new Label(Long.toString(aptUnit.getBuildingId()));
			Label bathroomResult = new Label(Integer.toString(aptUnit.getNoOfBathrooms()));
			Label bedRoomResult = new Label(Integer.toString(aptUnit.getNoOfBedrooms()));
			Label squareFeetResult = new Label(Double.toString(aptUnit.getSqFt()));
			Label civicAddressLabel = new Label("CIVIC ADDRESS");
			Label apartmentNumberLabel = new Label("APARTMENT NUMBER");
			grid.setConstraints(helpingTextLabel, 0, 0);
			grid.setConstraints(buildingIdLabel, 0, gridSizePanning);
			grid.setConstraints(buildingIdResult, 1, gridSizePanning++);
			grid.setConstraints(civicAddressLabel, 0, gridSizePanning);
			grid.setConstraints(civicAddressResult, 1, gridSizePanning++);
			grid.setConstraints(apartmentNumberLabel, 0, gridSizePanning);
			grid.setConstraints(apartmentNumberResult, 1, gridSizePanning++);
			grid.setConstraints(streetNameLabel, 0, gridSizePanning);
			grid.setConstraints(streetNameResult, 1, gridSizePanning++);
			grid.setConstraints(cityLabel, 0, gridSizePanning);
			grid.setConstraints(cityResult, 1, gridSizePanning++);
			grid.setConstraints(provinceLabel, 0, gridSizePanning);
			grid.setConstraints(provinceResult, 1, gridSizePanning++);
			grid.setConstraints(postalCodeLabel, 0, gridSizePanning);
			grid.setConstraints(postalCodeResult, 1, gridSizePanning++);
			grid.setConstraints(squareFeetLabel, 0, gridSizePanning);
			grid.setConstraints(squareFeetResult, 1, gridSizePanning++);
			grid.setConstraints(totalBathroomsLabel, 0, gridSizePanning);
			grid.setConstraints(bathroomResult, 1, gridSizePanning++);
			grid.setConstraints(totalBedroomsLabel, 0, gridSizePanning);
			grid.setConstraints(bedRoomResult, 1, gridSizePanning++);
			grid.getChildren().addAll(helpingTextLabel, buildingIdLabel, buildingIdResult, civicAddressLabel,
					civicAddressResult, apartmentNumberLabel, apartmentNumberResult, streetNameLabel, streetNameResult,
					cityLabel, cityResult, provinceLabel, provinceResult, postalCodeLabel, postalCodeResult,
					totalBathroomsLabel, bathroomResult, totalBedroomsLabel, bedRoomResult, squareFeetLabel,
					squareFeetResult);
			box.getChildren().add(grid);

		}
		if (((pageIndex) >= condoSizeStarting) && pageIndex < houseSizeStarting && condoList.size() > 0) {
			helpingTextLabel.setText("CONDO");
			Condo condoUnit = condoList.get(pageIndex - condoSizeStarting);
			Label cityResult = new Label(condoUnit.getCity());
			Label postalCodeResult = new Label(condoUnit.getPostalCode());
			Label provinceResult = new Label(condoUnit.getProvince());
			Label streetNameResult = new Label(condoUnit.getStreetName());
			Label buildingIdResult = new Label(Long.toString(condoUnit.getBuildingId()));
			Label bathroomResult = new Label(Integer.toString(condoUnit.getNoOfBathrooms()));
			Label bedRoomResult = new Label(Integer.toString(condoUnit.getNoOfBedrooms()));
			Label squareFeetResult = new Label(Double.toString(condoUnit.getSqFt()));
			Label streetNumberLabel = new Label("STREET NUMBER");
			Label streetNumberResult = new Label(Integer.toString(condoUnit.getStreetNumber()));
			Label unitNumberLabel = new Label("UNIT NUMBER");
			Label unitNumberResult = new Label(Integer.toString(condoUnit.getUnitNumber()));
			
			grid.setConstraints(helpingTextLabel, 0, 0);
			grid.setConstraints(buildingIdLabel, 0, gridSizePanning);
			grid.setConstraints(buildingIdResult, 1, gridSizePanning++);
			grid.setConstraints(streetNumberLabel, 0, gridSizePanning);
			grid.setConstraints(streetNumberResult, 1, gridSizePanning++);
			grid.setConstraints(unitNumberLabel, 0, gridSizePanning);
			grid.setConstraints(unitNumberResult, 1, gridSizePanning++);
			grid.setConstraints(streetNameLabel, 0, gridSizePanning);
			grid.setConstraints(streetNameResult, 1, gridSizePanning++);
			grid.setConstraints(cityLabel, 0, gridSizePanning);
			grid.setConstraints(cityResult, 1, gridSizePanning++);
			grid.setConstraints(provinceLabel, 0, gridSizePanning);
			grid.setConstraints(provinceResult, 1, gridSizePanning++);
			grid.setConstraints(postalCodeLabel, 0, gridSizePanning);
			grid.setConstraints(postalCodeResult, 1, gridSizePanning++);
			grid.setConstraints(squareFeetLabel, 0, gridSizePanning);
			grid.setConstraints(squareFeetResult, 1, gridSizePanning++);
			grid.setConstraints(totalBathroomsLabel, 0, gridSizePanning);
			grid.setConstraints(bathroomResult, 1, gridSizePanning++);
			grid.setConstraints(totalBedroomsLabel, 0, gridSizePanning);
			grid.setConstraints(bedRoomResult, 1, gridSizePanning++);
			grid.getChildren().addAll(helpingTextLabel, buildingIdLabel, buildingIdResult, streetNumberLabel,
					streetNumberResult, unitNumberLabel, unitNumberResult, streetNameLabel, streetNameResult, cityLabel,
					cityResult, provinceLabel, provinceResult, postalCodeLabel, postalCodeResult, totalBathroomsLabel,
					bathroomResult, totalBedroomsLabel, bedRoomResult, squareFeetLabel, squareFeetResult);
			box.getChildren().add(grid);

		}
		if (((pageIndex) >= houseSizeStarting) && houseList.size() > 0) {
			VBox element = new VBox();
			helpingTextLabel.setText("HOUSE");
			House houseUnit = houseList.get(pageIndex - houseSizeStarting);
			Label cityResult = new Label(houseUnit.getCity());
			Label postalCodeResult = new Label(houseUnit.getPostalCode());
			Label provinceResult = new Label(houseUnit.getProvince());
			Label streetNameResult = new Label(houseUnit.getStreetName());
			Label buildingIdResult = new Label(Long.toString(houseUnit.getBuildingId()));
			Label bathroomResult = new Label(Integer.toString(houseUnit.getNoOfBathrooms()));
			Label bedRoomResult = new Label(Integer.toString(houseUnit.getNoOfBedrooms()));
			Label squareFeetResult = new Label(Double.toString(houseUnit.getSqFt()));
			Label streetNumberLabel = new Label("STREET NUMBER");
			Label streetNumberResult = new Label(Integer.toString(houseUnit.getStreetNumber()));
			grid.setConstraints(helpingTextLabel, 0, 0);
			grid.setConstraints(buildingIdLabel, 0, gridSizePanning);
			grid.setConstraints(buildingIdResult, 1, gridSizePanning++);
			grid.setConstraints(streetNumberLabel, 0, gridSizePanning);
			grid.setConstraints(streetNumberResult, 1, gridSizePanning++);
			grid.setConstraints(streetNameLabel, 0, gridSizePanning);
			grid.setConstraints(streetNameResult, 1, gridSizePanning++);
			grid.setConstraints(cityLabel, 0, gridSizePanning);
			grid.setConstraints(cityResult, 1, gridSizePanning++);
			grid.setConstraints(provinceLabel, 0, gridSizePanning);
			grid.setConstraints(provinceResult, 1, gridSizePanning++);
			grid.setConstraints(postalCodeLabel, 0, gridSizePanning);
			grid.setConstraints(postalCodeResult, 1, gridSizePanning++);
			grid.setConstraints(squareFeetLabel, 0, gridSizePanning);
			grid.setConstraints(squareFeetResult, 1, gridSizePanning++);
			grid.setConstraints(totalBathroomsLabel, 0, gridSizePanning);
			grid.setConstraints(bathroomResult, 1, gridSizePanning++);
			grid.setConstraints(totalBedroomsLabel, 0, gridSizePanning);
			grid.setConstraints(bedRoomResult, 1, gridSizePanning++);
			grid.getChildren().addAll(helpingTextLabel, buildingIdLabel, buildingIdResult, streetNumberLabel,
					streetNumberResult, streetNameLabel, streetNameResult, cityLabel, cityResult, provinceLabel,
					provinceResult, postalCodeLabel, postalCodeResult, totalBathroomsLabel, bathroomResult,
					totalBedroomsLabel, bedRoomResult, squareFeetLabel, squareFeetResult);
			box.getChildren().add(grid);

		}
		return box;

//	        }

	}

	public void resetValues() throws Exception {
		houseList = null;
		apartmentList = null;
		condoList = null;
		leaseInfoList = null;
		tenantInfoList = null;
		apartmentSizeStarting = 0;
		condoSizeStarting = 0;
		houseSizeStarting = 0;
		 streetName = null;
		 city = null;
		 province = null;
		 postalCode = null;
		 noOfBedrooms = 0;
		 noOfBathrooms = 0;
		 sqFt = 0;
		 streetNumber = 0;
		 unitNumber = 0;
		 apartmentNumber = 0;
		 civicAddress = null;
			  tenantPhoneNumber = 0;
			  rentAmount = 0;
			  buildingId = 0;
			   isPresent = false;
			  isRented = false;
			  apartmentUnit = null;
			  condoUnit = null;
			  houseUnit = null;
			  leaseInformation = null;
			  tenantInfo = null;
	}

	public void testPageProperties(Stage mainMenu) throws Exception {
		BorderPane border = new BorderPane();
		AnchorPane anchor = new AnchorPane();
//	         
		if ((apartmentList.size() + condoList.size() + houseList.size()) > 0) {
			pagination = new Pagination((apartmentList.size() + condoList.size() + houseList.size()), 0);
			apartmentSizeStarting = 0;

			condoSizeStarting = apartmentList.size();
			houseSizeStarting = apartmentList.size() + condoList.size();
			AnchorPane.setTopAnchor(pagination, 10.0);
			AnchorPane.setRightAnchor(pagination, 10.0);
			AnchorPane.setBottomAnchor(pagination, 10.0);
			AnchorPane.setLeftAnchor(pagination, 10.0);
			pagination.setPageFactory(new Callback<Integer, Node>() {
				@Override
				public Node call(Integer pageIndex) {
					return createPageProperties(pageIndex);
				}
			});
			anchor.getChildren().addAll(pagination);
			border.setCenter(anchor);
		}

 

		GridPane gridbottom = new GridPane();
		gridbottom.setPadding(new Insets(20, 20, 20, 20));
		gridbottom.setVgap(8);
		gridbottom.setHgap(10);

		backToMainmenu = new Button("Back to Main Menu");
		backToMainmenu.setMaxWidth(MAX_WIDTH);
		backToMainmenu.setAlignment(Pos.BOTTOM_LEFT);
		backToMainmenu.setOnAction(e -> {
			try {
				resetValues();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			mainMenu.setScene(mainMenuScene);
		});
		if ((apartmentList.size() + condoList.size() + houseList.size()) == 0) {
			VBox layout = new VBox(25);
			layout.setSpacing(10);
			Label emptyMessage = new Label();
			emptyMessage.setText("Nothing to display here mate");
			layout.setAlignment(Pos.CENTER);
			layout.getChildren().add(emptyMessage);
			border.setCenter(layout);
		}

		gridbottom.setConstraints(backToMainmenu, 0, 0);

		border.setBottom(gridbottom);
		gridbottom.getChildren().addAll(backToMainmenu);
		Scene scene = new Scene(border, MenuHeight, MenuWidth);

		mainMenu.setScene(scene);
		mainMenu.show();
	}
	
	
	
	public VBox createtenantsProperties(int pageIndex) {
		BorderPane border = new BorderPane();
		Label helpingTextLabel = new Label();
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setVgap(8);
		grid.setHgap(10);

		int gridSizePanning = 1;
		VBox box = new VBox(5);
		Label tenantNameLabel = new Label("NAME");
		Label tenantAgeLabel = new Label("AGE");
		Label tenantEmailIdLabel = new Label("EMAIL ID");
		Label tenantPhoneNumberLabel = new Label("PHONE NUMBER");

		
 
			VBox element = new VBox();
			helpingTextLabel.setText("TENANT INFORMATION");
			TenantInformation tenantInfo = tenantInfoList.get(pageIndex);
			Label tenantNameResult = new Label(tenantInfo.getName());
			Label tenantAgeResult = new Label(Integer.toString(tenantInfo.getAge()));
			Label tenantEmailIdResult = new Label(tenantInfo.getEmailId());
			Label tenantPhoneNumberResult = new Label(Long.toString(tenantInfo.getPhoneNumber()));
			grid.setConstraints(helpingTextLabel, 0, 0);
			grid.setConstraints(tenantNameLabel, 0, gridSizePanning);
			grid.setConstraints(tenantNameResult, 1, gridSizePanning++);
			grid.setConstraints(tenantAgeLabel, 0, gridSizePanning);
			grid.setConstraints(tenantAgeResult, 1, gridSizePanning++);
			grid.setConstraints(tenantEmailIdLabel, 0, gridSizePanning);
			grid.setConstraints(tenantEmailIdResult, 1, gridSizePanning++);
			grid.setConstraints(tenantPhoneNumberLabel, 0, gridSizePanning);
			grid.setConstraints(tenantPhoneNumberResult, 1, gridSizePanning++);
			grid.getChildren().addAll(helpingTextLabel, tenantNameLabel, tenantNameResult, tenantAgeLabel,
					tenantAgeResult, tenantEmailIdLabel, tenantEmailIdResult, tenantPhoneNumberLabel, tenantPhoneNumberResult);
			box.getChildren().add(grid);

		return box;

//	        }

	}
	
	public void tenantsProperties(Stage mainMenu) throws Exception {
		BorderPane border = new BorderPane();
		AnchorPane anchor = new AnchorPane();
//	         
		if ((tenantInfoList.size()) > 0) {
			pagination = new Pagination((tenantInfoList.size()), 0);
			AnchorPane.setTopAnchor(pagination, 10.0);
			AnchorPane.setRightAnchor(pagination, 10.0);
			AnchorPane.setBottomAnchor(pagination, 10.0);
			AnchorPane.setLeftAnchor(pagination, 10.0);
			pagination.setPageFactory(new Callback<Integer, Node>() {
				@Override
				public Node call(Integer pageIndex) {
					return createtenantsProperties(pageIndex);
				}
			});
			anchor.getChildren().addAll(pagination);
			border.setCenter(anchor);
		}

		GridPane gridbottom = new GridPane();
		gridbottom.setPadding(new Insets(20, 20, 20, 20));
		gridbottom.setVgap(8);
		gridbottom.setHgap(10);

		backToMainmenu = new Button("Back to Main Menu");
		backToMainmenu.setMaxWidth(MAX_WIDTH);
		backToMainmenu.setAlignment(Pos.BOTTOM_LEFT);
		backToMainmenu.setOnAction(e -> {
			try {
				resetValues();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			mainMenu.setScene(mainMenuScene);
		});
		if ((tenantInfoList.size()) == 0) {
			VBox layout = new VBox(25);
			layout.setSpacing(10);
			Label emptyMessage = new Label();
			emptyMessage.setText("Nothing to display here mate");
			layout.setAlignment(Pos.CENTER);
			layout.getChildren().add(emptyMessage);
			border.setCenter(layout);
		}

		gridbottom.setConstraints(backToMainmenu, 0, 0);

		border.setBottom(gridbottom);
		gridbottom.getChildren().addAll(backToMainmenu);
		Scene scene = new Scene(border, MenuHeight, MenuWidth);

		mainMenu.setScene(scene);
		mainMenu.show();
	}
	
	
	public VBox createLeaseProperties(int pageIndex) {
		BorderPane border = new BorderPane();
		Label helpingTextLabel = new Label();
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setVgap(8);
		grid.setHgap(10);

		int gridSizePanning = 1;
		VBox box = new VBox(5);
		Label tenantNameLabel = new Label("NAME");
		Label tenantAgeLabel = new Label("AGE");
		Label tenantEmailIdLabel = new Label("EMAIL ID");
		Label tenantPhoneNumberLabel = new Label("PHONE NUMBER");
		Label leaseStartDateLabel = new Label("LEASE START DATE");
		Label leaseEndDateLabel = new Label("LEASE END DATE");
		Label streetNumberLabel = new Label("STREET NUMBER");
		Label unitNumberLabel = new Label("UNIT NUMBER");
		Label civicAddressLabel = new Label("CIVIC ADDRESS");
		Label apartmentNumberLabel = new Label("APARTMENT NUMBER");
		LeaseInformation leaseInformation = leaseInfoList.get(pageIndex);
		VBox element = new VBox();
		helpingTextLabel.setText("LEASE INFORMATION");
		Label tenantNameResult = new Label(leaseInformation.getTenantInfo().getName());
		Label tenantAgeResult = new Label(Integer.toString(leaseInformation.getTenantInfo().getAge()));
		Label tenantEmailIdResult = new Label(leaseInformation.getTenantInfo().getEmailId());
		Label tenantPhoneNumberResult = new Label(Long.toString(leaseInformation.getTenantInfo().getPhoneNumber()));
		Label leaseStartDateResult = new Label(leaseInformation.getLeaseStartDate().toString());
		Label leaseEndDateResult = new Label(leaseInformation.getLeaseEndDate().toString());
		grid.setConstraints(helpingTextLabel, 0, 0);
		grid.setConstraints(tenantNameLabel, 0, gridSizePanning);
		grid.setConstraints(tenantNameResult, 1, gridSizePanning++);
		grid.setConstraints(tenantAgeLabel, 0, gridSizePanning);
		grid.setConstraints(tenantAgeResult, 1, gridSizePanning++);
		grid.setConstraints(tenantEmailIdLabel, 0, gridSizePanning);
		grid.setConstraints(tenantEmailIdResult, 1, gridSizePanning++);
		grid.setConstraints(tenantPhoneNumberLabel, 0, gridSizePanning);
		grid.setConstraints(tenantPhoneNumberResult, 1, gridSizePanning++);
		grid.setConstraints(leaseStartDateLabel, 0, gridSizePanning);
		grid.setConstraints(leaseStartDateResult, 1, gridSizePanning++);
		grid.setConstraints(leaseEndDateLabel, 0, gridSizePanning);
		grid.setConstraints(leaseEndDateResult, 1, gridSizePanning++);
		grid.getChildren().addAll(helpingTextLabel, tenantNameLabel, tenantNameResult, tenantAgeLabel,
				tenantAgeResult, tenantEmailIdLabel, tenantEmailIdResult, tenantPhoneNumberLabel, tenantPhoneNumberResult,leaseStartDateLabel
				,leaseStartDateResult,leaseEndDateLabel,leaseEndDateResult);
		Label buildingTypeLabel= new Label("BUILDING TYPE");
			if (leaseInformation.getBuildingType() == 1) {
				
				Label buildingTypeResult = new Label("APARTMENT");
				Label civicAddressResult = new Label(leaseInformation.getCivicAddress());
				Label apartmentNumberResult = new Label(Integer.toString(leaseInformation.getApartmentNumber()));
				grid.setConstraints(buildingTypeLabel, 0, gridSizePanning);
				grid.setConstraints(buildingTypeResult, 1, gridSizePanning++);
				grid.setConstraints(civicAddressLabel, 0, gridSizePanning);
				grid.setConstraints(civicAddressResult, 1, gridSizePanning++);
				grid.setConstraints(apartmentNumberLabel, 0, gridSizePanning);
				grid.setConstraints(apartmentNumberResult, 1, gridSizePanning++);
				grid.getChildren().addAll(buildingTypeLabel,buildingTypeResult,civicAddressLabel,civicAddressResult,apartmentNumberLabel,apartmentNumberResult);
			} else if (leaseInformation.getBuildingType() == 2) {
				Label buildingTypeResult = new Label("CONDO");
				Label streetNumberResult = new Label(Integer.toString(leaseInformation.getStreetNumber()));
				Label unitNumberResult = new Label(Integer.toString(leaseInformation.getUnitNumber()));
				grid.setConstraints(buildingTypeLabel, 0, gridSizePanning);
				grid.setConstraints(buildingTypeResult, 1, gridSizePanning++);
				grid.setConstraints(streetNumberLabel, 0, gridSizePanning);
				grid.setConstraints(streetNumberResult, 1, gridSizePanning++);
				grid.setConstraints(unitNumberLabel, 0, gridSizePanning);
				grid.setConstraints(unitNumberResult, 1, gridSizePanning++);
				grid.getChildren().addAll(buildingTypeLabel,buildingTypeResult, streetNumberLabel, streetNumberResult, unitNumberLabel,
						unitNumberResult);
			} else if (leaseInformation.getBuildingType() == 3) {
				Label buildingTypeResult = new Label("HOUSE");
				Label streetNumberResult = new Label(Integer.toString(leaseInformation.getStreetNumber()));
				grid.setConstraints(buildingTypeLabel, 0, gridSizePanning);
				grid.setConstraints(buildingTypeResult, 1, gridSizePanning++);
				grid.setConstraints(streetNumberLabel, 0, gridSizePanning);
				grid.setConstraints(streetNumberResult, 1, gridSizePanning++);

				grid.getChildren().addAll(buildingTypeLabel,buildingTypeResult, streetNumberLabel, streetNumberResult);
			}

			box.getChildren().add(grid);
		return box;

//	        }

	}
	
	public void leaseProperties(Stage mainMenu) throws Exception {
		BorderPane border = new BorderPane();
		AnchorPane anchor = new AnchorPane();
//	         
		if ((leaseInfoList.size()) > 0) {
			pagination = new Pagination((leaseInfoList.size()), 0);
			AnchorPane.setTopAnchor(pagination, 10.0);
			AnchorPane.setRightAnchor(pagination, 10.0);
			AnchorPane.setBottomAnchor(pagination, 10.0);
			AnchorPane.setLeftAnchor(pagination, 10.0);
			pagination.setPageFactory(new Callback<Integer, Node>() {
				@Override
				public Node call(Integer pageIndex) {
					return createLeaseProperties(pageIndex);
				}
			});
			anchor.getChildren().addAll(pagination);
			border.setCenter(anchor);
		}
       
		GridPane gridbottom = new GridPane();
		gridbottom.setPadding(new Insets(20, 20, 20, 20));
		gridbottom.setVgap(8);
		gridbottom.setHgap(10);

		backToMainmenu = new Button("Back to Main Menu");
		backToMainmenu.setMaxWidth(MAX_WIDTH);
		backToMainmenu.setAlignment(Pos.BOTTOM_LEFT);
		backToMainmenu.setOnAction(e -> {
			try {
				resetValues();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			mainMenu.setScene(mainMenuScene);
		});
		if ((leaseInfoList .size()) == 0) {
			VBox layout = new VBox(25);
			layout.setSpacing(10);
			Label emptyMessage = new Label();
			emptyMessage.setText("Nothing to display here mate");
			layout.setAlignment(Pos.CENTER);
			layout.getChildren().add(emptyMessage);
			border.setCenter(layout);
		}

		gridbottom.setConstraints(backToMainmenu, 0, 0);

		border.setBottom(gridbottom);
		gridbottom.getChildren().addAll(backToMainmenu);
		Scene scene = new Scene(border, MenuHeight, MenuWidth);
		mainMenu.setScene(scene);
		mainMenu.show();
	}
	public VBox createRentalDuesProperties(int pageIndex) {
		BorderPane border = new BorderPane();
		Label helpingTextLabel = new Label();
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setVgap(8);
		grid.setHgap(10);

		int gridSizePanning = 1;
		VBox box = new VBox(5);
		Label tenantNameLabel = new Label("NAME");
		Label tenantAgeLabel = new Label("AGE");
		Label tenantEmailIdLabel = new Label("EMAIL ID");
		Label tenantPhoneNumberLabel = new Label("PHONE NUMBER");
		Label rentAmountLabel = new Label("RENT AMOUNT");
		LeaseInformation leaseInformation = leaseInfoList.get(pageIndex);
			VBox element = new VBox();
			helpingTextLabel.setText("TENANT INFORMATION");
			LeaseInformation leaseInfo = leaseInfoList.get(pageIndex);
			Label tenantNameResult = new Label(leaseInfo.getTenantInfo().getName());
			Label tenantAgeResult = new Label(Integer.toString(leaseInfo.getTenantInfo().getAge()));
			Label tenantEmailIdResult = new Label(leaseInfo.getTenantInfo().getEmailId());
			Label tenantPhoneNumberResult = new Label(Long.toString(leaseInfo.getTenantInfo().getPhoneNumber()));
			Label rentAmountResult = new Label(Double.toString(leaseInfo.getRentAmount()));
			grid.setConstraints(helpingTextLabel, 0, 0);
			grid.setConstraints(tenantNameLabel, 0, gridSizePanning);
			grid.setConstraints(tenantNameResult, 1, gridSizePanning++);
			grid.setConstraints(tenantAgeLabel, 0, gridSizePanning);
			grid.setConstraints(tenantAgeResult, 1, gridSizePanning++);
			grid.setConstraints(tenantEmailIdLabel, 0, gridSizePanning);
			grid.setConstraints(tenantEmailIdResult, 1, gridSizePanning++);
			grid.setConstraints(tenantPhoneNumberLabel, 0, gridSizePanning);
			grid.setConstraints(tenantPhoneNumberResult, 1, gridSizePanning++);
			grid.setConstraints(rentAmountLabel, 0, gridSizePanning);
			grid.setConstraints(rentAmountResult, 1, gridSizePanning++);
			grid.getChildren().addAll(helpingTextLabel, tenantNameLabel, tenantNameResult, tenantAgeLabel,
					tenantAgeResult, tenantEmailIdLabel, tenantEmailIdResult, tenantPhoneNumberLabel, tenantPhoneNumberResult,rentAmountLabel,rentAmountResult);
			box.getChildren().add(grid);

		return box;

 

	}
	public void rentalDuesProperties(Stage mainMenu) throws Exception {
		BorderPane border = new BorderPane();
		AnchorPane anchor = new AnchorPane();
		if ((leaseInfoList.size()) > 0) {
			pagination = new Pagination((leaseInfoList.size()), 0);
			AnchorPane.setTopAnchor(pagination, 10.0);
			AnchorPane.setRightAnchor(pagination, 10.0);
			AnchorPane.setBottomAnchor(pagination, 10.0);
			AnchorPane.setLeftAnchor(pagination, 10.0);
			pagination.setPageFactory(new Callback<Integer, Node>() {
				@Override
				public Node call(Integer pageIndex) {
					return createRentalDuesProperties(pageIndex);
				}
			});
			anchor.getChildren().addAll(pagination);
			border.setCenter(anchor);
		}
		GridPane gridbottom = new GridPane();
		gridbottom.setPadding(new Insets(20, 20, 20, 20));
		gridbottom.setVgap(8);
		gridbottom.setHgap(10);

		backToMainmenu = new Button("Back to Main Menu");
		backToMainmenu.setMaxWidth(MAX_WIDTH);
		backToMainmenu.setAlignment(Pos.BOTTOM_LEFT);
		backToMainmenu.setOnAction(e -> {
			try {
				resetValues();
			} catch (Exception e1) {
 
				e1.printStackTrace();
			}
			mainMenu.setScene(mainMenuScene);
		});
		if ((leaseInfoList.size()) == 0) {
			VBox layout = new VBox(25);
			layout.setSpacing(10);
			Label emptyMessage = new Label();
			emptyMessage.setText("Nothing to display here mate");
			layout.setAlignment(Pos.CENTER);
			layout.getChildren().add(emptyMessage);
			border.setCenter(layout);
		}

		gridbottom.setConstraints(backToMainmenu, 0, 0);

		border.setBottom(gridbottom);
		gridbottom.getChildren().addAll(backToMainmenu);
		Scene scene = new Scene(border, MenuHeight, MenuWidth);

		mainMenu.setScene(scene);
		mainMenu.show();
	}
}
