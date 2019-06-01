public class DownloaderPreDownload extends Downloader {

    public DownloaderPreDownload(Context context) {
        super(context);

        doAction();
    }

    private void doAction() {
        context.setCurrentDownload(context.downloadQueue.remove());
        if(context.space <= 0){
            context.waited = false;
            On on = (On) context.currentState;
            on.exitState(this);
            on.setDownloader(new DownloaderWait(context));
        }
        else if(context.space > 0 && context.connected){
            On on = (On) context.currentState;
            on.exitState(this);
            on.setDownloader(new DownloaderDownload(context));
        }
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
        System.out.println("Enter Downloader-PreDownload state");

    }

    @Override
    public void exit() {
        System.out.println("Exit Downloader-PreDownload state");
    }

}
