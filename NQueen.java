import java.util.Scanner;
class NQueen {

  static void breakLine() {
    System.out.print("\n---------------------------------\n");
  }

  static int MAX = 10;

  static int arr[] = new int[MAX], no;

  // Function to check queens placement
  static void nQueens(int k, int n) {

    for (int i = 1; i <= n; i++) {
      if (canPlace(k, i)) {
        arr[k] = i;
        if (k == n) {
          display(n);
        } else {
          nQueens(k + 1, n);
        }
      }
    }
  }
  // Helper Function to check if queen can be placed
  static boolean canPlace(int k, int i) {
    for (int j = 1; j <= k - 1; j++) {
      if (arr[j] == i || (Math.abs(arr[j] - i) == Math.abs(j - k))) {
        return false;
      }
    }
    return true;
  }
  // Function to display placed queen
  static void display(int n) {
    breakLine();
    System.out.print("Arrangement No. " + ++no);
    breakLine();

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (arr[i] != j) {
          System.out.print("\t0");
        } else {
          System.out.print("\t1");
        }
      }
      System.out.println("");
    }
    breakLine();
  }

  // Driver Code
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("NxN : ");
    int n = sc.nextInt();
    nQueens(1, n);
  }
}
