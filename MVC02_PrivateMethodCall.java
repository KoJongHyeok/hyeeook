package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) throws Exception {
		
//		Hello hello = new Hello();
//		hello.main();	// private라서 외부 호출 불가
		
//		톰캣에서는 호출 가능한 이유
//		Reflection API를 사용 - 클래스 정보를 얻고 다룰 수 있는 강력한 기능을 제공
//		java.lang.reflect 패키지를 제공
		
//		1. Hello 클래스의 Class 객체(클래스의 정보를 담고 있는 객체)를 얻어옴
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
//		2. Class 객체가 가진 정보로 Hello 객체를 생성
		Hello hello = (Hello)helloClass.newInstance();
//		3. Hello 클래스의 main() 정보를 가져옴
		Method main = helloClass.getDeclaredMethod("main");
//		4. private인 main()에 접근 가능하도록
		main.setAccessible(true);
//		5. hello.main()
		main.invoke(hello);
		
		
		
//		Spring Framework은 위와 같은 방식으로 자바의 Reflection API를 이용해서 객체를 만듦. 
	}
}
