//Pacote
package avancado;

//Bibliotecas
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;


public class Calcular {

    private MobileElement btnOperacao;
    private AndroidDriver<MobileElement> driver;
    private DesiredCapabilities desiredCapabilities;
    private URL remoteUrl;
    private static String nomePasta = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());
    private Massa massa;

    // Fun��es ou M�todos de Apoio
    public void print(String nomePrint) throws IOException {
        File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        System.out.println("nomePasta: " + nomePasta);
        FileUtils.copyFile(foto, new File("target/" + nomePasta + "/" + nomePrint + ".png"));


    }


    @Before
    public void setUp() throws MalformedURLException {
        /*
        Valores previstos de flag:
        EL = Emulador local
        EN = Emulador na N�vem
        DL = Dispositivo Local
        DN = Dispositivo na N�vem
         */

        String flag = "EN";

        desiredCapabilities = new DesiredCapabilities();

        switch (flag) {
            case "EL":
                desiredCapabilities.setCapability("platformName", "Android");
                desiredCapabilities.setCapability("platformVersion", "9.0");
                desiredCapabilities.setCapability("deviceName", "emulator-5554");
                desiredCapabilities.setCapability("automationName", "uiautomator2");
                desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
                desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

                remoteUrl = new URL("https://127.0.0.1:4723/wd/hub");

                break;
            case "EN":
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

                remoteUrl = new URL("https://marilia.laviola:90d204cf-597b-4e1d-b496-6665c573692b@ondemand.us-west-1.saucelabs.com:443/wd/hub");

                break;
            case "DL":
                //TODO: a programar
                break;
            case "DN":
                //TODO: a programar
                break;
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("^abro a calculadora do Google no meu smartphone$")
    public void abroACalculadoraDoGoogleNoMeuSmartphone() {
        driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
    }

    @When("^seleciono \"([^\"]*)\" mais \"([^\"]*)\" e pressiono o botao Igual$")
    public void selecionoMaisEPressionoOBotaoIgual(String num1, String num2) throws IOException {
        print("Somar Dois Numeros Positivos - Passo 1 - Abriu a Calculadora");
        MobileElement btnA = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_" + num1);
        btnA.click();
        print("Somar Dois Numeros Positivos - Passo 2 - Clicou no bot�o " + num1);
        MobileElement btnSoma = (MobileElement) driver.findElementByAccessibilityId("plus");
        btnSoma.click();
        print("Somar Dois Numeros Positivos - Passo 3 - Clicou no bot�o de soma");
        MobileElement btnB = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_" + num2);
        btnB.click();
        print("Somar Dois Numeros Positivos - Passo 4 - Clicou no bot�o " + num2);
        MobileElement btnIgual = (MobileElement) driver.findElementByAccessibilityId("equals");
        btnIgual.click();
        print("Somar Dois Numeros Positivos - Passo 5 - Clicou no bot�o Igual");

    }

    @Then("^exibe o resultado como \"([^\"]*)\"$")
    public void exibeOResultadoComo(String resultadoEsperado) {
        MobileElement lblResultadoAtual = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        assertEquals(resultadoEsperado, lblResultadoAtual.getText());
    }

    @When("^seleciono \"([^\"]*)\" menos \"([^\"]*)\" e pressiono o botao Igual$")
    public void selecionoMenosEPressionoOBotaoIgual(String num1, String num2) throws IOException{
        print("Diminuir Dois Numeros Positivos - Passo 1 - Abriu a Calculadora");
        MobileElement btnA = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_" + num1);
        btnA.click();
        print("Diminuir Dois Numeros Positivos - Passo 2 - Clicou no bot�o " + num1);
        MobileElement btnMenos = (MobileElement) driver.findElementByAccessibilityId("minus");
        btnMenos.click();
        print("Diminuir Dois Numeros Positivos - Passo 3 - Clicou no bot�o de menos");
        MobileElement btnB = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_" + num2);
        btnB.click();
        print("Diminuir Dois Numeros Positivos - Passo 4 - Clicou no bot�o " + num2);
        MobileElement btnIgual = (MobileElement) driver.findElementByAccessibilityId("equals");
        btnIgual.click();
        print("Diminuir Dois Numeros Positivos - Passo 5 - Clicou no bot�o Igual");
    }

    @When("^seleciono \"([^\"]*)\" dividido \"([^\"]*)\" e pressiono o botao Igual$")
    public void selecionoDivididoEPressionoOBotaoIgual(String num1, String num2) throws IOException{
        print("Dividir um Numero Positivo - Passo 1 - Abriu a Calculadora");
        MobileElement btnA = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_" + num1);
        btnA.click();
        print("Dividir um Numero Positivo - Passo 2 - Clicou no bot�o " + num1);
        MobileElement btnDividir = (MobileElement) driver.findElementByAccessibilityId("divide");
        btnDividir.click();
        print("Dividir um Numero Positivo - Passo 3 - Clicou no bot�o de dividir");
        MobileElement btnB = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_" + num2);
        btnB.click();
        print("Dividir um Numero Positivo - Passo 4 - Clicou no bot�o " + num2);
        MobileElement btnIgual = (MobileElement) driver.findElementByAccessibilityId("equals");
        btnIgual.click();
        print("Dividir um Numero Positivo - Passo 5 - Clicou no bot�o Igual");
    }

    @When("^seleciono \"([^\"]*)\" vezes \"([^\"]*)\" e pressiono o botao Igual$")
    public void selecionoVezesEPressionoOBotaoIgual(String num1, String num2) throws IOException{
        print("Multiplicar Dois Numeros Inteiros Positivos - Passo 1 - Abriu a Calculadora");
        MobileElement btnA = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_" + num1);
        btnA.click();
        print("Multiplicar Dois Numeros Inteiros Positivos - Passo 2 - Clicou no bot�o " + num1);
        MobileElement btnMultiplicar = (MobileElement) driver.findElementByAccessibilityId("multiply");
        btnMultiplicar.click();
        print("Multiplicar Dois Numeros Inteiros Positivos - Passo 3 - Clicou no bot�o de multiplicar");
        MobileElement btnB = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_" + num2);
        btnB.click();
        print("Multiplicar Dois Numeros Inteiros Positivos - Passo 4 - Clicou no bot�o " + num2);
        MobileElement btnIgual = (MobileElement) driver.findElementByAccessibilityId("equals");
        btnIgual.click();
        print("Multiplicar Dois Numeros Inteiros Positivos - Passo 5 - Clicou no bot�o Igual");
    }


    // Given com massa
    @Given("^que utilizo a massa \"([^\"]*)\" para testar a calculadora$")
    public void queUtilizoAMassaParaTestarACalculadora(String nomeMassa) throws MalformedURLException {

        //Configura��es para execu��o do emulador na nuvem
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "9.0");
        desiredCapabilities.setCapability("browserName", "");
        desiredCapabilities.setCapability("appiumVersion", "1.19.2");
        desiredCapabilities.setCapability("deviceName", massa.deviceName);
        desiredCapabilities.setCapability("deviceOrientation", "portrait");
        desiredCapabilities.setCapability("app", "storage:filename=Calculator_v7.8 (271241277)_apkpure.com.apk");
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("SAUCE_USERNAME", "marilia.laviola");
        desiredCapabilities.setCapability("SAUCE_ACCESS_KEY", "90d204cf-597b-4e1d-b496-6665c573692b");

        remoteUrl = new URL("https://marilia.laviola:90d204cf-597b-4e1d-b496-6665c573692b@ondemand.us-west-1.saucelabs.com:443/wd/hub");

        //abrir o app
}
    @When("^realizo a operacao com dois numeros$")
    public void realizoAOperacaoComDoisNumeros() throws IOException {

        print("Somar Dois Numeros Positivos - Passo 1 - Abriu a Calculadora");
        MobileElement btnA = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_" + massa.num1);
        btnA.click();
        print("Somar Dois Numeros Positivos - Passo 2 - Clicou no bot�o " + massa.num1);

        //Selecionar a opera��o matem�tica
        //Exemplo com um bot�o para cada um das 4 opera��es
        /*
        switch(massa.operador){
            case "+":
                MobileElement btnSoma = (MobileElement) driver.findElementByAccessibilityId("plus");
                btnSoma.click();
                break;
            case "-":
                MobileElement btnSubtrair = (MobileElement) driver.findElementByAccessibilityId("minus");
                btnSubtrair.click();
                break;
            case "*":
                MobileElement btnMultiplicar = (MobileElement) driver.findElementByAccessibilityId("multiply");
                btnMultiplicar.click();
                break;
            case "/":
                MobileElement btnDividir = (MobileElement) driver.findElementByAccessibilityId("divide");
                btnDividir.click();
                break;
        }*/

        //Exemplo resumido - l� o simbolo e transforma na opera��o
        switch(massa.operador){
            case "+":
                btnOperacao = (MobileElement) driver.findElementByAccessibilityId("plus");
                break;
            case "-":
                btnOperacao = (MobileElement) driver.findElementByAccessibilityId("minus");
                break;
            case "*":
                btnOperacao = (MobileElement) driver.findElementByAccessibilityId("multiply");
                break;
            case "/":
                btnOperacao = (MobileElement) driver.findElementByAccessibilityId("divide");
                break;
        }
        btnOperacao.click();

        // Ficaria muito mais simples se a massa j� tivesse a opera��o ao inv�s do simbol
        /*
        btnOperacao = (MobileElement) driver.findElementByAccessibilityId(massa.operador);
        btnOperacao.click();
        */

        print("Somar Dois Numeros Positivos - Passo 3 - Clicou no bot�o de soma");
        MobileElement btnB = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_" + massa.num2);
        btnB.click();
        print("Somar Dois Numeros Positivos - Passo 4 - Clicou no bot�o " + massa.num2);
        MobileElement btnIgual = (MobileElement) driver.findElementByAccessibilityId("equals");
        btnIgual.click();
        print("Somar Dois Numeros Positivos - Passo 5 - Clicou no bot�o Igual");

    }

    @Then("^compara o resultado atual com o esperado$")
    public void comparaOResultadoAtualComOEsperado() {
        if(massa.operador == "/" && massa.num2 == "0" ){
            //ToDo: mapear a mensagem de erro da divis�o
        }
        else{
            MobileElement lblResultadoAtual = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
            assertEquals(massa.resultadoEsperado, lblResultadoAtual.getText());
        }

    }
}
