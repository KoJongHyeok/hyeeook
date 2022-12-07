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
