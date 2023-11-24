import java.io.*;
import java.util.ArrayList;
import java.util.List;

import pac1.*;

public class Main {
    public static void main(String[] args) throws IOException {

//        FileReader f_read = new FileReader("test-1.txt");
//        FileWriter f_write = new FileWriter("test-2.txt");
//        int x = f_read.read();
//        char []arr = new char[10];
//        f_read.read(arr,0,4);
//        for (char i:arr) {
//            if(i != 0)
//              System.out.print(i);
//        }
//        f_read.close();
        BufferedReader b = new BufferedReader(new FileReader("test-1.txt"));
        String line = "";
        String[] row = new String[4];
//        while ((line = b.readLine()) != null){
//            row = line.split(",");
//        }
//        for(String s: row){
//            System.out.println(s);
//        }
       // System.out.println(row[2]);
        File file = new File("test-2.txt");
        OneRecord record = new OneRecord();
        boolean x = record.existInDatabase("hossam", file);
        if(x)
        {
            System.out.println(record.getRowNumber());
            System.out.println(record.getUsername());
        }
        record.deleteRecord("hossam", file);


    }
}