interface Inheritance_Interface {
	public abstract void inheritanceTest();
}

class Inheritance_Parent implements Inheritance_Interface {
	public void inheritanceTest() {
		System.out.println("inheritanceTest()");
	}
}

class Inheritance_Child extends Inheritance_Parent {}

public class Test {

	public static void main(String[] args) {

		Inheritance_Interface inheritTest_Parent = new Inheritance_Parent();
		Inheritance_Interface inheritTest_Child = new Inheritance_Child();
		inheritTest_Parent.inheritanceTest();
		inheritTest_Child.inheritanceTest();
		
	}

}

/*	출력 결과

inheritanceTest()
inheritanceTest()

*/
