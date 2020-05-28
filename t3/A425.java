public class A425 {
    public static void main(String[] args) {
        int[] A = {-10,0,0,0,-12};
        System.out.println(findMaxGap(A,7));
    }


    public static int findMaxGap(int[] A, int n) {
        int max = 0;
        for(int i = 0 ; i<A.length;i++){
            for(int j = 0; j < A.length;j++){
                max = max >Math.abs(A[i]-A[j])? max :Math.abs(A[i]-A[j]);
            }
        }

        return max;
    }
}
