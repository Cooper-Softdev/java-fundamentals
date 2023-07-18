package inheritance;

public class Review {
  public String body;
  public String author;
  public double stars; // Changed from double to int
  public String priceCategory;
  public String restaurantName;

  public Review(String restaurantName, double stars, String priceCategory, String body, String author) {
    if (stars < 1 || stars > 5) {
      throw new IllegalArgumentException("Stars must be an integer between 1 and 5 inclusive.");
    }
    if (!priceCategory.matches("\\$+")) {
      throw new IllegalArgumentException("Price category must be between $ and $$$$$ inclusive.");
    }
    this.restaurantName = restaurantName;
    this.stars = stars;
    this.priceCategory = priceCategory;
    this.body = body;
    this.author = author;
  }

  @Override
  public String toString() {
    return "Review{" +
      "Restaurant ='" + restaurantName + '\'' +
      ", Rating ='" + stars +
      ", Price ='" + priceCategory + '\'' +
      ", Review ='" + body + '\'' +
      ", Author ='" + author + '\'' +
      '}';
  }
}



