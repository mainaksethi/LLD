// Add different functionalities to heirarchy of classes
// Example: export all shapes into xml format, then into json format.
// We will be using XmlVisitor and JsonVisitor respectively in the respective classes.
// We won't have to modify the code of existing classes.

// instead of using funtion overloading like
// v.accept(Dot dot)
// v.accept(Circle circle)
//
// since most of them would be of type Shape we might end up calling accept(Shape s) method, so we use
// concept of double-dispatch, i.e. we are sending visitor to the class and calling respective method.

public class Dot {
    public void accept(Visitor v) {
        v.doForDot();
    }
}

public class Circle {
    public void accept(Visitor v) {
        v.doForCircle();
    }
}

public class Square {
    public void accept(Visitor v) {
        v.doForSquare();
    }
}

public class JsonVisitor {
    public void doForSquare() {
    }

    public void doForCircle() {
    }

    public void doForDot() {
    }
}

public class XmlVisitor {
    public void doForSquare() {
    }

    public void doForCircle() {
    }

    public void doForDot() {
    }
}

public static void main() {
    List<Shape> shapes;

    for (Shape shape: shapes) {
        shape.accept(exportVisitor);
    }
}