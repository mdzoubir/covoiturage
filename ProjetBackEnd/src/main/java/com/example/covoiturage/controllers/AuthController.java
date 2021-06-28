package com.example.covoiturage.controllers;

import com.example.covoiturage.Details.UserDetailsImpl;
import com.example.covoiturage.Dto.UserDto;
import com.example.covoiturage.Models.ConfirmationToken;
import com.example.covoiturage.Models.User;
import com.example.covoiturage.repository.ConfirmationTokenRepository;
import com.example.covoiturage.repository.RoleRepository;
import com.example.covoiturage.repository.UserRepository;
import com.example.covoiturage.request.LoginRequest;
import com.example.covoiturage.request.SignupRequest;
import com.example.covoiturage.response.JwtResponse;
import com.example.covoiturage.response.MessageResponse;
import com.example.covoiturage.securty.jwt.JwtUtils;
import com.example.covoiturage.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	ConfirmationTokenRepository confirmationTokenRepository;

	@PostMapping(value = "/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt,
												 userDetails.getId(),
												 userDetails.getUsername(),
												 userDetails.getEmail(),
												 roles));
	}


	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(signUpRequest, userDto);
		userService.createUser(userDto);
		return ResponseEntity.ok(new String("the registration is success"));
	}


	@RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<?> confirmUserAccount(@RequestParam("token")String confirmationToken) {
		ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

		if(token != null) {
			User user = userRepository.findByEmail(token.getUserEntity().getEmail());
			user.setEmailVerificationStatus(true);
			userRepository.save(user);
			confirmationTokenRepository.delete(token);
			return ResponseEntity.ok(new MessageResponse("user account is verified"));
		} else {
			return ResponseEntity.ok(new MessageResponse("The link is invalid or broken!"));
		}
	}
}