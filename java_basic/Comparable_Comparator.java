public interface Comparable {	// 객체의 기본 정렬 기준을 구현하는 데 사용.
	int compareTo(Object o);	// 주어진 객체(o)를 자신(this)과 비교.
	// 반환값이 1 : 본 객체(this)가 큼.
	// 반환값이 0 : 같음.
	// 반환값이 -1 : 매개변수 객체(o)가 큼.
}

public interface Comparator {	// 기본 정렬 기준 외에 다른 기준으로 정렬하고자 할 때 사용.
	int compare(Object o1, Object o2);	// o1, o2 두 객체를 비교.
	// 반환값이 + : 좌측(o1)이 큼.
	// 반환값이 0 : 같음.
	// 반환값이 - : 우측(o2)이 큼.
}

// 정렬 및 Set에 저장 등을 수행할 때,
// 정렬 기준(Comparator)을 반드시 입력해야 함.
// 정렬 기준을 생략한 경우는 정렬 및 저장되는 객체의 기본 정렬 기준(Comparable)을 사용함.

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
	//		>> sort() 메서드에 매개변수로 들어갈 수 있는 정렬 기준은 'Comparator'만 가능.
	// final class String implements ..., Comparable, ...
	//		>> String 클래스는 Comparable 인터페이스를 구현.
class Descending implements Comparator {
	// sort() 메서드에 정렬 기준으로 들어가는 Descending 클래스는 Comparator 인터페이스를 구현.
	// 문자열(String)의 실제 정렬 기준이 작성된 compare() 메서드 안에는 Comparable 인터페이스로 형변환.
	@Override
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable) o1;
			Comparable c2 = (Comparable) o2;
			return c2.compareTo(c1);	// 또는 return c1.compareTo(c2) * -1;
		}
		return -1;
	}
}

// -----------------------------------------------------------------------------------

	// 정렬 : 두 대상을 비교해서 자리바꿈을 반복하는 것.
	// 선택 정렬, 버블 정렬 등 어떤 정렬이든 자리 바꾸는 것은 똑같음.
	// 변하는 것은 전략(정렬 기준).
	
	// 그래서 이미 최고의 효율을 낼 수 있도록 자리 바꾸는 코드는 작성되어 있음.
	// 우리는 전략(정렬 기준)만 제공하면 됨.
	// 정렬하는(자리 바꾸는) 코드를 우리가 직접 작성할 필요 없음.

	static void bubbleSort(int[] iArr) {
		for (int i = iArr.length - 1; i > 0; i--) {
			for (int j = 0, tmp = 0; j < i; j++) {

				if (iArr[j] > iArr[j + 1]) { // 정렬(비교)을 어떻게 할지 기준을 제시하는 부분으로 이 부분만 변함.
					
					tmp = iArr[j];
					iArr[j] = iArr[j + 1];
					iArr[j + 1] = tmp;
				}
			}
		}
	}
