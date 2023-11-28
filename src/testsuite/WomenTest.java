package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException{
        //Mouse Hover on Women Menu
        mouseHoverToElements(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));
        // Mouse Hover on Tops
        mouseHoverToElements(By.xpath("//strong[normalize-space()='Tops']"));
        //Click on Jackets
        clickOnElement(By.xpath("//strong[normalize-space()='Jackets']"));
        // Select Sort By filter “Product Name”
selectByValueFromDropDown(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[4]/select[1]"),"Product Name");
        // Verify the products name display in alphabetical order
        List<WebElement> productsLists = driver.findElements(By.xpath("(//strong[@class='product name product-item-name'])[1]"));
        List<String> expectedProductLists = new ArrayList<>();
        for (WebElement productName : productsLists) {
            expectedProductLists.add(productName.getText());
        }
        System.out.println("Expected product name in Alphabetical order: " + expectedProductLists);
        Thread.sleep(2000);
        //OriginalList of Products name
        List<WebElement> originalProductsList = driver.findElements(By.xpath("(//strong[@class='product name product-item-name'])[1]"));
        List<String> originalProductLists = new ArrayList<>();
        for (WebElement productName : originalProductsList) {
            originalProductLists.add(productName.getText());
        }
        System.out.println("Original Product name in alphabetical order: " + originalProductLists);
        Assert.assertEquals(expectedProductLists, originalProductLists);
    }


}
    @Test
    public void verifyTheSortByPriceFilter(){
       // Mouse Hover on Women Menu
        mouseHoverToElements(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));
                // Mouse Hover on Tops
        mouseHoverToElements(By.xpath("//strong[normalize-space()='Tops']"));
            //Click on Jackets
        clickOnElement(By.xpath("//strong[normalize-space()='Jackets']"));
        //Select Sort By filter “Price”
        selectByValueFromDropDown(By.xpath("//div[@class='page-wrapper']//div[2]//div[4]//select[1]"),"Price");

        // Verify the products price display in Low to High
    }
    @After
    public void  tearDown(){
        closeBrowser();
    }



}
