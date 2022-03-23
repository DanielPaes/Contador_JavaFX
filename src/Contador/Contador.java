package Contador;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Contador extends Application{
	
	int contador = 0;
	
	public void mudaCor(Label label) {
		
		label.getStyleClass().remove("vermelho");
		label.getStyleClass().remove("verde");
		
		if(contador > 0) {
			label.getStyleClass().add("verde");
		} else if (contador < 0) {
			label.getStyleClass().add("vermelho");
		}
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {		
		
		VBox boxPrincipal = new VBox();
		boxPrincipal.setAlignment(Pos.CENTER);
		boxPrincipal.setSpacing(10);
		boxPrincipal.getStyleClass().add("conteudo");
		
		Label labelTitulo = new Label("Contador");
		labelTitulo.getStyleClass().add("titulo");
		
		Label labelContagem = new Label("0");
		labelContagem.getStyleClass().add("numero");
		
		HBox boxBotoes = new HBox();
		boxBotoes.setAlignment(Pos.CENTER);
		boxBotoes.setSpacing(10);		
		
		Button botaoIncremento = new Button("+");
		botaoIncremento.getStyleClass().add("botoes");
		
		Button botaoDecremento = new Button("-");
		botaoDecremento.getStyleClass().add("botoes");
		
		boxBotoes.getChildren().add(botaoDecremento);		
		boxBotoes.getChildren().add(botaoIncremento);
				
		boxPrincipal.getChildren().add(labelTitulo);
		boxPrincipal.getChildren().add(labelContagem);
		boxPrincipal.getChildren().add(boxBotoes);		
		
		botaoIncremento.setOnAction(
				e -> {
						contador++;
						labelContagem.setText(Integer.toString(contador));
						mudaCor(labelContagem);
				});
		
		botaoDecremento.setOnAction(
				e -> {
						contador--;
						labelContagem.setText(Integer.toString(contador));
						mudaCor(labelContagem);
				});

		
		String caminhoCss = getClass().getResource("/Contador/estilo.css")
				.toExternalForm();
		
		Scene cenaPrincipal = new Scene(boxPrincipal, 400, 400);
		
		cenaPrincipal.getStylesheets().add(caminhoCss);
		
		primaryStage.setScene(cenaPrincipal);
		
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}
	
	

}
