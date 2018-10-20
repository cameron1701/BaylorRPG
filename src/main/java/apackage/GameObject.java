package apackage;

import java.awt.*;

public abstract class GameObject {

    protected ObjectID id;

    public GameObject(ObjectID id) {
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics graphics);

    public void setId(ObjectID id) {
        this.id = id;
    }

    public ObjectID getID() {
        return this.id;
    }
}
