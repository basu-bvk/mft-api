package com.linshare.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.linshare.admin.dto.GroupDetailsDTO;

public class GroupDetailsDAO {

	public int insertGroups(GroupDetailsDTO groupDetailsDTO, SqlSession session) {
		session.insert("GroupDetails.insertGroups", groupDetailsDTO);
		return groupDetailsDTO.getId();
	}

	public List<GroupDetailsDTO> getAllGroups(SqlSession session) {
		List<GroupDetailsDTO> groupList=session.selectList("GroupDetails.selectAllGroup");
		return groupList;
	}

}
