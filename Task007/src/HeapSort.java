import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] uArray = {20,1,3,5,7,8,6,4,2,1000, -80,0};
        System.out.println(Arrays.toString(uArray));
        uHeapSorting(uArray);
        System.out.println(Arrays.toString(uArray));
    }
    private static void uHeapSorting(int[] userArray){
        int lengthArr = userArray.length;

        for (int i = lengthArr - 1; i >= 0; i--) {
            uSerchItem(userArray, 0, i);
            uSwap(userArray, i, 0);
        }
    }
    private static void uSerchItem(int[] arr, int begin, int lengthUArr){
        for (int i = begin; i < lengthUArr - 1; i++) {
            if (arr[i+1] > arr[begin]) {
                uSwap(arr, i+1, begin);

            }
        }
    }
    private static void uSwap(int[] uArr, int firstItem, int secondItem){
        int temp = uArr[firstItem];
        uArr[firstItem] = uArr[secondItem];
        uArr[secondItem] = temp;
    }
}
