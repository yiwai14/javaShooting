import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;

/**
 * 自機.
 */
public class KSpriteShip extends KSprite implements KConstant {

	/**
	 * 移動量.
	 */
	private float amount = 0.0f;

	/**
	 * ビーム発射間隔.
	 */
	private		int					intervalBeam		= 20;
	/**
	 * ビームスピード.
	 */
	private		int					speedBeam			= 12;
	/**
	 * ビーム時間.
	 */
	private		int					timeBeam			= intervalBeam;

	/**
	 * 被弾時間.
	 */
	private		int					timeHidan			= 0;

	/**
	 * 被弾立て直し時間.
	 */
	private final int				HIDAN				= 200;

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
	public KSpriteShip(KPanel panel){

		super(panel);

	} // end KSpriteShip

	/**
	 * 初期化.
	 */
	public void init(){

		// 位置初期化
		this.setX(284);
		this.setY(480);

		// ビーム発射間隔
		intervalBeam		= 20;
		// ビームスピード
		speedBeam			= 12;
		// ビーム時間.
		timeBeam			= intervalBeam;
		// 被弾時間.
		timeHidan			= 0;

		// 爆発フラグ
		flgBomb = false;

		// イメージ初期化
		setImage(KSpriteShip.class, 0);

	} // end init

	/**
	 * 実行.
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	public void run(){

		// 撃墜された場合、
		if(flgBomb){

			timeBomb++;

			if(timeBomb == 10){
				setImage(KSpriteShip.class, 2);
			}else if(timeBomb == 30){
				setImage(KSpriteShip.class, 1);
			}

			// リターン
			return;

		} // end if 撃墜された場合

		//
		// 移動
		//

		if(panel.isKeyCodePressed(KeyEvent.VK_LEFT)){
			if(intX > 0){
				intX = intX - (int)(4.0 + amount);
			}
		}

		if(panel.isKeyCodePressed(KeyEvent.VK_RIGHT)){
			if(intX < (panel.getWidth() - this.getWidth())){
				intX = intX + (int)(4.0 + amount);
			}
		}

		if(panel.isKeyCodePressed(KeyEvent.VK_UP)){
			if(intY > 0){
				intY = intY - (int)(4.0 + amount);
			}
		}

		if(panel.isKeyCodePressed(KeyEvent.VK_DOWN)){
			if(intY < (panel.getHeight() - this.getHeight())){
				intY = intY + (int)(4.0 + amount);
			}
		}

		//
		// ビーム
		//
		this.timeBeam++;

		if(this.timeBeam >= this.intervalBeam){

			this.timeBeam = 0;

			KSpriteBeam1 spriteBeam1 = new KSpriteBeam1(panel, speedBeam);
			panel.addSprite(LAYOUT_JIMEN, spriteBeam1);
			spriteBeam1.setX(this.getX());
			spriteBeam1.setY(this.getY());

		}

		//
		// 判定
		//

		// スプライト一覧取得
		ArrayList<KSprite> spriteLst = panel.getSpriteLst(LAYOUT_TEKI);

		// スプライト一覧の件数を取得
		int countSpriteLst = spriteLst.size();

		// スプライト一覧の件数分、ループ
		for(int i = 0; i < countSpriteLst; i++){

			// スプライトを取得
			KSprite sprite = spriteLst.get(i);

			// nullの場合、
			if(sprite == null){
				// コンティニュー
				continue;
			}

			// XY取得
			int intXSprite = sprite.intX;
			int intYSprite = sprite.intY;

			// 大きさ取得
			int intWidthSprite = sprite.getWidth();
			int intHeightSprite = sprite.getHeight();

			// 当たり判定
			if(intX + 4 < (intXSprite + intWidthSprite) && intXSprite < (intX + this.getWidth() - 4) &&
							intY + 4 < (intYSprite + intHeightSprite) && intYSprite < (intY + this.getHeight() - 4) ){

			// 当たっていない場合、
			}else{
				// コンティニュー
				continue;
			}

			// 敵の場合、
			if(sprite instanceof KSpriteT00){

				// 被弾中の場合、
				if(timeHidan > 0){
					// コンティニュー
					continue;
				}

				// 敵にキャスト
				KSpriteT00 spriteT00 = (KSpriteT00)sprite;

				// 爆発している場合、
				if(spriteT00.isBomb()){
					// コンティニュー
					continue;
				}

				// 敵を爆発させる
				spriteT00.bomb();

				// 被弾処理
				hidan();

			// ビームの場合、
			}else if(sprite instanceof KSpriteT99){

				// 被弾中の場合、
				if(timeHidan > 0){
					// コンティニュー
					continue;
				}

				// ビームを消去する
				sprite.removeSprite();

				// 被弾処理
				hidan();

			// Sの場合、
			}else if(sprite instanceof KSpriteS01){

				// スプライトを削除
				sprite.removeSprite();

				// 移動量を増やす
				amount = amount + 0.5f;

			// Mの場合、
			}else if(sprite instanceof KSpriteS02){

				// スプライトを削除
				sprite.removeSprite();

				// ビーム発射間隔が最大以外の場合、
				if(intervalBeam > 5){

					// ビーム発射間隔を短くする
					intervalBeam = intervalBeam - 5;

				}

			// Hの場合、
			}else if(sprite instanceof KSpriteS03){

				// スプライトを削除
				sprite.removeSprite();

				// ビームスピードが最大以外の場合、
				if(intervalBeam < 20){

					// ビームスピードを早くする
					speedBeam = speedBeam + 4;

				}

			// 1の場合、
			}else if(sprite instanceof KSpriteS04){

				// スプライトを削除
				sprite.removeSprite();

				// 防御加算
				((KCtrlSKK)panel.getKCtrl()).addShield(1);

			}

		} // end for スプライト一覧の件数分、ループ

		// 被弾時間計算
		timeHidan = (timeHidan > 0)?--timeHidan: 0;

	} // end run

	/**
	 * 表示の必要があれば実行されるメソッド.
	 * <pre>
	 * 被弾中は一時的に表示しません。
	 * </pre>
	 */
	public void paint(Graphics g){

		// 撃墜後の場合、
		if(timeBomb >= 40){
			// リターン
			// 自機を表示しない
			return;
		}

		// 被弾中の場合、
		if(timeHidan > 0){

			// 表示しない場合、
			if((timeHidan % 20) > 10){
				// リターン
				// 自機を表示しない
				return;
			}

		}

		super.paint(g);

	} // end paint

	/**
	 * 被弾処理.
	 */
	private void hidan(){

		// 防御減算
		int shield = ((KCtrlSKK)panel.getKCtrl()).addShield(-1);

		// 防御が無くなった場合、
		if(shield == 0){

			// 撃墜
			flgBomb = true;

			setImage(KSpriteShip.class, 1);

			// リターン
			return;

		}

		// 移動量を減らす
		if(amount > 0.0f){
			amount = amount - 0.5f;
		}

		// ビーム発射間隔を長くする
		if(intervalBeam < 20){
			intervalBeam = intervalBeam + 5;
		}

		// ビームスピードを遅くする
		if(speedBeam > 12){
			speedBeam = speedBeam - 4;
		}

		// 被弾時間
		timeHidan = HIDAN;

	} // end hidan

}
