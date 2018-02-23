package com.exed.testes.grc.paginas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListaApontamentosGerPage {

	private WebDriver driver;

	public ListaApontamentosGerPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean verificaRegistrosDuplicados(){
		WebDriver frameset = driver.switchTo().defaultContent();
		WebDriver childFrameset = frameset.switchTo().defaultContent();
		WebElement frameElem = childFrameset.findElement(By.name("main"));
		WebDriver frame = childFrameset.switchTo().frame(frameElem);

		String xPathSelect = "/html/body/div/table/tbody/tr/td/form/div/table/tbody[1]/tr/td[1]/table/tbody/tr/td[2]/select";
		String xPathNext = "/html/body/div/table/tbody/tr/td/form/div/table/tbody[1]/tr/td[1]/table/tbody/tr/td[2]/span/a[@id='header_button.page.next.BTN']";
		//String xpath = "/html/body/div/table/tbody/tr/td/form/div/table/tbody[3]/tr/td[2]/a/table/tbody/tr/td[2]";
		String xpath = "/html/body/div/table/tbody/tr/td/form/div/table/tbody[3]/tr/td[2]/a/table";
		// frame.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Select ckPages = getSeletorPaginas(frame, xPathSelect);
		// frame.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		int length = ckPages.getOptions().size();
		
		for (int i = 0; i < length; i++) {
			//int page = i;
			//page += 1;

			//Select ckPages2 = getPageSelector(frame, xPathSelect);

			//ckPages2.selectByVisibleText(String.valueOf(page));
			
			this.waitForElementPresent(By.xpath(xpath), 10);
			List<WebElement> rows = getTableRows(frame, xpath);

			Map<String, Integer> mapID = new HashMap<>();
			for (WebElement row : rows) {
				if (mapID.containsKey(row.getText())) {
					mapID.put(row.getText(), mapID.get(row.getText()) + 1);
				} else {
					mapID.put(row.getText(), 1);
				}
			}

			Iterator it = mapID.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) it.next();
				if ((Integer) pair.getValue() > 1) {
					return false;
				}
			}
			
			//this.waitForElementPresent(By.xpath(xPathNext), 10);
			/*try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			WebElement buttonNextPage = frame.findElement(By.xpath(xPathNext)).findElement(By.id("header_button.page.next.BTN"));
			buttonNextPage.click();

		}

		return true;
	}

	private List<WebElement> getTableRows(WebDriver frame, String xpath) {
		List<WebElement> rows = new ArrayList<>();
		/*
		 * new WebDriverWait(frame, 10)
		 * .until(ExpectedConditions.refreshed(ExpectedConditions.
		 * presenceOfElementLocated(By.xpath(xpath))));
		 */
		this.waitForElementPresent(By.xpath(xpath), 50);
		rows = frame.findElements(By.xpath(xpath));
		return rows;
	}

	private Select getSeletorPaginas(WebDriver frame, String xPathSelect) {
		Select ckPages = getPageSelector(frame, xPathSelect);
		return ckPages;
	}

	private Map<String, Integer> getListaID(List<WebElement> rows) {

		// List<Integer> idList = new ArrayList<>();
		Map<String, Integer> mapList = new HashMap<String, Integer>();

		for (WebElement row : rows) {
			if (mapList.containsKey(row.getText())) {
				this.waitForElementPresent(By.tagName(row.getTagName()), 100);
				mapList.put(row.getText(), mapList.get(row.getText()) + 1);
			} else {
				this.waitForElementPresent(By.tagName(row.getTagName()), 100);
				mapList.put(row.getText(), 1);
			}
		}

		return mapList;

	}

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

	private Select getPageSelector(WebDriver frame, String xPathSelect) {
		/*
		 * WebElement ckPages2Elem = new WebDriverWait(frame, 10).until(
		 * ExpectedConditions.refreshed(ExpectedConditions.
		 * presenceOfElementLocated(By.xpath(xPathSelect))));
		 */
		this.waitForElementPresent(By.xpath(xPathSelect), 100);
		WebElement ckPages2Elem = frame.findElement(By.xpath(xPathSelect));
		Select ckPages2 = new Select(ckPages2Elem);
		return ckPages2;
	}

}
