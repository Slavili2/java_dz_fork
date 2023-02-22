import java.lang.reflect.Array;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {

        int[] uArray3 = {2,3,32,34,85,7,0,97,45,8,800,97,61,2,38,4,70,2,9,3,8,46,78,38,49,71,6,2,9,387,68,97,84,54,0};

        System.out.println(Arrays.toString(uArray3));
        System.out.println("****************");
        uMergeSortV1(uArray3);
        System.out.println("****************");
        System.out.println(Arrays.toString(uArray3));

    }

    private static void uMergeV1(int[] firstArray, int startFirstArray, int[] secondArray, int startSecondArray, int[] destArray, int dStart, int size){

        int iFirstArray = startFirstArray;
        int iSecondArray =startSecondArray;
        int endFirstArray = Math.min(startFirstArray + size, firstArray.length);
        int endSecondArray = Math.min(startSecondArray + size, secondArray.length);

        int tempCount = endFirstArray - startFirstArray + endSecondArray - startSecondArray;

        if(startFirstArray + size > firstArray.length){
            for (int i = startFirstArray; i < endFirstArray; i++) {
                destArray[i] = firstArray[i];
            }
            return;
        }

        for(int i = dStart; i < dStart + tempCount; i++){
            if(iFirstArray < endFirstArray && (iSecondArray>= endSecondArray || firstArray[iFirstArray] < secondArray[iSecondArray])){
                destArray[i] = firstArray[iFirstArray];
                iFirstArray++;
            } else{
                destArray[i] =secondArray[iSecondArray];
                iSecondArray++;
            }
        }

    }

    private static void uMergeSortV1(int[] userArray){
        int[] tmp;
        int[] currentArray = userArray;
        int[] arrDest = new int[userArray.length];

        int stepSize = 1;

        while(stepSize < userArray.length){
            for(int i = 0; i < userArray.length; i+=2*stepSize){
                uMergeV1(currentArray, i, currentArray, i+stepSize, arrDest, i, stepSize);
                //System.out.println(i);
            }

            tmp = currentArray;
            currentArray = arrDest;
            arrDest = tmp;

            stepSize = stepSize * 2;
        }
    }


}
