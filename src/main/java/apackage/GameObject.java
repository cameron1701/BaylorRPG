package apackage;

import java.awt.Graphics;

import com.sun.xml.internal.bind.v2.model.core.ID;

public abstract class GameObject {

    protected ID id;

    public GameObject(ID id){
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics graphics);

    public void setId(ID id) {
        this.id = id;
    }

    public ID getID(){
        return this.id;
    }
}
