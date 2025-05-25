package pageObjects;


import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TimetablePage extends GeneralPage {
    private final By tabbookticket = By.xpath("//*[@id=\"content\"]/div/div/table/tbody/tr[2]/td[7]/a");
    private final String findticket1 = "//td[text()='";
    private final String findticket2 = "']/following-sibling::td[text()='";
    private final String findticket3 = "']/../td[7]/a";

    public TimetablePage() {
    }

    public WebElement gettabbookticket(String depart, String arrive) {
        if (depart == "" & arrive == "") {
            return Constant.WEBDRIVER.findElement(this.tabbookticket);
        } else {
            By tabbookticket = By.xpath("//td[text()='" + depart + "']/following-sibling::td[text()='" + arrive + "']/../td[7]/a");
            return Constant.WEBDRIVER.findElement(tabbookticket);
        }
    }

    public BookTicketPage gotobookticketPage(String depart, String arrive) {
        (new Actions(Constant.WEBDRIVER)).scrollByAmount(0, 500).perform();
        this.gettabbookticket(depart, arrive).click();
        return new BookTicketPage();
    }
}
