package com.exed.testes.grc.paginas;

import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public ExplorerPage navegarParaExplorerPage(){
		//driver.findElement(By.id("imgexplorer")).click();
		driver.get("http://localhost:8080/arcm/modulenavigation.do?__target=explorer&__titleKey=module.explorer.DBI");
		return new ExplorerPage(driver);
	}

}
