package com.linshare.admin.dto;

import java.util.Date;
import java.util.List;

public class UserManageDTO {

	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private int divisionId;
	private boolean isActive;
	private boolean isDeleted;
	private Date createdon;
	private int createdby;
	private Date updatedon;
	private int updatedby;

	// Non Table Fields
	private String divName;
	private List<ApplicationDetailsDTO> appsList;

	public String getDivName() {
		return divName;
	}

	public void setDivName(String divName) {
		this.divName = divName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreatedon() {
		return createdon;
	}

	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public Date getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(Date updatedon) {
		this.updatedon = updatedon;
	}

	public int getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(int updatedby) {
		this.updatedby = updatedby;
	}

	public List<ApplicationDetailsDTO> getAppsList() {
		return appsList;
	}

	public void setAppsList(List<ApplicationDetailsDTO> appsList) {
		this.appsList = appsList;
	}

}
