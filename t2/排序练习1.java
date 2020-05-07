import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class 排序练习1 {
    //堆排序
  public static void heapSort(int[] array){
    creatHeap(array);
    int end =array.length-1;
    while(end>=0){
      int tmp = array[end];
      array[end] = array[0];
      array[0] = tmp;
      adjustdown(array,0,end);
      end--;
    }
  }

  public static void creatHeap(int[] array){
    for(int i = (array.length-1-1)/2;i>=0;i--){
      adjustdown(array,i,array.length);
    }
  }

  public static void adjustdown(int[] array,int par ,int len){
    int p = par;
    int child = 2*p+1;
    while(child<len){
      if(child+1<len&&array[child+1]<array[child]){
        child++;
      }
      if(array[child]<array[p]){
        int tmp = array[child];
        array[child] = array[p];
        array[p] = tmp;
        p = child;
        child = p*2+1;
      }else{
        break;
      }
    }
  }
    //插入排序

  public static void insertSort(int[] array){
              int j = 0;
            for(int i = 1;i<array.length;i++){
                int tmp = array[i];
              for(j = i-1;j>=0;j--){
                if(array[j]>tmp){
                  array[j+1] = array[j];
                }else{
                  break;
                }
              }
              array[j+1] = tmp;

            }
  }
//   希尔排序

  public static void  shellSort(int[] array){
    int gap = array.length-1;
    while(gap>1){
      gap = gap/3+1;
      shellSortChild(array,gap);
    }
    shellSortChild(array,1);
  }

  public static void shellSortChild(int[] array,int gap){
    int j = 0;
    for(int  i = gap; i<array.length;i++){
        int tmp = array[i];
        for(j  = i - gap;j>=0;j-=gap){
          if(array[j]>tmp){
            array[j+gap] = array[j];
          }else{
            break;
          }
        }
        array[j+gap] = tmp;
    }
  }

  //冒泡排序
  public static void buble(int[] array){
    for(int i =0;i<array.length-1;i++){ //遍历次数
      boolean aa = false;
      for(int j = 0;j<array.length-i-1;j++){
        if(array[j+1]>array[j]){
          int t = array[j+1];
          array[j+1] = array[j];
          array[j] = t;
          aa = true;
        }
      }
      if(!aa){
        break;
      }
    }
  }
  //选择排序

  public static void selectSort(int[] array){
    for(int i = 0;i<array.length;i++){
      for(int j =i+1;j<array.length;j++){
        if(array[j]>array[i]){
          int tmp = array[i];
          array[i] = array[j];
          array[j] = tmp;
        }
      }
    }
  }
//  快速排序 递归
  public static void quickSort(int[] array){
     quickSortChild(array,0,array.length-1);
  }
  public static void quickSortChild(int[] array,int low,int high){
    if(low>=high){
      return;
    }
    int target  = partion(array,low,high);
    quickSortChild(array,low,target-1);
    quickSortChild(array,target+1,high);
  }

  public static int partion(int[] array,int low,int high){
    int tmp = array[low];
    int i =low;
    int j = high;
    while(i<j){
      while(i<j&&array[j]<=tmp){  //必须加等号
        j--;
      }

      while(i<j&&array[i]>=tmp){
        i++;
      }

      swap(array,i,j);
    }
    swap(array,low,i);
    return i;
  }

  //快排 不递归
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
      int target= partion(array,low,high);


      stack.push(target-1);
      stack.push(low);
      stack.push(high);
      stack.push(target+1);
    }
  }


  public static void swap(int[]array,int i ,int j){
    int tmp = array[i];
    array[i]= array[j];
    array[j] = tmp;
  }
//归并排序 递归

  public static void mergeSort(int[] array){
    mergeSortChild(array,0,array.length-1);
  }

  public static void mergeSortChild(int[] array,int low, int high){
    if(low>=high){
      return;
    }
    int mid = (low+high)/2;
    mergeSortChild(array,low,mid);
    mergeSortChild(array,mid+1,high);
    merg(array,low,mid,high);
  }

  public static void merg(int[] array,int low,int mid,int high){
    int[] tmp = new int[high-low+1];
    int k = 0;
    int s1 = low;
    int s2 = mid+1;
    while(s1<mid+1&&s2<high+1){
      if(array[s1]<array[s2]){
        tmp[k++] = array[s2++];
      }else{
        tmp[k++] = array[s1++];
      }
    }
    while(s1<mid+1){
      tmp[k++] = array[s1++];
    }
    while(s2<high+1){
      tmp[k++] = array[s2++];
    }
    for(int i = 0;i<tmp.length;i++){
      array[low++] = tmp[i];
    }
  }

//  归并 非递归

  public static void mergeSort2(int[] array){
    for(int i =1;i<array.length;i*=2){
      mergeSort2Child(array,i);//一组i个数字
    }
  }

  public static void mergeSort2Child(int[] array,int gap ){
    int[] tmp = new int[array.length];
    int k = 0;
    int s1 = 0;
    int e1 = s1+gap-1;
    int s2 = e1+1;
    int e2 = s2+gap-1<array.length? s2+gap-1: array.length-1;
    while(s2<array.length){
      while(s1<=e1&&s2<=e2){
        if(array[s1]>array[s2]){
          tmp[k++] = array[s1++];
        }else{
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
      e2 = s2+gap-1<array.length? s2+gap-1: array.length-1;
    }
    while(s1<array.length){
      tmp[k++] = array[s1++];
    }
    for(int i =0;i<tmp.length; i++){
      array[i] = tmp[i];
    }
  }



  public static void main(String[] args) {
    int[] a = {1,3,2,5,4};
    //buble(a);
    //quickSort2(a);
    mergeSort2(a);
    System.out.println(Arrays.toString(a));
  }
}
