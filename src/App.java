import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        runMaze();
        //runEjerciciosPD();
    }

    // private static void runEjerciciosPD() {
    //     EjerciciosPD ePd = new EjerciciosPD();
    //     System.out.println("Fibonacci Recursivo");
    //     long start = System.nanoTime();
    //     long resultado = ePd.getFibonacci(50);
    //     long end = System.nanoTime();
    //     long duration = end - start;
    //     System.out.println("Resultado = " + resultado +
    //     " en tiempo = " + duration);

    //     System.out.println("Fibonacci Recursivo Catching");
    //     start = System.nanoTime();
    //     resultado = ePd.getFibonacciPD(50);
    //     end = System.nanoTime();
    //     duration = end - start;
    //     System.out.println("Resultado = " + resultado +
    //     " en tiempo = " + duration);
    // }

    private static void runMaze() {
        boolean[][] predefinedMaze = {
            {true, true, true, true},
            {false, true, true, true},
            {true, true, false, false},
            {true, true, true, true }
        };

        Maze maze = new Maze(predefinedMaze);
        System.out.println("Laberinto cargado:");
        maze.printMaze();

        Cell start = new Cell(0, 3);
        Cell end = new Cell(3, 3);

        MazeSolver twoDirections = new MazeSolverRecursive();
        MazeSolver completeDirections = new MazeSolverRecursiveComplete();

        List<Cell> path = twoDirections.getPath(maze.getGrid(), start, end);
        List<Cell> path2 = completeDirections.getPath(maze.getGrid(), start, end);
        
        System.out.println("\nCamino Encontrado (Dos direcciones)");
        System.out.println(path);

        System.out.println("\nCamino Encontrado (Todas las direcciones)");
        System.out.println(path2);
    }
}
