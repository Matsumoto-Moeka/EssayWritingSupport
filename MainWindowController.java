package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;

public class MainWindowController implements Initializable {

	/**
	 * メニューバー(Top)
	 */
	@FXML
	private MenuBar menuBar;
	@FXML
	private MenuBarController menuBarController;

	/**
	 * 作業領域(Center)
	 */
	@FXML
	private AnchorPane workArea;
	@FXML
	private WorkAreaController workAreaController;

	/**
	 * 全体の操作(Left)
	 */
	@FXML
	private AnchorPane operation;
	@FXML
	private OperationController operationController;

	/**
	 * 情報(Right)
	 */
	@FXML
	private AnchorPane information;
	@FXML
	private InformationController informationController;


	@Override
	public void initialize(URL url,ResourceBundle rb){
		/**
		 * 各コントローラー同士の参照
		 */
		operationController.setWorkAreaController(workAreaController);

	}


}
