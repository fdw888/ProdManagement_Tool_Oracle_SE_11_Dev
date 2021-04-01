package tool.data;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Food extends Product {
    private LocalDate bestBefore;

    public LocalDate getBestBefore() {
        return bestBefore;

    }

     public Food(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        super(id,name,price,rating);
        this.bestBefore =bestBefore;
     }

    @Override
    public String toString() {
        return super.toString() + " , " + bestBefore;
    }

    @Override
    public BigDecimal getDiscountRate() {
        return (bestBefore.isEqual(LocalDate.now()))
                ? super.getDiscountRate() : BigDecimal.ZERO;
    }

    @Override
    public Product applyRating(Rating newRating) {
        return new Food(getId(),getName(),getPrice(),newRating,bestBefore);
    }


}
