package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Business {
  protected String name;
  protected double stars;
  protected String priceCategory;
  protected List<Review> reviews;

  public Business(String name, double stars, String priceCategory) {
    this.name = name;
    this.stars = stars;
    this.priceCategory = priceCategory;
    this.reviews = new ArrayList<>();
  }
  public String getName() {
    return this.name;
  }
  public void addReview(Review review) {
    if (!this.name.equals(review.businessName)) {
      throw new IllegalArgumentException("Review does not match business");
    }

    this.reviews.add(review);
    updateStars();
    updatePriceCategory();
  }

  protected void updateStars() {
    double totalStars = 0;
    for (Review r : this.reviews) {
      totalStars += r.stars;
    }
    this.stars = Math.round((totalStars / this.reviews.size()) * 10.0) / 10.0;
  }

  protected void updatePriceCategory() {
    int totalPriceCategory = 0;
    for (Review r : this.reviews) {
      totalPriceCategory += r.priceCategory.length();
    }
    int averagePriceCategory = Math.round((float)totalPriceCategory / this.reviews.size());
    this.priceCategory = new String(new char[averagePriceCategory]).replace("\0", "$");
  }

  @Override
  public String toString() {
    return "Business{" +
      "name='" + name + '\'' +
      ", stars=" + stars +
      ", priceCategory='" + priceCategory + '\'' +
      ", reviews=" + reviews +
      '}';
  }
}
