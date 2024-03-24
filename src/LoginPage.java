import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginPage implements ActionListener {

    //Initializing components
    private JLabel usernameLabel,passwordLabel;
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JButton loginButton;
    private final JFrame frame;
    private final WestminsterShoppingManager manager;
    private ArrayList<User> userList = new ArrayList<>();

    private boolean userExist;

    LoginPage(WestminsterShoppingManager manager){
        this.manager = manager;

        //Creating Components
        frame = new JFrame("Login");
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        usernameLabel.setBounds(50,100,100,30);
        passwordLabel.setBounds(50,150,100,30);
        usernameField.setBounds(150,100,100,30);
        passwordField.setBounds(150,150,100,30);
        loginButton.setBounds(150,200,100,30);

        //Adding components to the frame
        frame.add(usernameLabel);
        frame.add(passwordLabel);
        frame.add(usernameField);
        frame.add(passwordField);
        frame.add(loginButton);

        //Setting the frame
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }
    //Creating action listener for the login button
    @Override
    public void actionPerformed(ActionEvent e){
        //Checking if the login button is clicked
        if (e.getSource()==loginButton){
            userExist = false;
            String username = usernameField.getText();
            String password = passwordField.getText();
            if (username.isEmpty() || password.isEmpty()){
                JOptionPane.showMessageDialog(frame,"Enter Login Info");
                return;
            }
            User user = new User(username,password,false);
            userList = readUsersFromFile();
            //If the user list is empty, the user is a new user
            if (userList.size()==0){
                userExist = true;
                user.setNewUser(true);
                JOptionPane.showMessageDialog(frame,"New user created");
                userList.add(user);
                saveUsersToFile();}
            //Checking if the username and password are correct
            for (User u : userList){
                if (username.equals(u.getUsername()) && password.equals(u.getPassword())){
                    JOptionPane.showMessageDialog(frame,"Login Successful");
                    userExist = true;
                    new GUI(manager,user);
                    frame.dispose();
                }else if (username.equals(u.getUsername()) && !password.equals(u.getPassword())){
                    JOptionPane.showMessageDialog(frame,"Incorrect Password");
                    userExist = true;
                    return;

                }
            }
            //If the user is not in the list, the user is a new user
            if (!userExist){
            JOptionPane.showMessageDialog(frame,"New user created");
            JOptionPane.showMessageDialog(frame,"Login Successful");
            user.setUsername(username);
            user.setPassword(password);
            user.setNewUser(true);
            userList.add(user);
            saveUsersToFile();
            frame.dispose();
            new GUI(manager,user);
            }

        }
    }

    //Saving user info to file
    public void saveUsersToFile(){
        try{
            FileWriter file = new FileWriter("Users.txt");

            for (User user : userList){
                file.write(user.getUsername()+","+user.getPassword()+","+user.getNewUser()+"\n");
            }
            file.close();


        } catch (IOException e){
            System.out.println("Error1 :"+e+e.getMessage());
        }
    }


    //Reading user info from file
    public ArrayList<User> readUsersFromFile(){

        try {
            FileReader file = new FileReader("Users.txt");
            Scanner scanner = new Scanner(file);
            String line;
            while (scanner.hasNextLine()){
                line = scanner.nextLine();
                String[] values = line.split(",");
                User user = new User(values[0],values[1],false);
                userList.add(user);
            }
        } catch (Exception e){
            System.out.println("Error2 :"+e.getMessage());
            e.printStackTrace();
        }
        return userList;
    }



}
