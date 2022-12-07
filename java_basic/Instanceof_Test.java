class Car {}
class SportsCar extends Car {}

public class Instanceof_Test {

	public static void main(String[] args) {
		Object object = new Object();
		Car car = new Car();
		SportsCar sportsCar = new SportsCar();
		
		// 생성된 실제 child 객체를 parent 타입의 참조변수로 사용해도 되냐는 의미.
		boolean useChild_WithParent = sportsCar instanceof Car;	// true
		
		// 생성된 실제 parent 객체를 child 타입의 참조변수로 사용해도 되냐는 의미.
		boolean useParent_WithChild = car instanceof SportsCar;	// false
		
		System.out.println(useChild_WithParent);
		System.out.println(useParent_WithChild);
	}
}
