package application;


/*
 * class Idea
 * 	１つのアイデアの全情報を格納するクラス
 * 	ただし、リンク関係の情報に関してはLinkクラスのインスタンスlinkを参照している
 *
 * */

public class Idea {

	/* アイデアが持つ情報(ユーザに入力させるもの) */
	private String keyword;		//キーワード
	private String memo;			//メモ
	private int importance = 1;			//重要度　初期値は1
	private int order = 1;				//順序　初期値は1

	/* アイデアが持つ情報(システムで管理するもの) */
	private Link link;					//リンク


	//////////コンストラクタ///////////
	public Idea(String keyword, String memo) {
		this.keyword = keyword;
		this.memo = memo;
		this.link = new Link();

		//display
		System.out.println("create Idea\n"
				+ "\t keyword:" + keyword + "\n"
				+ "\t memo:" + memo);
	}
	//////////////////////////////////


	///////////getter///////////////

	public String getKeyword() {
		return keyword;
	}


	public String getMemo() {
		return memo;
	}


	public int getImportance() {
		return importance;
	}


	public int getOrder() {
		return order;
	}


	public Link getLink() {
		return link;
	}

	///////////setter/////////////////

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public void setMemo(String memo) {
		this.memo = memo;
	}


	public void setImportance(int importance) {
		this.importance = importance;
	}


	public void setOrder(int order) {
		this.order = order;
	}


	//////////////////////////////////

}
