package com.example.HRFullStackback.security.auth;

import com.example.HRFullStackback.security.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

  private String token;
  private String firstName;
  private Role role;
  private String email;
}
