
public abstract class Unit {
	
//  ----------------------------------------------------------------------
//  >> 변수
	int x, y;

//  ----------------------------------------------------------------------
//  >> 메서드
	abstract void move(int x, int y);
	
	void stop() {
		System.out.println("멈추겠소!");
	}

//  ----------------------------------------------------------------------
//  >> 생성자
	Unit() {super();}
	
}
