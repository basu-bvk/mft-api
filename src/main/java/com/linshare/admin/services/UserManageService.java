package com.linshare.admin.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.linshare.admin.dao.ApplicationDetailsDAO;
import com.linshare.admin.dao.UserManageDAO;
import com.linshare.admin.dto.ApplicationDetailsDTO;
import com.linshare.admin.dto.UserManageDTO;

public class UserManageService {
	UserManageDAO userManageDAO = new UserManageDAO();
	ApplicationDetailsDAO applicationDetailsDAO = new ApplicationDetailsDAO();

	public List<UserManageDTO> selectAllUser() {
		List<Integer> ids = new ArrayList<Integer>();
		List<ApplicationDetailsDTO> tempList = null;
		// 1. getting user details
		List<UserManageDTO> userList1 = userManageDAO.getAllUserList();
		// 2. getting userIds
		for (UserManageDTO user : userList1) {
			ids.add(user.getId());
		}
		// 3. getting mapped apps for selected users
		List<ApplicationDetailsDTO> appList = new ApplicationDetailsDAO().getApplicationsListByUserId(ids);
		for (UserManageDTO user : userList1) {
			for (ApplicationDetailsDTO app : appList) {
				if (user.getId() == app.getUserId()) {
					tempList = new ArrayList<ApplicationDetailsDTO>();
					if (user.getAppsList() != null) {
						tempList = user.getAppsList();
					}
					tempList.add(app);
					user.setAppsList(tempList);
				}
			}
		}
		return userList1;
	}

	public List<UserManageDTO> selectByUserId(String id) {
		List<Integer> ids = new ArrayList<Integer>();
		List<ApplicationDetailsDTO> tempList = null;
		// 1. getting user details
		List<UserManageDTO> userList1 = userManageDAO.getUserListById(id);
		// 2. getting userIds
		for (UserManageDTO user : userList1) {
			ids.add(user.getId());
		}
		// 3. getting mapped apps for selected users
		List<ApplicationDetailsDTO> appList = applicationDetailsDAO.getApplicationsListByUserId(ids);
		for (UserManageDTO user : userList1) {
			for (ApplicationDetailsDTO app : appList) {
				if (user.getId() == app.getUserId()) {
					tempList = new ArrayList<ApplicationDetailsDTO>();
					if (user.getAppsList() != null) {
						tempList = user.getAppsList();
					}
					tempList.add(app);
					user.setAppsList(tempList);
				}
			}
		}
		return userList1;
	}

	public void isDeleteByUserId(String id) {
		userManageDAO.isDeleteUserById(id);
	}

	public void insertUser(UserManageDTO userManageDTO) {
		Date date = new Date();
		userManageDTO.setDeleted(false);
		userManageDTO.setCreatedon(date);
		userManageDTO.setUpdatedon(date);
		
		userManageDTO.setCreatedby(1);
		userManageDTO.setUpdatedby(1);
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		int idUser = 0;
		try {
			idUser = userManageDAO.insertUser(userManageDTO, session);
			List<ApplicationDetailsDTO> appList = userManageDTO.getAppsList();
			for (ApplicationDetailsDTO app : appList) {
				app.setUserId(idUser);
				applicationDetailsDAO.insertMappingTable(app, session);
			}
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
	}
}
