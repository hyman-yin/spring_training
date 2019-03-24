package study.hyman.service.ui;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import study.hyman.dto.TmUser;
import study.hyman.service.biz.UserBizService;

@Controller
@RequestMapping("/user")
public class UserUiService {

	@Autowired
	private UserBizService userBizService;
	
	@RequestMapping(value="/tologin", method=RequestMethod.GET)
	public String toLogin() {
		return "/user/tologin";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView logIn(TmUser tmUser, HttpSession session) {
		boolean result= userBizService.validUser(tmUser);
		if(!result) {
			return new ModelAndView("/user/tologin");
		}
		ModelAndView mav = new ModelAndView("/user/welcome");
		mav.addObject("user", tmUser);
		
		// 把user对象放到session中
		System.out.println("登录session hashcode:"+session.hashCode());
		session.setAttribute("user", tmUser);
		
		return mav;
	}

	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("user");
		return new ModelAndView("/user/tologin");
	}
	
	@RequestMapping(value="/userList",method=RequestMethod.GET)
	public ModelAndView showUser() {
		ModelAndView mav = new ModelAndView("/user/userlist");
		mav.addObject("userList", userBizService.selectAllUser());
		return mav;
	}

	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public ModelAndView addUser(TmUser tmUser) {
		System.out.println("req: "+ tmUser);
		ModelAndView mav = new ModelAndView("/user/userlist");
		userBizService.addUser(tmUser);
		mav.addObject("userList", userBizService.selectAllUser());
		return mav;
	}
	
}
