package testcases;
import common.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.*;

import java.util.Random;


public class TestCase {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-Condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC02() {
        System.out.println("User can't login with blank 'Username' textbox");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage LoginPage = homePage.gotoLoginPage();
        LoginPage.login("", Constant.PASSWORD);
        String actualErrorMsg = LoginPage.getlblLoginErrorMsg().getText();
        String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC03() {
        System.out.println("User cannot log into Railway with invalid password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage LoginPage = homePage.gotoLoginPage();
        LoginPage.login(Constant.USERNAME, "INVALID PASSWORD");
        String actualErrorMsg = LoginPage.getlblLoginErrorMsg().getText();
        String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC04() {
        System.out.println("Login page displays when un-logged User clicks on Book ticket tab");
        HomePage homePage = new HomePage();
        homePage.open();
        new BookTicketPage();
        BookTicketPage bookPage = homePage.gotoBookTicketPage();
        String actualURL = bookPage.getURL();
        String expectedURL = "http://railwayb1.somee.com/Account/Login.cshtml?ReturnUrl=/Page/BookTicketPage.cshtml";
        Assert.assertEquals(actualURL, expectedURL, "Error message is not displayed as expected");
    }

    @Test
    public void TC05() {
        System.out.println("TC05 - System shows message when user enters wrong password several times");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();

        for (int i = 0; i < 5; ++i) {
            loginPage.login(Constant.USERNAME, "INVALID PASSWORD");
        }
        loginPage.login(Constant.USERNAME, "INVALID PASSWORD");
        String actualErrorMsg = loginPage.getlblLoginErrorMsg().getText();
        String expectedErrorMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC06() {
        System.out.println("Additional pages display once user logged in");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        MyTicketPage ticketPage = homePage.gotoMyTicketPage();
        Assert.assertNotNull(ticketPage,"user cannot directed to My ticket page");
        ChangePasswordPage changePasswordPage = ticketPage.gotoChangePasswordPage();
        Assert.assertNotNull(changePasswordPage,"user cannot directed to Change Password page");
    }

    @Test
    public void TC07() {
        System.out.println("User can create new account");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage Registerpage = homePage.gotoRegisterPage();
        String actualMsg = Registerpage.login("hoanglc2401@gmail.com", "hoanglc2401", "hoanglc2401", "338912309").getWelcomeRegister();
        String expectedMsg = "Thank you for registering your account";
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC08() {
        System.out.println("User can't login with an account hasn't been activated");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage LoginPage = homePage.gotoLoginPage();
        LoginPage.login("gfdhfhf", "gfdgdfg");
        String actualErrorMsg = LoginPage.getlblLoginErrorMsg().getText();
        String expectedErrorMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC09() {
        System.out.println("User can change password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage LoginPage = homePage.gotoLoginPage();
        LoginPage.login(Constant.USERNAME, Constant.PASSWORD);
        new ChangePasswordPage();
        ChangePasswordPage CPPage = homePage.gotoChangePasswordPage();
        CPPage.change(Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
        String actualMsg = CPPage.getlblCPSuccessMsg().getText();
        String expectedMsg = "Your password has been updated";
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC10() {
        System.out.println("User can't create account with Confirm password is not the same with Password");
        HomePage homePage = new HomePage();
        homePage.open();
        new RegisterPage();
        RegisterPage Registerpage = homePage.gotoRegisterPage();
        Registerpage.login("slc@gmail.com", "slc48k211", "kakakaka", "2233445566");
        String actualMsg = Registerpage.getlblRegisterErrorMsg().getText();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC11() {
        System.out.println("User can't create account while password and PID fields are empty");
        HomePage homePage = new HomePage();
        homePage.open();
        new RegisterPage();
        RegisterPage Registerpage = homePage.gotoRegisterPage();
        Registerpage.login("due@gmail.com", "", "", "");
        String actualMsg = Registerpage.getlblRegisterErrorMsg().getText();
        String actualMsgpw = Registerpage.getlblRegisterErrorpwMsg().getText();
        String actualMsgpid = Registerpage.getlblRegisterErrorpidMsg().getText();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        String expectedMsgpw = "Invalid password length";
        String expectedMsgpid = "Invalid ID length";
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
        Assert.assertEquals(actualMsgpw, expectedMsgpw, "Welcome message is not displayed as expected");
        Assert.assertEquals(actualMsgpid, expectedMsgpid, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC12() {
        System.out.println("Errors display when password reset token is blank");
        HomePage homePage = new HomePage();
        homePage.open();
        new LoginPage();
        LoginPage lgp = homePage.gotoLoginPage();
        lgp.gotofwpwPage();
        lgp.Getemail(Constant.USERNAME);
        //
        Assert.assertEquals("flase", "BUG SEP 01!");
    }

    @Test
    public void TC13() {
        System.out.println("Errors display if password and confirm password don't match when resetting password");
        HomePage homePage = new HomePage();
        homePage.open();
        new LoginPage();
        LoginPage lgp = homePage.gotoLoginPage();
        lgp.gotofwpwPage();
        lgp.Getemail(Constant.USERNAME);
        //Chuyen trang k nhan duoc mail
        Assert.assertEquals("flase", "BUG SEP 02!");
    }

    @Test
    public void TC14() {
        System.out.println("User can book 1 ticket at a time");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        new BookTicketPage();
        BookTicketPage Btk = homePage.gotoBookTicketPage();
        Random random = new Random();
        int randomDateindex = random.nextInt(28) + 3;
        Btk.book(String.valueOf(randomDateindex), "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");
        String actualMsg = Btk.getlblBookSuccessMsg().getText();
        String expectedMsg = "Ticket booked successfully!";
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC15() {
        System.out.println("User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        TimetablePage ttp = homePage.gotoTimetablePage();
        BookTicketPage btp = ttp.gotobookticketPage("Huế", "Sài Gòn");
        String depart = btp.getselDepartfromvalue().getText();
        String arrive = btp.getselArrivevalue().getText();
        Assert.assertEquals(depart, "Huế", "Depart location is not displayed as expected");
        Assert.assertEquals(arrive, "Sài Gòn", "Arrive location is not displayed as expected");
    }

    @Test
    public void TC16() {
        System.out.println("User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login("hoanglc2401@gmail.com", "hoanglc2401");
        new BookTicketPage();
        BookTicketPage Btk = homePage.gotoBookTicketPage();
        Random random = new Random();
        int randomDateindex = random.nextInt(28) + 3;
        Btk = Btk.book(String.valueOf(randomDateindex), "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");
        String url = Btk.getURL();
        String id = url.split("id=")[1];
        MyTicketPage Mtp = homePage.gotoMyTicketPage();
        Mtp.CancelTicket(id);
    }
}

