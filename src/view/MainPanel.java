package view;

import model.commodity.Commodity;
import model.user.consumer.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPanel {
    private final Scanner input;
    private final ArrayList<Consumer> consumers;
    private final ArrayList<Commodity> commodities;
    private final ArrayList<Comment> comments;
    private final ArrayList<SignupRequest> signupRequests;
    private final ArrayList<CommentRequest> commentRequests;
    private final ArrayList<ChargeRequest> chargeRequests;

    public MainPanel() {
        input = new Scanner(System.in);
        commodities=new ArrayList<>();
        chargeRequests=new ArrayList<>();
        comments=new ArrayList<>();
        consumers=new ArrayList<>();
        commentRequests=new ArrayList<>();
        signupRequests=new ArrayList<>();
    }

    public void mainPage() {
        System.out.println("1.Consumer\t2.Admin");
        int command1 = input.nextInt();
        switch (command1) {
            case 1: {
                ConsumerPage consumerPage = new ConsumerPage();
                break;
            }
            case 2: {
                AdminPanel adminPanel = new AdminPanel(consumers,commodities,comments,signupRequests,commentRequests,chargeRequests);
                while (!adminPanel.shouldExit()){
                    adminPanel.adminPage();
                }
                break;
            }
        }
    }
}
