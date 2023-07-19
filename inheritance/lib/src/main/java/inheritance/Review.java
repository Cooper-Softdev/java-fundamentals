package inheritance;

import java.util.Optional;

public class Review {
  public String body;
  public String author;
  public double stars;
  public String priceCategory;
  public String businessName;
  public Optional<String> movie;
  private Business business;

  public Review(Business business, double stars, String priceCategory, String body, String author, Optional<String> movie) {
    if (stars < 1 || stars > 5) {
      throw new IllegalArgumentException("Stars must be an integer between 1 and 5 inclusive.");
    }
    if (!priceCategory.matches("\\$+")) {
      throw new IllegalArgumentException("Price category must be between $ and $$$$$ inclusive.");
    }
    this.business = business;
    this.businessName = business.getName();
    this.stars = stars;
    this.priceCategory = priceCategory;
    this.body = body;
    this.author = author;
    this.movie = movie;
  }

  public Business getBusiness() {
    return this.business;
  }

  public void setBusiness(Business business) {
    this.business = business;
  }

  @Override
  public String toString() {
    return "Review{" +
      "Business ='" + businessName + '\'' +
      ", Rating ='" + stars +
      ", Price ='" + priceCategory + '\'' +
      ", Review ='" + body + '\'' +
      ", Author ='" + author + '\'' +
      ", Movie ='" + (movie.isPresent() ? movie.get() : "N/A") + '\'' +
      '}';
  }
}





