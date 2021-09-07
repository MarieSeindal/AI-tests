public class GCD {

    public static void main(String[] args) {
        int a=7;
        int b=21;
        gcd(a,b);
    }

    public static void gcd(int a, int b){
        if(a==b)
            System.out.println(a);
        else if(a>b)
            gcd(a-b,b);
        else if(a<b)
            gcd(a,b-a);
    }


}
