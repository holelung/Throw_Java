package com.throwjava.web.member.model.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDTO {
  @Size(min = 5, max = 20, message = "아이디는 5글자 이상 20자 이하만 사용이 가능합니다.")
  @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "아이디는 영어/숫자 만 사용이 가능합니다.")
  @NotBlank(message="아이디는 공백으로 만들 수 없습니다." )
  private String memberId;
  @Size(min = 5, max = 20, message = "비밀번호는 5글자 이상 20자 이하만 사용이 가능합니다.")
  @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{5,20}$",
          message = "비밀번호는 최소 한개의 특수문자를 포함하여 영어/숫자로 작성하여야 합니다.")
  @NotBlank(message="비밀번호는 공백으로 만들 수 없습니다.")
  private String memberPw;

  private String memberName;
  @Pattern(
    regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
    message = "유효한 이메일 주소 형식이 아닙니다."
  )
  private String email;
  private LocalDateTime enrollDate;
  private String role;
}
