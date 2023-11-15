// When there is a context object which behaves differently on state changes.

public class AudioPlayer {
    private State state;

    public AudioPlayer(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void clickLock() {
        state.clickLoad();
    }

    public void clickPlay() {
        state.clickLoad();
    }

    public void clickPrevious() {
        state.clickLoad();
    }
}

public interface State {

    private AudioPlayer player;

    public State(AudioPlayer player) {
        this.player = player;
    }
    public void clickLock();

    public void clickPlay();

    public void clickPrevious();

}

public class ClickedState implements State {
    public void clickLock() {
        if (player.playing) {
            player.changeState(new UnlockState());
        } else {
            plyer.changeState(new ReadyState());
        }
    }

    public void clickPlay() {
        state.clickLoad();
    }

    public void clickPrevious() {
        state.clickLoad();
    }
}

public interface UnlockState {
    public void clickLock() {
        ...
    }

    public void clickPlay() {
        ...
    }

    public void clickPrevious() {
        ....
    }
}

public interface ReadyState {
    public void clickLock() {
        ...
    }

    public void clickPlay() {
        ...
    }

    public void clickPrevious() {
        ....
    }
}

public static void main() {
    AudioPlayer audioPlayer = new AudioPlayer();
    State clickedState = new ClickedState(audioPlayer);
    audioPlayer.setState(clickedState);
}