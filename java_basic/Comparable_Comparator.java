public interface Comparable {	// 컴퓨터에 정렬 기준을 제시해줄 수 있는 인터페이스.
	int compareTo(Object o);	// 주어진 객체(o)를 자신(this)과 비교.
	// 반환값이 1 : 본 객체(this)가 큼.
	// 반환값이 0 : 같음.
	// 반환값이 -1 : 매개변수 객체(o)가 큼.
}

public interface Comparator {	// 컴퓨터에 정렬 기준을 제시해줄 수 있는 인터페이스.
	int compare(Object o1, Object o2);	// o1, o2 두 객체를 비교.
	// 반환값이 + : 좌측(o1)이 큼.
	// 반환값이 0 : 같음.
	// 반환값이 - : 우측(o2)이 큼.
}

// -----------------------------------------------------------------------------------

public class Comparable_Comparator_Test {

	public static void main(String[] args) {
		
		String[] strArr = {"cat", "Dog", "lion", "tiger"};
		
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr));
		// [Dog, cat, lion, tiger]
		
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(strArr));
		// [cat, Dog, lion, tiger]
		
		Arrays.sort(strArr, new Descending());
		System.out.println(Arrays.toString(strArr));
		// [tiger, lion, cat, Dog]
		
	}

}

	// static void sort(Object[] a, Comparator c)
	//		>> sort() 메서드에 매개변수로 들어갈 수 있는 비교 기준은 'Comparator'만 가능.
	// final class String implements ..., Comparable, ...
	//		>> String 클래스는 Comparable 인터페이스를 구현.
class Descending implements Comparator {
	// sort() 메서드에 비교 기준으로 들어가는 Descending 클래스는 Comparator 인터페이스를 구현.
	// 문자열(String)의 실제 비교 기준이 작성된 compare() 메서드 안에는 Comparable 인터페이스로 형변환.
	@Override
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable) o1;
			Comparable c2 = (Comparable) o2;
			return c2.compareTo(c1);
		}
		return -1;
	}
}
