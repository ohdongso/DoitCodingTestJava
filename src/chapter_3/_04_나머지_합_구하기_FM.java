package chapter_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _04_나머지_합_구하기_FM {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		long[] S = new long[N]; // 합 배열
		long[] C = new long[M]; // 같은 나머지의 인덱스를 카운트하는 배열
		long answer = 0;
		
		// 수열 합 배열 만들기
		S[0] = Integer.parseInt(st.nextToken());
		for(int i = 1; i < N; i++) {
			S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		// 합 배열의 모든 값에 %연산 수행하기
		for(int i = 0; i < N; i++) {
			int remainder = (int)(S[i] % M);
			
			// 0 ~ i까지의 구간 합 자체가 0일 때 정답에 더하기
			if(remainder == 0) answer++;
			
			// 나머지가 같은 인덱스의 개수 카운팅하기
			C[remainder]++;
		}
		
		for(int i = 0; i < M; i++) {
			if(C[i] > 1) {
				// 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
				answer = answer + (C[i] * (C[i] - 1) / 2);
			}
		}
		
		bw.write(answer + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
}