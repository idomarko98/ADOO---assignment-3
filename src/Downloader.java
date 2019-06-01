public abstract class Downloader extends Astate implements IState{

    static Astate lastState;

    public Downloader(Context context) {
        super(context);
    }
}
