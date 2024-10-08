package realEstateCompany.classes;

public class TenantInformation {
	 long tenantId;
	 String Name;
	 int Age;
	 long phoneNumber;
	 String emailId;
	 long preferredBuildingId;
	 long leaseId;
	public long getTenantId() {
		return tenantId;
	}
	public void setTenantId(long tenantId) {
		this.tenantId = tenantId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getPreferredBuildingId() {
		return preferredBuildingId;
	}
	public void setPreferredBuildingId(long preferredBuildingId) {
		this.preferredBuildingId = preferredBuildingId;
	}
	
	public long getLeaseId() {
		return leaseId;
	}
	public void setLeaseId(long leaseId) {
		this.leaseId = leaseId;
	}
	@Override
	public String toString() {
		return "TenantInformation [tenantId=" + tenantId + ", Name=" + Name + ", Age=" + Age + ", phoneNumber="
				+ phoneNumber + ", emailId=" + emailId + ", preferredBuildingId=" + preferredBuildingId + "]";
	}
	public String toFile() {
		return  tenantId +"-"+Name + "-" + Age + "-"+ phoneNumber +"-" + emailId + "-" + preferredBuildingId+"-"+leaseId;
	}
	
}
