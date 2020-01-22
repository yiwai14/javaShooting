//import java.awt.event.*;
//import java.awt.image.*;
import java.util.*;

public class KSpriteBeam1 extends KSprite implements KConstant {

	private		int		mY		= 12;

	/**
	 * コンストラクタ.
	 */
	public KSpriteBeam1(KPanel panel, int mY){

		super(panel);

		this.mY = mY;

	}

	/**
	 * 実行.
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	public void run(){

		intY = intY - mY;

		if(intY < -32){
			super.removeSprite();
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

			// 敵ではない場合、
			if(!(sprite instanceof KSpriteT00)){
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

			// XY取得
			int intXT00 = spriteT00.intX;
			int intYT00 = spriteT00.intY;

			// 大きさ取得
			int intWidthT00 = spriteT00.getWidth();
			int intHeightT00 = spriteT00.getHeight();

			// 当たり判定
			if(intX < (intXT00 + intWidthT00) && intXT00 < (intX + this.getWidth()) &&
							intY < (intYT00 + intHeightT00) && intYT00 < (intY + this.getHeight()) ){
				// 爆発
				spriteT00.bomb();
				// スプライト削除
				super.removeSprite();
			}

		} // end for スプライト一覧の件数分、ループ

	} // end run

}
