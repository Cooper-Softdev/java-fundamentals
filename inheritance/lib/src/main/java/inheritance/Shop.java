package inheritance;

public class Shop extends Business {

  public Shop(String name, double stars, String priceCategory) {
    super(name, stars, priceCategory);
  }

  @Override
  public String toString() {
    return "Shop{" +
      "name='" + name + '\'' +
      ", stars=" + stars +
      ", priceCategory='" + priceCategory + '\'' +
      ", reviews=" + reviews +
      '}';
  }
}
