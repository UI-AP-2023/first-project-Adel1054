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
                showProfile();
            }
            break;
            case 2: {
                showCommodities();
            }
            break;
            case 3: {
                showCommoditiesBought();
            }
            break;
            case 4:{
                increaseBalance();
            }
            break;
            case 5:{
                viewCart();
            }
            break;
            case 6:{
                finalizePurchase();
            }
            break;
            case 7: {
                shoppingHistory();
            }
            case 8:{
                exit=true;
            }
            break;
        }
    }
    private void showProfile(){
        System.out.println(consumer.toString() + "1.Change username\t2.Change password\t3.Change email\t4.Change phone number");
        String command2 = input.nextLine();
        switch (command2) {
            case "1": {
                System.out.println("Enter new username: ");
                String newUsername = input.nextLine();
                if (consumerController.checkUsername(newUsername)) {
                    consumer.setUsername(newUsername);
                } else {
                    while (!consumerController.checkUsername(newUsername)) {
                        System.out.println("Enter a valid username: ");
                        newUsername = input.nextLine();
                    }
                    consumer.setUsername(newUsername);
                }
            }
            break;
            case "2": {
                System.out.println("Enter new password: ");
                String newPassword = input.nextLine();
                if (consumerController.checkPassword(newPassword)) {
                    consumer.setPassword(newPassword);
                } else {
                    while (!consumerController.checkPassword(newPassword)) {
                        System.out.println("Enter a valid password: ");
                        newPassword = input.nextLine();
                    }
                    consumer.setPassword(newPassword);
                }
            }
            break;
            case "3":{
                System.out.println("Enter new email: ");
                String newEmail = input.nextLine();
                if (consumerController.checkEmail(newEmail)) {
                    consumer.setEmail(newEmail);
                } else {
                    while (!consumerController.checkEmail(newEmail)) {
                        System.out.println("Enter a valid password: ");
                        newEmail = input.nextLine();
                    }
                    consumer.setEmail(newEmail);
                }
            }
            break;
            case "4":{
                System.out.println("Enter new phone number: ");
                String newPhoneNumber = input.nextLine();
                if (consumerController.checkPhoneNumber(newPhoneNumber)) {
                    consumer.setPhoneNumber(newPhoneNumber);
                } else {
                    while (!consumerController.checkPhoneNumber(newPhoneNumber)) {
                        System.out.println("Enter a valid password: ");
                        newPhoneNumber = input.nextLine();
                    }
                    consumer.setPhoneNumber(newPhoneNumber);
                }
            }
            break;
        }
    }
    private void showCommodities(){
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
                    for (Commodity commodity:filteredCommodities){
                        if(commodity.getID().equals(pageCommand)){
                            System.out.println("1.Comment\t2.Add to cart\tanything else to quit");
                            String command= input.nextLine();
                            if(command.equals("1")){
                                String comment= input.nextLine();
                                consumerController.addCommentRequest(commodity,consumer,comment);
                                System.out.println("Comment request submitted.");
                            }
                            if(command.equals("2")){
                                consumerController.addToCart(consumer.getUsername(),commodity);
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
                    for (Commodity commodity:filteredCommodities){
                        if(commodity.getID().equals(pageCommand)){
                            System.out.println("1.Comment\t2.Add to cart\tanything else to quit");
                            String command= input.nextLine();
                            if(command.equals("1")){
                                String comment= input.nextLine();
                                consumerController.addCommentRequest(commodity,consumer,comment);
                                System.out.println("Comment request submitted.");
                            }
                            if(command.equals("2")){
                                consumerController.addToCart(consumer.getUsername(),commodity);
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
                    for (Commodity commodity:filteredCommodities){
                        if(commodity.getID().equals(pageCommand)){
                            System.out.println("1.Comment\t2.Add to cart\tanything else to quit");
                            String command= input.nextLine();
                            if(command.equals("1")){
                                String comment= input.nextLine();
                                consumerController.addCommentRequest(commodity,consumer,comment);
                                System.out.println("Comment request submitted.");
                            }
                            if(command.equals("2")){
                                consumerController.addToCart(consumer.getUsername(),commodity);
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
                    for (Commodity commodity:filteredCommodities){
                        if(commodity.getID().equals(pageCommand)){
                            System.out.println("1.Comment\t2.Add to cart\tanything else to quit");
                            String command= input.nextLine();
                            if(command.equals("1")){
                                String comment= input.nextLine();
                                consumerController.addCommentRequest(commodity,consumer,comment);
                                System.out.println("Comment request submitted.");
                            }
                            if(command.equals("2")){
                                consumerController.addToCart(consumer.getUsername(),commodity);
                                System.out.println("Commodity added to cart.");
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
    private void showCommoditiesBought(){
        System.out.println(consumerController.commoditiesBought(consumer));
        System.out.println("1.Comment request\t2.rate");
        String command = input.nextLine();
        switch (command) {
            case "1": {
                int num =-1;
                while(num>=0&&num<consumer.getCommoditiesBought().size()){
                    System.out.println("Enter commodity number: ");
                    num= input.nextInt();
                    input.nextLine();
                }
                System.out.println("Enter commodity number: ");
                num=input.nextInt();
                input.nextLine();
                System.out.println("Enter your comment: ");
                String comment = input.nextLine();
                consumerController.addCommentRequest(consumer.getCommoditiesBought().get(num - 1), consumer, comment);
                System.out.println("Comment request successfully submitted.");
            }
            break;
            case "2": {
                System.out.println("Enter commodity number: ");
                int num = input.nextInt();
                input.nextLine();
                int rating = 0;
                while (!(rating <= 6 && rating >= 1)) {
                    System.out.println("Enter a rating within 1 and 5: ");
                    rating = input.nextInt();
                    input.nextLine();
                }
                consumerController.addRating(consumer.getUsername(), rating, consumer.getCommoditiesBought().get(num - 1));
            }
            break;
        }
    }
    private void increaseBalance(){
        System.out.println("Enter credit card details in one line(CardNumber CVV2 Password):");
        String card= input.nextLine();
        String[] cardDetails=card.split(" ");
        if(cardDetails.length==3){
            while (!consumerController.checkCardNumber(cardDetails[0])||!consumerController.checkCVV2(cardDetails[1])||!consumerController.checkCardPassword(cardDetails[2])){
                System.out.println("Enter credit card details in one line(CardNumber CVV2 Password):");
                card= input.nextLine();
                cardDetails=card.split(" ");
            }
            System.out.println("Enter the amount you wish to add to your balance: ");
            double amount= input.nextDouble();
            input.nextLine();
            consumerController.chargeRequest(consumer.getUsername(),new CreditCard(cardDetails[0],cardDetails[1],cardDetails[2]),amount);
            System.out.println("Charge request submitted.");
        }
    }
    private void viewCart(){
        int page = 1;
        boolean exit = false;
        int pageCount = (int) Math.ceil((double) consumer.getCart().size() / 10);
        while (!exit) {
            System.out.println(consumerController.getCart(consumer.getUsername(),page));
            if (page != pageCount && page != 1) {
                System.out.println("1.Last page\t2.Next page\t3.remove commodity\t4.quit");
                int pageCommand = input.nextInt();
                input.nextLine();
                switch (pageCommand) {
                    case 1:
                        page--;
                        break;
                    case 2:
                        page++;
                        break;
                    case 3:{
                        System.out.println("Enter ID of commodity you wish to remove:");
                        String ID= input.nextLine();
                        consumerController.removeFromCart(consumer.getUsername(),ID);
                    }
                    break;
                    case 4:
                        exit = true;
                        break;
                }
                continue;
            }
            if (page == 1 && page != pageCount) {
                System.out.println("1.Next page\t2.remove commodity\t3.quit");
                int pageCommand = input.nextInt();
                input.nextLine();
                if (pageCommand == 1) {
                    page++;
                    continue;
                }
                if(pageCommand==2){
                    System.out.println("Enter ID of commodity you wish to remove:");
                    String ID= input.nextLine();
                    consumerController.removeFromCart(consumer.getUsername(),ID);
                }
                if (pageCommand == 3) {
                    exit = true;
                }
            }
            if (page == pageCount && page != 1) {
                System.out.println("1.last page\t2.remove commodity\t3.quit");
                int pageCommand = input.nextInt();
                input.nextLine();
                if (pageCommand == 1) {
                    page--;
                    continue;
                }
                if(pageCommand==2){
                    System.out.println("Enter ID of commodity you wish to remove:");
                    String ID= input.nextLine();
                    consumerController.removeFromCart(consumer.getUsername(),ID);
                }
                if (pageCommand == 3) {
                    exit = true;
                }
            }
            if (page == 1 && page == pageCount) {
                System.out.println("1.remove commodity\t2.quit");
                int pageCommand = input.nextInt();
                input.nextLine();
                if(pageCommand==1){
                    System.out.println("Enter ID of commodity you wish to remove:");
                    String ID= input.nextLine();
                    consumerController.removeFromCart(consumer.getUsername(),ID);
                }
                if (pageCommand == 2) {
                    exit = true;
                }
            }
        }
    }
    private void finalizePurchase(){
        boolean purchaseMade=consumerController.buyCommodities(consumer.getUsername());
        if(purchaseMade){
            System.out.println("Thank you for your purchase receipt added.");
            Receipt receipt=new Receipt("4/4/2023",consumer.getCart());
            consumer.getShoppingHistory().add(receipt);
            System.out.println(receipt);
        }
    }
    private void shoppingHistory(){
        int page = 1;
        int pageCount = (int) Math.ceil((double) consumer.getShoppingHistory().size() / 10);
        boolean exit = false;
        while (!exit) {
            System.out.println(consumerController.getShoppingHistory(consumer.getUsername(), page));
            if (page != pageCount && page != 1) {
                System.out.println("1.Last page\t2.Next page\t3.quit");
                int pageCommand = input.nextInt();
                input.nextLine();
                switch (pageCommand) {
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
            }
            if (page == 1 && page != pageCount) {
                System.out.println("1.Next page\t2.quit");
                int pageCommand = input.nextInt();
                input.nextLine();
                if (pageCommand == 1) {
                    page++;
                    continue;
                }
                if (pageCommand == 2) {
                    exit = true;
                }
            }
            if (page == pageCount && page != 1) {
                System.out.println("1.last page\t2.quit");
                int pageCommand = input.nextInt();
                input.nextLine();
                if (pageCommand == 1) {
                    page--;
                    continue;
                }
                if (pageCommand == 2) {
                    exit = true;
                }
            }
            if (page == 1 && page == pageCount) {
                System.out.println("1.quit");
                int pageCommand = input.nextInt();
                input.nextLine();
                if (pageCommand == 1) {
                    exit = true;
                }
            }
        }
    }
    public String consumerCommands() {
        StringBuilder commands = new StringBuilder();
        commands.append("1.Show profile\t2.Show commodities\t3.Show commodities bought\n4.Increase balance\t5.View cart");
        commands.append("\t6.Finalize purchase\t7.Shopping history\t8.Exit");
        return commands.toString();
    }

    public boolean shouldExit() {
        return exit;
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
                priceLow = input.nextInt();
                System.out.println("Enter the high rating: ");
                priceHigh = input.nextInt();
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

}
