package org.launchcode.techjobs_oo.Tests;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class JobTest {
    Job job1 = new Job("Web Developer", new Employer("Cerner"), new Location("Kansas City, MO"), new PositionType("Junior"), new CoreCompetency("Java"));
    Job job2 = new Job("Front END Developer", new Employer("SPRINT"), new Location("Overland Park, KS"), new PositionType("Senior"), new CoreCompetency("JavaScript"));

    //Job job3 = new Job();

    @Before
    @Test
    public void testSettingJobId(){
        assertEquals(job1.getId(), job2.getId() - 1, 0.01);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job3 instanceof Job);
    }

    @Test
    public void testJobsForEquality(){
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job4.equals(job5));
    }

    @Test
    public void displaysJobData(){
        Job job1 = new Job("Web Developer", new Employer("Cerner"), new Location("Kansas City, MO"), new PositionType("Junior"), new CoreCompetency("Java"));
        String testJob = job1.toString();
        assertTrue("it should return a string that contains a blank line before the job information", (testJob.substring(0, 1).equals("\n")));
        assertTrue("it should return a string that contains a blank line after the job information", ((testJob.substring(testJob.length() - 1).equals("\n"))));
        //System.out.println(testJob);
    }

    @Test
    public void containsLabelFollowedByField(){
        Job job1 = new Job("Web Developer", new Employer("Cerner"), new Location("Kansas City, MO"), new PositionType("Junior"), new CoreCompetency("Java"));
        String testJob = job1.toString();
        assertTrue("it should contain a label for each field followed by the data stored in that field",
                testJob.contains("ID: " + job1.getId()) &&
                        testJob.contains("Name: " + job1.getName()) &&
                        testJob.contains("Employer: " + job1.getEmployer()) &&
                        testJob.contains("Location: " + job1.getLocation()) &&
                        testJob.contains("Position: " + job1.getPositionType()) &&
                        testJob.contains("Core Competency: " + job1.getCoreCompetency())

        );
    }
    @Test
    public void emptyFieldTests(){
        Job job3 = new Job("N", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertTrue("it should display data not available if employer field is empty", job3.toString().contains("Employer: Data not available."));
        assertTrue("it should display data not available if location field is empty", job3.toString().contains("Location: Data not available."));
        assertTrue("it should display data not available if position field is empty", job3.toString().contains("Position: Data not available."));
        assertTrue("it should display data not available if core competency field is empty", job3.toString().contains("Core Competency: Data not available."));
       // assertTrue("it should display data not available if name field is empty", job3.toString().contains("Name: Data not available."));
       // System.out.println(job3);
    }

    @Test
    public void onlyIdValue(){
        Job job0 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertTrue("It should should return, “OOPS! This job does not seem to exist.”", job0.toString() == "OOPS! This job does not seem to exist.");
        //System.out.println(job0);
    }

}
