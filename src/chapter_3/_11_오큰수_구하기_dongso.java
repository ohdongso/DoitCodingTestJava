package chapter_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _11_오큰수_구하기_dongso {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n]; // 수열배열
		int[] ans = new int[n]; // 오큰수 정답배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> myStack = new Stack<Integer>();
		myStack.push(0);
		for(int i = 1; i < n; i++) {
			while(!myStack.isEmpty() && A[myStack.peek()] < A[i]) {
				ans[myStack.pop()] = A[i];
			} // while문 끝.
			myStack.push(i);
		} // for문 끝.
		
		while(!myStack.empty()) {
			ans[myStack.pop()] = -1;
		} // while문 끝.
		
		for(int i = 0; i < n; i++) {
			bw.write(ans[i] + " ");
		}
		
		bw.write("\n");
		bw.flush();
	}
}