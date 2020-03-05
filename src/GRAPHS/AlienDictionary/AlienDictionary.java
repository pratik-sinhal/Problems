package GRAPHS.AlienDictionary;

import GRAPHS.program_N11_TopologicalSort.TopologicalSort;
import GRAPHS.program_N13_Graph.Graph;
import GRAPHS.program_N13_Graph.GraphList;
import GRAPHS.program_N13_Graph.IGraph;

import java.util.ArrayList;

public class AlienDictionary {
    public static final int NUM_OF_CHARS = 26;

    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        printOrderOfCharacters(words);
    }

    private static void printOrderOfCharacters(String[] words) {
        IGraph iGraph = new GraphList(NUM_OF_CHARS);
        Graph g = new Graph(iGraph);

        String word1, word2;
        for (int i = 0; i < words.length-1; i++) {
            word1 = words[i];
            word2 = words[i+1];
            int j=0;
            while(j<word1.length() && j<word2.length()) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(c1 != c2){
                    g.addEdge(c1-'a', c2-'a');
                    break;
                }
                ++j;
            }
        }

        //removeVerticesWithNoEdges(g);
        Iterable<Integer> order = new TopologicalSort(g).order();
        order.forEach(i-> System.out.print((char)(i+'a')+" "));
    }

    /*private static void removeVerticesWithNoEdges(Graph g) {
        for (int i = 0; i < g.V(); i++) {
            if(((ArrayList)g.adjacents(i)).isEmpty()){

            }
        }
    }*/
}
