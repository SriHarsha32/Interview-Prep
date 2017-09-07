import java.io.*;

public class BetweenSets {

    static int gcd(int a, int b){
        return (b==0) ? a : gcd(b, a%b);
    }

    static int findgcd(int arr[], int n)
    {
        int result = arr[0];
        for (int i=1; i<n; i++)
            result = gcd(arr[i], result);
        return result;
    }

    static int findlcm(int arr[], int n)
    {
        int ans = arr[0];
        for (int i=1; i<n; i++)
            ans = ( ((arr[i]*ans)) /
                    (gcd(arr[i], ans)) );
    
        return ans;
    }

    static int finddivs(int num){
        int divs = 0;
        for(int i=1;i<=num;i++)
            if(num%i==0)
                divs++;
        
        return divs;
    }
    static int getTotalX(int[] a, int[] b){
        int no = 0;
        int l = findlcm(a,a.length);
        int r = findgcd(b,b.length);
        int k = r/l;
        return finddivs(k);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
    }
}
