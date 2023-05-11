package chapter_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _09_최소값_찾기_dongso {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
	    Deque<Node> mydeque = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			// 새로운 값이 들어올 때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임
			int now = Integer.parseInt(st.nextToken());
			
			// mydeque가 비어있지 않고, mydeque의 마지막 값이 새로들어온 값보다 크다면
			while(!mydeque.isEmpty() && mydeque.getLast().value > now) {
				// 최소값을 구해줘야 하기 떄문에 마지막 값 삭제
				mydeque.removeLast();
			}
			
			// 마지막에 현재 입력받은 최소값과 인덱스 저장
			mydeque.addLast(new Node(now, i));
			
			// 범위에서 벗어난 값은 덱에서 제거
			// mydeque에 남아있는 첫번째 값의 인덱스가 현재 인덱스 - L값보다 작으면 L의 범위를 벗어났기 때문에 삭제
			if(mydeque.getFirst().index <= i - L) {
				mydeque.removeFirst();
			}
			bw.write(mydeque.getFirst().value + " ");
		} // for문 끝.
		bw.flush();
		bw.close();
	}
	
	static class Node {
		public int value;
		public int index;
		
		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
}