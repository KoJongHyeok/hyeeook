package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller		// 1. 프로그램 등록
public class Hello {
	
//	@RequestMapping("/hello")	// 2. URL과 main()을 연결
//	public void main() {		// 톰캣 내부에서 객체를 생성해주기 때문에 인스턴스 메서드도 호출 가능
//		System.out.println("Hello! - instance");
//	}

//	@RequestMapping("/hello")	// 2. URL과 main()을 연결
//	public static void main() {
//		System.out.println("Hello! - static");
//	}
	
	@RequestMapping("/hello")	// 2. URL과 main()을 연결
	private void main() {		// @RequestMapping을 수행한다는 것은 외부에서 해당 메서드를 사용한다는 것
		System.out.println("Hello! - private");	// 접근 제어자에 상관없이 호출 가능
	}
	
}
