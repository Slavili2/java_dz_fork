/*
1. Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
Данные для фильтрации приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;

public class selectStatement {
    public static void main(String[] args)  throws IOException{
        String filePath ="WHERE.json";
        testFile(filePath);
    }


    public static void testFile(String filePath) throws IOException{
        String line = "empty";
        StringBuilder resultStringBuilder = new StringBuilder();
        try{
            BufferedReader uReader = new BufferedReader(new FileReader(filePath));
            //BufferedReader uReader = new BufferedReader(new FileReader("WHERE.json"));
            while((line = uReader.readLine()) != null){
                resultStringBuilder.append(line);
            }
            StringBuilder selectV1 = new StringBuilder();
            selectV1.append("SELECT * FROM students WHERE 1=1");
            JSONObject jo = new JSONObject(resultStringBuilder.toString());
            JSONArray myArr = jo.names();

            for (int i = 0; i < myArr.length(); i++) {

                if(!jo.opt((String)myArr.get(i)).toString().equalsIgnoreCase("null") ){
                    selectV1.append(" AND "+myArr.get(i) +" = '"+jo.opt((String)myArr.get(i))+"'");
                }

            }
            System.out.println(selectV1);
        }        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
