package ad1.ss16.pa;

import java.util.*;

public class Network {

    private List<TreeSet<Integer>> listArrays;

    private boolean[] discovered;
    private boolean Cycle;
    private int numberOfVertices;

    private int[] low;
    private int[] parent;
    private int[] disc;
    boolean[] isArticulation;
    //private int time = 0;




    public Network(int n) {
        numberOfVertices = n;
        listArrays = new ArrayList<>();

        for (int i = 0; i < n; i++){
            listArrays.add(new TreeSet<>());
        }

    }

    public int numberOfNodes() {
        return listArrays.size();
    }

    public int numberOfConnections() {

        int counter = 0;
        for (int i = 0; i < listArrays.size(); i++) {
            counter += listArrays.get(i).size();
        }
        return counter / 2 ;

    }

    public void addConnection(int v, int w){
        if(v == w) return;
        if (listArrays.get(v).contains(w)) return;
        listArrays.get(v).add(w);
        listArrays.get(w).add(v);



    }

    public void addAllConnections(int v){
        for (int i = 0; i < listArrays.size(); i++){
            addConnection(v,i);
        }


    }

    public void deleteConnection(int v, int w){
        //if(!listArrays.get(v).contains(w)) return;
       // if(!listArrays.get(w).contains(v)) return;
        listArrays.get(v).remove(w);
        listArrays.get(w).remove(v);

    }

    public void deleteAllConnections(int v){
        for (int i = 0; i < listArrays.size(); i++){
            deleteConnection(v,i);
        }
    }

    public int numberOfComponents() {
       discovered = new boolean[listArrays.size()];
        int count = 0;

        for (int a = 0; a < listArrays.size(); a++){
            if (!discovered[a]){
                count++;
                DFSNUM(a,discovered);
                //BFS(a, discovered);
            }
        }

        return count;
    }

    private boolean DFSNUM(int a, boolean[] discovered) {
        discovered[a] = true;
        boolean hascircle = false;
        for (int i : listArrays.get(a)){
            if (!discovered[i]){
                DFSNUM(i,discovered);
            }else {
                hascircle = true;
            }
        }
        return hascircle;
    }

   /* private void BFS(int a, boolean[] discovered) {
        discovered[a] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);
        while (!queue.isEmpty()){
            int u = queue.poll();
            for (int b :listArrays.get(u)){
                if (!discovered[b]){
                    discovered[b] = true;
                    queue.offer(b);
                }
            }
        }


    }*/

    public boolean hasCycle() {
        Cycle = false;
        discovered = new boolean[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++){
            discovered[i] = false;
        }

        for (int a = 0; a < numberOfVertices; a++){
            if (!discovered[a]){
                hasCycle(a,-1);
            }
        }
        return Cycle;
    }
    //DFS for hasCycle.
    private void hasCycle(int begin, int parent) {
         discovered[begin] = true;
        for (int a: listArrays.get(begin)){
            if (discovered[a] && a != parent){
                Cycle = true;
            }
            if (!discovered[a]){
                hasCycle(a,begin);
            }
        }

    }

    public int minimalNumberOfConnections(int start, int end){
        return helpMinimalNumberOfConnections(start,end);
    }

    private int helpMinimalNumberOfConnections(int start, int visited) {
        if (start == visited) {return 0;}
        boolean[] discovered = new boolean[numberOfVertices];
        int[] dist = new int[numberOfVertices];
        Queue<Integer> queue = new ArrayDeque<>();

        discovered[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()){
            int a = queue.poll();
            for (int b: listArrays.get(a)){
                if (b == visited){
                    return dist[a] + 1;
                }
                if (!discovered[b]){
                    discovered[b] = true;
                    dist[b] = dist[a]+1;
                    queue.offer(b);
                }
            }
        }
        return -1;
    }




    // A recursive function that find articulation points using DFS
    // vert --> The vertex to be visited next
    // visited[] --> keeps tract of visited vertices
    // disc[] --> Stores discovery times of visited vertices
    // parent[] --> Stores parent vertices in DFS tree
    // ArtiCulation[] --> Store articulation points
    private  void initApUtil(){
        discovered = new boolean[numberOfVertices];
        disc = new int[numberOfVertices];
        parent = new int[numberOfVertices];
        low = new int[numberOfVertices];

        for (int a = 0; a < numberOfVertices; a++){
           // discovered[a] = false;
            parent[a]= -1;
            //ap[a] = false;
        }
    }

    public List<Integer> criticalNodes() {
        List<Integer> critical = new LinkedList<>();
        initApUtil();
        isArticulation = new boolean[numberOfVertices];


        for (int vert = 0; vert < listArrays.size(); vert++ ){
            if (discovered[vert]) continue;
            criticalHelper(vert, discovered, disc, low, parent, 0, isArticulation);
        }


        for (int i = 0; i < isArticulation.length; i++){
            if (isArticulation[i]){
                critical.add(i);
            }
        }

        return critical;
    }

    private void criticalHelper(int vert, boolean[] discovered, int[] disc, int[] low, int[] parent ,int time, boolean[] ArtiCulation) {

        //current node visited
        discovered[vert] = true;

        int children = 0;
        disc[vert] = low[vert] = ++time;
        Iterator<Integer> iterator = listArrays.get(vert).iterator();
        while (iterator.hasNext()) {
            int v = iterator.next();
            if (!discovered[v]) {
                children++;
                parent[v] = vert;
                criticalHelper(v, discovered, disc, low, parent, time, ArtiCulation);
                low[vert] = Math.min(low[v], low[vert]);

                if (parent[vert] == -1 && children >= 2) {
                    ArtiCulation[vert] = true;
                }

                if (parent[vert] != -1 && low[v] >= disc[vert]) {
                    ArtiCulation[vert] = true;
                }
            } else if (v != parent[vert]) {
                low[vert] = Math.min(low[vert], disc[v]);
            }
        }

    }





    /* A recursive function that find articulation points using DFS
     vert --> The vertex to be visited next
     visited[] --> keeps tract of visited vertices
     disc[] --> Stores discovery times of visited vertices
     parent[] --> Stores parent vertices in DFS tree
     ap[] --> Store articulation points
     */
   /* private void criticalHelper(int vert, boolean[] discovered, int[] time, int[] low, int[] parent, int i, boolean[] ap) {
        discovered[vert] = true;
        int children = 0;
        time[vert] = low[vert] = ++i;
        Iterator<Integer> itor = listArrays.get(vert).iterator();
        while (itor.hasNext()){
            int v = itor.next();
            if (!discovered[v]){
                children++;
                parent[v] = vert;
                criticalHelper(v,discovered,time,low,parent,i,ap);
                low[vert] = Math.min(low[v],low[vert]);
            }

            if (parent[vert] == -1 && children >= 2){
                ap[vert] = true;
            }

            if (parent[vert] != -1 && low[v] >= time[vert]){
                ap[vert] = true;
            }
            else if (v != parent[vert]){
                low[vert] = Math.min(low[vert],time[v]);

            }
        }


    }*/
}



