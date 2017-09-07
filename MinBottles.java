import java.util.*;

class Hill{
    int height;
    int index;
    int min;
    Hill leftPeer, rightPeer;
    public Hill(int h,int i, int m){
        height = h;
        index = i;
        min = m;
        leftPeer = null;
        rightPeer = null;
    }

    public void changeMin(){
        if(leftPeer != null && rightPeer != null){
            if(height > leftPeer.height){
                if(height > rightPeer.height){
                    if(rightPeer.height > leftPeer.height){
                        if(min <= rightPeer.min)
                            min += rightPeer.min;
                    }
                    else if(leftPeer.height > rightPeer.height){
                        if(min <= leftPeer.min)
                            min += leftPeer.min;
                    }
                }
                else if(rightPeer.height > height){
                    if(rightPeer.min <= min)
                        rightPeer.min += min;
                }
            }
            else if(leftPeer.height > height){
                if(height > rightPeer.height){
                    if(leftPeer.min <= min)
                        leftPeer.min += min;
                }
                else if(height < rightPeer.height){
                    if(rightPeer.height < leftPeer.height){
                        if(rightPeer.min <= min)
                            rightPeer.min += min;
                    }
                    else if(leftPeer.height < rightPeer.height){
                        if(leftPeer.min <= min)
                            leftPeer.min += min;
                    }
                }
            }
        }
        else if(leftPeer != null && rightPeer == null){
            if(height < leftPeer.height){
                if(leftPeer.min <= min)
                    leftPeer.min += min;
            }
            else if(height > leftPeer.height){
                if(min <= leftPeer.min)
                    min += leftPeer.height;
            }
        }
        else if(leftPeer == null && rightPeer != null){
            if(height < rightPeer.height){
                if(rightPeer.min <= min)
                    rightPeer.min += min;
            }
            else if(height > rightPeer.height){
                if(min <= rightPeer.min)
                    min += rightPeer.min;
            }
        }
        
    }
}

class MinBottles{

    static Hill[] sortArray(Hill[] arr,int type){
        int n = arr.length;
        boolean swapped;
        do
        {
            swapped = false;
            for (int i = 0; i < n - 1; i++)
            {
                if(type == 0){
                    if (arr[i].height > arr[i + 1].height)
                    {
                        Hill temp = arr[i + 1];
                        arr[i + 1] = arr[i];
                        arr[i] = temp;
                        swapped = true;
                    }
                }
                else{
                    if (arr[i].index > arr[i + 1].index)
                    {
                        Hill temp = arr[i + 1];
                        arr[i + 1] = arr[i];
                        arr[i] = temp;
                        swapped = true;
                    }
                }
            }
        } while (swapped == true);
        return arr;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Hill[] hills = new Hill[n];
        
        for(int i=0;i<n;i++){
            hills[i] = new Hill(scan.nextInt(),i,1);
        }

        for(int i=0;i<n;i++){
            hills[i].leftPeer = (i>0) ? hills[i-1] : null;
            hills[i].rightPeer = (i<n-1) ? hills[i+1] : null; 
        }

        hills = sortArray(hills,0);

        for(int i=0;i<n;i++){
            hills[i].changeMin();
        }

        sortArray(hills, 1);

        for(int i=0;i<n;i++){
            System.out.printf("Hill %d : [HGT, MIN] = [%d, %d]\n",hills[i].index,hills[i].height,hills[i].min);
        }

    }
}