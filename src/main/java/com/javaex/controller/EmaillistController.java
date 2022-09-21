package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javaex.dao.EmaillistDao;
import com.javaex.vo.EmaillistVo;

@Controller
public class EmaillistController {
  //이렇게 선언하면 new EmaillistDao() 이런 형식 없이 아래처럼 선언하면 된다.
  @Autowired
  EmaillistDao emaillistdao;
  
   //list 보여주기  
  @RequestMapping("/getEmailList") //주소창에 이걸 넣어서 접근해야한다 컨트롤러
  //http://localhost:8088/hellospring/getEmailList
  public ModelAndView getEmailList( ModelAndView mav) {
    System.out.println(">>> "+this.getClass()+ " 호출됨!");
  
    
   //mav = new ModelAndView(); 
   //dao에서 return값을 mav.add.. 에 데이터가 담긴다. "emaillist" <-- Arraylist로 나온다
   mav.addObject( "emaillist", emaillistdao.getList() ); // ("B " , A) A가 B에 담긴다 값들이
   //jsp 위치를 정확하게 입력
   mav.setViewName( "/WEB-INF/views/getEmaillist.jsp" );
   //mav.setViewName( "getEmailList" ); 기본 뷰 리졸버 spring-servlet.xml에 등록해주면 이렇게 사용 가능
    return mav;
  }
  
  //insert
  //form 요구하면 화면 보여주기 용
  @RequestMapping(value="/form", method=RequestMethod.GET)
  public String form() {
	  System.out.println("form");
	  return "/WEB-INF/views/form.jsp";
  }
  
  //add 요구 insert
  @RequestMapping(value="/add", method=RequestMethod.POST)
  public String add(@ModelAttribute EmaillistVo emaillistVo) {
	  System.out.println("add");
	  System.out.println(emaillistVo.toString());
	  
	  
	  
	  emaillistdao.insert(emaillistVo);
	  return "redirect:/getEmailList";
  }
  
  //delete 
  @RequestMapping(value="/delete/{no}",method=RequestMethod.GET)
  public String delete(@PathVariable("no") int no) {
	  System.out.println("delete : " + no);
	  emaillistdao.delete(no);
	return "redirect:/getEmailList";
			  
  }
}