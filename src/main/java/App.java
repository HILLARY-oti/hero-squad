import models.Post;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }

    public static void main(String[] args){
        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        get("/", (request, response) ->{
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(new HashMap(), "hero.hbs");
                }, new HandlebarsTemplateEngine());

        get("/hero_photos", (request, response) ->{
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(new HashMap(), "hero_photos.hbs");
        }, new HandlebarsTemplateEngine());

        get("/form", (request, response) ->{
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(new HashMap(), "form.hbs");
        }, new  HandlebarsTemplateEngine());

        get("/hero_card", (request, response) ->{
            Map<String, Object> model = new HashMap<String, Object>();

            String hero = request.queryParams("hero");
            String superPower = request.queryParams("superPower");
            String weakness = request.queryParams("weakness");
            Object age = request.queryParams("age");
            String squad = request.queryParams("squad");

            model.put("hero", hero);
            model.put("superPower", superPower);
            model.put("weakness", weakness);
            model.put("age", age);
            model.put("squad", squad);

            return new ModelAndView(model, "hero_card.hbs");
        }, new HandlebarsTemplateEngine());

        post("/posts/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            String hero = request.queryParams("hero");
            String superPower = request.queryParams("superPower");
            String weakness = request.queryParams("weakness");
            Object age = request.queryParams("age");
            String squad = request.queryParams("squad");

            request.session().attribute("hero",hero);
            request.session().attribute("superPower", superPower);
            request.session().attribute("weakness", weakness);
            request.session().attribute("age", age);
            request.session().attribute("squad", squad);

            model.put("hero", hero);
            model.put("superPower", superPower);
            model.put("weakness", weakness);
            model.put("age", age);
            model.put("squad", squad);

            return new ModelAndView(model, "hero_list.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero_list", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Post> posts = Post.getAll();
            model.put("posts", posts);

            return new ModelAndView(model, "hero_list.hbs");
        }, new HandlebarsTemplateEngine());
 }
}