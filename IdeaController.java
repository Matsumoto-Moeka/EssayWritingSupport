package application;

import java.util.ArrayList;
import java.util.List;

/*
 * class IdeaController
 * 	生成したアイデアを全て格納し、管理するクラス
 * */


public class IdeaController {

	private List<Idea> ideaList;		//生成されたすべてのアイデアを格納するリスト　型はIdea
	private Idea topic;					//Topicへのポインタ

	///////コンストラクタ////////
	public IdeaController() {
		this.ideaList = new ArrayList<Idea>();
	}
	////////////////////////////



	//新規Idea追加
	public Idea addIdea(String kwd, String memo){
		Idea createIdea = new Idea(kwd,memo);
		ideaList.add(createIdea);
		return createIdea;
	}



}
