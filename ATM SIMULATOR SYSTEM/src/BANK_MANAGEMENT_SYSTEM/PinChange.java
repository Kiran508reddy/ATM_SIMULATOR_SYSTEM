package BANK_MANAGEMENT_SYSTEM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

      JButton change;
      JButton back;

      JPasswordField pin;
      JPasswordField repin;

      String pinnumber;

    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);

        JLabel pintext = new JLabel("New PIN :");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);

         pin = new JPasswordField();
        pin.setBounds(330,320,180,25);
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(pin);

        JLabel repintext = new JLabel(" Re-Enter new PIN :");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);

         repin = new JPasswordField();
        repin.setBounds(330,360,180,25);
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(repin);

         change  = new JButton("CHANGE");
        change.setBounds(355,405,150,30);
        image.add(change);
        change.addActionListener(this);

         back  = new JButton("BACK");
        change.setBounds(355,405,150,30);
        image.add(back);
        back.addActionListener(this);



        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == change){
            try{
                String npin = pin.getText();
                String rpin = pin.getText();
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }

                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter the new PIN");
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-nter the new PIN");
                }

                DatabaseConnection con = new DatabaseConnection();
                String query1 = "update bank set pinnumber = '"+rpin+"' where pinnumber ='"+pinnumber+"'";
                String query2 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber ='"+pinnumber+"'";
                String query3 = "update login set pinnumber = '"+rpin+"' where pinnumber ='"+pinnumber+"'";

                con.s.executeUpdate(query1);
                con.s.executeUpdate(query2);
                con.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                setVisible(false);
                new Transactions(npin).setVisible(true);

            }
            catch (Exception ae){
                System.out.println(ae);
            }
        }
        else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }


    }
}
