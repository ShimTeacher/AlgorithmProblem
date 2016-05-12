package XidasIT;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Prob_3 {
	
	//팩토리얼을 소인수분해하기 
	
	//<예> 입력 6
	//출력 2^4*3^2*5^1
	
	// Step 1.첫입력부터 Fact()함수를 통해 MAP 다음과 같은 규칙으로 저장한다 .
	//			2-1. 약수가 존재한다면 맵에 값을 확인하여 있으면 새로 저장하고 있다면 수를 하나 더 늘려;
	//			2-2. 약수가 존재하지 않다면 소수이므로 값 확인 후 저장.;
	
	// Step 2. 입력받은숫자를 n->1까지 내리기 n, n-1, n-2 .. 해서 1까지.(재귀를 활용) 
	// Step 3. 최종적으로 다 저장이 되었다면 key-value 값을 적당한 String 조작으로 정리.  
	
	static TreeMap<Integer,Integer> tmap = new TreeMap<Integer,Integer>();
	

	public static void main(String args[])
	{
		StringBuilder str = new StringBuilder();
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
	
		Fact(num); //Step 1,2
		
		
		
		// Step 3.
		for(int a: tmap.keySet()){
			str.append(a).append("^"+tmap.get(a)+"*");
		}
		
		System.out.println(str.substring(0, str.length()-1));
		
		
	}
	
	static void ThrowNumberInMap(int num)
	{
		if(tmap.get(num)==null){
			   tmap.put(num, 1);
		   }else {
			   tmap.put(num, tmap.get(num)+1);
		   }
	}
	
	static void Fact(int num)
	{
		if(num==1)
			return ;
		
		int temp = num/2+1;
		
		final int FirstNum = num;
		int checkval = 0;
		
		// Step 1 Fact로 들어온 수를 2부터 증가시켜 input / 2 +1 (약 절반)까지 검사한다.
		//		만약 소수일 경우 마지막에 Map에 저장한다. 
		for(int i=2; i<=temp; i++)
		{
			  while(true)
			  {
				   if(num%i==0){
					   ThrowNumberInMap(i);
					   checkval = 1; //checkval이  1이 되는 경우는 약수가 존재한다는 것이므로 검사하고 
					   				//있는 수는 소수가 아니다.
					   
					   num/=i;
				   }
				   else{
					   break;
				   }
			  }
		 }
		
		if(checkval == 0 )
		{
			//검사하는 수는 약수가 존재하지 않았다는 것, 즉 소수이므로  MAP 에 저장.
			ThrowNumberInMap(FirstNum);
		}
		
		// Step 2 
		Fact(FirstNum-1);
		
		
	}
}



