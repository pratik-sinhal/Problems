package GRAPH.program_N13_Graph;

import java.util.Scanner;

/**
 * Created by pratik_s on 11/10/16.
 */
public class TestGraph {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("No of vertices in the graph");
        Integer vertices = s.nextInt();

        System.out.println("Is the graph directed(y/n)");
        Character directed = s.next().charAt(0);
        Boolean isDirected = Boolean.FALSE;
        if(directed == 'y') {
            isDirected = Boolean.TRUE;
        }

        IGraph iGraph = new GraphList(vertices, isDirected);
        Graph graph = new Graph(iGraph);

        Character ans;
        Integer choice;

        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 5);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);

        do {
            System.out.println("---------------Menu-------------- ");
            System.out.println("1. add edge: ");
            System.out.println("2. adjacents to a graph: ");
            System.out.println("3. degree of a vertex: ");

            System.out.println("Enter your choice: ");
            choice = s.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Enter source vertex: ");
                    Integer u = s.nextInt();
                    System.out.println("Enter destination vertex: ");
                    Integer v = s.nextInt();
                    graph.addEdge(u, v);
                    break;

                case 2:
                    System.out.println("Enter source vertex: ");
                    u = s.nextInt();
                    System.out.println("The adjacents are: ");
                    for(Integer e: graph.adjacents(u)) {
                        System.out.println(e + ' ');
                    }
                    break;

                case 3:
                    System.out.println("Enter source vertex: ");
                    u = s.nextInt();
                    System.out.println("Degree of " + u + " is: " + graph.degree(u));
                    break;

                default:
                    System.out.println("Incorrect choice !!!");
            }

            System.out.println("Do you want to continue(y/n)?");
            ans = s.next().charAt(0);

        } while(ans != 'n');
    }
}
