public class FillAndPrintArray {
    public static void upFillMap(int[][] userArray){
        int min = 0;
        int max = userArray.length;
        int block = -1;

        for (int i = 0; i < userArray.length; i++) {
            int d = (int)(Math.random() * (max - min) + min)/2;
            for (int j = 0; j <= d; j++) {
                userArray[i][((int)(Math.random() * (max - min) + min))] = block;
            }
        }
    }

    public static void printMap(int[][] userArray){
        for (int i = 0; i < userArray.length; i++) {
            for (int j = 0; j < userArray[i].length; j++) {
                System.out.print(userArray[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
