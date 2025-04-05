package com.throwjava.web.token.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.throwjava.web.auth.util.JwtUtil;
import com.throwjava.web.exception.InvalidTokenException;
import com.throwjava.web.token.model.dao.TokenMapper;
import com.throwjava.web.token.model.vo.RefreshToken;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
  
  private final JwtUtil jwtUtil;
  private final TokenMapper tokenMapper;

  @Override
  public Map<String, String> generateToken(String username) {
    
    Map<String, String> tokens = createToken(username);
    saveToken(tokens.get("refreshToken"), username);
    tokenMapper.deleteExpiredRefreshToken(System.currentTimeMillis());
    return tokens;
  }
  
  @Override
  public Map<String, String> refreshToken(String refreshToken) {
    
    RefreshToken token = RefreshToken.builder().token(refreshToken).build();

    RefreshToken responseToken = tokenMapper.selectByToken(token);
    if (responseToken == null || token.getExpiration() < System.currentTimeMillis()) {
      throw new InvalidTokenException("유효하지 않은 토큰");
    }

    String username = getUsernameByToken(refreshToken);
    return  generateToken(username);
  }

  private Map<String, String> createToken(String username) {

    String accessToken = jwtUtil.getAccessToken(username);
    String refreshToken = jwtUtil.getRefreshToken(username);

    Map<String, String> tokens = new HashMap<>();
    tokens.put("accessToken", accessToken);
    tokens.put("refreshToken", refreshToken);
    return tokens;
  }
  
  private void saveToken(String refreshToken, String username) {
    RefreshToken token = RefreshToken.builder()
        .token(refreshToken)
        .username(username)
        .expiration(System.currentTimeMillis() + 36000000L * 72)
        .build();

    tokenMapper.saveToken(token);
  }
  
  private String getUsernameByToken(String refreshToken) {
    Claims claims = jwtUtil.parseJwt(refreshToken);
    return claims.getSubject();
  }
  

}
