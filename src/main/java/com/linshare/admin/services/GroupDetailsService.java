package com.linshare.admin.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.linshare.admin.dao.GroupDetailsDAO;
import com.linshare.admin.dao.RoleDetailsDAO;
import com.linshare.admin.dto.GroupDetailsDTO;
import com.linshare.admin.dto.RoleDetailsDTO;

public class GroupDetailsService {

	RoleDetailsDAO roleDetailsDAO = new RoleDetailsDAO();
	SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
	GroupDetailsDAO groupDetailsDAO = new GroupDetailsDAO();

	public void insertRoles(GroupDetailsDTO groupDetailsDTO) {
		int group = 0;
		try {
			group = groupDetailsDAO.insertGroups(groupDetailsDTO, session);
			// session.commit();
			List<RoleDetailsDTO> roleList = groupDetailsDTO.getRoleList();
			for (RoleDetailsDTO dto : roleList) {
				dto.setUsergroupId(group);
				roleDetailsDAO.insertMappingTable(dto, session);
			}
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
	}

	public List<GroupDetailsDTO> selectAllGroups() {
		List<RoleDetailsDTO> temp = null;
		List<Integer> groupids = new ArrayList<Integer>();
		List<GroupDetailsDTO> groupList = groupDetailsDAO.getAllGroups(session);

		for (GroupDetailsDTO group : groupList) {
			groupids.add(group.getId());
		}
		List<RoleDetailsDTO> roleids = roleDetailsDAO.getGroupList(groupids, session);
		for (GroupDetailsDTO group : groupList) {
			for (RoleDetailsDTO role : roleids) {
				if (group.getId() == role.getUsergroupId()) {
					temp = new ArrayList<RoleDetailsDTO>();
					if (group.getRoleList() != null) {
						temp = group.getRoleList();
					}
					temp.add(role);
					group.setRoleList(temp);
				}
			}
		}
		return groupList;
	}

	public void deleteGroups(String id) {
		groupDetailsDAO.deleteGroup(id,session);
	}
}
