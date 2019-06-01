public class DownloaderHold extends Downloader {

    public DownloaderHold(Context context) {
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
        On on = (On) context.currentState;
        on.exitState(this);
        on.setDownloader(new DownloaderDownload(context));
    }

    @Override
    public void internetOff() {

    }

    @Override
    public void fileRequest() {

    }

    @Override
    public void downloadAborted() {
        super.downloadAborted();
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
        System.out.println("enter Downloader-Hold state");
    }

    @Override
    public void exit() {
        System.out.println("exit Downloader-Hold state");
    }
}
