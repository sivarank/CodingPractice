package progPractice;

import java.util.Scanner;

public class HelloWorld {

	public HelloWorld() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("khkjfdj");
		Scanner scan=new Scanner(System.in);  
		int num = scan.nextInt();
		boolean isPrime = true;
		for(int i= 2; i<num-1; i++) {
			if(num % i == 0) {
				isPrime = false; 
				break;
			}
		}
		System.out.println("Is given number prime : "+isPrime);
	}

}
