package com.linshare.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.linshare.admin.dao.CapabilityDAO;
import com.linshare.admin.dto.CapabilityDTO;

@RestController
@RequestMapping("/Capability")
public class CapabilityController {
	CapabilityDAO capabilityDAO = new CapabilityDAO();
	CapabilityDTO capabilityDTO;

	@RequestMapping(value = "/Insert", method = RequestMethod.POST)
	public String insert(@RequestBody CapabilityDTO capabilityDTO) {
		capabilityDAO.insertCap(capabilityDTO);
		return "Inserted successfully";
	}

	@RequestMapping(value = "/Delete", method = RequestMethod.DELETE)
	public String delete(@RequestBody String id) {
		capabilityDAO.deleteCap(id);
		return "Deleted successfully";
	}

	@RequestMapping(value = "/SelectAll", method = RequestMethod.GET)
	public List<CapabilityDTO> selectAll() {
		List<CapabilityDTO> capabilityDTOs = new ArrayList<CapabilityDTO>();
		capabilityDTOs = capabilityDAO.selectAll();
		return capabilityDTOs;
	}

	@RequestMapping(value = "/SelectById", method = RequestMethod.POST)
	public List<CapabilityDTO> select(@RequestBody String id) {
		List<CapabilityDTO> capabilityDTOs = new ArrayList<CapabilityDTO>();
		capabilityDTOs = capabilityDAO.select(id);
		return capabilityDTOs;
	}

	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public String update(@RequestBody CapabilityDTO capabilityDTO) {
		capabilityDAO.updateCap(capabilityDTO);
		return "Updated successfully";
	}
}
