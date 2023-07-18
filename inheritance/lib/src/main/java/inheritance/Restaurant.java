package inheritance;

import java.util.ArrayList;
import java.util.List;
public class Restaurant {
  public String name;
  public double stars;
  public String priceCategory;
  public List<Review> reviews;

  public Restaurant(String name, double stars, String priceCategory) {
    this.name = name;
    this.stars = stars;
    this.priceCategory = priceCategory;
    this.reviews = new ArrayList<>();
  }

  public void addReview(Review review) {
    if (!this.name.equals(review.restaurantName)) {
      throw new IllegalArgumentException("Review does not match restaurant");
    }

    this.reviews.add(review);
    updateStars();
    updatePriceCategory();
  }

  private void updateStars() {
    double totalStars = 0;
    for (Review r : this.reviews) {
      totalStars += r.stars;
    }
    this.stars = Math.round((totalStars / this.reviews.size()) * 10.0) / 10.0;
  }

  private void updatePriceCategory() {
    int totalPriceCategory = 0;
    for (Review r : this.reviews) {
      totalPriceCategory += r.priceCategory.length();
    }
    int averagePriceCategory = Math.round((float)totalPriceCategory / this.reviews.size());
    this.priceCategory = new String(new char[averagePriceCategory]).replace("\0", "$");
  }

  @Override
  public String toString() {
    return "Restaurant{" +
      "name='" + name + '\'' +
      ", stars=" + stars +
      ", priceCategory='" + priceCategory + '\'' +
      ", reviews=" + reviews +
      '}';
  }
}

