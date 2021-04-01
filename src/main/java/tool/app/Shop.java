package tool.app;

import tool.data.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Locale;

public class Shop {

    public static void main(String[] args) {

        ProductManager pm = new ProductManager(Locale.GERMANY);

        pm.createProduct(333, "Cofee", BigDecimal.valueOf(2.99), Rating.FOUR_STAR);
        pm.printProductReport(333);
        pm.reviewProduct(333, Rating.FIVE_STAR, "delicious warm coffee");
        pm.reviewProduct(333, Rating.FIVE_STAR, "very good hot coffee");
        pm.reviewProduct(333, Rating.FIVE_STAR, "Serving very friendly.good hot coffee");


        pm.createProduct(111, "Cake", BigDecimal.valueOf(3.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
        pm.reviewProduct(111, Rating.ONE_STAR, "not worth the money");
        pm.reviewProduct(111, Rating.TWO_STAR, "there are definitely better cakes in town");
        pm.createProduct(234, "Cookie", BigDecimal.valueOf(1.49), Rating.FOUR_STAR, LocalDate.now().plusDays(1));
        pm.createProduct(333, "Cappucino", BigDecimal.valueOf(4.99), Rating.FIVE_STAR);
        pm.createProduct(333, "Chocolate", BigDecimal.valueOf(2.99), Rating.NOT_RATED, LocalDate.now().plusDays(2));
        pm.reviewProduct(234, Rating.TWO_STAR, "dry and not very tasty");

        pm.reviewProduct(333, Rating.FIVE_STAR, "nice hot coffee");



        Comparator<Product> ratingSorter = (p1,p2) -> p2.getRating().ordinal()-p1.getRating().ordinal();
        Comparator<Product> priceSorter = (p1,p2) -> p1.getPrice().compareTo(p2.getPrice());

        pm.printProducts(p -> p.getPrice().floatValue() <2, (p1,p2) ->p2.getRating().ordinal() - p1.getRating().ordinal());

//        pm.printProducts(ratingSorter.thenComparing(priceSorter));
//        pm.printProducts(ratingSorter.thenComparing(priceSorter).reversed());
//        //System.out.println(p4.getId() + " " + p4.getName() + " " + p4.getPrice() + " " + p4.getDiscountRate() + " " + p4.getRating().getStars());
        //System.out.println(p5.getId() + " " + p5.getName() + " " + p5.getPrice() + " " + p5.getDiscountRate() + " " + p5.getRating().getStars());


        //System.out.println(p4);
        //System.out.println(p5);
        //System.out.println(p6);
        //System.out.println(p7);
        //System.out.println(p8);
        //System.out.println(p9);

        //System.out.println(p6.equals(p7));
    }
}
