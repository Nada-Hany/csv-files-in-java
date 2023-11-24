package pac1;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class OneRecord {

    //so no one can change the index[row no.] of a record in the file.
    private int rowNumber;
    private String[] row;
    protected void addToFile(ArrayList<String> arr, File file)
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
    public void deleteRecord(String username, File file)
    {
        boolean x = this.existInDatabase(username, file);
        if(x){
            ArrayList<String> arr = new ArrayList<String>();
            try {
                String line ="";
                String []check;
                BufferedReader b = new BufferedReader(new FileReader(file));
                while ((line = b.readLine()) != null) {
                    check = line.split(",");
                    //won't add the wanted record to the list
                    if (!(check[0].equals(username))) {
                        arr.add(Arrays.toString(check));
                    }
                }
                this.addToFile(arr, file);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public int getRowNumber(){
        return rowNumber;
    }
    public String getUsername(){
        return row[0];
    }
    public String getPassword(){
        return row[1];
    }
    public String getEmail(){
        return row[2];
    }

}
