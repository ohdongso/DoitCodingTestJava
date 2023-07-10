package chapter_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _16_버블_소트_프로그램1_버블정렬_dongso {
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		boolean change = false; // 시간복잡도를 줄일수 있다.(1)
		int count = 1;
		
		for(int i = 1; i <= N - 1; i++) { // 버블정렬이 끝
			change = false;
			
			for(int j = 1; j <= N - i; j++) { // 버블정렬이 시작되어야 할 시작점을 나타낸다.
				if(A[j] > A[j + 1]) {
					change = true;
					swap(A[j], A[j + 1], j);
				}
			} // for문 끝.
			
			if(change == true) {
//				System.out.println(Arrays.toString(A));
				count++;
			}
			
			// 시간복잡도를 줄일수 있다.(2)
			// 마지막 스왑이 안된 부분+1, 스왑 횟수를 출력 한다.
			// false는 정렬이 완료 된것이다.
			if(change == false) {
				break;
			}	
		} // for문 끝.
		
		bw.write(count + "\n");
		// bw.write(Arrays.toString(A) + "");
		bw.flush();
		bw.close();
		br.close();
		
	} // main 끝.
	
	public static void swap(int num1, int num2, int index) {
		int temp = A[index];
		A[index] = A[index + 1];
		A[index + 1] = temp;
	}	
}