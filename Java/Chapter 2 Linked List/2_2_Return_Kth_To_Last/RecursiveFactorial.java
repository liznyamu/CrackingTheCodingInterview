package erza;

/**
 * Factorial of any number n is n times n-1 factorial
 * 
 * ie product of integers 1 to n ie n = 5, n! = 5 X 4 X 3 X 2 X 1
 * 
 * NB
 * 
 * 1) Recursion in definition--
 * 
 * The definition is recursive because it includes the factorial method within itself ie
 * 
 * n! = n X (n-1)!  --- ie factorial(n) = n X factorial(n-1)
 * 
 * 2) End Condition 
 * 
 * indicating when to stop calling itself
 * ie when n = 1 , return 1
 * 
 * 
 * @author erza
 *
 */
public class RecursiveFactorial {
	
	public static void main(String[] args) {
		System.out.println(factorial(5) );
	}

	private static int factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
		
		
	}

}
