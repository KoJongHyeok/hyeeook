package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TwoDice {
	
	@RequestMapping("/rollDice")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();	// response 객체에서 브라우저로의 출력 스트림을 얻음
		
		int idx1 = (int)(Math.random()*6)+1;
		int idx2 = (int)(Math.random()*6)+1;
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<img src='img/dice" + idx1 + ".jpg'>");
		out.println("<img src='img/dice" + idx2 + ".jpg'>");
		out.println("</body>");
		out.println("</html>");
		
	}

}

//	이미지 파일과 같은 정적 리소스는 src/main/webapp/resources에 생성
