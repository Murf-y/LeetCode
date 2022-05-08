class Solution {
    
    public class LinkedList{
        private class Node{
            int value;
            Node next;
            public Node(int i){value = i;}
        }
        private Node header;
        private Node tail;
        public LinkedList(){
            header = null;
            tail = null;
        }
        public void add(int i){
            Node n = new Node(i);
            if(tail == null){
                tail = n;
                header = n;
            }
            else{
                tail.next = n;
                tail = n;
            }
        }
        public boolean contains(int i){
            if(header == null) return false;
            Node current = header;
            while(current != null){
                if(current.value == i) return true;
                current = current.next;
            }
            return false;
        }
        
        public boolean isEmpty(){
            return header == null;
        }
    }
    public class DirectedGraph{
        private int[] vertices;
        public LinkedList[] edges;
        private int count;
        public DirectedGraph(){
            vertices = new int[5];
            edges = new LinkedList[5];
            count = 0;
        }
        
        public void increaseCapacity(){
            int[] new_vert = new int[vertices.length * 2];
            LinkedList[] new_edges = new LinkedList[vertices.length * 2];
            for(int i = 0 ; i < vertices.length; i++){
                new_vert[i] = vertices[i];
                new_edges[i] = edges[i];
            }
            vertices = new_vert;
            edges = new_edges;
        }
        public void addVertex(int u){
            if(count == vertices.length) increaseCapacity();
            vertices[count] = u;
            edges[count] = new LinkedList();
            count++;
        }
        public int find_index_of(int u){
            for(int i = 0 ; i < vertices.length; i++){
                if(vertices[i] == u) return i;
            }
            return -1;
        }
        public void addEdge(int u, int v){
            int index_of_u = find_index_of(u);
            int index_of_v = find_index_of(v);
            if(index_of_u == -1 || index_of_v == -1) return;
            edges[index_of_u].add(v);
        }
    }
    public int findJudge(int n, int[][] trust) {
        if(trust.length == 0) return n == 1? n : -1;
        else if(trust.length == 1)return trust[0][1];
        else{
            DirectedGraph graph = new DirectedGraph();
            for(int i = 1 ; i <= n; i++){
                graph.addVertex(i);
            }
            for(int i = 0; i< trust.length ; i++){
                graph.addEdge(trust[i][0], trust[i][1]);
            }
            for(int i = 0; i< graph.edges.length; i++){
                if(graph.edges[i] == null) continue;
                if(graph.edges[i].isEmpty()){
                    for(int j = 0 ; j < graph.edges.length; j++){
                        if(graph.edges[j] != null && graph.vertices[j] != graph.vertices[i]){
                            if(!graph.edges[j].contains(graph.vertices[i])){
                                return -1;
                            }
                        }
                    }
                    return graph.vertices[i];
                }
            }
            return -1;
        }
    }
}