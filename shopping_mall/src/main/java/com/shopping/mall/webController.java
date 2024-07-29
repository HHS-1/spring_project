package com.shopping.mall;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class webController extends md5_pass {

	PrintWriter pw = null;
	@Resource(name = "userselect")
	private user_select us;
	@PostMapping("/passmodify.do")
	public String passsmodify() {
			
		return null;
	}
	
	
	@PostMapping("/idsearch.do")
	public String idsearch(@RequestParam String uname, String uemail, HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=utf-8");

		System.out.println(uname);
		System.out.println(uemail);
		this.pw = res.getWriter();
		
		try {
			if(uname == null || uemail == null) {
				this.pw.print("<script>"
						+ "alert('올바른 접근방식이 아닙니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}else {
				ArrayList<Object> onedata = us.search_id(uname, uemail);
				System.out.println(onedata);
			}
		}catch(Exception e) {
			System.out.println(e);
			this.pw.print("<script>"
					+ "alert('에러');"
					+ "history.go(-1);"
					+ "</script>");
		}finally {
			
		}
		
		return null;
	}

	//패스워드 변경 여부를 체크(MD5)
	@GetMapping("/passwd.do")
	public String passwd() {
		String pwd = "a1234";
		String result = this.md5_making(pwd);
		System.out.println(result);
		return null;
	}
	
	
	//@SessionAttribute : session이 이미 등록되어 있는 상황일 경우 해당 정보를 가져올 수 있음
	@GetMapping("/restapi.do")
	public String restapi(@SessionAttribute(name="mid", required = false) String mid) throws Exception {
		if(mid == null) {
			System.out.println("로그인 해야만 장바구나를 확인하실 수 있습니다.");
		}
		return null;
	}
	//HttpSession : interface를 활용하여, 세션을 빠르게 구현하는 방식
	@PostMapping("/loginok.do")
	public String loginok(@RequestParam String mid, HttpSession session) {
		if(mid != null) {
			session.setAttribute("mid", mid);
			System.out.println(mid);
		}
		return null;
	}

	@PostMapping("/ajaxok3.do")
	@ResponseBody
	public String ajaxok3(@RequestBody List<BasketDto> data) {		
		System.out.println(data);
		return "ok";
	}
	
	/*public String ajaxok3(@RequestBody String arr) {
		JSONArray ja1 = new JSONArray(arr);
		JSONArray ja2 = new JSONArray(ja1.get(0));
		JSONArray ja3 = new JSONArray(ja1.get(1));
		System.out.println(ja2.get(0));
		System.out.println(ja3.get(0));
		return "ok";
	}*/
	
	
	@PostMapping("/ajaxok2.do")
	@CrossOrigin(origins = "*", allowedHeaders= "*")
	public String ajaxok2(@RequestBody all_data_dto all_data) {
		 System.out.println(all_data.getAll_data());
		 System.out.println(all_data.getHa());

		 return null;
	}
	
	
	
	@PostMapping("/ajaxok.do")
	@ResponseBody
	@CrossOrigin(origins = "*", allowedHeaders= "*")
	public String ajaxok(@RequestBody String alldata) {
		JSONObject ja = new JSONObject(alldata);
		JSONArray data = ja.getJSONArray("alldata");
		System.out.println(data.get(1));

		return null;
	}
	
}
