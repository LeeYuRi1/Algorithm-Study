package algorithm.sort;

public class MergeSort {
    public static void main(String[] args) {
    }

    static void merge(int data[], int p, int q, int r) {
        int i = p, j = q + 1, k = p;
        int[] tmp = new int[data.length];

        while (i <= q && j <= r) {
            if (data[i] <= data[j])
                tmp[k++] = data[i++];
            else
                tmp[k++] = data[j++];
        }
        while (i <= q)
            tmp[k++] = data[i++];
        while (j <= r)
            tmp[k++] = data[j++];
        for (int t = p; t <= r; t++)
            data[t] = tmp[t];
    }
}
