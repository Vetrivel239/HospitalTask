import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.*;
import java.util.stream.*;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

public class HospitalTest {

    @Test
    public void testtotalVisitedCount() {

        Hospitalvisit hospital1 = new Hospitalvisit("Apollo","Chennai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        Hospitalvisit hospital2 = new Hospitalvisit("Apollo","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        Patient p1= new Patient(1,"vetri","Chennai",Arrays.asList(hospital1,hospital2));
        Patient p2 = new Patient(2,"vetri","Bangalore",Arrays.asList(hospital1,hospital2));
        assertEquals(8,p1.visitcount("Apollo"));
    }


    @Test
    public void testlast3daysVisit() {


        Hospitalvisit hospital1 = new Hospitalvisit("Apollo","Chennai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        Hospitalvisit hospital2 = new Hospitalvisit("Apollo","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        Patient p1 = new Patient(2,"vetri","Chennai",Arrays.asList(hospital1,hospital2));
        Patient p = new Patient(1,"vetri","Bangalore",Arrays.asList(hospital1,hospital2));
        assertEquals(2,hospital1.getlastNodaysVisit(3));
    }

    @Test
    public void testtotalvisitduringrange()
    {
        Hospitalvisit hospital1 = new Hospitalvisit("Apollo","Chennai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        LocalDate date = LocalDate.now();
        Hospitalvisit hospital2 = new Hospitalvisit("Apollo","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        Patient p1 = new Patient(1,"Vetri","Chennai",Arrays.asList(hospital1,hospital2));
        LocalDate date1 = LocalDate.now();
        Patient p = new Patient(2,"Vetri","Bangalore",Arrays.asList(hospital1,hospital2));
        assertEquals(1,hospital1.getVisitDuringAtimeRange(date.minusDays(5),date.plusDays(5)));

    }



    @Test
    public void testPatientInsideBangalore() {
        Hospitalvisit hospital_chennai = new Hospitalvisit("KMC","Chennai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        Hospitalvisit hospital_bangalore = new Hospitalvisit("Apollo","Chennai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        Patient p = new Patient(1,"vetri","Chennai",Arrays.asList(hospital_bangalore,hospital_chennai));
        Patient p2 = new Patient(2,"vetri","Bangalore",Arrays.asList(hospital_bangalore,hospital_chennai));
        Patient p1 = new Patient(3,"vetri","Goa",Arrays.asList(hospital_bangalore,hospital_chennai));
        Hospital hospital = new Hospital("Bangalore","Apollo",Arrays.asList(p,p1,p2));
        assertEquals(1,hospital.getLocationPatients("Bangalore"));
    }

    @Test
    public void testPatientInsideBangalore() {
        Hospitalvisit hospital_chennai = new Hospitalvisit("KMC","Chennai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        Hospitalvisit hospital_bangalore = new Hospitalvisit("Apollo","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        Patient p = new Patient(1,"Aravind","Chennai",Arrays.asList(hospital_bangalore,hospital_chennai));
        Patient p2 = new Patient(2,"Charan","Bangalore",Arrays.asList(hospital_bangalore,hospital_chennai));
        Patient p1 = new Patient(3,"Ram","Goa",Arrays.asList(hospital_bangalore,hospital_chennai));
        Hospital hospital = new Hospital("Bangalore","Apollo",Arrays.asList(p,p1,p2));
        assertEquals(2,hospital.getPatientsOutsideBangalore("Bangalore"));
    }


    @Test
    public void testPatientOutsideBangalore() {
        Hospitalvisit hospital_chennai = new Hospitalvisit("KMC","Chennai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        Hospitalvisit hospital_bangalore = new Hospitalvisit("Apollo","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        Patient p = new Patient(1,"Aravind","Chennai",Arrays.asList(hospital_bangalore,hospital_chennai));
        Patient p2 = new Patient(2,"Charan","Bangalore",Arrays.asList(hospital_bangalore,hospital_chennai));
        Patient p1 = new Patient(3,"Ram","Kovai",Arrays.asList(hospital_bangalore,hospital_chennai));
        Hospital hospital = new Hospital("Bangalore","Apollo",Arrays.asList(p,p1,p2));
        assertEquals(2,hospital.getPatientsOutsideBangalore("Bangalore"));
    }
    @Test
    public void testPatientRatio() {
        Hospitalvisit hospital_chennai = new Hospitalvisit("KMC","Chennai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        Hospitalvisit hospital_bangalore = new Hospitalvisit("Apollo","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        LocalDate date2 = LocalDate.now();
        Patient p = new Patient(1,"Aravind","Chennai",Arrays.asList(hospital_bangalore,hospital_chennai));
        Patient p2 = new Patient(2,"Charan","Bangalore",Arrays.asList(hospital_bangalore,hospital_chennai));
        Patient p1 = new Patient(3,"Ram","Noida",Arrays.asList(hospital_bangalore,hospital_chennai));
        Hospital hospital = new Hospital("Bangalore","Apollo",Arrays.asList(p,p1,p2));// assertEquals(3,hospital.getRatioInsideToOutside("Bangalore"));
        assertEquals(3,hospital.getRatioInsideToOutside("Bangalore"),4);
    }

    @Test
    public void testpatientvisitwithinArange() {
        Hospitalvisit hospital_chennai = new Hospitalvisit("KMC","Chennai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        Hospitalvisit hospital_bangalore = new Hospitalvisit("Apollo","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,26),LocalDate.of(2021,6,20),LocalDate.of(2021,3,30)));
        Patient p = new Patient(1,"Aravind","Chennai",Arrays.asList(hospital_bangalore,hospital_chennai));
        Patient p2 = new Patient(2,"Charan","Bangalore",Arrays.asList(hospital_bangalore,hospital_chennai));
        Patient p1 = new Patient(3,"Ram","goa",Arrays.asList(hospital_bangalore,hospital_chennai));
        Hospital hospital = new Hospital("Bangalore", "Apollo",Arrays.asList(p,p1,p2));
        List<Patient> patients = hospital.getPatientList();
        LocalDate date_start = LocalDate.of(2021, 8, 3);
        LocalDate date_end = LocalDate.of(2021, 6, 30);
        long dates = 0;
        int i=0;
        for(Patient patient : patients) {
            dates = dates + patients.get(i).getTotalVisitWithinArange(date_start, date_end);
            i++;
        }
        assertEquals(21, dates);
    }

}