package com.fastcampus.ch3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DITest {
	
	public static void main(String[] args) throws Exception {

		ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
		
		Car car = (Car) ac.getBean("car");
		Car car2 = ac.getBean("car", Car.class);
//		Engine engine = (Engine) ac.getBean("engine");
//		Door door = (Door) ac.getBean("door");
		
		// Car 객체에 속성값 넣기 - 방법(1)
		car.setColor("red");
		car.setOil(100);
//		car.setEngine(engine);
		car.setDoors(new Door[] {ac.getBean("door", Door.class), ac.getBean("door", Door.class)});
		
		// Car 객체에 속성값 넣기 - 방법(2), 방법(3)
		// src/main/resources/config.xml 참조
		
		System.out.println("car="+car);
//		System.out.println("car2="+car2);
//		System.out.println("engine="+engine);
//		System.out.println("door="+door);

	}
	
}
