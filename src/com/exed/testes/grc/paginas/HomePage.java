package com.exed.testes.grc.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public ExplorerPage navegarParaExplorerPage(){
		//driver.findElement(By.id("imgexplorer")).click();
		//driver.findElement(By.id("explorer")).click();
		//driver.get("http://localhost:8080/arcm/modulenavigation.do?__target=explorer&__titleKey=module.explorer.DBI");
		WebElement frameElem = driver.findElement(By.name("head"));
		WebDriver frame = driver.switchTo().frame(frameElem);
		String xPath = "/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/div[2]";
		frame.findElement(By.xpath(xPath)).click();
			
		return new ExplorerPage(driver);
	}

}
