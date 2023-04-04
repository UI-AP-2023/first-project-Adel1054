package view;

import model.commodity.Commodity;
import model.user.consumer.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainPanel {
    private final Scanner input;
    private static boolean exit;
    private final ArrayList<Consumer> consumers;
    private final ArrayList<Commodity> commodities;
    private final ArrayList<Comment> comments;
    private final ArrayList<SignupRequest> signupRequests;
    private final ArrayList<CommentRequest> commentRequests;
    private final ArrayList<ChargeRequest> chargeRequests;
    private final ArrayList<String> usernames;
    private final ArrayList<String> emails;
    private final ArrayList<String> phoneNumbers;
    private final Pattern usernamePattern = Pattern.compile("^[a-zA-Z0-9._-]{6,16}$");
    private final Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    private final Pattern emailPattern=Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$");
    private final Pattern phoneNumberPattern=Pattern.compile("^09\\d{9}");
    public MainPanel() {
        input = new Scanner(System.in);
        exit = false;
        commodities = new ArrayList<>();
        chargeRequests = new ArrayList<>();
        comments = new ArrayList<>();
        consumers = new ArrayList<>();
        commentRequests = new ArrayList<>();
        signupRequests = new ArrayList<>();
        usernames = new ArrayList<>();
        emails = new ArrayList<>();
        phoneNumbers=new ArrayList<>();
    }

    public void mainPage() {
        System.out.println("1.ConsumerLogin\t2.AdminLogin\t3.SeeCommodities\t4.Signup");
        int command1 = input.nextInt();
        input.nextLine();
        switch (command1) {
            case 1: {
                System.out.println("Enter username:");
                String username = input.nextLine();
                System.out.println("Enter password:");
                String password = input.nextLine();
                for (Consumer consumer : consumers) {
                    if (consumer.getUsername().equals(username) && consumer.getPassword().equals(password)) {
                        ConsumerPanel consumerPanel = new ConsumerPanel(consumers, commodities, comments, signupRequests, commentRequests, chargeRequests, consumer);
                        while (!consumerPanel.shouldExit()) {
                            consumerPanel.consumerPage();
                        }
                        break;
                    }
                }
            }
            break;
            case 2: {
                System.out.print("Enter Admin username: ");
                String inputUsername = input.nextLine();
                System.out.print("Enter Admin password: ");
                String inputPassword = input.nextLine();
                AdminPanel adminPanel = new AdminPanel(consumers, commodities, comments, signupRequests, commentRequests, chargeRequests);
                if (adminPanel.login(inputUsername, inputPassword)) {
                    while (!adminPanel.shouldExit()) {
                        adminPanel.adminPage();
                    }
                }
            }
            break;
            case 3:
                break;
            case 4: {
                System.out.print("Enter a unique username: ");
                String username = input.nextLine();
                while (!usernamePattern.matcher(username).matches() || usernames.contains(username)) {
                    if(!usernamePattern.matcher(username).matches()){
                        System.out.print("Enter username between 6 and 16 letters: ");
                    }
                    else {
                        System.out.print("Username already taken. Choose another username: ");
                    }
                    username= input.nextLine();
                }
                System.out.print("Create a password for the account: ");
                String password = input.nextLine();
                while (!passwordPattern.matcher(password).matches()){
                    System.out.println("Enter a valid password between 8 and 14 letters using special characters and lower and upper case letters and numbers:");
                    password= input.nextLine();
                }
                System.out.print("Enter a unique email address: ");
                String email= input.nextLine();
                while (!emailPattern.matcher(email).matches()||emails.contains(email)){
                    if(!emailPattern.matcher(email).matches()){
                        System.out.println("Enter a valid email address:");
                        email= input.nextLine();
                    }
                    else {
                        System.out.println("Email already taken. Enter another email: ");
                        email= input.nextLine();
                    }
                }
                System.out.print("Enter a unique phone number: ");
                String phoneNumber= input.nextLine();
                while (!phoneNumberPattern.matcher(phoneNumber).matches()||phoneNumbers.contains(phoneNumber)){
                    if(!phoneNumberPattern.matcher(phoneNumber).matches()){
                        System.out.println("Enter a valid phoneNumbers starting with '09':");
                        phoneNumber= input.nextLine();
                    }
                    else {
                        System.out.println("Phone number already taken. enter another phone number: ");
                        phoneNumber= input.nextLine();
                    }
                }
                signupRequests.add(new SignupRequest(username,password,email,phoneNumber));
                System.out.println("Signup request successfully submitted.");
            }
            break;
        }
    }

    public static boolean shouldExit() {
        return exit;
    }

    public static void setExit(boolean exit) {
        MainPanel.exit = exit;
    }
}
