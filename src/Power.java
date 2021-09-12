public class Power {


    public static void main(String[] args) {
        int base = 2;
        int result = base;
        int exponent =4;

        int p = power(base,exponent,result);
        System.out.println(p);

    }

    public static int power(int base, int exponent,int result){
        if (exponent==1)
            return result;
        else {
            result = result * base;
            exponent = exponent - 1;
            result = power(base, exponent, result);
            return result;
        }
    }
}
