import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;

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

    // the game board will have 50 rows and 50 columns
    public int rows = 50;
    public int cols = 50;
    public int amount = rows * cols + rows;
    public int generations = 9999999;
    public int sleep = 30;

    // list of locations of current generation
    ArrayList<Location> locList = new ArrayList<Location>();

    /**
     * Default constructor for objects of class GameOfLife
     * 
     * @post    the game will be initialized and populated with the initial state of cells
     * 
     */
    public GameOfLife()
    {
        // create the grid, of the specified size, that contains Actors
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(rows, cols);

        // create a world based on the grid
        world = new ActorWorld(grid);

        // populate the game
        populateGame();

        // display the newly constructed and populated world
        world.show();

    }

    /**
     * Constructor for test class
     * 
     * @post    the game will be initialized and populated with the initial state of cells
     * @param   nothing     a variable with the sole purpose of differentiating this constructor with the 
     *                      one without a parameter
     */
    public GameOfLife(int nothing)
    {
        // create the grid, of the specified size, that contains Actors
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(rows, cols);

        // create a world based on the grid
        world = new ActorWorld(grid);

        // the grid of Actors that maintains the state of the game
        //  (alive cells contains actors; dead cells do not)

        // create and add rocks (a type of Actor) to the three intial locations
        Rock rock1 = new Rock();
        Location loc1 = new Location(1, 1);
        grid.put(loc1, rock1);

        Rock rock2 = new Rock();
        Location loc2 = new Location(1, 2);
        grid.put(loc2, rock2);

        Rock rock3 = new Rock();
        Location loc3 = new Location(1, 3);
        grid.put(loc3, rock3);

        Rock rock4 = new Rock();
        Location loc4 = new Location(1, 4);
        grid.put(loc4, rock4);

        Rock rock5 = new Rock();
        Location loc5 = new Location(2, 0);
        grid.put(loc5, rock5);

        Rock rock6 = new Rock();
        Location loc6 = new Location(2, 5);
        grid.put(loc6, rock6);

        // display the newly constructed and populated world
        world.show();


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
                locList.add(randLoc);
            }
        }

    }

    /**
     * Generates the next generation based on the rules of the Game of Life and updates the grid
     * associated with the world
     *
     * @pre     the game has been initialized
     * @post    the world has been populated with a fresh containing the next generation
     * 
     */
    public void createNextGeneration() 
    {
        /** You will need to read the documentation for the World, Grid, and Location classes
         *      in order to implement the Game of Life algorithm and leverage the GridWorld framework.
         */

        // create the grid, of the specified size, that contains Actors
        Grid<Actor> grid = world.getGrid();

        // insert magic here...

        this.locList = new ArrayList<Location>();
        Color newColor = randColor();

        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < cols; col++)
            {
                Actor cell = getActor(row, col);
                Location locNew = new Location(row, col);
                int count = 0;
                ArrayList<Actor> neighborList = grid.getNeighbors(locNew);
                if (cell != null)
                {
                    if (neighborList.size() == 3 || neighborList.size() == 2)
                    {
                        locList.add(locNew);
                    }

                }   
                else
                {

                    for (int index = 0; index < neighborList.size(); index++)
                    {
                        if (neighborList.get(index) != null)
                        {
                            count += 1;
                        }
                    }
                    if (count == 3)
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

        world.setGrid(grid);

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
        return cols;
    }

    /**
     * Returns the list of locations in the game board
     *
     * @return    the list of the current generations locations
     */
    public ArrayList<Location> getLocations()
    {
        return locList;
    }

    /**
     * Returns a random color using r, g, b.
     *
     * @return    a random color
     */
    public Color randColor()
    {
        Random generator = new Random();
        int r = generator.nextInt(255);
        int g = generator.nextInt(255);
        int b = generator.nextInt(255);

        Color newColor = new Color(r, g, b);

        return newColor;
    }

    /**
     * Creates an instance of this class. Provides convenient execution.
     *
     */
    public static void main(String[] args) throws InterruptedException
    {
        GameOfLife game = new GameOfLife();

        for (int i = 0; i < game.generations; i++)
        {
            game.createNextGeneration();
            Thread.sleep(30);
        }

    }
}
