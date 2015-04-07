/**
 * @author Kevin Bohinski <bohinsk1@tcnj.edu>
 * For TrentonWorks
 * @version 1.0
 * @since 2015-4-06
 * 
 * BrokenLights
 * BrokenLightEntry.java
 */

/* Setting Package */
package org.trentonworks.brokenlights;

/* Setting Imports */


public class BrokenLightEntry {

	/* 
	 * Example URL in:
	 * http://45.56.104.253:8080/lightReq/?bl|Light|40.268835|-74.78091|https://i.imgur.com/57YvXwt.jpg|The light is broken|Kevin|Bohinski|5555555555
	 * 
	 * PSE&G Security email:
	 * PSEG-BAandR@pseg.com
	 */
	
	/* Setting Vars */
	private String type;
	private double xCoor;
	private double yCoor;
	private String picLink;
	private String description;
	private String fName;
	private String lName;
	/* Using String for phone number due to the many ways to enter a phone number. */
	private String phone;
	

	/**
	 * Constructor: Creates a new BrokenLightEntry object based on the given input data
	 *
	 * @param type        : What entry's report type (ex: streetlight out, graffiti removal, fallen tree, dangerous building, abandoned automobile...)
	 * @param xCoor       : X Coordinate of the report
	 * @param yCoor       : Y Coordinate of the report
	 * @param picLink     : Link to Amazon S3, with a picture of the report
	 * @param description : Simple user inputed description
	 * @param fName       : Reporter's first name
	 * @param lName       : Reporter's last name
	 * @param phone       : Reporter's phone number
	 */
	public BrokenLightEntry(String type, double xCoor, double yCoor,
			String picLink, String description, String fName, String lName,
			String phone) {
		this.type = type;
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		this.picLink = picLink;
		this.description = description;
		this.fName = fName;
		this.lName = lName;
		this.phone = phone;
		cleanDescription();
	}
	
	/**
	 * Constructor: Creates a new BrokenLightEntry object based on no input data
	 */
	public BrokenLightEntry() {
	}
	
	/* End Constructors */
	
	/**
	 * Cleans the %20's from the html string.
	 */
	private void cleanDescription() {
		description = description.replace("%20", " ");
	}

	/**
	 * toString()
	 * 
	 * @return : The message object in a human readable string.
	 */
	@Override
	public String toString() {
		return "BrokenLightEntry [type=" + type + ", xCoor=" + xCoor
				+ ", yCoor=" + yCoor + ", picLink=" + picLink
				+ ", description=" + description + ", fName=" + fName
				+ ", lName=" + lName + ", phone=" + phone + "]";
	}
	
	/* begin getters and setters */

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the xCoor
	 */
	public double getxCoor() {
		return xCoor;
	}

	/**
	 * @param xCoor the xCoor to set
	 */
	public void setxCoor(double xCoor) {
		this.xCoor = xCoor;
	}

	/**
	 * @return the yCoor
	 */
	public double getyCoor() {
		return yCoor;
	}

	/**
	 * @param yCoor the yCoor to set
	 */
	public void setyCoor(double yCoor) {
		this.yCoor = yCoor;
	}

	/**
	 * @return the picLink
	 */
	public String getPicLink() {
		return picLink;
	}

	/**
	 * @param picLink the picLink to set
	 */
	public void setPicLink(String picLink) {
		this.picLink = picLink;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
		cleanDescription();
	}

	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
		
	/* end getters and setters */
	
} /* end class BrokenLightEntry */
