import view.MainPanel;

public class Main {
    public static void main(String[] args) {
        MainPanel mainPanel=new MainPanel();
        while(!MainPanel.shouldExit()){
            mainPanel.mainPage();
        }
    }
}
/*
2 admin admin
Add Pen pen1 2 5 USA Blue
Add FlashMemory flash1










 */