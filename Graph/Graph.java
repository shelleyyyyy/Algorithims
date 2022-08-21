// package Graph;

// import java.util.Map;
// import java.util.HashMap;
// public class Graph {
//     private Map<String, Vertex> vertexMap;
    
//     public Graph() {
//         vertexMap = new HashMap<>();
//     }
//     public Vertex getVertex(String vertexName) {
//         Vertex vertex = vertexMap.get(vertexName);
//         if (vertex == null) {
//                         vertex = new Vertex(vertexName);
//                         vertexMap.put(vertexName,  vertex);
//         }
//         return vertex;
//     }
//     public void addEdge(String sourceName, String destName, double cost) {
//         Vertex v = getVertex(sourceName);
//         Vertex w = getVertex(destName);
//         v.adj.add(new Edge(w, cost));
//     }
// }
