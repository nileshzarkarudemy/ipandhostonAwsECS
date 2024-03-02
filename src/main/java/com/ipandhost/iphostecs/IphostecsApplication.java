package com.ipandhost.iphostecs;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class IphostecsApplication {

	public static void main(String[] args) {
		SpringApplication.run(IphostecsApplication.class, args);
	}

	@Autowired
	private UserService userService;

	@GetMapping("/ip-host")
	public String displayIpAndHost() throws UnknownHostException{
		return "IP: "+ Inet4Address.getLocalHost().getHostAddress()+ " HOSTNAME: "+ Inet4Address.getLocalHost().getHostName();
	}


	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getUsers() {
		List<UserDto> usersList = userService.getUsers();
		return new ResponseEntity<>(usersList, HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
		try {
			String status = userService.creatUser(userDto);
			return new ResponseEntity<>(status, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
