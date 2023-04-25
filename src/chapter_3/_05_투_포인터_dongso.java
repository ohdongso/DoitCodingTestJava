package chapter_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _05_투_포인터_dongso {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int count = 1, start_index = 1, end_index = 1, sum = 1;
		
		int[] array = new int[N + 1];
		for(int i = 1; i <= N; i++) array[i] = i;
		
		while(end_index != N) {
			if(sum == N) {
				count++;
				sum += array[++end_index];
			} else if(sum > N) {
				sum -= array[start_index++];
			} else if(sum < N) {
				sum += array[++end_index];
			}
		}
		
		bw.write(count + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
}