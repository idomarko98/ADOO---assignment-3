public abstract class UserMonitor extends Astate implements IState{

    private static boolean first = true;
    public UserMonitor(Context context) {
        super(context);

        monitorFullDownload();
    }

    protected void monitorFullDownload(){
        if(first) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (context.percent == 100) {
                            context.points = context.points + 1;
                            try {
                                Thread.sleep(1000); //sleep so the downloader can catch up
                                context.percent = 0;
                                System.out.println(context.points);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
            t.start();
            first = false;
        }
    }
}
