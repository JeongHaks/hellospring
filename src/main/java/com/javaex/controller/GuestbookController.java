package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {
  //이렇게 선언하면 new guestbookDao() 이런 형식 없이 아래처럼 선언하면 된다.
  @Autowired
  GuestbookDao guestbookDao;
  GuestbookVo guestbookVo;
    //리스트
  @RequestMapping("/getGuestbookList") //주소창에 이걸 넣어서 접근해야한다 컨트롤러
  //http://localhost:8088/hellospring/getGuestbookList
  public ModelAndView getGuestbookList( ModelAndView mav) {
    System.out.println(">>> "+this.getClass()+ " 호출됨!");
    
    //mav = new ModelAndView(); 
    mav.addObject( "guestbookList", guestbookDao.getList() ); // ("B " , A) A가 B에 담긴다 값들이
    //jsp 위치를 정확하게 입력
    mav.setViewName( "/WEB-INF/views/getGuestbookList.jsp" );
    //mav.setViewName( "getGuestbookList" ); 기본 뷰 리졸버 spring-servlet.xml에 등록해주면 이렇게 사용 가능
    return mav;
  }
  
  //insert
  @RequestMapping(value="/guestform", method=RequestMethod.GET)
  public String form() {
	  System.out.println("guestform");
	  return "/WEB-INF/views/guestform.jsp";
  }
  @RequestMapping(value="/addd",method=RequestMethod.POST)
  public String add(@ModelAttribute GuestbookVo guestbookVo) {
	  System.out.println("addd");
	  System.out.println(guestbookVo.toString());
	  
	  guestbookDao.insert(guestbookVo);
	  return "redirect:/getGuestbookList";
  }
  
  
  //delete  삭제 버튼을 클릭 시 deleteform화면으로 이동하는 생성자
  @RequestMapping(value="/deleteform",method=RequestMethod.GET)
  public String deleteform() {
	  System.out.println("deleteform");
	  return "/WEB-INF/views/deleteform.jsp";
  }
  
  //deleteform에서 비밀번호를 입력하여 확인 버튼을 누르면 비밀번호가 같을 시 삭제 아닐 시 삭제가 되지않고 메인 리스트화면으로 돌아온다.
  @RequestMapping(value="/deletee", method=RequestMethod.GET)
  public String delete(@ModelAttribute GuestbookVo guestbookVo , @RequestParam("no") int no, @RequestParam("pass") String pass,
		  @RequestParam("password") String password) {
	  System.out.println("del pass : " + pass);
	  System.out.println("del password : " + password);
	  System.out.println("deletee");
	  guestbookVo.setNo(no);
	  guestbookVo.setPassword(pass);
	  if(pass.equals(password)) {
		  guestbookDao.delete(guestbookVo);
	  }
	  return "redirect:/getGuestbookList";
  }
  
//    @RequestMapping(value="/deleteform",method=RequestMethod.GET)
//    public String deleteform() {
//    	return "/WEB-INF/views/deleteform.jsp";
//    }
//  
//    @RequestMapping(value="/deletee",method=RequestMethod.GET)
//    public String delete(@RequestParam("no") int no, @RequestParam("pass") String pass, Model model) {
//    	
//    	model.addAttribute("no",no);
//    	model.addAttribute("pass",pass);
//    	System.out.println("no : " + no);
//    	System.out.println("pass : " + pass);
//    	guestbookDao.delete(model);
//    	return "redirect:/getGuestbookList";
//    }
  
//  @RequestMapping(value="/deletee",method=RequestMethod.POST)
//  public String deletee(@ModelAttribute GuestbookVo guestbookVo) {
//	  guestbookDao.delete(guestbookVo);
//	  return "redirect:/getGuestbookList";
//  }
}