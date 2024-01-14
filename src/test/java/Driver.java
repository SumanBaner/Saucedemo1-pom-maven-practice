import org.sikuli.script.FindFailed;

import java.awt.*;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws InterruptedException, IOException, AWTException, FindFailed {
        MethodRepository mr=new MethodRepository();
        //mr.browserApplicationLaunch("chrome","https://demoqa.com/buttons");
       //mr.browserApplicationLaunch("chrome","https://www.saucedemo.com");
        //mr.browserApplicationLaunch("chrome","http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        //mr.loginApplicationAndVerifyValidLogin();
      // mr.loginWithPropertyFileData();
        //mr.loginWithRobotClass();
        //mr.selectFilter();
        //mr.loginWithImplicitWait();
       //mr.ExplicitWait();
        //mr.scrollElement();
        //mr.iframeHandling();
       //mr.scrollDown();
        //mr.scrollUp();
        //mr.MenuButton();
        //mr.AboutUs();
      //mr.LogOutButton();
       //mr.actionClassMouseHandlingLogin();
       // mr.actionRightClick();
        //mr.multipleWindowHandling();
       //mr.AddcartDoubleClickPostLogin();
        //mr.DragnDrop();
       //mr.ishipWindowHandling();
        //mr.popups();
        //mr.loginWithPropertyFileData();
       //mr.dataDrivenExcel();
        //mr.webTable();
       // mr.loginWithSikuli();
        mr.CreateProj();
        mr.Createfol();
        mr.Vwropenmarkup();


    }
}
