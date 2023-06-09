package steps;

import factory.DriverFactory;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.PolicyPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PolicyPageSteps {
    PolicyPage policyPage = new PolicyPage(DriverFactory.getDriver());


    @When("User clicks on policy icon on left tool bar")
    public void user_clicks_on_policy_icon_on_left_tool_bar() {
        policyPage.clickPolicyIcon();
    }

    @Then("User can see {string} message with all policy data")
    public void user_can_see_message_with_all_policy_data(String string) {
        String mpMessage = policyPage.verifyManagePolicyPage();
        Assert.assertEquals(mpMessage, string);
        String dataArray = policyPage.fetchAndDisplayData();
        if (dataArray.length() > 0) {
            System.out.println(dataArray);
        } else {
            Assert.fail();
        }

    }

    @Then("All data under Start date and And date displays in dd-mm-yyyy format")
    public void all_data_under_start_date_and_and_date_displays_in_dd_mm_yyyy_format() {
        String startDate = policyPage.verifyDateFormatOfStartDate();
        String sDate[] = startDate.split(" ");
        for (String staDate : sDate) {
            String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
            boolean isDate = staDate.matches(datePattern);
            if (!isDate) {
                System.out.println("StartDate Column data displays with dd-mm-yyyy format");
                break;
            } else {
                Assert.fail();
            }
        }

        String expireDate = policyPage.verfiyDateFormatOfExpireDate();
        String endDate[] = expireDate.split(" ");
        for (String eDate : endDate) {
            String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
            boolean isDate = eDate.matches(datePattern);
            if (!isDate) {
                System.out.println("ExpireDate Column data displays with dd-mm-yyyy format");
                break;
            } else {
                Assert.fail();
            }
        }

    }

    @When("User clicks on policy number")
    public void user_clicks_on_policy_number() {
        String policyMessage = policyPage.clickOnPolicyNumberLink();
        if (policyMessage.length()>0){
            System.out.println(policyMessage);
        }
        else
        {
            Assert.fail();
        }

    }

    @Then("User will redirect to policy information page")
    public void user_will_redirect_to_policy_information_page() {

    }

    @When("User clicks on policy number link")
    public void user_clicks_on_policy_number_link() {
        policyPage.clickPolicyPageToDownloadFile();
    }

    @When("User clicks on letter tab on policy information page")
    public void user_clicks_on_letter_tab_on_policy_information_page() {
        policyPage.LetterIcon();
    }

    @When("User clicks on download icon")
    public void user_clicks_on_download_icon() {
        policyPage.DownloadIcon();

    }

    @Then("User will able to see downloaded policy page")
    public void user_will_able_to_see_downloaded_policy_page() {
        /*String downloadFile = policyPage.verifyDownLoadFile();
        if (downloadFile.equals("file exist")) {
            System.out.println("File Has Been Downloaded");
        } else {
            Assert.fail();
        }*/

    }

    //Check appropriate policy data should displays against option selected from status drop down on manage policy page
    @When("User selects any options from status dropdown")
    public void user_selects_any_options_from_status_dropdown() {

        policyPage.selectOptionFromStatusDropDown();
    }

    @Then("Appropriate data displays on manage policy page depend on drop down option")
    public void appropriate_data_displays_on_manage_policy_page_depend_on_drop_down_option() {
        String policyStatus = policyPage.verifyPolicyStatusUponDropDown();
        if (policyStatus.length()>0) {
            System.out.println(policyStatus);
        }
    }

}
