package chapter_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class _14_절대갑_힙_구현하기_dongso {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> myQueue = new PriorityQueue<Integer>((o1,o2) -> {
			int frist_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			if(frist_abs == second_abs) {
				return o1 > o2 ? 1 : -1;
			} else {
				return frist_abs - second_abs;
			}
		});
		
		for(int i = 0; i < N; i++) {
			int request = Integer.parseInt(br.readLine());
			if(request == 0) {
				if(myQueue.isEmpty()) {
					System.out.println("0");
				} else {
					System.out.println(myQueue.poll());
				}
			} else {
				myQueue.add(request);
			}
		}
	}
}