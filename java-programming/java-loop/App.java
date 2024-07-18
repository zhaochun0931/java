import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



public class App {
    public static void main(String[] args) {

        try {

            while (true){

            LocalDateTime current_time = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            System.out.println("current date and time is: " + current_time.format(formatter));

            Thread.sleep(1000);


            }


        }catch (InterruptedException e){
            e.printStackTrace();
        }



    }
}
