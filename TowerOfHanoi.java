package bp;

public class TowerOfHanoi {
    static void tower(int n, char from, char to, char aux){
        if (n == 1){
            System.out.println("Disk 1 dari " + from + " ke " + to);
            return;
        }
        tower(n-1, from, aux, to);
        System.out.println("Disk " + n + " dari " + from + " ke " + to);
        tower(n-1, aux, to, from);
    }
    
    public static void main(String[] args) {
        tower(3, 'A', 'B', 'C');
    }
}
