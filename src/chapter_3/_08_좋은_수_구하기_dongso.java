package chapter_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _08_좋은_수_구하기_dongso {

	public static void main(String[] args) throws IOException {
	 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	 	
	 	int N = Integer.parseInt(br.readLine());
	 	StringTokenizer st = new StringTokenizer(br.readLine());
	 	
	 	int[] array = new int[N];
	 	for(int i = 0; i < N; i++) {
	 		array[i] = Integer.parseInt(st.nextToken());
	 	}
	 	Arrays.sort(array);
	 	
	 	int count = 0;
	 	for(int i = 0; i < N; i++) {
	 		int start_index = 0, end_index = N - 1, find = array[i];
	 		
	 		while(start_index < end_index) {
	 			if(array[start_index] + array[end_index] == find) {
	 				if(start_index != i && end_index != i) {
	 					count++;
	 					break;
	 				} else if (start_index == i) {
	 					start_index++;
	 				} else {
	 					end_index--;
	 				}
	 			} else if(array[start_index] + array[end_index] < find) {
	 				start_index++;
	 			} else {
	 				end_index--;
	 			}
	 		} // while문 끝.
	 	} // for문 끝.
	 	
	 	bw.write(count + "");
	 	bw.flush();
	 	bw.close();
	 	br.close();
	}
}