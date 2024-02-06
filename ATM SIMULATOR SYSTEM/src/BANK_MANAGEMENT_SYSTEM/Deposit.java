package BANK_MANAGEMENT_SYSTEM;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deposit extends JFrame implements ActionListener {


    JButton deposit;

    JButton back;

    JTextField cash;
    String pinnumber;
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3  = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

         cash = new JFormattedTextField();
        cash.setFont(new Font("Raleway",Font.BOLD,22));
        cash.setBounds(170,350,320,25);
        image.add(cash);

         deposit = new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        image.add(deposit);
        deposit.addActionListener(this);

         back = new JButton("Back");
        back.setBounds(355,520,150,30);
        image.add(back);
        back.addActionListener(this);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Deposit("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == deposit){
             String amount = cash.getText();
            Date date = new Date();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
            }
            else{
                try {
                DatabaseConnection conn = new DatabaseConnection();
                String query = "insert into bank values('"+pinnumber+"','"+date+"', 'Deposit', '"+amount+"')";

                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Rs "+amount + " Deposited succesfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

                } catch (Exception ae) {
                    System.out.println(ae);
                    ae.printStackTrace();
                }

            }

        }
        else if(e.getSource() == back){
            setVisible(false);
              new Transactions(pinnumber).setVisible(true);
        }

    }
}
