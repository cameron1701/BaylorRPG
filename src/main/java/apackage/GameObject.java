package apackage;

import java.awt.Graphics;

//import com.sun.xml.internal.bind.v2.model.core.ID;

public abstract class GameObject {

    protected ObjectID id;

    public GameObject(ObjectID id){
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics graphics);

    public void setId(ObjectID id) {
        this.id = id;
    }

    public ObjectID getID(){
        return this.id;
    }
}
