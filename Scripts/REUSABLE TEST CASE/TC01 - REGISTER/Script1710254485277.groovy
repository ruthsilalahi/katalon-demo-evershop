import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('REUSABLE TEST CASE/TC00 - OPEN BROWSER'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HOME PAGE/user_icon'))

WebUI.verifyElementVisible(findTestObject('LOGIN PAGE/text_Login'))

WebUI.click(findTestObject('Object Repository/LOGIN PAGE/cta_Create an account'))

WebUI.click(findTestObject('Object Repository/LOGIN PAGE/REGISTER/input_register_full_name'))

WebUI.setText(findTestObject('Object Repository/LOGIN PAGE/REGISTER/input_register_full_name'), Fullname)

WebUI.setText(findTestObject('Object Repository/LOGIN PAGE/REGISTER/input_register_email'), Email)

WebUI.setText(findTestObject('Object Repository/LOGIN PAGE/REGISTER/input_register_password'), Password)

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/LOGIN PAGE/REGISTER/button_sign_up'))

