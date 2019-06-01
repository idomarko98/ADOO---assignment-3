import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Context {

    public IState currentState;
    public boolean connected; //is connected to the internet
    public Queue<Integer>downloadQueue; //download queue
    public int space = 100; //space on the disk
    public int currentDownload;
    public boolean waited = false; //boolean rather the pre-download state waited for 4 secs or not
    public int downloadSpeed = 1; //download speed - default 1
    public int percent = 0; //percent of download
    public boolean downloadStop = false; //boolean rather a download was stopped for any reason
    public int playTime = 0; //where is the movie at

    public Context(){
        currentState = new Off(this);
        connected = true;
        downloadQueue = new ArrayDeque<>();
    }


    public void setCurrentState(IState state) {
        currentState = state;
    }

    public void exitState(){
        currentState.exit();
        currentState = null;
    }

    public void start(){
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
                    if(!downloadQueue.isEmpty())
                        handleInput("downQueueNotEmpty");
                }
            }
        });
        queueListenerThread.start();

        Thread inputThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    Scanner scanner = new Scanner(System.in);
                    String input = scanner.nextLine();
                    handleInput(input);
                }
            }
        });
        inputThread.start();
    }

    private void handleInput(String input){
        switch (input){
            case "turnOn":
                if(connected)
                    this.currentState.turnOn();
                break;
            case "turnOff":
                this.currentState.turnOff();
                break;
            case "fileRequest":
                this.currentState.fileRequest();
                break;
            case "downQueueNotEmpty":
                this.currentState.downQueueNotEmpty();
                break;
            case "setSpace":
                Scanner scanner = new Scanner(System.in);
                String number = scanner.nextLine();
                space = Integer.valueOf(number);
                break;
            case "downloadError":
                this.currentState.downloadError();
        }
    }

    public static void main(String[] args) {
        Context context = new Context();
        context.start();
    }

    public void addToQueue(int request){
        downloadQueue.add(request);
    }

    public void setCurrentDownload(int current){
        currentDownload = current;
    }
}
