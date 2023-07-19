package inheritance;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RestaurantTests {

  @Test
  void testRestaurantConstructor() {
    Restaurant restaurant = new Restaurant("Sonic", 4, "$$");
    assertEquals("Sonic", restaurant.name);
    assertEquals(4, restaurant.stars);
    assertEquals("$$", restaurant.priceCategory);
    assertTrue(restaurant.reviews.isEmpty());
  }

  @Test
  void testRestaurantToString() {
    Restaurant restaurant = new Restaurant("Sonic", 4, "$$");
    String expected = "Restaurant{name='Sonic', stars=4.0, priceCategory='$$', reviews=[]}";
    assertEquals(expected, restaurant.toString());
  }

  @Test
  void testReviewConstructor() {
    Review review = new Review("Sonic", 4, "$$", "Great food!", "Alice");
    assertEquals("Sonic", review.restaurantName);
    assertEquals(4, review.stars);
    assertEquals("$$", review.priceCategory);
    assertEquals("Great food!", review.body);
    assertEquals("Alice", review.author);
  }

  @Test
  void testReviewToString() {
    Review review = new Review("Sonic", 4, "$$", "Great food!", "Alice");
    String expected = "Review{Restaurant ='Sonic', Rating ='4.0, Price ='$$', Review ='Great food!', Author ='Alice'}";
    assertEquals(expected, review.toString());
  }

  @Test
  void testAddReview() {
    Restaurant restaurant = new Restaurant("Sonic", 4, "$$");
    Review review = new Review("Sonic", 4, "$$", "Great food!", "Alice");
    restaurant.addReview(review);
    assertEquals(1, restaurant.reviews.size());
    assertEquals(review, restaurant.reviews.get(0));
  }

  @Test
  void testAddReviewUpdatesStars() {
    Restaurant restaurant = new Restaurant("Sonic", 4, "$$");
    Review review1 = new Review("Sonic", 4, "$$", "Great food!", "Alice");
    Review review2 = new Review("Sonic", 5, "$$", "I got a free tater-tot in my fries!", "Bob");
    restaurant.addReview(review1);
    restaurant.addReview(review2);
    assertEquals(4.5, restaurant.stars);
  }

  @Test
  void testAddReviewUpdatesPriceCategory() {
    Restaurant restaurant = new Restaurant("Sonic", 4, "$$");
    Review review1 = new Review("Sonic", 4, "$$", "Great food!", "Alice");
    Review review2 = new Review("Sonic", 5, "$$$", "I got a free tater-tot in my fries!", "Bob");
    restaurant.addReview(review1);
    restaurant.addReview(review2);
    assertEquals("$$$", restaurant.priceCategory);
  }

}
