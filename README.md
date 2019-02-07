# BBC GRADUATE TRAINEE SCHEME CODING EXERCISE
## by Daniel Lake, February 2019

The following is my solution to the Game of Life problem provided.

### Features of Solution

I built my solution in Java and it's comprised of the following four classes:

- Coordinates.java
- GameApp.java
- GameOfLife.java
- Grid.java

Originally, my first solution was confined to a 2D array and would not spread beyond the bounds specified by the input.

However, after doing more research on the problem I realised that an "infinite" solution could be created by treating the live cells as a set of coordinates and applying the rules solely to them and their neighbours, rather than iterating through a fixed sized grid.

### Coordinates
The coordinates for each cell and it's neighbours are defined within the "Coordinates" class. I decided to store these coordinates in a HashSet as their order was not important and this would improve it's efficiency when dealing with large numbers of coordinate objects compared to the 2D array.

### Game Rules
The rules of the game are applied to each living cell during each turn and rules are also applied to the dead neighbouring cells, this is implemented in the "GameOfLife" class.

### Display Grid
In order to display the result, I made a third class, "Grid", that takes a set of coordinates as a parameter and prints them to the console as "1" or "0" depending on whether they are alive or dead respectively. As the game progresses and grid expands, it also represents white space around the cells in a simple square grid to better visualise the output.

### Testing
The final class, "GameApp", is able to call methods from the other classes and should hopefully enable a user to test the code against expected results by printing to the console. As default, I've written the example provided in the exercise document to demo functionality.

## Evaluation
Apologies in advance if you feel I went beyond the scope of the original exercise by introducing a small app and grid output. I found this exercise challenging but rewarding and am grateful for the experience.

I attempted to take an object oriented approach to my solution by dividing my work into classes as I have learned it is generally considered good practice.

This, along with the basic javadoc I have provided, should hopefully lend to the readability of my code and I would like to thank you in advance for taking the time to consider me.

Many Thanks,
Dan.