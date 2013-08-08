package br.com.temperatura;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import br.com.temperatura.controller.ConversorOverviewController;

public class MainApplication extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Conversor de Temperatura");
		
		try {
			// Carrega o layout raiz (RootLayout) do arquivo FXML
			FXMLLoader loader = new FXMLLoader(
					MainApplication.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			Scene scene = new Scene(rootLayout);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			// Pode lançar uma exceção caso o arquivo FXML não seja carregado
			e.printStackTrace();
		}
		
		showConversorOverview();
	}

	private void showConversorOverview() {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApplication.class
							.getResource("view/ConversorOverview.fxml"));
			
			AnchorPane overviewPage = (AnchorPane) loader.load();
			rootLayout.setCenter(overviewPage);
			
			ConversorOverviewController controller = loader.getController();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
