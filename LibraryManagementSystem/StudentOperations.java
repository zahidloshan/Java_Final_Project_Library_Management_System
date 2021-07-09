package LibraryManagementSystem;

public interface StudentOperations {

    void insertStudent(Student s);

    //void removeStudent(Student s);
    Student getStudent(int studentId);

    void showAllStudents();

}
