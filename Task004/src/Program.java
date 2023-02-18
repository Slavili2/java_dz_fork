/*
Дана json строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

Написать метод(ы), который распарсит json и, используя StringBuilder,
создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
Пример вывода:

Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
*/

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
public class Program {
    public static void main(String[] args) throws IOException {
        String filePath = "Z:\\shared\\copy_java_dz\\Task004\\src\\SOURCE.json";
        String line = "empty";
        StringBuilder resultStringBuilder = new StringBuilder();
        StringBuilder destinationStringBuilder = new StringBuilder();
    try{
        BufferedReader uReader = new BufferedReader(new FileReader(filePath));
        while((line = uReader.readLine()) != null){
            resultStringBuilder.append(line);
        }

        JSONArray array = new JSONArray(resultStringBuilder.toString());
        JSONObject jo = new JSONObject();
        BufferedWriter writer = new BufferedWriter(new FileWriter("destination.txt"));

        for (int i = 0; i < array.length(); i++) {
            jo = new JSONObject(array.get(i).toString());

            writer.write("Студент "+jo.get("фамилия")+" получил "+jo.get("оценка")+" по предмету "+jo.get("предмет")+".\n");
            destinationStringBuilder.append("Студент "+jo.get("фамилия")+" получил "+jo.get("оценка")+" по предмету "+jo.get("предмет")+".\n");
        }
        writer.close();

        System.out.println(destinationStringBuilder.toString());
    }
    catch(FileNotFoundException e) {
        System.out.println(e.getMessage());
    }

    }

}
