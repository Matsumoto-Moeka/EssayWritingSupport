package application;

/**
 * メイン画面に関する動作記述
 * @author 松本
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MainWindowController {

	/**
	 * 作業領域
	 */
	@FXML
	private AnchorPane workArea;

	///////左側領域////////

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



	///////右側領域////////






	///////変数宣言////////
	private IdeaController ideaController = new IdeaController();


	/**
	 * 追加ボタンを押したときの動作。<br>
	 * キーワード、メモを取得して新しいアイデアを作り、表示
	 * @author 松本
	 */
	@FXML
	protected void addIdeaAction(ActionEvent e){
		System.out.println("addButton pressed.");

		//アイデアを生成、追加
		Idea createIdea = ideaController.addIdea(keywordField.getText(), memoArea.getText());

		//入力フォームをクリア
		keywordField.setText("");
		memoArea.setText("");

		//アイデア表示用コンテナを作成
		VBox ideaPane = new VBox();
		ideaPane.getChildren().add(new Label(createIdea.getKeyword()));
		ideaPane.getChildren().add(new Label(createIdea.getMemo()));
		workArea.getChildren().add(ideaPane);

	}

}
