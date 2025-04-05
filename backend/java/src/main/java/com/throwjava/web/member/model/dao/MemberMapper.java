package com.throwjava.web.member.model.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.throwjava.web.member.model.dto.MemberDTO;
import com.throwjava.web.member.model.vo.Member;

@Mapper
public interface MemberMapper {

  // 회원가입
  int signUp(Member member);
  
  // 회원정보 받아오기
  MemberDTO selectMemberByMemberId(String memberId);

  // 회원정보 업데이트
  void updateMemberInfo(Member member);

  // 비밀번호 변경
  void updatePassword(Member member);
  
  // 회원 탈퇴
  void deleteByPassword(String memberId);
}
