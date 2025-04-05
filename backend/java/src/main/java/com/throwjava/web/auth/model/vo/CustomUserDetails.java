package com.throwjava.web.auth.model.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Value
@Builder
@ToString
public class CustomUserDetails implements UserDetails {
  private String username;
  private String password;
  private String memberName;
  private String email;
  private Collection<? extends GrantedAuthority> authorities;
}
