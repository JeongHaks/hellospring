package com.javaex.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
  //DI가 발생 = 객체를 만들어서 주입해준다.
  @Autowired 
  private SqlSession sqlSession;

  //등록된 게시물 리스트를 보여준다.
  public List<GuestbookVo> getList(){
    System.out.println("----> sqlSession.selectList()");
    System.out.println(sqlSession);

    return sqlSession.selectList("GuestBookXml.selectList"); // 쿼리문이 작성된 XML로 값들을 넘겨준다(DB)에 저장.
  }
  
  
  //insert 
  public int insert(GuestbookVo vo) {
	  System.out.println(vo);
	  return sqlSession.insert("GuestBookXml.insert",vo);
  }
  
//  //delete vo로 전달된 값을 GuestBookXml.delete로 넘겨준다.
  public int delete( GuestbookVo vo) {

	return sqlSession.delete("GuestBookXml.delete",vo);
  }
  
//  public int delete(Model model) {
//	  System.out.println(model.toString());
//	  return sqlSession.delete("GuestBookXml.delete",model);
//  }
  
  //하나의 값을 사용하기 위해 
  public GuestbookVo selectGuestBook(int no) {
	  return sqlSession.selectOne("guestbook.selectGuestBook",no);
  }
  
}
