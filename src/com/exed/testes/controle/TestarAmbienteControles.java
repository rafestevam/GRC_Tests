package com.exed.testes.controle;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.exed.testes.grc.paginas.ExplorerPage;
import com.exed.testes.grc.paginas.ListaRiscosPage;
import com.exed.testes.grc.paginas.LoginPage;
import com.exed.testes.grc.paginas.RiscoPage;

public class TestarAmbienteControles {
	
	private WebDriver driver;
	private LoginPage loginPage;
	
	@Before
	public void inicializa(){
		System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//driver = new FirefoxDriver();
		options.addArguments("--no-sandbox");
		driver = new ChromeDriver();	
		loginPage = new LoginPage(driver);		
	}
	
	@Test
	public void testarResultadoAmbienteControle(){
		
		loginPage.visita();
		
		ExplorerPage explorerPage = loginPage.executaLogin("manager", "manager").navegarParaExplorerPage();
		ListaRiscosPage listaRiscosPage = explorerPage.acessaMenuRisco().acessaListagemRiscos();
		int numeroPaginas = listaRiscosPage.getNumeroPaginas();
		//Select ckPages = listaRiscosPage.getSeletorPaginas();	
		
		for(int i = 1; i <= numeroPaginas; i++){
			
			listaRiscosPage.selecionaPagina(i);
			List<WebElement> tabelaRiscos = listaRiscosPage.getTabelaRiscos();
			int nRiscosRows = tabelaRiscos.size();
			
			for(int j = 0; j < nRiscosRows; j++){
				
				listaRiscosPage.debugElements(j, tabelaRiscos);
				
				//RiscoPage riscoPage = listaRiscosPage.acessaRisco(tabelaRiscos.get(j)).selecionaRole();
				//riscoPage.voltarParaListaRisco();
				
			}			
			
		}
		
	}
	
	
	@After
	public void encerraTeste(){
		//driver.close();
	}

}
