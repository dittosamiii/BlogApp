package com.springboot.service.Impl;

import java.util.Arrays;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.dto.RegistrationDto;
import com.springboot.entity.User;
import com.springboot.repository.RoleRepository;
import com.springboot.repository.UserRepository;
import com.springboot.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;

	@Override
	public void createUser(RegistrationDto registrationDto) {
		User user = new User();
		user.setName(registrationDto.getFirstName() + " " + registrationDto.getLastName());
		user.setEmail(registrationDto.getEmail());
		user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
		user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_GUEST")));
		userRepository.save(user);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
