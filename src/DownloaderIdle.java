public class DownloaderIdle extends Downloader{

    Thread queueListener;

    public DownloaderIdle(Context context) {
        super(context);

        setQueueListener();
        setDownloadStop();
    }

    private void setQueueListener() {
        Thread queueListenerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    //System.out.println(downloadQueue.isEmpty());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(!context.downloadQueue.isEmpty())
                        downQueueNotEmpty();
                }
            }
        });
        queueListenerThread.start();
    }

    private void setDownloadStop() {
        //doing as a thread so that system will have time to process it
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    context.downloadStop = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
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


    public void downQueueNotEmpty() {
        if(context.connected) {
            On on = (On) context.currentState;
            on.exitState(this);
            //on.setState(this, new DownloaderPreDownload(context));
            on.setDownloader(new DownloaderPreDownload(context));
        }
    }
}
