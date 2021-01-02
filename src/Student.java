import java.util.Date;

public class Student {
    private int studentID;
    private String name;
    private Date birthday;
    private String classNumber;

    public Student(int ID, String name) {
        this.studentID = ID;
        this.name = name;
    }

    public Student() {
    }

    //ID
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    //Name

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //Birthday

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

//Class

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    @Override
    public String toString() {
        return "StudentID: " + this.studentID + "; Name: " + this.name + "; Birthday: " + this.birthday;
    }
}
