package chapter_4;

import java.util.Scanner;

public class _17_내림차순으로_자릿수_정렬하기_FM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] A = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			A[i] = Integer.parseInt(str.substring(i, i + 1));
		}
		for (int i = 0; i < str.length(); i++) {
			int Max = i;
			for(int j = i + 1; j < str.length(); j++) {
				if (A[j] > A[Max]) // 내림차순이므로 최댓값을 찾음
					Max = j;
			}
			if (A[i] < A[Max]) {
				int temp = A[i];
				A[i] = A[Max];
				A[Max] = temp;
			}
		}
		for (int i = 0; i < str.length(); i++) {
			System.out.print(A[i]);
		}
	}
}