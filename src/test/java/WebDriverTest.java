
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


/**
 * Created by igortimokhin on 1/11/18.
 */
public class WebDriverTest {

        WebDriver driver;

        /**
         * Test to navigate Yahoo page
         *
         * Starting point will be the yahoo.com
         *
         * *** You may want to do a manual test at first to gather the needed
         * element locators needed for the test ****** Run Thru The Debugger
         *
         * https://www.yahoo.com
         *
         * Follow Steps below
         *
         */

        @Test
        public void funWithYahooPage() {

            driver.get("https://www.yahoo.com/");

            // Step 1. Assert that we are on the correct page by checking that title = 'Yahoo'
           Assert.assertEquals("Yahoo", driver.getTitle());

		/*
		 * Step 2. Display the count of options on the left side panel ('Mail', 'News', 'Sports',......)
		 * including 'More Yahoo Sites' option
	 	 */

            // Step 3: Enter 'Nutrition' on the search bar on the top
            driver.findElement(By.id("uh-search-box")).sendKeys("Nutrition");

            // Step 4: Click Search button
            driver.findElement(By.id("uh-search-button")).click();

            // Step 5: Display count of Images on the page
            System.out.println("Step 5. Images count ==> " + driver.findElements(By.tagName("img")).toString().length());

            // Step 6. Click 'Sign In' button on the top left side

            driver.findElement(By.id("yucs-login_signIn")).click();


            // Step 7. Display the boolean state of the checkbox next to 'Keep me signed in'

            System.out.println("Step 7: " + driver.findElement(By.id("persistent")).isSelected());

            // Step 8. Click 'Sign In' button
            driver.findElement(By.id("login-signin")).click();

		/*
		 * Step 9. Error will be displayed.
		 * Assert true when the error message contains the expectedErrorStr defined below
		 */
            String expectedErrorStr = "Sorry, we don't recognize this email.";
            Assert.assertEquals(expectedErrorStr, driver.findElement(By.id("username-error")).getText().toString());
        }

        /**
         * Test to simulate an attempted Sign in to Paypal and validate error
         * message returned
         *
         * Starting point will be the PayPal
         *
         * *** You may want to do a manual test at first to gather the needed
         * element locators needed for the test ****** Run Thru The Debugger
         *
         * https://www.paypal.com
         *
         * Follow Steps below
         *
         */

        @Test
        public void funWithPayPalSignUpPage() {

            driver.get("https://www.paypal.com");

		/*
		 * Step 1. Assert that we are on the correct page by checking that title = 'Send Money, Pay Online or Set Up
		 * a Merchant Account - PayPal'
		 */
            System.out.println(driver.getTitle());
            Assert.assertEquals("Send Money, Pay Online or Set Up a Merchant Account - PayPal", driver.getTitle());

            // Step 2. Click 'Sign Up for Free' button
            driver.findElement(By.id("signup-button")).click();

            // Step 3: Enter email address test@google.com
            driver.findElement(By.id("cta-btn")).click();

            driver.findElement(By.id("paypalAccountData_email")).sendKeys("test@google.com");

            // Step 4: Enter password test123
            driver.findElement(By.id("paypalAccountData_password")).sendKeys("test123");

            // Step 5: Enter confirm password test123
            driver.findElement(By.id("paypalAccountData_confirmPassword")).sendKeys("test123");

            // Step 6: Click 'Continue' button
            driver.findElement(By.cssSelector(".vx_btn.vx_btn-block")).click();


		/*
		 * Step 7. Error will be displayed
		 * Assert True that error message contains the expectedErrorStr defined below
 		 */
            String expectedErrorStr = "It looks like you already signed up.";
            assertThat(driver.findElement(By.cssSelector(".vx_form-control-message")).getText(), containsString(expectedErrorStr));

            // Step 8. Print out the boolean state of the 'confirmPassword' input field displayed
            System.out.println(driver.findElement(By.id("paypalAccountData_confirmPassword")).isDisplayed());


            // Step 9. Display the count of Images on the Sign In page
            System.out.println("Step 5. Images count ==> " + driver.findElements(By.tagName("img")).toString().length());


            // Step 10. Display the country flag shown on the bottom right side
            System.out.println(driver.findElement(By.cssSelector("a.country")).getAttribute("class"));
        }

        @Before
        public void setUp() {

            System.setProperty("webdriver.chrome.driver", "/Users/igortimokhin/Documents/MyProjects/Vodka/Drivers/chromedriver");
            driver = new ChromeDriver();

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        }

        @After
        public void tearDown() {
           driver.quit();
        }
    }


