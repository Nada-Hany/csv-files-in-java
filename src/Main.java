import java.io.*;
import java.util.ArrayList;
import java.util.List;
import pac1.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader b = new BufferedReader(new FileReader("test-1.txt"));
        String line = "";
        String[] row = new String[4];
        File file = new File("test-2.txt");
//        OneRecord record = new OneRecord();
//        boolean x = record.existInDatabase("hossam", file);
//        if(x)
//        {
//            System.out.println(record.getRowNumber());
//            System.out.println(record.getUsername());
//        }
//        record.deleteRecord("hossam", file);

        String s = "hello,sw,e222";
        String []arr = s.split(",");
        arr[1]="hhhh";
        String sNew = String.join(",", arr);
        System.out.println(sNew);

        OneRecord record = new OneRecord();
        record.changeCell("mahmoud","mahmoud", "ahlaaannn", file);



    }
}