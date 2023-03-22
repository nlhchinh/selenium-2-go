/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.chinhnguyen.selenium.go;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author Admin
 */
public class Selenium2Go {

    public static void main(String[] args) {
        searchGoogle();
    }

    // Test case: check if google search runs well
    // Steps:
    // 1. Open a certain browser, e.g, Chrome
    // 2. Type https://google.com to open Google search engine
    // 3. Type "Dung nhan sai cai"
    // 4. Hit enter to see the result 
    // Expected value/ result
    // The search result will show the list of web pages with the keyword
    // "Dung nhan sai cai" included
    public static void searchGoogle() {

        WebDriver myBrowser; // day la bien object lat hoi se tro vao 1 cai tab hay 1 cai trinh duyet cu the dc nap vao RAM
        String drivePath = "chromedriver.exe"; // duong dan tro den tap tin
        // nhi phan/driver dieu khien
        // trinh duyet
        // bao voi may ao Java JVM 1 bien moi truong ten la
        // webdriver.chrome.driver tro den tap tin .exe!!!
        // giong voi PATH TRO VAO BIN CUA BEN WINDOWS
        System.setProperty("webdriver.chrome.driver", drivePath);

        // new cua OOP bat dau, xin ram, nap trinh duyet vao, new la tao object
        // new xong thoai mai cham goi hanh dong trong vung ram cua object
        // mo Chrome an danh
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--incognito");
        //options.addArguments("--lang=zh-cn"); // vi en-GB

        myBrowser = new ChromeDriver(options); // khai Cha new Con
        // Chrome, CoCoc
        // Browser
        myBrowser.get("https://google.com");
        // bung rong full man hinh cai trinh duyet
        myBrowser.manage().window().maximize();

        // tim gium em cai input tag ten la q trong trang google
        WebElement txtSearchBox = myBrowser.findElement(By.name("q"));
        txtSearchBox.sendKeys("Đúng nhận sai cãi");
        txtSearchBox.submit(); // enter
    }
}
