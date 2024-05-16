package btt;

import java.io.File;
import java.util.Scanner;

public class DeleteFileOrDirectory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập đường dẫn thư mục hoặc file: ");
        String path = scanner.nextLine();

        File fileOrDirectory = new File(path);

        if (!isSafeToDelete(path)) {
            System.out.println("Đường dẫn này không được phép xóa vì lý do an toàn.");
        } else {
            if (fileOrDirectory.exists()) {
                delete(fileOrDirectory);
                System.out.println("Đã xóa thành công.");
            } else {
                System.out.println("Thư mục hoặc file không tồn tại.");
            }
        }

        scanner.close();
    }

    private static boolean isSafeToDelete(String path) {
        String lowerCasePath = path.toLowerCase();
        return !(lowerCasePath.equals("c:\\") || lowerCasePath.equals("d:\\") || lowerCasePath.equals("e:\\")
                || lowerCasePath.equals("/") || lowerCasePath.matches("[a-zA-Z]:\\\\"));
    }

    private static void delete(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory()) {
            File[] entries = fileOrDirectory.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                    delete(entry);
                }
            }
        }
        if (!fileOrDirectory.delete()) {
            System.out.println("Không thể xóa " + fileOrDirectory.getPath());
        }
    }
}