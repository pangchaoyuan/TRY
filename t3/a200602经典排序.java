import java.util.Arrays;
import java.util.Stack;

public class a200602经典排序 {






    public static void swap(int x,int y ,int[] array){
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }


    //======直接插入排序==========
    public static void insertSort(int[] array){
        for(int i = 1 ;i<array.length;i++){
            int tmp =array[i];int j =0;
            for( j = i-1;j>=0;j--){

                if(array[j]>tmp){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }


    //=========希尔排序===========
    public static void shellSort(int[] array){

        int gap = array.length;
        while(gap>0){
            gap = gap/3;
            method(array,gap+1);
        }
    }

    private static void method(int[] array, int gap) {
        int j = 0;
        for(int i =gap;i<array.length;i++){
            int tmp = array[i];
            for(j = i-gap;j>=0;j-= gap){
                if(array[j]>tmp){
                    array[j+gap] = array[j];
                }else{
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    //=============选择排序=====================

    public static void selectSort(int[] array){
        for(int i = 0 ;i<array.length;i++){
            for(int j = i+1;j<array.length;j++){
                if(array[i]<array[j]){
                    swap(i,j,array);
                }

            }
        }
    }


    //===========冒泡排序====================

    public static void boo(int[] array){
        for(int i = 0 ; i < array.length-1;i++){
            boolean l = false;
            for(int j = 0 ;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    swap(j,j+1,array);
                    l = true;
                }
            }
            if(!l) break;
        }
    }

    //===============堆排序===============


    public static void heapSort(int[] array){
        creatHeap(array);
        int end = array.length-1;
        while (end>0){
            swap(end,0,array);
            adjustDown(array,0,end);
            end--;
        }
    }

    public static void creatHeap(int[] array){
        for(int i =(array.length-1-1)/2;i>=0;i--){
            adjustDown(array,i,array.length);
        }
    }

    public static void adjustDown(int[] array,int p ,int len){
        int child = p*2+1;//左孩子
        while(child<len){
            if(child+1<len&&array[child]>array[child+1]){
                child++;
            }
            if(array[child]<array[p]){
                swap(child,p,array);
                p = child;
                child = p*2+1;
            }else{
                break;
            }

        }
    }


    //===========快速排序递归====================


    public static void quickSort1(int[] array){
        quick(array,0,array.length-1);
    }

    private static void quick(int[] array, int left, int right) {
        if(left>=right){
            return;
        }
        int target = quickMethod(array,left,right);
        quick(array,left,target-1);
        quick(array,target+1,right);
    }

    private static int quickMethod(int[] array, int low, int high) {
        int tmp = array[low];
        int left = low;
        int right = high;
        while(left<right){
            while (left<right&&array[right]>=tmp){
                right--;
            }//右边下标必须第一个
            while(left<right&&array[left]<=tmp){
                left++;
            }
                swap(left,right,array);
        }
        swap(left,low,array);
        return left;
    }

    //===================快速排序不递归========================

    public static void quickSort2(int[] array){
        Stack<Integer> stack = new Stack<>();
        stack.push(array.length-1);
        stack.push(0);
        while(!stack.isEmpty()){
            int low = stack.pop();
            int high = stack.pop();

            if(low>high){
                continue;
            }

            int povit = quickMethod(array,low,high);

            stack.push(povit-1);
            stack.push(low);
            stack.push(high);
            stack.push(povit+1);
        }
    }

//===============归并排序递归=========================
public static void  mergeSort(int[] array){
        mergeSort2(array,0,array.length-1);
}

    private static void mergeSort2(int[] array, int left, int right) {
        if(left>=right){
            return;
        }
        int mid = (left+right)/2;
        mergeSort2(array,left,mid);
        mergeSort2(array,mid+1,right);
        merge(array,left,mid,right);
    }

    private static void merge(int[] array,int left,int mid,int right){
        int[] tmp = new int[right-left+1];
        int k = 0;
        int s1 = left;
        int s2 = mid+1;
        while(s1<mid+1&&s2<right+1){

            tmp[k++] = array[s1]>array[s2]?array[s1++]:array[s2++];
        }

        while(s1<mid+1){
            tmp[k++] = array[s1++];
        }
        while(s2<right+1){
            tmp[k++] = array[s2++];
        }
        for(int i = 0 ; i <tmp.length;i++){
            array[left++] = tmp[i];
        }
    }

    //===============归并排序不递归========================

    public static void mergeSort2(int[] array){
        for(int i =1 ; i< array.length;i*=2){
            mergeSort3(array,i);
        }
    }

    private static void mergeSort3(int[] array,int gap ){
        int[] tmp = new int[array.length];
        int k = 0;
        int s1 = 0;
        int e1 = gap-1;
        int s2 = e1+1;
        int e2 = s2+gap-1<array.length?s2+gap-1:array.length-1;
        while(s2<array.length){
            while (s1<=e1&&s2<=e2){
                tmp[k++] =array[s1]>array[s2]?array[s1++]:array[s2++];
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
        }//出while循环之后s2一定无了

        while(s1<array.length){
            tmp[k++] = array[s1++];
        }
        for(int i = 0 ; i <tmp.length;i++){
            array[i] = tmp[i];
        }

    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,4,3,2,1,5,6,7};
        //insertSort(arr);
       // shellSort(arr);
       // selectSort(arr);
       // boo(arr);
       // heapSort(arr);
        //quickSort1(arr);
        //quickSort2(arr);
        //mergeSort(arr);
        //mergeSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
