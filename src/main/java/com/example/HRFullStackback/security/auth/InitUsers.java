package com.example.HRFullStackback.security.auth;


import com.example.HRFullStackback.security.user.Role;
import com.example.HRFullStackback.security.user.User;
import com.example.HRFullStackback.security.user.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitUsers {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationService authenticationService;

    public InitUsers(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationService authenticationService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationService = authenticationService;
    }

    @PostConstruct
    public void initUsers() {
        var user = User.builder()
                .email("admin@admin.com")
                .firstname("Admin")
                .password(passwordEncoder.encode("password"))
                .role(Role.ADMIN)
                .build();
        userRepository.save(user);
        var authReq = AuthenticationRequest.builder()
                .email("admin@admin.com")
                .password("password")
                .build();
        authenticationService.authenticate(authReq);
        var registerRequest = RegisterRequest.builder()
                .email("user@user.com")
                .firstname("User")
                .password("password")
                .build();
        authenticationService.register(registerRequest);
    }

}
