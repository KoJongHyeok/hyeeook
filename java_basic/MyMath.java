
public class MyMath {

//  ----------------------------------------------------------------------
//  >> 변수
	long a, b;

//  ----------------------------------------------------------------------
//  >> 메서드
	public long add() {
		return this.a + this.b;
	}

	public long add(int a, int b) {
		return a + b;
	}

	public static long add(long a, long b) {
		return a + b;
	}

	int add(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}

	long add(int a, long b) {
		return a + b;
	}

	long add(long a, int b) {
		return a + b;
	}

	public long sub(long a, long b) {
		this.a = a;
		this.b = b;
		return this.a - this.b;
	}

//  ----------------------------------------------------------------------
//  >> 생성자
	MyMath() {super();}


}
