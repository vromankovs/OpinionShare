package lv.akurss.opinionshare.rest;

import lv.akurss.opinionshare.model.Role;
import lv.akurss.opinionshare.model.User;
import lv.akurss.opinionshare.repository.RoleRepository;
import lv.akurss.opinionshare.repository.UserRepository;
import lv.akurss.opinionshare.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	EmailService emailService;
	
	@RequestMapping(path = "/user", method = RequestMethod.POST)
	public void createNewUser(@RequestBody User user) {
		Role defaultRole = roleRepository.findByRole("USER");

		Set<Role> roles = new HashSet<>();
		roles.add(defaultRole);
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roles);
		
		userRepository.save(user);

		emailService.sendMail(user.getEmail(), "Welcome to OpinionShare", "Hello, "+user.getName()+ "\n\nNice to meet you at OpinionShare" );
	}
	
}
