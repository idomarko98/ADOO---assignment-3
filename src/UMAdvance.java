public class UMAdvance extends UserMonitor {

    private boolean keepListening;

    public UMAdvance(Context context) {
        super(context);

        context.downloadSpeed = 1.2;

        listenToPoints();
    }

    private void listenToPoints() {
        keepListening = true;
        Thread listenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(keepListening){
                    if(context.points >= 7){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        moveToPro();
                    }
                    if(context.points < 4){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        moveToBeginner();
                    }
                }
            }
        });

        listenThread.start();
    }

    private void moveToBeginner() {
        On on = (On) context.currentState;
        on.exitState(this);
        on.setUserMonitor(new UMBeginner(context));
    }

    private void moveToPro() {
        On on = (On) context.currentState;
        on.exitState(this);
        on.setUserMonitor(new UMProfessional(context));
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
        System.out.println("enter UserMonitor-Advance state");
    }

    @Override
    public void exit() {
        keepListening = false;
        System.out.println("exit UserMonitor-Advance state");
    }
}
