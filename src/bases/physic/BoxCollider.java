package bases.physic;

import bases.Vector2D;

public class BoxCollider {
    public Vector2D position;
    public float width;
    public float height;

    public BoxCollider(float width, float height){
        position = new Vector2D();
        this.width = width;
        this.height = height;
    }

    public float left(){return position.x - width/2;}

    public float right(){return  position.x + width/2;}

    public  float top(){return position.y - height/2;}

    public float bottom(){return  position.y + height/2;}

    public boolean collideWith(BoxCollider other){
        boolean xOverLap = other.right() >= this.left() && other.left() <= this.right();
        boolean yOverLap = other.bottom() >= this.top() && other.top() <= this.bottom();
        return xOverLap && yOverLap;
    }
}
