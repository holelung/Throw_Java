package com.throwjava.web.util;

import org.springframework.stereotype.Component;

import com.throwjava.web.auth.model.service.AuthService;
import com.throwjava.web.auth.model.vo.CustomUserDetails;
import com.throwjava.web.exception.UnauthorizedAccessException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuthUtil {
    
    private final AuthService authService;

    public void checkAuthorization(String memberId) {
        CustomUserDetails user = authService.selectUserDetails();
        String authMemberId = user.getUsername();
        if (!memberId.equals(authMemberId)) {
            throw new UnauthorizedAccessException("권한이 없습니다.");
        }
    }

}
