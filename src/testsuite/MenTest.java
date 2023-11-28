package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "= https://magento.softwaretestingboard.com/";
    @Before
    public void setup() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException{
       //Mouse Hover on Men Menu

        mouseHoverToElements(By.xpath("//span[normalize-space()='Men']"));
        //Mouse Hover on Bottoms
        mouseHoverToElements(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));
        // Click on Pants
        clickOnElement(By.xpath("//a[@id='ui-id-23']"));
        Thread.sleep(1000);
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverToElementAndClick(By.xpath("(//div[@id='option-label-size-143-item-175'])[1]"));
        Thread.sleep(1000);
        //Mouse Hover on product name Cronus Yoga Pant’ and click on colour Black.
        mouseHoverToElementAndClick(By.xpath("(//div[@id='option-label-color-93-item-49'])[1]"));
        Thread.sleep(1000);
        //Mouse Hover on product name Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHoverToElementAndClick(By.xpath("(//span[contains(text(),'Add to Cart')])[1]"));
        Thread.sleep(1000);
        //Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
        String actualText = getTextFromElement(By.xpath("(//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)'])[1]"));
        Assert.assertEquals(expectedText, actualText);

        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //Verify the text ‘Shopping Cart'.
        Assert.assertEquals("Label does not match","Shopping Cart",getTextFromElement(By.xpath("//span[@class='base']")));

        // Verify the product name ‘Cronus Yoga Pant’
        Assert.assertEquals("Name does not match","Cronus Yoga Pant",getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")));

        // Verify the product size ‘32’
        Assert.assertEquals("Size does not match","32",getTextFromElement(By.xpath("//dd[contains(text(),'32')]")));

        //Verify the product colour ‘Black’
        Assert.assertEquals("Colour does not match","Black",getTextFromElement(By.xpath("//dd[contains(text(),'Black')]")));
    }


    @After
    public void tearDown(){
        closeBrowser();
    }

}

