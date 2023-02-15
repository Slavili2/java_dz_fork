//+Написать программу вычисления n-ого треугольного числа

public class Triangle {
    public static void main(String[] args) {

        int number = 3;

        System.out.println(TriangularNumberV1(number));
        System.out.println(TriangularNumberV2(number));
        System.out.println(TriangularNumberV3(number, 0));
    }

    public static int TriangularNumberV1(int userNumber){
        int resultSum = 0;
        for(int i = 1; i <= userNumber; i++){
            resultSum+=i;
        }
        return resultSum;
    }

    public static int TriangularNumberV2(int userNumber){
        return userNumber*(userNumber+1)/2;
    }

    public static int TriangularNumberV3(int userNumber, int result){
        if(userNumber <= 0 )
            return result;
        return TriangularNumberV3(userNumber - 1, result +=userNumber);
    }
}
