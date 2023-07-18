# Restaurant Thing

This Java library provides a simple way to "manage" restaurants and their reviews.

## Features

- Create and manage restaurants
- Add reviews to restaurants
- Automatically update restaurant ratings based on reviews
- Print all reviews for a specific restaurant

## Usage

### Creating a Restaurant

```java
Restaurant restaurant = new Restaurant("Sonic", 4, "$$$");

Review review = new Review("Sonic", 4, "$$$", "Great food!", "Alice");

restaurant.addReview(review);

RestaurantManager restaurantManager = new RestaurantManager();
restaurantManager.addReview(review);

restaurantManager.printReviews("Sonic");
/// Printing reviews may be broken actually. I gave up on that
```
