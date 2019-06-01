import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Context {

    public IState currentState;
    public boolean connected; //is connected to the internet
    private Queue<Integer>downloadQueue; //download queue
    public int space = 100; //space on the disk

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
        inputThread.run();

        Thread queueListenerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(!downloadQueue.isEmpty())
                        handleInput("downQueueNotEmpty");
                }
            }
        });
        queueListenerThread.run();
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
        }
    }

    public static void main(String[] args) {
        Context context = new Context();
        context.start();
    }

    public void addToQueue(int request){
        downloadQueue.add(request);
    }
}
