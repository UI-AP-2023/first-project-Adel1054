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
            case "Add":
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
                break;
            case "ShowConsumers": {
                int page = 1;
                boolean exit = false;
                int pageCount = (int) Math.ceil((double) adminController.getConsumerCount() / 10);
                while (!exit) {
                    System.out.println(adminController.getConsumers(page));
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
                    }
                    if (page == 1 && page != pageCount) {
                        System.out.println("1.Next page\t2.quit");
                        int pageCommand = input.nextInt();
                        if (pageCommand == 1) {
                            page++;
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
            break;
            case "ShowComments": {
                int page = 1;
                boolean exit = false;
                int pageCount = (int) Math.ceil((double) adminController.getConsumerCount() / 10);
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
                    }
                    if (page == 1 && page != pageCount) {
                        System.out.println("1.Next page\t2.quit");
                        int pageCommand = input.nextInt();
                        if (pageCommand == 1) {
                            page++;
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
            break;
            case "ShowCommodities": {
                int page = 1;
                boolean exit = false;
                int pageCount = (int) Math.ceil((double) adminController.getCommodityCount() / 10);
                while (!exit) {
                    System.out.println(adminController.getCommodities(page));
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
                    }
                    if (page == 1 && page != pageCount) {
                        System.out.println("1.Next page\t2.quit");
                        int pageCommand = input.nextInt();
                        if (pageCommand == 1) {
                            page++;
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
            break;
            case "SignupRequests": {
                int page = 1;
                boolean exit = false;
                int pageCount = (int) Math.ceil((double) adminController.getSignupRequestCount() / 10);
                while (!exit) {
                    System.out.println(adminController.getSignupRequests(page));
                    if (page != pageCount && page != 1) {
                        System.out.println("1.Last page\t2.Next page\t3.quit\nTo accept request enter the username");
                        String pageCommand = input.next();
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
                            adminController.addConsumer(pageCommand);
                        }
                    }
                    if (page == 1 && page != pageCount) {
                        System.out.println("1.Next page\t2.quit\nTo accept request enter the username");
                        String pageCommand = input.next();
                        if (Pattern.matches("\\d", pageCommand)) {
                            if (Integer.parseInt(pageCommand) == 1) {
                                page++;
                            }
                            if (Integer.parseInt(pageCommand) == 2) {
                                exit = true;
                            }
                        } else {
                            adminController.addConsumer(pageCommand);
                        }
                    }
                    if (page == pageCount && page != 1) {
                        System.out.println("1.last page\t2.quit\nTo accept request enter the username");
                        String pageCommand = input.next();
                        if (Pattern.matches("\\d", pageCommand)) {
                            if (Integer.parseInt(pageCommand) == 1) {
                                page--;
                            }
                            if (Integer.parseInt(pageCommand) == 2) {
                                exit = true;
                            }
                        } else {
                            adminController.addConsumer(pageCommand);
                        }
                    }
                    if (page == 1 && page == pageCount) {
                        System.out.println("1.quit\nTo accept request enter the username");
                        String pageCommand = input.next();
                        if (Pattern.matches("\\d", pageCommand)) {
                            if (Integer.parseInt(pageCommand) == 1) {
                                exit = true;
                            } else {
                                adminController.addConsumer(pageCommand);
                            }
                        }
                    }
                }
            }
            break;
            case "CommentRequests": {
                int page = 1;
                boolean exit = false;
                int pageCount = (int) Math.ceil((double) adminController.getCommentRequestCount() / 10);
                while (!exit) {
                    System.out.println(adminController.getCommentRequests(page));
                    if (page != pageCount && page != 1) {
                        System.out.println("1.Last page\t2.Next page\t3.quit\nTo accept request enter the username and commodity name");
                        String pageCommand = input.next();
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
                            String[] pageCommands=pageCommand.split(" ");
                            adminController.addComment(pageCommands[0],pageCommands[1]);
                        }
                    }
                    if (page == 1 && page != pageCount) {
                        System.out.println("1.Next page\t2.quit\nTo accept request enter the username and commodity name");
                        String pageCommand = input.next();
                        if (Pattern.matches("\\d", pageCommand)) {
                            if (Integer.parseInt(pageCommand) == 1) {
                                page++;
                            }
                            if (Integer.parseInt(pageCommand) == 2) {
                                exit = true;
                            }
                        } else {
                            String[] pageCommands=pageCommand.split(" ");
                            adminController.addComment(pageCommands[0],pageCommands[1]);
                        }
                    }
                    if (page == pageCount && page != 1) {
                        System.out.println("1.last page\t2.quit\nTo accept request enter the username and commodity name");
                        String pageCommand = input.nextLine();
                        if (Pattern.matches("\\d", pageCommand)) {
                            if (Integer.parseInt(pageCommand) == 1) {
                                page--;
                            }
                            if (Integer.parseInt(pageCommand) == 2) {
                                exit = true;
                            }
                        } else {
                            String[] pageCommands=pageCommand.split(" ");
                            adminController.addComment(pageCommands[0],pageCommands[1]);
                        }
                    }
                    if (page == 1 && page == pageCount) {
                        System.out.println("1.quit\nTo accept request enter the username and commodity name");
                        String pageCommand = input.next();
                        if (Pattern.matches("\\d", pageCommand)) {
                            if (Integer.parseInt(pageCommand) == 1) {
                                exit = true;
                            } else {
                                String[] pageCommands=pageCommand.split(" ");
                                adminController.addComment(pageCommands[0],pageCommands[1]);
                            }
                        }
                    }
                }
            }
            break;
            case "ChargeRequests": {
                int page = 1;
                boolean exit = false;
                int pageCount = (int) Math.ceil((double) adminController.getChargeRequestCount() / 10);
                while (!exit) {
                    System.out.println(adminController.getChargeRequests(page));
                    if (page != pageCount && page != 1) {
                        System.out.println("1.Last page\t2.Next page\t3.quit\nTo accept request enter the username and commodity name");
                        String pageCommand = input.next();
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
                            String[] pageCommands=pageCommand.split(" ");
                            adminController.addToBalance(pageCommands[0],Double.parseDouble(pageCommands[1]));
                        }
                    }
                    if (page == 1 && page != pageCount) {
                        System.out.println("1.Next page\t2.quit\nTo accept request enter the username and commodity name");
                        String pageCommand = input.next();
                        if (Pattern.matches("\\d", pageCommand)) {
                            if (Integer.parseInt(pageCommand) == 1) {
                                page++;
                            }
                            if (Integer.parseInt(pageCommand) == 2) {
                                exit = true;
                            }
                        } else {
                            String[] pageCommands=pageCommand.split(" ");
                            adminController.addToBalance(pageCommands[0],Double.parseDouble(pageCommands[1]));
                        }
                    }
                    if (page == pageCount && page != 1) {
                        System.out.println("1.last page\t2.quit\nTo accept request enter the username and commodity name");
                        String pageCommand = input.nextLine();
                        if (Pattern.matches("\\d", pageCommand)) {
                            if (Integer.parseInt(pageCommand) == 1) {
                                page--;
                            }
                            if (Integer.parseInt(pageCommand) == 2) {
                                exit = true;
                            }
                        } else {
                            String[] pageCommands=pageCommand.split(" ");
                            adminController.addToBalance(pageCommands[0],Double.parseDouble(pageCommands[1]));
                        }
                    }
                    if (page == 1 && page == pageCount) {
                        System.out.println("1.quit\nTo accept request enter the username and commodity name");
                        String pageCommand = input.next();
                        if (Pattern.matches("\\d", pageCommand)) {
                            if (Integer.parseInt(pageCommand) == 1) {
                                exit = true;
                            } else {
                                String[] pageCommands=pageCommand.split(" ");
                                adminController.addToBalance(pageCommands[0],Double.parseDouble(pageCommands[1]));
                            }
                        }
                    }
                }
            }
            break;
            case "Exit":
                exit = true;
                break;
        }
    }
    public boolean shouldExit() {
        return exit;
    }
}
