import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class PomodoroTimer {
    private static final int workDuration = 25 * 60;
    private static final int shortBreakDuration = 5 * 60;
    private static final int longBreakDuration = 15 * 60;
    private static final int workIntervals = 4;
    private static int intervalCount = 0;
    public static void main(String[] args) {

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (intervalCount < workIntervals){
                    System.out.println("Work interval started");
                    startTimer(workDuration);
                    System.out.println("Short break started");
                    startTimer(shortBreakDuration);
                    intervalCount++;
                }else {
                    System.out.println("work interval started");
                    startTimer(workDuration);
                    System.out.println("long break started");
                    startTimer(longBreakDuration);
                    intervalCount = 0;
                }
            }
        };
        timer.schedule(task, 0);

        System.out.println("press q to quit");

        while (true){
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")){
                timer.cancel();
                System.out.println("hadi eywallah");
                break;
            }
        }
    }
    private static void startTimer(int duration){
        try {
            Thread.sleep(duration * 1000L);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
