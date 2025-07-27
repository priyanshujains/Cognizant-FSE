import java.util.*;

class Result {
    public static int getSortingFactorK(List<Integer> arr) {
        int n = arr.size();
        int[] original = new int[n];
        int[] sorted = new int[n];

        for (int i = 0; i < n; i++) {
            original[i] = arr.get(i);
            sorted[i] = arr.get(i);
        }

        Arrays.sort(sorted);

        if (Arrays.equals(original, sorted)) return 0;

        // Map value -> list of indices
        Map<Integer, List<Integer>> valToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valToIndices.computeIfAbsent(original[i], x -> new ArrayList<>()).add(i);
        }

        // Try from high k to 0
        for (int k = n - 1; k >= 1; k--) {
            UnionFind uf = new UnionFind(n);

            // Step 1: Connect all elements whose (val & k) == k
            for (int val : valToIndices.keySet()) {
                if ((val & k) == k) {
                    List<Integer> indices = valToIndices.get(val);
                    for (int i = 1; i < indices.size(); i++) {
                        uf.union(indices.get(0), indices.get(i));
                    }
                }
            }

            // Step 2: Now connect different values with (a & b) == k
            List<Integer> keys = new ArrayList<>(valToIndices.keySet());
            for (int i = 0; i < keys.size(); i++) {
                int a = keys.get(i);

                if ((a & k) != k) continue;

                for (int j = i + 1; j < keys.size(); j++) {
                    int b = keys.get(j);
                    if ((b & k) != k) continue;
                    if ((a & b) == k) {
                        uf.union(valToIndices.get(a).get(0), valToIndices.get(b).get(0));
                    }
                }
            }

            // Step 3: Validate if sorting is possible
            boolean valid = true;
            for (int i = 0; i < n; i++) {
                if (original[i] != sorted[i]) {
                    int from = i;
                    int to = findIndex(original, sorted[i], i); // find correct target index
                    if (uf.find(from) != uf.find(to)) {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid) return k;
        }

        return 0;
    }

    // Find index of value in arr (excluding the current one)
    private static int findIndex(int[] arr, int value, int excludeIndex) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value && i != excludeIndex) return i;
        }
        return excludeIndex;
    }

    static class UnionFind {
        int[] parent;

        UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py)
                parent[px] = py;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(0,1, 3, 2,4);
        System.out.println(Result.getSortingFactorK(arr)); // Output: 1
    }
}
