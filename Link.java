package data;

import java.util.ArrayList;
import java.util.List;


/* class Link
 * 	アイデアの親子関係や、それに対応するラベルを格納するクラス
 * 	アイデアと1対1で作成される
 *
 * */


public class Link {

	/* Linkが持つ情報 */

	private Idea parentIdea;						//親アイデア
	private String parentIdeaLabel;					//親アイデア側のラベル		/**** 型要検討 ****/

	private List<Idea> childIdeaList;			//子アイデアのリスト
	private List<String> childIdeaLabel;		//子アイデア側のラベル		/**** 型要検討 ****/


	///////////コンストラクタ/////////////
	public Link(){
		parentIdea = null;
		parentIdeaLabel = null;
		childIdeaList = new ArrayList<Idea>();
		childIdeaLabel = new ArrayList<String>();

	}

	//////////////////////////////////////

}
