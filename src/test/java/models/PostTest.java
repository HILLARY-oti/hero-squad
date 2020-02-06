package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PostTest {

    @Test
    public void NewPostObjectGetsCorrectlyCreated_true() throws Exception {
        Post post = new Post("hero", "superPower", "weakness", 12, "squad");
        assertEquals(true, post instanceof Post);
    }

    @Test
    public void PostInstantiatesWithContent_true() throws Exception {
        Post post = new Post("Rock","leaser eyes", "death", 18, "Joker squad");
        assertEquals("hero,superPower,weakness,age,squad",post.getContent());

    }
}