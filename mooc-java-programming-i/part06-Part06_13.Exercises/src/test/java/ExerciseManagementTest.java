import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class ExerciseManagementTest {
    private ExerciseManagement management;
    
    @Before
    public void initialize() {
        management = new ExerciseManagement();
    }
    
    @Test
    public void exerciseListEmptyAtBeginning() {
        assertEquals(0, management.exerciseList().size());
    }
    
    @Test
    public void addingExerciseGrowsListByOne() {
        management.add("Write a test");
        assertEquals(1, management.exerciseList().size());
    }
    
    @Test
    public void addedExerciseIsInList() {
        management.add("Write a test");
        assertTrue(management.exerciseList().contains("Write a test"));
    }
    
    @Test
    public void exerciseCanBeMarkedAsCompleted() {
        management.add("New Exercise");
        management.markAsCompleted("New Exercise");
        assertTrue(management.isCompleted("New Exercise"));
    }
    
    @Test
    public void ifNotMarkedCompletedIsNotCompleted() {
        management.add("New Exercise");
        management.markAsCompleted("New Exercise");
        assertFalse(management.isCompleted("Some Exercise"));
    }
}
