package kr.co.tripChoice.tuser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TuserCont {
	
	private TuserDAO dao;
	
	public TuserCont() {
		System.out.println("---TuserCont()객체 생성됨");
	}
	
	//페이지 호출
	@RequestMapping(value="loginForm.do", method =RequestMethod.GET)
	public String loginForm() {
		return "tuser/loginForm";
	}
	//public String 
	@RequestMapping(value="loginProc.do", method =RequestMethod.POST)
    public ModelAndView loginProc(TuserDTO dto) {
        ModelAndView mav = new ModelAndView ();
        mav.setViewName ( "tuser/loginProc");
        return mav;
	}
	@RequestMapping(value="logout.do", method =RequestMethod.GET)
	public String logout() {
		return "tuser/logout";
	}
	@RequestMapping(value="agreement.do", method =RequestMethod.GET)
	public String agreement() {
		return "tuser/agreement";
	}
	@RequestMapping(value = "emailCheckForm.do", method = RequestMethod.GET)
	public String emailCheckForm() {
		return "tuser/emailCheckForm";
	}
	@RequestMapping(value = "emailCheckProc.do", method = RequestMethod.GET)
	public String emailCheckProc() {
		return "tuser/emailCheckProc";
	}
	@RequestMapping(value="findID.do", method =RequestMethod.GET)
	public String findID() {
		return "tuser/findID";
	}
	@RequestMapping(value="findIDProc.do", method =RequestMethod.GET)
	public String findIDProc() {
		return "tuser/findIDProc";
	}
	@RequestMapping(value = "idCheckForm.do", method = RequestMethod.GET)
	public String idCheckForm() {
		return "tuser/idCheckForm";
	}
	@RequestMapping(value = "idCheckProc.do", method = RequestMethod.GET)
	public String idCheckProc() {
		return "tuser/idCheckProc";
	}
	@RequestMapping(value="memberForm.do", method =RequestMethod.GET)
	public String memberForm() {
		return "tuser/memberForm";
	}
	@RequestMapping(value="memberModify.do", method =RequestMethod.GET)
	public String memberModify() {
		return "tuser/memberModify";
	}
	@RequestMapping(value="memberModifyProc.do", method =RequestMethod.POST)
    public ModelAndView memberModifyProc(TuserDTO dto) {
        ModelAndView mav = new ModelAndView ();
        mav.setViewName ( "tuser/memberModifyProc");
        return mav;
	}
	@RequestMapping(value="memberProc.do", method =RequestMethod.POST)
    public ModelAndView memberProc(TuserDTO dto) {
        ModelAndView mav = new ModelAndView ();
        mav.setViewName ( "tuser/memberProc");
        return mav;
	}
	@RequestMapping(value="memberWithdraw.do", method =RequestMethod.GET)
	public String memberWithdraw() {
		return "tuser/memberWithdraw";
	}
	@RequestMapping(value="memberWithdrawProc.do", method =RequestMethod.POST)
    public ModelAndView memberWithdrawProc(TuserDTO dto) {
        ModelAndView mav = new ModelAndView ();
        mav.setViewName ( "tuser/memberWithdrawProc");
        return mav;
	}

}
