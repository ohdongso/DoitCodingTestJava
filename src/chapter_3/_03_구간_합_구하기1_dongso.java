package chapter_3;

import java.util.Scanner;

public class _03_구간_합_구하기1_dongso {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] numberArr = new int[N];
		
		for(int i = 0; i < N; i++) {
			numberArr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < M; i++) {
			int startIndex = sc.nextInt();
			int endIndex = sc.nextInt();
			
			int sum = 0;
			for(int j = startIndex; j <= endIndex; j++) {
				sum += numberArr[j - 1];
			}
			
			System.out.println(sum);
		}
	}
}