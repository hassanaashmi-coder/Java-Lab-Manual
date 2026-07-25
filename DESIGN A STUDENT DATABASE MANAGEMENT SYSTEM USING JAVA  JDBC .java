import java.sql.*; 
 
public class StudentDB { 
 
    static final String URL = "jdbc:mysql://localhost:3306/college"; 
    static final String USER = "root"; 
    static final String PASSWORD = "root"; 
 
    public static void main(String args[]) { 
 
        Connection con = null; 
        PreparedStatement insertStmt = null; 
        PreparedStatement updateStmt = null; 
        PreparedStatement searchStmt = null; 
        PreparedStatement displayStmt = null; 
        ResultSet rs = null; 
 
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            con = DriverManager.getConnection(URL, USER, PASSWORD); 
 
            System.out.println("Connected Successfully.\n"); 
 
            String insertQuery = "INSERT INTO student VALUES(?,?,?,?)"; 
            insertStmt = con.prepareStatement(insertQuery); 
 
            insertStmt.setInt(1,101); 
            insertStmt.setString(2,"Rahul"); 
            insertStmt.setString(3,"CSE"); 
            insertStmt.setInt(4,85); 
            insertStmt.executeUpdate(); 
 
            insertStmt.setInt(1,102); 
            insertStmt.setString(2,"Priya"); 
            insertStmt.setString(3,"ECE"); 
            insertStmt.setInt(4,90); 
            insertStmt.executeUpdate(); 
 
            System.out.println("Records Inserted Successfully.\n"); 
 
            String updateQuery = "UPDATE student SET marks=? WHERE rollno=?"; 
            updateStmt = con.prepareStatement(updateQuery); 
            updateStmt.setInt(1,95); 
            updateStmt.setInt(2,101); 
 
            if(updateStmt.executeUpdate()>0) 
                System.out.println("Record Updated Successfully.\n"); 
 
            String searchQuery = "SELECT * FROM student WHERE rollno=?"; 
            searchStmt = con.prepareStatement(searchQuery); 
            searchStmt.setInt(1,101); 
            rs = searchStmt.executeQuery(); 
 
            System.out.println("Student Details"); 
            while(rs.next()){ 
                System.out.println("Roll No    : " + rs.getInt("rollno")); 
                System.out.println("Name       : " + rs.getString("name")); 
                System.out.println("Department : " + rs.getString("department")); 
                System.out.println("Marks      : " + rs.getInt("marks")); 
            } 
 
            displayStmt = con.prepareStatement("SELECT * FROM student"); 
            rs = displayStmt.executeQuery(); 
 
            System.out.println("\nAll Student Records"); 
            while(rs.next()){ 
                System.out.println("--------------------------------"); 
                System.out.println("Roll No    : " + rs.getInt("rollno")); 
                System.out.println("Name       : " + rs.getString("name")); 
                System.out.println("Department : " + rs.getString("department")); 
                System.out.println("Marks      : " + rs.getInt("marks")); 
            } 
 
        } catch(Exception e){ 
            System.out.println(e); 
        } finally { 
            try{ 
                if(rs!=null) rs.close(); 
                if(insertStmt!=null) insertStmt.close(); 
                if(updateStmt!=null) updateStmt.close(); 
                if(searchStmt!=null) searchStmt.close(); 
                if(displayStmt!=null) displayStmt.close(); 
                if(con!=null) con.close(); 
                System.out.println("\nConnection Closed."); 
            }catch(Exception e){ 
                System.out.println(e); 
            } 
        } 
    } 
} 
