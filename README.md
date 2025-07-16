> I developed this automation script using Selenium with Java to simulate a realistic hotel booking flow.

1. **First**, I launched the Chrome browser and navigated to the hotel booking website. I used `WebDriverWait` to handle dynamic page elements and avoid timing issues.

2. **Then**, I searched for hotels in **New York** between **April 10 and April 15** by entering the location and dates into the input fields, and clicked the **search button**.

3. Once the search results were loaded, I used a CSS selector to **click on the first hotel** listed. I ensured it's interactable using `ExpectedConditions.elementToBeClickable()`.

4. On the hotel detail page, I waited for the **coupon input field** to be visible and entered the **coupon code “SUMMER25”**. After clicking **Apply**, I validated the discount using `getText()` on the discount label and checked if the expected 25% discount was shown.

5. After applying the coupon successfully, I proceeded to the **checkout page** — but did **not perform any payment** since that was not part of the test scope.

6. Throughout the script, I used **explicit waits**, proper exception handling (`try-catch-finally`), and meaningful condition checks to ensure stability and reliability.

7. Finally, I used `driver.quit()` in the `finally` block to ensure the browser closes even if the test fails.

---

> * I’ve kept the element locators as `By.id()` and CSS selectors for simplicity, but in a real project, I’d shift these into a **Page Object Model** structure to enhance maintainability.
> * All locators like `location-input`, `coupon-code`, etc., are assumed. In a real app, I’d inspect the DOM and optimize selectors accordingly.
> * The script is built to be **scalable**, and I can easily wrap it in a TestNG or JUnit framework for assertions, reporting, and CI integration.

---


