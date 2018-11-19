
import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.*;

public class WorkSchedule_Test_addWorkingPeriod {

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

        String[] workingEmployeesBefore = workschedule.readSchedule(2).workingEmployees;
        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));
        assertTrue(scheduleUnchanged(workingEmployeesBefore, 2));
    }

    /**
     * When endtime >= size(size of the schedule) addWorkingPeriod returns false
     */
    @Test
    public void addWorkingPeriod_Test1_part2(){
        int startTime = 18;
        int endTime = 26;

        String[] workingEmployeesBefore = workschedule.readSchedule(20).workingEmployees;
        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));
        assertTrue(scheduleUnchanged(workingEmployeesBefore, 20));
    }

    /**
     * When starttime > endtime addWorkingPeriod should return false
     */
    @Test
    public void addWorkingPeriod_Test1_part3(){
        int startTime = 18;
        int endTime = 15;

        String[] workingEmployeesBefore = workschedule.readSchedule(18).workingEmployees;
        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));
        assertTrue(scheduleUnchanged(workingEmployeesBefore, 18));
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

        String[] workingEmployeesBefore = workschedule.readSchedule(7).workingEmployees;
        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));
        assertTrue(scheduleUnchanged(workingEmployeesBefore, 7));
    }

    @Test
    public void addWorkingPeriod_Test1_part5(){
        int startTime = 5;
        int endTime = 10;
        int requiredNumber = 2;

        workschedule.setRequiredNumber(requiredNumber, startTime, endTime);
        workschedule.addWorkingPeriod(employee, startTime, endTime);

        String[] workingEmployeesBefore = workschedule.readSchedule(7).workingEmployees;
        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime)); //The method returns false, employee is already added
        assertTrue(scheduleUnchanged(workingEmployeesBefore, 7));
    }

    @Test
    public void addWorkingPeriod_Test1_part6(){
        int startTime = 5;
        int endTime = 10;
        int requiredNumber = 2;

        workschedule.setRequiredNumber(requiredNumber, startTime, endTime);

        String[] workingEmployeesBefore = workschedule.readSchedule(7).workingEmployees;

        assertTrue(workschedule.addWorkingPeriod(employee, startTime, endTime)); //The method returns true, employee is added

        assertTrue(workschedule.addWorkingPeriod(employee2, startTime, endTime)); //The method returns true, employee2 is added

        assertFalse(scheduleUnchanged(workingEmployeesBefore, 7)); //The schedule has been changed
    }

    private boolean scheduleUnchanged(String[] workingEmployeesBefore, int time) {
        return Arrays.equals(workingEmployeesBefore, workschedule.readSchedule(time).workingEmployees);
    }

}

