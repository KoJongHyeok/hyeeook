package com.fastcampus.ch2;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTeller {
	
	@RequestMapping("/getYoil")
	public static void main(HttpServletRequest request) {
//		1. 입력
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
//		2. 작업
		int yyyy = Integer.valueOf(year);
		int mm = Integer.valueOf(month);
		int dd = Integer.valueOf(day);
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm-1, dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		char yoil = " 일월화수목금토".charAt(dayOfWeek);
		
//		3. 출력
		System.out.print(year + "년 " + month + "월 " + day + "일은 ");
		System.out.println(yoil + "요일입니다.");
		
		
	}

}

//	target 우측 클릭 >> show in >> Terminal >> cd classes
//	>> java com.fastcampus.ch2.YoilTeller args[0] args[1] args[2]

//	브라우저로 URL을 입력해서 원격 프로그램을 호출하는 과정도 이와 같음.
//	자바 인터프리터가 매개변수로 받은 값을 문자열 배열로 만들어서 해당 메서드에게 넘겨주는 것처럼,
//	톰캣이 URL로 요청받은 정보를 HttpServletRequest 객체를 만들어서 담고 해당 메서드에 넘겨줌.
