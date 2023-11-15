// Mainly used for single instance of a particular object

public class SingletonClassEarlyInitialization {

    //Early, instance will be created at load time.
    private static SingletonClass instance = new SingletonClass();

    public SingletonClass() {

    }

    public static SingletonClass getInstance() {
        return instance;
    }
}

public class SingletonClassLazyInitialization {

    //Early, instance will be created at load time.
    private static SingletonClass instance;

    private Object lock;

    public SingletonClass() {

    }

    public static SingletonClass getInstance() {
        synchronized (lock) {
            if (instance == null) {
                instance = new SingletonClassLazyInitialization();
            }
        }
        return instance;
    }
}