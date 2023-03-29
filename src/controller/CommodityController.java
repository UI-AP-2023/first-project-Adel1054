package controller;

import model.commodity.Category;
import model.commodity.Commodity;
import model.commodity.comestible.Comestible;
import model.commodity.digitalCommodities.FlashMemory;
import model.commodity.digitalCommodities.PC;
import model.commodity.digitalCommodities.SSD;
import model.commodity.stationery.Notebook;
import model.commodity.stationery.Pen;
import model.commodity.stationery.Pencil;
import model.commodity.vehicles.Automobile;
import model.commodity.vehicles.Bicycle;

import java.util.ArrayList;

public class CommodityController {
    private final ArrayList<Commodity> commodities;

    public void addComestible(String name, double price, int availableCount, String productionDate, String expirationDate) {
        commodities.add(new Comestible(name, price, availableCount, productionDate, expirationDate));
        Commodity.addToComestibleCount();
    }

    public void addFlashMemory(String name, double price, int availableCount, double weight, String dimensions, double capacity, double usbVersion) {
        commodities.add(new FlashMemory(name, price, availableCount, weight, dimensions, capacity, usbVersion));
        Commodity.addToDigitalCount();
    }

    public void addPC(String name, double price, int availableCount, double weight, String dimensions, int ramCapacity, String cpuType) {
        commodities.add(new PC(name, price, availableCount, weight, dimensions, ramCapacity, cpuType));
        Commodity.addToDigitalCount();
    }

    public void addSSD(String name, double price, int availableCount, double weight, String dimensions, double capacity, double readSpeed, double writeSpeed) {
        commodities.add(new SSD(name, price, availableCount, weight, dimensions, capacity, readSpeed, writeSpeed));
        Commodity.addToDigitalCount();
    }

    public void addNotebook(String name, double price, int availableCount, String country, int numberOfPages, String pageType) {
        commodities.add(new Notebook(name, price, availableCount, country, numberOfPages, pageType));
        Commodity.addToStationeryCount();
    }

    public void addPen(String name, double price, int availableCount, String country, String colour) {
        commodities.add(new Pen(name, price, availableCount, country, colour));
        Commodity.addToStationeryCount();
    }

    public void addPencil(String name, double price, int availableCount, String country, Pencil.PencilType pencilType) {
        commodities.add(new Pencil(name, price, availableCount, country, pencilType));
        Commodity.addToStationeryCount();
    }

    public void addAutomobile(String name, double price, int availableCount, String companyName, boolean isAutomatic, int motorVolume) {
        commodities.add(new Automobile(name, price, availableCount, companyName, isAutomatic, motorVolume));
        Commodity.addToVehicleCount();
    }

    public void addBicycle(String name, double price, int availableCount, String companyName, Bicycle.BicycleType bicycleType) {
        commodities.add(new Bicycle(name, price, availableCount, companyName, bicycleType));
        Commodity.addToVehicleCount();
    }

    public void removeCommodity(Commodity commodity) {
        commodities.remove(commodity);
    }

    public void changeCommodityName(String ID, String newName) {
        int commodityIndex = -1;
        for (Commodity commodity : commodities) {
            if (commodity.getID().equals(ID)) {
                commodityIndex = commodities.indexOf(commodity);
            }
        }
        if (commodityIndex != -1) {
            commodities.get(commodityIndex).setName(newName);
        }
    }

    public void changeCommodityPrice(String ID, double newPrice) {
        int commodityIndex = -1;
        for (Commodity commodity : commodities) {
            if (commodity.getID().equals(ID)) {
                commodityIndex = commodities.indexOf(commodity);
            }
        }
        if (commodityIndex != -1) {
            commodities.get(commodityIndex).setPrice(newPrice);
        }
    }

    public void changeCommodityAvailableCount(String ID, int newAvailableCount) {
        int commodityIndex = -1;
        for (Commodity commodity : commodities) {
            if (commodity.getID().equals(ID)) {
                commodityIndex = commodities.indexOf(commodity);
            }
        }
        if (commodityIndex != -1) {
            commodities.get(commodityIndex).setAvailableCount(newAvailableCount);
        }
    }

    public CommodityController() {
        commodities = new ArrayList<>();
    }
}
