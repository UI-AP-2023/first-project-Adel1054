package view;

import controller.ConsumerController;
import exception.InvalidEmailException;
import exception.InvalidPasswordException;
import exception.InvalidPhoneNumberException;
import exception.InvalidUsernameException;
import model.commodity.Category;
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
    private final ConsumerController consumerController;
    private boolean filterByCategory = false;
    private boolean filterByRating = false;
    private boolean filterByPrice = false;
    private boolean filterByAvailability = false;
    private boolean filterByNameFragment = false;
    private int priceLow = -1;
    private int priceHigh = -1;
    private Category category = null;
    private int ratingLow = -1;
    private int ratingHigh = -1;
    private String nameFragment = "";
    private final ArrayList<Commodity> cart;
    private final ArrayList<String> usernames;
    private final ArrayList<String> emails;
    private final ArrayList<String> phoneNumbers;

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
        phoneNumbers = new ArrayList<>();
        consumerController = new ConsumerController(consumers, signupRequests, commentRequests, comments, commodities, chargeRequests);
        cart = new ArrayList<>();
    }

    public void mainPage() {
        System.out.println("1.ConsumerLogin\t2.AdminLogin\t3.SeeCommodities\t4.Signup");
        int command1 = input.nextInt();
        input.nextLine();
        switch (command1) {
            case 1: {
                consumerLogin();
            }
            break;
            case 2: {
                adminLogin();
            }
            break;
            case 3: {
                seeCommodities();
            }
            break;
            case 4: {
                signup();
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

    private void filters() {
        System.out.println("1.filter by availability\t2.filter by price\t3.filter by rating\t4.filter by category\t5.filter by name fragment");
        System.out.println("6.remove availability filter\t7.remove price filter\t8.remove rating filter\t9.remove category filter\t10.remove name filter");
        String command2 = input.nextLine();
        switch (command2) {
            case "1": {
                filterByAvailability = true;
            }
            break;
            case "2": {
                filterByPrice = true;
                System.out.println("Enter the low price: ");
                priceLow = input.nextInt();
                System.out.println("Enter the high price: ");
                priceHigh = input.nextInt();
            }
            break;
            case "3": {
                filterByRating = true;
                System.out.println("Enter the low rating: ");
                ratingLow = input.nextInt();
                System.out.println("Enter the high rating: ");
                ratingHigh = input.nextInt();
            }
            break;
            case "4": {
                filterByCategory = true;
                while (category == null) {
                    System.out.println("1.Comestible\t2.Digital\t3.Stationery\t4.Vehicle");
                    int command3 = input.nextInt();
                    input.nextLine();
                    switch (command3) {
                        case 1: {
                            category = Category.COMESTIBLE;
                        }
                        break;
                        case 2: {
                            category = Category.DIGITAL;
                        }
                        break;
                        case 3: {
                            category = Category.STATIONERY;
                        }
                        break;
                        case 4: {
                            category = Category.VEHICLE;
                        }
                        break;
                    }
                }
            }
            break;
            case "5": {
                filterByNameFragment = true;
                System.out.println("Enter name fragment: ");
                nameFragment = input.nextLine();
            }
            break;
            case "6": {
                filterByAvailability = false;
            }
            break;
            case "7": {
                filterByPrice = false;
            }
            break;
            case "8": {
                filterByRating = false;
            }
            break;
            case "9": {
                filterByCategory = false;
                category = null;
            }
            break;
            case "10": {
                filterByNameFragment = false;
            }
            break;
        }
    }

    private void seeCommodities() {
        int page = 1;
        boolean exit = false;
        while (!exit) {
            ArrayList<Commodity> filteredCommodities = consumerController.getCommodities();
            if (filterByCategory) {
                filteredCommodities = consumerController.filterByCategory(category, filteredCommodities);
            }
            if (filterByRating) {
                filteredCommodities = consumerController.filterByRating(ratingLow, ratingHigh, filteredCommodities);
            }
            if (filterByAvailability) {
                filteredCommodities = consumerController.filterByAvailability(filteredCommodities);
            }
            if (filterByPrice) {
                filteredCommodities = consumerController.filterByPrice(priceLow, priceHigh, filteredCommodities);
            }
            if (filterByNameFragment) {
                filteredCommodities = consumerController.filterByNameFragment(nameFragment, filteredCommodities);
            }
            int pageCount = (int) Math.ceil((double) filteredCommodities.size() / 10);
            System.out.println(consumerController.showCommodities(page, filteredCommodities));
            if (page != pageCount && page != 1) {
                System.out.println("1.Last page\t2.Next page\t3.quit\t4.filters\nEnter commodity ID to go to its page");
                String pageCommand = input.nextLine();
                if (Pattern.matches("\\d", pageCommand)) {
                    switch (Integer.parseInt(pageCommand)) {
                        case 1:
                            page--;
                            break;
                        case 2:
                            page++;
                            break;
                        case 3:
                            exit = true;
                            break;
                        case 4:
                            filters();
                            break;
                    }
                    continue;
                } else {
                    System.out.println(consumerController.commodityPage(pageCommand));
                    for (Commodity commodity : filteredCommodities) {
                        if (commodity.getID().equals(pageCommand)) {
                            System.out.println("1.Add to cart\tanything else to quit");
                            String command = input.nextLine();
                            if (command.equals("1")) {
                                cart.add(commodity);
                                System.out.println("Commodity added to cart.");
                            }
                            break;
                        }
                    }
                }
            }
            if (page == 1 && page != pageCount) {
                System.out.println("1.Next page\t2.quit\t3.filters\nEnter commodity ID to go to its page");
                String pageCommand = input.nextLine();
                if (Pattern.matches("\\d", pageCommand)) {
                    if (Integer.parseInt(pageCommand) == 1) {
                        page++;
                        continue;
                    }
                    if (Integer.parseInt(pageCommand) == 2) {
                        exit = true;
                    }
                    if (Integer.parseInt(pageCommand) == 3) {
                        filters();
                    }
                } else {
                    System.out.println(consumerController.commodityPage(pageCommand));
                    for (Commodity commodity : filteredCommodities) {
                        if (commodity.getID().equals(pageCommand)) {
                            System.out.println("1.Add to cart\tanything else to quit");
                            String command = input.nextLine();
                            if (command.equals("1")) {
                                cart.add(commodity);
                                System.out.println("Commodity added to cart.");
                            }
                            break;
                        }
                    }
                }
            }
            if (page == pageCount && page != 1) {
                System.out.println("1.last page\t2.quit\t3.filters\nEnter commodity ID to go to its page");
                String pageCommand = input.nextLine();
                if (Pattern.matches("\\d", pageCommand)) {
                    if (Integer.parseInt(pageCommand) == 1) {
                        page--;
                        continue;
                    }
                    if (Integer.parseInt(pageCommand) == 2) {
                        exit = true;
                    }
                    if (Integer.parseInt(pageCommand) == 3) {
                        filters();
                    }
                } else {
                    System.out.println(consumerController.commodityPage(pageCommand));
                    for (Commodity commodity : filteredCommodities) {
                        if (commodity.getID().equals(pageCommand)) {
                            System.out.println("1.Add to cart\tanything else to quit");
                            String command = input.nextLine();
                            if (command.equals("1")) {
                                cart.add(commodity);
                                System.out.println("Commodity added to cart.");
                            }
                            break;
                        }
                    }
                }
            }
            if (page == 1 && page == pageCount) {
                System.out.println("1.quit\t2.filters\nEnter commodity ID to go to its page");
                String pageCommand = input.nextLine();
                if (Pattern.matches("\\d", pageCommand)) {
                    if (Integer.parseInt(pageCommand) == 1) {
                        exit = true;
                    }
                    if (Integer.parseInt(pageCommand) == 2) {
                        filters();
                    }
                } else {
                    System.out.println(consumerController.commodityPage(pageCommand));
                    for (Commodity commodity : filteredCommodities) {
                        if (commodity.getID().equals(pageCommand)) {
                            System.out.println("1.Add to cart\tanything else to quit");
                            String command = input.nextLine();
                            if (command.equals("1")) {
                                cart.add(commodity);
                                System.out.println("Commodity added to cart.");
                            }
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("If you wish to buy these commodities make an account and use the command to add these to the cart.");

    }

    private void signup() {
        System.out.print("Enter a unique username: ");
        String username = input.nextLine();
        try {
            consumerController.checkUsernameT(username);
        } catch (InvalidUsernameException e1) {
            System.out.println(e1.getMessage());
            while (!consumerController.checkUsername(username) || usernames.contains(username)) {
                if (!consumerController.checkUsername(username)) {
                    System.out.print("Enter username between 6 and 16 letters: ");
                } else {
                    System.out.print("Username already taken. Choose another username: ");
                }
                username = input.nextLine();
                try {
                    consumerController.checkUsernameT(username);
                } catch (InvalidUsernameException e2) {
                    System.out.println(e2.getMessage());
                }
            }
        }
        System.out.print("Create a password for the account: ");
        String password = input.nextLine();
        try {
            consumerController.checkPasswordT(password);
        } catch (InvalidPasswordException e1) {
            System.out.println(e1.getMessage());
            while (!consumerController.checkPassword(password)) {
                System.out.println("Enter a valid password between 8 and 14 letters using special characters and lower and upper case letters and numbers:");
                password = input.nextLine();
                try {
                    consumerController.checkPasswordT(password);
                } catch (InvalidPasswordException e2) {
                    System.out.println(e2.getMessage());
                }
            }
        }
        System.out.print("Enter a unique email address: ");
        String email = input.nextLine();
        try {
            consumerController.checkEmailT(email);
        } catch (InvalidEmailException e1) {
            System.out.println(e1.getMessage());
            while (!consumerController.checkEmail(email) || emails.contains(email)) {
                if (!consumerController.checkEmail(email)) {
                    System.out.println("Enter a valid email address:");
                } else {
                    System.out.println("Email already taken. Enter another email: ");
                }
                email = input.nextLine();
                try {
                    consumerController.checkEmailT(email);
                } catch (InvalidEmailException e2) {
                    System.out.println(e2.getMessage());
                }
            }
        }
        System.out.print("Enter a unique phone number: ");
        String phoneNumber = input.nextLine();
        try {
            consumerController.checkPhoneNumberT(phoneNumber);
        }catch (InvalidPhoneNumberException e1) {
            System.out.println(e1.getMessage());
            while (!consumerController.checkPhoneNumber(phoneNumber) || phoneNumbers.contains(phoneNumber)) {
                if (!consumerController.checkPhoneNumber(phoneNumber)) {
                    System.out.println("Enter a valid phoneNumbers starting with '09':");
                } else {
                    System.out.println("Phone number already taken. enter another phone number: ");
                }
                phoneNumber = input.nextLine();
                try {
                    consumerController.checkPhoneNumberT(phoneNumber);
                }catch (InvalidPhoneNumberException e2){
                    System.out.println(e2.getMessage());
                }
            }
        }
        signupRequests.add(new SignupRequest(username, password, email, phoneNumber));
        System.out.println("Signup request successfully submitted.");
    }

    private void adminLogin() {
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

    private void consumerLogin() {
        System.out.println("Enter username:");
        String username = input.nextLine();
        System.out.println("Enter password:");
        String password = input.nextLine();
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username) && consumer.getPassword().equals(password)) {
                System.out.println("if you wish to add commodities to cart enter 1 anything else to pass");
                String command = input.nextLine();
                if (command.equals("1")) {
                    for (Commodity commodity : cart) {
                        consumer.getCart().add(commodity);
                    }
                    cart.clear();
                }
                ConsumerPanel consumerPanel = new ConsumerPanel(consumers, commodities, comments, signupRequests, commentRequests, chargeRequests, consumer);
                while (!consumerPanel.shouldExit()) {
                    consumerPanel.consumerPage();
                }
                break;
            }
        }
    }
}
