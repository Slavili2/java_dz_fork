/*
4*. Реализуйте простой калькулятор, с консольным интерфейсом. К калькулятору добавить логирование.
*/
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;
public class Program {
    public static void main(String[] args) throws IOException {
        System.out.println("Простой калькулятор.");
        System.out.println("Разрешённые действия: +,-,*,/");
        System.out.print("Введите первое число: ");
        try{
            Scanner i1 = new Scanner(System.in);
            double item1 = i1.nextDouble();
            System.out.print("Введите второе число: ");
            Scanner i2 = new Scanner(System.in);
            double item2 = i2.nextDouble();
            System.out.print("Введие действие: ");
            Scanner ch = new Scanner(System.in);
            char calculation = ch.next().charAt(0);
            if(calculation == '/' && item2 == 0){
                System.out.println("Деление на ноль невозможно!!!");
            }
            else System.out.println(item1+" "+ calculation+" "+ item2+" = "+ uCalculation(item1,item2,calculation));


        }catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    private static double uCalculation(double item1, double item2, char action) throws IOException {
        double tempResult = 0;
        try{
            Logger logger = Logger.getLogger(Program.class.getName());
            FileHandler fh = new FileHandler("logOfCalculation.txt");
            logger.addHandler(fh);

            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            switch(action){
                case '*' -> {
                    tempResult = item1 * item2;
                    logger.info(item1 + " * " + item2 + " = "+tempResult);
                }
                case '/' -> {
                    tempResult = item1 / item2;
                    logger.info(item1 + " / " + item2 + " = "+tempResult);
                }
                case '+' -> {
                    tempResult = item1 + item2;
                    logger.info(item1 + " + " + item2 + " = "+tempResult);
                }
                case '-' -> {
                    tempResult = item1 - item2;
                    logger.info(item1 + " - " + item2 + " = "+tempResult);
                }
                default -> {
                    System.out.println("Такая операция не предусмотрена!");
                    logger.info("операция '"+ action +"' не предусмотрена!");
                }
            }
        }    catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


    return tempResult;
    }
}
