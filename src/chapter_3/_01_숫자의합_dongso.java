package chapter_3;

import java.util.Scanner;

public class _01_숫자의합_dongso {

	public static void main(String[] args) {
		// dongso
		Scanner sc = new Scanner(System.in);
		int numberCount = sc.nextInt();
		String numberList = sc.next();
		
		int sum = 0;
		for(int i = 0; i < numberCount; i++) {
			sum += numberList.charAt(i) - '0';
		}
		
		System.out.println(sum);
	}
}