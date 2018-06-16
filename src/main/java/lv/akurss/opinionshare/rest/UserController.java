package lv.akurss.opinionshare.rest;

import lv.akurss.opinionshare.model.Role;
import lv.akurss.opinionshare.model.User;
import lv.akurss.opinionshare.repository.RoleRepository;
import lv.akurss.opinionshare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@RequestMapping(path = "/user", method = RequestMethod.POST)
	public void createNewUser(@RequestBody User user) {
		Role defaultRole = roleRepository.findByRole("USER");

		Set<Role> roles = new HashSet<>();
		roles.add(defaultRole);
		
		user.setRoles(roles);
		
		userRepository.save(user);
	}
	
}