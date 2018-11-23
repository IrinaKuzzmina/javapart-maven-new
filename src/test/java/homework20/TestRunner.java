package homework20;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        LoginTests testLogin = new LoginTests();
        try {
            testLogin.loginNegative();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
