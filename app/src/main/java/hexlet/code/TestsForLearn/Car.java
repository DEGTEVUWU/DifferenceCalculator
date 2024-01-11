package hexlet.code.TestsForLearn;

//import java.io.IOException;

public class Car {
    private String color;
    private String type;

    Car(String color, String type) {
        this.color = color;
        this.type = type;
    }
    Car() {

    }
    public String getColor() {
        return this.color;
    }
    public String getType() {
        return this.type;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setType(String type) {
        this.type = type;
    }
}
