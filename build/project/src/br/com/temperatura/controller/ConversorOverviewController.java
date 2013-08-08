package br.com.temperatura.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * 
 * Essa classe (Controller) é responsável por acessar os campos da tela (View).
 * 
 * @author Gabriel Tavares - gabrieltavaresmelo@gmail.com
 * 
 */
public class ConversorOverviewController {

	@FXML
	private Label simboloTemperaturaLabel;

	@FXML
	private TextField valorTextField;
	
	@FXML
	private Button converterButton;
	
	@FXML
	private RadioButton celsiusRadioButton;
	
	@FXML
	private RadioButton fahrenheitRadioButton;
	
	@FXML
	private Label resultadoConversaoLabel;
	
	/**
	 * Inicializa o controlador automaticamente após o carregamento do arquivo
	 * FXML.
	 */
	@FXML
	private void initialize() {
		final ToggleGroup group = new ToggleGroup();
		celsiusRadioButton.setToggleGroup(group);		
		fahrenheitRadioButton.setToggleGroup(group);

		// Inicia o celsiusRadioButton selecionado
		celsiusRadioButton.setSelected(true);
		simboloTemperaturaLabel.setText("C");
	}
	
	/**
	 * Chamado quando o usuário clicar no componente visual celsiusRadioButton.
	 */
	@FXML
	private void handleConversaoCelsius() {
		simboloTemperaturaLabel.setText("C");
	}
	
	/**
	 * Chamado quando o usuário clicar no componente visual fahrenheitRadioButton.
	 */
	@FXML
	private void handleConversaoFahrenheit() {
		simboloTemperaturaLabel.setText("F");		
	}
	
	/**
	 * Chamado quando o usuário clicar no componente visual converterButton.
	 */
	@FXML
	private void handleConverterButton() {
//		c/5 = (f-32)/9;
		int valor = Integer.parseInt(valorTextField.getText());
		String resultado = "";
		
		if(celsiusRadioButton.isSelected()){ // Celsius -> Fahrenheit
			double f = (1.8 * valor) + 32;
			resultado = String.format("%.1f", f) + " F";
			
		} else{ // Fahrenheit -> Celsius
			double c = (double) ((valor - 32) / 1.8);
			resultado = String.format("%.1f", c) + " C";
		}
		
		resultadoConversaoLabel.setText(resultado);
	}
}
