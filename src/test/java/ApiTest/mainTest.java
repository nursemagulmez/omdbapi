package ApiTest;
import org.junit.Test;

public class mainTest {
    helper apiHelper = new helper();

    String apiKey = "710b48ea";
    String movieName = "Harry Potter";
    String movieTitle = "Harry Potter and the Sorcerer's Stone";

    @Test
    public void getMovieData(){
        String movieID = apiHelper.bySearch(movieName,apiKey, movieTitle);
        String movieData = apiHelper.byIDorTitle(movieID, apiKey);

        System.out.println("Result for Movie Data: " + movieData);
    }

}
