// Basically a base interface containing the methods
// and a tree heirarcy of leaf classes and compound classes for drawing.
//

public interface Graphic {
    public void draw();
}

public class Dot implements Graphic {

    public void draw() {

    }

}

public class Circle implements Dot {

    public void draw() {

    }

}

public class CompoundGraphic implements Graphic {

    private List<Graphic> graphicList;

    public void addChildre(Graphic graphic) {
        graphicList.add(graphic);
    }

    public void removeChildren(Graphic graphic) {
        graphicList.remove(graphic);
    }

    public void draw() {

    }
}