package bases;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D() {
        x = 0;
        y = 0;
    }

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Vector2D clone() {
        return new Vector2D(this.x, this.y);
    }

    public void addUp(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void addUp(Vector2D other) {
        this.addUp(other.x, other.y);
    }

    public Vector2D add(float otherX, float otherY) {
        return new Vector2D(this.x + otherX, this.y + otherY);
    }

    public Vector2D add(Vector2D otherVector) {
        return new Vector2D(this.x + otherVector.x, this.y + otherVector.y);
    }

    public void subtractBy(float x, Float y) {
        this.x -= x;
        this.y -= y;
    }

    public void subtract(Vector2D otherVector) {
        this.subtractBy(otherVector.x,otherVector.y);
    }

    public void multiply(float number) {
        this.x *= number;
        this.y *= number;
    }

    public void lenght() {

    }

}
