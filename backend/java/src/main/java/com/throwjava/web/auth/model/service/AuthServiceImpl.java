package com.throwjava.web.auth.model.service;

import java.util.HashMap;
import java.util.Map;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.throwjava.web.auth.model.vo.CustomUserDetails;
import com.throwjava.web.exception.CustomAuthenticationException;
import com.throwjava.web.member.model.dto.MemberDTO;
import com.throwjava.web.member.model.vo.ResponseMember;
import com.throwjava.web.token.model.service.TokenService;
import com.throwjava.web.token.model.vo.Token;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
  
  private final AuthenticationManager authenticationManager;
  private final TokenService tokenService;

  @Override
  public Map<String, Object> login(MemberDTO member) {
    
    Authentication authentication = null;
    try{
      authentication = authenticationManager
          .authenticate(new UsernamePasswordAuthenticationToken(member.getMemberId(), member.getMemberPw()));
    } catch (AuthenticationException e) {
      throw new CustomAuthenticationException("아이디 또는 비밀번호를 잘못입력하셨습니다.");
    }
    CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();

    log.info("로그인 성공");
    log.info("사용자 정보: {}",user);

    
    Map<String, String> tokens = tokenService.generateToken(user.getUsername());
    Token authToken = Token.builder()
        .accessToken(tokens.get("accessToken"))
        .refreshToken(tokens.get("refreshToken"))
        .build();

    ResponseMember responseMember = ResponseMember.builder()
                                          .memberId(user.getUsername())
                                          .memberName(user.getMemberName())
                                          .email(user.getEmail())
                                          .build();
    Map<String, Object> loginResponse = new HashMap<>();

    loginResponse.put("authTokens", authToken);
    loginResponse.put("memberInfo", responseMember);

    return loginResponse;
  }

  @Override
  public CustomUserDetails selectUserDetails() {
    
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
    
    return user;
  }
  
  
}
