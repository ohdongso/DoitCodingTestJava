package chapter_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _05_투_포인터_FM {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int count = 1, start_index = 1, end_index = 1, sum = 1;
		
		while(end_index != N) {
			if(sum == N) { // 현재 연속 합이 N과 같은 경우
				count++;
				end_index++;
				sum = sum + end_index;
			} else if(sum > N) { // 현재 연속 합이 N보다 더 큰 경우
				sum = sum - start_index;
				start_index++;
			} else { // 현재 연속 합이 N보다 작은 경우
				end_index++;
				sum = sum + end_index;
			}
		}
		
		bw.write(count + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
}