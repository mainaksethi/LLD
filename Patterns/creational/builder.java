// Mainly used for returning instance of object when multiple properties should be set.
public class CarBuilder {

    private String name;
    private String tyre;
    private String wheel;


    public CarBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CarBuilder setTyre(String tyre) {
        this.tyre = tyre;
        return this;
    }

    public CarBuilder setWheel(String wheel) {
        this.wheel = wheel;
        return this;
    }

    public Car build() {
        Car car = new Car();
    }

    private class Car {

        private String name;
        private String tyre;
        private String wheel;

        public Car() {
            return new Car(name, tyre, wheel);
        }
    }
}