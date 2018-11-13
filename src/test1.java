
import org.junit.*;
import static org.junit.Assert.*;

public class test1 {

    private int size = 24;
    private WorkSchedule workschedule = new WorkSchedule(size);
    private String employee = "name";
    private String employee2 = "name2";

    @Test
    public void addWorkingPeriod_Test1_part1(){
        int startTime = -5;
        int endTime = 5;
        //WorkSchedule.Hour scheduleBefore = workschedule.readSchedule(5);

        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));
        //WorkSchedule.Hour scheduleAfter = workschedule.readSchedule(5);
        //Add an assert to check that the schedule is unchanged.
    }

    @Test
    public void addWorkingPeriod_Test1_part2(){
        int startTime = 18;
        int endTime = 15;

        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));
    }

    @Test
    public void addWorkingPeriod_Test1_part3(){
        int startTime = 18;
        int endTime = 26;

        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));
    }

    @Test
    public void addWorkingPeriod_Test1_part4(){
        int startTime = 5;
        int endTime = 10;

        workschedule.setRequiredNumber(0, startTime, endTime);
        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));
    }

    @Test
    public void addWorkingPeriod_Test1_part5(){
        int startTime = 5;
        int endTime = 10;

        workschedule.setRequiredNumber(2, startTime, endTime);
        assertTrue(workschedule.addWorkingPeriod(employee, startTime, endTime));
        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));
        assertTrue(workschedule.addWorkingPeriod(employee2, startTime, endTime));
    }

}

