import java.util.*; 
 
class PiCalculator  
{ 
 
    private double pi; 
 
    PiCalculator(int n) 
 { 
 
        for (int i = 0; i < n; i++) 
 
            pi += 4.0 * Math.pow(-1, i) / (2 * i + 1); 
    } 
 
    public void result()  
{ 
        System.out.println("Public Method - Displaying Result:"); 
 
        System.out.println("Approximated value of Pi: " + pi); 
    } 
 
    protected void info(int n)  
{ 
        System.out.println("Protected Method - Displaying Precision Info:"); 
 
        System.out.println("Precision used: " + n + " terms"); 
 
        System.out.println("Series used: Leibniz Series (4/1 - 4/3 + 4/5 - 4/7 + 4/9 ...)"); 
 
    } 
 
    private void raw()  
{ 
        System.out.println("Private Data - Accessed only within class:"); 
 
        System.out.println("Raw computed value (private): " + pi); 
    } 
 
    public void show() 
 { 
        raw(); 
    } 
} 
 
public class Main { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
 
        System.out.println("=== Pi Calculator using Access Specifiers ==="); 
 
        System.out.print("Enter the number of terms for Pi approximation: "); 
 
        int n = sc.nextInt(); 
 
        System.out.println("Calculating Pi using Leibniz Series..."); 
 
 
        PiCalculator p = new PiCalculator(n); 
        p.result(); 
        p.info(n); 
        p.show(); 
    } 
} 
 
LEETCODE ID: 1232 
QUESTION: CHECK IF IT IS A STRAIGHT LINE
