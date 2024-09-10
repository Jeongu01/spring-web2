package com.ssg.web2.todo.dao;

import com.ssg.web2.todo.domain.MemberVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lombok.Cleanup;

public class MemberDAO {

  public MemberVO getWithPassword(String mid, String mpw) {
    String sql = "select mname from tbl_member where mid=? and mpw=?";

    MemberVO vo = null;
    try {
      @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
      @Cleanup PreparedStatement psmt = connection.prepareStatement(sql);

      psmt.setString(1, mid);
      psmt.setString(2, mpw);

      @Cleanup ResultSet rs = psmt.executeQuery();

      while (rs.next()) {

        vo = MemberVO.builder()
            .mid(mid)
            .mpw(mpw)
            .mname(rs.getString("mname"))
            .build();
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    return vo;
  }

}
