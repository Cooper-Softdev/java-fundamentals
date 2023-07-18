# Restaurant Thing

This Java library provides a "simple" way to "manage" restaurants and their reviews.

## Features

- Create and manage restaurants
- Add reviews to restaurants
- Automatically update restaurant ratings based on reviews
- Print all reviews for a specific restaurant

## Why?

The addReview method in the RestaurantManager adds a review to an already existing 
restaurant by retrieving the existing `Restaurant` object and calls it's `addReview` method, 
but if the restaurant doesn't exist (within the restaurant HashMap) it creates a new restaurant 
from the info contained with the review, and then adds the review to that new restaurant via 
the addReview method within the Restaurant Class. Two methods called addReview, I'm dumb I should
have named them differen't but it made since when I was working on it, and now it doesn't make sense.

### Creating a Restaurant or adding Reviews

```java
Restaurant restaurant = new Restaurant("Sonic", 4, "$$$");

Review review = new Review("Sonic", 4, "$$$", "Great food!", "Alice");

restaurant.addReview(review);

restaurantManager.printReviews("Sonic");

```
