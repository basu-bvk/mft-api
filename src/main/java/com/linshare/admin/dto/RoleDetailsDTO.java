package com.linshare.admin.dto;

import java.util.List;

public class RoleDetailsDTO {
	private int id;
	private String roleName;
	private String shortName;
	private String description;
	private boolean isActive;

	// Non Table Fields
	private List<CapabilityDTO> capabilitesList;
	private int usergroupId;
	
	public int getUsergroupId() {
		return usergroupId;
	}

	public void setUsergroupId(int usergroupId) {
		this.usergroupId = usergroupId;
	}

	public List<CapabilityDTO> getCapabilitesList() {
		return capabilitesList;
	}

	public void setCapabilitesList(List<CapabilityDTO> capabilitesList) {
		this.capabilitesList = capabilitesList;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
