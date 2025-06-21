import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.util.Collections.binarySearch;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        // User input for number of products
        System.out.print("Enter the number of products: ");
        int numberOfProducts = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product[] products = new Product[numberOfProducts];

        // User input for product details
        for (int i = 0; i < numberOfProducts; i++) {
            System.out.print("Enter product ID for product " + (i + 1) + ": ");
            int productId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter product name for product " + (i + 1) + ": ");
            String productName = scanner.nextLine();

            System.out.print("Enter category for product " + (i + 1) + ": ");
            String category = scanner.nextLine();

            products[i] = new Product(productId, productName, category);
        }

        // Sort the products array for binary search
        Arrays.sort(products, new Comparator<Product>() {
            public int compare(Product a, Product b) {
                if (a.productId < b.productId)
                    return -1;
                else if (a.productId < b.productId)
                    return 1;
                else
                    return 0;
            }
        });

        // User input for productId to search
        System.out.print("Enter the product ID to search: ");
        int searchId = scanner.nextInt();

        // Linear Search
        Product foundProductLinear = ProductSearch.linearSearch(products, searchId);
        if (foundProductLinear != null) {
            System.out.println("Product found using Linear Search: " + foundProductLinear);
        } else {
            System.out.println("Product not found using Linear Search.");
        }

        // Binary Search
        Product foundProductBinary = ProductSearch.binarySearch(products, searchId);
        if (foundProductBinary != null) {
            System.out.println("Product found using Binary Search: " + foundProductBinary);
        } else {
            System.out.println("Product not found using Binary Search.");
        }

        scanner.close();
    }
}

// Linear search is simple but slow for large arrays (O(n))
// Binary search is fast (O(log n)) but needs sorted data