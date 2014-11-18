
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import info.gridworld.actor.Actor;
import java.util.ArrayList;
import info.gridworld.grid.Location;

/**
 * The test class GameOfLifeTest.
 *
 * @author  @gcschmit
 * @version 19 July 2014
 */
public class GameOfLifeTest
{
    /**
     * Default constructor for test class GameOfLifeTest
     */
    public GameOfLifeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testInitialState() throws InterruptedException
    {
        /* expected pattern for initial state
         *  (X: alive; -: dead)
         * 
         *    0 1 2 3 4 5 6 7 8 9 
         *  0 - -  - - - - - - -
         *  1 - X X X X - - - - - 
         *  2 X - - - - X - - - -
         *  3 - - - - - - - - - - 
         *  4 - - - - - - - - - - 
         *  5 - - - - - - - - - - 
         *  6 - - - - - - - - - - 
         *  7 - - - - - - - - - - 
         *  8 - - - - - - - - - - 
         *  9 - - - - - - - - - - 
         */

        
        GameOfLife game = new GameOfLife(0);
        final int ROWS = game.getNumRows();
        final int COLS = game.getNumCols();

        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                // in this example, an alive cell has a non-null actor and a dead cell has a null actor
                Actor cell = game.getActor(row, col);

                // if the cell at the current row and col should be alive, assert that the actor is not null
                if(     (row == 1 && col == 1) ||
                (row == 1 && col == 2) ||
                (row == 1 && col == 3) ||
                (row == 1 && col == 4) ||
                (row == 2 && col == 0) ||
                (row == 2 && col == 5))
                {
                    assertNotNull("expected alive cell at (" + row + ", " + col + ")", cell);
                }
                else // else, the cell should be dead; assert that the actor is null
                {
                    assertNull("expected dead cell at (" + row + ", " + col + ")", cell);
                }
            }
        }

    }

    @Test
    public void testFinalState()
    {
        /* verify that the actual pattern matches the expected pattern after 2 generations         *  
         */

        /* expected pattern for final state
         *  (X: alive; -: dead)
         * 
         *    0 1 2 3 4 5 6 7 8 9 
         *  0 - X - - X - - - - -
         *  1 - - - - - - - - - - 
         *  2 - X - - X - - - - -
         *  3 - - X X - - - - - - 
         *  4 - - - - - - - - - - 
         *  5 - - - - - - - - - - 
         *  6 - - - - - - - - - - 
         *  7 - - - - - - - - - - 
         *  8 - - - - - - - - - - 
         *  9 - - - - - - - - - - 
         */

        GameOfLife game = new GameOfLife(0);
        final int ROWS = game.getNumRows();
        final int COLS = game.getNumCols();
        
        // Runs 2 generations of the game to be ready for checking
        for (int i = 0; i < 2; i++)
        {
            game.createNextGeneration();
            try {
                Thread.sleep(100);                 
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        
        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                // in this example, an alive cell has a non-null actor and a dead cell has a null actor
                Actor cell = game.getActor(row, col);

                // if the cell at the current row and col should be alive, assert that the actor is not null
                if(     (row == 0 && col == 1) ||
                (row == 0 && col == 4) ||
                (row == 2 && col == 1) ||
                (row == 2 && col == 4) ||
                (row == 3 && col == 2) ||
                (row == 3 && col == 3))
                {
                    assertNotNull("expected alive cell at (" + row + ", " + col + ")", cell);
                }
                else // else, the cell should be dead; assert that the actor is null
                {
                    assertNull("expected dead cell at (" + row + ", " + col + ")", cell);
                }
            }
        }

    }
}

