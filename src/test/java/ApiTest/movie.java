package ApiTest;

public class movie {
    public String Title;
    public String Year;
    public String Released;
    public String imdbID;
    public String Type;
    public String Poster;

    @Override
    public String toString() {
        return    "title: "+ Title
                +"\nyear: "+ Year
                +"\nimdbID: "+ imdbID
                +"\ntype: "+ Type
                +"\nPoster: "+ Poster
                +"\nReleased: "+ Released;
    }
}
