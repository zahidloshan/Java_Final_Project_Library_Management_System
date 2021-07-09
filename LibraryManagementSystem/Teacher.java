package LibraryManagementSystem;

public class Teacher extends Patron {

    private String teacherId;

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    @Override
    void showInfo() {
        System.out.println("Teacher Name : " + getName());
        System.out.println("Teacher Id : " + getTeacherId());
        System.out.println("Department : " + getDepartmentName());
        System.out.println("Email : " + getEmail());
        System.out.println("Salary : " + getAmount());
    }

}
