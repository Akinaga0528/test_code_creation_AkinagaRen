package jp.co.sss.lms.ct.f01_login1;

import static jp.co.sss.lms.ct.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 結合テスト ログイン機能①
 * ケース02
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース02 受講生 ログイン 認証失敗")
public class Case02 {

	/** 前処理 */
	@BeforeAll
	static void before() {
		createDriver();
	}

	/** 後処理 */
	@AfterAll
	static void after() {
		closeDriver();
	}

	@Test
	@Order(1)
	@DisplayName("テスト01 トップページURLでアクセス")
	void test01() {
		//トップページにアクセス
		goTo("http://localhost:8080/lms/");

		//ログイン画面の検証
		assertEquals("ログイン | LMS", webDriver.getTitle());

		//エビデンス取得
		getEvidence(new Object() {
		});
	}

	@Test
	@Order(2)
	@DisplayName("テスト02 DBに登録されていないユーザーでログイン")
	void test02() {
		// トップページ（ログイン画面）へアクセス
		goTo("http://localhost:8080/lms/");

		String testUser = "test";
		String testPassword = "test123";

		// ログインID入力
		WebElement inputLoginId = webDriver.findElement(By.id("loginId"));
		inputLoginId.clear();
		inputLoginId.sendKeys(testUser);

		// パスワード入力
		WebElement password = webDriver.findElement(By.id("password"));
		password.clear();
		password.sendKeys(testPassword);

		// ログインボタン押下
		WebElement loginBtn = webDriver.findElement(By.className("btn-primary"));
		loginBtn.click();

		// エラーメッセージチェック		
		WebElement errorMsg = webDriver.findElement(By.className("help-inline"));
		assertEquals("* ログインに失敗しました。", errorMsg.getText());

		// エビデンス取得
		getEvidence(new Object() {
		});
	}

}
