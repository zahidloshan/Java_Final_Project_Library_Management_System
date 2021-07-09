package LibraryManagementSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Book implements BookOperations, IBasicOperations {

    private int id;
    private String title;
    private String subtitle;
    private Author author;
    private Publisher publisher;
    private double price;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubTitle(String subTitle) {
        this.subtitle = subTitle;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void insertBook(Book b) {
        File file = new File("C:\\Users\\Asus\\Desktop\\File\\book.txt");

        FileWriter fileWriter = null;
        String aName, aEmail, bpublisherName, bpublisherContact;
        int aId, bpublisherId;
        Scanner ina = new Scanner(System.in);
        Scanner ina1 = new Scanner(System.in);
        author = new Author();

        System.out.println("Author Name  : ");
        author.setName(aName = ina.nextLine());
        System.out.println("Author ID  : ");
        author.setId(aId = ina1.nextInt());
        System.out.println("Author Email  : ");
        author.setEmail(aEmail = ina.nextLine());

        publisher = new Publisher();

        System.out.println("Publisher Name  : ");
        publisher.setName(bpublisherName = ina.nextLine());
        System.out.println("Publisher ID  : ");
        publisher.setId(bpublisherId = ina1.nextInt());
        System.out.println("Publisher contact  : ");
        publisher.setContactNo(bpublisherContact = ina.nextLine());

        try {
            file.createNewFile();
            fileWriter = new FileWriter("C:\\Users\\Asus\\Desktop\\File\\book.txt", true);

            fileWriter.write(Integer.toString(b.id));
            fileWriter.write("     ");
            fileWriter.write(b.title);
            fileWriter.write("     ");
            fileWriter.write(b.subtitle);
            fileWriter.write("     ");
            fileWriter.write(String.valueOf(b.price));
            fileWriter.write("     ");
            fileWriter.write(Integer.toString(author.getId()));
            fileWriter.write("     ");
            fileWriter.write(author.getName());
            fileWriter.write("     ");
            fileWriter.write(author.getEmail());
            fileWriter.write("     ");
            fileWriter.write(Integer.toString(publisher.getId()));
            fileWriter.write("     ");
            fileWriter.write(publisher.getName());
            fileWriter.write("     ");
            fileWriter.write(publisher.getContactNo());
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
    public Book getBook(int bookId) {
        Book b1 = new Book();
        
        FileReader fileReader=null;
        BufferedReader bufferedReader=null;
        
        try{
        fileReader = new FileReader("C:\\Users\\Asus\\Desktop\\File\\book.txt");
        bufferedReader=new BufferedReader(fileReader);
        
            
        String line = "";
            String searchKey =Integer.toString(bookId);
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
        
        return b1;

    }

    @Override
    public void showAllBooks() {
        try {
            BufferedReader file = new BufferedReader(new FileReader("C:\\Users\\Asus\\Desktop\\File\\book.txt"));
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
    public void borrow(Patron p, Book b) {
        File file = new File("C:\\Users\\Asus\\Desktop\\File\\borrowbook.txt");

        FileWriter fileWriter = null;

        try {
            file.createNewFile();
            fileWriter = new FileWriter("C:\\Users\\Asus\\Desktop\\File\\borrowbook.txt", true);

            String userName;
            Scanner user = new Scanner(System.in);
            System.out.print("Enter Name : ");
            p.setName(userName = user.nextLine());

            fileWriter.write(Integer.toString(p.getId()));
            fileWriter.write("     ");
            fileWriter.write(p.getName());
            fileWriter.write("     ");
            fileWriter.write(Integer.toString(b.id));
            fileWriter.write("     ");
            fileWriter.write(b.title);

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
    public void returnBook(Patron p, Book b) {

        String bookId, ownId;
        Scanner binput = new Scanner(System.in);

        System.out.print("Enter Your Id : ");
        ownId = binput.nextLine();
        System.out.print("Enter Book Id : ");
        bookId = binput.nextLine();

        try {
            BufferedReader file = new BufferedReader(new FileReader("C:\\Users\\Asus\\Desktop\\File\\borrowbook.txt"));
            String line;
            String input = "";
            while ((line = file.readLine()) != null) {
                //System.out.println(line);
                if (line.contains(ownId) && line.contains(bookId)) {
                    line = "";
                    System.out.println("Line deleted.");
                }
                input += line + '\n';
            }
            FileOutputStream File = new FileOutputStream("C:\\Users\\Asus\\Desktop\\File\\borrowbook.txt");
            File.write(input.getBytes());
            file.close();
            File.close();
        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }

    }

    @Override
    public void fine(Patron p, double amount) {

        File file = new File("C:\\Users\\Asus\\Desktop\\File\\fine.txt");

        FileWriter fileWriter = null;

        try {
            file.createNewFile();
            fileWriter = new FileWriter("C:\\Users\\Asus\\Desktop\\File\\fine.txt", true);

            fileWriter.write(Integer.toString(p.getId()));
            fileWriter.write("     ");
            fileWriter.write(p.getName());
            fileWriter.write("     ");
            fileWriter.write(String.valueOf(amount));

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

}
