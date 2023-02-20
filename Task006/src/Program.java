import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        int[] uArray2 = {1,2,3,4,5,6};
        int[] uArray1 = {1,4,7};
        int[] result = new int[uArray1.length + uArray2.length];
        System.out.println(Arrays.toString(result));
        uMerge(uArray2, uArray1, result);
        System.out.println(Arrays.toString(result));
    }

    private static void uMerge(int[] firstArray, int[] secondArray, int[] destArray){
        int tempCount = firstArray.length + secondArray.length;
        int iFirstArray = 0;
        int iSecondArray =0;
        for(int i = 0; i < tempCount; i++){
            if(iFirstArray < firstArray.length && (firstArray[iFirstArray] < secondArray[iSecondArray]) || iSecondArray>=secondArray.length){
                destArray[i] = firstArray[iFirstArray];
                iFirstArray++;
            } else{
                destArray[i] =secondArray[iSecondArray];
                iSecondArray++;
            }
        }
    }

    private static void uMergeForSortV1(int[] firstArray, int startFirstArray, int[] secondArray, int startSecondArray, int[] destArray, int size){
        int tempCount = firstArray.length + secondArray.length;
        int iFirstArray = 0;
        int iSecondArray =0;
        for(int i = 0; i < tempCount; i++){
            if(iFirstArray < firstArray.length && (firstArray[iFirstArray] < secondArray[iSecondArray]) || iSecondArray>=secondArray.length){
                destArray[i] = firstArray[iFirstArray];
                iFirstArray++;
            } else{
                destArray[i] =secondArray[iSecondArray];
                iSecondArray++;
            }
        }
    }

    private static int[] uMergeSortV1(int[] userArray){

    int[] resultArray = userArray;
    int stepSize = 1;//razmer massiva s konca

    while(stepSize < resultArray.length){
        for(int i = 0; i < userArray.length; i+=2*stepSize){

        }

        stepSize*=2;
    }

    return resultArray;
    }


}
