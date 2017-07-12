package model;

import org.testng.collections.Lists;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by GKM on 7/11/2017.
 * Method to calculate Nth last item in the sequence whose price is greater than given Price
 * Validations of arguments are not written.
 */
public class ProductDao {

    public Product GetSecondLastItemGreaterThan5(List<Product> products,BigDecimal valueToCompare, int count){
        Product filteredItem;
        if (products.size() <=1 || count==0 || valueToCompare.equals(null))
            return null;
        products = com.google.common.collect.Lists.reverse(products);
        filteredItem =  products.stream().filter(product ->
                    (product.getPrice().compareTo(valueToCompare) > 0)).collect(Collectors.toList()).get(count-1);

        return filteredItem;
    }
}
