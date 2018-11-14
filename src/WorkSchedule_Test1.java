
import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.*;

public class WorkSchedule_Test1 {

    private int size = 24;
    private WorkSchedule workschedule = new WorkSchedule(size);
    private String employee = "name";
    private String employee2 = "name2";

    /**
     * When starttime < 0 addWorkingPeriod returns false
     */
    @Test
    public void addWorkingPeriod_Test1_part1(){
        int startTime = -5;
        int endTime = 5;

        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));
        //Add an assert to check that the schedule is unchanged.
    }

    /**
     * When endtime >= size(size of the schedule) addWorkingPeriod returns false
     */
    @Test
    public void addWorkingPeriod_Test1_part2(){
        int startTime = 18;
        int endTime = 26;

        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));
    }

    /**
     * When starttime > endtime addWorkingPeriod should return false
     */
    @Test
    public void addWorkingPeriod_Test1_part3(){
        int startTime = 18;
        int endTime = 15;

        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));
    }

    /**
     * When the required number for an hour in the interval starttime-endtime is already met, addWorkingPeriod returns false
     * and schedule is unchanged
     */
    @Test
    public void addWorkingPeriod_Test1_part4(){
        int startTime = 5;
        int endTime = 10;
        int requiredNumber = 0;

        workschedule.setRequiredNumber(requiredNumber, startTime, endTime);


        assertTrue(workschedule.workingEmployees(startTime, endTime).length == 0);//No employees in the schedule
        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime)); //Returns false and schedule is unchanged
        assertTrue(workschedule.workingEmployees(startTime, endTime).length == 0); //No employee was added
    }

    @Test
    public void addWorkingPeriod_Test1_part5(){
        int startTime = 5;
        int endTime = 10;

        workschedule.setRequiredNumber(2, startTime, endTime);
        assertTrue(workschedule.addWorkingPeriod(employee, startTime, endTime));//The method returns true and employee is added
        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));//The method returns false, employee is already added
        assertTrue(workschedule.addWorkingPeriod(employee2, startTime, endTime));////The method returns true and employee2 is added
    }

    private boolean scheduleUnchanged(WorkSchedule.Hour hourBefore, WorkSchedule.Hour hourAfter ) {
        return hourBefore.requiredNumber == hourAfter.requiredNumber && Arrays.equals(hourBefore.workingEmployees, hourAfter.workingEmployees);
    }

}

