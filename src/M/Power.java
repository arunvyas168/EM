package M;

public class Power {

/*
    SOLUTION:
        TLDR:  X^5 == (X^4 * x) == (x^2 * x^2 * x)  ---> recursion
               Anything can be computed as x^2 and add x in the end if needed

         1. Use power helper --> pass Absolute (-ve can be handled in the end)

         2. Base case:
                X^0 = 1;    n==0 return 1
                0^n = 0;    x==0 return 0
         3.  result = powHelper(x,n/2) ----> split
         4.  result = result*result  ---> join
         5.    if odd number (use %) then multiply by x again
*/

    public double powHelper(double x, int n){

        // There are 2 base case here x^0 == 1
        // and 0^n == 0
        if(n==0){
            return 1;
        }
        if(x==0){
            return 0;
        }

        //every result is divided into power of 2
        double result = powHelper(x, n/2);

        // We are multiplying here as its devide and conquer x^2 * x^2 and so on
        result = result*result;

        // This is to see if n is odd then we need an additional multiplication with x
        // x^5 == x^2 * x^2 * x
        if(n%2==0){
            return result;
        }else{
            return result*x;
        }
    }

    public double myPow(double x, int n) {
        //We pass abs value and handle the negative in the end
        double result = powHelper(x, Math.abs(n));

        //Check if n was negative and give result
        if(n<0){
            return 1/result;
        }else{
            return result;
        }
    }
}
