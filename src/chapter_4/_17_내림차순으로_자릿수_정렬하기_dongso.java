package chapter_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _17_내림차순으로_자릿수_정렬하기_dongso {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int[] A = new int[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			A[i] = Integer.parseInt(str.substring(i, i + 1));
		}
		
		for(int i = 0; i < str.length(); i++) {
			int Max = i;
			
			for(int j = i + 1; j < str.length(); j++) {
				if(A[j] > A[Max]) Max = j;
			}
			
			if(A[i] < A[Max]) {
				int temp = A[i];
				A[i] = A[Max];
				A[Max] = temp;
			}
		}
		
		for(int i = 0; i < str.length(); i++) {
			bw.write(A[i] + "");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}