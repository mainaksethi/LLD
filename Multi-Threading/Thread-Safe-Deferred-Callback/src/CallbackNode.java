public class CallbackNode {

    public CallbackNode(Long at, Callback callback) {
        this.at = at;
        this.callback = callback;
    }

    public Long at;
    public Callback callback;
}
