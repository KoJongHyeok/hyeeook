public class Sort {

	public static void main(String[] args) throws Exception {

		int[] iArr = { 9, 3, 6, 1, 4, 55, 2, 30 };
		bubbleSort(iArr);
		selectionSort(iArr);
		insertionSort(iArr);
		System.out.println(Arrays.toString(iArr));

	}

	static void swap(int[] arr, int x, int y) {
		int tmp = 0;

		tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
	
	static void bubbleSort(int[] iArr) {
		for (int i = iArr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (iArr[j] > iArr[j + 1]) {
					swap(iArr, j, j + 1);
				}
			}
		}
	}
	
	static void selectionSort(int[] iArr) {
		int minIndex = 0;
		for (int i = 0; i < iArr.length - 1; i++) {
			minIndex = i;
			
			for (int j = i + 1; j < iArr.length; j++) {
				if (iArr[minIndex] > iArr[j]) {
					minIndex = j;
				}
			}
			swap(iArr, minIndex, i);
		}
	}
	
	static void insertionSort(int[] iArr) {
		int target = 0;
		for (int i = 1; i < iArr.length; i++) {
			int j = i - 1;
			target = iArr[i];
			while (j >= 0 && iArr[j] > target) {
				iArr[j + 1] = iArr[j];
				j--;
			}
			iArr[j + 1] = target;
		}
	}

}
