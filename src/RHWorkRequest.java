import java.util.Random;

public class RHWorkRequest extends RequestHandler {

    public RHWorkRequest(Context context) {
        super(context);

        addRequest();
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
        System.out.println("enter RequestHandler-WorkRequest state");
    }

    private void addRequest() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int max = 101;
                int min = 1;
                Random random = new Random();
                context.addToQueue(random.nextInt(max - min + 1) + min);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                moveToExit();
            }
        });
        t.start();
    }

    private void moveToExit() {
        On on = (On)context.currentState;
        on.exitState(this);
        on.setRequestHandler(new RHIdle(context));
    }

    @Override
    public void exit() {
        System.out.println("exit RequestHandler-WorkRequest state");
    }

}
