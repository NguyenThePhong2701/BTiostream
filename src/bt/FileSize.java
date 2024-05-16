package bt;

import java.io.File;
import java.util.Scanner;

public class FileSize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập đường dẫn file: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (file.exists() && file.isFile()) {
            long fileSize = file.length(); // Kích thước file tính bằng byte
            System.out.println("Kích thước file: " + fileSize + " byte");
        } else {
            System.out.println("File không tồn tại hoặc không phải là file hợp lệ.");
        }

        scanner.close();
    }
}