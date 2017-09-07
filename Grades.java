import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Grades {

    static int[] solve(int[] grades){
        int newgrades[] = new int[grades.length];
        int gd;
        for(int i=0;i<grades.length;i++){
            if(grades[i] < 38){
                newgrades[i] = grades[i];
                continue;
            }
            gd = (grades[i] % 5);
            switch(gd){
                case 0: 
                case 1: 
                case 2: newgrades[i] = grades[i]; break;
                case 3: newgrades[i] = grades[i] + 2; break;
                case 4: newgrades[i] = grades[i] + 1; break;
            }
        }

        return newgrades;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
        

    }
}
