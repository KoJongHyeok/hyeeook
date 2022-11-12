
public class Tv extends Product {

//  ----------------------------------------------------------------------
//  >> 변수
	String color;
	boolean power;
	int channel;

//  ----------------------------------------------------------------------
//  >> 메서드
	public void power() 		{ power = !power; }
	public void channelUp() 	{ channel++; }
	public void channelDown()	{ channel--; }
	
	@Override
	public String toString() {
		return "Tv";
	}
	
//  ----------------------------------------------------------------------
//  >> 생성자
	Tv() {super(100);}

}
