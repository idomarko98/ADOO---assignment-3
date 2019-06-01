public class DownloaderIdle extends Downloader{

    public DownloaderIdle(Context context) {
        super(context);
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public void internetOn() {

    }

    @Override
    public void internetOff() {

    }

    @Override
    public void fileRequest() {

    }

    @Override
    public void downloadAborted() {

    }

    @Override
    public void downloadError() {

    }

    @Override
    public void errorFixed() {

    }

    @Override
    public void movieOn() {

    }

    @Override
    public void restartMovie() {

    }

    @Override
    public void holdMovie() {

    }

    @Override
    public void movieOff() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void entry() {
        System.out.println("Enter Downloader-Idle state");
    }

    @Override
    public void exit() {
        System.out.println("Exit Downloader-Idle state");
    }

    @Override
    public void downQueueNotEmpty() {
        if(context.connected && context.space > 0) {
            On on = (On) context.currentState;
            on.exitState(this);
            on.setState(this, new DownloaderPreDownload(context));
        }
    }
}
