package kr.co.tripChoice;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * mymelon 프로젝트의 첫페이지 호출 http://localhost:9090/tripChoice/index.do
 */
@Controller
public class HomeController {

	public HomeController() {
		System.out.println("--------HomeController()객체 생성됨");
	}

	/*
	 * mymelon프로젝트의 첫페이지 호출 http://localhost:9090/tripChoice/index.do
	 */

	@RequestMapping("/index.do")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index/index");
		return mav;
	}// home() end

	@RequestMapping(value = "mailForm.do", method = RequestMethod.GET)
	public String mailForm() {
		return "mail/mailForm";
	}

	@RequestMapping(value = "mailProc.do", method = RequestMethod.POST)
	public ModelAndView mailProc() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mail/mailProc");
		return mav;
	}

}// class end
