import static spark.Spark.*;

public class App {
    public static void main(String[] args){
        get("/herosquad", (request, response) ->
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "<title>Hero Squad</title>" +
                        "<link rel='stylesheet' + href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>" +
                        "</head>" +
                        "<body>" +
                        "<h1>Hero Squad</h1>" +
                        "<p>Who is Your Hero?</p/>" +
                        "</body>" +
                        "</html>"
                );
 }
}