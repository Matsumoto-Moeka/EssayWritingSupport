package data;

import java.util.ArrayList;
import java.util.List;

/**
 * 	生成したアイデアを全て格納し、管理するクラス
 * @author 松本
 * */


public class IdeaController {

	private List<Idea> ideaList;		//生成されたすべてのアイデアを格納するリスト　型はIdea
	private Idea topic;					//Topicへのポインタ

	/**
	 * (削除したものも含めて)生成したすべてのアイデアの数。Ideaに渡すID用
	 */
	private int allIdeaCnt;

	///////コンストラクタ////////
	public IdeaController() {
		this.ideaList = new ArrayList<Idea>();
		allIdeaCnt = 0;
	}
	////////////////////////////



	//新規Idea追加
	public Idea addIdea(String kwd, String memo){
		Idea createIdea = new Idea(kwd,memo,++allIdeaCnt);
		ideaList.add(createIdea);
		return createIdea;
	}



}
