		

int[] iArr = { 222, 9, 6, 77, 2, 54 };

// 막(?) 정렬
for (int i = 0; i < iArr.length; i++) {
	for (int j = 0, tmp=0; j < iArr.length - 1; j++) {
		if (iArr[j] > iArr[j + 1]) {
			tmp = iArr[j];
			iArr[j] = iArr[j + 1];
			iArr[j + 1] = tmp;
		}
	}
	System.out.println(Arrays.toString(iArr));
}

// 버블 정렬
for (int i=iArr.length-1; i>0; i--) {
	for (int j=0, tmp=0; j<i; j++) {
		if (iArr[j] > iArr[j + 1]) {
			tmp = iArr[j];
			iArr[j] = iArr[j + 1];
			iArr[j + 1] = tmp;
		}
	}
	System.out.println(Arrays.toString(iArr));
}
