package com.hms.hospital_management_system.controller;

import com.hms.hospital_management_system.dto.UserDto;
import com.hms.hospital_management_system.entity.User;
import com.hms.hospital_management_system.repository.UserRepository;
import com.hms.hospital_management_system.services.UserService;
import com.hms.hospital_management_system.services.jwt.UserDetailsServiceImpl;
import com.hms.hospital_management_system.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class LoginController {

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String HEADER_STRING = "Authorization";

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping(path = "/create-user")
    public ResponseEntity<?> createUser(@RequestBody UserDto dto) {
         UserDto userDto = userService.createUser(dto);
         if(userDto ==null) {
             return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
         }
         return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    @PostMapping({"/login"})
    public void createAuthenticationToken(@RequestBody UserDto authenticationRequest,
                                          HttpServletResponse response) throws IOException, JSONException {

        UserDto userDto = userService.getUserByUsername(authenticationRequest.getUsername());
        if(userDto == null || userDto.getRole() != authenticationRequest.getRole()){
            throw new BadCredentialsException("Incorrect username, password or role");
        }
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),authenticationRequest.getPassword()
            ));
        } catch (BadCredentialsException e){
            throw new BadCredentialsException("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        User user = userRepository.findUserByUsername(authenticationRequest.getUsername()).get();
        response.getWriter().write(new JSONObject()
                .put("id", user.getId())
                .put("token", jwt)
                .toString()
        );

        response.addHeader("Access-Control-Expose-Headers", "Authorization");
        response.addHeader("Access-Control-Allow-Headers", "Authorization," +
                " X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept, X-Custom-header");

        response.addHeader(HEADER_STRING, TOKEN_PREFIX+jwt);
    }
}
