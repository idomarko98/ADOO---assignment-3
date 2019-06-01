public abstract class UserMonitor extends Astate implements IState{

    public UserMonitor(Context context) {
        super(context);

        monitorFullDownload();
    }

    protected void monitorFullDownload(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(context.percent == 100) {
                        context.points++;
                        context.percent = 0;
                        System.out.println(context.points);
                    }
                }
            }
        });
        t.start();
    }
}
