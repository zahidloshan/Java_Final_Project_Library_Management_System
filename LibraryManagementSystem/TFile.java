package LibraryManagementSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TFile implements TeacherOperations {

    @Override
    public void insertTeacher(Teacher t) {
        File file = new File("C:\\Users\\Asus\\Desktop\\File\\teacher.txt");

        FileWriter fileWriter = null;

        try {
            file.createNewFile();
            fileWriter = new FileWriter("C:\\Users\\Asus\\Desktop\\File\\teacher.txt", true);

            fileWriter.write(t.getName());
            fileWriter.write("     ");
            fileWriter.write(t.getTeacherId());
            fileWriter.write("     ");
            fileWriter.write(t.getDepartmentName());
            fileWriter.write("     ");
            fileWriter.write(t.getEmail());
            fileWriter.write("     ");
            fileWriter.write(t.getContactNo());
            fileWriter.write("     ");
            fileWriter.write(String.valueOf(t.getAmount()));
            fileWriter.write("     ");
            fileWriter.write(t.getAddress());
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
    public Teacher getTeacher(int teacherId) {
        Teacher t = new Teacher();
         FileReader fileReader=null;
        BufferedReader bufferedReader=null;
        
        try{
        fileReader = new FileReader("C:\\Users\\Asus\\Desktop\\File\\teacher.txt");
        bufferedReader=new BufferedReader(fileReader);
        
            
        String line = "";
            String searchKey =Integer.toString(teacherId);
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
        return t;

    }

    @Override
    public void showAllTeachers() {
       try {
            BufferedReader file = new BufferedReader(new FileReader("C:\\Users\\Asus\\Desktop\\File\\teacher.txt"));
            String line;
            while ((line = file.readLine()) != null) {
                System.out.println(line);
                
            }
           
            
            file.close();
        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }

    }

}
