import java.util.*;

public class CountA {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        
        int countA = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'a')
                countA++;
        }
        if(countA == 0)
            System.out.println(0);
        else if(countA == 1 && s.length() == 1)
            System.out.println(n);
        else{
            long numberOfSubs = (n / s.length());
        
            long charsOver = (numberOfSubs * s.length());

            long rem = n - charsOver;

            long totalAs = numberOfSubs * countA;

            for(int i=0;i<rem;i++){
                if(s.charAt(i) == 'a')
                    totalAs++;
            }

            System.out.println(totalAs);
        }
        
        in.close();
    }
}