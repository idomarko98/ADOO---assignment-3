public abstract class Downloader extends Astate implements IState{

    static Astate lastState;

    public Downloader(Context context) {
        super(context);
    }

    @Override
    public void downloadAborted() {
        context.percent = 0;
        context.currentDownload = -1;
        On on = (On) context.currentState;
        on.exitState(this);
        on.setDownloader(new DownloaderIdle(context));
    }
}
