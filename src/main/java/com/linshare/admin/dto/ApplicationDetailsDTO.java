package com.linshare.admin.dto;

public class ApplicationDetailsDTO {
	private int id;
	private String name;
	private String ShortName;
	private String description;
	private boolean isActive;

	// Non Table Files
	private int userId;
	private String roleName;
	private int roleId;
	private int applicationId;
	private String appName;
	private boolean approvalStatus;
	private String approvalStatusStr;
	
	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	public String getShortName() {
		return ShortName;
	}

	public void setShortName(String shortName) {
		ShortName = shortName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public boolean getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(boolean approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getApprovalStatusStr() {
		return approvalStatusStr;
	}

	public void setApprovalStatusStr(String approvalStatusStr) {
		this.approvalStatusStr = approvalStatusStr;
	}

	@Override
	public String toString() {
		return "ApplicationDetailsDTO [id=" + id + ", name=" + name + ", ShortName=" + ShortName + ", description="
				+ description + ", isActive=" + isActive + ", roleName=" + roleName + ", approvalStatus="
				+ approvalStatus + ", approvalStatusStr=" + approvalStatusStr + "]";
	}

}
