import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class RegistrationForm implements ActionListener {
    JFrame frame;
    String[] airline={"Jaipur","Delhi","Mumbai","USA","UK","Californima","Banglore","Hydrabad","Pune"};
    JLabel nameLabel=new JLabel("Full Name");
    JLabel airlineLabel=new JLabel("From");
    JLabel airline1Label=new JLabel("To");
    JLabel DateLabel=new JLabel("Date");
    JLabel TimeLabel=new JLabel("Time");
    JLabel passportLabel=new JLabel("Passport Id");
    JLabel mobileLabel=new JLabel("Mobile No.");
 
    JTextField nameTextField=new JTextField();
    JComboBox airlineComboBox=new JComboBox(airline);
    JComboBox airline1ComboBox=new JComboBox(airline);
    //JTextField fatherTextField=new JTextField();
    JTextField DateTextField=new JTextField();
    JTextField TimeTextField=new JTextField();
    JTextField passportTextField=new JTextField();
    JTextField mobileTextField=new JTextField();
    JButton registerButton=new JButton("Flight Book");
    JButton resetButton=new JButton("RESET");
  

    RegistrationForm()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame=new JFrame();
        frame.setTitle(" Flight Ticket Booking");
        frame.setBounds(40,40,800,600);
        frame.getContentPane().setBackground(Color.pink);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize()
    {
        nameLabel.setBounds(20,20,70,70);
        airlineLabel.setBounds(20,70,80,70);
        airline1Label.setBounds(20,120,100,70);
        DateLabel.setBounds(20,170,100,70);
        TimeLabel.setBounds(20,220,140,70);
        passportLabel.setBounds(20,270,100,70);
        mobileLabel.setBounds(20,320,100,70);
        nameTextField.setBounds(180,43,165,23);
        airlineComboBox.setBounds(180,93,165,23);
        airline1ComboBox.setBounds(180,143,165,23);
        DateTextField.setBounds(180,193,165,23);
        TimeTextField.setBounds(180,243,165,23);
        passportTextField.setBounds(180,293,165,23);
        mobileTextField.setBounds(180,343,165,23);
        registerButton.setBounds(70,400,100,35);
        resetButton.setBounds(220,400,100,35);
    }
    public void addComponentsToFrame()
    {
        frame.add(nameLabel);
        frame.add(airlineLabel);
        frame.add(airline1Label);
        frame.add(DateLabel);
        frame.add(TimeLabel);
        frame.add(passportLabel);
        frame.add(mobileLabel);
        frame.add(nameTextField);
        frame.add(airlineComboBox);
        frame.add(airline1ComboBox);
        frame.add(DateTextField);
        frame.add(TimeTextField);
        frame.add(passportTextField);
        frame.add(mobileTextField);
        frame.add(registerButton);
        frame.add(resetButton);
    }
    public void actionEvent()
    {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registerButton)
        {
            try {
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","root");
                PreparedStatement Pstatement=connection.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
                Pstatement.setString(1,nameTextField.getText());
                Pstatement.setString(2,airlineComboBox.getSelectedItem().toString());
                Pstatement.setString(3,airline1ComboBox.getSelectedItem().toString());
                Pstatement.setString(4,DateTextField.getText());
                Pstatement.setString(5,TimeTextField.getText());
                Pstatement.setString(6,passportTextField.getText());
                Pstatement.setString(7,mobileTextField.getText());
               // if(passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText()))
               // {

                //    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Ticket Booked Successfully");
               // }
               // else
               // {
               //     JOptionPane.showMessageDialog(null,"Try Again ");
               // }

            } catch (SQLException e1) {
                e1.printStackTrace();
            }


        }
        if(e.getSource()==resetButton)
        {
            nameTextField.setText("");
            airlineComboBox.setSelectedItem("Delhi");
            airline1ComboBox.setSelectedItem("Pune");
            DateTextField.setText("");
            TimeTextField.setText("");
            passportTextField.setText("");
            mobileTextField.setText("");
        }

    }
}
