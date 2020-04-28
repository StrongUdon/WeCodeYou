package com.it.wecodeyou.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.it.wecodeyou.member.model.MemberVO;
import com.it.wecodeyou.member.service.IMemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private IMemberService service;
	@Autowired
	JavaMailSender mailSender; //메일 서비스를 사용하기 위해 의존성을 주입함
	
	
	//회원가입 페이지 처리
	//RestController 에서 viewResolver로 보낼땐 ModelAndView 사용
	@GetMapping("/")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/join-form");
		return mv;
	}
	
	
	
	//회원가입 요청 처리
	//RestController에서는 insert 작업을 post로 처리
	@PostMapping("/")
	public String register(@RequestBody MemberVO mvo) {
		System.out.println("/member/ : 회원가입 POST 요청 발생!");
		System.out.println("param: "+mvo);
		
		service.insertMember(mvo);
		
		return "joinSuccess";
	}
	
	
	//회원탈퇴 요청 처리
	@DeleteMapping("{userNo}")
	public String delete(@PathVariable Integer userNo) {
		System.out.println("/member/"+userNo+" : 탈퇴 DELETE 요청 발생!");
		
		service.deleteMember(userNo);
		
		return "delSuccess";
	}
	
	
	//회원정보 조회 요청 처리 (한 사람 조회)
	@GetMapping("{userNo}")
	public MemberVO selectOne(@PathVariable Integer userNo) throws SQLException {
		System.out.println("/member/"+userNo+" : 회원정보 조회 GET 요청 발생!");
		
		return service.getOneInfo(userNo);		
	}
	
	
	//회원 리스트 조회 요청 처리 (전체 회원 조회 - 관리자 위한 기능)
	@GetMapping("/list")
	public List<MemberVO> selectAll() throws SQLException{
		System.out.println("/member/list : 전체 회원 리스트 조회 GET 요청 발생!");
		
		List<MemberVO> list = service.getAllInfo();
		
		return list;
	}
	
	
	//이메일 중복확인 요청 처리
	@PostMapping("/checkEmail")
	public String checkEmail(@RequestBody String userEmail) {
		System.out.println("/member/checkEmail : 이메일 중복확인 POST 요청 발생!");
		System.out.println("param: "+userEmail);
		
		String result = null;
		
		Integer cnt = service.checkEmail(userEmail);
		
		if(cnt == 1) {	// 이메일 중복일때
			System.out.println("이메일 중복!");
			result="NO";
		} else {		// 이메일 중복 아님
			System.out.println("이메일 사용 가능!");
			result="OK";
		}
		
		return result;
	}

	//전화번호 중복확인 요청 처리
	@PostMapping("/checkTel")
	public String checkTel(@RequestBody String userTel) {
		System.out.println("/member/checkTel : 전화번호 중복확인 POST 요청 발생!");
		System.out.println("param: "+userTel);
		
		String result=null;
		
		Integer cnt = service.checkTel(userTel);
		
		if(cnt == 1) {	//전화번호 중복일때
			System.out.println("전화번호 중복!");
			result="NO";
		} else {		//전화번호 중복아님
			System.out.println("전화번호 사용 가능!");
			result="OK";
		}
		return result;
	}

	
		//로그인 페이지 처리
		@GetMapping("/login")
		public ModelAndView login() {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/member/login-form");
			return mv;
		}
		
		//로그인 요청 처리
		@PostMapping("/loginCheck")
		public String loginCheck(@RequestBody MemberVO inputData, HttpSession session) throws SQLException {
			System.out.println("/member/loginCheck : 로그인 POST 요청 발생!");
			String result=null;
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();	//비밀번호 암호화 하여 db 저장하기 위한 객체 선언
			
			System.out.println(inputData.getUserEmail());
			MemberVO dbData = service.checkLogin(inputData.getUserEmail());
			
			if(dbData != null) {
				if(encoder.matches(inputData.getUserPw(), dbData.getUserPw())) {
					session.setAttribute("login", dbData);
					result="loginSuccess";
				} else {
					result="pwFail";
				}
			} else {
				result="emailFail";
			}
			
			return result;
		}

	//로그아웃 요청 처리
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		System.out.println("/member/logout : 로그아웃 GET 요청 발생!");
		MemberVO mvo = (MemberVO) session.getAttribute("login");
		
		if(mvo != null) {
			session.removeAttribute("login");
			session.invalidate();
		}
		return new ModelAndView("redirect:/");
	}

	
	//이메일 인증 페이지 맵핑 메서드
	@GetMapping("/email-form")
	public ModelAndView email() {
		System.out.println("/member/email-form : 이메일 인증 form GET 요청 발생!");
		
		return new ModelAndView("/member/email-form");
	}
	
	 //mailSending
	   @PostMapping("/auth")
	   public ModelAndView emailSending(HttpServletRequest request, String userEmail, HttpServletResponse response, HttpSession session) throws IOException {
	     ModelAndView mv=new ModelAndView();   //ModelAndView로 보낼 페이지를 지정하고 보낼 값을 지정한다
	     response.setContentType("text/html; charset=UTF-8");
	     PrintWriter out_email = response.getWriter();
	         
	     //중복된 경우 -> 다시 email-form으로 
	     if(checkEmail(userEmail).equals("NO") || userEmail.equals("")){// 중복되면 
	        mv.setViewName("/member/login-form");  
	         
	         System.out.println("view: "+mv.getViewName());
	         out_email.println("<script>alert('이메일을 확인해 주세요.');</script>");
	         out_email.flush();
	     
	     }else{
	      
	        System.out.println("/member/auth : 이메일 인증번호 발송 POST 요청 발생!");
	        System.out.println("받는사람 이메일주소: "+userEmail);
	      
	         
	         Random r = new Random();
	         int dice = r.nextInt(4589362)+49311;
	         
	         String setFrom =  "kouri1004@gmail.com"; //보내는 사람(관리자) 이메일
	         String tomail = request.getParameter("userEmail"); //받는 사람 이메일
	         String title = "[WeCodeYou] 회원가입 인증 번호 발송";   //제목
	         String content =
	               //한줄씩 줄간격을 두기 위해 작성
	               System.getProperty("line.separator")+System.getProperty("line.separator")+
	               "안녕하세요, 회원님. 저희 [WeCodeYou]를 찾아주셔서 감사합니다."+System.getProperty("line.separator")+
	               "인증번호는 "+dice+" 입니다."+System.getProperty("line.separator")+
	               "홈페이지로 돌아가 위 인증번호를 입력해주시면 회원가입이 진행됩니다."+System.getProperty("line.separator");
	         
	         try {
	            MimeMessage message = mailSender.createMimeMessage();
	            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true,"UTF-8");
	            messageHelper.setFrom(setFrom);   //보내는사람 생략하면 정상작동 안함
	            messageHelper.setTo(tomail);   //받는사람 이메일
	            messageHelper.setSubject(title);//메일제목 (생략가능)
	            messageHelper.setText(content); //메일 내용
	            
	            mailSender.send(message);
	         } catch (MessagingException e) {
	            e.printStackTrace();
	         }
	         
	         mv.setViewName("/member/email-auth");
	         session.setAttribute("user_email", userEmail);
	         session.setAttribute("dice", dice);
	         
	         System.out.println("view: "+mv.getViewName()   + "   인증 code: "+dice);
	         out_email.println("<script>alert('인증번호가 이메일로 발송되었습니다. 확인 후 인증번호를 입력해주세요.');</script>");
	         out_email.flush();
	         
	     }
	     return mv;
	   }
	
		
	//이메일로 받은 인증번호를 입력하고 확인버튼을 누르면 맵핑되는 메서드
	//내가 입력한 인증번호와 메일로 받은 인증번호가 맞는지 확인해서 맞으면 회원가입 페이지로 넘기고 틀리면 다시 원래 페이지로 돌아오는 메소드
	@PostMapping("/join_auth")
	public ModelAndView join_auth(String email_auth, HttpServletResponse response, HttpServletRequest request, HttpSession session) throws IOException {
		String dice = request.getParameter("dice");
		
		System.out.print("사용자 입력 code: "+email_auth);
		System.out.println("\t\t인증 code: "+dice);
		
		//페이지 이동과 자료를 동시에 하기 위해 ModelAndView를 사용해서 이동할 페이지와 자료를 담음
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/join");
		mv.addObject("email_auth", email_auth);
		if(email_auth.equals(dice)) {
			//인증번호가 일치할 경우 인증번호가 맞다는 창을 출력하고 회원가입창으로 이동함
			session.removeAttribute("dice");
			mv.setViewName("member/join-form");
			mv.addObject("email_auth", email_auth);
			
			//만약 인증번호가 같다면 이메일을 회원가입 페이지로 같이 넘겨서 이메일을 한번더 입력할 필요가 없게 한다.
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out_equals = response.getWriter();
			out_equals.println("<script>alert('이메일 인증 성공! 회원가입 페이지로 이동합니다.');</script>");
			out_equals.flush();
			
			return mv;
		}else{
			ModelAndView mv2 = new ModelAndView();
			mv2.setViewName("/member/email-auth");
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out_equals = response.getWriter();
			out_equals.println("<script>alert('인증번호가 일치하지 않습니다. 인증번호를 다시 입력해주세요!');</script>");
			out_equals.flush();
			
			return mv2;
		}
		
	}
	
	//이메일,비번찾기 페이지 요청 
	@GetMapping("/find-form")
	public ModelAndView find(ModelAndView mv, HttpServletRequest req) {
	   
		mv.setViewName("member/find-form");
		mv.addObject("target", req.getParameter("target"));
		return mv;
		
	}
	

	   //이메일 찾기
	   @PostMapping("/findEmail")
	   public ModelAndView findEmail(ModelAndView mv , HttpServletRequest req) {

	      MemberVO mvo = new MemberVO();
	      mvo.setUserName(req.getParameter("userName"));
	      mvo.setUserTel(req.getParameter("userTel"));
	      if(service.findEmail(mvo) == null) {
	         // 없어서 널이 나왔다. 
	         //model.addAttribute("msg", "입력하신 정보에 맞는 계정이 없습니다.");
	      
	         mv.setViewName("member/find-form");
	          mv.addObject("msg", "입력하신 정보에 맞는 계정이 없습니다.");
	          
	      }else {
	         
	         String email = service.findEmail(mvo).getUserEmail();
	         String id = email.split("@")[0];
	         String email_host = email.split("@")[1];
	        
	         email = id.substring(0,id.length()-2)+"**@"+email_host;
	         //model.addAttribute("msg", "찾으시는 계정은 "+email);
	         mv.setViewName("member/find-form");
	         mv.addObject("msg", "찾으시는 계정은 "+email);
	         
	         
	      }
	      return mv;
	   }
	   
	   
	   //임시비밀번호 발송
	   @PostMapping("/findPw")
	   public ModelAndView findPw(HttpServletRequest request, String userEmail, HttpServletResponse response, HttpSession session) throws IOException {
	      System.out.println("/member/findPw : 임시비밀번호 발송 POST 요청 발생!");
	      System.out.println("받는사람 이메일주소: "+userEmail);
	                
	      String uuid = UUID.randomUUID().toString().replaceAll("-", ""); // -를 제거해 주었다.
	      uuid = uuid.substring(0, 10); //uuid를 앞에서부터 10자리 잘라줌.
	      System.out.println(uuid);
	      
	      MemberVO mvo = new MemberVO();
	      mvo.setUserEmail(userEmail);
	      mvo.setUserPw(uuid);
	      service.changePw(mvo);
	      
	      String setFrom =  "kouri1004@gmail.com"; //보내는 사람(관리자) 이메일
	      String tomail = request.getParameter("userEmail"); //받는 사람 이메일
	      String title = "[WeCodeYou] 임시비밀번호 발송";   //제목
	      String content =
	            //한줄씩 줄간격을 두기 위해 작성
	            System.getProperty("line.separator")+System.getProperty("line.separator")+
	            "안녕하세요, 회원님. 저희 [WeCodeYou]를 찾아주셔서 감사합니다."+System.getProperty("line.separator")+
	            "임시 비밀번호는 "+uuid+" 입니다."+System.getProperty("line.separator")+
	            "로그인 후 비밀번호 변경을 꼭 진행해주시길 바랍니다."+System.getProperty("line.separator");
	      
	      try {
	         MimeMessage message = mailSender.createMimeMessage();
	         MimeMessageHelper messageHelper = new MimeMessageHelper(message, true,"UTF-8");
	         messageHelper.setFrom(setFrom);   //보내는사람 생략하면 정상작동 안함
	         messageHelper.setTo(tomail);   //받는사람 이메일
	         messageHelper.setSubject(title);//메일제목 (생략가능)
	         messageHelper.setText(content); //메일 내용
	         
	         mailSender.send(message);
	      } catch (MessagingException e) {
	         e.printStackTrace();
	      }
	      
	      ModelAndView mv=new ModelAndView();   //ModelAndView로 보낼 페이지를 지정하고 보낼 값을 지정한다
	      mv.setViewName("/member/login-form");
	      
	      System.out.println("view: "+mv.getViewName()   + "   임시 비밀번호: "+uuid);
	      
	      response.setContentType("text/html; charset=UTF-8");
	      PrintWriter out_email = response.getWriter();
	      out_email.println("<script>alert('임시비밀번호가 이메일로 발송되었습니다. 확인 후 로그인해주세요.');</script>");
	      out_email.flush();
	      
	      return mv;
	   }
	
	
}
