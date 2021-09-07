public class Simplify {
    public static void main(String[] args) {
        int taeller=7;
        int naevner=21;

        System.out.println("Brøk før simplify: "+ taeller+"/"+naevner);

        simplify(taeller,naevner);

    }


    public static void simplify(int taeller, int naevner){

        int gcdnum = gcd(taeller,naevner);
        taeller = taeller/gcdnum;
        naevner = naevner/gcdnum;
        System.out.println("Brøk efter simplify: "+ taeller+"/"+naevner);

    }

    public static int gcd(int a, int b){
        if(a==b)
            return a;
        else if(a>b)
            gcd(a-b,b);
        else if(a<b)
            gcd(a,b-a);
        return a;
    }

}


