import java.util.Scanner;
import java.time.LocalTime;

interface Alarm {
    void setAlarm(String time);    
    void showAlarm();            
}
abstract class Weekday implements Alarm {
}
public class Monday extends Weekday {
    private String time;  

    @Override
    public void setAlarm(String time) {
        this.time = time;
    }
    @Override
    public void showAlarm() {
        LocalTime alarm = LocalTime.parse(time); 
        LocalTime now = LocalTime.now();         

        System.out.println("Current time: " + now);

        if (alarm.isAfter(now)) {
            System.out.println("I'll wake you up later!");
        } else {
            System.out.println("Alarm is set for tomorrow!");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Monday monday = new Monday();
        
        System.out.print("Enter the time for the alarm (HH:mm): ");
        String alarmTime = sc.nextLine();

        monday.setAlarm(alarmTime);
        monday.showAlarm();

        sc.close();
    }
}