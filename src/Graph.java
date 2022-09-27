import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {

    private HashMap<Integer, graphNode> nodeMap= new HashMap<>();

    class graphNode{
        private int id;
        LinkedList<graphNode> adjacent = new LinkedList<graphNode>();
        private graphNode(int id){
            this.id = id;
        }
    }

    private graphNode getGraphNode(int id){
        return nodeMap.get(id);
    }

    public void addBranch(int source, int destination){
        graphNode s = getGraphNode(source);
        graphNode d = getGraphNode(destination);
        s.adjacent.add(d);

    }

    // Depth-first search on a graph
    public boolean hasPathDFS(int source, int destination){
        // get the nodes at the start and the end
        graphNode s = getGraphNode(source);
        graphNode d = getGraphNode(destination);

        // create a hashset to store the id of nodes that have been visited.
        HashSet<Integer> visited = new HashSet<>();

        return hasPathDFS(s, d, visited);
    }

    // recursive call for depth-first search
    public boolean hasPathDFS(graphNode source, graphNode destination, HashSet<Integer> visited){
        if(visited.contains(source.id)){
            return false;
        }

        visited.add(source.id);

        // if the node we're checking
        if(source == destination){
            return true;
        }

        for(graphNode child : source.adjacent){
            if(hasPathDFS(child, destination, visited))
                return true;
        }

        return false;
    }

    public boolean hasPathBFS(int source, int destination){
        return hasPathBFS(getGraphNode(source), getGraphNode(destination));
    }
    // Breadth-first search
    private boolean hasPathBFS(graphNode source, graphNode destination){

        // LinkedList to store the next set of nodes to be visited.
        // so teh next line in the tree basically
        LinkedList<graphNode> nextToVisit = new LinkedList<>();
        // hashset to store the nodes already visited
        HashSet<Integer> visited = new HashSet<>();

        nextToVisit.add(source);

        while(!nextToVisit.isEmpty()){

            graphNode checkingNode = nextToVisit.remove();

            if(source == destination)
                return true;

            if(visited.contains(checkingNode.id))
                continue;

            visited.add(checkingNode.id);

            for(graphNode child : source.adjacent){
                nextToVisit.add(child);
            }
        }

        return false;
    }
}


