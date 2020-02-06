package models;

import java.util.ArrayList;

public class Post {
    private String hero;
    private String superPower;
    private String weakness;
    private int age;
    private String squad;
    private Object content;

    private static ArrayList<Post>instances=new ArrayList<>();
    public Post(String hero, String superPower, String weakness, int age, String squad) {
        this.hero = hero;
        this.superPower = superPower;
        this.weakness = weakness;
        this.age = age;
        this.squad = squad;
        this.content="hero,superPower,weakness,age,squad";
        instances.add(this);
    }

    public Object getContent() {
        return (Object) content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
    public static ArrayList<Post> getAll(){
        return instances;
    }

    public static void clearAllPosts(){
        instances.clear();
    }
}
