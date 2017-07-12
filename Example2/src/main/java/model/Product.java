package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Created by GKM on 7/11/2017.
 * A model to represent product information.
 * Name: name of the product
 * Price: price of the product
 * UnitsSold : number of units sold
 */
public class Product {

    public Product(String Name,BigDecimal Price, int UnitsSold)
    {
        this.setName(Name);
        this.setPrice(Price);
        this.setUnitsSold(UnitsSold);
    }
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    private BigDecimal Price;

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }

    private int UnitsSold;

    public int getUnitsSold() {
        return UnitsSold;
    }

    public void setUnitsSold(int unitsSold) {
        UnitsSold = unitsSold;
    }

}
