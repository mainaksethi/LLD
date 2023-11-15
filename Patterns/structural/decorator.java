// Decorator Design Pattern

// Ref: https://refactoring.guhttps://refactoring.guru/design-patterns/decoratorru/design-patterns/decorator

/** We have notifiers of type:
    1. SMS Notifier
    2. Facebook Notifier
    3. Slack Notifier
 If we need Sms + Facebook, we will either extend the classes and these permutation/combination would lead to many classes.
 so we will use composition over inheritance.
**/

/**
 * Points to Note:
 * 1. Adapter provides a completely different interface for accessing an existing object.
 * On the other hand, with the Decorator pattern the interface either stays the same or gets extended.
 * In addition, Decorator supports recursive composition, which isn’t possible when you use Adapter.
 *
 */


public class BaseNotifier {

    private Notifier childNotifier;

    public BaseNotifier(Notifier childNotifier) {
        this.childNotifier = childNotifier;
    }

    public void send(String message) {
        if (childNotifier != null) {
            childNotifier.send();
        }
    }
}

public class SmsNotifier extends BaseNotifier {

    private Notifier childNotifier;

    public SmsNotifier(Notifier childNotifier) {
        this.childNotifier = childNotifier;
    }

    public void send(String message) {
        // do the action
        if (childNotifier != null) {
            childNotifier.send(message);
        }
    }
}

public class FacebookNotifier extends BaseNotifier {

    private Notifier childNotifier;

    public SmsNotifier(Notifier childNotifier) {
        this.childNotifier = childNotifier;
    }

    public void send(String message) {
        // do the action
        if (childNotifier != null) {
            childNotifier.send(message);
        }
    }
}

public class SlackNotifier extends BaseNotifier {

    private Notifier childNotifier;

    public SmsNotifier(Notifier childNotifier) {
        this.childNotifier = childNotifier;
    }

    public void send(String message) {
        // do the action
        if (childNotifier != null) {
            childNotifier.send(message);
        }
    }
}


public static void main() {
    // Creating composition at runtime.
    BaseNotifier notifier = new BaseNotifier();
    if (facebookEnabled) {
        notifier = new FacebookNotifier(notifier);
    }
    if (slackEnabled) {
        notifier = new SlackNotifier(notifier);
    }
}