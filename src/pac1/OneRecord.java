package pac1;
import java.io.*;
import java.util.ArrayList;

public class OneRecord {

    //so no one can change the index[row no.] of a record in the file.
    private int rowNumber;
    private String[] row;
    public boolean existInDatabase (String username, File file)
    {

        String line = "";
        int rowNumber = 0;
        try {
            BufferedReader b = new BufferedReader(new FileReader(file));
            while ((line = b.readLine()) != null) {
                row = line.split(",");
                rowNumber++;
                if (row[0].equals(username)) {
                    this.rowNumber = rowNumber;
                    return true;
                }
            }
            b.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public void addToFile(ArrayList<String> arr, File file)
    {
        try {
            BufferedWriter b = new BufferedWriter(new FileWriter(file));
            for(String index:arr){
                b.write(index);
                b.newLine();
            }
            b.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteRecord(String username, File file)
    {
        boolean x = this.existInDatabase(username, file);
        if(x){
            ArrayList<String> arr = new ArrayList<String>();
            try {
                String line ="";
                String []check;
                String eachLine;
                BufferedReader b = new BufferedReader(new FileReader(file));
                while ((line = b.readLine()) != null) {
                    check = line.split(",");
                    System.out.println(line);
                    //won't add the wanted record to the list
                    if (!(check[0].equals(username))) {
                        arr.add(line);
                    }
                }
                this.addToFile(arr, file);
                b.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void changeCell(String username, String oldCell,String newCell, File file){
        boolean x = existInDatabase(username, file);
        if(x){
            try{
                BufferedReader b = new BufferedReader(new FileReader(file));
                String line = "";
                String []row;
                ArrayList<String> arrayList = new ArrayList<String>();
                while ((line = b.readLine()) != null){
                    row = line.split(",");
                    if(row[0].equals(username)){
                        for (int index=0; index<row.length; index++){
                            if(row[index].equals(username)) {
                                row[index] = newCell;
                                line = String.join(",",row);
                            }
                        }
                    }
                    arrayList.add(line);
                }
                addToFile(arrayList,file);
                b.close();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
