package view;

import model.commodity.Commodity;
import model.user.consumer.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPanel {
    private final Scanner input;
    private ArrayList<Consumer> consumers;
    private ArrayList<Commodity> commodities;
    private ArrayList<Comment> comments;
    private ArrayList<SignupRequest> signupRequests;
    private ArrayList<CommentRequest> commentRequests;
    private ArrayList<ChargeRequest> chargeRequests;

    public MainPanel() {
        input = new Scanner(System.in);
    }

    public void mainPage() {
        int command1 = input.nextInt();
        switch (command1) {
            case 1: {
                ConsumerPage consumerPage = new ConsumerPage();
                break;
            }
            case 2: {
                AdminPage adminPage = new AdminPage(consumers,commodities,comments,signupRequests,commentRequests,chargeRequests);
                break;
            }
        }
        System.out.println("Shutting down the online shop.");
    }
}
