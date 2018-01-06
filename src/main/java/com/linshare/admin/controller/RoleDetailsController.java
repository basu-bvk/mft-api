package com.linshare.admin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.linshare.admin.dto.RoleDetailsDTO;
import com.linshare.admin.services.RoleDetailsService;

@RestController
@RequestMapping("/RoleDetails")
public class RoleDetailsController {

	RoleDetailsService roleDetailsService = new RoleDetailsService();

	@RequestMapping(value = "/InsertUser", method = RequestMethod.POST)
	public String insertUser(@RequestBody RoleDetailsDTO roleDetailsDTO) {
		roleDetailsService.insertRoles(roleDetailsDTO);
		return "Inserted successfully";
	}

	@RequestMapping(value = "/SelectAllRoles", method = RequestMethod.GET)
	public List<RoleDetailsDTO> selectAll() {
		List<RoleDetailsDTO> roles = roleDetailsService.selectAllRoles();
		return roles;
	}
}
