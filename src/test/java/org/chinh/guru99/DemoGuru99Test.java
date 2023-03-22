/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.chinh.guru99;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author Admin
 */
public class DemoGuru99Test {

    // Test case: test the login function of Demo Guru 99 with valid account
    // Steps:
    //          Open a certain browser, e.g. Chrome
    //          Open Demo Guru 99 website to see the login page:
    //          https://demo.guru99.com/v4
    //          Input a valid user/pass, e.g. mngr485060/uhudYhe
    //          Hit login button
    // Expected:
    //          A welcome message appears with the following format:
    //          Welcome manger : <username>
    // ta xai ke JUnit vi no giup xanh do khi so sanh, bai nay ko phai la test code
    // test ham, ma la test chuc nang, QC dong vai nguoi dung xai app
    public static WebDriver myBrowser; // xai bien toan cuc, bien trinh duyet xai chung
    // cho cac ham @Test

    @BeforeAll // ham nay se chay truoc cac @Test => khoi dong
    public static void setUpClass() {
        // mo trinh duyet o phan khoi dong, mo trinh duyet 1 lan thoi
        String drivePath = "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", drivePath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--incognito");

        myBrowser = new ChromeDriver(options);
        myBrowser.manage().window().maximize();
    }

    @Test
    public void demoGuru99LoginWithValidAccount() throws InterruptedException {

        String username = "mngr485060";
        String password = "uhudYhe";

        myBrowser.get("https://demo.guru99.com/v4");
        

        // bat cac tag user/pass, dua account vao va nhan login
        WebElement txtUserName = myBrowser.findElement(By.xpath("//input[@name='uid']"));
        txtUserName.sendKeys(username);
        WebElement txtPassword = myBrowser.findElement(By.xpath("//input[@name='password']"));
        txtPassword.sendKeys(password);
        WebElement btnLogin = myBrowser.findElement(By.xpath("//input[@name='btnLogin']"));
        btnLogin.click();
        // sau nut nhan Login, can phai chuyen trang, tuc la co trang Welcome
        // dc tai ve, trang admin dc tai ve
        // do toc do mang, nen viec tai ve trinh duyet co the bi lag 1 chut
        // trong khi do code Java tim tag Welcome cu chay ma ko cho
        // trang dc tai xong. XAY RA LOI KO TIM THAY TAG 100%

        // NGUYEN TAC CHUYEN TRANG: WAIT, CHO TRANG TAI XONG MOI DI TIM TAG
        Thread.sleep(3000);

        // bat not cai tag Welcome Hello
        WebElement lblWelcome = myBrowser.findElement(By.cssSelector("tr[class='heading3'] td"));

        System.out.println("Msg: " + lblWelcome.getText());

        String expected = "Manger Id : " + username; // hy vong login thanh cong, thi in ra cau Manger Id : <username>

        String actual = lblWelcome.getText(); // lay text trong tag <td>

        assertEquals(expected, actual);
    }


    @AfterAll // ham nay se chay sau tat ca cac @Test da chay xong => don dep
    public static void tearDownClass() throws InterruptedException {
//        Thread.sleep(3000); // CPU nghi 3s roi tat trinh duyet
//        myBrowser.quit(); // tat trinh duyet tu te, don RaM luon!!!
    }

}