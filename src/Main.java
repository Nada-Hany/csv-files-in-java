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
//        CSV_File record = new CSV_File();
//        boolean x = record.existInDatabase("hossam", file);
//        if(x)
//        {
//            System.out.println(record.getRowNumber());
//            System.out.println(record.getUsername());
//        }
//        record.deleteRecord("hossam", file);
//
//        String s = "hello,sw,e222";
//        String []arr = s.split(",");
//        arr[1]="hhhh";
//        String sNew = String.join(",", arr);
//        System.out.println(sNew);
//
//        CSV_File record = new CSV_File();
//        record.changeCell("mahmoud","mahmoud", "ahlaaannn", file);
            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList = CSV_File.readFile(file);
            for (String index:arrayList)
                System.out.println(index);
        //ArrayList<String> arrayList2 = new ArrayList<String>();
        String ans;
        ans = CSV_File.existsInFile(arrayList,"sara");
        //arrayList.remove(ans);
        CSV_File.deleteOneRecord(arrayList,ans);
        System.out.println("\n\n");
        for (String index:arrayList)
            System.out.println(index);
        //System.out.println(ans);
        CSV_File.writeOnFile(arrayList,file);
        System.out.println("written succ");
        System.out.println("\n\n");
        CSV_File.changeCell(arrayList,"nada", "nada", "nadaaa");
        for (String index:arrayList)
            System.out.println(index);
        System.out.println("\n\n");

    }
}