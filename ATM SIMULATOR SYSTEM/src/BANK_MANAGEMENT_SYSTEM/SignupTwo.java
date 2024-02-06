package BANK_MANAGEMENT_SYSTEM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class SignupTwo extends JFrame implements ActionListener {


    JTextField aadharTextField;

    JTextField panTextField;
    JButton next;
    JRadioButton eyes;
    JRadioButton eno;
    JRadioButton yes;
    JRadioButton no;

    JComboBox religion;
    JComboBox category;
    JComboBox income;
    JComboBox education;
    JComboBox occupation;
    String formno;
   public SignupTwo(String formno){
       this.formno = formno;

       setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
       additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
       additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion : ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        String[] valReligion = {"Hindu","Muslim","Sikh","Chirstian","Other"};
         religion = new JComboBox(valReligion);
       religion.setBounds(300, 140, 400, 30);
       religion.setBackground(Color.WHITE);
       add(religion);

        JLabel _category = new JLabel("Category : ");
       _category.setFont(new Font("Raleway", Font.BOLD, 20));
       _category.setBounds(100, 190, 200, 30);
        add(_category);

       String[] valcategory  = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valcategory);
       category.setBounds(300, 190, 400, 30);
       category.setBackground(Color.WHITE);
       add(category);

        JLabel _income = new JLabel("Income :");
       _income.setBounds(100, 240, 200, 30);
       _income.setFont(new Font("Raleway", Font.BOLD, 20));
        add(_income);

       String[] incomecategory  = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income = new JComboBox(incomecategory);
       income.setBounds(300, 240, 400, 30);
       income.setBackground(Color.WHITE);
       add(income);

        JLabel gender = new JLabel("Educational");
        gender.setBounds(100, 290, 200, 30);
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        add(gender);

        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("RaleWay", Font.BOLD, 20));
        email.setBounds(100, 330, 200, 30);
        add(email);

       String[] educationVal  = {"Non-Graduate","Graduation","Post-Graduation","Post-Graduation"};
        education = new JComboBox(educationVal);
       education.setBounds(300, 315, 400, 30);
       education.setBackground(Color.WHITE);
       add(education);

       JLabel marital = new JLabel("Occupation :");
        marital.setFont(new Font("RaleWay", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

       String[] occupationalVal  = {"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        occupation = new JComboBox(occupationalVal);
       occupation.setBounds(300, 390, 400, 30);
       occupation.setBackground(Color.WHITE);
       add(occupation);

        JLabel pan = new JLabel("PAN Number :");
       pan.setFont(new Font("RaleWay", Font.BOLD, 20));
       pan.setBounds(100, 440, 200, 30);
        add(pan);

        panTextField = new JTextField();
       panTextField.setBounds(300, 440, 400, 30);
       panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(panTextField);


        JLabel aadhar = new JLabel("Aadhar Number:");
       aadhar.setBounds(100, 490, 200, 30);
       aadhar.setFont(new Font("RaleWay", Font.BOLD, 20));
        add(aadhar);

        aadharTextField = new JTextField();
       aadharTextField.setBounds(300, 490, 400, 30);
       aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(aadharTextField);


        JLabel citizen = new JLabel("Senior Citizen:");
       citizen.setBounds(100, 540, 200, 30);
       citizen.setFont(new Font("RaleWay", Font.BOLD, 20));
        add(citizen);

       yes  = new JRadioButton("Yes");
       yes.setBounds(300, 540, 100, 30);
       yes.setBackground(Color.white);
       add(yes);
       no = new JRadioButton("No");
       no.setBounds(450, 540, 100, 30);
       no.setBackground(Color.white);
       add(no);

       ButtonGroup gendergroup = new ButtonGroup();
       gendergroup.add(yes);
       gendergroup.add(no);

       JLabel pincode = new JLabel("Existing Account :");
        pincode.setBounds(100, 590, 200, 30);
        pincode.setFont(new Font("RaleWay", Font.BOLD, 20));
        add(pincode);

       eyes  = new JRadioButton("Yes");
       eyes.setBounds(300, 590, 100, 30);
       eyes.setBackground(Color.white);
       add(eyes);
       eno = new JRadioButton("No");
       eno.setBounds(450, 590, 100, 30);
       eno.setBackground(Color.white);
       add(eno);

       ButtonGroup existing = new ButtonGroup();
       existing.add(eyes);
       existing.add(eno);




        next = new JButton("Next->");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        add(next);

        next.addActionListener(this);


        getContentPane().setBackground(Color.white);
        setTitle("SIGNUP FORM");
        setLayout(null);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }
    public static void main(String[] args) {

        new SignupTwo("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();

        String existingaccount  = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        }
        else if(eno.isSelected()){
            existingaccount = "No";
        }
        String aadhar = aadharTextField.getText();
        String pan = panTextField.getText();

        String scitizen = null;
        if(yes.isSelected()){
            scitizen = "Yes";
        }
        else if(no.isSelected()){
            scitizen = "No";
        }

        try{

                DatabaseConnection con = new DatabaseConnection();
                String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+scitizen+"', '"+seducation+"', '"+soccupation+"', '"+aadhar+"', '"+pan+"','"+existingaccount+"')";

                con.s.executeUpdate(query);

                setVisible(false);
                new SignUpThree(formno);

        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }
}
