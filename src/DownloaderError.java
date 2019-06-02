public class DownloaderError extends Downloader {

    public DownloaderError(Context context) {
        super(context);

        startTimer();
    }

    private void startTimer() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    moveToIdle();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    private void moveToIdle() {
        //if(this == ((On)context.currentState).down)
        On on = (On) context.currentState;
        if(this != on.getDownloader())
            return;
        on.exitState(this);
        context.downloadStop = true;
        context.currentDownload = -1;
        context.percent = 0;
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
        On on = (On) context.currentState;
        on.exitState(this);
        on.setDownloader(new DownloaderDownload(context));
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
        System.out.println("enter Downloader-Error state");
    }

    @Override
    public void exit() {
        System.out.println("exit Downloader-Error state");
    }

}
