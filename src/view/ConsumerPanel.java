package view;

import controller.ConsumerController;
import model.commodity.Category;
import model.commodity.Commodity;
import model.user.consumer.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsumerPanel {
    private final Scanner input;
    private final ConsumerController consumerController;
    private boolean exit;
    private final Consumer consumer;
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
    private final Pattern usernamePattern = Pattern.compile("^[a-zA-Z0-9._-]{6,16}$");
    private final Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");

    ConsumerPanel(ArrayList<Consumer> consumers, ArrayList<Commodity> commodities, ArrayList<Comment> comments, ArrayList<SignupRequest> signupRequests, ArrayList<CommentRequest> commentRequests, ArrayList<ChargeRequest> chargeRequests, Consumer consumer) {
        input = new Scanner(System.in);
        consumerController = new ConsumerController(consumers, signupRequests, commentRequests, comments, commodities, chargeRequests);
        exit = false;
        this.consumer = consumer;
    }

    public void consumerPage() {
        System.out.println(consumerCommands());
        int command1 = input.nextInt();
        input.nextLine();
        switch (command1) {
            case 1: {
                System.out.println(consumer.toString() + "1.Change username\t2.Change password");
                String command2 = input.nextLine();
                switch (command2) {
                    case "1": {
                        System.out.println("Enter new username: ");
                        String newUsername = input.nextLine();
                        if (usernamePattern.matcher(newUsername).matches()) {
                            consumer.setUsername(newUsername);
                        } else {
                            while (!usernamePattern.matcher(newUsername).matches()) {
                                System.out.println("Enter a valid username: ");
                                newUsername = input.nextLine();
                            }
                            consumer.setUsername(newUsername);
                        }
                    }
                    break;
                    case "2":{
                        System.out.println("Enter new password: ");
                        String newPassword = input.nextLine();
                        if (usernamePattern.matcher(newPassword).matches()) {
                            consumer.setPassword(newPassword);
                        } else {
                            while (!passwordPattern.matcher(newPassword).matches()) {
                                System.out.println("Enter a valid password: ");
                                newPassword = input.nextLine();
                            }
                            consumer.setUsername(newPassword);
                        }
                    }
                    break;
                }
            }
            break;
            case 2: {
                int page = 1;
                boolean exit = false;
                int pageCount = (int) Math.ceil((double) consumerController.getCommodityCount() / 10);
                while (!exit) {
                    System.out.println(consumerController.showCommodities(page,consumerController.getCommodities()));
                    if (page != pageCount && page != 1) {
                        System.out.println("1.Last page\t2.Next page\t3.quit\nEnter commodity ID to go to its page");
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
                            }
                            continue;
                        } else {
                            consumerController.commodityPage(pageCommand);
                        }
                    }
                    if (page == 1 && page != pageCount) {
                        System.out.println("1.Next page\t2.quit\nEnter commodity ID to go to its page");
                        String pageCommand = input.nextLine();
                        if (Pattern.matches("\\d", pageCommand)) {
                            if (Integer.parseInt(pageCommand) == 1) {
                                page++;
                                continue;
                            }
                            if (Integer.parseInt(pageCommand) == 2) {
                                exit = true;
                            }
                        } else {
                            consumerController.commodityPage(pageCommand);
                        }
                    }
                    if (page == pageCount && page != 1) {
                        System.out.println("1.last page\t2.quit\nEnter commodity ID to go to its page");
                        String pageCommand = input.nextLine();
                        if (Pattern.matches("\\d", pageCommand)) {
                            if (Integer.parseInt(pageCommand) == 1) {
                                page--;
                                continue;
                            }
                            if (Integer.parseInt(pageCommand) == 2) {
                                exit = true;
                            }
                        } else {
                            consumerController.commodityPage(pageCommand);
                        }
                    }
                    if (page == 1 && page == pageCount) {
                        System.out.println("1.quit\nEnter commodity ID to go to its page");
                        String pageCommand = input.nextLine();
                        if (Pattern.matches("\\d", pageCommand)) {
                            if (Integer.parseInt(pageCommand) == 1) {
                                exit = true;
                            }
                        } else {
                            consumerController.commodityPage(pageCommand);
                        }
                    }
                }
            }
            break;
            case 3: {

            }
            break;
        }

    }

    public String consumerCommands() {
        StringBuilder commands = new StringBuilder();
        commands.append("1.Edit info").append("\n2.Show commodities").append("\n3.Show commodities bought");
        return commands.toString();
    }

    public boolean shouldExit() {
        return exit;
    }

    private void filters(String pageCommand) {
        for (Commodity commodity : consumerController.getCommodities()) {
            if (commodity.getID().equals(pageCommand)) {
                System.out.println("2.filter by availability\t3.filter by price\t4.filter by rating\t5.filter by category\t6.filter by name fragment");
                System.out.println("7.remove availability filter\t8.remove price filter\t9.remove rating filter\t10.remove category filter\t11.remove name filter");
                String command2 = input.next();
                switch (command2) {
                    case "1": {
                        consumer.getCart().add(commodity);
                        System.out.println("Commodity " + pageCommand + " added to cart.");
                    }
                    break;
                    case "2": {
                        filterByAvailability = true;
                    }
                    break;
                    case "3": {
                        filterByPrice = true;
                        System.out.println("Enter the low price: ");
                        priceLow = input.nextInt();
                        System.out.println("Enter the high price: ");
                        priceHigh = input.nextInt();
                    }
                    break;
                    case "4": {
                        filterByRating = true;
                        System.out.println("Enter the low rating: ");
                        priceLow = input.nextInt();
                        System.out.println("Enter the high rating: ");
                        priceHigh = input.nextInt();
                    }
                    break;
                    case "5": {
                        filterByCategory = true;
                        System.out.println("1.Comestible\t2.Digital\t3.Stationery\t4.Vehicle");
                        int command3 = input.nextInt();
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
                    break;
                    case "6": {
                        filterByNameFragment = true;
                        System.out.println("Enter name fragment: ");
                        nameFragment = input.next();
                    }
                    break;
                    case "7": {
                        filterByAvailability = false;
                    }
                    break;
                    case "8": {
                        filterByPrice = false;
                    }
                    break;
                    case "9": {
                        filterByRating = false;
                    }
                    break;
                    case "10": {
                        filterByCategory = false;
                        category=null;
                    }
                    break;
                    case "11": {
                        filterByNameFragment = false;
                    }
                    break;
                }
            }
        }
    }
    private Category getCategory(String str){
        Category category=null;
        switch (str.toUpperCase()){
            case "COMESTIBLE":{
                category=Category.COMESTIBLE;
            }
            break;
            case "DIGITAL":{
                category=Category.DIGITAL;
            }
            break;
            case "STATIONERY":{
                category=Category.STATIONERY;
            }
            break;
            case "VEHICLE":{
                category=Category.VEHICLE;
            }
        }
        return category;
    }
}
