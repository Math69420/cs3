/**
 * A quick sort demonstration algorithm
 * SortAlgorithm.java, Thu Oct 27 10:32:35 1994
 *
 * @author James Gosling
 * @version    1.6f, 31 Jan 1995
 */
/**
 * 19 Feb 1996: Fixed to avoid infinite loop discoved by Paul Haeberli.
 *              Misbehaviour expressed when the pivot element was not unique.
 *              -Jason Harrison
 *
 * 21 Jun 1996: Modified code based on comments from Paul Haeberli, and
 *              Peter Schweizer (Peter.Schweizer@mni.fh-giessen.de).  
 *              Used Daeron Meyer's (daeron@geom.umn.edu) code for the
 *              new pivoting code. - Jason Harrison
 *
 * 09 Jan 1998: Another set of bug fixes by Thomas Everth (everth@wave.co.nz)
 *              and John Brzustowski (jbrzusto@gpu.srv.ualberta.ca).
 */

class QSortAlgorithm extends SortAlgorithm {
    void sort(int a[], int lo0, int hi0) throws Exception {
   int lo = lo0;
   int hi = hi0;
   pause(lo, hi);
   if (lo >= hi) {
       return;
   }
        else if( lo == hi - 1 ) {
            /*
             *  sort a two element list by swapping if necessary 
             */
            if (a[lo] > a[hi]) {
                int T = a[lo];
                a[lo] = a[hi];
                a[hi] = T;
            }
            return;
   }


        /*
         *  Pick a pivot and move it out of the way
         */
   int pivot = a[(lo + hi) / 2];
        a[(lo + hi) / 2] = a[hi];
        a[hi] = pivot;

        while( lo < hi ) {
            /*
             *  Search forward from a[lo] until an element is found that
             *  is greater than the pivot or lo >= hi 
             */
            while (a[lo] <= pivot && lo < hi) {
      lo++;
       }

            /*
             *  Search backward from a[hi] until element is found that
             *  is less than the pivot, or lo >= hi
             */
       while (pivot <= a[hi] && lo < hi ) {
      hi--;
       }

            /*
             *  Swap elements a[lo] and a[hi]
             */
            if( lo < hi ) {
                int T = a[lo];
                a[lo] = a[hi];
                a[hi] = T;
                pause();
            }

       if (stopRequested) {
                return;
            }
   }

        /*
         *  Put the median in the "center" of the list
         */
        a[hi0] = a[hi];
        a[hi] = pivot;

        /*
         *  Recursive calls, elements a[lo0] to a[lo-1] are less than or
         *  equal to pivot, elements a[hi+1] to a[hi0] are greater than
         *  pivot.
         */
   sort(a, lo0, lo-1);
   sort(a, hi+1, hi0);
    }

    void sort(int a[]) throws Exception {
   sort(a, 0, a.length-1);
    }
}
