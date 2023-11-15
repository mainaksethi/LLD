// Mainly used for returning object of certain type.
public class AnimalFactory {

    public class Animal {

    }

    public class Dog extends Animal {

    }

    public class Cat extends Animal {

    }

    public Animal getInstance(String name) {
        switch (name) {
            case "cat":
                return new Cat();
            case "dog":
                return new Dog();
            default:
                throw new RuntimeException();
        }
    }
}