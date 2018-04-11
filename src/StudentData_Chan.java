import java.util.ArrayList;
import java.util.LinkedList;

public class StudentData_Chan {
    private String id, fname, lname, snumber, bday, pnumber, address;
    private SinglyLinkedList_Chan gradelist;
    public StudentData_Chan(String id,String lname,String fname,String snumber,String bday,String pnumber,String address){
        this.id = id;
        this.lname = lname;
        this.fname = fname;
        this.snumber = snumber;
        this.bday = bday;
        this.pnumber = pnumber;
        this.address = address;
    }
    public StudentData_Chan(){

    }
    public String getId(){
        return id;
    }
    public String getFname(){
        return fname;
    }
    public String getLname(){
        return lname;
    }
    public String getSnumber(){
        return snumber;
    }
    public String getBday(){
        return bday;
    }
    public String getPnumber(){
        return pnumber;
    }
    public String getAddress(){
        return address;
    }
    public void setGradelist(StudentGradeData newData){
        gradelist.insert(newData);
    }
    public void updateGrade(StudentGradeData newData){
        gradelist.update(getId(), newData);
    }
    public void deleteGrade(){
        //NEEDS EDIT
    }
    public void showClasses(){
        //NEEDS EDIT
    }
    public int compareTo(String targetKey){
        return (id.compareTo(targetKey));
    }
    public StudentData_Chan deepCopy(){
        StudentData_Chan clone = new StudentData_Chan(id, lname, fname, snumber, bday, pnumber, address);
        return clone;
    }
    public String toString() {
        String str = String.format("%-25s %10s", "Student:", getFname() + " "+getLname()+ "\n");
        str += String.format("%-25s %10s", "Student ID:", getId() + "\n");
        str += String.format("%-25s %10s", "SS Number:", getSnumber() + "\n");
        str += String.format("%-25s %10s", "Birthday:", getBday() + "\n");
        str += String.format("%-25s %10s", "Phone:", getPnumber() + "\n");
        str += String.format("%-25s %10s", "Address:", getAddress() + "\n");
        return str;
    }
    public String fileStringMain(){
        String str = getId()+","+getLname()+","+getFname()+","+getSnumber()+","+getBday()+","+getPnumber()+","+getAddress();
        return str;
    }
    public String fileStringGrade(){
        while(!gradelist.isEmpty()){
        StudentGradeData fetchData = gradelist.fetch(getId());
        String str = fetchData.getClassc()+","+fetchData.getGrade();
        }
        return str;
    }
}