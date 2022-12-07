# Arrays
- 배열을 다루기 편리한 메서드(static) 제공.

| 메서드 | 특징 |
|:-----:|:-----:|
| static String toString(int[] a) | 배열 출력 |
| static int[] copyOf(int[] original, int newLength) | 배열 복사 |
| static int[] copyOfRange(int[] original, int from, int to) | 배열 복사 |
| static void fill(int[] a, int val) | 배열 채우기 |
| static void setAll(int[] array, IntUnaryOperator generator) | 배열 채우기 |
| static void sort(int[] a) | 정렬 |
| static int binarySearch(int[] a, int key) | 검색(반드시 먼저 정렬되어있어야 함) |
