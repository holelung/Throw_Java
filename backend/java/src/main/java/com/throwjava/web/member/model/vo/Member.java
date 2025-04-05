package com.throwjava.web.member.model.vo;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Member {
  private String memberId;
  private String memberPw;
  private String memberName;
  private String email;
  private LocalDateTime enrollDate;
  private String role;
}
