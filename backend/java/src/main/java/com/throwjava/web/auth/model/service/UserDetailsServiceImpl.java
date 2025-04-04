package com.throwjava.web.auth.model.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.throwjava.web.auth.model.vo.CustomUserDetails;
import com.throwjava.web.exception.CustomAuthenticationException;
import com.throwjava.web.member.model.dao.MemberMapper;
import com.throwjava.web.member.model.dto.MemberDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  
  private final MemberMapper mapper;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
    MemberDTO user = mapper.selectMemberByMemberId(username);

    if (user == null) {
      throw new CustomAuthenticationException("존재하지 않는 사용자입니다.");
    }

    return CustomUserDetails.builder()
        .username(user.getMemberId())
        .password(user.getMemberPw())
        .memberName(user.getMemberName())
        .email(user.getEmail())
        .authorities(Collections.singletonList(new SimpleGrantedAuthority(user.getRole())))
        .build();
  }
  
  

}
