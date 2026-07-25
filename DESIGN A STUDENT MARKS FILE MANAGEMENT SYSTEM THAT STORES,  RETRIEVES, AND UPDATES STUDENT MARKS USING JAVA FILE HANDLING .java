import java.io.*; 
import java.util.*; 
 
class Student { 
    int roll, marks; 
    String name; 
 
    Student(int roll, String name, int marks) { 
        this.roll = roll; 
        this.name = name; 
        this.marks = marks; 
    } 
 
    public String toString() { 
        return roll + "," + name + "," + marks; 
    } 
} 
 
public class StudentRecord { 
    public static void main(String[] args) throws Exception { 
        Scanner sc = new Scanner(System.in); 
        Student[] s = new Student[3]; 
 
        System.out.println("Enter Details of 3 Students"); 
 
        for (int i = 0; i < 3; i++) { 
            System.out.println("\nStudent " + (i + 1)); 
 
            System.out.print("Roll No : "); 
            int roll = sc.nextInt(); 
 
            System.out.print("Name : "); 
            String name = sc.next(); 
 
            System.out.print("Marks : "); 
            int marks = sc.nextInt(); 
 
            s[i] = new Student(roll, name, marks); 
        } 
 
        FileWriter fw = new FileWriter("students.txt"); 
 
        for (Student x : s) 
            fw.write(x + "\n"); 
 
        fw.close(); 
 
        System.out.println("\nStudent records saved successfully."); 
 
        System.out.println("----- Student Records"); 
 
        for (Student x : s) 
            System.out.println(x); 
 
        System.out.print("\nEnter Roll Number to Search : "); 
 
 
        int search = sc.nextInt(); 
 
        for (Student x : s) { 
            if (x.roll == search) { 
                System.out.println("\nStudent Found"); 
 
                System.out.println("\nRoll No : " + x.roll); 
 
                System.out.println("Name : " + x.name); 
 
                System.out.println("Marks : " + x.marks); 
            } 
        } 
    } 
}
