package application;

import java.io.IOException;
import java.util.List;

import data.Idea;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class WorkAreaController {

	/**
	 * 作業エリア(ScrollPaneの中のAnchorPane)
	 */
	@FXML
	private AnchorPane workArea;

	/**
	 * 選択中のアイデア
	 */
	private Idea selectIdea = null;




	/**
	 * 新規アイデアを表示
	 */
	public void newIdeaDisp(Idea idea){
			try {

				//IdeaBoxをfxmlから作成
				FXMLLoader ideaBoxLoader = new FXMLLoader(getClass().getResource("IdeaBox.fxml"));
				VBox ideaBox = (VBox)ideaBoxLoader.load();
				//IdeaBoxのコントローラーを取得
				IdeaBoxController ideaBoxCtrl = (IdeaBoxController)ideaBoxLoader.getController();

				//IdeaBoxに投げる
				ideaBoxCtrl.newIdeaBox(idea);

				//表示位置探索(初期位置(20,20))
				Point2D p = searchPoint(20,20);
				ideaBox.relocate(p.getX(), p.getY());

				//Controllerを設定
				ideaBoxCtrl.setWorkAreaController(this);
				idea.setController(ideaBoxCtrl);

				//表示
				workArea.getChildren().add(ideaBox);


			} catch (IOException e) {
				e.printStackTrace();
			}

	}


	/**
	 * IdeaBoxを選択(クリック)したとき
	 * 表示を変えて、Informationに渡す
	 */
	public void selectIdea(Idea idea){
		if(selectIdea != null){
			selectIdea.getIdeaBox().setStyle("-fx-border-width : 0px");
		}
		selectIdea = idea;


	}

	/**
	 * 表示位置探索(既に表示済みのIdeaBoxと被らない位置を探す)
	 * @param a 探索を始める位置のx座標
	 * @param b 探索を始める位置のy座標
	 */
	private Point2D searchPoint(double a, double b){
		double x, y;	//return用
		List<Node> list = workArea.getChildren();

		double size = 10; //IdeaBoxの大きさ(被っているかの判定範囲)
		double m = 50; //探索幅

		for(x = a, y = b ;  ; x = x + m){
			boolean select = true;
			for(int i=0; i < list.size(); i++){	//workAreaにある全IdeaBoxを探索します
				if(list.get(i).getLayoutX() <= x && list.get(i).getLayoutX() + size >= x && list.get(i).getLayoutY() <= y && list.get(i).getLayoutY() + size >= y){
					select = false;
				}
			}

			//全IdeaBoxとの判定をクリアした点を返す
			if(select)
				return new Point2D(x,y);

			//探索の折り返し
			if(x > workArea.getWidth()){
				x = a;
				y = y + m;
			}
		}
	}


}
