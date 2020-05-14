import java.util.*;

public class Sort大全集 {



    //----------------------------------------------------------------------------------------------------------------------------------\\

    /**
     * 堆排序(升序排序)：1、建立大根堆;2、将堆顶元素放到最后进行排序
     * 时间复杂度：n*log2n;
     * 空间复杂度：O(1);
     * 建堆时间复杂度：n*log2n;
     * 一次调整的时间复杂度：log2n
     * 不稳定的排序算法
     * @param array
     */
    public static void headpSort(int[] array){
        createHeap(array);//用来建立大根堆（堆顶存放最大值）
        int end = array.length-1;
        //开始排序，将堆顶元素放到最底下,每交换一次做一次向上调整
        while(end > 0){
            int tmp = array[end];
            array[end] = array[0];
            array[0] = tmp;
            adjustDown(array,0,end);
            end--;
        }
    }
    private static void createHeap(int[] array) {
        for(int i = (array.length -1 -1)/2;i >=0;i--){
            adjustDown(array,i,array.length);//对每一棵子树进行向上调整
        }
    }
    private static void adjustDown(int[] array, int root, int len) {//向上调整-->根节点的值大于左右孩子的值
        int parent = root;//父亲节点
        int child = 2*parent+1;//得到的是左孩子
        while(child < len){
            //用来判断是否有右孩子并且获得左右孩子中最大的值的位置
            if(child+1 < len && array[child] < array[child+1]){
                child++;
            }
            if(array[child] > array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] =tmp;
                parent = child;
                child = 2*parent+1;
            }else{
                break;
            }
        }
    }

//----------------------------------------------------------------------------------------------------------------------------------\\

    /**
     * 插入排序：1、将数组分为一个有序区间，一个无序区间；2、在无序区间中取数据插入有序区间中合适的位置
     * 时间复杂度：
     *      最好：O(n) -- 越有序越快
     *      最坏：O(n^2)
     * 空间复杂度：O(1)
     * 稳定的排序算法
     * @param array
     */
    public static void insertSort(int[] array){
        int j = 0;
        for(int i = 1; i < array.length;i++){//遍历数组,i 前为有序区间，i 后为无序区间
            int tmp = array[i];//待插入的数据
            for(j = i-1;j >= 0;j--){//找合适的位置
                if(array[j] > tmp){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = tmp;//将 tmp 插入
        }
    }

//----------------------------------------------------------------------------------------------------------------------------------\\

    /**
     * 希尔排序：1、可以说是对插入排序的优化；2、对数据进行分组然后再插入排序；
     * 时间复杂度：O(n^1.3 - n^1.5)
     * 空间复杂度：O(1)
     * 不稳定的排序算法
     * @param array
     */
    public static void shellSort(int[] array){
        int[] drr = {5,3,1};
        for(int i = 0;i < drr.length;i++){
            shell(array,drr[i]);
        }
    }
    private static void shell(int[] array, int gap) {
        int j = 0;
        for(int i = gap;i < array.length;i++){
            int tmp = array[i];
            for(j = i-gap;j >= 0;j -= gap){
                if(array[j] > tmp){
                    array[j+gap] = array[j];
                }else{
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

//----------------------------------------------------------------------------------------------------------------------------------\\

    /**
     * 选择排序：遍历数组，每次把最小的元素向前放
     * 时间复杂度：O(n^2)
     * 空间负责度：O(1)
     * 不稳定的排序算法
     * @param array
     */
    public static void selectSort(int[] array){
        for(int i = 0;i < array.length;i++){
            for(int j = i+1;j < array.length;j++){//将最小的元素放到 i 位置
                if(array[j] < array[i]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

//----------------------------------------------------------------------------------------------------------------------------------\\

    /**
     * 冒泡排序：每一趟遍历将最大的元素放到最后
     * 时间复杂度：O(n^2);
     * 空间复杂度：O(1)
     * 稳定的排序算法
     * @param array
     */
    public static void bubbleSort(int[] array){
        for(int i = 0;i < array.length-1;i++){//遍历的趟数
            for(int j = 0;j < array.length-1-i;j++){//每趟遍历的次数
                if(array[j] > array[j+1]){
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

//----------------------------------------------------------------------------------------------------------------------------------\\

    /**
     * 快速排序：1. 从待排序区间选择一个数，作为基准值(pivot)；
     *           2. partion: 遍历整个待排序区间，将比基准值小的（可以包含相等的）放到基准值的左边，
     *                       将比基准值大的（可以包含相等的）放到基准值的右边；
     *           3. 采用分治思想，对左右两个小区间按照同样的方式处理，直到小区间的长度 == 1，代表已经有序，
     *              或者小区间的长度 == 0，代表没有数据。
     * 时间复杂度：O(n*log2n),最坏O(n^2);
     * 空间复杂度：O(log2n)
     * 不稳定的排序
     * @param array
     */
    public static void quickSort(int[] array){
        quickNor(array,0,array.length-1);
    }
    //递归实现
    private static void quick(int[] array, int low, int high) {
        if(low >= high){
            return;
        }
        int pivot = partion(array,low,high);//找基准的下标，并且基准的左边小于基准，基准的右边大于基准
        quick(array,low,pivot-1);
        quick(array,pivot+1,high);
    }
    //非递归实现
    private static void quickNor(int[] array, int low, int high) {
        int pivot = partion(array,low,high);
        Stack<Integer> stack = new Stack<>();
        if(pivot > low+1){
            stack.push(low);
            stack.push(pivot-1);
        }
        if(pivot < high-1){
            stack.push(pivot+1);
            stack.push(high);
        }
        while(!stack.empty()){
            high = stack.pop();
            low = stack.pop();
            pivot = partion(array,low,high);
            if(pivot > low+1){
                stack.push(low);
                stack.push(pivot-1);
            }
            if(pivot < high-1){
                stack.push(pivot+1);
                stack.push(high);
            }
        }
    }
    private static int partion(int[] array,int start, int end) {
        int tmp = array[start];
        while(start < end){
            while((start < end) && (array[end]) >= tmp){
                end--;
            }
            if(start >= end){
                break;
            }else{
                array[start] = array[end];

            }
            while((start < end) && array[start] <= tmp){
                start++;
            }
            if(start >= end){
                break;
            }else{
                array[end] = array[start];
            }
        }
        array[start] = tmp;
        return start;
    }


//----------------------------------------------------------------------------------------------------------------------------------\\

    /**
     * 归并排序：归并排序是建立在归并操作上的一种有效的排序算法,该算法是采用分治法
     *           将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使
     *           子序列段间有序。若将两个有序表合并成一个有序表，称为二路归并。
     * 时间复杂度：n*log2n;
     * 空间复杂度：O(n)
     * 稳定的排序算法
     * @param array
     */
    public static void mergeSort(int[] array){
        mergeSortChild(array,0,array.length-1);
    }

//从小段到大段进行归并
    private static void mergeSortChild(int[] array, int low, int high) {
        if(low >= high){
            return;
        }
        int mid = (low + high)/2;
        mergeSortChild(array,low,mid); //递归传入前一半，使前一半有序
        mergeSortChild(array,mid+1,high);//递归传入后一半，使后一半有序
        merge(array,low,mid,high);//调用排序算法的函数，将两段有序的部分合为一个有序部分
    }
 //主要思想就是新建一个数组，遍历两个需要归并的数组比大小，每次把大的（小的）放进新数组。再把新数组赋值给原数组的对应的位置
    //传入的low、mid、high是需要被归并的两段数字在大数组的起步下标和最后下标。并非整个数组的
    private static void merge(int[] array, int low, int mid, int high) {
        int s1 = low;
        int s2 = mid+1;
        int[] tmpArr = new int[high-low+1];
        int i = 0;
        while(s1 <= mid && s2 <= high){ //取小的放进新数组
            if(array[s1] < array[s2]){
                tmpArr[i++] = array[s1++];
            }else{
                tmpArr[i++] = array[s2++];
            }
        }
        while(s1 <= mid){      //可能s2加完了，s1还没加完
            tmpArr[i++] = array[s1++];
        }
        while(s2 <= high){    //可能s1加完了，s2还没加完
            tmpArr[i++] = array[s2++];
        }
        for(int j = 0;j < tmpArr.length;j++){ //从原数组被排序部分的第一下标开始赋值，赋值到新建数组结束
            array[low++] = tmpArr[j];
        }
    }
//==============非递归===============
    public static void mergeSortNor(int[] array){
        for(int i = 1;i < array.length;i *= 2){
            mergeNor(array,i);
        }
    }

    private static void mergeNor(int[] array, int gap) {
        int[] tmpArr = new int[array.length];
        int k = 0;
        int s1 = 0;
        int e1 = s1 + gap -1; //两组一归并，e1是第一组最后数字，e2是第二组最后数字
        int s2 = e1 + 1;
        int e2 = s2 + gap -1 < array.length ? s2+gap-1:array.length-1;
        while(s2 < array.length){
            while(s1 <= e1 && s2 <= e2){
                if(array[s1] < array[s2]){
                    tmpArr[k++] = array[s1++];
                }else{
                    tmpArr[k++] = array[s2++];
                }
            }
            while(s1 <= e1){
                tmpArr[k++] = array[s1++];
            }
            while(s2 <= e2){
                tmpArr[k++] = array[s2++];
            }
            s1 = e2+1;
            e1 = s1 + gap -1;
            s2 = e1+1;
            e2 = s2+gap-1 <array.length ? s2+gap-1:array.length-1;
        }
        //跳出循环时，第二组起点s2==array.length，所以只有第一组有数据，所以直接写s1<=数组长度-1
        while(s1 <= array.length-1){ //可能存在第二组数字个数小于第一组的情况，此时将第一组全加入
            tmpArr[k++] = array[s1++];
        }
        for(int i = 0;i < array.length;i++){
            array[i] = tmpArr[i];
        }
    }


//----------------------------------------------------------------------------------------------------------------------------------\\
}