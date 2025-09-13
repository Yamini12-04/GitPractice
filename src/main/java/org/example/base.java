package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class base {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        String productName= "Apple iPhone 13 (Midnight, 128 GB)";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        /*

        driver.findElement(By.xpath("//a[text()='Login']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[class='r4vIwl BV+Dqf']")).sendKeys("saiyamini815@gmail.com");
        driver.findElement(By.xpath("//button[@class='QqFHMw twnTnD _7Pd1Fp']")).click();
        String otp =System.console().readLine();
        driver.findElement(By.className("XDRRi5")).sendKeys(otp);
        driver.findElement(By.cssSelector("[type='submit']")).click();

         */

        WebElement searchBox= driver.findElement(By.cssSelector("input[type='text']"));
        searchBox.sendKeys("iphone 13");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='DOjaWF gdgoEp']"));
        List<WebElement> pro =driver.findElements(By.cssSelector(".tUxRFH"));

        WebElement prod =	pro.stream().filter(product->
                product.findElement(By.cssSelector(".KzDlHZ")).getText().equals(productName)).findFirst().get();

        prod.click();

        Set<String> window=driver.getWindowHandles();
        Iterator<String> It=window.iterator();
        String ParentWindow=It.next();
        String childWindow= It.next();

        driver.switchTo().window(childWindow);
        System.out.println(driver.getCurrentUrl());



        //Adding item to cart
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@class='_1ri+WN lwANdH'] //button[@class='QqFHMw vslbG+ In9uk2']")).click();


        String cartProductName =driver.findElement(By.cssSelector("a[class='T2CNXf QqLTQ-']")).getText();

        Boolean bool= cartProductName.equals(productName);

        System.out.println(bool);









    }
}