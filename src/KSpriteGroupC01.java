import java.awt.*;

public class KSpriteGroupC01 extends KSpriteGroup implements KConstant {

	private		KText		kTextClear	= null;

	public KSpriteGroupC01(KPanel panel){
		super(panel);

	}

	public void run(){

		// 一定時間経過の場合、
		if(time <= 64 && (time % 16) == 0){
			for(int i = 0; i < 600; i = i + 32){
				KSpriteJ01 kSpriteJ01 = new KSpriteJ01(super.getKPanel(), i);
				super.getKPanel().addSprite(LAYOUT_JIMEN, kSpriteJ01);
			}
		}

		// 地面が非表示になったら、
		if(time == 320){

			// ストーリーをストップ
			KCtrlSKK kCTrlSKK = (KCtrlSKK)(super.getKPanel().getKCtrl());
			kCTrlSKK.stop();

			// メッセージ表示
			kTextClear = new KText(super.getKPanel(), 230, 250);
			kTextClear.setFont(new Font("HG丸ｺﾞｼｯｸM-PRO", Font.PLAIN, 16));
			super.getKPanel().addText("CLEAR", kTextClear);
			kTextClear.setText("STAGE ".concat(Integer.toString(kCTrlSKK.getStage())).concat(" CLEAR"));

		}

		// ステージクリア表示終わりになったら、
		if(time == 500){

			// メッセージを非表示
			super.getKPanel().removeText("CLEAR");

			// ストーリをスタート
			KCtrlSKK kCTrlSKK = (KCtrlSKK)(super.getKPanel().getKCtrl());
			kCTrlSKK.restart();

			super.getKPanel().removeSpriteGroup(this);

			// ステージ＋１
			kCTrlSKK.addStage();

		}
	}

}
