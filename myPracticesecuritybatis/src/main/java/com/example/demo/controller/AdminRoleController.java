package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserRoleDTO;
import com.example.demo.formDTOList.FormUserListDTO;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class AdminRoleController {

	// private final List<String> adminRole = Arrays.asList("ADMIN", "USER",
	// "CREATOR", "WRITER", "READER");
	private final static String adminRole = "ADMIN";
	private final static String adminUser = "USER";
	private final static String adminCreator = "CREATOR";
	private final static String adminWriter = "WRITER";
	private final static String adminReader = "READER";

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@GetMapping("/admin/role")
	public String role(Model model) {

		FormUserListDTO formUserListDTO = new FormUserListDTO();

		List<User> users = new ArrayList<User>();
		List<Role> roles = roleRepository.findAllRole();

		for (User user : userRepository.findAllUser()) {

			User user1 = new User();
			user1.setId(user.getId());
			user1.setUsername(user.getUsername());
			user1.setPassword(user.getPassword());
			user1.setEnabled(user.isEnabled());

			List<Role> role = new ArrayList<Role>();

			role.add(0, new Role(0, adminRole));
			role.add(1, new Role(0, adminUser));
			role.add(2, new Role(0, adminCreator));
			role.add(3, new Role(0, adminReader));
			role.add(4, new Role(0, adminWriter));

			for (Role r : user.getRoles()) {
				if (r.getRolename().equals(adminRole)) {
					r.setId(r.getId());
					r.setRolename(adminRole);
					role.set(0, r);
				}
				if (r.getRolename().equals(adminUser)) {
					r.setId(r.getId());
					r.setRolename(adminUser);
					role.set(1, r);
				}
				if (r.getRolename().equals(adminCreator)) {
					r.setId(r.getId());
					r.setRolename(adminCreator);
					role.set(2, r);
				}
				if (r.getRolename().equals(adminReader)) {
					r.setId(r.getId());
					r.setRolename(adminReader);
					role.set(3, r);
				}
				if (r.getRolename().equals(adminWriter)) {
					r.setId(r.getId());
					r.setRolename(adminWriter);
					role.set(4, r);
				}

			}

			user1.setRoles(role);
			users.add(user1);

		}

		formUserListDTO.setListUser(users);

		model.addAttribute("formUserListDTO", formUserListDTO);
		model.addAttribute("users", users);
		model.addAttribute("roles", roles);
		model.addAttribute("userRole", new UserRoleDTO());

		return "role";

	}

	@PostMapping("/addrole")
	public String addRole(@ModelAttribute("userRole") UserRoleDTO userRole) {

		userRepository.insertUserRoles(userRole);

		return "redirect:/admin/role";
	}

	@GetMapping("/deleterole")
	public String deleteRole(@ModelAttribute("userRole") UserRoleDTO userRole) {

		userRepository.deleteRole(userRole);

		return "redirect:/admin/role";
	}

	@PostMapping("/addRole")
	public String addMultiRole(@ModelAttribute("formUserListDTO") FormUserListDTO formUserListDTO) {

		for (User user : formUserListDTO.getListUser()) {

//			Long id = user.getId();
//
//			long changeId = id;

			User userget = userRepository.findOnePDetails(user.getUsername());

			for (int i = 0; i < user.getRoles().size(); i++) {

				if (user.getRoles().get(i).getId() == 0 && (user.getRoles().get(i).getRolename().equals(adminRole)
						|| user.getRoles().get(i).getRolename().equals(adminCreator)
						|| user.getRoles().get(i).getRolename().equals(adminUser)
						|| user.getRoles().get(i).getRolename().equals(adminReader)
						|| user.getRoles().get(i).getRolename().equals(adminWriter))) {

					Long useridlong = userget.getId();
					long useridchange = useridlong;
					int userid = (int) useridchange;

					UserRoleDTO role = new UserRoleDTO();
					role.setUserid(userid);
					role.setRoleid(i + 1);

					userRepository.deleteRole(role);

				}

				if (user.getRoles().get(i).getId() != 0) {

					Long useridlong = userget.getId();
					long useridchange = useridlong;
					int userid = (int) useridchange;

					UserRoleDTO role = new UserRoleDTO();
					role.setUserid(userid);
					role.setRoleid(i+1);

					userRepository.insertUserRoles(role);

				}

			}

			/*
			 * for(Role r : user.getRoles()) {
			 * 
			 * if(userget.getRoles().get())
			 * 
			 * Long useridlong = userget.getId(); long useridchange = useridlong; int userid
			 * = (int) useridchange;
			 * 
			 * UserRoleDTO role = new UserRoleDTO(); role.setUserid(userid);
			 * role.setRoleid(r.getId());
			 * 
			 * userRepository.insertUserRoles(role);
			 * 
			 * }
			 */

		}

		return "redirect:/admin/role";
	}

}
