import java.io.*;
import java.util.ArrayList;

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


//        boolean isExists = record.existInDatabase("sara");
//        System.out.println(record.getRowNumber());
//        if(isExists)
//            System.out.println(record.getUsername());
//        if(isExists){
//            int rowNumber = 0;
//            while ((line = b.readLine()) != null){
//                row = line.split(",");
//                rowNumber++;
//                if(rowNumber == record.getRowNumber())
//                    System.out.println(row[0]);
//            }
//        }
//        else {
//            System.out.println("record not found");
//        }
//        ArrayList<String>arr = new ArrayList<String>();
//        arr.add("hossam,123,hossam@gmail,30-3");
//        arr.add("manal,456,manal@gmail,9-4");
//        try {
//            BufferedWriter b2 = new BufferedWriter(new FileWriter(file));
//            for(String index:arr){
//                b2.write(index);
//                b2.newLine();
//            }
//            b2.close();
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }
}