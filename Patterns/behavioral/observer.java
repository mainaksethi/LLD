

public interface Subscriber {
    public void update();
}

public class Publisher {

    List<Subscriber> subscriberList;

    public void addSubscriber(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscriberList.remove(subscriber);
    }

    public void onUpdate() {
        for (Subscriber subscriber: subscriberList) {
            subscriber.update();
        }
        return;
    }
}