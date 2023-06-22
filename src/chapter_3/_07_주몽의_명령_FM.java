package chapter_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _07_주몽의_명령_FM {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // 재료의 개수
		int M = Integer.parseInt(br.readLine()); // 갑옷이 완성되는 번호의 합
		int[] array = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬
		Arrays.sort(array);
		
		int count = 0;
		int start_index = 0;
		int end_index = N - 1;
		
		while(start_index < end_index) { // 투 포인터 이동 원칙 따라 포인터를 이동하며 처리
			if(array[start_index] + array[end_index] < M) {
				start_index++;
			} else if(array[start_index] + array[end_index] > M) {
				end_index--;
			} else {
				count++;
				start_index++;
				end_index--;
			}
		}
		
		bw.write(count + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
}