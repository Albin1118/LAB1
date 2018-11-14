
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

        WorkSchedule.Hour hourBefore = workschedule.readSchedule(5);
        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));
        WorkSchedule.Hour hourAfter = workschedule.readSchedule(5);
        assertTrue(scheduleUnchanged(hourBefore, hourAfter));
    }

    /**
     * When endtime >= size(size of the schedule) addWorkingPeriod returns false
     */
    @Test
    public void addWorkingPeriod_Test1_part2(){
        int startTime = 18;
        int endTime = 26;

        WorkSchedule.Hour hourBefore = workschedule.readSchedule(20);
        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));
        WorkSchedule.Hour hourAfter = workschedule.readSchedule(20);
        assertTrue(scheduleUnchanged(hourBefore, hourAfter));
    }

    /**
     * When starttime > endtime addWorkingPeriod should return false
     */
    @Test
    public void addWorkingPeriod_Test1_part3(){
        int startTime = 18;
        int endTime = 15;

        WorkSchedule.Hour hourBefore = workschedule.readSchedule(18);
        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));
        WorkSchedule.Hour hourAfter = workschedule.readSchedule(18);
        assertTrue(scheduleUnchanged(hourBefore, hourAfter));
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


        WorkSchedule.Hour hourBefore = workschedule.readSchedule(5);
        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));
        WorkSchedule.Hour hourAfter = workschedule.readSchedule(5);
        assertTrue(scheduleUnchanged(hourBefore, hourAfter));
    }

    @Test
    public void addWorkingPeriod_Test1_part5(){
        int startTime = 5;
        int endTime = 10;

        workschedule.setRequiredNumber(2, startTime, endTime);

        WorkSchedule.Hour hourBefore, hourAfter;

        ////////////////////////////////////////////
        hourBefore = workschedule.readSchedule(5);
        int requiredNumber1 = hourBefore.requiredNumber;
        String[]array1 = hourBefore.workingEmployees;

        assertTrue(workschedule.addWorkingPeriod(employee, startTime, endTime));//The method returns true and employee is added

        hourAfter = workschedule.readSchedule(5);
        int requiredNumber2 = hourAfter.requiredNumber;
        String[]array2 = hourAfter.workingEmployees;

        assertFalse(scheduleUnchanged2(requiredNumber1,requiredNumber2,array1, array2));

        ///////////////////////////////////////////
        hourBefore = workschedule.readSchedule(5);
        requiredNumber1 = hourBefore.requiredNumber;
        array1 = hourBefore.workingEmployees;

        assertFalse(workschedule.addWorkingPeriod(employee, startTime, endTime));//The method returns false, employee is already added

        hourAfter = workschedule.readSchedule(5);
        requiredNumber2 = hourAfter.requiredNumber;
        array2 = hourAfter.workingEmployees;

        assertTrue(scheduleUnchanged2(requiredNumber1, requiredNumber2, array1, array2));

        ////////////////////////////////////////////
        hourBefore = workschedule.readSchedule(5);
        requiredNumber1 = hourBefore.requiredNumber;
        array1 = hourBefore.workingEmployees;

        assertTrue(workschedule.addWorkingPeriod(employee2, startTime, endTime));////The method returns true and employee2 is added

        hourAfter = workschedule.readSchedule(5);
        requiredNumber2 = hourAfter.requiredNumber;
        array2 = hourAfter.workingEmployees;
        assertFalse(scheduleUnchanged2(requiredNumber1, requiredNumber2, array1, array2));


    }

    @Test
    public void test24(){
        int[]array1 = {1, 2, 3};
        int[]array2 = {1, 2, 3};

        String[]array11 = {"0", "1", "2"};
        String[]array22 = {"0", "1", "2"};

        String[]array111 = new String[2];
        array111[0] = new String("0");
        array111[1] = new String("1");
        String[]array222 = new String[2];
        array222[0] = new String("0");
        array222[1] = new String("1");



        assertTrue(Arrays.equals(array1, array2));
        assertTrue(Arrays.equals(array11, array22));
        assertTrue(Arrays.equals(array111, array222));


    }

    private boolean scheduleUnchanged(WorkSchedule.Hour hourBefore, WorkSchedule.Hour hourAfter ) {
        return hourBefore.requiredNumber == hourAfter.requiredNumber && Arrays.equals(hourBefore.workingEmployees, hourAfter.workingEmployees);
    }

    private boolean scheduleUnchanged2(int requiredNumber1, int requiredNumber2, String[]array1, String[]array2){
        return requiredNumber1==requiredNumber2 && Arrays.equals(array1, array2);
    }

    private boolean arrayofStringsEquals(String[]array1, String[]array2){
        if (array1.length == array2.length){
            for (int i = 0; i<array1.length; i++){
               // if(array1[i].equals(2)==0);

            }
            return true;
        }else{
            return false;
        }
    }

}

