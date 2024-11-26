import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Supermarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username, password, captchaInput, captcha = "SHSH";
        boolean isLoggedIn = false;

        // Log in
        System.out.println("+-----------------------------------------------------+");
        System.out.println("Log in");
        while (!isLoggedIn) {
            try {
                System.out.print("Username: ");
                username = scanner.nextLine();

                System.out.print("Password: ");
                password = scanner.nextLine();

                System.out.print("Captcha (" + captcha + "): ");
                captchaInput = scanner.nextLine();

                if (username.equals("hasbi") && password.equals("sidiqgtg") && captchaInput.equals(captcha)) {
                    isLoggedIn = true;
                    System.out.println("Login berhasil!");
                } else {
                    throw new Exception("Login gagal, terdapat kesalahan, ulangi lagi.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("+-----------------------------------------------------+");

        // Welcome message
        System.out.println("Selamat Datang di ash'sMart");
        displayCurrentDateTime();
        System.out.println("+-----------------------------------------------------+");

        // Input Faktur
        String noFaktur = inputString(scanner, "No. Faktur");
        String kodeBarang = inputString(scanner, "Kode Barang");
        String namaBarang = inputString(scanner, "Nama Barang");
        double hargaBarang = inputDouble(scanner, "Harga Barang");
        int jumlahBeli = inputInteger(scanner, "Jumlah Beli");

        // Calculate total
        double total = hargaBarang * jumlahBeli;

        // Display Invoice
        System.out.println("+-----------------------------------------------------+");
        System.out.printf("No. Faktur      : %s%n", noFaktur);
        System.out.printf("Kode Barang     : %s%n", kodeBarang);
        System.out.printf("Nama Barang     : %s%n", namaBarang);
        System.out.printf("Harga Barang    : %.2f%n", hargaBarang);
        System.out.printf("Jumlah Beli     : %d%n", jumlahBeli);
        System.out.printf("TOTAL           : %.2f%n", total);
        System.out.println("+-----------------------------------------------------+");
        System.out.println("Kasir           : sidiqgtg");
        System.out.println("+-----------------------------------------------------+");

        scanner.close();
    }

    // Method to display the current date and time
    public static void displayCurrentDateTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("Tanggal dan Waktu: " + dateFormat.format(date));
    }

    // Method to safely input a string
    public static String inputString(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    throw new Exception(prompt + " tidak boleh kosong!");
                }
                return input;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Method to safely input a double
    public static double inputDouble(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(prompt + " harus berupa angka desimal yang valid!");
            }
        }
    }

    // Method to safely input an integer
    public static int inputInteger(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(prompt + " harus berupa angka bulat yang valid!");
            }
        }
    }
}
