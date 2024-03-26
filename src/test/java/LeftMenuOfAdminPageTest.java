import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class LeftMenuOfAdminPageTest extends TestBase {
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    final AdminAuthorizationPageTest adminAuthorizationPage = new AdminAuthorizationPageTest();
    final String pageUrl = "http://localhost/litecart/admin";

    //Appearence
    final String appearenceTab = "//li[@id = 'app-']/a/span[text() = 'Appearence']";
    final String templateTitle = "Template";
    final String templateTab = "#app-.selected #doc-template";
    final String logotypeTab = "#app-.selected #doc-logotype";
    final String logotypeTitle = "Logotype";
    //Catalog
    final String catalogTab = "//li[@id = 'app-']/a/span[text() = 'Catalog']";
    final String catalogTitle = "Catalog";
    final String internalCatalogTab = "#app-.selected #doc-catalog";
    final String productGroupsTab = "#app-.selected #doc-product_groups";
    final String productGroupsTitle = "Product Groups";
    final String optionGroupsTab = "#app-.selected #doc-option_groups";
    final String optionGroupsTitle = "Option Groups";
    final String manufacturersTab = "#app-.selected #doc-manufacturers";
    final String manufacturersTitle = "Manufacturers";
    final String suppliersTab = "#app-.selected #doc-suppliers";
    final String suppliersTitle = "Suppliers";
    final String deliveryStatusesTab = "#app-.selected #doc-delivery_statuses";
    final String deliveryStatusesTitle = "Delivery Statuses";
    final String soldOutStatusesTab = "#app-.selected #doc-sold_out_statuses";
    final String soldOutStatusesTitle = "Sold Out Statuses";
    final String quantityUnitsTab = "#app-.selected #doc-quantity_units";
    final String quantityUnitsTitle = "Quantity Units";
    final String csvImportExportTabIntoCatalogTab = "#app-.selected #doc-csv";
    final String csvImportExportTitleIntoCatalogTab = "CSV Import/Export";
    //Countries
    final String countriesTab = "//li[@id = 'app-']/a/span[text() = 'Countries']";
    final String countriesTitle = "Countries";
    //Currencies
    final String currenciesTab = "//span[text() = 'Currencies']";
    final String currenciesTitle = "Currencies";
    //Customers
    final String customersTab = "//li[@id = 'app-']/a/span[text() = 'Customers']";
    final String customersTitle = "Customers";
    final String internalCustomersTab = "#app-.selected #doc-customers";
    final String csvImportExportTabIntoCustomersTab = "#app-.selected #doc-csv";
    final String csvImportExportTitleIntoCustomersTab = "CSV Import/Export";
    final String newsletterTab = "#app-.selected #doc-newsletter";
    final String newsletterTitle = "Newsletter";
    //Geo Zones
    final String geoZonesTab = "//li[@id = 'app-']/a/span[text() = 'Geo Zones']";
    final String geoZonesTitle = "Geo Zones";
    //Languages
    final String languagesTab = "//li[@id = 'app-']/a/span[text() = 'Languages']";
    final String languagesTitle = "Languages";
    final String internalLanguagesTab = "#app-.selected #doc-languages";
    final String storageEncodingTab = "#app-.selected #doc-storage_encoding";
    final String storageEncodingTitle = "Storage Encoding";
    //Modules
    final String modulesTab = "//li[@id = 'app-']/a/span[text() = 'Modules']";
    final String modulesTitle = "Job Modules";
    final String backgroundJobsTab = "#app-.selected #doc-jobs";
    final String backgroundJobsTitle = modulesTitle;
    final String customerTabIntoModulesTab = "#app-.selected #doc-customer";
    final String customerTitleIntoModulesTab = "Customer Modules";
    final String shippingTab = "#app-.selected #doc-shipping";
    final String shippingTitle = "Shipping Modules";
    final String paymentTab = "#app-.selected #doc-payment";
    final String paymentTitle = "Payment Modules";
    final String orderTotalTab = "#app-.selected #doc-order_total";
    final String orderTotalTitle = "Order Total Modules";
    final String orderSuccessTab = "#app-.selected #doc-order_success";
    final String orderSuccessTitle = "Order Success Modules";
    final String orderActionTab = "#app-.selected #doc-order_action";
    final String orderActionTitle = "Order Action Modules";
    //Orders
    final String ordersTab = "//li[@id = 'app-']/a/span[text() = 'Orders']";
    final String ordersTitle = "Orders";
    final String internalOrdersTab = "#app-.selected #doc-orders";
    final String orderStatusesTab = "#app-.selected #doc-order_statuses";
    final String orderStatusesTitle = "Order Statuses";
    //Pages
    final String pagesTab = "//li[@id = 'app-']/a/span[text() = 'Pages']";
    final String pagesTitle = "Pages";
    //Reports
    final String reportsTab = "//li[@id = 'app-']/a/span[text() = 'Reports']";
    final String reportsTitle = "Monthly Sales";
    final String monthlySalesTab = "#app-.selected #doc-monthly_sales";
    final String monthlySalesTitle = reportsTitle;
    final String mostSoldProductsTab = "#app-.selected #doc-most_sold_products";
    final String mostSoldProductsTitle = "Most Sold Products";
    final String mostShoppingCustomersTab = "#app-.selected #doc-most_shopping_customers";
    final String mostShoppingCustomersTitle = "Most Shopping Customers";
    //Settings
    final String settingsTab = "//li[@id = 'app-']/a/span[text() = 'Settings']";
    final String settingsTitle = "Settings";
    final String storeInfoTab = "#app-.selected #doc-store_info";
    final String storeInfoTitle = settingsTitle;
    final String defaultsTab = "#app-.selected #doc-defaults";
    final String defaultsTitle = settingsTitle;
    final String generalTab = "#app-.selected #doc-general";
    final String generalTitle = settingsTitle;
    final String listingsTab = "#app-.selected #doc-listings";
    final String listingsTitle = settingsTitle;
    final String imagesTab = "#app-.selected #doc-images";
    final String imagesTitle = settingsTitle;
    final String checkoutTab = "#app-.selected #doc-checkout";
    final String checkoutTitle = settingsTitle;
    final String advancedTab = "#app-.selected #doc-advanced";
    final String advancedTitle = settingsTitle;
    final String securityTab = "#app-.selected #doc-security";
    final String securityTitle = settingsTitle;
    //Slides
    final String slidesTab = "//li[@id = 'app-']/a/span[text() = 'Slides']";
    final String slidesTitle = "Slides";
    //Tax
    final String taxTab = "//li[@id = 'app-']/a/span[text() = 'Tax']";
    final String taxTitle = "Tax Classes";
    final String taxClassesTab = "#app-.selected #doc-tax_classes";
    final String taxClassesTitle = taxTitle;
    final String taxRatesTab = "#app-.selected #doc-tax_rates";
    final String taxRatesTitle = "Tax Rates";
    //Translations
    final String translationsTab = "//li[@id = 'app-']/a/span[text() = 'Translations']";
    final String translationsTitle = "Search Translations";
    final String searchTranslationsTab = "#app-.selected #doc-search";
    final String searchTranslationsTitle = translationsTitle;
    final String scanFilesTab = "#app-.selected #doc-scan";
    final String scanFilesTitle = "Scan Files For Translations";
    final String csvImportExportTabIntoTranslationsTab = "#app-.selected #doc-csv";
    final String csvImportExportTitleIntoTranslationsTab = "CSV Import/Export";
    //Users
    final String usersTab = "//li[@id = 'app-']/a/span[text() = 'Users']";
    final String usersTitle = "Users";
    //vQmods
    final String vQmodsTab = "//li[@id = 'app-']/a/span[text() = 'vQmods']";
    final String vQmodsTitle = "vQmods";
    final String internalYQmodsTab = "#app-.selected #doc-vqmods";


    @Test
    @DisplayName("Проверка работы кнопок левого навигационного меню панели админа")
    public void checkingButtonsOfLeftNavigationMenuAdminPanel() {
        goToAdminPageAndLoginThere();
        checkingSuccessfulNavigationToAppearencesTabs();
        checkingSuccessfulNavigationToCatalogsTabs();
        checkingSuccessfulNavigationToCountriesTabs();
        checkingSuccessfulNavigationToCurrenciesTabs();
        checkingSuccessfulNavigationToCustomersTabs();
        checkingSuccessfulNavigationToGeoZonesTabs();
        checkingSuccessfulNavigationToLanguagesTabs();
        checkingSuccessfulNavigationToModulesTabs();
        checkingSuccessfulNavigationToOrdersTabs();
        checkingSuccessfulNavigationToPagesTabs();
        checkingSuccessfulNavigationToReportsTabs();
        checkingSuccessfulNavigationToSettingsTabs();
        checkingSuccessfulNavigationToSlidesTabs();
        checkingSuccessfulNavigationToTaxsTabs();
        checkingSuccessfulNavigationToTranslationsTabs();
        checkingSuccessfulNavigationToUsersTabs();
        checkingSuccessfulNavigationToVQmodsTabs();
    }

    private void goToAdminPageAndLoginThere() {
        driver.navigate().to(adminAuthorizationPage.pageUrl);
        driver.findElement(cssSelector(adminAuthorizationPage.locatorOfUserNameField))
                .sendKeys(adminAuthorizationPage.adminLogin);
        driver.findElement(cssSelector(adminAuthorizationPage.locatorOfPasswordField))
                .sendKeys(adminAuthorizationPage.adminPassword);
        driver.findElement(cssSelector(adminAuthorizationPage.locatorOfLoginButton)).click();
        WebElement successNoticeElement =
                driver.findElement(cssSelector(adminAuthorizationPage.locatorOfSuccessNoticeText));
        wait.until(e -> successNoticeElement.isDisplayed());
        Assumptions.assumeTrue(driver.getCurrentUrl().contains(pageUrl), "Current page hasn't URL: " + pageUrl);
    }

    private void checkingSuccessfulNavigationToAppearencesTabs() {
        driver.findElement(xpath(appearenceTab)).click();
        Assertions.assertEquals(templateTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(templateTab)).click();
        Assertions.assertEquals(templateTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(logotypeTab)).click();
        Assertions.assertEquals(logotypeTitle, driver.findElement(cssSelector("h1")).getText());
    }

    private void checkingSuccessfulNavigationToCatalogsTabs() {
        driver.findElement(xpath(catalogTab)).click();
        Assertions.assertEquals(catalogTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(internalCatalogTab)).click();
        Assertions.assertEquals(catalogTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(productGroupsTab)).click();
        Assertions.assertEquals(productGroupsTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(optionGroupsTab)).click();
        Assertions.assertEquals(optionGroupsTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(manufacturersTab)).click();
        Assertions.assertEquals(manufacturersTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(suppliersTab)).click();
        Assertions.assertEquals(suppliersTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(deliveryStatusesTab)).click();
        Assertions.assertEquals(deliveryStatusesTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(soldOutStatusesTab)).click();
        Assertions.assertEquals(soldOutStatusesTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(quantityUnitsTab)).click();
        Assertions.assertEquals(quantityUnitsTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(csvImportExportTabIntoCatalogTab)).click();
        Assertions.assertEquals(csvImportExportTitleIntoCatalogTab, driver.findElement(cssSelector("h1")).getText());
    }

    private void checkingSuccessfulNavigationToCountriesTabs() {
        driver.findElement(xpath(countriesTab)).click();
        Assertions.assertEquals(countriesTitle, driver.findElement(cssSelector("h1")).getText());
    }

    private void checkingSuccessfulNavigationToCurrenciesTabs() {
        driver.findElement(xpath(currenciesTab)).click();
        Assertions.assertEquals(currenciesTitle, driver.findElement(cssSelector("h1")).getText());
    }

    private void checkingSuccessfulNavigationToCustomersTabs() {
        driver.findElement(xpath(customersTab)).click();
        Assertions.assertEquals(customersTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(internalCustomersTab)).click();
        Assertions.assertEquals(customersTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(csvImportExportTabIntoCustomersTab)).click();
        Assertions.assertEquals(csvImportExportTitleIntoCustomersTab, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(newsletterTab)).click();
        Assertions.assertEquals(newsletterTitle, driver.findElement(cssSelector("h1")).getText());
    }

    private void checkingSuccessfulNavigationToGeoZonesTabs() {
        driver.findElement(xpath(geoZonesTab)).click();
        Assertions.assertEquals(geoZonesTitle, driver.findElement(cssSelector("h1")).getText());
    }

    private void checkingSuccessfulNavigationToLanguagesTabs() {
        driver.findElement(xpath(languagesTab)).click();
        Assertions.assertEquals(languagesTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(internalLanguagesTab)).click();
        Assertions.assertEquals(languagesTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(storageEncodingTab)).click();
        Assertions.assertEquals(storageEncodingTitle, driver.findElement(cssSelector("h1")).getText());
    }

    private void checkingSuccessfulNavigationToModulesTabs() {
        driver.findElement(xpath(modulesTab)).click();
        Assertions.assertEquals(modulesTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(backgroundJobsTab)).click();
        Assertions.assertEquals(backgroundJobsTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(customerTabIntoModulesTab)).click();
        Assertions.assertEquals(customerTitleIntoModulesTab, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(shippingTab)).click();
        Assertions.assertEquals(shippingTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(paymentTab)).click();
        Assertions.assertEquals(paymentTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(orderTotalTab)).click();
        Assertions.assertEquals(orderTotalTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(orderSuccessTab)).click();
        Assertions.assertEquals(orderSuccessTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(orderActionTab)).click();
        Assertions.assertEquals(orderActionTitle, driver.findElement(cssSelector("h1")).getText());
    }

    private void checkingSuccessfulNavigationToOrdersTabs() {
        driver.findElement(xpath(ordersTab)).click();
        Assertions.assertEquals(ordersTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(internalOrdersTab)).click();
        Assertions.assertEquals(ordersTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(orderStatusesTab)).click();
        Assertions.assertEquals(orderStatusesTitle, driver.findElement(cssSelector("h1")).getText());
    }

    private void checkingSuccessfulNavigationToPagesTabs() {
        driver.findElement(xpath(pagesTab)).click();
        Assertions.assertEquals(pagesTitle, driver.findElement(cssSelector("h1")).getText());
    }

    private void checkingSuccessfulNavigationToReportsTabs() {
        driver.findElement(xpath(reportsTab)).click();
        Assertions.assertEquals(reportsTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(monthlySalesTab)).click();
        Assertions.assertEquals(monthlySalesTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(mostSoldProductsTab)).click();
        Assertions.assertEquals(mostSoldProductsTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(mostShoppingCustomersTab)).click();
        Assertions.assertEquals(mostShoppingCustomersTitle, driver.findElement(cssSelector("h1")).getText());
    }

    private void checkingSuccessfulNavigationToSettingsTabs() {
        driver.findElement(xpath(settingsTab)).click();
        Assertions.assertEquals(settingsTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(storeInfoTab)).click();
        Assertions.assertEquals(storeInfoTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(defaultsTab)).click();
        Assertions.assertEquals(defaultsTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(generalTab)).click();
        Assertions.assertEquals(generalTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(listingsTab)).click();
        Assertions.assertEquals(listingsTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(imagesTab)).click();
        Assertions.assertEquals(imagesTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(checkoutTab)).click();
        Assertions.assertEquals(checkoutTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(advancedTab)).click();
        Assertions.assertEquals(advancedTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(securityTab)).click();
        Assertions.assertEquals(securityTitle, driver.findElement(cssSelector("h1")).getText());
    }

    private void checkingSuccessfulNavigationToSlidesTabs() {
        driver.findElement(xpath(slidesTab)).click();
        Assertions.assertEquals(slidesTitle, driver.findElement(cssSelector("h1")).getText());
    }

    private void checkingSuccessfulNavigationToTaxsTabs() {
        driver.findElement(xpath(taxTab)).click();
        Assertions.assertEquals(taxTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(taxClassesTab)).click();
        Assertions.assertEquals(taxClassesTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(taxRatesTab)).click();
        Assertions.assertEquals(taxRatesTitle, driver.findElement(cssSelector("h1")).getText());
    }

    private void checkingSuccessfulNavigationToTranslationsTabs() {
        driver.findElement(xpath(translationsTab)).click();
        Assertions.assertEquals(translationsTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(searchTranslationsTab)).click();
        Assertions.assertEquals(searchTranslationsTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(scanFilesTab)).click();
        Assertions.assertEquals(scanFilesTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(csvImportExportTabIntoTranslationsTab)).click();
        Assertions.assertEquals(csvImportExportTitleIntoTranslationsTab,
                driver.findElement(cssSelector("h1")).getText());
    }

    private void checkingSuccessfulNavigationToUsersTabs() {
        driver.findElement(xpath(usersTab)).click();
        Assertions.assertEquals(usersTitle, driver.findElement(cssSelector("h1")).getText());
    }

    private void checkingSuccessfulNavigationToVQmodsTabs() {
        driver.findElement(xpath(vQmodsTab)).click();
        Assertions.assertEquals(vQmodsTitle, driver.findElement(cssSelector("h1")).getText());
        driver.findElement(cssSelector(internalYQmodsTab)).click();
        Assertions.assertEquals(vQmodsTitle, driver.findElement(cssSelector("h1")).getText());
    }
}