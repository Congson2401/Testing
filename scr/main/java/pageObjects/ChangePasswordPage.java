package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

    public class ChangePasswordPage extends GeneralPage {
        private final By _txtChangePassword = By.xpath("//h1[@align='center']");
        private final By _txtcrPassword = By.xpath("//*[@id=\"currentPassword\"]");
        private final By _txtnewPassword = By.xpath("//*[@id=\"newPassword\"]");
        private final By _txtcfPassword = By.xpath("//*[@id=\"confirmPassword\"]");
        private final By _btnChangePassword = By.xpath("//input[@value='Change Password']");
        private final By _lblCPSuccessMsg = By.xpath("//p[@class='message success']");

        public ChangePasswordPage() {
        }

        public WebElement gettxtcrPassword() {
            return Constant.WEBDRIVER.findElement(this._txtcrPassword);
        }

        public WebElement gettxtnewPassword() {
            return Constant.WEBDRIVER.findElement(this._txtnewPassword);
        }

        public WebElement gettxtcfPassword() {
            return Constant.WEBDRIVER.findElement(this._txtcfPassword);
        }

        public WebElement getBtnChangePassword() {
            return Constant.WEBDRIVER.findElement(this._btnChangePassword);
        }

        public WebElement getlblCPSuccessMsg() {
            return Constant.WEBDRIVER.findElement(this._lblCPSuccessMsg);
        }

        public WebElement getChangePasswordPage() {
            return Constant.WEBDRIVER.findElement(this._txtChangePassword);
        }

        public ChangePasswordPage change(String crpassword, String newpassword, String cfpassword) {
            this.gettxtcrPassword().sendKeys(new CharSequence[]{crpassword});
            this.gettxtnewPassword().sendKeys(new CharSequence[]{newpassword});
            this.gettxtcfPassword().sendKeys(new CharSequence[]{cfpassword});
            this.getBtnChangePassword().submit();
            return new ChangePasswordPage();
        }
    }

