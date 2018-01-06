package com.linshare.admin.dto;

public class CapabilityDTO {
	private int capabilitiesId;
	private String name;
	private String shortName;
	private String description;
	private int isActive;

	//Non table field
	private int roleId;
	
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public int getCapabilitiesId() {
		return capabilitiesId;
	}

	public void setCapabilitiesId(int capabilitiesId) {
		this.capabilitiesId = capabilitiesId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

}
