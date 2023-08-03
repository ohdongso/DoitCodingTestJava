package chapter_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _16_버블_소트_프로그램1_dongso {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		mData[] A = new mData[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = new mData(Integer.parseInt(br.readLine()), i);
		} // for문 끝.
		
		System.out.println("------------ 정렬 전 입력 값 ------------");
		for (int i = 0; i < N; i++) {
			System.out.println("index:" + A[i].index + " , value:" + A[i].value);
		}
		
		Arrays.sort(A);
		System.out.println("------------ value값 오름차순 정렬 후 ------------");
		
		for (int i = 0; i < N; i++) {
			System.out.println("index:" + A[i].index + " , value:" + A[i].value);	
		}
		
		System.out.println("------------ 실제인덱스 정렬 후 ------------");
		for (int i = 0; i < N; i++) {
			System.out.println("RealIndex:" + i + " , " + "BoforeIndex:" + A[i].index + " , value:" + A[i].value);
		}
		
		System.out.println("------------ (정렬전index - 정렬후index) ------------");
		for (int i = 0; i < N; i++) {
			System.out.println("BoforeIndex(" + A[i].index + ")" + " - RealIndex(" + i + ") = " + (A[i].index - i));
		}
			
		int Max = 0;
			for (int i = 0; i < N; i++) {
				if(Max < A[i].index - i) { // 정렬 전 index - 정렬 후 index 계산의 최댓값 저장하기
					Max = A[i].index - i;
				}
			} // for문 끝.
			
			bw.write(Max + 1 + "");
			bw.flush();
			bw.close();
			br.close();
		}
	}
	
	class mData implements Comparable<mData> {
		int value;
		int index;
		
		public mData(int value, int index) {
			super();
			this.value = value;
			this.index = index;
		}

		@Override
		public int compareTo(mData o) { // value 기준 오름차순 정렬하기
//			System.out.println("호출확인");
			return this.value - o.value;
		}
	}	