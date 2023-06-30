package chapter_3;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public class _14_우선순위큐공부 {
	
	public static void main(String[] args) throws IOException{
//		PriorityQueue<Integer> myQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> myQueue = new PriorityQueue<Integer>();
		
		myQueue.add(5);
		myQueue.add(4);
		myQueue.add(3);
		myQueue.add(2);
		myQueue.add(1);
		System.out.println(myQueue.poll());
		
		System.out.println(myQueue);
	}
}
