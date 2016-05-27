package com.register.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.register.dto.UserDTO;
import com.register.model.User;
import com.register.service.UserManager;

@Component("registerAction")
@Scope("prototype")  //一定要设置Scope为prototype
public class LoginAction  extends ActionSupport  implements ModelDriven<UserDTO>{
	private UserDTO userDTO=new UserDTO();
	private UserManager userManager;
	
	private List<User> users; //用来保存从数据库中提取的user
	
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	public UserManager getUserManager() {
		return userManager;
	}
	@Resource
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	//判断user在数据库中是否存在来返回不同的字符串
	@Override
	public String execute() throws Exception {
		User user=new User();
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getUsername());
		boolean exists=userManager.exists(user);
		if(exists){
			System.out.println("registerFail");
			return "fail";
		}

		userManager.save(user);
		System.out.println("registerSuccess");
		return "success";
	}
	@Override
	public UserDTO getModel() {
		return userDTO;
	}	
	
	public String list() throws Exception{
		users=this.userManager.getUsers();
		return "list";
	}
}
