/**
 * 
 */
package com.komal.studytest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kkadam
 *
 */
public class StreamTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		
		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setName("One");
		
		Address emp1Add1 = new Address();
		emp1Add1.setStreet("One Street1");
		emp1Add1.setPincode("OnePin1");
		emp1Add1.setCity("One Pune1");
		emp1Add1.setStatus(MigrationStatus.DISCOVERED);

		
		Address emp1Add2 = new Address();
		emp1Add2.setStreet("One Street2");
		emp1Add2.setPincode("OnePin2");
		emp1Add2.setCity("One Pune2");
		emp1Add2.setStatus(MigrationStatus.MIGRATED);

		
		emp1.addAddress(emp1Add1);
		emp1.addAddress(emp1Add2);
		
		Employee emp2 = new Employee();
		emp2.setId(2);
		emp2.setName("Two");
		
		Address emp2Add1 = new Address();
		emp2Add1.setStreet("Two Street1");
		emp2Add1.setPincode("TwoPin1");
		emp2Add1.setCity("Two Pune1");
		emp2Add1.setStatus(MigrationStatus.MIGRATED);
		
		Address emp2Add2 = new Address();
		emp2Add2.setStreet("Two Street2");
		emp2Add2.setPincode("TwoPin2");
		emp2Add2.setCity("Two Pune2");
		emp2Add2.setStatus(MigrationStatus.MIGRATING);
		
		emp2.addAddress(emp2Add1);
		emp2.addAddress(emp2Add2);
		employees.add(emp1);
		employees.add(emp2);
		
		employees.stream().flatMap(emp -> emp.getAddresses().stream()).
		filter(server -> !MigrationStatus.MIGRATED.equals(server.getStatus()))
		.forEach(address -> System.out.println(address.getCity()));
		
	}

}

enum MigrationStatus {
	DISCOVERED("Discovered"), INSTALLING_AGENT("Installing Agent"), RETRYING_AGENT_INSTALLATION(
			"Retrying Agent Installation"), AGENT_INSTALLED_SUCCESSFULLY(
			"Agent Installed Successfully"), AGENT_INSTALLATION_FAILED(
			"Agent Installation Failed"), MIGRATING("Migrating"), MIGRATED(
			"Migrated Successfully"), MIGRATION_FAILED("Migration Failed"), MIGRATION_IN_PROGRESS(
			"Migration In Progress"), GET_STATUS_OF_CLIENT_AGENT_INSTALLATION(
			"Get status of the agent installation done by client");

	private String status;

	private MigrationStatus(String value) {
		this.status = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
class Employee {
	private int id;
	
	private String name;
	
	private List<Address> addresses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public void addAddress(Address address) {
		if (this.addresses == null)
			this.addresses = new ArrayList<>();
		this.addresses.add(address);
	}
	
}

class Address {
	private String city;
	
	private String pincode;
	
	private String street;
	
	private MigrationStatus status;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public MigrationStatus getStatus() {
		return status;
	}

	public void setStatus(MigrationStatus status) {
		this.status = status;
	}
}