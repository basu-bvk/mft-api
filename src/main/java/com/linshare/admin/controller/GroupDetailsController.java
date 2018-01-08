package com.linshare.admin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.linshare.admin.dto.GroupDetailsDTO;
import com.linshare.admin.services.GroupDetailsService;

@RestController
@RequestMapping("/GroupDetails")

public class GroupDetailsController {

	GroupDetailsService groupDetailsService = new GroupDetailsService();

	@RequestMapping(value = "/InsertGroups", method = RequestMethod.POST)
	public String insertGroups(@RequestBody GroupDetailsDTO groupDetailsDTO) {
		groupDetailsService.insertRoles(groupDetailsDTO);
		return "Inserted successfully";
	}

	@RequestMapping(value = "/SelectAllGroups", method = RequestMethod.GET)
	public List<GroupDetailsDTO> selectAll() {
		List<GroupDetailsDTO> groups = groupDetailsService.selectAllGroups();
		return groups;
	}
	
	@RequestMapping(value = "/DeleteGroups", method = RequestMethod.POST)
	public String insertGroups(@RequestBody String id) {
		groupDetailsService.deleteGroups(id);
		return "Deleted successfully";
	}
}
