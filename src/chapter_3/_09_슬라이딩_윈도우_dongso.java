package chapter_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _09_슬라이딩_윈도우_dongso {
	static int[] myArr;
	static int[] checkArr;
	static int checkSecret;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int Result = 0;
		checkArr = new int[4];
		myArr = new int[4];
		char[] A = new char[S];
		checkSecret = 0;
		
		A = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			// A,C,G,T에서 필요한 값의 갯수를 저장해주는 작업
			if(checkArr[i] == 0) {
				checkSecret++;
			}
		}
		
		for(int i = 0; i < P; i++) { // 부분문자열 처음 받을 때 세팅
			Add(A[i]);
		}
		
		if(checkSecret == 4) Result++;

		// 슬라이딩윈도우
		for(int i = P; i < S; i++) {
			int j = i - P;
			Add(A[i]);
			Remove(A[j]);
			if(checkSecret == 4) Result++;
		}
		bw.write(Result + "");
		bw.flush();
		bw.close();
		br.close();
	}
	private static void Add(char c) {
		switch (c) {
		case 'A' :
			myArr[0]++;
			if(myArr[0] == checkArr[0]) checkSecret++;
			break;
		case 'C' :
			myArr[1]++;
			if(myArr[1] == checkArr[1]) checkSecret++;
			break;
		case 'G' :
			myArr[2]++;
			if(myArr[2] == checkArr[2]) checkSecret++;
			break;
		case 'T' :
			myArr[3]++;
			if(myArr[3] == checkArr[3]) checkSecret++;
			break;
		}
	}
	
	private static void Remove(char c) {
		switch (c) {
		case 'A' :
			if(myArr[0] == checkArr[0]) checkSecret--;
			myArr[0]--;
			break;
		case 'C' :
			if(myArr[1] == checkArr[1]) checkSecret--;
			myArr[1]--;
			break;
		case 'G' :
			if(myArr[2] == checkArr[2]) checkSecret--;
			myArr[2]--;
			break;
		case 'T' :
			if(myArr[3] == checkArr[3]) checkSecret--;
			myArr[3]--;
			break;
		}
	}
}