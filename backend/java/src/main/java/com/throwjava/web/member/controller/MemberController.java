package com.throwjava.web.member.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.throwjava.web.member.model.dto.MemberDTO;
import com.throwjava.web.member.model.dto.UpdatePasswordDTO;
import com.throwjava.web.member.model.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;




@Slf4j
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
  
  private final MemberService memberService;

  @PostMapping
  public ResponseEntity<?> signUp(@RequestBody @Valid MemberDTO member) {
    log.info("받은거{}", member);
    memberService.signUp(member);
    return ResponseEntity.status(201).build();
  }
  
  @PutMapping("/password")
  public ResponseEntity<?> updatePassword(@RequestBody @Valid UpdatePasswordDTO requestPassword) {

    log.info("updatePassword:{}", requestPassword);
    memberService.updatePassword(requestPassword);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
  
  @PutMapping("/info")
  public ResponseEntity<?> updateInfo(@RequestBody @Valid MemberDTO member) {
      
    log.info("updateMember: {}", member);
    memberService.updateMemberInfo(member);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping
  public ResponseEntity<?> deleteByPassword(@RequestBody Map<String, String> password) {
    log.info("deleteByPassword:{}", password);
    memberService.deleteByPassword(password.get("password"));
    return ResponseEntity.status(204).build();
  }

}
