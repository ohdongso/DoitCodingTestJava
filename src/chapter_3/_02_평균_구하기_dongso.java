package chapter_3;

import java.util.Scanner;

public class _02_평균_구하기_dongso {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 과목수 입력받기
		int N = sc.nextInt();
		
		// 배열선언
		double A[] = new double[N];
		
		// 배열에 입력받은 숫자 저장
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextDouble();
		}
		
		// 과목 최대값 찾기
		double maxScore = A[0];
		for(int i = 1; i < N; i++) {
			if(maxScore < A[i]) {
				maxScore = A[i];
			}
		}
		
		// 과목점수 / 최대점수 * 100 == 수정된 과목점수
		double sum = 0;
		for(int i = 0; i < N; i++) {
			sum += A[i] / maxScore * 100;
		}
		
		System.out.println(sum / N);
	}
}