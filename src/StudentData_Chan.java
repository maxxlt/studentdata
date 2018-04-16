import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentData_Chan {
    public String id, fname, lname, snumber, bday, pnumber, address;
    public SinglyLinkedList_Chan gradelist = new SinglyLinkedList_Chan();
    public StudentData_Chan(String id,String lname,String fname,String snumber,String bday,String pnumber,String address, SinglyLinkedList_Chan gradelist){
        this.id = id;
        this.lname = lname;
        this.fname = fname;
        this.snumber = snumber;
        this.bday = bday;
        this.pnumber = pnumber;
        this.address = address;
        this.gradelist = gradelist;
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
    public void setId(String id) {
        this.id = id;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }
    public void setBday(String bday) {
        this.bday = bday;
    }
    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int compareTo(String targetKey){
        return (id.compareTo(targetKey));
    }
    public StudentData_Chan deepCopy(){
        StudentData_Chan clone = new StudentData_Chan(id, lname, fname, snumber, bday, pnumber, address, gradelist);
        return clone;
    }
    public String toString() {
        String str = String.format("%-12s %40s", "Student:", getFname() + " "+getLname()+ "\n");
        str += String.format("%-12s %40s", "Student ID:", getId() + "\n");
        str += String.format("%-12s %40s", "SS Number:", getSnumber() + "\n");
        str += String.format("%-12s %40s", "Birthday:", getBday() + "\n");
        str += String.format("%-12s %40s", "Phone:", getPnumber() + "\n");
        str += String.format("%-12s %40s", "Address:", getAddress() + "\n");
        return str;
    }
    public String transctriptPrint(){
        SimpleDateFormat dateFormat = new SimpleDateFormat( "MM/dd/yyyy" );
        Date dateObj = new Date();
        String str = "---------------------------------------- \n";
        str += String.format("%-15s %25s", "Student:", getFname() + " "+getLname()+ "\n");
        str += String.format("%-15s %25s", "Student ID:", getId() + "\n");
        str += String.format("%-15s %25s", "Date:", dateFormat.format(dateObj) + "\n");
        str +=  "---------------------------------------- \n";
        return str;
    }
    public String fileStringMain(){
        String str = getId()+","+getLname()+","+getFname()+","+getSnumber()+","+getBday()+","+getPnumber()+","+getAddress();
        return str;
    }
    public String fileStringGrade(){
        String str ="";
        while(!gradelist.isEmpty()){
        StudentGradeData fetchData = gradelist.fetch(getId());
        str += fetchData.getClassc()+","+fetchData.getGrade();
        }
        return str;
    }
}