package simples;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class Calc {

    private AndroidDriver <MobileElement> driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "9.0");
        desiredCapabilities.setCapability("browserName", "");
        desiredCapabilities.setCapability("appiumVersion", "1.19.2");
        desiredCapabilities.setCapability("deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator");
        desiredCapabilities.setCapability("deviceOrientation", "portrait");
        desiredCapabilities.setCapability("app", "storage:filename=Calculator_v7.8 (271241277)_apkpure.com.apk");
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("SAUCE_USERNAME", "marilia.laviola");
        desiredCapabilities.setCapability("SAUCE_ACCESS_KEY", "90d204cf-597b-4e1d-b496-6665c573692b");

        URL remoteUrl = new URL("https://marilia.laviola:90d204cf-597b-4e1d-b496-6665c573692b@ondemand.us-west-1.saucelabs.com:443/wd/hub");

        driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
    }

    @Test
    public void somarDoisNumeros() {

        String resultadoEsperado = "5";

        MobileElement btn2 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        btn2.click();
        MobileElement btnSoma = (MobileElement) driver.findElementByAccessibilityId("plus");
        btnSoma.click();
        MobileElement btn3 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
        btn3.click();
        MobileElement btnIgual = (MobileElement) driver.findElementByAccessibilityId("equals");
        btnIgual.click();
        MobileElement lblResultadoAtual = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        assertEquals(resultadoEsperado,lblResultadoAtual.getText() );

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
