package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class MyTicketPage extends GeneralPage {
    private final By _txtTicket = By.xpath("//h1[@align='center']");
    private final String btnCancel1 = "//input[@onclick='DeleteTicket(";
    private final String btnCancel2 = ");']";

    public MyTicketPage() {
    }

    public WebElement getMyTicketPage() {
        return Constant.WEBDRIVER.findElement(this._txtTicket);
    }

    public void CancelTicket(String id) {
        By btnCancel = By.xpath("//input[@onclick='DeleteTicket(" + id + ");']");
        Constant.WEBDRIVER.findElement(btnCancel).click();
    }

    public boolean CheckCancel(String id) {
        By btnCancel = By.xpath("//input[@onclick='DeleteTicket(" + id + ");']");

        try {
            Constant.WEBDRIVER.findElement(btnCancel);
            return false;
        } catch (NoSuchElementException var4) {
            return true;
        }
    }
}

