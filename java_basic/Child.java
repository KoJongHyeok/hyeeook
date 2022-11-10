
public class Child extends Parent {
	
//  ----------------------------------------------------------------------
//  >> 변수
//	int x = 20;
	
//  ----------------------------------------------------------------------
//  >> 메서드
	
	void method() {
		System.out.println("x = " + x);
		System.out.println("this.x = " + this.x);
		System.out.println("super.x = " + super.x);
	}

//  ----------------------------------------------------------------------
//  >> 생성자
	Child() {super();}
	
}
