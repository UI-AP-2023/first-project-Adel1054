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
Add Pen FaberCastell.7mm 2 5 USA Blue
Add FlashMemory SanDisk 20 6 15.4 5x1 128 3.2
Add Bicycle Domane 200 2 Trek Hybrid
Add Automobile Genesis 40000 1 Hyundai true 252
Add Pencil Panther 1.5 20 USA HB
Add Notebook Staedtler 4.5 15 Germany 150 normalPaper
Add SSD Samsung870EVO 80 5 70 2.5Inches 1000 560 530
Add PC MacBookAirM2 1300 3 1000 13.6Inches 8 intelCoreI7
Add Comestible BolognaSausage 20 8 4/4/2023 8/4/2023
 */