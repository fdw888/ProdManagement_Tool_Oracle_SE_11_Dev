package tool.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Product implements Rateable <Product> {

    private int id;
    private String name;
    private BigDecimal price;
    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private Rating rating;



    public Product() {
        this(0, "no name", BigDecimal.ZERO);

    }

    public Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public Product(int id, String name, BigDecimal price) {
        this(id, name, price, Rating.NOT_RATED);
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public BigDecimal getPrice() {
        return price;
    }


    public BigDecimal getDiscountRate()  {
        return  price.multiply(DISCOUNT_RATE).setScale(2, RoundingMode.HALF_UP);
    }

    public Rating getRating() {
        return rating;
    }

//   public abstract Product applyRating(Rating newRating) ;
//   // {
////      return new Product (this.id,this.name, this.price,newRating);
////   }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating.getStars() +
                ", discount=" + getDiscountRate() +
                ", bestBefore=" + getBestBefore() +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if (obj instanceof Product) {
            final Product other = (Product) obj;
            return this.id == other.id;
        }
        return false;
    }

    public LocalDate getBestBefore() {
        return LocalDate.now();

    }

}
