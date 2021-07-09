package LibraryManagementSystem;

public class Student extends Patron {

    private String studentId;
    private String guardianName;
    private String guardianContactNo;

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public void setGuardianContactNo(String guardianContactNo) {
        this.guardianContactNo = guardianContactNo;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public String getGuardianContactNo() {
        return guardianContactNo;
    }

    @Override
    void showInfo() {
        System.out.println("Student Name : " + getName());
        System.out.println("Student Id : " + getStudentId());
        System.out.println("Guardian Name : " + getGuardianName());
        System.out.println("Guardian Contact : " + getGuardianContactNo());
        System.out.println("Address : "+getAddress());
    }

}
