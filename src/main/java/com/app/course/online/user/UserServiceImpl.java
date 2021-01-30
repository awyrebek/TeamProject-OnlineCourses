package com.app.course.online.user;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findUserByEmail(String email)
	{
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user)
	{
		List<User> users = userRepository.findAll();
		if(users.stream().filter(u -> u.getEmail().equals(user.getEmail())).findAny().orElse(null) != null)
			throw new IllegalArgumentException("Email " + user.getEmail() + " już istnieje w bazie danych.");
		
		BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
		user.setId(null);
		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);

		userRepository.save(user);
	}
}