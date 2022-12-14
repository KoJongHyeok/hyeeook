# Arrays
- 배열을 다루기 편리한 메서드(static) 제공.

| 메서드 | 특징 |
|:-----:|:-----:|
| static String ***toString(int[] a)*** | 배열 출력 |
| static int[] ***copyOf(int[] original, int newLength)*** | 배열 복사 |
| static int[] ***copyOfRange(int[] original, int from, int to)*** | 배열 복사 |
| static void ***fill(int[] a, int val)*** | 배열 채우기 |
| static void ***setAll(int[] array, IntUnaryOperator generator)*** | 배열 채우기 |
| static void ***sort(int[] a)*** | 정렬 |
| static int ***binarySearch(int[] a, int key)*** | 검색(반드시 먼저 정렬되어있어야 함) |
| static String ***deepToString(Object[] a)*** | 다차원 배열 출력 |
| static boolean ***deepEquals(Object[] a1, Object[] a2)*** | 다차원 배열 비교 |
| static List ***asList(Object... a)*** | 배열을 List로 변환(읽기 전용) |

*** Object... a : 가변 매개변수, (0 ~ n) 개 매개변수 입력 가능. 아무것도 안 넣어도 되고 한 개만 넣어도 됨.
___

### 순차 탐색(검색)과 이진 탐색(검색)
> 순차 탐색
> - 찾으려는 요소를 차례대로 하나씩 검색하는 방법.
> - 정렬할 필요 없음. `{ 7, 1, 6, 9, 5, 3, 8, 4, 10, 2 }`
> - 10개 요소 중 원하는 요소를 찾는데 필요한 평균 검색 횟수 : 5.5회

> 이진 탐색
> - 전체를 반으로 나눠서(두 개의 검색 구간으로 계속 구분해가면서) 찾으려는 요소가 있는 부분만 검색하는 방법.
> - 먼저 정렬해야 함. `{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }`
> - 정렬하고 검색해야 하므로 정렬 속도를 높여야 함.
> - '10'이라는 요소를 찾는데 필요한 검색 횟수 : 3회
