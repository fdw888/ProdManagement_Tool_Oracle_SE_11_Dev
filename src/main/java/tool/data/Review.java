package tool.data;

import java.util.Comparator;

public class Review implements Comparable <Review> {

    private Rating rating;
    private String comments;

    public Rating getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }

    public Review(Rating rating, String comments) {
        this.rating = rating;
        this.comments = comments;


    }

    @Override
    public String toString() {
        return "Review{" +
                "rating=" + rating +
                ", comments='" + comments + '\'' +
                '}';
    }

    @Override
    public int compareTo(Review other) {
         return other.rating.ordinal() - this.rating.ordinal();
    }
}
