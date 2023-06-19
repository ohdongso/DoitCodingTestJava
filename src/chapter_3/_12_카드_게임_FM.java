package chapter_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _12_카드_게임_FM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> myQueue = new LinkedList<Integer>();
		int N = sc.nextInt();
		for(int i = 1; i <= N; i++) {
			myQueue.add(i);
		}
		while(myQueue.size() > 1) {
			myQueue.poll();
			myQueue.add(myQueue.poll());
		} // while문 끝.
		System.out.println(myQueue.poll());
	}
}