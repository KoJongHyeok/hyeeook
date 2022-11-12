
public class Time {
	
//  ----------------------------------------------------------------------
//  >> 변수
	private int hour;
	private int minute;
	private int second;
	
//  ----------------------------------------------------------------------
//  >> 메서드
	public void setHour(int hour) {
		if(!(0<=hour&&hour<=23)) {
			System.out.println("잘못된 시간을 입력했소!");
			return;
		}
		this.hour = hour;
	}
	
	public int getHour() {
		return this.hour;
	}
	

//  ----------------------------------------------------------------------
//  >> 생성자
	Time() {super();}
	
}
