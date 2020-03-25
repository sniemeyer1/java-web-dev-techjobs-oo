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
}
