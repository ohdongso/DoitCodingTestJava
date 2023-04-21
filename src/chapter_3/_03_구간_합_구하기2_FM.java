package chapter_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _03_구간_합_구하기2_FM {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 원본 배열 저장하기
		int[][] square = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				square[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		// 합 배열 저장하기
		int[][] squareSum = new int [N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				// 구간 합 구하기
				squareSum[i][j] = squareSum[i][j - 1] + squareSum[i - 1][j] - squareSum[i - 1][j - 1] + square[i][j];
			}
		}
		
		// 질의 계산 및 출력하기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
		
			// 구간 합 배열로 질의에 답변하기
			int result = squareSum[x2][y2] - squareSum[x1 - 1][y2] - squareSum[x2][y1 - 1] + squareSum[x1 - 1][y1 - 1];
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}