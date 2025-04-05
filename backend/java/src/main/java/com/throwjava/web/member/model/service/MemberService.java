package com.throwjava.web.member.model.service;



import com.throwjava.web.member.model.dto.MemberDTO;
import com.throwjava.web.member.model.dto.UpdatePasswordDTO;


public interface MemberService {
  
  // 회원가입
  void signUp(MemberDTO member);

  void updatePassword(UpdatePasswordDTO passwordEntity);

  void updateMemberInfo(MemberDTO member);

  void deleteByPassword(String password);

}
