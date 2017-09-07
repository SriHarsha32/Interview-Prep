import java.util.*;

class MaxSubsequence{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }

        int s = 0,si = 0, ei = 0, sum = 0, maxSum = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            sum += arr[i];
            if(maxSum < sum){
                ei = i;
                si = s;
                maxSum = sum;
            }
            if(sum < 0){
                sum = 0;
                s = i+1;
            }
        }

        System.out.println("The value of subsequence is : "+maxSum);
        System.out.print("The subsequence is : [");
        StringBuffer sbr = new StringBuffer("");
        for(int i=si;i<=ei;i++)
            sbr.append(arr[i]).append(", ");
        String str = sbr.substring(0,sbr.length() - 2);
        System.out.println(str+"]");

        scan.close();

    }
}