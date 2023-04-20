package chapter_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _03_구간_합_구하기2_dongso {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] square = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				square[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			
			// 전체구간
			if(x1 == 1 && y1 == 1 && x2 == N && y2 == N) {
				bw.write("전체구간 디버깅");
				for(int x = 0; x < N; x++) {
					for(int y = 0; y < N; y++) {
						sum += square[x][y];
					}
				}
			// 좌표가 같은 구간
			} else if(x1 == x2 && y1 == y2) {
				bw.write("좌표가 같은 구간");
				sum += square[x1 - 1][y1 - 1];
			// 전체구간도 아니고, 좌표도 같지 않을 경우
			} else {
				bw.write("그 외 구간");
				for(int x = x1 - 1; x < x2; x++) {
					// 마지막 행
					if(x == x2 - 1) {
						for(int y = 0; y < y2; y++) {
							sum += square[x][y];
						}
					// 시작 행
					} else if(x == x1 - 1) {
						for(int y = y1; y < N; y++) {
							sum += square[x][y];
						}
					// 마지막행도 시작행도 아닐 때
					} else {
						for(int y = 0; y < N; y++) {
							sum += square[x][y];
						}
					}
				}
			}
		
			bw.write(sum + "\n");
		
		} // for문 끝.	
		
		bw.flush();
		bw.close();
		br.close();
	}
}