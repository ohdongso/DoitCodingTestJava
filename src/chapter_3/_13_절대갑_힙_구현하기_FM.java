package chapter_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _13_절대갑_힙_구현하기_FM {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> myQueue = new PriorityQueue<Integer>((o1,o2) -> {
			int frist_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			if(frist_abs == second_abs) { // 절대값이 같은 경우 음수 우선
				return o1 > o2 ? 1 : -1;
			} else {
				return frist_abs - second_abs;// 절대값 작은 데이터 우선
			}	
		});
		
		for(int i=0; i<N; i++) {
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