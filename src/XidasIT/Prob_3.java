package XidasIT;

import java.util.HashMap;
import java.util.Scanner;

public class Prob_3 {
	
	//팩토리얼을 소인수분해하기 
	
	//<예> 입력 6
	//출력 2^4*3^2*5^1
	
	// Step 1. 입력받은숫자를 6->1까지 내리기 n, n-1, n-2 .. 해서 1까지.
	// Step 2. 첫입력부터 isPrime()함수를 통해 소수인지 판단 .
	//			2-1. 소수라면 맵에 저장;
	//			2-2. 소수가 아니라면 인수분해하여 저장;
	// Step 3. 최종적으로 다 저장이 되었다면 key-value 값을 적당한 String 조작으로 정리.  
	
	public static void main(String args[])
	{
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		
		System.out.println(num);
		
		
		
//		
//		
//		
//		hmap.put(1, 100);
//		hmap.put(1, hmap.get(1)+1);
//		System.out.println(hmap.get(1));
	}
}
