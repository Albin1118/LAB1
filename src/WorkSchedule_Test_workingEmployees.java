import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class WorkSchedule_Test_workingEmployees {

    private int size = 24;
    private WorkSchedule workschedule = new WorkSchedule(size);
    private String employee1 = "name";

    /**
     * Tests partition 1. Checks that when startTime<=endTime and an employee has been added to the schedule, then
     * workingEmployees() returns an array containing the name of the employee
     */
    @Test
    public void workingEmployees_test_part1(){
        int startTime = 5;
        int endTime = 10;
        int requiredNumber = 2;
        String [] result = {employee1};


        workschedule.setRequiredNumber(requiredNumber, startTime, endTime);
        workschedule.addWorkingPeriod(employee1, startTime, endTime); //Adds employee1 to the schedule

        String[] workingEmployeesBefore = workschedule.readSchedule(7).workingEmployees;
        assertArrayEquals(workschedule.workingEmployees(startTime, endTime), result); //workingEmployees now returns an array containing employee1
        assertTrue(scheduleUnchanged(workingEmployeesBefore, 7));

    }

    /**
     * Tests partition 2. Checks that when startTime>endTime, workingEmployees() returns an empty array
     */
    @Test
    public void workingEmployees_test_part2(){
        int startTime = 10;
        int endTime = 5;

        String[] workingEmployeesBefore = workschedule.readSchedule(7).workingEmployees;
        assertTrue(workschedule.workingEmployees(startTime, endTime).length == 0 );
        assertTrue(scheduleUnchanged(workingEmployeesBefore, 7));
    }

    private boolean scheduleUnchanged(String[] workingEmployeesBefore, int time) {
        return Arrays.equals(workingEmployeesBefore, workschedule.readSchedule(time).workingEmployees);
    }



}
