package com.gaya.citizen.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Our Citizen Model  or entity class
 * @author Asif
 *
 */


@Entity
@Table(name="citizen_table")
public class Citizen {

	 /**
	  * @Param Id
	  * this will act as unique key or primary key 
	  */
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id; 
	
	
	/**
	 * @Param title
	 *  this will display the title of a person like shri , mis, mr.s 
	 * 
	 */
	@Column(name="title")
    private String title;
	
	/**
	 * @Param first_name
	 * for the first name of the employee
	 */
	@Column(name="first_name")
    private String firstName;
	
	/**
	 * @Param last_name
	 * for storing the last name of  the citizen 
	 * 
	 */
	@Column(name="last_name")
    private String lastName;
	
	
	/**
	 * @Parma
	 *   geneder
	 *   
	 */
	
	@Column(name="gender")
    private String  gender;
	
	/**
	 *  @param dateOfBirth
	 *   this is take store the date of birth of the citizen
	 */
	@Column(name="dob")
    private String dateOfBirth;
	
	/**
	 * @Param 
	 *  Store the email Id of the citizen
	 */
	@Column(name="email")
    private String email;
	
	/**
	 * @Param mobile
	 * to store the mobile number of the citizen  
	 * 
	 */
	@Column(name="mobile")
    private String mobile;
	
	/**
	 * @Param alias 
	 * To store the nick name of the cotizen 
	 */
	@Column(name="alias")
    private String alias;
	
	/**
	 * @Param permanet_addess
	 * thsi is going to store the permanent adderess of  the citizen 
	 */
	@Column(name="permanent_address")
    private String permanentAddress;
	
	/**
	 * @Param zipcode
	 * this will store the zipcode of the citizen permanent address
	 *  
	 */
	@Column(name="zipcode")
    private String pincode;

	/**
	 * no args constructor
	 */
	public Citizen() {
		super();
	}

	
	// below code is written for the getter and  setter of the field
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	
	//code written for the toString method 
	// we have overriden toString method
	@Override
	public String toString() {
		return "Citizen [id=" + id + ", title=" + title + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", mobile=" + mobile
				+ ", alias=" + alias + ", permanentAddress=" + permanentAddress + ", pincode=" + pincode + "]";
	}
    
    		
	
	
}
