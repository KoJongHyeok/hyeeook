
public class Fighter extends Unit implements Fightable {
	
//  ----------------------------------------------------------------------
//  >> 변수

//  ----------------------------------------------------------------------
//  >> 메서드
	public void move(int x, int y) {
		System.out.println("[x=" + x + ", y=" + y + "] 이동!");
	}
	
	public void attack(Fightable f) {
		System.out.println(f + "을/를 공격!");
	}
	
	
	Fightable getFighter() {
		return new Fighter();
	}

//  ----------------------------------------------------------------------
//  >> 생성자
	Fighter() {super();}
	
}
