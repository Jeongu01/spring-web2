package com.ssg.web2.todo.service;

import com.ssg.web2.todo.dao.MemberDAO;
import com.ssg.web2.todo.domain.MemberVO;
import com.ssg.web2.todo.dto.MemberDTO;
import com.ssg.web2.todo.util.ModelUtil;
import org.modelmapper.ModelMapper;

public enum MemberService {

  INSTANCE;

  private MemberDAO dao;
  private ModelMapper modelMapper;

  MemberService() {
    dao = new MemberDAO();
    modelMapper = ModelUtil.INSTANCE.get();
  }

  public MemberDTO login(String mid, String mpw) {
    MemberVO memberVO = dao.getWithPassword(mid, mpw);
    if (memberVO == null) return null;
    MemberDTO dto = modelMapper.map(memberVO, MemberDTO.class);

    return dto;
  }

}
