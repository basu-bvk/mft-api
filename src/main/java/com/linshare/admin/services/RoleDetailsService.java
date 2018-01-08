package com.linshare.admin.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.linshare.admin.dao.CapabilityDAO;
import com.linshare.admin.dao.RoleDetailsDAO;
import com.linshare.admin.dto.CapabilityDTO;
import com.linshare.admin.dto.RoleDetailsDTO;

public class RoleDetailsService {

	RoleDetailsDAO roleDetailsDAO = new RoleDetailsDAO();
	CapabilityDAO capabilityDAO = new CapabilityDAO();
	SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();

	public void insertRoles(RoleDetailsDTO roleDetailsDTO) {

		int role = 0;
		try {
			role = roleDetailsDAO.insertRole(roleDetailsDTO, session);
			//session.commit();
			List<CapabilityDTO> capList = roleDetailsDTO.getCapabilitesList();
			for (CapabilityDTO dto : capList) {
				dto.setRoleId(role);
				capabilityDAO.insertMappingTable(dto, session);
			}
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
	}

	public List<RoleDetailsDTO> selectAllRoles() {
		List<CapabilityDTO> temp = null;
		List<Integer> roleids = new ArrayList<Integer>();
		List<RoleDetailsDTO> roleList = roleDetailsDAO.getAllRoles(session);

		for (RoleDetailsDTO roles : roleList) {
			roleids.add(roles.getId());
		}
		List<CapabilityDTO> capids = capabilityDAO.getCapIdList(roleids, session);
		for (RoleDetailsDTO role : roleList) {
			for (CapabilityDTO caps : capids) {
				if (role.getId() == caps.getRoleId()) {
					temp = new ArrayList<CapabilityDTO>();
					if (role.getCapabilitesList() != null) {
						temp = role.getCapabilitesList();
					}
					temp.add(caps);
					role.setCapabilitesList(temp);
				}
			}
		}
		return roleList;
	}

	public void deleteRoles(String id) {
		roleDetailsDAO.deleteRole(id,session);
		session.commit();
		session.close();
	}
}
