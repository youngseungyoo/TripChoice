package kr.co.tripChoice.tbrq;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.utility.Utility;


@Controller
public class TbrqCont {
	
	@Autowired
	private TbrqDAO dao;
	
	public TbrqCont() {
		System.out.println("=== TbrqCont() 객체가 생성 되었습니다. ===");
	}//TripCont() end
	
	// 결과확인
    // http:///localhost:9090/tbrq/create.do
   
	@RequestMapping("/tbrq/list.do")
	public ModelAndView list(int trip_no) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tbrq/tbrqlist");
		mav.addObject("root", Utility.getRoot());
		
		return mav;
	}//list() end
	
	
	@RequestMapping(value="/tbrq/create.do", method=RequestMethod.GET)
	public ModelAndView tripForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tbrq/tbrqForm");
		mav.addObject("root", Utility.getRoot());
		
		return mav;
	}//tripForm()end
	
	@RequestMapping(value="/tbrq/create.do", method=RequestMethod.POST)
	public void createProc(@ModelAttribute TbrqDTO dto 
									,HttpServletRequest req
									,HttpServletResponse resp
									,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tbrq/msgView");
		mav.addObject("root", Utility.getRoot() ); 
	
		int cnt=dao.create(dto);
		if(cnt==0) {
			mav.addObject("msg1", "<p>여행상품 등록 실패! </p>");
			mav.addObject("img", "<img src='../images/crying.png'>");
			mav.addObject("link1", "<input type='button' value='다시시도' onclick='javascript:history.back()'>");
			mav.addObject("link2", "<input type='button' value='목록' onclick='location.href=\"./list.do?tbrq_no=" +dto.getTbrq_no() + "\"'>");
		}else {
			mav.addObject("msg1"  , "<p>음원 등록 성공! </p>");
			mav.addObject("img"   , "<img src='../images/heart.png'>");
			mav.addObject("link1" , "<input type='button' value='목록'  onclick='location.href=\"./list.do?trip_no=" +dto.getTbrq_no() + "\"'>");
		}//if end 
		
		
		
	}// createProc() end 
		
	
	}// class() end 
