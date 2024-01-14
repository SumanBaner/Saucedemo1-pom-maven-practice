import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import javax.swing.text.Element;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class MethodRepository {
    private WebDriver driver;

    public void browserApplicationLaunch(String browserName, String url) throws InterruptedException {

        try {
            if (browserName.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }

            if (browserName.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
            if (browserName.equals("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
            }

            driver.get(url);
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //sauce Demo
    /*public void loginApplicationAndVerifyValidLogin() {
        try {
            Thread.sleep(3000);
            WebElement txtEmailAddress = driver.findElement(By.id("user-name"));
            txtEmailAddress.sendKeys("standard_user");
            WebElement txtPassword = driver.findElement(By.id("password"));
            txtPassword.sendKeys("secret_sauce");
            WebElement btnSignIn = driver.findElement(By.id("login-button"));
            btnSignIn.click();

            String expPageTitle = "Swag Labs";
            System.out.println(expPageTitle);
            String actPageTitle = driver.getTitle();
            System.out.println(actPageTitle);
            if (expPageTitle.equals(actPageTitle)) {
                System.out.println("Login is successful with valid credentials");
            } else {
                System.out.println("Login is unsuccessful with valid credentials");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }*/

    // BY id Identifier---Sauce Demo
       /* WebElement txtUsername = driver.findElement(By.id("user-name"));
        txtUsername.sendKeys("standard_user");

        WebElement txtPassword = driver.findElement(By.id("password"));
        txtPassword.sendKeys("secret_sauce");

        WebElement btnLogin = driver.findElement(By.id("login-button"));
        btnLogin.click();*/
//by absolute path-Sauce demo
    //WebElement txtUsername = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div/input"));
    //txtUsername.sendKeys("standard_user");
    //Thread.sleep(3000);

    //WebElement txtPassword = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div[2]/input"));
    // txtPassword.sendKeys("secret_sauce");
    //Thread.sleep(3000);
    //WebElement btnLogin = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/input"));
    //btnLogin.click();

    /*by relative path-In Sauce demo*/
    // WebElement txtEmailAddress = driver.findElement(By.xpath("//input[@id='user-name']"));
    // txtEmailAddress.sendKeys("standard_user");
    // Thread.sleep(3000);
    // WebElement txtPassword = driver.findElement(By.xpath("//input[@id='password']"));
    // txtPassword.sendKeys("secret_sauce");
    // Thread.sleep(3000);

    //WebElement btnLogin = driver.findElement(By.xpath("//input[@id='login-button']"));
    // btnLogin.click();
    //WebElement btnLogout = driver.findElement(By.id("logout_sidebar_link"));
    //btnLogout.click();
    public void selectFilter() throws InterruptedException {
        WebElement filterDropDown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        filterDropDown.click();
        Select st = new Select(filterDropDown);
        st.selectByValue("lohi");
        //st.selectByIndex(3);
        //st.selectByVisibleText("Name (A to Z)");
        Thread.sleep(5000);
    }

    public void loginWithPropertyFileData() throws InterruptedException, IOException {
        try {
            FileReader reader = new FileReader("./testdata/testdata.properties");
            Properties props = new Properties();
            props.load(reader);
            String uname = props.getProperty("username");
            String pwd = props.getProperty("password");

            //WebElement username = driver.findElement(By.id("user-name"));
            WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
            //WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
            username.sendKeys(uname);
            Thread.sleep(3000);
            //WebElement username = driver.findElement(By.id("user-name"));
            WebElement txtpassword = driver.findElement(By.xpath("//input[@id='password']"));
            //WebElement txtpassword = driver.findElement(By.xpath("//input[@id='password']"));
            txtpassword.sendKeys(pwd);
            Thread.sleep(3000);
            //WebElement btnLogin = driver.findElement(By.xpath("//input[@id='login-button']"));
            //WebElement btnLogin = driver.findElement(By.xpath("//*[@id='login-button']"));
            //btnLogin.click();
            WebElement btnSignIn = driver.findElement(By.id("login-button"));
            btnSignIn.click();
            String expPageTitle = "Swag Labs";
            System.out.println(expPageTitle);
            String actPageTitle = driver.getTitle();
            System.out.println(actPageTitle);
            if (expPageTitle.equals(actPageTitle)) {
                System.out.println("Login is successful with valid credentials");
            } else {
                System.out.println("Login is unsuccessful with valid credentials");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loginWithRobotClass() {
        try {
            FileReader reader = new FileReader("./testdata/testdata.properties");
            Properties props = new Properties();
            props.load(reader);
            String uname = props.getProperty("username");
            String pwd = props.getProperty("password");
            WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
            username.sendKeys(uname);
            Thread.sleep(3000);
            WebElement txtpassword = driver.findElement(By.xpath("//input[@id='password']"));
            txtpassword.sendKeys(pwd);
            Thread.sleep(3000);
            Robot robot = new Robot();
            Thread.sleep(3000);
            /* Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_NUM_LOCK, false); */
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(7000);
            //robot.keyRelease(3000);
            String expPageTitle = "My account - My Shop";
            String actPageTitle = driver.getTitle();
            if (expPageTitle.equals(actPageTitle)) {
                System.out.println("Login is successful with valid credentials");
            } else {
                System.out.println("Login is unsuccessful with valid credentials");
            }
        } catch (AWTException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedOperationException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loginWithImplicitWait() {
        try {
            WebElement btnSigninNavBar = driver.findElement(By.xpath("//a[@class='login']"));
            btnSigninNavBar.click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebElement txtUsername = driver.findElement(By.id("email"));
            txtUsername.sendKeys("louissuman16@gmail.com");
            WebElement txtPassword = driver.findElement(By.id("passwd"));
            txtPassword.sendKeys("secret_sauce");
            WebElement btnSignIn = driver.findElement(By.id("SubmitLogin"));
            btnSignIn.click();

            String expPageTitle = "Single Page Apps for GitHub Pages";
            String actPageTitle = driver.getTitle();

            if (expPageTitle.equals(actPageTitle)) {
                System.out.println("Login is successful with valid credentials");
            } else {
                System.out.println("Login is unsuccessful with valid credentials");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void ExplicitWait() {
        try {
            WebElement btnSignInNavBar = driver.findElement(By.xpath("//a[@class='login']"));
            btnSignInNavBar.click();
            WebElement txtEmailAddress = driver.findElement(By.id("email"));
            txtEmailAddress.sendKeys("louissuman16@gmail.com");
            WebElement txtPassword = driver.findElement(By.id("passwd"));
            txtPassword.sendKeys("123456");
            WebElement btnSignIn = driver.findElement(By.id("SubmitLogin"));
            btnSignIn.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@class='logout']")));
            String expPageTitle = "My account - My Shop";
            String actPageTitle = driver.getTitle();

            if (expPageTitle.equals(actPageTitle)) {
                System.out.println("Login is successful with valid credentials");
            } else {
                System.out.println("Login is unsuccessful with valid credentials");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void scrollElement() {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.guru99.com/test/guru99home/");
            Thread.sleep(5000);
            //WebElement emailTextBox = driver.findElement(By.id("philadelphia-field-email"));
            WebElement CourseSelDropDown = driver.findElement(By.id("awf_field-91977689"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            // js.executeScript("arguments[0].scrollIntoView();", emailTextBox);
            js.executeScript("arguments[0].scrollIntoView();", CourseSelDropDown);

            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void iframeHandling() {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.guru99.com/test/guru99home/");
            Thread.sleep(5000);
            driver.switchTo().frame("a077aa5e");

            WebElement imageInIframe = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", imageInIframe);
            Thread.sleep(4000);
            imageInIframe.click();

            /* driver.switchTo().parentFrame(); */
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrollDown() {
        try {
            //WebDriverManager.chromedriver().setup();
            //driver = new ChromeDriver();
            // driver.manage().window().maximize();
            // driver.get("https://demo.guru99.com/test/guru99home/");
            // driver.get("https://www.saucedemo.com/inventory.html");
            Thread.sleep(5000);
            WebElement element = driver.findElement(By.linkText("Sauce Labs Onesie"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
            //js.executeScript("window.scrollBy(0,-300)");
            //js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(5000);
            //js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrollUp() {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.guru99.com/test/guru99home/");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
            Thread.sleep(5000);
            //js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
            //js.executeScript("window.scrollTo(0,0)");
            js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void MenuButton() throws InterruptedException {
        Thread.sleep(3000);
        WebElement Menubtn = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        Menubtn.click();
    }

    public void LogOutButton() throws InterruptedException {
        Thread.sleep(4000);
        WebElement logoutbtn = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        logoutbtn.click();
    }

    public void AboutUs() throws InterruptedException {
        Thread.sleep(24000);
        WebElement abtus = driver.findElement(By.xpath("//a[@id='about_sidebar_link']"));
        abtus.click();
        driver.navigate().back();
    }

    public void actionClassMouseHandlingLogin() {
        try {
            WebElement txtEmailAddress = driver.findElement(By.id("user-name"));
            txtEmailAddress.sendKeys("standard_user");
            Thread.sleep(2000);
            WebElement txtPassword = driver.findElement(By.id("password"));
            txtPassword.sendKeys("secret_sauce");
            Thread.sleep(2000);
            WebElement btnSignIn = driver.findElement(By.id("login-button"));
            /* btnSignIn.click(); */
            Actions actions = new Actions(driver);
            //actions.click(btnSignIn).build().perform();
            Thread.sleep(4000);

            String expPageTitle = "My account - My Shop";
            String actPageTitle = driver.getTitle();

            if (expPageTitle.equals(actPageTitle)) {
                System.out.println("Login is successful with valid credentials");
            } else {
                System.out.println("Login is unsuccessful with valid credentials");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void actionRightClick() throws InterruptedException {
        try {
            WebElement txtEmailAddress = driver.findElement(By.id("user-name"));
            txtEmailAddress.sendKeys("standard_user");
            Actions actions = new Actions(driver);
            //actions.click(txtEmailAddress).build().perform();
            actions.contextClick(txtEmailAddress).build().perform();
            Thread.sleep(4000);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
        public void AddcartDoubleClickPostLogin() {
            try {
                Thread.sleep(6000);
                //WebElement addcart =driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
               // Actions actions = new Actions(driver);
               // actions.doubleClick(addcart).build().perform();
                WebElement DC= driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
                Actions actions=new Actions(driver);
                actions.doubleClick(DC).build().perform();

               //actions.click(addcart).build().perform();
                String expPageTitle = "My account - My Shop";
                String actPageTitle = driver.getTitle();

                if (expPageTitle.equals(actPageTitle)) {
                    System.out.println("Login is successful with valid credentials");
                } else {
                    System.out.println("Login is unsuccessful with valid credentials");
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        public void DragnDrop() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.guru99.com/test/drag_drop.html");
            Thread.sleep(5000);
            WebElement From=driver.findElement(By.xpath("//li[@id='credit2']/a"));
            WebElement To=driver.findElement(By.xpath("//ol[@id='bank']/li"));
            Actions action=new Actions(driver);
            action.dragAndDrop(From,To).build().perform();
            Thread.sleep(5000);
            WebElement From1= driver.findElement(By.xpath("//li[@id='fourth']/a"));
            WebElement To1=driver.findElement(By.xpath("//ol[@id='amt7']/li"));
            Actions act=new Actions(driver);
            act.dragAndDrop(From1,To1).build().perform();
            Thread.sleep(5000);
            WebElement From2= driver.findElement(By.xpath("//li[@id='credit1']/a"));
            WebElement To2= driver.findElement(By.xpath("//ol[@id='loan']/li"));
            Actions act1=new Actions(driver);
            act1.dragAndDrop(From2,To2).build().perform();
            Thread.sleep(5000);
            WebElement From3= driver.findElement(By.xpath("//li[@id='fourth']/a"));
            WebElement To3= driver.findElement(By.xpath("//ol[@id='amt8']/li"));
            Actions act2=new Actions(driver);
            act2.dragAndDrop(From3,To3).build().perform();
            Thread.sleep(5000);
            System.out.println("Perfect");

    }
    public void multipleWindowHandling() {
        try {
            Thread.sleep(5000);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/browser-windows");
            driver.manage().window().maximize();
            driver.findElement(By.id("windowButton")).click();
            Thread.sleep(5000);
            String mainWindowHandle = driver.getWindowHandle();
            System.out.println("This is main window information: " + mainWindowHandle);
            Set<String> allWindowHandles = driver.getWindowHandles();
            System.out.println("This is all window information: " + allWindowHandles);
            Iterator<String> iterator = allWindowHandles.iterator();
            // Here we will check if child window has other child windows and will fetch the heading of the child window
            while (iterator.hasNext()) {
                String childWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(childWindow)) {
                    driver.switchTo().window(childWindow);
                    WebElement text = driver.findElement(By.id("sampleHeading"));
                    System.out.println("Heading of child window is: " + text.getText());
                }
            }

            // Switching to Parent window that is Main Window.
            driver.switchTo().window(mainWindowHandle);
            //driver.switchTo().defaultContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }public void ishipWindowHandling() {
        try {
            Thread.sleep(5000);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.ishipdocs.com/ishipdocs/Secure/Login.aspx");
            driver.manage().window().maximize();
            String mainWindowHandle = driver.getWindowHandle();
            System.out.println("This is main window information: " + mainWindowHandle);
            Set<String> allWindowHandles = driver.getWindowHandles();
            System.out.println("This is all window information: " + allWindowHandles);
            Iterator<String> iterator = allWindowHandles.iterator();
            while (iterator.hasNext()) {
                String childWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(childWindow)) {
                    driver.switchTo().window(childWindow);
                    System.out.println(driver.switchTo().window(childWindow).getTitle());
                }
            }
            // Switching to Parent window that is Main Window.
            driver.switchTo().window(mainWindowHandle);
            //driver.switchTo().defaultContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void popups() throws InterruptedException, AWTException {

        Thread.sleep(5000);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.ishipdocs.com/ishipdocs/Secure/Login.aspx");
        driver.get(" https://app.arcfacilities.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //WebElement pp=driver.findElement(By.xpath("//div[@id='securityUpdateMessage']/div[1]/button"));
        WebElement af= driver.findElement(By.xpath("//div[@id='maintenance']/div/div/div/button"));
        Thread.sleep(3000);
        //pp.click();
        af.click();

    }

    public void dataDrivenExcel() throws IOException, InterruptedException {
        File file = new File("./testdata/testdataexcel1.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = wb.getSheet("Login");
        XSSFRow row = null;
        XSSFCell cell = null;
        String username = null;
        String Password = null;
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                cell = row.getCell(j);
                if (j == 0) {
                    username = cell.getStringCellValue();
                }
                if (j == 1) {
                    Password = cell.getStringCellValue();
                }
            }
            Thread.sleep(2000);
            driver.findElement(By.id("user-name")).clear();
            driver.findElement(By.id("user-name")).sendKeys(username);
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys(Password);
            driver.findElement(By.id("login-button")).click();
            Thread.sleep(5000);
            String result = null;
            try{
                Boolean isLoggedIn = driver.findElement(By.xpath("//*[@class='app_logo']")).isDisplayed();
                if(isLoggedIn==true)
                {
                    result="PASS";
                }
                System.out.println("Username: " + username + " -----> " + "Password: " + Password + " -----> Login Success? " + result );
                driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
                Thread.sleep(4000);
                driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
                Thread.sleep(5000);
            }catch(Exception e){
                Boolean isError = driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed();
                if(isError==true)
                {
                    result="FAIL";
                }
                System.out.println("Username: " + username + " -----> " + "Password: " + Password + " -----> Login Success? " + result );
                Thread.sleep(3000);
            }

        }


    }
    public void webTable() {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.guru99.com/test/web-table-element.php");
            driver.manage().window().maximize();
            Thread.sleep(10000);
            java.util.List<WebElement> col = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
            System.out.println("No of cols are : " +col.size());
            List<WebElement> rows = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
           //List <WebElement> rows = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[5]/td"));
            System.out.println("No of rows are : " +rows.size());

            for(int i = 1; i<=rows.size(); i++){
                String companyName = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[" + i + "]/td[1]")).getText();
                //System.out.println("Company name from list: " + companyName);
                if(companyName.equals("Kwality") || companyName.equals("REC") || companyName.equals("LIC Housing Fi") || companyName.equals("CESC Ltd.")){
                    String currentPrice = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[" + i + "]/td[4]")).getText();
                    System.out.println("The Current Price of " + companyName + " is: " + currentPrice);
                    break;
                }else{
                    System.out.println("Company name is not found");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //driver.close();
    }
    public void loginWithSikuli() throws InterruptedException, FindFailed {
        Thread.sleep(3000);
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        Thread.sleep(6000);
        String filePath = "E:\\TestAutomation\\SeleniumTest\\Projects\\Saucedemo1\\testdata\\sikuliFiles\\loginButtonSnap.PNG";
       //String filePath = "./sikuliFiles/";
       Screen sc = new Screen();
        Pattern loginButtonSnap=new Pattern(filePath + "loginButtonSnap.PNG");
        Thread.sleep(6000);
        sc.click(loginButtonSnap);
        Thread.sleep(6000);
    }


    public void CreateProj() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.skysite.com/?FirstTimeLogin=no");
        WebElement txtUsername = driver.findElement(By.id("UserID"));
        txtUsername.sendKeys("prosuman1@mailinator.com");
        WebElement txtPassword = driver.findElement(By.id("Password"));
        txtPassword.sendKeys("123456");
        WebElement btnLogin = driver.findElement(By.id("btnLogin"));
        btnLogin.click();
        Thread.sleep(6000);
        WebElement CreateProject = driver.findElement(By.xpath("//*[@name='create-prj']"));
        CreateProject.click();
        Thread.sleep(5000);
        WebElement Projectname = driver.findElement(By.xpath("//input[@id='txtProjectName']"));
        Projectname.sendKeys("style");
        Thread.sleep(5000);
        WebElement btncreateproj = driver.findElement(By.xpath("//button[@id='btnCreate']"));
        btncreateproj.click();
        Thread.sleep(4000);
        WebElement btnclose = driver.findElement(By.xpath("//*[@id='divProjectSettings']/div/div[1]/button"));
        btnclose.click();
        Thread.sleep(5000);

    }

    public void Createfol() throws InterruptedException, IOException, AWTException {
        WebElement CrtFolder = driver.findElement(By.xpath("//*[@id='aPrjAddFolder']"));
        CrtFolder.click();
        Thread.sleep(5000);
        WebElement CF = driver.findElement(By.xpath("//input[@id='txtFolderName']"));
        CF.sendKeys("Automation Testing");
        WebElement upf = driver.findElement(By.xpath("//button[@id='btnFolderCreateThisFolder']"));
        upf.click();
        Thread.sleep(15000);
        WebElement ChooseFiles2 = driver.findElement(By.xpath("//*[@id='btnSelectFiles']"));
        ChooseFiles2.click();
        Thread.sleep(8000);
        Runtime.getRuntime().exec("./Autoit/Upload.exe");
        Thread.sleep(6000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(4000);
        WebElement Dni = driver.findElement(By.xpath("//*[@id='DonotIndexFiles']"));
        Dni.click();
        Thread.sleep(30000);
        WebElement pc = driver.findElement(By.xpath("//div[@class='col-md-2 col-lg-2 pull-right text-right pblsh-padd admrg']"));
        pc.click();
    }

    public void Vwropenmarkup() throws InterruptedException, AWTException, FindFailed {
        WebElement Vwro= driver.findElement(By.xpath("//*[@class='preview document-preview-event']"));
        Vwro.click();
        Thread.sleep(25000);
        Robot robot = new Robot();
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(4000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(4000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(4000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(4000);
        String filePath1 = "E:\\TestAutomation\\SeleniumTest\\Projects\\Saucedemo1\\src\\testdata\\sikuliFiles\\";
        Screen sc1 = new Screen();
        Pattern markup = new Pattern(filePath1 + "Line.PNG.jpg");
        Thread.sleep(6000);
        sc1.click(markup);
        Thread.sleep(6000);
        String filePath = "E:\\TestAutomation\\SeleniumTest\\Projects\\Saucedemo1\\src\\testdata\\sikuliFiles\\";
        //String filePath = "./sikulefiles";
        Screen sc = new Screen();
        Pattern vwrSnap = new Pattern(filePath + "Area.JPG");
        Thread.sleep(6000);
        sc.click(vwrSnap);
        Thread.sleep(6000);


    }
}








































