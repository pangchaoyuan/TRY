import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class 排序练习2 {
    //快速排序 递归
    public static void quickSort(int[] array){
        quickSortChild(array,0,array.length-1);
    }

    public static void quickSortChild(int[] array, int low, int high){
        if(low>=high) return;

        int p =target(array,low,high);
        quickSortChild(array,low,p-1);
        quickSortChild(array,p+1,high);
    }

    public static int target(int[] array , int low,int high){
        int tmp = array[low];
        int i =low;
        int j =high;
        while(i<j){
            while(i<j&&array[i]>=tmp){
                i++;
            }
            while (i<j&&array[j]<=tmp){
                j--;
            }
            swap(array,i,j);
        }
        swap(array,low,i);
        return i;
    }
    public static void swap(int[] array, int i,int j  ){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
//快速排序 非递归

    public static void quickSort2(int[] array){
        Stack<Integer> stack = new Stack<>();
        stack.push(array.length-1);
        stack.push(0);
        while(!stack.isEmpty()){
            int low = stack.pop();
            int high = stack.pop();
            if(low>=high){
                continue;
            }
            int t = target(array,low,high);

            stack.push(high);
            stack.push(t+1);
            stack.push(t-1);
            stack.push(low);
        }
    }
//堆排序

    public static void heapSort(int[] array){
        creatHeap(array);
        int end = array.length-1;
        while(end>=0){
            swap(array,0,end);
            adjustdown(array,0,end--);
        }
    }
    public static void creatHeap(int[] array){
        for(int i = (array.length-1-1)/2;i>=0;i--){
            adjustdown(array,i,array.length);
        }
    }
    public static void adjustdown(int[] array, int p ,int len){
        int child = p*2+1;
        while(child<len){
            if(child+1<len&&array[child+1]>array[child]){
            child++;
            }
            if(array[p]<array[child]){
                swap(array,p,child);
            }
            p =child;
            child = p*2+1;
        }

    }
 //归并排序 递归
    public static void mergeSort(int[] array){
        mergeSortChild(array,0,array.length-1);
    }

    public static void mergeSortChild(int[] array,int low,int high){
        if(low>=high) return;
        int mid = (low+high)/2;
        mergeSortChild(array,low,mid);
        mergeSortChild(array,mid+1,high);
        merge(array,low,mid,high);
    }

    public static void merge(int[] array,int low,int mid,int high){
        int[] tmp = new int[high-low+1];
        int s1 =low;
        int s2 = mid+1;
        int k =0;
        while(s1<=mid&&s2<=high){
                if(array[s1]>array[s2]){
                    tmp[k++] = array[s1++];
                }else{
                    tmp[k++] = array[s2++];
                }
        }
            while(s1<=mid){
                tmp[k++] = array[s1++];
            }
            while(s2<=high){
                tmp[k++] = array[s2++];
            }


        for(int i =0;i<tmp.length;i++){
            array[low++] = tmp[i];
        }
    }
//归并排序 非递归
    public static void mergeSort2(int[] array){
        for(int i =1;i<array.length;i*=2){
            merge2(array,i);
        }
    }
    public static void merge2(int[] array,int gap){
        int[] tmp = new int[array.length];
        int k  =0;
        int s1 = 0;
        int e1 = s1+gap-1;
        int s2 = e1+1;
        int e2 = s2+gap-1>array.length?array.length-1:s2+gap-1;
        while(s2<array.length){
            while(s1<=e1&&s2<=e2) {
                if (array[s1] < array[s2]) {
                    tmp[k++] = array[s1++];
                } else {
                    tmp[k++] = array[s2++];
                }
            }
            while(s1<=e1){
                tmp[k++] = array[s1++];
            }
            while(s2<=e2){
                tmp[k++] = array[s2++];
            }
             s1 = e2+1;
             e1 = s1+gap-1;
             s2 = e1+1;
            e2 = s2+gap-1>array.length?array.length-1:s2+gap-1;

        }
        while(s1<array.length){
            tmp[k++] = array[s1++];
        }

        for(int i = 0;i<array.length;i++){
             array[i]=tmp[i];
        }
    }



    public static void main(String[] args) {
        int[] a = {1,3,45,5,76,7};
        //quickSort2(a);
        //heapSort(a);
        mergeSort2(a);
        System.out.println(Arrays.toString(a));
    }

}
