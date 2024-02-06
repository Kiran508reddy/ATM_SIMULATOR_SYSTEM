package BANK_MANAGEMENT_SYSTEM;

import javax.swing.*;
import javax.xml.crypto.Data;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{
    JButton hundred;
 //   JButton twoHundred;

    JButton fiveHundred;
    JButton thousand;
    JButton twoThousand;
    JButton   fiveThousand;
    JButton tenThousand;
    JButton back;


    private  String pinnumber;

    FastCash(String pinnumber){
        this.pinnumber = pinnumber;

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image  = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Select withdrawal amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        add(text);
        image.add(text);

        hundred  = new JButton("Rs 100");
        hundred.setBounds(170,415,150,30);
        add(hundred);
        image.add(hundred);
        hundred.addActionListener(this);

        fiveHundred  = new JButton("Rs 500");
        fiveHundred.setBounds(355,415,150,30);
        add(fiveHundred);
        image.add(fiveHundred);
        fiveHundred.addActionListener(this);

        thousand  = new JButton("Rs 1000");
        thousand.setBounds(170,450,150,30);
        add(thousand);
        image.add(thousand);
        thousand.addActionListener(this);

        twoThousand  = new JButton("Rs 2000");
        twoThousand.setBounds(355,450,150,30);
        add(twoThousand);
        image.add(twoThousand);
        twoThousand.addActionListener(this);

        fiveThousand  = new JButton("Rs 5000");
        fiveThousand.setBounds(170,485,150,30);
        add(fiveThousand);
        image.add(fiveThousand);
        fiveThousand.addActionListener(this);

        tenThousand  = new JButton("Rs 10000");
        tenThousand.setBounds(355,485,150,30);
        add(tenThousand);
        image.add(tenThousand);
        tenThousand.addActionListener(this);

        back  = new JButton("BACK");
        back.setBounds(355,515,150,30);
        add(back);
        image.add(back);
        back.addActionListener(this);





        setSize(900,900);
        setLocation(300,0);

        setUndecorated(true);
        setVisible(true);

    }
    public static void main(String[] args) {
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {




            try{

                String amount = ((JButton)e.getSource()).getText().substring(3);

                DatabaseConnection conn = new DatabaseConnection();
                ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+ pinnumber+"'");

                int balance =0;
                while(rs.next()){
                    if(rs.getString("choice").equals("Deposit")){
                         balance  = balance+ Integer.parseInt( rs.getString("amount"));
                    }
                    else{
                        balance = balance - Integer.parseInt(rs.getString("amount"));
                    }
                }
                System.out.println(balance + "  ");

                if(e.getSource()!=back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                if(e.getSource() == back){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    System.out.println("helloo");
                    Date date = new Date();
                    String query = "insert into bank values('" + this.pinnumber + "', '" + date + "', 'Withdrawl', '" + amount + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+amount + "Debited Successfully");

                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }

            }
            catch(Exception ae){
                //System.out.println(ae);
                ae.printStackTrace();
            }

        }


}
