package installation;

public class FirstRunBrowser extends BaseClass{
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://google.com");
        Thread.sleep(3000);
        driver.get("https://youtube.com");
        Thread.sleep(3000);
        driver.quit();

    }

}