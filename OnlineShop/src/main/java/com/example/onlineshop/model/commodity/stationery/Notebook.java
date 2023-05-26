package com.example.onlineshop.model.commodity.stationery;



public class Notebook extends StationerySupply {
    private final int numberOfPages;
    private final String pageType;

    public Notebook(String name, double price, int availableCount, String country, int numberOfPages, String pageType) {
        super(name, price, availableCount, country);
        this.numberOfPages = numberOfPages;
        this.pageType = pageType;
    }

    public String getPageType() {
        return pageType;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String toString() {
        return super.toString() + " Number of pages: " + numberOfPages + " Page type: " + pageType;
    }
}
