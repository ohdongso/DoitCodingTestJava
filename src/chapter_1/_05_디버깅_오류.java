package chapter_1;

import java.util.Scanner;

public class _05_디버깅_오류 {
	/*
	 * 1, answer변수 초기화 오류
	 * 2, 값 세팅 부분에서 반복범위가 100000이 아니라 10000부분 오류
	 * 3, 마지막 출력부분에서 t가 아니라 testcase 오류
	 * 4, 배열 S에 데이터타입이 int라서 음수가 저잔되어 있는 경우가 있다(Long으로 수정 필요)
	 * */
	
	public static void main(String[] args) {
		// TODO 배열에서 주어진 범위의 합을 구하는 프로그램을 구하시오
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		
		int answer = 0;
		int A[] = new int[100001];
		int S[] = new int[100001];
		

		// 값 세팅
		for (int i = 1; i < 10000; i++) {
			// A[i]에는 랜덤한 숫자가 저장 된다.
			A[i] = (int) (Math.random() * Integer.MAX_VALUE);
			
			// S[i]에는 S[i] + A[i] 값이 저장 된다.
			S[i] = S[i - 1] + A[i];
		}
	
		// 테스트케이스 만큼 반복한다.
		for(int t = 1; t < testcase; t++) {
			// 실행중인 한번인 테스트 케이스에서 몇번의 합을 구해줄지 정하는 변수
			int query = sc.nextInt();
				for(int i = 0; i < query; i++) {
					int start = sc.nextInt();
					int end = sc.nextInt();
					
					// end - start = 값을 누적하고 있다.
					answer += S[end] - S[start - 1];
					System.out.println(testcase + " " + answer);
				}
		}
		

	}
}