import java.util.Random;
public class DecreaseAndConquer {
    static int []w=null;
    static int k;
    public static void main(String []args){
        getdata();
        System.out.println("before sort");
        print();
        System.out.println("after sort");
        System.out.println("ygy"+selectkmin(0,w.length-1,k));
        print();
    }
    public static void getdata(){
        Random random=new Random();
        int n=random.nextInt(10)+10;
        k=random.nextInt(n-2)+1;
        w=new int[n];
        for(int i=0;i<n;i++){
            w[i]=random.nextInt(10)+20;
        }
    }


    public static int selectkmin(int low,int high,int k){
        int index=partition(low,high);
        if(index==low+k-1)
            return w[index];
        if(index<k){
            return selectkmin(index+1,high,k-(index-low+1));
        }
        else{
            return selectkmin(low,index-1,k);
        }

    }

    /**
     * swap the two items
     * @param i
     * @param j
     */
    public static void swap(int i,int j){
        int temp=w[i];
        w[i]=w[j];
        w[j]=temp;
    }

    /**
     *
     * @param low
     * @param high
     * @return
     */
    public static int  partition(int low,int high){
            while(low<high){
                while(low<high&&w[low]<w[high]){
                    high--;
                }
            }
            if(low<high){
                swap(low,high);
                low++;
            }
            while (low<high&&w[low]<w[high])
                low++;
        if (low < high) {
            swap(low,high);
            high--;
        }
        return low;
    }

    public static void print(){
        for(int i:w){
            System.out.print(i+" ");
        }
        System.out.println();
    }


}
