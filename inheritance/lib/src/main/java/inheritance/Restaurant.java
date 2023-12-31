package inheritance;

public class Restaurant extends Business {

  public Restaurant(String name, double stars, String priceCategory) {
    super(name, stars, priceCategory);
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


