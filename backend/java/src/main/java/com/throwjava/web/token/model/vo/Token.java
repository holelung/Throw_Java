package com.throwjava.web.token.model.vo;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Token {
    private String accessToken;
    private String refreshToken;
}
