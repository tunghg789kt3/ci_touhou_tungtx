package bases;

import java.awt.*;

public class CheckRectangle {
    boolean CheckRectangle(Rectangle a, Rectangle b){
        if (a.x > b.x || a.y > b.y) {
            return CheckRectangle(a, b);
        }
        if (a.x + a.width < b.x || a.y + a.height < b.y) {
            return false;
        }
        if (a.x + a.width > b.x + b.width && a.y + a.height > b.y + b.height){
            return false;
        }
        return true;
    }
}
