
import org.junit.Test;
import static org.junit.Assert.*;

public class test1 {

    private int size = 24;
    private WorkSchedule workschedule = new WorkSchedule(size);
    String employee = "name";

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

}

