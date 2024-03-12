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

if (WebUI.verifyElementVisible(findTestObject('CHECK OUT PAGE/label_already have an account'), FailureHandling.OPTIONAL)) {
    if (Login == 'No') {
        WebUI.setText(findTestObject('CHECK OUT PAGE/input_email_co'), Email)

        WebUI.takeScreenshot()

        WebUI.click(findTestObject('CHECK OUT PAGE/button_Continue to shipping'))

        WebUI.verifyElementVisible(findTestObject('SHIPPING ADDRESS/text_Shipping Address'))
    } else if (Login == 'Yes') {
        WebUI.click(findTestObject('CHECK OUT PAGE/Login_label'))

        WebUI.click(findTestObject('Object Repository/LOGIN PAGE/input_Login_email'))

        WebUI.setText(findTestObject('Object Repository/LOGIN PAGE/input_Login_email'), Email)

        WebUI.setText(findTestObject('Object Repository/LOGIN PAGE/input_Login_password'), Password)

        WebUI.click(findTestObject('Object Repository/LOGIN PAGE/button_sign_in'))

        WebUI.callTestCase(findTestCase('REUSABLE TEST CASE/TC03 - PICK PRODUCT - HOMEPAGE'), [('ProductName') : 'Nike air zoom pegasus 35'
                , ('ProductQty') : '2', ('ProductSize') : 'L', ('ProductColor') : 'Black'], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('REUSABLE TEST CASE/TC04 - ADD TO CART - SHOPPING CART'), [:], FailureHandling.STOP_ON_FAILURE)
    }
}

if (WebUI.verifyElementVisible(findTestObject('SHIPPING ADDRESS/text_Shipping Address'), FailureHandling.OPTIONAL)) {
    WebUI.setText(findTestObject('SHIPPING ADDRESS/input_Full name'), Fullname)

    WebUI.setText(findTestObject('SHIPPING ADDRESS/input_Telephone'), PhoneNumber)

    WebUI.setText(findTestObject('SHIPPING ADDRESS/input_Address'), Address)

    WebUI.setText(findTestObject('SHIPPING ADDRESS/input_City'), City)

    WebUI.selectOptionByLabel(findTestObject('SHIPPING ADDRESS/select_Country'), Country, false)

    WebUI.verifyOptionSelectedByLabel(findTestObject('SHIPPING ADDRESS/select_Country'), Country, false, 5)

    if (WebUI.verifyElementVisible(findTestObject('SHIPPING ADDRESS/label_Province'))) {
        WebUI.selectOptionByLabel(findTestObject('SHIPPING ADDRESS/select_Province'), Province, false)
    } else {
        System.out.println('Country not selected')
    }
    
    WebUI.setText(findTestObject('SHIPPING ADDRESS/input_Postcode'), Postcode)

    if (ShippingMethod == 'Express') {
        WebUI.click(findTestObject('SHIPPING ADDRESS/span_Express Delivery - 15.00'))
    } else if (ShippingMethod == 'Standard') {
        WebUI.click(findTestObject('SHIPPING ADDRESS/span_Standard Delivery - 5.00'))
    }
    
    WebUI.takeFullPageScreenshot()

    WebUI.click(findTestObject('SHIPPING ADDRESS/button_Continue to payment'))
}

