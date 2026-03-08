class User {
    private int age;
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Tuổi không thể âm!");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
public class Ex_03 {
    public static void main(String[] args) {
        User u = new User();
        try {
            u.setAge(-5);
            System.out.println("Tuổi: " + u.getAge());
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Chương trình vẫn tiếp tục chạy...");
    }
}
