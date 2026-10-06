package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_true_for_same_object() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_returns_false_for_different_class() {
        assertFalse(team.equals("test-team"));
    }

    @Test
    public void equals_returns_true_for_same_name_and_members() {
        Team t = new Team("test-team");
        assertTrue(team.equals(t));
    }

    @Test
    public void equals_returns_false_for_same_name_and_different_members() {
        Team other = new Team("test-team");
        other.addMember("npzyzz");
        assertFalse(team.equals(other));
    }

    @Test
    public void equals_returns_false_for_different_name_and_same_members() {
        Team other = new Team("t-team");
        assertFalse(team.equals(other));
    }

    @Test
    public void hash_code_value() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }
    @Test
    public void hash_code_valueas() {
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
   
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
