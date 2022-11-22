package com.fastcampus.ch3;

import java.util.Arrays;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {

//	------------------------------------------------------------
//	변수
	
	String Color;
	int oil;
	Engine engine;
	Door[] doors;
	
//	------------------------------------------------------------
//	getter, setter

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public int getOil() {
		return oil;
	}

	public void setOil(int oil) {
		this.oil = oil;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Door[] getDoors() {
		return doors;
	}

	public void setDoors(Door[] doors) {
		this.doors = doors;
	}

//	------------------------------------------------------------
//	toString
	
	@Override
	public String toString() {
		return "Car [Color=" + Color + ", oil=" + oil + ", engine=" + engine + ", doors=" + Arrays.toString(doors)
				+ "]";
	}

//	------------------------------------------------------------
//	생성자
	
	public Car() {super();}
	public Car(String color, int oil, Engine engine, Door[] doors) {
		super();
		Color = color;
		this.oil = oil;
		this.engine = engine;
		this.doors = doors;
	}

}

class Engine {}
class Door {}
