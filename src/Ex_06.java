import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
class InvalidAgeException extends Exception {
    public InvalidAgeException(String msg) {
        super(msg);
    }
}
class Logger {
    public static void logError(String message) {
        String time = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println("[ERROR] " + time + " - " + message);
    }
}
class User {
    private String name;
    private int age;
    public User(String name) {
        this.name = name;
    }
    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Tuổi không thể âm!");
        }
        this.age = age;
    }
    public void printName() {
        // Defensive programming
        if (name != null) {
            System.out.println("Tên người dùng: " + name);
        } else {
            System.out.println("Tên chưa được thiết lập.");
        }
    }
    public int getAge() {
        return age;
    }
}
class FileService {
    public static void saveToFile() throws IOException {
        System.out.println("Đang lưu dữ liệu...");
        throw new IOException("Không thể ghi file!");
    }
    public static void processUserData() throws IOException {
        saveToFile();
    }

}
public class Ex_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhập năm sinh: ");
            String input = sc.nextLine();
            int birthYear = Integer.parseInt(input);
            int age = 2026 - birthYear;
            User user = new User("Huy");
            user.setAge(age);
            user.printName();
            System.out.println("Tuổi: " + user.getAge());
            System.out.print("Nhập tổng số người: ");
            int total = sc.nextInt();
            System.out.print("Nhập số nhóm: ");
            int groups = sc.nextInt();
            int result = total / groups;
            System.out.println("Mỗi nhóm có: " + result + " người");
            FileService.processUserData();
        }
        catch (NumberFormatException e) {
            Logger.logError("Năm sinh phải là số!");
        }
        catch (InvalidAgeException e) {
            Logger.logError(e.getMessage());
        }
        catch (ArithmeticException e) {
            Logger.logError("Không thể chia cho 0!");
        }
        catch (IOException e) {
            Logger.logError("Lỗi ghi file: " + e.getMessage());
        }
        finally {
            sc.close();
            System.out.println("Dọn dẹp tài nguyên...");
        }
        System.out.println("Chương trình kết thúc an toàn.");
    }
}
