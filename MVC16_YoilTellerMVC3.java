package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class YoilTellerMVC {
	
	@RequestMapping("/getYoilMVC2")
	public ModelAndView main(int year, int month, int day) throws IOException {
		
		ModelAndView mv = new ModelAndView();
//		1. 유효성 검사
		if (!isValid(year, month, day)) { mv.setViewName("yoilError"); }
		
//		2. 요일 계산
		char yoil = getYoil(year, month, day);
		
//		3. 계산 결과를 ModelAndView에 저장
		mv.addObject("year", year);
		mv.addObject("month", month);
		mv.addObject("day", day);
		mv.addObject("yoil", yoil);
		
//		4. view를 지정
		mv.setViewName("yoil");
		
		return mv;
		
	}

	
	
	private boolean isValid(int year, int month, int day) {
		return true;
	}



	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " 일월화수목금토".charAt(dayOfWeek);
	}

}
