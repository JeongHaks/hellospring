package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.EmaillistVo;

@Repository
public class EmaillistDao {
  //DI가 발생 = 객체를 만들어서 주입해준다.
  @Autowired 
  private SqlSession sqlSession;

  
  public List<EmaillistVo> getList(){
    System.out.println("----> sqlSession.selectList()");
    System.out.println(sqlSession); //

    //emaillist_xml의 namespeace.id
    //controller로 다시 전달
    return sqlSession.selectList("emaillistXml.emaillist");
  }
  
  //insert 부분!!
  public int insert(EmaillistVo vo) {
	  System.out.println(vo);
	  return sqlSession.insert("emaillistXml.insert",vo);
  }
  
  //delete 부분!!
  public int delete(int no) {
	  System.out.println("delete");
	  return sqlSession.delete("emaillistXml.delete",no);
  }
 
  
}
