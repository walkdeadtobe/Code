//package sortdemo;
import java.util.Arrays;
public class Heapsort {
    /**
     * main
     * @param args
     */
    public static void main(String []args){
        int []arr={9,8,7,6,5,4,3,2,1,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * heapsort
     * @param arr
     */
    public static  void sort(int []arr){
        for(int i=arr.length/2-1;i>=0;i--){
            //start with the i item ,from down to up, from left to right adjust it
            adjustHeap(arr,i,arr.length);
        }
        //swap the first and the last ,then adjust
        for(int j=arr.length-1;j>=0;j--){
            swap(arr,0,j);
            adjustHeap(arr,0,j);;
        }
    }

    /**
     * after building the max-heap,adjust it
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp=arr[i];//first get current value/item
        for(int k=i*2+1;k<length;k=k*2+1){//from the left child of current item,in other word,the 2i+1 item
            if(k+1<length&&arr[k]<arr[k+1]){//if the left child is less than the  right child ,let k point to right child
                k++;
            }
            if(arr[k]>temp){//if k item-the max of left-right child is more than i item ,swap it ,and maybe  k item and his child need to change
                arr[i]=arr[k];
                i=k;
            }else{
                break;
            }
        }
        arr[i]=temp;//place the temp=arr[i] at right position
    }


    /**
     * swap the item
     * @param arr
     * @param a
     * @param b
     */

    public static void swap(int []arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

}
