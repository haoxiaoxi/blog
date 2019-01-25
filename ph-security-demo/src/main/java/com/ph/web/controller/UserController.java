package com.ph.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ph.web.dto.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

	@ApiOperation(value = "查询用户" ,  notes="查询用户")
	@GetMapping
	public List<User> getUser(String userName){
		System.out.println(userName);
		List<User> userList = new ArrayList<User>();
		userList.add(new User());
		userList.add(new User());
		userList.add(new User());
		return userList;
	}
	
	@ApiOperation(value = "新增用户" ,  notes="新增注册")
	@PostMapping
	public User addUser(@RequestBody User user) {
		System.out.println(user.toString());
		user.setId(1);
		return user;
	}
	@ApiOperation(value = "修改用户" ,  notes="修改用户")
	@PutMapping
	public User update( @RequestBody User user) {

		System.out.println(user.toString());
		user.setUserName("ph");
		return user;
	}
	@ApiOperation(value = "删除用户" ,  notes="删除用户")
	@DeleteMapping("/{id:\\d+}")
	public void deleteUser(@PathVariable int id) {
		System.out.println(id);
	}
	
	
} 
