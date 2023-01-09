package com.rrs.binance;
import java.io.BufferedReader;
import java.io.FileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Paste_form {
    public static void main( String[] args ) throws InterruptedException {
        try {
            String login, password;
            BufferedReader login_reader = new BufferedReader(new FileReader("src/main/java/com/rrs/binance/login.txt"));
            BufferedReader password_reader = new BufferedReader(new FileReader("src/main/java/com/rrs/binance/password.txt"));
        
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.clientam.com/sso/Login");
            Thread.sleep(500);

            while((login = login_reader.readLine()) != null && (password = password_reader.readLine()) != null) {

                driver.findElement(By.xpath("//input[@id='user_name']")).clear();
                driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(login);
                driver.findElement(By.xpath("//input[@id='password']")).clear();
                driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
                Thread.sleep(500);

            }

            login_reader.close();
            password_reader.close();
            Thread.sleep(5000);
            driver.quit();
            
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }
}
