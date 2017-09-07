import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BigSorting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<BigInteger> numList = new ArrayList<>();
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            BigInteger bigInteger= new BigInteger(in.nextLine());
			numList.add(bigInteger);
        }
        Collections.sort(numList);
        for(BigInteger big : numList)
            System.out.println(big);
    }
}
