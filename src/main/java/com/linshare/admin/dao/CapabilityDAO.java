package com.linshare.admin.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.linshare.admin.dto.CapabilityDTO;
import com.linshare.admin.services.MyBatisUtil;

public class CapabilityDAO {
	SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
	CapabilityDTO capabilityDTO;

	public void insertCap(CapabilityDTO capabilityDTO) {
		session.insert("Capability.insertCapability", capabilityDTO);
		session.commit();
		session.close();
	}

	public List<CapabilityDTO> selectAll() {
		List<CapabilityDTO> capabilityDTOs = new ArrayList<CapabilityDTO>();
		capabilityDTOs = session.selectList("Capability.selectAll");
		return capabilityDTOs;
	}
	
	public List<CapabilityDTO> select(String id) {
		List<CapabilityDTO> capabilityDTOs = new ArrayList<CapabilityDTO>();
		capabilityDTOs =session.selectList("Capability.select", id);
		return capabilityDTOs;
	}
	
	public void deleteCap(String id) {
		session.update("Capability.deleteCap", id);
		session.commit();
		session.close();
	}
	
	public void updateCap(CapabilityDTO capabilityDTO2) {
		session.update("Capability.updateCap", capabilityDTO2);
		session.commit();
		session.close();
	}

	public void insertMappingTable(CapabilityDTO dto, SqlSession session2) {
		session2.insert("Capability.insertIntoMapping", dto);
	}

	public List<CapabilityDTO> getCapIdList(List<Integer> roleids, SqlSession session2) {
		List<CapabilityDTO> capIdList=session2.selectList("Capability.getCapIds", roleids);
		return capIdList;
	}
	
}