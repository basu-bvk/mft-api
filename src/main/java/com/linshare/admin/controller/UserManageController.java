package com.linshare.admin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.linshare.admin.dto.UserManageDTO;
import com.linshare.admin.services.UserManageService;

@RestController
@RequestMapping("/UserManage")
public class UserManageController {
	UserManageService userManageService = new UserManageService();

	@RequestMapping(value = "/SelectAllUser", method = RequestMethod.GET)
	public List<UserManageDTO> selectAll() {
		List<UserManageDTO> user1 = userManageService.selectAllUser();
		return user1;
	}

	@RequestMapping(value = "/SelectUserById", method = RequestMethod.POST)
	public List<UserManageDTO> selectUser(@RequestBody String id) {
		List<UserManageDTO> user1 = userManageService.selectByUserId(id);
		return user1;
	}

	@RequestMapping(value = "/IsDeleteByUserId", method = RequestMethod.POST)
	public String deleteUser(@RequestBody String id) {
		userManageService.isDeleteByUserId(id);
		return "Marked isDelete as 1 successfully";
	}
	
	@RequestMapping(value = "/InsertUser", method = RequestMethod.POST)
	public String deleteUser(@RequestBody UserManageDTO userManageDTO) {
		userManageService.insertUser(userManageDTO);
		return "Inserted successfully";
	}
}
