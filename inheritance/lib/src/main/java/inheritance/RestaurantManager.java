package inheritance;

import java.util.HashMap;

// Creates new restaurant from a review if restaurant name doesn't already exist.
// If the restaurant does exist it will add the review like normal in the Restaurant class.

public class RestaurantManager {
  private HashMap<String, Restaurant> restaurants;

  public RestaurantManager() {
    this.restaurants = new HashMap<>();
  }

  public void addReview(Review review) {
    String restaurantName = review.restaurantName.toLowerCase();
    if (this.restaurants.containsKey(restaurantName)) {
      this.restaurants.get(restaurantName).addReview(review);
    } else {
      Restaurant newRestaurant = new Restaurant(restaurantName, review.stars, review.priceCategory);
      newRestaurant.addReview(review);
      this.restaurants.put(restaurantName, newRestaurant);
    }
  }

  public Restaurant getRestaurant(String name) {
    return this.restaurants.get(name.toLowerCase());
  }

  public void printReviews(String restaurantName) {
    restaurantName = restaurantName.toLowerCase();

    Restaurant restaurant = this.getRestaurant(restaurantName);

    if (restaurant != null) {
      for (Review review : restaurant.reviews) {
        System.out.println(review);
      }
    } else {
      System.out.println("Restaurant not found.");
    }
  }

}
