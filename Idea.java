package application;


/**
 * 	１つのアイデアの全情報を格納する
 * 	ただし、リンク関係の情報に関してはLinkクラスのインスタンスlinkを参照している
 *	@author 松本
 * */

public class Idea {

	//// アイデアが持つ情報(ユーザに入力させるもの) ///
	/**
	 * キーワード
	 */
	private String keyword;

	/**
	 * メモ
	 */
	private String memo;

	/**
	 * 重要度　初期値=0<br>
	 * 兄弟アイデア間単位でつける
	 */
	private int importance = 0;

	/**
	 * 順序　初期値=0<br>
	 * 兄弟アイデア間単位でつける
	 */
	private int order = 0;



	/// アイデアが持つ情報(システムで管理するもの) ///

	/**
	 * ID<br>
	 * 識別用ID。（削除したものも含めて）生成した順の通し番号。通し番号はIdeaControllerからもらう
	 */
	private int id;

	/**
	 * リンク
	 */
	private Link link;


	//////////コンストラクタ///////////
	public Idea(String keyword, String memo, int id) {
		this.keyword = keyword;
		this.memo = memo;
		this.link = new Link();
		this.id = id;

		//display
		System.out.println("create Idea\n"
				+ "\t keyword:" + keyword + "\n"
				+ "\t memo:" + memo + "\n"
				+ "\t id:" + id);
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
