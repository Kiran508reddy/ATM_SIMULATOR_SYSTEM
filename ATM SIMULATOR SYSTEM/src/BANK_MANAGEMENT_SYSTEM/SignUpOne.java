package BANK_MANAGEMENT_SYSTEM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
public class SignUpOne extends JFrame implements ActionListener {

          long random;
          JTextField nameTextFiled;
          JTextField  fnameTextFiled;
           JTextField emailTextField;
           JTextField stateTextField;
           JTextField pincodeTextField;
           JTextField cityTextField;
           JTextField addressTextField;
           JButton next;
           JRadioButton male;
           JRadioButton female;
           JRadioButton married;
           JRadioButton unmarried;
           JRadioButton other;
           JDateChooser dateChooser;
          SignUpOne(){
              Random ran = new Random();
               random = Math.abs((ran.nextLong() % 9000L)+1000L);
              JLabel formno = new JLabel("APPLICATION FORM NO ." + random);
              formno.setFont(new Font("Raleway",Font.BOLD,38));
              formno.setBounds(140,20,600,40);
              add(formno);

              JLabel personalDetails = new JLabel("Page 1 : Personal Details");
              personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
              personalDetails.setBounds(290,80,400,30);
              add(personalDetails);

              JLabel name = new JLabel("Name : ");
              name.setFont(new Font("Raleway",Font.BOLD,20));
              name.setBounds(100,140,100,30);
              add(name);

               nameTextFiled = new JTextField();
              nameTextFiled.setBounds(300,140,400,30);
              nameTextFiled.setFont(new Font("Raleway",Font.BOLD,14));
              add(nameTextFiled);


              JLabel fname = new JLabel("Father's Name : ");
              fname.setFont(new Font("Raleway",Font.BOLD,20));
              fname.setBounds(100,190,200,30);
              add(fname);

               fnameTextFiled = new JTextField();
              fnameTextFiled.setBounds(300,190,400,30);
              fnameTextFiled.setFont(new Font("Raleway",Font.BOLD,14));
              add(fnameTextFiled);



              JLabel dob = new JLabel("Date of Birth :");
              dob.setBounds(100,240,200,30);
              dob.setFont(new Font("Raleway",Font.BOLD,20));
              add(dob);

               dateChooser = new JDateChooser();
              dateChooser.setBounds(300,240,400,30);
              dateChooser.setForeground(new Color(105,105,105));
              add(dateChooser);

              JLabel gender = new JLabel("Gender:");
              gender.setBounds(100,290,200,30);
              gender.setFont(new Font("Raleway",Font.BOLD,20));
              add(gender);

               male  = new JRadioButton("Male");
               male.setBounds(300,290,60,30);
               male.setBackground(Color.white);
               add(male);
               female = new JRadioButton("Female");
               female.setBounds(450,290,120,30);
              female.setBackground(Color.white);
               add(female);

               ButtonGroup gendergroup = new ButtonGroup();
               gendergroup.add(male);
               gendergroup.add(female);
               //add(gendergroup);


              JLabel email = new JLabel("Email Address:");
              email.setFont(new Font("RaleWay",Font.BOLD,20));
              email.setBounds(100,340,200,30);
              add(email);

               emailTextField = new JTextField();
              emailTextField.setBounds(300,340,400,30);
              emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
              add(emailTextField);

              JLabel marital = new JLabel("Marital Status :");
              marital.setFont(new Font("RaleWay",Font.BOLD,20));
              marital.setBounds(100,390,200,30);
              add(marital);


               married = new JRadioButton("Married");
              married.setBackground(Color.white);
              married.setBounds(300,390,100,30);
              add(married);

               unmarried = new JRadioButton("UnMarried");
              unmarried.setBackground(Color.white);
              unmarried.setBounds(450,390,100,30);
              add(unmarried);

               other = new JRadioButton("Other");
              other.setBackground(Color.white);
              other.setBounds(630,390,100,30);
              add(other);

              ButtonGroup maritalgroup = new ButtonGroup();
              maritalgroup.add(married);
              maritalgroup.add(unmarried);
              maritalgroup.add(other);




              JLabel address = new JLabel("Address :");
              address.setFont(new Font("RaleWay",Font.BOLD,20));
              address.setBounds(100,440,200,30);
              add(address);

               addressTextField = new JTextField();
              addressTextField.setBounds(300,440,400,30);
              addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
              add(addressTextField);


              JLabel city = new JLabel("City:");
              city.setBounds(100,490,200,30);
              city.setFont(new Font("RaleWay",Font.BOLD,20));
              add(city);

               cityTextField = new JTextField();
              cityTextField.setBounds(300,490,400,30);
              cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
              add(cityTextField);


              JLabel state = new JLabel("State:");
              state.setBounds(100,540,200,30);
              state.setFont(new Font("RaleWay",Font.BOLD,20));
              add(state);

               stateTextField = new JTextField();
              stateTextField.setBounds(300,540,400,30);
              stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
              add(stateTextField);

              JLabel pincode = new JLabel("Pincode :");
              pincode.setBounds(100,590,200,30);
              pincode.setFont(new Font("RaleWay",Font.BOLD,20));
              add(pincode);

               pincodeTextField = new JTextField();
              pincodeTextField.setBounds(300,590,400,30);
              pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
              add(pincodeTextField);


               next = new JButton("Next->");
              next.setBackground(Color.BLACK);
              next.setForeground(Color.WHITE);
              next.setFont(new Font("Raleway",Font.BOLD,14));
              next.setBounds(620,660,80,30);
              add(next);

              next.addActionListener(this);


              getContentPane().setBackground(Color.white);
              setTitle("SIGNUP FORM");
              setLayout(null);

              setSize(850,800);
              setLocation(350,10);
              setVisible(true);
          }
    public static void main(String[] args) {

              new SignUpOne();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

              String formno = ""+random;
              String  name = nameTextFiled.getText();
              String fname = fnameTextFiled.getText();
              String dob  = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();

              String gender = null;
              if(male.isSelected()){
                  gender = "Male";
              }
              else if(female.isSelected()){
                  gender = "Female";
              }
              String email = emailTextField.getText();
              String marital  = null;

              if(married.isSelected()){
                  marital = "Married";
              }
              else if(unmarried.isSelected()){
                  marital = "UnMarried";
              }
              else if(other.isSelected()){
                  marital = "Other";
              }

              String address  = addressTextField.getText();
              String city = cityTextField.getText();
              String state = stateTextField.getText();
              String pincode = pincodeTextField.getText();
              try{
                  if(name.equals("")){
                      JOptionPane.showMessageDialog(null,"Name is Required");
                  }
                  else{
                      DatabaseConnection con = new DatabaseConnection();
                      String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pincode+"', '"+state+"')";

                     con.s.executeUpdate(query);
                     setVisible(false);
                     new SignupTwo(formno).setVisible(true);
                  }
              }
              catch (Exception ex){
                  System.out.println(ex);
              }
    }
}
