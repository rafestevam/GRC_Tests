package com.exed.testes.controle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.exed.testes.grc.paginas.ExplorerPage;
import com.exed.testes.grc.paginas.ListaRiscosPage;
import com.exed.testes.grc.paginas.LoginPage;

public class TestarAmbienteControles {
	
	private WebDriver driver;
	private LoginPage loginPage;
	
	@Before
	public void inicializa(){
		System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("no-sandbox");
		driver = new ChromeDriver();	
		loginPage = new LoginPage(driver);		
	}
	
	@Test
	public void testarResultadoAmbienteControle(){
		
		loginPage.visita();
		
		ExplorerPage explorerPage = loginPage.executaLogin("manager", "manager").navegarParaExplorerPage();
		ListaRiscosPage listaRiscosPage = explorerPage.acessaMenuRisco().acessaListagemRiscos();
		
		for(int i = 1; i <= listaRiscosPage.getNumeroPaginas(); i++){
			
			listaRiscosPage.selecionaPagina(i);
			
		}
		
	}
	
	
	@After
	public void encerraTeste(){
		//driver.close();
	}

}
