package com.throwjava.web.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;

@Value
@Builder
public class ResponseMember {
    private String memberId;
    private String memberName;
    private String email;
}
