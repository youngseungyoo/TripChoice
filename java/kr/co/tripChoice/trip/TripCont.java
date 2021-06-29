package kr.co.tripChoice.trip;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.utility.Utility;


@Controller
public class TripCont {
	
	@Autowired
	private TripDAO dao;
	
	public TripCont() {
		System.out.println("=== TripCont() 객체가 생성 되었습니다. ===");
	}//TripCont() end
	
	// 결과확인
    // http:///localhost:9090/trip/create.do
   
	@RequestMapping("/trip/tripList.do")
	public ModelAndView list(int trip_no) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("trip/tripList");
		mav.addObject("root", Utility.getRoot());
		mav.addObject("list", dao.list(trip_no));
		mav.addObject("trip_no", trip_no); // 부모글번호
		return mav;
	}//list() end
	
	
	@RequestMapping(value="trip/create.do", method=RequestMethod.GET)
	public ModelAndView tripForm(int trip_no) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("trip/createForm");
		mav.addObject("root", Utility.getRoot());
		mav.addObject("trip_no", trip_no); // 부모글번호
		return mav;
	}//tripForm()end
	
	@RequestMapping(value="/trip/create.do", method=RequestMethod.POST)
	public void createProc(@ModelAttribute TripDTO dto 
									,HttpServletRequest req
									,HttpServletResponse resp
									,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("trip/msgView");
		mav.addObject("root", Utility.getRoot() ); 
	
				
		int cnt=dao.create(dto);
		if(cnt==0) {
			mav.addObject("msg1", "<p>여행상품 등록 실패! </p>");
			mav.addObject("img", "<img src='./images/crying.png'>");
			mav.addObject("link1", "<input type='button' value='다시시도' onclick='javascript:history.back()'>");
			mav.addObject("link2", "<input type='button' value='목록' onclick='location.href=\"./create.do?trip_no=" +dto.getTrip_no() + "\"'>");
		}else {
			mav.addObject("msg1"  , "<p>여행상품 등록 성공! </p>");
			mav.addObject("img"   , "<img src='./images/heart.png'>");
			mav.addObject("link1" , "<input type='button' value='목록'  onclick='location.href=\"./create.do?trip_no=" +dto.getTrip_no() + "\"'>");
		}//if end 
		
	
	}// createProc() end 
		
	  @RequestMapping(value="/trip/update.do", method=RequestMethod.GET)
	    public ModelAndView updateForm(TripDTO dto) {
	        ModelAndView mav = new ModelAndView();
	        mav.setViewName("trip/updateForm");
	        mav.addObject("root", Utility.getRoot());
	       
	        return mav;
	    }//updateForm() end
	     

	    @RequestMapping(value="/trip/update.do", method=RequestMethod.POST)
	    public ModelAndView updateProc(TripDTO dto) {
	        ModelAndView mav = new ModelAndView();
	        mav.setViewName("trip/msgView");
	        int cnt = dao.update(dto);
	        if(cnt == 0) {
	            mav.addObject("msg1",  "<p> 여행상품 목록 수정 실패</p>");
	            mav.addObject("img",   "<p><img src='./images/fail.png'></p>");
	            mav.addObject("link1", "<input type='button' value='다시시도' onclick='javascript:history.back()'>");
	            mav.addObject("link2", "<input type='button' value='그룹목록' onclick='location.href=\"./list.do\"'>");
	        } else {
	            mav.addObject("msg1",  "<p> 여행상품 목록 수정 성공</p>");
	            mav.addObject("img",   "<p><img src='./images/sound.png'></p>");
	            mav.addObject("link1", "<input type='button' value='그룹목록' onclick='location.href=\"./list.do\"'>");   
	        }
	        return mav;   
	      }//updateProc() end 
	
		
	}// class() end 
