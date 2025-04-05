package com.throwjava.web.token.model.vo;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RefreshToken {
  private String token;
  private String username;
  private Long expiration;
}
