package com.exed.testes.auditoria;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.exed.testes.grc.paginas.ExplorerPage;
import com.exed.testes.grc.paginas.LoginPage;

public class TestarListagemDeApontamentos {
	
	private WebDriver driver;
	private LoginPage loginPage;
	
	@Before
	public void inicializa(){
		System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
	}

	@Test(timeout = 1000 * 60)
	public void acessarListagem() {
		
		loginPage.visita();
		
		ExplorerPage explorerPage = loginPage.executaLogin("f000580", "manager").navegarParaExplorerPage();
		explorerPage.acessaMenuApontamento();
		

		// FirefoxDriver driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		//driver.get("http://localhost:8080/arcm/login.jsp");

		//this.logon("f000580", "manager", driver);

	}
	
	@After
	public void encerraTeste(){
		//driver.close();
	}

/*	private void logon(String userName, String pass, WebDriver driver) {

		WebElement name = driver.findElement(By.id("username"));
		name.sendKeys(userName);

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(pass);

		name.submit();

	}*/

}
