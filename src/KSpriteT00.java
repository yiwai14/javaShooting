/**
 * 敵スプライト.
 * <pre>
 * 敵スプライトオブジェクトとして共通化できる部分を記述します。
 * 爆発処理を行います。
 * <pre>
 */
public class KSpriteT00 extends KSprite {

	/**
	 * 爆発フラグ.
	 */
	private boolean flgBomb = false;

	/**
	 * 爆発時間.
	 */
	private int timeBomb = -1;

	/**
	 * コンストラクタ.
	 */
	public KSpriteT00(KPanel panel){

		super(panel);

	}

	/**
	 * 実行.
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	public void run(){

		if(flgBomb){

			timeBomb++;

			if(timeBomb == 5){
				setImage(KSpriteT00.class, 1);
			}else if(timeBomb == 15){
				setImage(KSpriteT00.class, 0);
			}else if(timeBomb == 20){
				super.removeSprite();
			}

		}

	}

	/**
	 * 爆発.
	 */
	public void bomb(){
		flgBomb = true;
		setImage(KSpriteT00.class, 0);
	}

	/**
	 * 爆発取得.
	 */
	public boolean isBomb(){
		return flgBomb;
	}

}
