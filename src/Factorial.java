public class Factorial {


    public static void main(String[] args) {
        int n = 5;
        int result =n;
        factorial(n,result);
    }

    public static void factorial(int n, int result){
        if (n==1 || n==0)
            System.out.println(result);
        else{
            result=result*(n-1);
            factorial(n-1,result);
        }
    }
}
