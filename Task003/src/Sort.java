/*
2.Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
*/
import java.util.Arrays;
import java.io.IOException;
import java.util.logging.*;
public class Sort {
    public static void main(String[] args) throws IOException {
        int[] uArray = {1,3,54,6,3,2,59,6,3,18,4,2,5};
        System.out.println("Original user array: "+Arrays.toString(uArray));
        uSorting(uArray);
        System.out.println("Sorted user array: "+Arrays.toString(uArray));




    }
    private static void uSorting(int[] userArray) throws IOException {

        Logger logger = Logger.getLogger(Sort.class.getName());
        FileHandler fh = new FileHandler("logOfSorting.txt");
        logger.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);


        int tempValue = 0;
        for (int i = userArray.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if(userArray[j] > userArray[j+1]){
                    tempValue = userArray[j];
                    userArray[j] = userArray[j+1];
                    userArray[j+1] = tempValue;
                    logger.info(Arrays.toString(userArray));
                }

            }
        }
    }
}
