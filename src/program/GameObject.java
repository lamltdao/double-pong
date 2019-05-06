package program;

import program.physics.BoxCollider;
import program.renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    // static ~ quan li doi tuong
    public Renderer renderer;
    public Vector2D position;
    public Vector2D velocity;

    public BoxCollider hitBox; // = null
    public Vector2D anchor;
    public static ArrayList<GameObject> objects = new ArrayList<>();

    public GameObject() {
        objects.add(this);
        position = new Vector2D();
        velocity = new Vector2D();

        anchor = new Vector2D(0.5, 0.5);


    }

    public static <E extends GameObject> E findIntersects(Class<E> cls, BoxCollider hitBox) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if( cls.isAssignableFrom(object.getClass())
                && object.hitBox != null
                && object.hitBox.intersects(hitBox)) {
                return (E) object;
            }
        }
        return null;
    }

    public void render(Graphics g) {
        if(renderer != null) {
            renderer.render(g, this);
        }

    }

    public void run() {
        position.add(velocity);
    }
}
