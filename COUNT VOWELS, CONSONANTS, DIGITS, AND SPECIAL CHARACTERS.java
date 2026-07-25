import java.util.*; 
 
public class Main { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
 
        System.out.print("Enter a string: "); 
        String s = sc.nextLine(); 
 
        int vowels = 0, consonants = 0, digits = 0, special = 0; 
 
        for (char c : s.toCharArray()) { 
            if (Character.isLetter(c)) { 
                if ("AEIOUaeiou".indexOf(c) != -1) 
                    vowels++; 
                else 
                    consonants++; 
            } else if (Character.isDigit(c)) 
                digits++; 
            else if (c != ' ') 
                special++; 
        } 
 
        System.out.println("Vowels: " + vowels); 
        System.out.println("Consonants: " + consonants); 
        System.out.println("Digits: " + digits); 
        System.out.println("Special Characters: " + special); 
        System.out.println("Breakdown for \"" + s + "\":"); 
    } 
} 
 
 
 
 
