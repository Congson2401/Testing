package pageObjects;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.Constant;

public class GeneralPage {
    private final By tabLogin = By.xpath("//*[@id=\"menu\"]/ul/li[8]/a/span");
    private final By tabBookTicket = By.xpath("//*[@id=\"menu\"]/ul/li[6]/a");
    private final By tabMyTicket = By.xpath("//*[@id=\"menu\"]/ul/li[7]/a");
    private final By tabChangePassword = By.xpath("//*[@id=\"menu\"]/ul/li[8]/a");
    private final By tabTimetable = By.xpath("//*[@id=\"menu\"]/ul/li[4]/a");
    private final By tabLogout = By.xpath("//*[@id=\"menu\"]/ul/li[9]/a");
    private final By tabRegister = By.xpath("//*[@id=\"menu\"]/ul/li[7]/a");
    private final By lblWelcomeMessage = By.xpath("//*[@id=\"banner\"]/div/strong");
    private final By lblWelcomeRegister = By.xpath("//*[@id=\"content\"]/p");
    private final By _linkFPwPage = By.xpath("//*[@id=\"content\"]/ul/li[3]/a");

    public GeneralPage() {
    }

    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(this.tabLogin);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(this.tabLogout);
    }

    protected WebElement getMyTicket() {
        return Constant.WEBDRIVER.findElement(this.tabMyTicket);
    }

    protected WebElement getChangePassword() {
        return Constant.WEBDRIVER.findElement(this.tabChangePassword);
    }

    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(this.lblWelcomeMessage);
    }

    protected WebElement getLblWelcomeRegister() {
        return Constant.WEBDRIVER.findElement(this.lblWelcomeRegister);
    }

    protected WebElement getBookTicket() {
        return Constant.WEBDRIVER.findElement(this.tabBookTicket);
    }

    protected WebElement getRegister() {
        return Constant.WEBDRIVER.findElement(this.tabRegister);
    }

    protected WebElement getTabForgetPW() {
        return Constant.WEBDRIVER.findElement(this._linkFPwPage);
    }

    protected WebElement getTabTimetable() {
        return Constant.WEBDRIVER.findElement(this.tabTimetable);
    }

    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public String getWelcomeRegister() {
        return this.getLblWelcomeRegister().getText();
    }

    public LoginPage gotoLoginPage() {
        this.getTabLogin().click();
        return new LoginPage();
    }

    public BookTicketPage gotoBookTicketPage() {
        this.getBookTicket().click();
        return new BookTicketPage();
    }

    public MyTicketPage gotoMyTicketPage() {
        this.getMyTicket().click();
        return new MyTicketPage();
    }

    public ChangePasswordPage gotoChangePasswordPage() {
        this.getChangePassword().click();
        return new ChangePasswordPage();
    }

    public LogoutPage gotoLogoutPage() {
        this.getTabLogout().click();
        return new LogoutPage();
    }

    public RegisterPage gotoRegisterPage() {
        this.getRegister().click();
        return new RegisterPage();
    }

    public LoginPage gotofwpwPage() {
        this.getTabForgetPW().click();
        return new LoginPage();
    }

    public TimetablePage gotoTimetablePage() {
        this.getTabTimetable().click();
        return new TimetablePage();
    }

    public String getURL() {
        return Constant.WEBDRIVER.getCurrentUrl();
    }

    public Alert getAlert() {
        return Constant.WEBDRIVER.switchTo().alert();
    }
}