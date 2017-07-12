import enums.BrowserType;
import helper.DriverHelperFactory;
import model.Product;
import model.ProductDao;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by GKM on 7/10/2017.
 */



public class Question1 {

    private static List<Product> products;
    private static ProductDao productDao;

    @BeforeClass
    public static void Initialize() {
        productDao = new ProductDao();
    }


    @Test(priority=1)
    public void GetSecondLastItemGreaterThan5() {
        System.out.println("List of products...");
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("Coffee",new BigDecimal(3),100));
        products.add(new Product("Ball",new BigDecimal(6),200));
        products.add(new Product("Hamster cage",new BigDecimal(25),150));
        products.add(new Product("Jar of pickles",new BigDecimal(7),250));
        products.add(new Product("Pack of gum",new BigDecimal(2),400));
        products.add(new Product("Supernova poster",new BigDecimal(10),300));

        products.forEach(product ->
                System.out.println("Product: Name:" + product.getName() + "  ,Price: " + product.getPrice() + " and Units Sold: " + product.getUnitsSold()));
        System.out.println("validate Second largest as 7...");
        Assert.assertEquals(productDao.GetSecondLastItemGreaterThan5(products,new BigDecimal(5),2).getPrice(),(new BigDecimal(7)));
    }

    @Test(priority=2)
    public void GetSecondLastItemGreaterThan5WhenListHasOneItemButNotMeetingCriteria() {
        System.out.println("List of products...");
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("Coffee",new BigDecimal(3),100));

        products.forEach(product ->
                System.out.println("Product: Name:" + product.getName() + "  ,Price: " + product.getPrice() + " and Units Sold: " + product.getUnitsSold()));
        System.out.println("validate Second largest as null...");
        Assert.assertEquals(productDao.GetSecondLastItemGreaterThan5(products,new BigDecimal(5),2),null);
    }

    @Test(priority=3)
    public void GetSecondLastItemGreaterThan5WhenListHasTwoItemsButNotMeetingCriteria() {
        System.out.println("List of products...");
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("Coffee",new BigDecimal(6),100));
        products.add(new Product("Ball",new BigDecimal(7),100));

        products.forEach(product ->
                System.out.println("Product: Name:" + product.getName() + "  ,Price: " + product.getPrice() + " and Units Sold: " + product.getUnitsSold()));
        System.out.println("validate Second largest as null...");
        Assert.assertEquals(productDao.GetSecondLastItemGreaterThan5(products,new BigDecimal(5),2).getPrice(),(new BigDecimal(6)));
    }

    @Test(priority=4)
    public void ListIsEmpty() {
        System.out.println("List of products...");
        List<Product> products = new ArrayList<Product>();


        products.forEach(product ->
                System.out.println("Product: Name:" + product.getName() + "  ,Price: " + product.getPrice() + " and Units Sold: " + product.getUnitsSold()));
        System.out.println("validate Second largest as null...");
        Assert.assertEquals(productDao.GetSecondLastItemGreaterThan5(products,new BigDecimal(5),2),null);
    }


    @Test(priority=5)
    public void GetSecondLastItemGreaterThan5OneItemMeetingCriteria() {
        System.out.println("List of products...");
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("Coffee",new BigDecimal(6),100));


        products.forEach(product ->
                System.out.println("Product: Name:" + product.getName() + "  ,Price: " + product.getPrice() + " and Units Sold: " + product.getUnitsSold()));
        System.out.println("validate Second largest as null...");
        Assert.assertEquals(productDao.GetSecondLastItemGreaterThan5(products,new BigDecimal(5),2),null);
    }

    @AfterClass
    public  static void Cleanup() {
       //do clean objects here
    }

}
