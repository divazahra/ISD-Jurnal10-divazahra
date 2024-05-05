// menggunakan iterator, linkedlist dan queue untuk menentukan DFS
import java.util.Iterator; 
import java.util.LinkedList; 
import java.util.Stack; 
 
public class DFSTraversal { 
    private int verteks; // menyimpan value vertex
    private LinkedList<Integer> adj[]; // array penyimpan list adjacency
    private boolean visited[]; // penyimpan vertex yang telah dikunjungi
 
    //method pembuat list adjacency dan inisialisasi vertex
    @SuppressWarnings("unchecked") 
    public DFSTraversal(int v) { 
        verteks = v; 
        adj = new LinkedList[verteks]; 
        for (int i = 0; i < v; ++i) 
            adj[i] = new LinkedList<Integer>(); 
 
        visited = new boolean[verteks]; 
        // inisialisasi penanda semua vertex belum dikunjungi
        for (int i = 0; i < verteks; i++) { 
            visited[i] = false; 
        } 
    } 
 
    // method menambah edge
    public void addEdge(int source, int dest) { //source = vertex asal dan dest = vertex yang dituju
        adj[source].add(dest); 
    } 
 
    //method mengubah angka menjadi huruf 
    public String numToAlphabet(int i) {
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        return alphabet[i];
    }

    public void dfs(int sourceVertex) { 
        // membuat stack 
        Stack<Integer> stack = new Stack<>(); 
        // push vertex awal
        stack.push(sourceVertex); 
 
        while (stack.empty() == false) { 
            // selama stack tidak kosong, pop vertex teratas dalam stack
            sourceVertex = stack.peek(); 
            stack.pop(); 
            
            // vertex yang dikunjungi bernilai false
            // cetak vertex dan vertex akan bernilai true
            if (visited[sourceVertex] == false) { 
                System.out.print(numToAlphabet(sourceVertex) + " "); 
                visited[sourceVertex] = true; 
            } 
 
            // buat iterator dan tandai vertex awal sebagai iterator
            // cek vertex selanjutnya belum dikunjungi, kunjungi tetangga 
            Iterator<Integer> itr = adj[sourceVertex].iterator(); 

            while (itr.hasNext()) { 
                int v = itr.next(); 
                if (!visited[v]) 
                    stack.push(v); //push vertex tetangga ke stack
            } 
        } 
    } 

    public static void main(String[] args) { 
        DFSTraversal graf = new DFSTraversal(9); 
          
        graf.addEdge(0, 1); 
        graf.addEdge(0, 3); 
        graf.addEdge(0, 4); 
        graf.addEdge(1, 4); 
        graf.addEdge(3, 6); 
        graf.addEdge(4, 5); 
        graf.addEdge(4, 7);  
        graf.addEdge(6, 7); 
        graf.addEdge(5, 7); 
        graf.addEdge(5, 2); 
        graf.addEdge(7, 8); 
        graf.addEdge(2, 1); 
        graf.addEdge(8, 5); 

        System.out.println("DFS untuk graf (mulai dari A); "); 
        graf.dfs(0); 
    } 
} 