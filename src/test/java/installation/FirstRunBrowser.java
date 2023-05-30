package installation;

public class FirstRunBrowser extends BaseClass{
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://google.com");
        Thread.sleep(3000);

    }

}