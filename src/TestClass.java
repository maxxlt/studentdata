import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {
    public static ArrayList<StudentData_Chan> readFile(String file1){//read file function
        ArrayList<StudentData_Chan> list = new ArrayList<>();
        String id, fname, lname, snumber, bday, pnumber, address;
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
               String line;
               String[] ss;
                while ((line = br.readLine()) != null) {//loop until till the end of the file
                    ss = line.split(",");
                    id=ss[0];
                    fname=ss[2];
                    lname=ss[1];
                    snumber=ss[3];
                    bday=ss[4];
                    pnumber=ss[5];
                    address=ss[6];
                    list.add(new StudentData_Chan(id, lname, fname, snumber, bday, pnumber, address));
                }
                br.close();
            }
            catch (Exception e){
                System.out.println("File not found.");
            }
        return list;
    }
    public static void main(String[] args) {
        String file1 = "/Users/maxxlt/Google Drive/SP2018/COSC-2436/studentdata/studentInformation.csv";
        String file2 = "/Users/maxxlt/Google Drive/SP2018/COSC-2436/studentdata/studentGrade.csv";
        ArrayList<StudentData_Chan> studentlist = readFile(file1);
        ArrayList<String> keys = new ArrayList<>();
        LQHashed_Chan ourdata = new LQHashed_Chan(100);
        for (int i = 0; i < studentlist.size(); i++){ //inserting info from file to data structure
            ourdata.insert(studentlist.get(i));
            keys.add(studentlist.get(i).getId());
            System.out.println(ourdata.fetch(keys.get(i)).toString());
        }
    }
}
