import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class StudentService_Chan {
    public static void ClearScreen(){
        for( int clear = 0; clear < 100; clear++)
            System. out. println( "\b") ;
    }
    public static LQHashed_Chan readFile(String file1, String file2) {//read file function
        //Declaring needed objects
        LQHashed_Chan ourhash = new LQHashed_Chan(1000);
        StudentGradeData gradeData = new StudentGradeData();
        //Trying to open 2 data files
        try {
            String line, line1;
            String[] ss, ss1;
            BufferedReader f1 = new BufferedReader(new FileReader(file1));
            BufferedReader f2 = new BufferedReader(new FileReader(file2));
            while ((line = f1.readLine()) != null && (line1 = f2.readLine()) != null){
                StudentData_Chan studentdata = new StudentData_Chan();
                ss = line.split(",");
                ss1 = line1.split(",");
                //assigning according to the file
                studentdata.setId(ss[0]);
                studentdata.setLname(ss[1]);
                studentdata.setFname(ss[2]);
                studentdata.setSnumber(ss[3]);
                studentdata.setBday(ss[4]);
                studentdata.setPnumber(ss[5]);
                studentdata.setAddress(ss[6]);
                gradeData.setId(ss1[0]);
                //Looping 2nd file to get our LinkedList object filled up
                for(int i = 1; i < ss1.length;i++){
                    if (i%2==0){//if it's even index
                        gradeData.setGrade(ss1[i]);
                        studentdata.setGradelist(gradeData);
                    }
                    else if (i%2==1)//if it's odd index
                        gradeData.setClass(ss1[i]);
                    else//otherwise if there is nothing
                        break;
                }
                ourhash.insert(studentdata);
            }
        }
        catch (Exception e){//catch file not found
            System.out.println("File not found.");
        }


        return ourhash;
    }
    public static void MainMenu(){
        System.out.println("1. Add one student from the keyboard");
        System.out.println("2. Remove one student");
        System.out.println("3. Find one student by ID");
        System.out.println("4. Add a class for one student");
        System.out.println("5. Drop a class for one student");
        System.out.println("6. Print the list of student names in one class");
        System.out.println("7. Print out the transcript of one student");
        System.out.println("8. Show all students in the data structure");
        System.out.println("9. Exit");
    }
    public static StudentData_Chan insertStudent(){
        StudentData_Chan studentdata = new StudentData_Chan();
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Student's ID: ");
        String str = keyboard.nextLine();
        studentdata.setId(str);
        System.out.print("Student's last name: ");
        str = keyboard.nextLine();
        studentdata.setLname(str);
        System.out.print("Student's first name: ");
        str = keyboard.nextLine();
        studentdata.setFname(str);
        System.out.print("Student's security number: ");
        str = keyboard.nextLine();
        studentdata.setSnumber(str);
        System.out.print("Student's birthday: ");
        str = keyboard.nextLine();
        studentdata.setBday(str);
        System.out.print("Student's phone number: ");
        str = keyboard.nextLine();
        studentdata.setPnumber(str);
        System.out.print("Student's address: ");
        str = keyboard.nextLine();
        studentdata.setAddress(str);
        return studentdata;
    }
    public static void main(String[] args) throws InterruptedException{
        String file1 = "/Users/maxxlt/Google Drive/SP2018/COSC-2436/studentdata/studentInformation.csv";//directory of the main
        String file2 = "/Users/maxxlt/Google Drive/SP2018/COSC-2436/studentdata/studentGrade.csv";//directory of the grade file
        LQHashed_Chan ourhash = readFile(file1, file2);//our hash list of imported files
        Scanner keyboard = new Scanner(System.in);
        int choice;
        do {
            MainMenu();
            System.out.print("Choice: ");
            choice = keyboard.nextInt();
            switch (choice){
                case 1: //adding new student
                    StudentData_Chan studentdata = insertStudent();
                    ourhash.insert(studentdata);
                    System.out.println();
                    System.out.println();
                    System.out.println("INSERT SUCCESS :)");
                    Thread.sleep(1500);
                    ClearScreen();
                    break;
                case 2: //removing student
                    keyboard.nextLine();
                    System.out.print("Removing Student with an ID: ");
                    String remove = keyboard.nextLine();
                    System.out.println();
                    if(ourhash.delete(remove)){
                        System.out.println("Student with ID "+remove+" is removed");
                    }
                    else
                        System.out.println("Student with ID "+remove+" is NOT in the system");
                    Thread.sleep(1500);
                    ClearScreen();
                    break;
                case 3:
                    System.out.println("Student's ID: ");
            }
        } while (choice != 9);
    }
}
