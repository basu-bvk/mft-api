package com.linshare.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.linshare.admin.dto.UserManageDTO;
import com.linshare.admin.services.MyBatisUtil;

public class UserManageDAO {
	SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();

	public List<UserManageDTO> getAllUserList() {
		List<UserManageDTO> list = session.selectList("UserManage.selectAllUser");
		return list;
	}
	
	public List<UserManageDTO> getUserListById(String id) {
		List<UserManageDTO> list = session.selectList("UserManage.selectbyUser",id);
		return list;
	}
	
	public void isDeleteUserById(String id) {
		session.update("UserManage.delteUser",id);
		session.commit();
		session.close();
		
	}
	public int insertUser(UserManageDTO userManageDTO, SqlSession sqlsess) {
		sqlsess.insert("UserManage.insertUser",userManageDTO);
		return userManageDTO.getId();
	}
}
