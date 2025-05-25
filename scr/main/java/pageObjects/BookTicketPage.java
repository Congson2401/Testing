package pageObjects;
import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Date;
public class BookTicketPage extends GeneralPage {
    String Url_Login_Page;
    private final By _selDateDepart = By.xpath("//*[@id=\"content\"]/div[1]/form/fieldset/ol/li[1]/select");
    private final By _selDepartfrom = By.xpath("//*[@id=\"content\"]/div[1]/form/fieldset/ol/li[2]/select");
    private final By _selDepartfromvalue = By.xpath("//*[@id=\"content\"]/div[1]/form/fieldset/ol/li[2]/select/option[@selected='selected']");
    private final By _selArrive = By.xpath("//*[@id=\"ArriveStation\"]/select");
    private final By _selArrivevalue = By.xpath("//*[@id=\"ArriveStation\"]/select/option[@selected='selected']");
    private final By _selSeatType = By.xpath("//*[@id=\"content\"]/div[1]/form/fieldset/ol/li[4]/select");
    private final By _selTicketAmount = By.xpath("//*[@id=\"content\"]/div[1]/form/fieldset/ol/li[5]/select");
    private final By _btnBookTicket = By.xpath("//*[@id=\"content\"]/div[1]/form/fieldset/input");
    private final By _lblBookSuccessMsg = By.xpath("//*[@id=\"content\"]/h1");

    public BookTicketPage() {
    }

    public WebElement getselDatepart() {
        return Constant.WEBDRIVER.findElement(this._selDateDepart);
    }

    public WebElement getselDepartfrom() {
        return Constant.WEBDRIVER.findElement(this._selDepartfrom);
    }

    public WebElement getselDepartfromvalue() {
        return Constant.WEBDRIVER.findElement(this._selDepartfromvalue);
    }

    public WebElement getselArrivevalue() {
        return Constant.WEBDRIVER.findElement(this._selArrivevalue);
    }

    public String getCurrentPage() {
        this.Url_Login_Page = Constant.WEBDRIVER.getCurrentUrl();
        return this.Url_Login_Page;
    }

    public WebElement getselArrive() {
        return Constant.WEBDRIVER.findElement(this._selArrive);
    }

    public WebElement getselSeatType() {
        return Constant.WEBDRIVER.findElement(this._selSeatType);
    }

    public WebElement getselTicketAmount() {
        return Constant.WEBDRIVER.findElement(this._selTicketAmount);
    }

    public WebElement getbtnBookTicket() {
        return Constant.WEBDRIVER.findElement(this._btnBookTicket);
    }

    public WebElement getlblBookSuccessMsg() {
        return Constant.WEBDRIVER.findElement(this._lblBookSuccessMsg);
    }

    public BookTicketPage book(String Datepart, String Departfrom, String Arriveat, String Seattype, String ticketamt) {
        this.getselDatepart().sendKeys(new CharSequence[]{Datepart});
        this.getselDepartfrom().sendKeys(new CharSequence[]{Departfrom});
        this.getselArrive().sendKeys(new CharSequence[]{Arriveat});
        this.getselSeatType().sendKeys(new CharSequence[]{Seattype});
        this.getselTicketAmount().sendKeys(new CharSequence[]{ticketamt});
        this.getbtnBookTicket().submit();
        return new BookTicketPage();
    }

    public String getTicketID() {
        return this.getURL();
    }
}
