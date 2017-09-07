import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Min_max {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the 5 numbers");
        long[] arr = new long[5];
        long[] sums = new long[5];
        for(int i=0;i<5;i++)
            sums[i] = 0;
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextLong();
            for(int i=0;i<5;i++){
                if(i != arr_i)
                    sums[i] += arr[arr_i];
            }
        }
        Arrays.sort(sums);
        System.out.println(sums[0]+" "+sums[4]);
    }
}