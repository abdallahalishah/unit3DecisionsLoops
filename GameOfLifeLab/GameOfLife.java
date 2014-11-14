import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.util.Scanner;

/**
 * Game of Life starter code. Demonstrates how to create and populate the game using the GridWorld framework.
 * Also demonstrates how to provide accessor methods to make the class testable by unit tests.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class GameOfLife
{
    // the world comprised of the grid that displays the graphics for the game
    private ActorWorld world;

    // the game board will have 5 rows and 5 columns
    public int rows = 0;
    public int cols = 0;
    public int amount = 0;
    public int generations = 9999999;
    public int sleep = 30;

    // constants for the location of the three cells initially alive
    private final int X1 = 1, Y1 = 1;
    private final int X2 = 1, Y2 = 2;
    private final int X3 = 1, Y3 = 3;
    private final int X4 = 1, Y4 = 4;
    private final int X5 = 2, Y5 = 0;
    private final int X6 = 2, Y6 = 5;

    /**
     * Default constructor for objects of class GameOfLife
     * 
     * @post    the game will be initialized and populated with the initial state of cells
     * 
     */
    public GameOfLife()
    {
        // create the grid, of the specified size, that contains Actors
        Scanner scan = new Scanner(System.in);

        System.out.println("How many rows: ");
        this.rows = scan.nextInt();

        System.out.println("How many columns: ");
        this.cols = scan.nextInt();

        this.amount = rows * cols;

        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(rows, cols);

        // create a world based on the grid
        world = new ActorWorld(grid);

        // populate the game
        populateGame();

        // display the newly constructed and populated world
        world.show();

        createNextGeneration();
    }

    /**
     * Creates the actors and inserts them into their initial starting positions in the grid
     *
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    private void populateGame()
    {
        // the grid of Actors that maintains the state of the game
        //  (alive cells contains actors; dead cells do not)
        Grid<Actor> grid = world.getGrid();
        Random gen = new Random();
        // create and add Rocks (a type of Actor) to the three intial locations

        for (int amt = 0; amt < amount; amt++)
        {
            int num1 = gen.nextInt(rows);
            int num2 = gen.nextInt(cols);
            Actor cell = getActor(num1, num2);
            if (cell == null)
            {
                Rock rock = new Rock();
                Location randLoc = new Location(num1, num2);
                grid.put(randLoc, rock);
            }
        }

    }
    /**
     * Generates the next generation based on the rules of the Game of Life and updates the grid
     * associated with the world
     *
     * @pre     the game has been initialized
     * @post    the world has been populated with a new grid containing the next generation
     * 
     */
    public void createNextGeneration() 
    {
        /** You will need to read the documentation for the World, Grid, and Location classes
         *      in order to implement the Game of Life algorithm and leverage the GridWorld framework.
         */

        // create the grid, of the specified size, that contains Actors
        Grid<Actor> grid = world.getGrid();

        try {
            Thread.sleep(sleep);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }     
        // insert magic here...
        for (int i = 0; i < generations; i++)
        {

            ArrayList<Location> locList = new ArrayList<Location>();
            Color newColor = randColor();
            
            for (int row = 0; row < rows; row++)
            {
                for (int col = 0; col < cols; col++)
                {
                    Actor cell = getActor(row, col);
                    Location locNew = new Location(row, col);
                    int countAlive = 0;
                    int countDead = 0;
                    if (cell != null)
                    {
                        ArrayList<Actor> neighborList = grid.getNeighbors(locNew);

                        for (int index = 0; index < neighborList.size(); index++)
                        {
                            if (neighborList.get(index) != null)
                            {
                                countAlive += 1;                            
                            }
                        }
                        if (countAlive == 3 || countAlive == 2)
                        {
                            locList.add(locNew);
                        }

                    }   
                    else
                    {
                        ArrayList<Actor> neighborList = grid.getNeighbors(locNew);

                        for (int index = 0; index < neighborList.size(); index++)
                        {
                            if (neighborList.get(index) != null)
                            {
                                countDead += 1;
                            }
                        }
                        if (countDead == 3)
                        {
                            locList.add(locNew);
                        }

                    }

                }
            }

            for (int row = 0; row < rows; row++)
            {
                for (int col = 0; col < cols; col++)
                {
                    Actor cell = getActor(row, col);
                    Location locNew = new Location(row, col);
                    if (cell != null)
                    {
                        grid.remove(locNew);
                    }
                }
            }

            for (int j = 0; j < locList.size(); j++)
            {
                Rock rock = new Rock(newColor);
                grid.put(locList.get(j),rock);
            }

            try {
                Thread.sleep(sleep);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }     

            world.setGrid(grid);
        }

    }

    /**
     * Returns the actor at the specified row and column. Intended to be used for unit testing.
     *
     * @param   row the row (zero-based index) of the actor to return
     * @param   col the column (zero-based index) of the actor to return
     * @pre     the grid has been created
     * @return  the actor at the specified row and column
     */
    public Actor getActor(int row, int col)
    {
        Location loc = new Location(row, col);
        Actor actor = world.getGrid().get(loc);
        return actor;
    }

    /**
     * Returns the number of rows in the game board
     *
     * @return    the number of rows in the game board
     */
    public int getNumRows()
    {
        return rows;
    }

    /**
     * Returns the number of columns in the game board
     *
     * @return    the number of columns in the game board
     */
    public int getNumCols()
    {
        return rows;
    }
    
    /**
     * Returns the number of columns in the game board
     *
     * @return    the number of columns in the game board
     */
    public Color randColor()
    {
        Random generator = new Random();
        int r = generator.nextInt(255);
        int g = generator.nextInt(255);
        int b = generator.nextInt(2);
        
        Color newColor = new Color(r, g, b);
        
        return newColor;
    }

    /**
     * Creates an instance of this class. Provides convenient execution.
     *
     */
    public static void main(String[] args)
    {
        GameOfLife game = new GameOfLife();
    }

}
