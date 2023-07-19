package inheritance;

import java.util.ArrayList;
import java.util.List;

public class User {
  private String name;
  private List<Review> reviews;

  public User(String name) {
    this.name = name;
    this.reviews = new ArrayList<>();
  }

  public void addReview(Review review) {
    for (Review r : reviews) {
      if (r.getBusiness().equals(review.getBusiness())) {
        throw new IllegalArgumentException("User has already reviewed this business");
      }
    }
    reviews.add(review);
  }
}
