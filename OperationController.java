package application;

import data.Idea;
import data.IdeaController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class OperationController {

	/**
	 * 大元のレイアウト
	 */
	@FXML
	private AnchorPane operationArea;

	/**
	 * 追加ボタン
	 */
	@FXML
	private Button addButton;

	/**
	 * キーワード入力領域
	 */
	@FXML
	private TextField keywordField;

	/**
	 * メモ入力領域
	 */
	@FXML
	private TextArea memoArea;


	/**
	 * workAreaのコントローラー
	 */
	private WorkAreaController workAreaCtrl;




	private IdeaController ideaController = new IdeaController();

	//メインウィンドウと対象のワークエリア指定
//	BorderPane mainWindow = (BorderPane) operationArea.getParent();
//	AnchorPane workArea = (AnchorPane) mainWindow.getCenter();


	/**
	 * workAreaControllerの設定
	 */
	public void setWorkAreaController(WorkAreaController wac){
		workAreaCtrl = wac;
	}


	/**
	 * 追加ボタンを押したときの動作。<br>
	 * キーワード、メモを取得して新しいアイデアを作り、表示
	 * @author 松本
	 */
	@FXML
	protected void addIdeaAction(ActionEvent e){

		//アイデアを生成、追加
		Idea createIdea = ideaController.addIdea(keywordField.getText(), memoArea.getText());

		//入力フォームをクリア
		keywordField.setText("");
		memoArea.setText("");

		//作ったアイデアをWorkAreaに渡す
		workAreaCtrl.newIdeaDisp(createIdea);



	}
}