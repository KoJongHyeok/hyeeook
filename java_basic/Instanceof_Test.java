class Car {}
class SportsCar extends Car {}

public class Instanceof_Test {

	public static void main(String[] args) {
		Object object = new Object();
		Car car = new Car();
		SportsCar sportsCar = new SportsCar();
		
		boolean useChild_WithParent = sportsCar instanceof Car;	// true
		boolean useParent_WithChild = car instanceof SportsCar;	// false
		
		System.out.println(useChild_WithParent);
		System.out.println(useParent_WithChild);
	}
}
