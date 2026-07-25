import java.util.*; 
 
class Student { 
    int rollNo; 
    String name; 
    double percentage; 
    Student(int rollNo, String name, double percentage) { 
        this.rollNo = rollNo; 
        this.name = name; 
        this.percentage = percentage; 
    } 
 
    // Display student details 
    public String toString() { 
        return String.format("%-8d %-10s %.1f", 
                rollNo, name, percentage); 
    } 
} 
public class StudentRecord { 
    public static void main(String[] args) { 
        ArrayList<Student> studentList = new ArrayList<>(); 
        HashMap<Integer, Student> studentMap = new HashMap<>(); 
 
        Student s1 = new Student(101, "Rahul", 88.5); 
        Student s2 = new Student(102, "Sneha", 91.2); 
        Student s3 = new Student(103, "Kiran", 84.8); 
 
        studentList.add(s1); 
        studentList.add(s2); 
        studentList.add(s3); 
 
        studentMap.put(s1.rollNo, s1); 
        studentMap.put(s2.rollNo, s2); 
        studentMap.put(s3.rollNo, s3); 
 
        System.out.println("Student Records (ArrayList)"); 
 
        for (Student s : studentList) { 
            System.out.println(s); 
        } 
        Student updateStudent = studentMap.get(103); 
 
        if (updateStudent != null) { 
            updateStudent.percentage = 90.0; 
            System.out.println("Record Updated Successfully."); 
        } 
 
          int searchRoll = 102; 
        Student found = studentMap.get(searchRoll); 
        if (found != null) { 
            System.out.println("Record Found"); 
            System.out.println("Roll No: " + found.rollNo); 
            System.out.println("Name: " + found.name); 
            System.out.println("Percentage: " + found.percentage); 
        } else { 
            System.out.println("Record Not Found"); 
        } 
        Student removed = studentList.remove(0); 
        studentMap.remove(removed.rollNo); 
        System.out.println("Student Records (HashMap)"); 
 
        for (Map.Entry<Integer, Student> entry 
                : studentMap.entrySet()) { 
 
            Student s = entry.getValue(); 
            System.out.println(entry.getKey() 
                    + " -> " + s.name 
                    + " (" + s.percentage + "%)"); 
        } 
    } 
}
