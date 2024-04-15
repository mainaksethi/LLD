/**
 * Come up with application that can perform
 *
 * Caller identification
 * Call blocking
 * Spam Detection
 * Store users contacts
 * Search for users contacts by name and number
 */

/**
 * 1. System should be able to identify callers.
 * 2. System should be be able to block calls.
 * 3. System should be able to detect spam calls.
 * 4. System should store users contact.
 * 5. System should search for users contact by name and number.
 *
 *
 *
 * Api:
 * 1. registerContact.
 *      Contact:
 *          name, number
 * 2. SearchContactByName:
 * 3. SearchContactByNumber:
 *
 * 4. void call(Contact contact)
 *
 * // recieveCall
 *
 *
 */

/**
 * 1. Approach.
 * 1. Start with the api interface to expose apis.
 * 2. dig into each api and break into steps.
 * 3. Identify each step is taken care by a separate module and apply pattern to that module.
 * 4. For each independent functionality design a class and check if any pattern can be applied to it.
 * Popular Patterns:
 *  1. Publisher Subscriber Pattern.
 *  2. Builder Pattern.
 *  3. Decorator Pattern.
 *  4. Factory Pattern.
 *  5. Double dispatch pattern.
 *  6. Singleton Design pattern.
 *  Interview is always looking for a pattern so always try to to think of one.
 */

//public interface TrueCaller {
//
//    private CallManager callManager;
//
//    private ContactRegistry contactRegistry;
//
//    void registerContact(Contact contact);
//
//    Contact searchContactByName(String name);
//
//    Contact searchContactByNumber(String phoneNumber);
//
//    Call makeCall(Contact contact) {
//        callManager.initiateCall();
//    }
//
//}
//
//
//public class ContactRegistry {
//
//}
//
//
//public class CallManager {
//
//    // call logs, will reside with the call manager.
//
//    private PhoneOperatorFactory phoneOperatorsFactory;
//
//    private ChargeCalculator chargeCalculator;
//
//    public void initiateCall(Call call) {
//
//    }
//}
//
//
//class PhoneOperatorFactory {
//
//    public PhoneOperator getOperator(OperatorType operatorType) {
//        switch (operatorType) {
//            case Airtel:
//                return Airtel.getInstance();
//            default:
//                break;
//        }
//    }
//}
//
//public enum OperatorType {
//    Airtel,
//    Tata;
//}
//
//
//interface PhoneOperator {
//    public Integer callCharges();
//}
//
//class Airtel implements PhoneOperator {
//
//    public Integer callCharges() {
//        return null;
//    }
//
//    private static Airtel instance = new Airtel();
//
//    public static PhoneOperator getInstance() {
//        return instance;
//    }
//
//}
//
//
//class Contact {
//    String name;
//    String phoneNumber;
//
//
//
//    boolean canPickCall() {
//
//    }
//
//    boolean pickCall(Call call) {
//
//    }
//
//    void callDisconnected(Call call) {
//
//    }
//}
//
//
//class Call {
//
//    private CallManager callManager;
//
//    private Contact caller;
//
//    private Contact reciever;
//
//    public Boolean getInternational() {
//        return isInternational;
//    }
//
//    private Boolean isInternational;
//
//    public void setInternational(boolean isCallInternational) {
//
//    }
//
//    public void setIsInternational(boolean isCallInternational) {
//
//    }
//
//    public void setReciever(boolean isCallInternational) {
//
//    }
//
//
//    private Call() {
//
//    }
//    void disconnect() {
//        callManager.callDisConnected(this);
//    }
//
//    public class CallBuilder() {
//
//        private CallManager callManager;
//
//        private Contact caller;
//
//        private Contact reciever;
//
//        public CallManager getCallManager() {
//            return callManager;
//        }
//
//        public void setCallManager(CallManager callManager) {
//            this.callManager = callManager;
//        }
//
//        public Contact getCaller() {
//            return caller;
//        }
//
//        public void setCaller(Contact caller) {
//            this.caller = caller;
//        }
//
//        public Contact getReciever() {
//            return reciever;
//        }
//
//        public void setReciever(Contact reciever) {
//            this.reciever = reciever;
//        }
//
//        public CallBuilder(CallManager callManager, Contact caller, Contact reciever) {
//            this.callManager = callManager;
//            this.caller = caller;
//            this.reciever = reciever;
//        }
//
//        public void setInternational(boolean isCallInternational) {
//
//        }
//
//        public Call build() {
//            Call call = new Call();
//            // so on and so forth.
//            return call;
//        }
//    }
//
//}
//
//interface ChargeCalculator {
//    Integer getPrice(Integer currentPrice, Call call);
//}
//
//class BaseChargeCalculator {
//
//    private ChargeCalculator chargeCalculator;
//
//    private ChargeCalculator(ChargeCalculator chargeCalculator) {
//
//    }
//
//    Integer getPrice(Integer currentPrice, Call call) {
//        currentPrice =
//    }
//
//}
//
//class InternationalChargeCalculator {
//
//    private ChargeCalculator internationalChargeCalculator;
//
//    private ChargeCalculator(ChargeCalculator internationalChargeCalculator) {
//
//    }
//
//    Integer getPrice(Integer currentPrice, Call call) {
//        currentPrice = 50;
//        // if call is international apply international multiplier
//        return this.internationalChargeCalculator.getPrice(currentPrice, call);
//    }
//
//}


//new BaseChargeCalculator(new InternationalChargeCalculator());

/**
 * call()
 * 1. will notify contact and check if he can pick the call.
 * 2. Call object is created.
 *
 *
 *
 *
 */