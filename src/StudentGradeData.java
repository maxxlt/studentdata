class StudentGradeData {
    private String classc, grade;
    public StudentGradeData(String classc, String grade){
        this.classc = classc;
        this.grade = grade;
    }
    public void setGrade(String newGrade){
        grade = newGrade;
    }
    public void setClass(String newClass){
        classc = newClass;
    }
    public String getGrade(){
        return grade;
    }
    public String getClassc(){
        return classc;
    }
    public StudentGradeData deepCopy(){
        StudentGradeData clone = new StudentGradeData(classc, grade);
        return clone;
    }
    public String toString(){
        String str = getClassc() +" "+ getGrade() +"\n";
        return str;
    }
}