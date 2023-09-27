class HeapSortAlgorithm extends SortAlgorithm {
    void sort(int a[]) throws Exception {
   int N = a.length;
   for (int k = N/2; k > 0; k--) {
       downheap(a, k, N);
       pause();
        }
   do {
            int T = a[0];
            a[0] = a[N - 1];
            a[N - 1] = T;
       N = N - 1;
       pause(N);
            downheap(a, 1, N);
   } while (N > 1);
    }

    void downheap(int a[], int k, int N) throws Exception {
   int T = a[k - 1];
   while (k <= N/2) {
            int j = k + k;
            if ((j < N) && (a[j - 1] < a[j])) {
           j++;
       }
       if (T >= a[j - 1]) {
      break;
       } else {
                a[k - 1] = a[j - 1];
                k = j;
      pause();
            }
   }
        a[k - 1] = T;
   pause();
    }
}
