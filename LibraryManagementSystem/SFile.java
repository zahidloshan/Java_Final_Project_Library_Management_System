package LibraryManagementSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class SFile implements StudentOperations {

    @Override
    public void insertStudent(Student s) {
        File file = new File("C:\\Users\\Asus\\Desktop\\File\\student.txt");

        FileWriter fileWriter = null;

        try {
            file.createNewFile();
            fileWriter = new FileWriter(file, true);

            fileWriter.write(s.getName());
            fileWriter.write("     ");
            fileWriter.write(s.getStudentId());
            fileWriter.write("     ");
            fileWriter.write(s.getDepartmentName());
            fileWriter.write("     ");
            fileWriter.write(s.getGuardianName());
            fileWriter.write("     ");
            fileWriter.write(s.getGuardianContactNo());
            fileWriter.write("     ");
            fileWriter.write(s.getAddress());
            fileWriter.write("\n");

        } catch (IOException e) {
            System.out.println("IO Exception");

        } finally {

            try {
                fileWriter.close();
            } catch (IOException e1) {

                System.out.println("IOException occurred!! Couldn't close the resource");

            }

        }

    }

    @Override
    public void showAllStudents() {
        

        try {
            BufferedReader file = new BufferedReader(new FileReader("C:\\Users\\Asus\\Desktop\\File\\student.txt"));
            String line;
            while ((line = file.readLine()) != null) {
                System.out.println(line);
                
            }
           
            
            file.close();
        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }

    }

    @Override
    public Student getStudent(int studentId) {
        Student s = new Student();
         FileReader fileReader=null;
        BufferedReader bufferedReader=null;
        
        try{
        fileReader = new FileReader("C:\\Users\\Asus\\Desktop\\File\\student.txt");
        bufferedReader=new BufferedReader(fileReader);
        
            
        String line = "";
            String searchKey =Integer.toString(studentId);
            String words[] = null;
            boolean found = false;
            while((line = bufferedReader.readLine()) != null) {
                
                words = line.split(" ");
                for(String word: words) {
                    if(word.equals(searchKey))
                        System.out.println("Line Is : "+line);
                        found = true;
                }
                if(!found) {
                    System.out.println("In if block of found: " + line);
                    found = false;
                }
            }
            
        }catch(IOException io)
        {
            System.out.println("IO Exception");
        }
       
        finally {

            try {
                fileReader.close();
            } catch (IOException e1) {

                System.out.println("IOException occurred!! Couldn't close the resource");

            }
        }
        return s;
    }
}
