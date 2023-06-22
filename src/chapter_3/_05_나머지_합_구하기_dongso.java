package chapter_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _05_나머지_합_구하기_dongso {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] array = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		int sum = 0;
		// 시작숫자값만 포함될 때, 
		for(int i = 0; i < N - 1; i++) {
			sum = 0;
			
			for(int j = i; j < N; j++) {
				// 시작숫자값 구간합을 구해 줄 때
				if(i == j) {
					sum = array[i];
					if(sum % M == 0) {
						count++;
					}
					continue;
				}
				sum += array[j];
				if(sum % M == 0) count++;
			}
		}
		
		// 마지막 숫자만 포함 될 때
		if(array[N - 1] % M == 0) count++;
		
		bw.write(count + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
}