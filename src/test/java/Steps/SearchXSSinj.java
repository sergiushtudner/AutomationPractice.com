
package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchXSSinj {
    private WebDriver driver;

    @Given("Open site in Google Chrome2")
    public void open_site_in_Google_Chrome() {
        System.setProperty("webdriver.chrome.driver","C:/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
        String title = driver.getTitle();
        String titleExp = "My Store";
        assertEquals(titleExp, title);


    }
    @Given("Find XSS injection")
    public void find_XSS_injection() {
        WebElement Search = driver.findElement(By.name("search_query"));
        Search.sendKeys("<script>alert(\"xss-injection!\")</script>");
        Search.sendKeys(Keys.ENTER);
        String title = driver.getTitle();
        String titleExp = "Search - My Store";
        assertEquals(titleExp, title);

        //      String Dress=driver.findElement(By.xpath("//span[@class='cat-name']")).getText();
        //      System.out.println("Dress");
    }

/*
    @Given("Find Shirt2")
    public void find_Shirt2() {
        driver.findElement(By.xpath("//input[@id='search_query_top']")).clear();
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("Shirts");
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys(Keys.ENTER);
//      String SearchResult;
//        SearchResult = driver.findElement(By.xpath("//input[@id='search_query_top']")).getText();
//        System.out.println("SearchResult");
        //     assertTrue(Objects.equals(SearchResult, "Shirts"));

        driver.quit();
        /*
            @Then("Dress found")

        WebElement Search=driver.findElement(By.name("search_query"));
        Search.sendKeys("Dress");
        Search.sendKeys(Keys.ENTER);
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Search - My Store"));

  //          Assert.assertTrue("Dress");

*/

    }



    /*
    @Given("CLick Sing Up button")
    public void click_Sing_Up_button() {
        //driver.findElement(By.xpath("//a[@class='btn btn-success btn-sm']")).click();
//        WebElement SignUp=driver.findElement(By.xpath("//a[@class='btn btn-success btn-sm']"));
//        SignUp.click();
        WebElement Search=driver.findElement(By.name("q"));
        Search.sendKeys("Moldova");
        Search.sendKeys(Keys.ENTER);
    }
    @When("Fill Email Adress \\(username)")
    public void fill_Email_Adress_username() {
        WebElement Email=driver.findElement(By.xpath("//input[@placeholder='Email Address (username)']"));
        Email.click();
        Email.sendKeys("test@test.md");


}
*/