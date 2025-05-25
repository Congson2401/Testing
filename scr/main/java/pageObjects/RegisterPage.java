package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    private final By _txtEmail = By.xpath("//*[@id=\"email\"]");
    private final By _txtPassword = By.xpath("//*[@id=\"password\"]");
    private final By _txtCfPassword = By.xpath("//*[@id=\"confirmPassword\"]");
    private final By _txtPID = By.xpath("//*[@id=\"pid\"]");
    private final By _btnRegister = By.xpath("//input[@value='Register']");
    private final By _lblRegisterErrorMsg = By.xpath("//p[@class='message error']");
    private final By _lblRegisterErrorpwMsg = By.xpath("//label[@for='password' and contains(@class, 'validation-error')]");
    private final By _lblRegisterErrorpidMsg = By.xpath("//label[@for='pid' and contains(@class, 'validation-error')]");

    public RegisterPage() {
    }

    public WebElement gettxtEmail() {
        return Constant.WEBDRIVER.findElement(this._txtEmail);
    }

    public WebElement gettxtPassword() {
        return Constant.WEBDRIVER.findElement(this._txtPassword);
    }

    public WebElement gettxtCFPassword() {
        return Constant.WEBDRIVER.findElement(this._txtCfPassword);
    }

    public WebElement gettxtPID() {
        return Constant.WEBDRIVER.findElement(this._txtPID);
    }

    public WebElement getTxtBtnRegister() {
        return Constant.WEBDRIVER.findElement(this._btnRegister);
    }

    public WebElement getlblRegisterErrorMsg() {
        return Constant.WEBDRIVER.findElement(this._lblRegisterErrorMsg);
    }

    public WebElement getlblRegisterErrorpwMsg() {
        return Constant.WEBDRIVER.findElement(this._lblRegisterErrorpwMsg);
    }

    public WebElement getlblRegisterErrorpidMsg() {
        return Constant.WEBDRIVER.findElement(this._lblRegisterErrorpidMsg);
    }

    public RegisterPage openRegisterPage() {
        Constant.WEBDRIVER.navigate().to("http://railwayb2.somee.com/Account/Confirm?confirmationCode=1jC9hNbnmCiwNrDaKkkjNA%3d%3d");
        return this;
    }

    public RegisterPage login(String email, String password, String CFpassword, String PID) {
        this.gettxtEmail().sendKeys(new CharSequence[]{email});
        this.gettxtPassword().sendKeys(new CharSequence[]{password});
        this.gettxtCFPassword().sendKeys(new CharSequence[]{CFpassword});
        this.gettxtPID().sendKeys(new CharSequence[]{PID});
        this.getTxtBtnRegister().submit();
        return new RegisterPage();
    }
}
