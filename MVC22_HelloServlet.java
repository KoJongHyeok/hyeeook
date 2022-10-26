package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
//		서블릿이 초기화될 때 자동 호출되는 메서드, 처음에 한 번만 호출됨
//		1. 서블릿의 초기화 작업 담당
		System.out.println("[HelloServlet] init() is called.");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		요청이 올 때마다 반복적으로 호출되며 요청을 처리함
//		2-1. 입력
//		2-2. 처리
//		2-3. 출력
		System.out.println("[HelloServlet] service() is called.");
	}

	@Override
	public void destroy() {
//		3. 서블릿이 메모리에서 내려올 때, 서블릿이 새로 갱신되서 리로딩될 때, 웹애플리케이션이 종료될 때 뒷마무리 작업을 위해 서블릿 컨테이너에 의해 자동 호출됨
		System.out.println("[HelloServlet] destroy() is called.");
	}

}
