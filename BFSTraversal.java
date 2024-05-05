// menggunakan linkedlist dan queue untuk menentukan BFS
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
    private int nodes; // menyimpan jumlah node
    private LinkedList<Integer>adj[]; // array penyimpan list adjacency
    private Queue<Integer> vertexQueue; // penyimpan vertex yang telah dikunjungi

    //method pembuat list adjacency dan inisialisasi vertexQueue penampung vertex yang telah dikunjungi
    @SuppressWarnings("unchecked")
    public BFSTraversal (int vertex) {
        nodes = vertex;
        adj = new LinkedList[nodes];

        for (int i = 0; i < vertex; i++) {
            adj[i] = new LinkedList<>();
        }

        vertexQueue = new LinkedList<Integer>();
    }

    //method penambahan edge 
    public void insertEdge(int source, int dest) { //source = vertex asal dan dest = vertex yang dituju
        adj[source].add(dest); 
    } 
     
   //method untuk melihat hasil List Adjacency 
    public void getAdj() { 
        for (LinkedList<Integer> linkedList : adj) { 
            System.out.println(linkedList); 
        } 
    } 
 
    //method mengubah angka menjadi huruf 
    public String numToAlphabet (int i) {
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        return alphabet[i];
    }

    //Penelusuran BFS 
    public void bfs(int sumber) { 
        //membuat queue untuk verteks yang sudah dikunjungi 
        boolean traversalOrder[] = new boolean[nodes]; 
        //nilai awal verteks yang dikunjungi adalah 0
        int vertexDikunjungi = 0; 
        traversalOrder[sumber] = true; //vertex sumber di-visit dan bernilai true 
        vertexQueue.add(sumber); // vertex tersebut dimasukkan ke dalam queue 

        while (!vertexQueue.isEmpty()){ 
            //ambil dan hapus vertex pertama 
            vertexDikunjungi = vertexQueue.poll(); 
            //print vertex pertama 
            System.out.print(numToAlphabet(vertexDikunjungi) + " "); 
            //cek tetangga dari vertex awal 
            for (int tetangga : adj[vertexDikunjungi]) { 
 
                //jika tetangga belum dikunjungi, kunjungi tetangga 
                if (!traversalOrder[tetangga]) { 
                    traversalOrder[tetangga] = true;  //tetangga dikunjungi dan bernilai true 
                    vertexQueue.add(tetangga); //masukkan tetangga ke vertexQueue                   
                } 
            } 
        } 
    }

    public static void main(String[] args) {
        BFSTraversal graf = new BFSTraversal(10);

        graf.insertEdge(0, 1);
        graf.insertEdge(0, 3);
        graf.insertEdge(0, 4);
        graf.insertEdge(1, 4);
        graf.insertEdge(3, 6);
        graf.insertEdge(4, 5);
        graf.insertEdge(4, 7);
        graf.insertEdge(6, 7);
        graf.insertEdge(5, 7);
        graf.insertEdge(5, 2);
        graf.insertEdge(7, 8);
        graf.insertEdge(2, 1);
        graf.insertEdge(8, 5);

        System.out.println("BFS untuk graf (mulai dari A):");
        graf.bfs(0);
    }
}
