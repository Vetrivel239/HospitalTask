import java.time.LocalDate;
import java.util.List;

public class Patient {
    private int patientID;
    private String name;
    private String location;
    private List<Hospitalvisit> hospitalvisits;

    Patient(String name, String location, List<Hospitalvisit> hospitalvisits) {
        this.patientID = patientID;
        this.name = name;
        this.location = location;
        this.hospitalvisits = hospitalvisits;
    }
    public int Visitcount(String hospitalname){
        int count=0;
        List<Hospitalvisit>hospitalvisits=this.hospitalvisits;
        for (Hospitalvisit hospitalvisit:hospitalvisits){
            if(hospitalvisit.hospitalname.equals(hospitalname))
                count = count + hospitalvisits.getTotalVisit();
        }
        return count;
    }
    public long getTotalVisitWithinArange(LocalDate date1,LocalDate date2){
        long count=0;
        for(Hospitalvisit hospitalvisit : hospitalvisits) {
            List<LocalDate> dates = hospitalvisit.getDates();
            count = count + dates.stream().filter((s) -> s.isAfter(date1) && s.isBefore(date2)).count();
        }
        return count;
    }
    public int getID(){
        return this.patientID;
    }
    public String getLocation(){
        return this.location;
    }
}
