package com.throwjava.web.member.model.dto;

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
public class UpdatePasswordDTO {

  @Size(min = 5, max = 20, message = "비밀번호는 5글자 이상 20자 이하만 사용이 가능합니다.")
  @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{5,20}$",
          message = "비밀번호는 최소 한개의 특수문자를 포함하여 영어/숫자로 작성하여야 합니다.")
  @NotBlank(message="비밀번호는 공백으로 만들 수 없습니다.")
  private String currentPassword;
  @Size(min = 5, max = 20, message = "비밀번호는 5글자 이상 20자 이하만 사용이 가능합니다.")
  @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{5,20}$",
          message = "비밀번호는 최소 한개의 특수문자를 포함하여 영어/숫자로 작성하여야 합니다.")
  @NotBlank(message="비밀번호는 공백으로 만들 수 없습니다.")
  private String newPassword;
  
}
