package application;

import java.util.Properties;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("MainWindow.fxml"));

			Scene scene = new Scene(root);

			//css指定　なんかエラーになる 2016/8/8
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setTitle("EssayWritingSupport");	//左上のタイトル
			primaryStage.show();




		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init(){
		Properties prop = System.getProperties();
		Object fxVer = prop.get("javafx.runtime.version");		//JavaFXのバージョンを取得
		System.out.println("JavaFX version ="+ fxVer);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
