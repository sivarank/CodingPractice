


package progPractice;


class CCLeastCommonDivisor{

	private static boolean isPrime(int x){
		if(x == 2) {
			return true;
		}
		int sqrtNum = (int) Math.ceil(Math.sqrt(x)); 
		for(int i=2; i<=sqrtNum;  i++){
			if(x % i == 0){
				return false;
			}
		}
		return true; 
	
	}
	
	private static int getMaxPower(int num, int p){
		int result = 0;
		while((num>0) && (num % p == 0)){
			result++;
			num /= p;
		}
		return result; 
	}
	
	public static void main(String args[]) {
		int m = 10;
		int n = 18;
		int result = 1;
		for(int i=2; i<=m || i<= n ; i++){
			if((m %i == 0 || n % i== 0) && (isPrime(i))){
				int maxPower = Math.max(getMaxPower(m,i), getMaxPower(n,i));
				result *= (int)Math.pow(i, maxPower);
			}
		}
		System.out.println(result);
		
	}
}