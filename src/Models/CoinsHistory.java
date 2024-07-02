package Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CoinsHistory {
    //variables privates to save history logs
    private List<String> logConverter;
    private List<LocalDateTime> logs;
    private DateTimeFormatter structureTimeFormatter;

    //constructor
    public CoinsHistory(){
        this.logConverter = new ArrayList<>();
        this.logs = new ArrayList<>();
        this.structureTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    }

    //To add a new conversion in the history
    public void addConversionToCoinsHistory(String conversion){
        LocalDateTime log= LocalDateTime.now();
        this.logConverter.add(conversion);
        logs.add(log);
    }

    //Show the history logs
    public void showHistory(){
        System.out.println("Conversion History: ");
        for (int i = 0; i< logConverter.size(); i++){
            String timeFormatter =logs.get(i).format(structureTimeFormatter);
            System.out.println((i+1)+ ". "+ logConverter.get(i)+"- Log: "+ timeFormatter);
        }
    }
}
