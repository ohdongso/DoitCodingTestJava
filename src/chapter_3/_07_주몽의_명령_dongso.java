package chapter_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _07_주몽의_명령_dongso {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // 재료의 개수
		int M = Integer.parseInt(br.readLine()); // 갑옷이 완성되는 번호의 합
		int start_index = 0; 
		int end_index = N - 1;
		int count = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] array = new int[N];
		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬
		// 가장 끝자리에 가장큰수를 저장하면서 오름차순 정렬한다.
		for(int i = 0; i < N - 1; i++) {
			// i만큼 빼주는 이유는 제일 끝자리에 가장 큰수가 들어 갔기때문에 비교해줄 필요가 없다.
			for(int j = 0; j < N - 1 - i; j++) { 
				if(array[j] > array[j + 1]) {
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
		}
		
		while(start_index < end_index) {
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