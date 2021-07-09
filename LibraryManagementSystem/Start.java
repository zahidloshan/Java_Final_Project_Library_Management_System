package LibraryManagementSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        char ch;
        do {

            System.out.println("1. Student Management");
            System.out.println("2. Teacher Management");
            System.out.println("3. Book Management");
            System.out.println("4. Basic Operations");
            System.out.println("5. Exit");

            System.out.println("Choice your option");
            ch = in.next().charAt(0);

            switch (ch) {
                case '1'://STUDENT MANAGMENT
                    studentManagement();
                    break;

                //TEACHER MANAGEMENT
                case '2':
                    teacherManagement();
                    break;
                case '3'://Book Management
                    bookManagement();
                    break;
                case '4'://Book Borrow/Return/Lost Management
                    bookBRLManagement();
                    break;
                case '5':
                    System.out.println("Exit");
                    break;
            }

        } while (Character.getNumericValue(ch) != 5);

    }

    static void studentManagement() {

        System.out.println("Options for Student Management:");
        System.out.print("1. Insert New Student ");
        System.out.print("     2. Search by StudentId");
        System.out.print("     3. All Student");
        System.out.println("");
        Scanner in2 = new Scanner(System.in);
        char ch1;
        System.out.println("Choice your option");
        ch1 = in2.next().charAt(0);

        switch (ch1) {
            case '1':
                StudentOperations ob = new SFile();
                Student s[] = new Student[20];
                System.out.println("How many Student : ");
                Scanner input = new Scanner(System.in);
                int snumber = input.nextInt();

                for (int i = 0; i < snumber; i++) {
                    s[i] = new Student();

                    String name1, id1, sdepartmentName, sguardianName, sguardianContactNo, address;

                    Scanner sc = new Scanner(System.in);
                    System.out.println("Name  : ");
                    s[i].setName(name1 = sc.nextLine());
                    System.out.println("Id  : ");
                    s[i].setStudentId(id1 = sc.nextLine());
                    System.out.println("Department  : ");
                    s[i].setdepartmentName(sdepartmentName = sc.nextLine());
                    System.out.println("Guardian Name  : ");
                    s[i].setGuardianName(sguardianName = sc.nextLine());
                    System.out.println("Guardian ContactNo  : ");
                    s[i].setGuardianContactNo(sguardianContactNo = sc.nextLine());
                    System.out.println("Address  : ");
                    s[i].setAddress(address = sc.next());
                    ob.insertStudent(s[i]);
                }

                System.out.println("Student Insert Complete");
                break;
            case '2':
                int studentId;
                Scanner input1 = new Scanner(System.in);

                System.out.print("Enter Id : ");
                studentId = input1.nextInt();
                StudentOperations ob2 = new SFile();
                ob2.getStudent(studentId);

                break;
            case '3':
                StudentOperations ob1 = new SFile();
                ob1.showAllStudents();
                break;
        }

    }

    static void teacherManagement() {

        System.out.println("Options for Teacher Management:");
        System.out.print("1. Insert New Teacher ");
        System.out.print("     2. Search by TeacherId");
        System.out.print("     3. All Teacher");
        System.out.println("");
        Scanner inT = new Scanner(System.in);
        char cht;
        System.out.println("Choice your option");
        cht = inT.next().charAt(0);

        switch (cht) {
            case '1':
                TeacherOperations tob = new TFile();
                Teacher t[] = new Teacher[20];
                System.out.println("How many Teacher : ");
                Scanner input = new Scanner(System.in);
                int tnumber = input.nextInt();

                for (int i = 0; i < tnumber; i++) {
                    t[i] = new Teacher();

                    String tname, tid, tdepartmentName, temail, tContactNo, taddress;
                    double tamount;

                    Scanner sc = new Scanner(System.in);
                    System.out.println("Name  : ");
                    t[i].setName(tname = sc.nextLine());
                    System.out.println("Id  : ");
                    t[i].setTeacherId(tid = sc.nextLine());
                    System.out.println("Department  : ");
                    t[i].setdepartmentName(tdepartmentName = sc.nextLine());
                    System.out.println("Email  : ");
                    t[i].setEmail(temail = sc.nextLine());
                    System.out.println("ContactNo  : ");
                    t[i].setContactNo(tContactNo = sc.nextLine());
                    System.out.println("Salary : ");
                    t[i].setAmount(tamount = sc.nextDouble());
                    System.out.println("Address  : ");
                    t[i].setAddress(taddress = sc.next());
                    tob.insertTeacher(t[i]);
                }

                System.out.println("Teacher Insert Complete");
                break;
            case '2':
                int teacherId;
                Scanner tinput = new Scanner(System.in);

                System.out.print("Enter Id : ");
                teacherId = tinput.nextInt();
                TeacherOperations tob1 = new TFile();
                tob1.getTeacher(teacherId);

                break;
            case '3':
                TeacherOperations tob2 = new TFile();
                tob2.showAllTeachers();
                break;
        }
    }

    static void bookManagement() {
        System.out.println("Options for Book Management:");

        System.out.print("1. Insert New Book ");
        System.out.print("     2. Search by BookId");
        System.out.print("     3. Show All Books");
        System.out.println("");
        Scanner inB = new Scanner(System.in);
        char chb;
        System.out.println("Choice your option");
        chb = inB.next().charAt(0);

        switch (chb) {
            case '1':
                BookOperations bob = new Book();
                Book b[] = new Book[20];
                System.out.println("How many Book : ");
                Scanner input = new Scanner(System.in);
                int bnumber = input.nextInt();

                for (int i = 0; i < bnumber; i++) {
                    b[i] = new Book();

                    String btitle, bsubtitle;
                    int bid;
                    double bprice;

                    Scanner scb = new Scanner(System.in);
                    Scanner scb1 = new Scanner(System.in);
                    System.out.println("Book Id  : ");
                    b[i].setId(bid = scb.nextInt());
                    System.out.println("Book Title  : ");
                    b[i].setTitle(btitle = scb1.nextLine());
                    System.out.println("Book SubTitle  : ");
                    b[i].setSubTitle(bsubtitle = scb1.nextLine());
                    System.out.println("Price : ");
                    b[i].setPrice(bprice = scb.nextDouble());

                    bob.insertBook(b[i]);
                }

                System.out.println("Book Insert Complete");
                break;
            case '2':
                int bookId;
                Scanner binput = new Scanner(System.in);

                System.out.print("Enter Id : ");
                bookId = binput.nextInt();
                BookOperations bob1 = new Book();
                bob1.getBook(bookId);

                break;
            case '3':
                BookOperations bob2 = new Book();
                bob2.showAllBooks();
                break;
        }

    }

    static void bookBRLManagement() {
        System.out.println("Options for Book Borrow/Return/Lost Management:");
        System.out.print("1. Borrow book ");
        System.out.print("     2. Return Book");
        System.out.print("     3. Add Fine");
        System.out.println("");
        Scanner inBR = new Scanner(System.in);
        char chbr;
        System.out.println("Choice your option");
        chbr = inBR.next().charAt(0);

        switch (chbr) {
            case '1':
                IBasicOperations ibob = new Book();
                Patron p;
                Book b = new Book();
                System.out.println("Choice your option Teacher/Student");
                System.out.print("1. Teacher ");
                System.out.print("      2. Student");
                System.out.println("");
                Scanner usert = new Scanner(System.in);
                int userType;
                userType = usert.nextInt();

                if (userType == 1) {
                    Teacher teacher = new Teacher();
                    p = teacher;
                    String teacherName;
                    int teacherId;
                    System.out.print("Enter Teacher Id : ");
                    Scanner inputid = new Scanner(System.in);
                    p.setId(teacherId = inputid.nextInt());

                    try {
                        FileReader fr = new FileReader("C:\\Users\\Asus\\Desktop\\File\\teacher.txt");
                        BufferedReader br = new BufferedReader(fr);
                        String s;
                        
                        String keyword = Integer.toString(teacherId);
                       
                        while ((s = br.readLine()) != null) {
                            if (s.contains(keyword)) {
                                System.out.println("Your Are Able to Borrow Book");
                                String btitle;
                                int bid;

                                Scanner scb = new Scanner(System.in);
                                Scanner scb1 = new Scanner(System.in);
                                System.out.println("Enter Book Id, Which you want to Borrow?: ");
                                b.setId(bid = scb.nextInt());
                                System.out.println("Book Title  : ");
                                b.setTitle(btitle = scb1.nextLine());

                                ibob.borrow(p, b);
                            }

                        }

                    } catch (Exception e) {
                        System.out.println(e);
                    }

                } else if (userType == 2) {
                    Student student = new Student();
                    p = student;
                    String studentName;
                    int studentId;
                    System.out.print("Enter Student Id : ");
                    Scanner inputid = new Scanner(System.in);
                    p.setId(studentId = inputid.nextInt());

                    try {
                        
                        FileReader fr = new FileReader("C:\\Users\\Asus\\Desktop\\File\\student.txt");
                        BufferedReader br = new BufferedReader(fr);
                        String s;

                        String keyword = Integer.toString(studentId);
                        String line;

                        while ((s = br.readLine()) != null) {
                            if (s.contains(keyword)) {
                                System.out.println("Your Are Able to Borrow Book");
                                String btitle;
                                int bid;

                                Scanner scb = new Scanner(System.in);
                                Scanner scb1 = new Scanner(System.in);
                                System.out.println("Enter Book Id, Which you want to Borrow?: ");
                                b.setId(bid = scb.nextInt());
                                System.out.println("Book Title  : ");
                                b.setTitle(btitle = scb1.nextLine());

                                ibob.borrow(p, b);
                            }

                        }

                    } catch (Exception e) {
                        System.out.println(e);
                    }

                }

                System.out.println("Borrow  Complete");
                break;
            case '2':

                IBasicOperations ibob1 = new Book();
                Patron p1;
                Teacher t = new Teacher();
                p1 = t;
                Book b1 = new Book();
                ibob1.returnBook(p1, b1);

                break;
            case '3':
                IBasicOperations ibob2 = new Book();
                Patron p3;

                System.out.println("Choice your option Teacher/Student");
                System.out.print("1. Teacher ");
                System.out.print("      2. Student");
                System.out.println("");
                Scanner usertype = new Scanner(System.in);
                int userType1;
                userType1 = usertype.nextInt();

                if (userType1 == 1) {
                    Teacher t3 = new Teacher();
                    p3 = t3;
                    double amount;
                    String tname3;
                    int tId3;
                    Scanner inputid = new Scanner(System.in);
                    System.out.println("Enter Id : ");
                    p3.setId(tId3 = inputid.nextInt());

                    Scanner free = new Scanner(System.in);
                    System.out.println("Enter Lost Book Fine : ");
                    amount = free.nextDouble();

                    Scanner inName = new Scanner(System.in);
                    System.out.println("Enter Name: ");
                    p3.setName(tname3 = inName.nextLine());

                    ibob2.fine(p3, amount);

                } else if (userType1 == 2) {
                    Student s3 = new Student();
                    p3 = s3;
                    double amount;
                    String sname3;
                    int sId3;
                    Scanner inputid = new Scanner(System.in);
                    System.out.println("Enter Id : ");
                    p3.setId(sId3 = inputid.nextInt());

                    Scanner free = new Scanner(System.in);
                    System.out.println("Enter Lost Book Fine : ");
                    amount = free.nextDouble();

                    Scanner inName = new Scanner(System.in);
                    System.out.println("Enter Name: ");
                    p3.setName(sname3 = inName.nextLine());

                    ibob2.fine(p3, amount);
                }

                break;

        }
    }

}
