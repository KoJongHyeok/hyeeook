
public class Tank extends Unit {
	
//  ----------------------------------------------------------------------
//  >> 변수

//  ----------------------------------------------------------------------
//  >> 메서드
	@Override
	void move(int x, int y) {
		System.out.println("Tank (x : " + x + ", y : " + y + ") 이동!");
	}

//  ----------------------------------------------------------------------
//  >> 생성자
	Tank() {super();}
	
}