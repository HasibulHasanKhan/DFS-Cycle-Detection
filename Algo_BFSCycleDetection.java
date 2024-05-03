import java.util.*;

final class BFSCycleDetection {


    BFSCycleDetection() {
        detectCycle();
    }

    
    void detectCycle() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int N = scanner.nextInt(); 

        List<List<Integer>> adjList = new ArrayList<>();

   
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        System.out.println("Enter the adjacency list:");
        for (int i = 0; i < N; i++) {
            System.out.print("Adjacent nodes of node " + i + ": ");
            int count = scanner.nextInt();
            for (int j = 0; j < count; j++) {
                int neighbor = scanner.nextInt();
                adjList.get(i).add(neighbor);
            }
        }

        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false);

        boolean isCycle = false;

      
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                isCycle = detectCycleUtil(i, adjList, visited);
                if (isCycle)
                    break;
            }
        }

        if (isCycle)
            System.out.println("Graph contains a cycle.");
        else
            System.out.println("Graph doesn't contain a cycle.");

        scanner.close();
    }

  
    boolean detectCycleUtil(int src, List<List<Integer>> adjList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        int[] parent = new int[visited.length];
        Arrays.fill(parent, -1);

        visited[src] = true;
        queue.add(src);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adjList.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                    parent[v] = u;
                } else if (parent[u] != v) { 
                    return true;
                }
            }
        }
        return false;
    }
}

public class Algo_BFSCycleDetection {

    public static void main(String[] args) {
        BFSCycleDetection b = new BFSCycleDetection(); 
    }
}
