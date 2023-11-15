// Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.

public class RoundHole {
    public Integer fits(RoundPeg peg) {
        return peg.getRadius() * 2;
    }
}

public class RoundPeg {

    private Integer radius;

    public RoundPeg(Integer radius) {
        this.radius = radius;
    }

    public Integer getRadius(RoundPeg peg) {
        return peg.radius * 2;
    }
}

// Try to fit square peg into round hole.

public class SquarePeg {

    private Integer height;

    public Integer getHeight() {
        return this.height;
    }
}

public class SquarePegAdapter extends RoundPeg {

    private Integer radius;

    private SquarePeg squarePeg;

    public SquarePegAdapter(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    public Integer getRadius() {
        Math.square_root(2)*squarePeg.getHeight();
    }
}