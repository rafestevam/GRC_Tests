package com.exed.testes.grc.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RiscoPage {
	
	private WebDriver driver;

	public RiscoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public RiscoPage selecionaRole(){
		
		WebDriver frameset = driver.switchTo().defaultContent();
		WebDriver childFrameset = frameset.switchTo().defaultContent();
		WebElement frameElem = childFrameset.findElement(By.name("main"));
		WebDriver frame = childFrameset.switchTo().frame(frameElem);
		
		String xPathSelect = "/html/body/div/div/form/div/table/tbody/tr[3]/td/select";
		//String xPathOKButton = "/html/body/div/form/div[2]/input";
		WebDriverWait wait = new WebDriverWait(frame, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathSelect)));
		WebElement roleSelectElem = frame.findElement(By.xpath(xPathSelect));
		Select ckRoleSelect = new Select(roleSelectElem);
		
		ckRoleSelect.selectByVisibleText("Gestor de risco");
		frame.findElement(By.id("button")).click();
		//frame.findElement(By.xpath(xPathOKButton)).submit();
		
		return new RiscoPage(driver);
	}

	public void voltarParaListaRisco() {
		
		WebDriver frameset = driver.switchTo().defaultContent();
		WebDriver childFrameset = frameset.switchTo().defaultContent();
		WebElement frameElem = childFrameset.findElement(By.name("main"));
		WebDriver frame = childFrameset.switchTo().frame(frameElem);
		
		WebDriverWait wait1 = new WebDriverWait(frame, 60);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabcontent")));
		WebElement childFrameElem = frame.findElement(By.id("tabcontent"));
		WebDriver childFrame = frame.switchTo().frame(childFrameElem);
		
		//String xPathAnterior = "/html/body/form/table/tbody/tr/td/table/tbody/tr/td/a[6]";
		//childFrame.findElement(By.xpath(xPathAnterior));
		WebDriverWait wait = new WebDriverWait(frame, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form_back")));
		childFrame.findElement(By.id("form_back")).click();
		
	}

}
