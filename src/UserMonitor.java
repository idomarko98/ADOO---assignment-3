public abstract class UserMonitor extends Astate implements IState{

    private static boolean firstFull = true;
    private static boolean firstStop = true;
    public UserMonitor(Context context) {
        super(context);

        monitorFullDownload();
        monitorDownloadStop();
    }

    private void monitorDownloadStop() {
        if(firstStop){
            Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if(context.downloadStop){
                            if(context.points > 0)
                                context.points = context.points - 1;
                            context.downloadStop = false;
                            //System.out.println(context.points);
                        }
                    }
                }
            });
            th.start();
            firstStop = false;
        }
    }

    protected void monitorFullDownload(){
        if(firstFull) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (context.percent == 100) {
                            context.points = context.points + 1;
                            try {
                                Thread.sleep(1000); //sleep so the downloader can catch up
                                context.percent = 0;
                                //System.out.println(context.points);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
            t.start();
            firstFull = false;
        }
    }
}
