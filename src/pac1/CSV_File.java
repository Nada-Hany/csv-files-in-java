package pac1;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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
    public static ArrayList<String> readTwoLines(File file)  {
        ArrayList<String> arrayList = new ArrayList<String>();
        String line = "";
        String[] firstLine = new String[20];
        String[] wholeLine = new String[20];
        try{
            int i = 0;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while((line = bufferedReader.readLine()) != null){
                if(i % 2 == 0){
                    firstLine = line.split(",");
                }
                else {
                    wholeLine = line.split(",");
                    //System.arraycopy(wholeLine ,0 ,firstLine ,5,16);
                    firstLine = Arrays.copyOf(firstLine, firstLine.length + wholeLine.length);
                    int g = 0 , k = 6;
                    while(k < firstLine.length && g< wholeLine.length){
                        System.out.println(g);
                        firstLine[k] = wholeLine[g];
                        ++g;
                        ++k;
                    }
                    String eachLine =String.join(",", firstLine);
                    arrayList.add(eachLine);
                }

                i++;
            }
        }
        catch (IOException ioException){
            throw new RuntimeException(ioException);
        }
        return  arrayList;
    }
}
