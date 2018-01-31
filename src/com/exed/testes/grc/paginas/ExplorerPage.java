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
	
	public void acessaMenuApontamento(){
		driver.findElement(By.id("item.explorer.issue.management")).click();
	}
	
	public void acessaRelatorioGerencial(){
		driver.findElement(By.id("dataGrid.Issues3")).click();
	}
	
	public boolean verificaRegistrosDuplicados(){
		WebElement table = driver.findElement(By.id("content"));
		List<Integer> listaID = this.getListaID(table);
		
		
		
		return false;
	}
	
	private List<Integer> getListaID(WebElement table){
		
		List<Integer> idList = new ArrayList<>();
		
		List<WebElement> cols = table.findElements(By.id("list_row_1"));
		
		
		return idList;
		
	}

}
