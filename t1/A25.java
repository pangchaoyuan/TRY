import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class A25 {
  /* int mid = (left+right)/2;
        int tmp = array[mid]>array[left]?array[mid]:array[left];
        tmp = tmp>array[right]?array[right]:tmp;
        int sr = array[left];
        array[left] = tmp;
        if(array[right]==tmp) array[right] = sr;
        if(array[mid]==tmp)  array[mid] = sr;*/

    //================快速排序(递归)========================
    /*时间nlogn
    空间logn
    *
    * */
    public   static  void quickSortChild(int[] array,int left,int right){
       if(left > right) return;
       if(left == right) return;




        int index = targetIndex(array,left,right);
        quickSortChild(array,left,index-1);
        quickSortChild(array,index+1,right);
    }


    public  static  int targetIndex(int[] array,int left, int right){
        int tmp = array[left];
        int i =left;
        int j =right;

        while(i<j){
            while(i<j&&array[j]>=tmp){    //一定要把高位放到前边循环
                j--;
            }
            while(i<j&&array[i]<=tmp){
                i++;
            }

            swap(array,i,j);
        }
        swap(array,left,i);
        return i;
    }

    public static void quickSort(int[] array){
     quickSortChild(array,0,array.length-1);
    }

    public static void swap(int[] array,int x ,int y ){
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
//===============快速排序（非递归）====== ===================
    public static int target(int[] array,int left,int right){
        int tmp = array[left];
        int i =left;
        int j = right;
        while(i<j){
            while(i<j&&array[j]>=tmp){
                j--;
            }
            while(i<j&&array[i]<=tmp){
                i++;
            }
            swap(array,j,i);
        }
        swap(array,i,left);
        return i;
    }

    public static void quicklySort(int[] array){
        Stack<Integer> stack = new Stack<>();
        stack.push(array.length-1);
        stack.push(0);

        while(!stack.isEmpty()){
            int left = stack.pop();
            int right = stack.pop();
            if(left>=right){
                continue;
            }
            int index = target(array,left,right);
            stack.push(right);
            stack.push(index+1);
            stack.push(index-1);
            stack.push(left);
        }
    }
//=============堆排序=============时间nlog2n  空间 O1==============

    public static void adjustDown(int[] array,int p ,int len){   //以p为根构建大根堆
        int parent = p;
        int child = p*2+1; //p的左孩子节点
        while(child<len){
            if(child+1<len&&array[child]<array[child+1]){   //取孩子节点中大的那个
                child++;
            }
            if(array[child]>array[parent]){ //构建大根堆取三个数中最大放parent，小根堆就是三数最小
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = parent*2+1;
            }else{
                break;
            }
        }
    }

    public static void creatHeap(int[] array){
       for(int i =(array.length-1-1)/2;i>=0;i--){
           adjustDown(array,i,array.length);
       }
    }

    public static void sortHeap(int[] array){
        creatHeap(array); //构建完毕后，根节点array[0]为最大值
        int end = array.length-1;   //固定数据的次序 ，大根堆 从小到大
        while(end>0){
            int tmp = array[end];
            array[end] = array[0];
            array[0] = tmp;
            adjustDown(array,0,end);
            end--;
        }
    }




    //================================================
    public static void main(String[] args) {

        int[] array = {123,12,4213,45367,45,67,568,765,9867,9789789};
        System.out.println(Arrays.toString(array));
        //quickSort(array);
        //quicklySort(array);
        sortHeap(array);
        System.out.println(Arrays.toString(array));
    }

}
