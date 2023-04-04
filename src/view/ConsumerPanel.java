package view;

import controller.ConsumerController;
import model.commodity.Commodity;
import model.user.consumer.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsumerPanel {
    private final Scanner input;
    private final ConsumerController consumerController;
    private boolean exit;
    private final Consumer consumer;
    boolean filterByCategory;
    boolean filterByRating;
    boolean filterByPrice;
    boolean filterByAvailability;
    boolean filterByNameFragment;
    private Pattern usernamePattern = Pattern.compile("(?=\\w)(?=\\S){6,16}");
    private Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,14}$");

    ConsumerPanel(ArrayList<Consumer> consumers, ArrayList<Commodity> commodities, ArrayList<Comment> comments, ArrayList<SignupRequest> signupRequests, ArrayList<CommentRequest> commentRequests, ArrayList<ChargeRequest> chargeRequests, Consumer consumer) {
        input = new Scanner(System.in);
        consumerController = new ConsumerController(consumers, signupRequests, commentRequests, comments, commodities, chargeRequests);
        exit = false;
        this.consumer = consumer;
    }

    public void consumerPage() {
        System.out.println("Enter command: ");
        int command1 = input.nextInt();
        switch (command1) {
            case 1: {
                System.out.println(consumer.toString() + "\nTo change info enter next command");
                String command2 = input.next();
                switch (command2) {
                    case "ChangeUsername": {
                        System.out.println("Enter new username: ");
                        String newUsername = input.next();
                        if (usernamePattern.matcher(newUsername).matches()) {
                            consumer.setUsername(newUsername);
                        } else {
                            while (!usernamePattern.matcher(newUsername).matches()) {
                                System.out.println("Enter a valid username: ");
                                newUsername = input.next();
                            }
                            consumer.setUsername(newUsername);
                        }
                    }
                }
            }
            break;
            case 2: {
                int page = 1;
                boolean exit = false;
                int pageCount = (int) Math.ceil((double) consumerController.getCommodityCount() / 10);
                while (!exit) {
                    System.out.println(consumerController.showCommodities(page));
                    if (page != pageCount && page != 1) {
                        System.out.println("1.Last page\t2.Next page\t3.quit\nEnter commodity ID to view its page");
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
                        } else {
                            consumerController.commodityPage(pageCommand);
                        }
                    }
                    if (page == 1 && page != pageCount) {
                        System.out.println("1.Next page\t2.quit\nEnter commodity ID to view its page");
                        String pageCommand = input.nextLine();
                        if (Pattern.matches("\\d", pageCommand)) {
                            if (Integer.parseInt(pageCommand) == 1) {
                                page++;
                            }
                            if (Integer.parseInt(pageCommand) == 2) {
                                exit = true;
                            }
                        } else {
                            consumerController.commodityPage(pageCommand);
                        }
                    }
                    if (page == pageCount && page != 1) {
                        System.out.println("1.last page\t2.quit\nEnter commodity ID to view its page");
                        String pageCommand = input.nextLine();
                        if (Pattern.matches("\\d", pageCommand)) {
                            if (Integer.parseInt(pageCommand) == 1) {
                                page--;
                            }
                            if (Integer.parseInt(pageCommand) == 2) {
                                exit = true;
                            }
                        } else {
                            consumerController.commodityPage(pageCommand);
                        }
                    }
                    if (page == 1 && page == pageCount) {
                        System.out.println("1.quit\nEnter commodity ID to view its page");
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
        }
    }

    public String consumerCommands() {
        StringBuilder commands = new StringBuilder();
        commands.append("1.Edit info").append("\n2.Show commodities");
        return commands.toString();
    }

    public boolean shouldExit() {
        return exit;
    }
}
