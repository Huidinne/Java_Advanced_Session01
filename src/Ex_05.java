class InvalidAgeException extends Exception {
    public InvalidAgeException(String msg) {
        super(msg);
    }

}
class User {
    private int age;
    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Tuổi không thể âm!");
        }
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}
public class Ex_05 {
    public static void main(String[] args) {
        User u = new User();
        try {
            u.setAge(-10); // thử nhập tuổi âm
            System.out.println("Tuổi: " + u.getAge());
        }
        catch (InvalidAgeException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        System.out.println("Chương trình vẫn tiếp tục chạy...");
    }
}
