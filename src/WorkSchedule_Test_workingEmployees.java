import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class WorkSchedule_Test_workingEmployees {

    private int size = 24;
    private WorkSchedule workschedule = new WorkSchedule(size);
    private String employee = "name";

    /**
     * Tests partition 1 - Checks that when startTime <= endTime and an employee has been added to the schedule, then
     * workingEmployees() returns an array containing the name of the employee
     */
    @Test
    public void workingEmployees_test_part1(){
        int startTime = 5;
        int endTime = 10;
        int requiredNumber = 2;
        String [] result = {employee};


        workschedule.setRequiredNumber(requiredNumber, startTime, endTime);
        workschedule.addWorkingPeriod(employee, startTime, endTime); //Adds employee to the schedule

        String[] workingEmployeesBefore = workschedule.readSchedule(7).workingEmployees;
        assertArrayEquals(workschedule.workingEmployees(startTime, endTime), result); //workingEmployees now returns an array containing employee
        assertTrue(scheduleUnchanged(workingEmployeesBefore, 7)); //Schedule is unchanged

    }

    /**
     * Tests partition 2 - Checks that when startTime > endTime, workingEmployees() returns an empty array
     */
    @Test
    public void workingEmployees_test_part2(){
        int startTime = 10;
        int endTime = 5;

        String[] workingEmployeesBefore = workschedule.readSchedule(7).workingEmployees;
        assertTrue(workschedule.workingEmployees(startTime, endTime).length == 0 ); //The array returned is empty
        assertTrue(scheduleUnchanged(workingEmployeesBefore, 7)); //Schedule is unchanged
    }

    private boolean scheduleUnchanged(String[] workingEmployeesBefore, int time) {
        return Arrays.equals(workingEmployeesBefore, workschedule.readSchedule(time).workingEmployees);
    }



}
