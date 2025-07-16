import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HotelBookingAutomation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            driver.manage().window().maximize();
            driver.get("https://hotelbooking.com");

            // Step 1: Search for Hotels in New York from April 10 to April 15
            driver.findElement(By.id("location-input")).sendKeys("New York");
            driver.findElement(By.id("checkin-date")).sendKeys("2025-04-10");
            driver.findElement(By.id("checkout-date")).sendKeys("2025-04-15");
            driver.findElement(By.id("search-button")).click();

            // Step 2: Select the first hotel from results
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".hotel-card:first-child .select-button"))).click();

            // Step 3: Apply Coupon Code
            WebElement couponInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coupon-code")));
            couponInput.sendKeys("SUMMER25");
            driver.findElement(By.id("apply-coupon")).click();

            // Step 4: Verify Discount
            WebElement discountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("discount-amount")));
            String discountText = discountElement.getText();
            if (discountText.contains("25%") || discountText.contains("applied")) {
                System.out.println("Coupon applied successfully: " + discountText);
            } else {
                System.out.println("Coupon not applied correctly.");
            }

            // Step 5: Proceed to Checkout (without completing payment)
            driver.findElement(By.id("proceed-to-checkout")).click();
            wait.until(ExpectedConditions.urlContains("checkout"));

            System.out.println("Navigated to checkout successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}