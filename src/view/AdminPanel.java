package view;

import controller.AdminController;
import model.commodity.Commodity;
import model.commodity.stationery.Pencil;
import model.commodity.vehicles.Bicycle;
import model.user.consumer.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AdminPanel {
    private final AdminController adminController;
    private final Scanner input;
    private boolean exit;

    AdminPanel(ArrayList<Consumer> consumers, ArrayList<Commodity> commodities, ArrayList<Comment> comments, ArrayList<SignupRequest> signupRequests, ArrayList<CommentRequest> commentRequests, ArrayList<ChargeRequest> chargeRequests) {
        input = new Scanner(System.in);
        adminController = new AdminController(consumers, commodities, comments, signupRequests, commentRequests, chargeRequests);
        exit = false;
    }

    private Bicycle.BicycleType getBicycleType(String type) {
        switch (type.toUpperCase()) {
            case "MOUNTAIN":
                return Bicycle.BicycleType.MOUNTAIN;
            case "ROAD":
                return Bicycle.BicycleType.ROAD;
            case "CITY":
                return Bicycle.BicycleType.CITY;
            case "HYBRID":
                return Bicycle.BicycleType.HYBRID;
        }
        return null;
    }

    private Pencil.PencilType getPencilType(String type) {
        switch (type.toUpperCase()) {
            case "H2":
                return Pencil.PencilType.H2;
            case "H":
                return Pencil.PencilType.H;
            case "F":
                return Pencil.PencilType.F;
            case "B":
                return Pencil.PencilType.B;
            case "HB":
                return Pencil.PencilType.HB;
        }
        return null;
    }

    public void adminPage() {
        System.out.println("Enter next command in one line:");
        String command = input.nextLine();
        String[] commands = command.split(" ");
        switch (commands[0]) {
            case "Add": {
                switch (commands[1]) {
                    case "Comestible":
                        adminController.addComestible(commands[2], Double.parseDouble(commands[3]), Integer.parseInt(commands[4]), commands[5], commands[6]);
                        break;
                    case "FlashMemory":
                        adminController.addFlashMemory(commands[2], Double.parseDouble(commands[3]), Integer.parseInt(commands[4]), Double.parseDouble(commands[5]), commands[6], Integer.parseInt(commands[7]), Double.parseDouble(commands[8]));
                        break;
                    case "PC":
                        adminController.addPC(commands[2], Double.parseDouble(commands[3]), Integer.parseInt(commands[4]), Double.parseDouble(commands[5]), commands[6], Integer.parseInt(commands[7]), commands[8]);
                        break;
                    case "SSD":
                        adminController.addSSD(commands[2], Double.parseDouble(commands[3]), Integer.parseInt(commands[4]), Double.parseDouble(commands[5]), commands[6], Integer.parseInt(commands[7]), Double.parseDouble(commands[8]), Double.parseDouble(commands[9]));
                        break;
                    case "Notebook":
                        adminController.addNotebook(commands[2], Double.parseDouble(commands[3]), Integer.parseInt(commands[4]), commands[5], Integer.parseInt(commands[6]), commands[7]);
                        break;
                    case "Pen":
                        adminController.addPen(commands[2], Double.parseDouble(commands[3]), Integer.parseInt(commands[4]), commands[5], commands[6]);
                        break;
                    case "Pencil":
                        adminController.addPencil(commands[2], Double.parseDouble(commands[3]), Integer.parseInt(commands[4]), commands[5], getPencilType(commands[6]));
                        break;
                    case "Automobile":
                        adminController.addAutomobile(commands[2], Double.parseDouble(commands[3]), Integer.parseInt(commands[4]), commands[5], Boolean.getBoolean(commands[6]), Integer.parseInt(commands[7]));
                        break;
                    case "Bicycle":
                        adminController.addBicycle(commands[2], Double.parseDouble(commands[3]), Integer.parseInt(commands[4]), commands[5], getBicycleType(commands[6]));
                        break;
                }
            }
            break;
            case "1": {
                showConsumers();
            }
            break;
            case "2": {
                showComments();
            }
            break;
            case "3": {
                showCommodities();
            }
            break;
            case "4": {
                signupRequests();
            }
            break;
            case "5": {
                commentRequests();
            }
            break;
            case "6": {
                chargeRequests();
            }
            break;
            case "7": {
                exit = true;
            }
            break;
            case "8": {
                System.out.println(AdminCommands());
            }
            break;
            case "9": {
                MainPanel.setExit(true);
                exit = true;
                System.out.println("Shutting down the online shop.");
            }
            break;
        }

    }

    public String AdminCommands() {
        StringBuilder commandsList = new StringBuilder();
        commandsList.append("1.Add:").append("\n\tComestible Name Price AvailableCount ProductionDate ExpirationDate");
        commandsList.append("\n\tFlashMemory Name Price AvailableCount Weight Dimensions Capacity UsbVersion");
        commandsList.append("\n\tPC Name Price AvailableCount Weight Dimensions RamCapacity CpuType");
        commandsList.append("\n\tSSD Name Price AvailableCount Weight Dimensions Capacity ReadSpeed WriteSpeed");
        commandsList.append("\n\tNotebook Name Price AvailableCount Country NumberOfPages PageType");
        commandsList.append("\n\tPencil Name Price AvailableCount Country PencilType(H2, H, F, B, HB)");
        commandsList.append("\n\tPen Name Price AvailableCount Country Colour");
        commandsList.append("\n\tAutomobile Name Price AvailableCount CompanyName IsAutomatic(true,false) MotorVolume");
        commandsList.append("\n\tBicycle Name Price AvailableCount CompanyName BicycleType(MOUNTAIN, ROAD, CITY, HYBRID)");
        commandsList.append("\n1.ShowConsumers\n2.ShowComments\n3.ShowCommodities\n4.SignupRequests\n5.CommentRequests\n6.ChargeRequests\n9.ShutdownShop");
        return commandsList.toString();
    }

    public boolean shouldExit() {
        return exit;
    }

    private void commodityEdit(String commodityID, String commodityAttribute) {
        for (Commodity commodity : adminController.getCommodities()) {
            if (commodity.getID().equals(commodityID)) {
                switch (commodityAttribute) {
                    case "AvailableCount": {
                        System.out.println("Enter new available count: ");
                        String newAvailableCount = input.next();
                        input.nextLine();
                        commodity.setAvailableCount(Integer.parseInt(newAvailableCount));
                        System.out.println("New available count for commodity " + commodityID + " is: " + newAvailableCount + ".");
                    }
                    break;
                    case "Name": {
                        System.out.println("Enter new name: ");
                        String newName = input.next();
                        input.nextLine();
                        commodity.setName(newName);
                        commodity.setID();
                        System.out.println("New name for commodity " + commodityID + " is: " + newName + ".");
                    }
                    break;
                    case "Price": {
                        System.out.println("Enter new price: ");
                        String newPrice = input.next();
                        input.nextLine();
                        commodity.setPrice(Double.parseDouble(newPrice));
                        System.out.println("New price for commodity " + commodityID + " is: " + newPrice + ".");
                    }
                    break;
                }
                break;
            }
        }
    }

    public boolean login(String inputUsername, String inputPassword) {
        if (inputUsername.equals(adminController.getAdmin().getUsername()) && inputPassword.equals(adminController.getAdmin().getPassword())) {
            return true;
        } else {
            return false;
        }
    }
    private void signupRequests(){
        int page = 1;
        boolean exit = false;
        int pageCount = (int) Math.ceil((double) adminController.getSignupRequestCount() / 10);
        while (!exit) {
            System.out.println(adminController.showSignupRequests(page));
            if (page != pageCount && page != 1) {
                System.out.println("1.Last page\t2.Next page\t3.quit\nTo accept request enter the username");
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
                    boolean bool = adminController.addConsumer(pageCommand);
                    if (bool) {
                        System.out.println("User added.");
                    } else {
                        System.out.println("Signup request not found.");
                    }
                }
                continue;
            }
            if (page == 1 && page != pageCount) {
                System.out.println("1.Next page\t2.quit\nTo accept request enter the username");
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
                    adminController.addConsumer(pageCommand);
                    continue;
                }
            }
            if (page == pageCount && page != 1) {
                System.out.println("1.last page\t2.quit\nTo accept request enter the username");
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
                    boolean bool = adminController.addConsumer(pageCommand);
                    if (bool) {
                        System.out.println("User added.");
                    } else {
                        System.out.println("Signup request not found.");
                    }
                }
            }
            if (page == 1 && page == pageCount) {
                System.out.println("1.quit\nTo accept request enter the username");
                String pageCommand = input.nextLine();
                if (Pattern.matches("\\d", pageCommand)) {
                    if (Integer.parseInt(pageCommand) == 1) {
                        exit = true;
                    }
                } else {
                    boolean bool = adminController.addConsumer(pageCommand);
                    if (bool) {
                        System.out.println("User added.");
                    } else {
                        System.out.println("Signup request not found.");
                    }
                }
            }
        }
    }
    private void showComments(){
        int page = 1;
        boolean exit = false;
        int pageCount = (int) Math.ceil((double) adminController.getCommentCount() / 10);
        while (!exit) {
            System.out.println(adminController.getAllComments(page));
            if (page != pageCount && page != 1) {
                System.out.println("1.Last page\t2.Next page\t3.quit");
                int pageCommand = input.nextInt();
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
                if (pageCommand == 1) {
                    exit = true;
                }
            }
        }
    }
    private void showConsumers(){
        int page = 1;
        boolean exit = false;
        int pageCount = (int) Math.ceil((double) adminController.getConsumerCount() / 10);
        while (!exit) {
            System.out.println(adminController.showConsumers(page));
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
    private void showCommodities(){
        int page = 1;
        boolean exit = false;
        int pageCount = (int) Math.ceil((double) adminController.getCommodityCount() / 10);
        while (!exit) {
            System.out.println(adminController.showCommodities(page));
            if (page != pageCount && page != 1) {
                System.out.println("1.Last page\t2.Next page\t3.remove commodity\t4.quit\nEnter commodity ID and commodity attribute for editing");
                String pageCommand = input.nextLine();
                if (Pattern.matches("\\d", pageCommand)) {
                    switch (Integer.parseInt(pageCommand)) {
                        case 1:
                            page--;
                            break;
                        case 2:
                            page++;
                            break;
                        case 3:{
                            System.out.println("Enter the commodity ID you wish to remove:");
                            String ID= input.nextLine();
                            adminController.removeCommodity(ID);
                        }
                        break;
                        case 4:
                            exit = true;
                            break;
                    }
                    continue;
                } else {
                    String[] commands2 = pageCommand.split(" ");
                    if (commands2.length == 2) {
                        commodityEdit(commands2[0], commands2[1]);
                        continue;
                    }
                }
            }
            if (page == 1 && page != pageCount) {
                System.out.println("1.Next page\t2.remove commodity\t3.quit\nEnter commodity ID and commodity attribute for editing");
                String pageCommand = input.nextLine();
                if (Pattern.matches("\\d", pageCommand)) {
                    switch (Integer.parseInt(pageCommand)){
                        case 1:
                            page++;
                            break;
                        case 2:
                            System.out.println("Enter the commodity ID you wish to remove:");
                            String ID= input.nextLine();
                            adminController.removeCommodity(ID);
                            break;
                        case 3:
                            exit=true;
                            break;
                    }
                } else {
                    String[] commands2 = pageCommand.split(" ");
                    if (commands2.length == 2) {
                        commodityEdit(commands2[0], commands2[1]);
                        continue;
                    }
                }
            }
            if (page == pageCount && page != 1) {
                System.out.println("1.last page\t2.remove commodity\t3.quit\nEnter commodity ID and commodity attribute for editing");
                String pageCommand = input.nextLine();
                if (Pattern.matches("\\d", pageCommand)) {
                    switch (Integer.parseInt(pageCommand)){
                        case 1:
                            page--;
                            break;
                        case 2:
                            System.out.println("Enter the commodity ID you wish to remove:");
                            String ID= input.nextLine();
                            adminController.removeCommodity(ID);
                            break;
                        case 3:
                            exit=true;
                            break;
                    }
                } else {
                    String[] commands2 = pageCommand.split(" ");
                    if (commands2.length == 2) {
                        commodityEdit(commands2[0], commands2[1]);
                        continue;
                    }
                }
            }
            if (page == 1 && page == pageCount||adminController.getCommodities().size()==0) {
                System.out.println("1.remove commodity\t2.quit\nEnter commodity ID and commodity attribute for editing");
                String pageCommand = input.nextLine();
                if (Pattern.matches("\\d", pageCommand)) {
                    switch (Integer.parseInt(pageCommand)){
                        case 1:
                            System.out.println("Enter the commodity ID you wish to remove:");
                            String ID= input.nextLine();
                            adminController.removeCommodity(ID);
                            break;
                        case 2:
                            exit=true;
                            break;
                    }
                } else {
                    String[] commands2 = pageCommand.split(" ");
                    if (commands2.length == 2) {
                        commodityEdit(commands2[0], commands2[1]);
                    }
                }
            }
        }
    }
    private void chargeRequests(){
        int page = 1;
        boolean exit = false;
        int pageCount = (int) Math.ceil((double) adminController.getChargeRequestCount() / 10);
        while (!exit) {
            System.out.println(adminController.showChargeRequests(page));
            if (page != pageCount && page != 1) {
                System.out.println("1.Last page\t2.Next page\t3.quit\nTo accept request enter the username and requested amount");
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
                    String[] pageCommands = pageCommand.split(" ");
                    if (pageCommands.length == 2) {
                        adminController.addToBalance(pageCommands[0], Double.parseDouble(pageCommands[1]));
                        continue;
                    }
                }
            }
            if (page == 1 && page != pageCount) {
                System.out.println("1.Next page\t2.quit\nTo accept request enter the username and requested amount");
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
                    String[] pageCommands = pageCommand.split(" ");
                    if (pageCommands.length == 2) {
                        adminController.addToBalance(pageCommands[0], Double.parseDouble(pageCommands[1]));
                        continue;
                    }
                }
            }
            if (page == pageCount && page != 1) {
                System.out.println("1.last page\t2.quit\nTo accept request enter the username and requested amount");
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
                    String[] pageCommands = pageCommand.split(" ");
                    if (pageCommands.length == 2) {
                        adminController.addToBalance(pageCommands[0], Double.parseDouble(pageCommands[1]));
                        continue;
                    }
                }
            }
            if (page == 1 && page == pageCount) {
                System.out.println("1.quit\nTo accept request enter the username and requested amount");
                String pageCommand = input.nextLine();
                if (Pattern.matches("\\d", pageCommand)) {
                    if (Integer.parseInt(pageCommand) == 1) {
                        exit = true;
                    }
                } else {
                    String[] pageCommands = pageCommand.split(" ");
                    if (pageCommands.length == 2) {
                        adminController.addToBalance(pageCommands[0], Double.parseDouble(pageCommands[1]));
                    }
                }
            }
        }
    }
    private void commentRequests(){
        int page = 1;
        boolean exit = false;
        int pageCount = (int) Math.ceil((double) adminController.getCommentRequestCount() / 10);
        while (!exit) {
            System.out.println(adminController.showCommentRequests(page));
            if (page != pageCount && page != 1) {
                System.out.println("1.Last page\t2.Next page\t3.quit\tTo accept request enter the username and commodity name");
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
                    String[] pageCommands = pageCommand.split(" ");
                    if (pageCommands.length == 2) {
                        adminController.addComment(pageCommands[0], pageCommands[1]);
                        continue;
                    }
                }
            }
            if (page == 1 && page != pageCount) {
                System.out.println("1.Next page\t2.quit\tTo accept request enter the username and commodity name");
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
                    String[] pageCommands = pageCommand.split(" ");
                    if (pageCommands.length == 2) {
                        adminController.addComment(pageCommands[0], pageCommands[1]);
                        continue;
                    }
                }
            }
            if (page == pageCount && page != 1) {
                System.out.println("1.last page\t2.quit\tTo accept request enter the username and commodity name");
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
                    String[] pageCommands = pageCommand.split(" ");
                    if (pageCommands.length == 2) {
                        adminController.addComment(pageCommands[0], pageCommands[1]);
                        continue;
                    }
                }
            }
            if (page == 1 && page == pageCount) {
                System.out.println("1.quit\tTo accept request enter the username and commodity name");
                String pageCommand = input.nextLine();
                if (Pattern.matches("\\d", pageCommand)) {
                    if (Integer.parseInt(pageCommand) == 1) {
                        exit = true;
                    }
                } else {
                    String[] pageCommands = pageCommand.split(" ");
                    if (pageCommands.length == 2) {
                        adminController.addComment(pageCommands[0], pageCommands[1]);
                    }
                }
            }
        }
    }
}
