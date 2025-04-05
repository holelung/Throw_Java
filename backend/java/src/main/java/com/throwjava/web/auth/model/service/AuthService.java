package com.throwjava.web.auth.model.service;

import java.util.Map;

import com.throwjava.web.auth.model.vo.CustomUserDetails;
import com.throwjava.web.member.model.dto.MemberDTO;

public interface AuthService {
  
  Map<String, Object> login(MemberDTO member);

  CustomUserDetails selectUserDetails();
}
