// Basically a base interface containing the methods and a tree heirarcy of classes containing child classes.
//

public interface Graphic {
    public void draw();
}

public class Dot extends Graphic {

}

public class Circle extends Dot {

}