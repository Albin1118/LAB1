
import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.*;

public class WorkSchedule_Test_addWorkingPeriod {

    private int size = 24;
    private WorkSchedule workschedule = new WorkSchedule(size);
    private String employee = "name";


    /**
     * Tests partition 1 - When all criteria are fulfilled, addWorkingPeriod() will return true and employee will
     * be added
     */
    @Test
    public void test_addWorkingPeriod_part1(){
        int startTime = 5;
        int endTime = 10;
        int requiredNumber = 2;

        workschedule.setRequiredNumber(requiredNumber, startTime, endTime);
        String[] workingEmployeesBefore = workschedule.readSchedule(7).workingEmployees;

        assertTrue(workschedule.addWorkingPeriod(employee, startTime, endTime)); //The method returns true, employee is added
        assertFalse(scheduleUnchanged(workingEmployeesBefore, 7)); //The schedule has been changed
    }

    /**
     * Border case when starttime = 0
     */
    @Test
    public void test_addWorkingPeriod_part1_border1(){
        int startTime = 0;
        int endTime = 10;
        int requiredNumber = 2;

        workschedule.setRequiredNumber(requiredNumber, startTime, endTime);
        String[] workingEmployeesBefore = workschedule.readSchedule(7).workingEmployees;

        assertTrue(workschedule.addWorkingPeriod(employee, startTime, endTime)); //The method returns true, employee is added
        assertFalse(scheduleUnchanged(workingEmployeesBefore, 7)); //The schedule has been changed
    }

    /**
     * Border case when starttime = endtime
     */
    @Test
    public void test_addWorkingPeriod_part1_border2(){
        int startTime = 10;
        int endTime = 10;
        int requiredNumber = 2;

        workschedule.setRequiredNumber(requiredNumber, startTime, endTime);
        String[] workingEmployeesBefore = workschedule.readSchedule(10).workingEmployees;

        assertTrue(workschedule.addWorkingPeriod(employee, startTime, endTime)); //The method returns true, employee is added
        assertFalse(scheduleUnchanged(workingEmployeesBefore, 10)); //The schedule has been changed
    }

    /**
     * Border case when endtime = size-1
     */
    @Test
    public void test_addWorkingPeriod_part1_border3(){
        int startTime = 10;
        int endTime = 23;
        int requiredNumber = 2;

        workschedule.setRequiredNumber(requiredNumber, startTime, endTime);
        String[] workingEmployeesBefore = workschedule.readSchedule(15).workingEmployees;

        assertTrue(workschedule.addWorkingPeriod(employee, startTime, endTime)); //The method returns true, employee is added
        assertFalse(scheduleUnchanged(workingEmployeesBefore, 15)); //The schedule has been changed
    }

    /**
     * Tests partition 2 - When starttime < 0, addWorkingPeriod returns false
     */
    @Test
    public void test_addWorkingPeriod_part2(){
        int startTime = -5;
        int endTime = 10;
        int requiredNumber = 2;

        workschedule.setRequiredNumber(requiredNumber, 0, endTime);
        String[] workingEmployeesBefore = workschedule.readSchedule(2).workingEmployees;

        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime)); // The method returns false
        assertTrue(scheduleUnchanged(workingEmployeesBefore, 2)); //Schedule is unchanged
    }

    /**
     * Border case when starttime = MIN_INT-1
     */
    @Test
    public void test_addWorkingPeriod_part2_border1(){
        int startTime = Integer.MIN_VALUE;
        int endTime = 10;
        int requiredNumber = 2;

        workschedule.setRequiredNumber(requiredNumber, 0, endTime);
        String[] workingEmployeesBefore = workschedule.readSchedule(2).workingEmployees;

        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));
        assertTrue(scheduleUnchanged(workingEmployeesBefore, 2));
    }

    /**
     * Border case when starttime = -1
     */
    @Test
    public void test_addWorkingPeriod_part2_border2(){
        int startTime = -1;
        int endTime = 10;
        int requiredNumber = 2;

        workschedule.setRequiredNumber(requiredNumber, 0, endTime);
        String[] workingEmployeesBefore = workschedule.readSchedule(2).workingEmployees;

        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));
        assertTrue(scheduleUnchanged(workingEmployeesBefore, 2));
    }

    /**
     * Tests partition 3 - When endtime >= size(size of the schedule) addWorkingPeriod returns false
     */
    @Test
    public void test_addWorkingPeriod_part3(){
        int startTime = 5;
        int endTime = 26;
        int requiredNumber = 2;

        workschedule.setRequiredNumber(requiredNumber, startTime, size-1);
        String[] workingEmployeesBefore = workschedule.readSchedule(20).workingEmployees;

        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime)); // The method returns false
        assertTrue(scheduleUnchanged(workingEmployeesBefore, 20)); //Schedule is unchanged
    }

    /**
     * Border case when endtime = size
     */
    @Test
    public void test_addWorkingPeriod_part3_border1(){
        int startTime = 5;
        int endTime = 24;
        int requiredNumber = 2;

        workschedule.setRequiredNumber(requiredNumber, startTime, size-1);
        String[] workingEmployeesBefore = workschedule.readSchedule(20).workingEmployees;

        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));
        assertTrue(scheduleUnchanged(workingEmployeesBefore, 20));
    }

    /**
     * Border case when endtime = MAX_INT
     */
    @Test
    public void test_addWorkingPeriod_part3_border2(){
        int startTime = 5;
        int endTime = Integer.MAX_VALUE;
        int requiredNumber = 2;

        workschedule.setRequiredNumber(requiredNumber, startTime, size-1);
        String[] workingEmployeesBefore = workschedule.readSchedule(20).workingEmployees;

        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));
        assertTrue(scheduleUnchanged(workingEmployeesBefore, 20));
    }

    /**
     * Tests partition 4 - When starttime > endtime, addWorkingPeriod returns false
     */
    @Test
    public void test_addWorkingPeriod_part4(){
        int startTime = 10;
        int endTime = 5;
        int requiredNumber = 2;

        workschedule.setRequiredNumber(requiredNumber, startTime, endTime);
        String[] workingEmployeesBefore = workschedule.readSchedule(10).workingEmployees;

        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime)); // The method returns false
        assertTrue(scheduleUnchanged(workingEmployeesBefore, 10)); //Schedule is unchanged
    }

    /**
     * Border case when starttime = endtime+1
     */
    @Test
    public void test_addWorkingPeriod_part4_border1(){
        int startTime = 11;
        int endTime = 10;
        int requiredNumber = 2;

        workschedule.setRequiredNumber(requiredNumber, startTime, endTime);
        String[] workingEmployeesBefore = workschedule.readSchedule(11).workingEmployees;

        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));
        assertTrue(scheduleUnchanged(workingEmployeesBefore, 11));
    }

    /**
     * Tests partition 5 - When the required number for an hour in the interval startTime--endTime is already met, addWorkingPeriod returns false
     * and schedule is unchanged
     */
    @Test
    public void test_addWorkingPeriod_part5(){
        int startTime = 5;
        int endTime = 10;
        int requiredNumber = 0;

        workschedule.setRequiredNumber(requiredNumber, startTime, endTime);
        String[] workingEmployeesBefore = workschedule.readSchedule(7).workingEmployees;

        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime)); // The method returns false
        assertTrue(scheduleUnchanged(workingEmployeesBefore, 7)); //Schedule is unchanged
    }

    /**
     * Tests partition 6 - When an employee is already added to an hour in the interval startTime--endTime,
     * addWorkingPeriod returns false
     */
    @Test
    public void test_addWorkingPeriod_part6(){
        int startTime = 5;
        int endTime = 10;
        int requiredNumber = 2;

        workschedule.setRequiredNumber(requiredNumber, startTime, endTime);
        workschedule.addWorkingPeriod(employee, startTime, endTime);
        String[] workingEmployeesBefore = workschedule.readSchedule(7).workingEmployees;

        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime)); //The method returns false, employee is already added
        assertTrue(scheduleUnchanged(workingEmployeesBefore, 7));
    }

    /**
     * Method used to check if the schedule is unchanged. If one hour is changed in the interval startTime--endTime,
     * by addWorkingPeriod(), then all hours will be changed. The schedule is therefore unchanged if the workingEmployees
     * of an hour is the same before as after.
     */
    private boolean scheduleUnchanged(String[] workingEmployeesBefore, int time) {
        return Arrays.equals(workingEmployeesBefore, workschedule.readSchedule(time).workingEmployees);
    }

}

