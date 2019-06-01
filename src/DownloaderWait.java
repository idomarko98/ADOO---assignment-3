public class DownloaderWait extends Downloader {

    public DownloaderWait(Context context) {
        super(context);

        if(!context.waited)
            timing();
        checkCondition();
    }

    private void checkCondition() {
        if(context.space > 0 && context.connected){
            On on = (On) context.currentState;
            on.exitState(this);
            on.setDownloader(new DownloaderDownload(context));
            context.waited = false;
        }
        else if(context.waited){
            On on = (On) context.currentState;
            context.downloadStop = true;
            on.exitState(this);
            on.setDownloader(new DownloaderIdle(context));
            context.waited = false;
        }
    }

    private void timing() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        context.waited = true;
        On on = (On) context.currentState;
        on.exitState(this);
        on.setDownloader(new DownloaderWait(context));
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
        System.out.println("Enter Downloader-Wait state");
    }

    @Override
    public void exit() {
        System.out.println("Exit Downloader-Wait state");
    }

}
