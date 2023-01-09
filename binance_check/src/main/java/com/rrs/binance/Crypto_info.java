package com.rrs.binance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Crypto_info 
{
    static WebDriver driver = new ChromeDriver();
    public static void main( String[] args ) throws InterruptedException
    {
        

        show_cryptoinfo("https://www.binance.com/uk-UA/trade/BTC_BUSD?_from=markets&theme=dark&type=spot");
        show_cryptoinfo("https://www.binance.com/uk-UA/trade/ETH_BUSD?_from=markets&theme=dark&type=spot");
        show_cryptoinfo("https://www.binance.com/uk-UA/trade/SOL_BUSD?_from=markets&theme=dark&type=spot");
        show_cryptoinfo("https://www.binance.com/uk-UA/trade/LTC_BUSD?_from=markets&theme=dark&type=spot");
        Thread.sleep(5000);
        driver.quit(); 

    }
    public static void show_cryptoinfo(String url) {
        driver.manage().window().minimize();
        
        driver.get(url);
            
        System.out.println("\n" + driver.findElement(By.xpath("//div[@class='css-1qkv3vk']")).getText() + ":");
        
        System.out.println(
            driver.findElement(By.xpath("(//div[@class='tickerItemLabel'])[2]")).getText() + ": " + 
            driver.findElement(By.xpath("(//div[@class='tickerPriceText'])[2]")).getText() + ".");
            
        System.out.println(
            driver.findElement(By.xpath("(//div[@class='tickerItemLabel'])[3]")).getText() + ": " + 
            driver.findElement(By.xpath("(//div[@class='tickerPriceText'])[3]")).getText() + ".");

        System.out.println(
            driver.findElement(By.xpath("(//div[@class='tickerItemLabel'])[4]")).getText() + ": " + 
            driver.findElement(By.xpath("(//div[@class='tickerPriceText'])[4]")).getText() + ".\n");
            

        driver.switchTo().newWindow(WindowType.TAB);
    }
}