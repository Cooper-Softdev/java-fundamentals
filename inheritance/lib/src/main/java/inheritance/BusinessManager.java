package inheritance;

import java.util.HashMap;

public class BusinessManager {
  private HashMap<String, Business> businesses;

  public BusinessManager() {
    this.businesses = new HashMap<>();
  }

  public void addReview(Review review) {
    String businessName = review.getBusiness().getName().toLowerCase();
    if (this.businesses.containsKey(businessName)) {
      this.businesses.get(businessName).addReview(review);
    } else {
      Business newBusiness;
      switch(review.getBusinessType()) {
        case RESTAURANT:
          newBusiness = new Restaurant(businessName, review.stars, review.priceCategory);
          break;
        case SHOP:
          newBusiness = new Shop(businessName, review.stars, review.priceCategory);
          break;
        case THEATER:
          newBusiness = new Theater(businessName, review.stars, review.priceCategory);
          break;
        default:
          throw new IllegalArgumentException("Unsupported business type.");
      }
      review.setBusiness(newBusiness);
      newBusiness.addReview(review);
      this.businesses.put(businessName, newBusiness);
    }
  }
  public Business getBusiness(String name) {
    return this.businesses.get(name.toLowerCase());
  }

  public void printReviews(String businessName) {
    businessName = businessName.toLowerCase();

    Business business = this.getBusiness(businessName);

    if (business != null) {
      for (Review review : business.reviews) {
        System.out.println(review);
      }
    } else {
      System.out.println("Business not found.");
    }
  }
}


