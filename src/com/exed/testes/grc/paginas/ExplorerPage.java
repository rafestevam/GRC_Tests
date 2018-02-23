package com.exed.testes.grc.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplorerPage {

	private WebDriver driver;

	public ExplorerPage(WebDriver driver) {
		this.driver = driver;
	}

	public ExplorerPage acessaMenuApontamento() {
		// WebElement framesetElem =
		// driver.findElement(By.xpath("/html/frameset/frameset"));
		WebDriver frameset = driver.switchTo().defaultContent();
		WebDriver childFrameset = frameset.switchTo().defaultContent();
		WebElement frameElem = childFrameset.findElement(By.name("main"));
		WebDriver frame = driver.switchTo().frame(frameElem);
		frame.findElement(By.id("item.explorer.issue.management")).click();
		// driver.findElement(By.id("item.explorer.issue.management")).click();
		return new ExplorerPage(driver);
	}
	
	public ExplorerPage acessaMenuControle(){
		WebDriver frameset = driver.switchTo().defaultContent();
		WebDriver childFrameset = frameset.switchTo().defaultContent();
		WebElement frameElem = childFrameset.findElement(By.name("main"));
		WebDriver frame = driver.switchTo().frame(frameElem);
		frame.findElement(By.id("item.explorer.issue.management")).click();
		return new ExplorerPage(driver);
	}
	
	public ExplorerPage acessaMenuRisco(){
		WebDriver frameset = driver.switchTo().defaultContent();
		WebDriver childFrameset = frameset.switchTo().defaultContent();
		WebElement frameElem = childFrameset.findElement(By.name("main"));
		WebDriver frame = driver.switchTo().frame(frameElem);
		frame.findElement(By.id("item.explorer.risk.management")).click();
		return new ExplorerPage(driver);
	}

	public ListaApontamentosGerPage acessaRelatorioGerencial() {
		driver.findElement(By.id("dataGrid.Issues3")).click();
		return new ListaApontamentosGerPage(driver);
	}
	
	public ListaControlesPage acessaListagemControles(){
		driver.findElement(By.id("dataGrid.control")).click();
		return new ListaControlesPage(driver);
	}
	
	public ListaRiscosPage acessaListagemRiscos(){
		driver.findElement(By.id("dataGrid.risk")).click();
		return new ListaRiscosPage(driver);
	}

	/*
	 * public boolean verificaRegistrosDuplicados() { WebDriver frameset =
	 * driver.switchTo().defaultContent(); WebDriver childFrameset =
	 * frameset.switchTo().defaultContent(); WebElement frameElem =
	 * childFrameset.findElement(By.name("main")); WebDriver frame =
	 * childFrameset.switchTo().frame(frameElem);
	 * 
	 * String xPathSelect =
	 * "/html/body/div/table/tbody/tr/td/form/div/table/tbody[1]/tr/td[1]/table/tbody/tr/td[2]/select";
	 * // frame.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); Select
	 * ckPages = getSeletorPaginas(frame, xPathSelect); //
	 * frame.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	 * 
	 * int length = ckPages.getOptions().size();
	 * 
	 * for (int i = 0; i < length; i++) { int page = i; page += 1;
	 * 
	 * // Select ckPages2 = getSeletorPaginas(frame, xPathSelect); Select
	 * ckPages2 = getPageSelector(frame, xPathSelect);
	 * 
	 * ckPages2.selectByVisibleText(String.valueOf(page)); String xpath =
	 * "/html/body/div/table/tbody/tr/td/form/div/table/tbody[3]/tr/td[2]/a/table/tbody/tr/td[2]";
	 * // List<WebElement> rows = new ArrayList<>(); // rows =
	 * frame.findElements(By.xpath(xpath));
	 * 
	 * 
	 * List<WebElement> rowsList = new WebDriverWait(frame, 20)
	 * .until(ExpectedConditions.stalenessOf(element)); List<WebElement> rows =
	 * frame.findElements(By.xpath(xpath));
	 * 
	 * 
	 * List<WebElement> rows = getTableRows(frame, xpath);
	 * 
	 * //Map<String, Integer> mapID = this.getListaID(rows); Map<String,
	 * Integer> mapID = new HashMap<>(); for (WebElement row : rows) { if
	 * (mapID.containsKey(row.getText())) {
	 * //this.waitForElementPresent(By.tagName(row.getTagName()), 100);
	 * mapID.put(row.getText(), mapID.get(row.getText()) + 1); } else {
	 * //this.waitForElementPresent(By.tagName(row.getTagName()), 100);
	 * mapID.put(row.getText(), 1); } }
	 * 
	 * Iterator it = mapID.entrySet().iterator(); while (it.hasNext()) {
	 * Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) it.next();
	 * if ((Integer) pair.getValue() > 1) { return false; } }
	 * 
	 * 
	 * while (mapID.values().iterator().hasNext()) { Integer value =
	 * mapID.values().iterator().next(); if (value > 1) { return false; } }
	 * 
	 * } // }
	 * 
	 * return true; }
	 */

	/*
	 * private Select getPageSelector(WebDriver frame, String xPathSelect) {
	 * WebElement ckPages2Elem = new WebDriverWait(frame, 10).until(
	 * ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(
	 * By.xpath(xPathSelect))));
	 * this.waitForElementPresent(By.xpath(xPathSelect), 100); WebElement
	 * ckPages2Elem = frame.findElement(By.xpath(xPathSelect)); Select ckPages2
	 * = new Select(ckPages2Elem); return ckPages2; }
	 */

	/*
	 * private List<WebElement> getTableRows(WebDriver frame, String xpath) {
	 * List<WebElement> rows = new ArrayList<>(); new WebDriverWait(frame, 10)
	 * .until(ExpectedConditions.refreshed(ExpectedConditions.
	 * presenceOfElementLocated(By.xpath(xpath))));
	 * this.waitForElementPresent(By.xpath(xpath), 50); rows =
	 * frame.findElements(By.xpath(xpath)); return rows; }
	 * 
	 * private Select getSeletorPaginas(WebDriver frame, String xPathSelect) {
	 * Select ckPages = getPageSelector(frame, xPathSelect); return ckPages; }
	 * 
	 * private Map<String, Integer> getListaID(List<WebElement> rows) {
	 * 
	 * // List<Integer> idList = new ArrayList<>(); Map<String, Integer> mapList
	 * = new HashMap<String, Integer>();
	 * 
	 * for (WebElement row : rows) { if (mapList.containsKey(row.getText())) {
	 * this.waitForElementPresent(By.tagName(row.getTagName()), 100);
	 * mapList.put(row.getText(), mapList.get(row.getText()) + 1); } else {
	 * this.waitForElementPresent(By.tagName(row.getTagName()), 100);
	 * mapList.put(row.getText(), 1); } }
	 * 
	 * return mapList;
	 * 
	 * }
	 */

	public void waitForElementPresent(final By by, int timeout) {
		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, timeout)
				.ignoring(StaleElementReferenceException.class);
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver webDriver) {
				WebElement element = webDriver.findElement(by);
				return element != null && element.isDisplayed();
			}
		});
	}

}
