public class DownloaderDownload extends Downloader {

    Thread downloadThread;

    public DownloaderDownload(Context context) {
        super(context);

        download();
    }

    private void download() {
        downloadThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(context.percent < 100) {
                    context.percent += context.downloadSpeed;
                    //System.out.println(context.percent);
                }
            }
        });
        downloadThread.start();
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
        On on = (On) context.currentState;
        on.exitState(this);
        on.setDownloader(new DownloaderError(context));
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
        System.out.println("Enter Downloader-Download state");
    }

    @Override
    public void exit() {
        System.out.println("Exit Downloader-Download state");
    }

}
