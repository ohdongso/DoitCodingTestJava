package chapter_3;

import java.util.PriorityQueue;

public class Test {

	public static void main(String[] args) {
		PriorityQueue<Integer> myQueue1 = new PriorityQueue<Integer>((o1,o2) -> {
			int frist_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			if(frist_abs == second_abs) { // 절대값이 같은 경우 음수 우선
				return o1 > o2 ? 1 : -1;
			} else {
				return frist_abs - second_abs;// 절대값 작은 데이터 우선
			}	
		});
		myQueue1.add(1);
		myQueue1.add(-1);
		myQueue1.add(2);
		myQueue1.add(-2);
		System.out.println(myQueue1);
		
		
		
		PriorityQueue<Integer> myQueue2 = new PriorityQueue<Integer>();
		myQueue2.add(2);
		myQueue2.add(1);
		myQueue2.add(-1);
		myQueue2.add(-2);
		System.out.println(myQueue2);
	}
}