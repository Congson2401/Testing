package pageObjects;
import common.Constant;
import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
public class LoginPage extends GeneralPage {
    private final By _txtUsername = By.xpath("//*[@id=\"username\"]");
    private final By _txtPassword = By.xpath("//*[@id=\"password\"]");
    private final By _btnLogin = By.xpath("//*[@id=\"content\"]/form/fieldset/p/input");
    private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By _txtEmailAddress = By.xpath("//*[@id=\"email\"]");
    private final By _btnSendIn = By.xpath("//*[@id=\"content\"]/form/fieldset/p[2]/input");
    private final By _txtmesresetpw = By.xpath("/html/body/span/h1");

    public LoginPage() {
    }

    public WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(this._txtUsername);
    }

    public WebElement getTxtresetpw() {
        return Constant.WEBDRIVER.findElement(this._txtmesresetpw);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(this._txtPassword);
    }

    public WebElement getTxtBtnLogin() {
        return Constant.WEBDRIVER.findElement(this._btnLogin);
    }

    public WebElement getlblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(this._lblLoginErrorMsg);
    }

    public WebElement getlblBookTicketErrorMsg() {
        return Constant.WEBDRIVER.findElement(this._lblLoginErrorMsg);
    }

    public WebElement getTxtEmailAddress() {
        return Constant.WEBDRIVER.findElement(this._txtEmailAddress);
    }

    public WebElement getBtnSendIn() {
        return Constant.WEBDRIVER.findElement(this._btnSendIn);
    }

    public HomePage login(String username, String password) {
        this.getTxtUsername().sendKeys(new CharSequence[]{username});
        this.getTxtPassword().sendKeys(new CharSequence[]{password});
        this.getTxtBtnLogin().submit();
        return new HomePage();
    }

    public LoginPage Getemail(String sendemail) {
        this.getTxtEmailAddress().sendKeys(new CharSequence[]{sendemail});
        this.getBtnSendIn().submit();
        return new LoginPage();
    }
}
