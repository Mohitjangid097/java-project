import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class RegistrationForm implements ActionListener {
    JFrame frame;
    String[] from={"Delhi","Jaipur","Mumbai","USA","UK","Californima","Banglore","Hydrabad","Pune"};
    String[] to={"Pune","Jaipur","Delhi","Mumbai","USA","UK","Californima","Banglore","Hydrabad"};
    String[] time={"10:30 AM","10:30 PM"};
    JLabel nameLabel=new JLabel("Name");
    JLabel fromLabel=new JLabel("From");
    JLabel toLabel=new JLabel("To");
    JLabel dateLabel=new JLabel("Date (dd/mm/yyyy)");
    JLabel timeLabel=new JLabel("Time");
    JLabel passwordLabel=new JLabel("Passport ID");
    JLabel confirmPasswordLabel=new JLabel("Confirm Passport ID");
    JLabel mobileLabel=new JLabel("Mobile No.");
    JLabel emailLabel=new JLabel("EMAIL");
    JTextField nameTextField=new JTextField();
    JComboBox fromComboBox=new JComboBox(from);
    JComboBox toComboBox=new JComboBox(to); 
    JTextField dateTextField=new JTextField();
    JComboBox timeComboBox=new JComboBox(time); 
    JTextField TextField=new JTextField();
    JTextField confirmTextField=new JTextField();
    JTextField mobileTextField=new JTextField();
    JTextField emailTextField=new JTextField();
    JButton registerButton=new JButton("Ticket Book");
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
        frame.setTitle("Flight Ticket Booking");
        frame.setBounds(40,40,800,650);
        frame.getContentPane().setBackground(Color.pink);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize()
    {
        nameLabel.setBounds(20,20,40,70);
        fromLabel.setBounds(20,70,80,70);
        toLabel.setBounds(20,120,100,70);
        dateLabel.setBounds(20,170,120,70);
        timeLabel.setBounds(20,220,140,70);
        passwordLabel.setBounds(20,270,100,70);
        confirmPasswordLabel.setBounds(20,320,130,70);
        mobileLabel.setBounds(20,370,100,70);
        emailLabel.setBounds(20,420,100,70);
        
        nameTextField.setBounds(180,43,165,23);
        fromComboBox.setBounds(180,93,165,23);
        toComboBox.setBounds(180,143,165,23);
        dateTextField.setBounds(180,193,165,23);
        timeComboBox.setBounds(180,243,165,23);
        TextField.setBounds(180,293,165,23);
        confirmTextField.setBounds(180,343,165,23);
        mobileTextField.setBounds(180,393,165,23);
        emailTextField.setBounds(180,443,165,23);
        
        registerButton.setBounds(70,500,120,35);
        resetButton.setBounds(220,500,100,35);
    }
    public void addComponentsToFrame()
    {
        frame.add(nameLabel);
        frame.add(fromLabel);
        frame.add(toLabel);
        frame.add(dateLabel);
        frame.add(timeLabel);
        frame.add(passwordLabel);
        frame.add(confirmPasswordLabel);
        frame.add(mobileLabel);
        frame.add(emailLabel);
        frame.add(nameTextField);
        frame.add(fromComboBox);
        frame.add(toComboBox);
        frame.add(dateTextField);
        frame.add(timeComboBox);
        frame.add(TextField);
        frame.add(confirmTextField);
        frame.add(mobileTextField);
        frame.add(emailTextField);
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
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightDatabase","root","root");
                PreparedStatement Pstatement=connection.prepareStatement("insert into flight values(?,?,?,?,?,?,?,?,?)");
                Pstatement.setString(1,nameTextField.getText());
                Pstatement.setString(2,fromComboBox.getSelectedItem().toString());
                Pstatement.setString(3,toComboBox.getSelectedItem().toString());
                Pstatement.setString(4,dateTextField.getText());
                Pstatement.setString(5,timeComboBox.getSelectedItem().toString());
                Pstatement.setString(6,TextField.getText());
                Pstatement.setString(7,confirmTextField.getText());
                Pstatement.setString(8,mobileTextField.getText());
                Pstatement.setString(9,emailTextField.getText());
                if(TextField.getText().equalsIgnoreCase(confirmTextField.getText()))
                {

                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Ticked Booked Successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Passport ID did not match");
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
            }


        }
        if(e.getSource()==resetButton)
        {
            nameTextField.setText("");
            fromComboBox.setSelectedItem("mumbai");
            toComboBox.setSelectedItem("pune");
            dateTextField.setText("");
            timeComboBox.setSelectedItem("pune");
            TextField.setText("");
            confirmTextField.setText("");
            mobileTextField.setText("");
            emailTextField.setText("");
        }

    }
}
