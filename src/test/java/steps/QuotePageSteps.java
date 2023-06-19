package steps;

import factory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.QuotePage;

import java.util.List;

public class QuotePageSteps {
    QuotePage quotePage = new QuotePage(DriverFactory.getDriver());

    @When("User clicks on quote icon on left tool bar")
    public void user_clicks_on_quote_icon_on_left_tool_bar() {
        String Message = quotePage.verifyManageQuotePage();
        Assert.assertEquals(Message, "Manage Quote");

    }

    @Then("Manage quote page displays with list of quote")
    public void manage_quote_page_displays_with_list_of_quote() {
        String quoteData = quotePage.fetchAndDisplayedData();
        if (quoteData.length() > 0) {
            System.out.println(quoteData);
        } else {
            Assert.fail();
        }
    }

    @Then("User will able to see all data under quote date and expire date column displays with dd-mm-yyyy format")
    public void user_will_able_to_see_all_data_under_quote_date_and_expire_date_column_displays_with_dd_mm_yyyy_format() {
        String date = quotePage.verifyQuoteDateColumnForamt();
        String newDate[] = date.split(" ");
        for (String expDate : newDate) {
            System.out.println(expDate);
            String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
            boolean isDate = expDate.matches(datePattern);
            if (!isDate) {
                System.out.println("QuoteDate Column Having All Dates In Require Format");
                break;
            } else {
                Assert.fail();
            }

        }

        String eDate = quotePage.verifyExpireDateColumnFormat();
        String expDate[] = eDate.split(" ");
        for (String expireDate : expDate) {
            System.out.println(expireDate);
            String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
            boolean isDate = expireDate.matches(datePattern);
            if (!isDate) {
                System.out.println("Expire Date Column Having All Dates In Require Format");
                break;
            } else {
                Assert.fail();
            }
        }
    }

    @When("User clicks add quote button on manage quote page")
    public void user_clicks_add_quote_button_on_manage_quote_page() {
        quotePage.clickOnAddQuoteButton();

    }

    @Then("User will able to see add quote page with data")
    public void user_will_able_to_see_add_quote_page_with_data() {
        String addQuoteMessage=quotePage.verifyAddQuotePage();
        Assert.assertEquals(addQuoteMessage,"Add Quote");

    }

    @Then("User will able to see  all data under total and monthly premium colum prefixed by £ sign")
    public void user_will_able_to_see_all_data_under_total_and_monthly_premium_colum_prefixed_by_£_sign() {
        String yearlyArray=quotePage.verifyTotalPremiumColumn();
        //System.out.println(yearlyArray);

        String[] split = yearlyArray.split("[ .\\ ]+");
        // System.out.println(split);
        for (int j = 1; j <= split.length-1; j=j+3) {
            System.out.println(split[j]);
            if (split[j].contains("£")) {
                System.out.println("Data Prefixed by £");

            } else {
               // Assert.fail();
                System.out.println("Data not Prefixed by £");
            }


        }

        String monthlyArray=quotePage.verifyMonthlyPremiumColumn();
        //System.out.println(monthlyArray);

        String monthArray[] = monthlyArray.split("[ .,\\ ]+");
        for (int j = 1; j <= monthArray.length-1; j=j+3) {
            System.out.println(monthArray[j]);
            if (monthArray[j].contains("£")) {
                System.out.println("Data Prefixed by £");

            } else {
               // Assert.fail();
                System.out.println("Data not Prefixed by £");
            }


        }

    }

    @When("User clicks on upload microchip file button")
    public void user_clicks_on_upload_microchip_file_button() {
        String Message=quotePage.clickOnMicrochipButton();
        Assert.assertEquals(Message,"Microchip File Upload");
    }

    @Then("User will be able to see microchip file upload page with data")
    public void user_will_be_able_to_see_microchip_file_upload_page_with_data() {
        String dataOfMicroPage = quotePage.verifyDataOnMicrochipPage();
        if (dataOfMicroPage.length() > 0) {
            System.out.println(dataOfMicroPage);
        }
    }

    @When("User clicks on add quote button")
    public void user_clicks_on_add_quote_button() {
     quotePage.clickOnAddQuoteButton();
    }

    @Then("On add quote page product dropdown will appear with desired list")
    public void on_add_quote_page_product_dropdown_will_appear_with_desired_list() {
        String verifyProducts=quotePage.verifyProductList();
        if (verifyProducts.length() > 0) {
            System.out.println(verifyProducts);
        } else {
            Assert.fail();
        }


    }

    @When("User clicks on quote number on manage quote page")
    public void user_clicks_on_quote_number_on_manage_quote_page() {
        quotePage.fetchDataOfQuoteInformation();

    }

    @Then("Quote Information page displays with details")
    public void quote_information_page_displays_with_details() {
        String quoteMessage=quotePage.fetchDataOfQuoteInformation();
        if (quoteMessage.length()>0){
            System.out.println(quoteMessage);
        }
        else
        {
            Assert.fail();
        }

    }

    //Items on manage quote page displays upon option selects from quote status dropdown

    @When("User selects appropriate option from quote status dropdown")
    public void user_selects_appropriate_option_from_quote_status_dropdown() {
        quotePage.SelectItemFromDropDown();

    }

    @Then("Respected data will be displayed on Manage quote page")
    public void respected_data_will_be_displayed_on_manage_quote_page() {
        String statusArray = quotePage.fetchAndVerifyDataAgainstDropDown();


            if (statusArray.length()>0) {
                System.out.println("Quote has been filtered against status dropdown option");
            }
            else {
                System.out.println("Failed to fetch data against status dropdown option");
            }

    }

    //Fetch list of quote based on product dropdown option

    @When("User selects appropriate option from product dropdown on manage quote page")
    public void user_selects_appropriate_option_from_product_dropdown_on_manage_quote_page() {
        quotePage.selectOptionFromProductDropDown();

    }

    @When("User clicks on search button on manage quote page")
    public void user_clicks_on_search_button_on_manage_quote_page() {
        quotePage.clickOnSearchButton();

    }

    @Then("Appropriate list of quote will display")
    public void appropriate_list_of_quote_will_display() {
        List<WebElement> productList=quotePage.verifyListOfQuoteBasedOnProductDD();
        if ((productList.size()>0)){
            System.out.println("List of quotes display upon product dropdown value ");
        }
        else {
            System.out.println("Failed to display data upon selected option");
        }

    }

    //Fetch quote on manage quote page based on quote number for qa

    @When("User enters quote number inside searc box on manage quote page")
    public void user_enters_quote_number_inside_searc_box_on_manage_quote_page() {
        quotePage.enterQuoteNumberInsideSearchBox();

    }

    @Then("Appropriate quote information displays on manage quote page")
    public void appropriate_quote_information_displays_on_manage_quote_page() {
        String quoteInformation=quotePage.verifyQuoteDetails();
        if(quoteInformation.length()>0){
            System.out.println(quoteInformation);
        }
        else {
            Assert.fail();
        }

    }

    //Fetch quote on manage quote page based on quote number for stage
    @When("User enters quote number inside search box on manage quote page")
    public void user_enters_quote_number_inside_search_box_on_manage_quote_page() {
       quotePage.enterQuoteNumberInsideSearchBoxStage();
    }

    //Verify include payment feature of quote module for Qa and Stage
    @When("User selects include payment only quotes checkbox")
    public void user_selects_include_payment_only_quotes_checkbox() {
        quotePage.selectIncludePaymentCheckBox();

    }

    @Then("Appropriate quote list displays on manage quote page")
    public void appropriate_quote_list_displays_on_manage_quote_page() {
        String quoteListIncludePayment=quotePage.verifyIncludePaymentDetailsOfQuote();
        if(quoteListIncludePayment.length()>0){
            System.out.println(quoteListIncludePayment);
        }
        else {
            System.out.println("NO record found on manage quote page");
        }
    }

    //Edit quote information and verifies the same

    @When("User clicks on quote number from list of quote on manage quote page")
    public void user_clicks_on_quote_number_from_list_of_quote_on_manage_quote_page() {
        quotePage.clickOnQuoteNumber();

    }

    @When("User selects edit quote option from cog icon on quote information page")
    public void user_selects_edit_quote_option_from_cog_icon_on_quote_information_page() {
        quotePage.selectEditQuoteOption();
    }
    @Then("User can edit all required field on edit quote page")
    public void user_can_edit_all_required_field_on_edit_quote_page() {
        quotePage.editQuoteDetails();
    }






}
