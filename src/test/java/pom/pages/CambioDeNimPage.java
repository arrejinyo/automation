package pom.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CambioDeNimPage extends BasePage {

        private String titlePage=environment().titlePage();


        @FindBy(id="title-assign_nim")
        private WebElement titleCambioDeNimLocator;

        @FindBy(id = "button-save_nim")
        private WebElement btnGuardarNim;

        @FindBy(id = "input-current_number")
        private WebElement inputNumeroActual;

        @FindBy(id = "input-area_code")
        private WebElement inputCodigoArea;

        @FindBy(id = "input-block_code")
        private WebElement inputBloque;

        @FindBy(id = "checkbox-special_number")
        private WebElement checkBoxNroEspecial;

        @FindBy(id = "dropwdown-special_number")
        private WebElement comboNuevoNumeroLinea;

        @FindBy(id = "input-new_number")
        private WebElement inputNuevoNumeroLinea;

        @FindBy(id = "input-previous_number")
        private WebElement inputNumeroAnterior;

        @FindBy(id = "input-change_date")
        private WebElement inputFecha;

        @FindBy(id = "button-save_undonim")
        private WebElement btnDeshacerNim;

        @FindBy(id = "mensaje-de-confirmacion")
        private WebElement msjConfirmacion;


        @FindBy(id = "title-assign_nim")
        private WebElement titleAssingDeNim;
        @FindBy(id = "title-undo_nim")
        private WebElement titleUndoNim;

        @FindBy(id = "input-special_number")
        private WebElement inputNroEspecial;

        @FindBy(id = "")
        private WebElement dropdownNuevoNumeroLinea;
        @FindBy(id ="input-billing_number")
        private WebElement inputBillingNumber;
        @FindBy(id ="button-search")
        private WebElement buttonSearch;




        public CambioDeNimPage(WebDriver driver){
                super(driver);
        }




        public void setInputNumeroActual(String text) throws Exception {
                clearField(inputNumeroActual);
            setText(inputNumeroActual, text);
        }

        public String getNumeroActual() throws Exception {
             return getValue(inputNumeroActual);
        }

        public void setInputCodigoArea(String text) throws Exception {
                clearField(inputCodigoArea);
                Thread.sleep(300);
                setText(inputCodigoArea, text);
        }

        public void setInputBloque(String text) throws Exception {
                clearField(inputBloque);
                setText(inputBloque, text);
        }



        public void selectOptionCombo(String option) throws Exception {
                WebElement optionCombo=getElementLocatorByText(option);
                click(comboNuevoNumeroLinea);
                Thread.sleep(3000);//WebElement optionCombo =getDriver().findElement(By.xpath("//*[text()[contains(.,'"+option+"')]]"));
        }


        public void clickOnGuardarNim() throws Exception {
                this.click(btnGuardarNim);
                float time = 0;
                while (!getText(btnGuardarNim).equalsIgnoreCase("Guardar") && time < 10) {
                        Thread.sleep(250);
                        time += 0.25;
                }

        }

        public boolean cambioDeNimPageIsDisplayed() throws Exception {
            return isDisplayed(titleCambioDeNimLocator);
        }

        public void goToCambioDeNimPage(){
            getDriver().get(environment().urlCambioNim());
        }


        public boolean isTitleCambioDeNimDisplayed() throws Exception {
                return isDisplayed(titleCambioDeNimLocator);
        }

        public boolean isMsjConfirmacionDisplayed() throws Exception {
                return getText(inputNuevoNumeroLinea).equalsIgnoreCase("asdf")&& getTitle().equalsIgnoreCase("asdfasdf");
        }

        public ArrayList<String> catch_messages() throws Exception {
                List<WebElement> messages= getDriver().findElements(By.xpath("//*[@id='root']/div[1]/div"));
                ArrayList<String> mensajes_texto= new ArrayList<String>();

                for (int i = 1; i < messages.size()+1; i++){
                        String element1 = getText(getDriver().findElement(By.xpath("//*[@id='root']/div[1]/div["+i+"]/div[1]/p")));
                        String element2 = getText(getDriver().findElement(By.xpath("//*[@id='root']/div[1]/div["+i+"]/div[2]/p")));
                        mensajes_texto.add(" "+element1 +" "+ element2);
                }
                return mensajes_texto;
        }


        public String getBloque() throws Exception {
              return getValue(inputBloque);
        }


        public String getCodArea() throws Exception {
                return getValue(inputCodigoArea);
        }






        public boolean isTitleUndoCambioDeNimDisplayed() throws Exception {
                return isDisplayed(titleUndoNim);
        }

        public void setInputBillingNumber(String text) throws Exception {
                clearField(inputBillingNumber);
                setText(inputBillingNumber, text);
        }

        public void setNumeroEspecial(String text) throws Exception {
                clearField(inputNroEspecial);
                setText(inputNroEspecial, text);
        }



        public String getBillingNumber() throws Exception {
                return  getValue(inputBillingNumber);
        }

        public String getNumeroEspecial() throws Exception {
                return  getValue(inputNroEspecial);
        }

        public void clickOnButtonSearch() throws Exception {
                this.click(buttonSearch);
        }

        public String getNuevoNumeroLinea() throws Exception {
                return getValue(inputNuevoNumeroLinea);
        }


        public String getInputBloque() throws Exception {
                return getValue(inputBloque);
        }


        public void clickOnCheckSpecialNumber() throws Exception{
                this.click(checkBoxNroEspecial);
        }

        public Boolean ValidateCompanyRules(String mensaje_esperado) throws Exception {
                ArrayList<String> messages = this.catch_messages();
                try{
                        for (int i = 0; i < messages.size(); i++) {
                                if (messages.get(i).contains(mensaje_esperado)){
                                        String mensaje_actual= messages.get(i);
                                        return true;
                                }
                        }
                        return false;
                }
                catch (Exception e ){
                        System.out.println(e.getMessage());
                        return false;
                }
        }


}
