package chapter_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class _13_카드_게임_dongso {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Integer> myQueue = new LinkedList<Integer>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= N; i++) {
			myQueue.add(i);
		}
		
		while(myQueue.size() > 1) {
			myQueue.poll();
			myQueue.add(myQueue.poll());
		} // while문 끝.
		
		bw.write(myQueue.poll() + "");
		bw.flush();
		bw.close();
		br.close();
	}
}