package application;

import data.Idea;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class IdeaBoxController {

	@FXML
	private VBox ideaBox;

	/**
	 * キーワード表示用
	 */
	@FXML
	private Label keywordLabel;

	/**
	 * メモ表示用
	 */
	@FXML
	private Label memoLabel;


	/**
	 * 対応するアイデア
	 */
	private Idea idea;

	/**
	 * IdeaBoxの位置（WorkArea左上端を基準とした、Boxの左上端の位置）
	 * ていうかこれいる？？？Saveの時に保存するくらい？でもそれならIdeaのほうかも。Ideaにもメモ残してます
	 */
	private Point2D point;

	/**
	 * 対応するworkAreaController
	 */
	private WorkAreaController workAreaCtrl;




	/**
	 * 新規IdeaBox初期設定
	 */
	public void newIdeaBox(Idea idea){
		keywordLabel.setText(idea.getKeyword());
		memoLabel.setText(idea.getMemo());
		this.idea = idea;

	}

	/**
	 * workAreaControllerの設定
	 */
	public void setWorkAreaController(WorkAreaController wac){
		workAreaCtrl = wac;
	}

	/**
	 * クリックしたときの動作
	 * 枠を黒にして、workAreaControllerに送る
	 */
	@FXML
	protected void clickIdea(MouseEvent e){
		ideaBox.setStyle("-fx-border-width : 1px");
		workAreaCtrl.selectIdea(idea);
	}


	/* ドラッグ処理ここから */
	private double dragAnchorX;
	private double dragAnchorY;

	@FXML
	protected void pressedIdea(MouseEvent e){
		Node node = (Node)e.getSource();
		dragAnchorX = e.getSceneX() - node.getLayoutX();
		dragAnchorY = e.getSceneY() - node.getLayoutY();
	}

	@FXML
	protected void draggedIdea(MouseEvent e){
		Node node = (Node)e.getSource();
		node.setLayoutX(e.getSceneX() - dragAnchorX);
		node.setLayoutY(e.getSceneY() - dragAnchorY);
	}
	/* ドラッグ処理ここまで */




	//////// getter ////////
	public Point2D getPoint(){
		return point;
	}

	public VBox getIdeaBox(){
		return ideaBox;
	}


	/////// setter ////////
	public void setPoint(Point2D point){
		this.point = point;
	}

}
