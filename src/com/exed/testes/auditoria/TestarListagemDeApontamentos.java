package com.exed.testes.auditoria;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestarListagemDeApontamentos {
	
	@Test
	public void acessarListagem(){
		
		//FirefoxDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8080/arcm/login.jsp");
		
		this.logon("f000580", "manager", driver);
		
	}
	
	private void logon(String userName, String pass, WebDriver driver){
		
		WebElement name = driver.findElement(By.id("username"));
		name.sendKeys(userName);
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(pass);
		
		name.submit();

	}

}
