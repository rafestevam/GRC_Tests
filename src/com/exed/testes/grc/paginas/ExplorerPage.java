package com.exed.testes.grc.paginas;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExplorerPage {
	
	private WebDriver driver;

	public ExplorerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public ExplorerPage acessaMenuApontamento(){
		//WebElement framesetElem = driver.findElement(By.xpath("/html/frameset/frameset"));
		WebDriver frameset = driver.switchTo().defaultContent();
		WebDriver childFrameset = frameset.switchTo().defaultContent();
		WebElement frameElem = childFrameset.findElement(By.name("main"));
		WebDriver frame = driver.switchTo().frame(frameElem);
		frame.findElement(By.id("item.explorer.issue.management")).click();
		//driver.findElement(By.id("item.explorer.issue.management")).click();
		return new ExplorerPage(driver);
	}
	
	public void acessaRelatorioGerencial(){
		driver.findElement(By.id("dataGrid.Issues3")).click();
	}
	
	public boolean verificaRegistrosDuplicados(){
		WebDriver frameset = driver.switchTo().defaultContent();
		WebDriver childFrameset = frameset.switchTo().defaultContent();
		WebElement frameElem = childFrameset.findElement(By.name("main"));
		WebDriver frame = childFrameset.switchTo().frame(frameElem);
		String xpath = "/html/body/div/table/tbody/tr/td/form/div/table/tbody[3]/tr/td[2]/a/table/tbody/tr/td[2]";
		List<WebElement> rows = frame.findElements(By.xpath(xpath));
		
		for (WebElement row : rows) {
			System.out.println(row.getText());
		}
		//List<Integer> listaID = this.getListaID(table);
		
		return false;
	}
	
	private List<Integer> getListaID(List<WebElement> rows){
		
		List<Integer> idList = new ArrayList<>();
		
		for (WebElement row : rows) {
			idList.add(Integer.valueOf(row.getText()));			
		}
				
		return idList;
		
	}

}
