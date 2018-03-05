package com.exed.testes.grc.paginas;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		WebDriverWait wait = new WebDriverWait(frame, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathPageSelect)));
		Select ckPages = getPageSelector(frame, xPathPageSelect);
		
		return ckPages.getOptions().size();
		
	}
	
	public ListaRiscosPage selecionaPagina(int numeroPagina){
		
		WebDriver frameset = driver.switchTo().defaultContent();
		WebDriver childFrameset = frameset.switchTo().defaultContent();
		WebElement frameElem = childFrameset.findElement(By.name("main"));
		WebDriver frame = childFrameset.switchTo().frame(frameElem);
		
		String xPathPageSelect = "/html/body/div/table/tbody/tr/td/form/div/table/tbody/tr/td/table/tbody/tr/td[2]/select";
		WebDriverWait wait = new WebDriverWait(frame, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathPageSelect)));
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
		//WebElement ckPages2Elem = frame.findElement(By.id("__pages_top"));
		Select ckPages2 = new Select(ckPages2Elem);
		return ckPages2;
	}

	public List<WebElement> getTabelaRiscos() {
		WebDriver frameset = driver.switchTo().defaultContent();
		WebDriver childFrameset = frameset.switchTo().defaultContent();
		WebElement frameElem = childFrameset.findElement(By.name("main"));
		WebDriver frame = childFrameset.switchTo().frame(frameElem);
		
		String xPathTable = "/html/body/div/table/tbody/tr/td/form/div/table/tbody[3]/tr";
		//WebElement riskTable = frame.findElement(By.xpath(xPathTable));
		//List<WebElement> tableRows = frame.findElements(By.xpath(xPathTable));
		
		//WebDriverWait wait = new WebDriverWait(frame, 120);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathTable)));
		//List<WebElement> tableRows = frame.findElements(By.xpath(xPathTable));
		
		WebDriverWait wait = new WebDriverWait(frame, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));		
		WebElement riskTable = frame.findElement(By.id("content"));
		
		List<WebElement> tableRows = new ArrayList<>();
		for (WebElement line : riskTable.findElements(By.tagName("tr"))) {
			if(line.getAttribute("id").contains("list_row_")){
				tableRows.add(line);
			}
		}
		
		//List<WebElement> tableRows = riskTable.findElements(By.tagName("tr"));
		
		return tableRows;
		
	}

	public RiscoPage acessaRisco(WebElement elem) {
		WebDriver frameset = driver.switchTo().defaultContent();
		WebDriver childFrameset = frameset.switchTo().defaultContent();
		WebElement frameElem = childFrameset.findElement(By.name("main"));
		WebDriver frame = childFrameset.switchTo().frame(frameElem);
		
		WebDriverWait wait = new WebDriverWait(frame, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("a")));
		
		elem.findElement(By.tagName("a")).click();
		
		return new RiscoPage(driver);
		
	}

	public Select getSeletorPaginas() {
		
		WebDriver frameset = driver.switchTo().defaultContent();
		WebDriver childFrameset = frameset.switchTo().defaultContent();
		WebElement frameElem = childFrameset.findElement(By.name("main"));
		WebDriver frame = childFrameset.switchTo().frame(frameElem);
		
		String xPathPageSelect = "/html/body/div/table/tbody/tr/td/form/div/table/tbody[1]/tr/td[1]/table/tbody/tr/td[2]/select";
		Select ckPages = getPageSelector(frame, xPathPageSelect);
		
		return ckPages;
		
	}

	public void debugElements(int j, List<WebElement> tabelaRiscos) {
		WebDriver frameset = driver.switchTo().defaultContent();
		WebDriver childFrameset = frameset.switchTo().defaultContent();
		WebElement frameElem = childFrameset.findElement(By.name("main"));
		WebDriver frame = childFrameset.switchTo().frame(frameElem);
		
		int idx = j + 1;
		if(j < 20){
			String idAttr = "list_row_" + String.valueOf(idx);
			
			WebDriverWait wait = new WebDriverWait(frame, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idAttr)));
			
			System.out.println(tabelaRiscos.get(j).getAttribute("id"));
		}
	}

}
