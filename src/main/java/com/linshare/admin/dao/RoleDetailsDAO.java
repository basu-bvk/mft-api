package com.linshare.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.linshare.admin.dto.RoleDetailsDTO;

public class RoleDetailsDAO {

	public int insertRole(RoleDetailsDTO roleDetailsDTO, SqlSession session2) {
		 session2.insert("RoleDetails.insertRoles", roleDetailsDTO);
		 return roleDetailsDTO.getId();
	}

	public List<RoleDetailsDTO> getAllRoles(SqlSession session) {
		List<RoleDetailsDTO> roleList = session.selectList("RoleDetails.selectAllRoles");
		return roleList;
	}

	public void insertMappingTable(RoleDetailsDTO dto, SqlSession session) {
		session.insert("RoleDetails.insertIntoMapping", dto);
	}

	public List<RoleDetailsDTO> getGroupList(List<Integer> groupids, SqlSession session) {
		List<RoleDetailsDTO> roleList=session.selectList("RoleDetails.getGroupIds", groupids);
		return roleList;
	}

	public void deleteRole(String id, SqlSession session) {
		session.update("RoleDetails.deleteRoles", id);
	}
}
