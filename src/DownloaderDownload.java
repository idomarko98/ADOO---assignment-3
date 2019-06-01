public class DownloaderDownload extends Downloader {

    private Thread downloadThread;
    private boolean keepPercent;

    public DownloaderDownload(Context context) {
        super(context);

        download();
    }

    private void download() {
        keepPercent = true;
        downloadThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(keepPercent && context.percent < 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(context.downloadSpeed);
                    context.percent += context.downloadSpeed;
                    //System.out.println(context.percent);
                }
                if(context.percent >= 100){
                    finishDownload();
                }
            }
        });
        downloadThread.start();
    }

    private void finishDownload() {
        //context.percent = 0;
        context.currentDownload = -1;
        context.space--;
        On on = (On) context.currentState;
        on.exitState(this);
        on.setDownloader(new DownloaderIdle(context));
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
        On on = (On) context.currentState;
        on.exitState(this);
        on.setDownloader(new DownloaderHold(context));
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
        System.out.println("enter Downloader-Download state");
    }

    @Override
    public void exit() {
        keepPercent = false;
        System.out.println("exit Downloader-Download state");
    }

}
