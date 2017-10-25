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

    public void set(Vector2D other){
        this.set(other.x , other.y);
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

    public Vector2D add(Vector2D other) {
        return add(other.x, other.y);
    }

    public void subtractBy(float x, float y) {
        this.x -= x;
        this.y -= y;
    }

    public void subtractBy(Vector2D otherVector) {
        subtractBy(otherVector.x, otherVector.y);
    }

    public Vector2D subtract(float x, float y) {
        return new Vector2D(this.x - x, this.y - y);
    }

    public Vector2D subtract(Vector2D other) {
        return subtract(other.x, other.y);
    }

    public void multiply(float number) {
        this.x *= number;
        this.y *= number;
    }

    public float lenght() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public Vector2D normalize(){
        float lenght = lenght();
        return new Vector2D(this.x / lenght, this.y / lenght);
    }

}
