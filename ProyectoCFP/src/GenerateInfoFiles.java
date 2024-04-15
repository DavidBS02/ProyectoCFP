import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Arrays;

public class GenerateInfoFiles {

    private static final String[] DOCUMENT_TYPES = {"CEDULA CIUDADANIA"};
    private static final String[] PRODUCT_NAMES = {"LAPTOP", "CELLPHONE1", "EARPHONES", "MOUSE", "BATTERY", "TV", "COMPUTER", "GUITAR", "KEYBOARD", "CONTROL"};
    private static final double[] PRODUCT_PRICES = {1.000,  2.000, 100, 200, 300, 4.000, 5.000, 2.000, 400, 50};

    public static void main(String[] args) {
        createSalesMenFile(10, "CC", (long) 1.000);
        String[][] cosax = createProductsFile(10);
        System.out.println(Arrays.deepToString(cosax));
        String[][] sellerx =createSalesManInfoFile(10);
        System.out.println(Arrays.deepToString(sellerx));
//        System.out.println("Archivos creados con éxito.");
    }

    public static void createSalesMenFile(int randomSalesCount, String name, long id) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sales.csv"))) {
            Random random = new Random();
            writer.write(name + ";" + id + "\n"); // Escribir el nombre y el ID del vendedor
            for (int i = 1; i <= randomSalesCount; i++) { // Comenzar desde 1 y ajustar el índice
                writer.write("products" + i + ";" + (random.nextInt(10) + 1) + "\n");
            }
            id++; // Incrementar el ID del vendedor
            System.out.println("Archivo sales creado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[][] createProductsFile(int productsCount) {
    	String[][] arrayProducto = new String[10][3];
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("products.csv"))) {
            for (int i = 0; i < productsCount; i++) {
                writer.write("IDProducto" + (i + 1) + ";" + PRODUCT_NAMES[i] + ";" + PRODUCT_PRICES[i] + "\n");
                for (int j = 0; j < 3; j++) {
                	if (j == 0) {
                		arrayProducto[i][0] = "IDProducto" + (i + 1);
                	} else if (j == 1) {
                		arrayProducto[i][1] = PRODUCT_NAMES[i];
                	} else if (j == 2) {
                		arrayProducto[i][2] = Double.toString(PRODUCT_PRICES[i]);
                	}
                }
            }
            System.out.println("Archivo products creado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayProducto;
    }

    public static String[][] createSalesManInfoFile(int salesmanCount) {
    	String[][] arraySellers = new String[10][4];
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("seller.csv"))) {
            Random random = new Random();
            for (int i = 0; i < salesmanCount; i++) {
            	String typeDocument = DOCUMENT_TYPES[random.nextInt(DOCUMENT_TYPES.length)];
            	String numberDocument = String.valueOf(random.nextInt(99999999) + 10000000);
                writer.write(typeDocument + ";" + numberDocument + ";" + "NombresVendedor" + (i + 1) + ";" + "ApellidosVendedor" + (i + 1) + "\n");
                for (int j = 0; j < 4  ; j++) {
                	if (j == 0) {
                		arraySellers[i][0] = typeDocument;
                	} else if (j == 1) {
                		arraySellers[i][1] = numberDocument;
                	} else if (j == 2) {
                		arraySellers[i][2] = "NombresVendedor" + (i + 1);
                	} else if (j == 3) {
                		arraySellers[i][3] = "ApellidosVendedor" + (i + 1);
                	}
                }
            }
            System.out.println("Archivo seller creado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arraySellers;
    }
}

