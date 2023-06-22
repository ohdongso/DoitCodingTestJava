package chapter_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class _11_스택으로_오름차순_수열_만들기_dongso {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<>();
		int num = 1;
		boolean result = true;
		
		for(int i = 0; i < A.length ; i++) {
			int su = A[i];
			if(su >= num) {
				while(su >= num) {
					stack.push(num++);
					bw.write("+\n");
				}
				stack.pop();
				bw.write("-\n");
			} else {
				int n = stack.pop();
				if(n > su) {
					System.out.println("NO");
					result = false;
					break;
				} else {
					bw.write("-\n");
				}
			}
		} // for문 끝.
		
		if(result) bw.flush();
		br.close();
	}
}