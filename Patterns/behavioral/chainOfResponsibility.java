// More or less Similar to decorator.
// Only difference decorator ends at base decorator whereas chain of responsibility can break in between.


public interface BaseComponent {
    public void nextComponent(BaseComponent nextComponent);
    public void trigger();
}

public class Component1 implements BaseComponent {

    BaseComponent nextComponent;

    public void setNext(BaseComponent nextComponent) {
        this.nextComponent = nextComponent;
    }

    public void trigger() {
        // current steps
        if (nextComponent != null) {
            nextComponent.trigger();
        }
    }

}

public class Component2 implements BaseComponent {

    public void setNext(BaseComponent nextComponent) {
        this.nextComponent = nextComponent;
    }

    public void trigger() {
        // current steps
        if (nextComponent != null) {
            nextComponent.trigger();
        }
    }

}

public static void main() {
    Component1 component1 = new Component1();
    Component2 component2 = new Component2();
    component1.setNext(component2);
    component1.trigger();
}