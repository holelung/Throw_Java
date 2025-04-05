package com.throwjava.web.token.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.throwjava.web.token.model.vo.RefreshToken;

@Mapper
public interface TokenMapper {
  
  void saveToken(RefreshToken token);

  RefreshToken selectByToken(RefreshToken token);

  void deleteExpiredRefreshToken(Long now);

}
