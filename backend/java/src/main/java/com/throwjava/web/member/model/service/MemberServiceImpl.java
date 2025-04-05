package com.throwjava.web.member.model.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.throwjava.web.auth.model.vo.CustomUserDetails;
import com.throwjava.web.exception.InvalidPasswordException;
import com.throwjava.web.exception.MemberIdDuplicationException;
import com.throwjava.web.member.model.dao.MemberMapper;
import com.throwjava.web.member.model.dto.MemberDTO;
import com.throwjava.web.member.model.dto.UpdatePasswordDTO;
import com.throwjava.web.member.model.vo.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

  private final MemberMapper mapper;
  private final PasswordEncoder passwordEncoder;
  
  @Override
  public void signUp(MemberDTO member) {

    MemberDTO searchMember = mapper.selectMemberByMemberId(member.getMemberId());
    if (searchMember != null) {
      throw new MemberIdDuplicationException("이미 존재하는 아이디 입니다.");
    }

    Member memberValue = Member.builder()
        .memberId(member.getMemberId())
        .memberPw(passwordEncoder.encode(member.getMemberPw()))
        .memberName(member.getMemberName())
        .email(member.getEmail())
        .role("ROLE_USER")
        .build();
    int result = mapper.signUp(memberValue);
    if (result != 0) {
      log.info("등록 성공{},", memberValue);
    } else {
      log.info("등록 실패 {}", memberValue);
    }
  }

  @Override
  public void deleteByPassword(String password) {
    String memberId = checkPassword(password);
    
    mapper.deleteByPassword(memberId);    
  }

  @Override
  public void updatePassword(UpdatePasswordDTO passwordEntity) {
    // 현재 비밀번호 검증
    String memberId = checkPassword(passwordEntity.getCurrentPassword());
    // 새 비밀번호 암호화
    String encodedPassword = passwordEncoder.encode(passwordEntity.getNewPassword());

    Member member = Member.builder().memberId(memberId).memberPw(encodedPassword).build();
    mapper.updatePassword(member);
  }

  @Override
  public void updateMemberInfo(MemberDTO member) {
    Member updateMember = Member.builder().memberId(member.getMemberId()).memberName(member.getMemberName())
        .email(member.getEmail()).build();

    mapper.updateMemberInfo(updateMember);
  }
  
  private String checkPassword(String password) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
    log.info("저장된 비밀번호: {}",user.getPassword());
    log.info("입력받은 비밀번호:{}",password);
    log.info("matches 결과 : {} ", passwordEncoder.matches(password, user.getPassword()));


    if (!passwordEncoder.matches(password, user.getPassword())) {
      throw new InvalidPasswordException("비밀번호가 일치하지 않습니다.");
    }
    return user.getUsername();
  }
  
  
}
