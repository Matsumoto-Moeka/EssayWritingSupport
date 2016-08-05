package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MainWindowController {

	@FXML
	private AnchorPane workArea;

	@FXML
	private Button addButton;

	@FXML
	private TextField keywordField;

	@FXML
	private TextArea memoArea;

	private IdeaController ideaController = new IdeaController();


	@FXML
	protected void addIdeaAction(ActionEvent e){
		System.out.println("addButton pressed.");

		String kwd = keywordField.getText();
		String memo = memoArea.getText();

		Idea createIdea = ideaController.addIdea(kwd, memo);

		keywordField.setText("");
		memoArea.setText("");

		VBox ideaPane = new VBox();
		ideaPane.getChildren().add(new Label(createIdea.getKeyword()));
		ideaPane.getChildren().add(new Label(createIdea.getMemo()));
		workArea.getChildren().add(ideaPane);

	}

}
