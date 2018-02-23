package com.exed.testes.grc.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ListaRiscosPage {
	
	private WebDriver driver;

	public ListaRiscosPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public int getNumeroPaginas(){
		
		WebDriver frameset = driver.switchTo().defaultContent();
		WebDriver childFrameset = frameset.switchTo().defaultContent();
		WebElement frameElem = childFrameset.findElement(By.name("main"));
		WebDriver frame = childFrameset.switchTo().frame(frameElem);
		
		String xPathPageSelect = "/html/body/div/table/tbody/tr/td/form/div/table/tbody[1]/tr/td[1]/table/tbody/tr/td[2]/select";
		Select ckPages = getPageSelector(frame, xPathPageSelect);
		
		return ckPages.getOptions().size();
		
	}
	
	public ListaRiscosPage selecionaPagina(int numeroPagina){
		
		WebDriver frameset = driver.switchTo().defaultContent();
		WebDriver childFrameset = frameset.switchTo().defaultContent();
		WebElement frameElem = childFrameset.findElement(By.name("main"));
		WebDriver frame = childFrameset.switchTo().frame(frameElem);
		
		String xPathPageSelect = "/html/body/div/table/tbody/tr/td/form/div/table/tbody[1]/tr/td[1]/table/tbody/tr/td[2]/select";
		Select ckPages = getPageSelector(frame, xPathPageSelect);
		
		//ckPages.selectByValue(String.valueOf(numeroPagina));
		ckPages.selectByVisibleText(String.valueOf(numeroPagina));
		
		return new ListaRiscosPage(driver);
		
	}
	
	private Select getPageSelector(WebDriver frame, String xPathSelect) {
		/*
		 * WebElement ckPages2Elem = new WebDriverWait(frame, 10).until(
		 * ExpectedConditions.refreshed(ExpectedConditions.
		 * presenceOfElementLocated(By.xpath(xPathSelect))));
		 */
		WebElement ckPages2Elem = frame.findElement(By.xpath(xPathSelect));
		Select ckPages2 = new Select(ckPages2Elem);
		return ckPages2;
	}

}
