package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Theater extends Business {
  private List<String> movies;

  public Theater(String name, double stars, String priceCategory) {
    super(name, stars, priceCategory);
    this.movies = new ArrayList<>();
  }

  public void addMovie(String movie) {
    this.movies.add(movie);
  }

  public void removeMovie(String movie) {
    this.movies.remove(movie);
  }

  @Override
  public void addReview(Review review) {
    if (review.movie != null && !this.movies.contains(review.movie)) {
      throw new IllegalArgumentException("Movie not showing at this theater");
    }
    super.addReview(review);
  }

  @Override
  public String toString() {
    return "Theater{" +
      "name='" + name + '\'' +
      ", stars=" + stars +
      ", priceCategory='" + priceCategory + '\'' +
      ", movies=" + movies +
      ", reviews=" + reviews +
      '}';
  }
}
