import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInfoFiles {

    private static final String[] DOCUMENT_TYPES = {"Cédula de Ciudadanía", "Cédula de Extranjería", "Pasaporte"};
    private static final String[] PRODUCT_NAMES = {"Producto1", "Producto2", "Producto3", "Producto4", "Producto5"};
    private static final double[] PRODUCT_PRICES = {10000, 20000, 30000, 40000, 50000};

    public static void main(String[] args) {
        createSalesMenFile(10, "NombresVendedor1", 1000);
        createProductsFile(5);
        createSalesManInfoFile(10);
        System.out.println("Archivos creados con éxito.");
    }

    public static void createSalesMenFile(int randomSalesCount, String name, long id) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("salesmen.csv"))) {
            Random random = new Random();
            writer.write(name + ";" + id + "\n"); // Escribir el nombre y el ID del vendedor
            for (int i = 1; i <= randomSalesCount; i++) { // Comenzar desde 1 y ajustar el índice
                writer.write("IDProducto" + i + ";" + (random.nextInt(10) + 1) + "\n");
            }
            id++; // Incrementar el ID del vendedor
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createProductsFile(int productsCount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("products_info.csv"))) {
            for (int i = 0; i < productsCount; i++) {
                writer.write("IDProducto" + (i + 1) + ";" + PRODUCT_NAMES[i] + ";" + PRODUCT_PRICES[i] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createSalesManInfoFile(int salesmanCount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("salesman_info.csv"))) {
            Random random = new Random();
            for (int i = 0; i < salesmanCount; i++) {
                writer.write(DOCUMENT_TYPES[random.nextInt(DOCUMENT_TYPES.length)] + ";" + (random.nextInt(99999999) + 10000000) + ";" + "NombresVendedor" + (i + 1) + ";" + "ApellidosVendedor" + (i + 1) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
