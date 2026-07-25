import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
 
public class StudentRegistration extends JFrame implements ActionListener { 
 
    JLabel nameLabel, rollLabel, genderLabel, courseLabel, hobbyLabel; 
    JTextField nameField, rollField; 
    JRadioButton maleButton, femaleButton, otherButton; 
    ButtonGroup genderGroup; 
    JComboBox<String> courseBox; 
    JCheckBox javaBox, pythonBox, cppBox; 
    JButton submitButton, clearButton; 
    JTextArea outputArea; 
 
    StudentRegistration() { 
 
        setTitle("Student Registration Form"); 
        setSize(500, 600); 
        setLayout(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 
        nameLabel = new JLabel("Name:"); 
        nameLabel.setBounds(50, 30, 100, 30); 
        add(nameLabel); 
 
        nameField = new JTextField(); 
        nameField.setBounds(160, 30, 250, 30); 
        add(nameField); 
 
        rollLabel = new JLabel("Roll Number:"); 
        rollLabel.setBounds(50, 80, 100, 30); 
        add(rollLabel); 
 
        rollField = new JTextField(); 
        rollField.setBounds(160, 80, 250, 30); 
        add(rollField); 
 
        genderLabel = new JLabel("Gender:"); 
        genderLabel.setBounds(50, 130, 100, 30); 
        add(genderLabel); 
 
        maleButton = new JRadioButton("Male"); 
        maleButton.setBounds(160, 130, 70, 30); 
        add(maleButton); 
 
        femaleButton = new JRadioButton("Female"); 
        femaleButton.setBounds(230, 130, 80, 30); 
        add(femaleButton); 
 
        otherButton = new JRadioButton("Other"); 
        otherButton.setBounds(310, 130, 70, 30); 
        add(otherButton); 
 
        genderGroup = new ButtonGroup(); 
        genderGroup.add(maleButton); 
        genderGroup.add(femaleButton); 
        genderGroup.add(otherButton); 
 
        courseLabel = new JLabel("Course:"); 
        courseLabel.setBounds(50, 180, 100, 30); 
        add(courseLabel); 
 
        String[] courses = {"B.E CSE","B.E ECE","B.Tech IT","B.E Mechanical"}; 
        courseBox = new JComboBox<>(courses); 
        courseBox.setBounds(160,180,250,30); 
        add(courseBox); 
 
        hobbyLabel = new JLabel("Skills:"); 
        hobbyLabel.setBounds(50,230,100,30); 
        add(hobbyLabel); 
 
        javaBox=new JCheckBox("Java"); 
        javaBox.setBounds(160,230,70,30); 
        add(javaBox); 
 
        pythonBox=new JCheckBox("Python"); 
        pythonBox.setBounds(230,230,80,30); 
        add(pythonBox); 
 
        cppBox=new JCheckBox("C++"); 
        cppBox.setBounds(310,230,70,30); 
        add(cppBox); 
 
        submitButton=new JButton("Submit"); 
        submitButton.setBounds(120,280,100,35); 
        submitButton.addActionListener(this); 
        add(submitButton); 
 
        clearButton=new JButton("Clear"); 
        clearButton.setBounds(250,280,100,35); 
        clearButton.addActionListener(this); 
        add(clearButton); 
 
        outputArea=new JTextArea(); 
        outputArea.setBounds(50,340,360,170); 
        outputArea.setEditable(false); 
        add(outputArea); 
 
        setVisible(true); 
    } 
 
    public void actionPerformed(ActionEvent e) { 
        if(e.getSource()==submitButton){ 
            String name=nameField.getText(); 
            String roll=rollField.getText(); 
 
            if(name.isEmpty()||roll.isEmpty()){ 
                JOptionPane.showMessageDialog(this,"Please fill in all mandatory fields!"); 
                return; 
            } 
 
            String gender=""; 
            if(maleButton.isSelected()) gender="Male"; 
            else if(femaleButton.isSelected()) gender="Female"; 
            else if(otherButton.isSelected()) gender="Other"; 
 
            String course=(String)courseBox.getSelectedItem(); 
 
            String skills=""; 
            if(javaBox.isSelected()) skills+="Java "; 
            if(pythonBox.isSelected()) skills+="Python "; 
            if(cppBox.isSelected()) skills+="C++ "; 
 
            outputArea.setText( 
                "STUDENT REGISTRATION DETAILS\n\n"+ 
                "Name: "+name+"\n"+ 
                "Roll Number: "+roll+"\n"+ 
                "Gender: "+gender+"\n"+ 
                "Course: "+course+"\n"+ 
                "Skills: "+skills); 
        } else { 
            nameField.setText(""); 
            rollField.setText(""); 
            genderGroup.clearSelection(); 
            courseBox.setSelectedIndex(0); 
            javaBox.setSelected(false); 
            pythonBox.setSelected(false); 
            cppBox.setSelected(false); 
            outputArea.setText(""); 
        } 
    } 
 
    public static void main(String[] args){ 
        new StudentRegistration(); 
    } 
} 
 
 
 
 
