package pac1;
import java.io.*;
import java.util.ArrayList;

public class CSV_File {
    //reading a whole file and storing each line in an arraylist.
    public static ArrayList<String> readFile(File file) {
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            String line = "";
            BufferedReader b = new BufferedReader(new FileReader(file));
            while ((line = b.readLine()) != null) {
                arrayList.add(line);
            }
            b.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }
    public static void writeOnFile(ArrayList<String> arrayList, File file){
        try {
            BufferedWriter b = new BufferedWriter(new FileWriter(file));
            for(String index:arrayList){
                b.write(index);
                b.newLine();
            }
            b.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void changeCell(ArrayList<String> arrayList, String username, String oldCell, String newCell){
        String recuiredLine = existsInFile(arrayList, username);
        String []row = recuiredLine.split(",");
        for (int index=0; index<row.length; index++){
            if(row[index].equals(username))
                row[index] = newCell;
        }
        arrayList.set(arrayList.indexOf(recuiredLine),String.join(",",row));
    }
    public static String existsInFile(ArrayList<String> arrayList, String username){
        boolean exist = false;
        String[] eachLine;
        for (String index: arrayList){
            eachLine = index.split(",");
            if(eachLine[0].equals(username)){
                return index;
            }
        }
        return null;
    }
    public static void deleteOneRecord(ArrayList<String> arrayList, String record){
        arrayList.remove(record);
    }
}
