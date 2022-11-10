
public class Car {

//  ----------------------------------------------------------------------
//  >> 변수
	String color;
	String gearType;
	int door;

//  ----------------------------------------------------------------------
//  >> 메서드
	
	void drive() {
		System.out.println("Drive, Brrr~");
	}
	
	void stop() {
		System.out.println("Stop!");
	}

//  ----------------------------------------------------------------------
//  >> 생성자
	Car() {
		this("white", "auto", 4);
	}

	Car(String color, String gearType, int door) {
		this(color);
		this.gearType = gearType;
		this.door = door;
	}

	Car(String color) {
		this.color = color;
	}

}
