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
        File file1 = new File("test-1.txt");
        ArrayList<String> movie = new ArrayList<String>(CSV_File.readTwoLines(file1));
        System.out.println(movie);


    }
}