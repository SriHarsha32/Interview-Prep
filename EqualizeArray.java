import java.util.*;

public class EqualizeArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        SortedMap<Integer,Integer> counts = new TreeMap<Integer,Integer>();
        int n = scan.nextInt();
        for(int i=0;i<n;i++){
            int val = scan.nextInt();
            if(!counts.containsKey(val)){
                counts.put(val,0);
            }
            counts.put(val, counts.get(val)+1);
        }
        int totalDeletes = 0;
        int maxCount = 0;
        for(int count : counts.values()){
            if(count > maxCount){
                maxCount = count;
            }
            totalDeletes += count;
        }
        totalDeletes -= maxCount;
        System.out.println(totalDeletes);

        scan.close();
    }
}