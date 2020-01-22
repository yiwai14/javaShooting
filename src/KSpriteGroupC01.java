import java.awt.*;

public class KSpriteGroupC01 extends KSpriteGroup implements KConstant {

	private		KText		kTextClear	= null;

	public KSpriteGroupC01(KPanel panel){
		super(panel);

	}

	public void run(){

		// ��莞�Ԍo�߂̏ꍇ�A
		if(time <= 64 && (time % 16) == 0){
			for(int i = 0; i < 600; i = i + 32){
				KSpriteJ01 kSpriteJ01 = new KSpriteJ01(super.getKPanel(), i);
				super.getKPanel().addSprite(LAYOUT_JIMEN, kSpriteJ01);
			}
		}

		// �n�ʂ���\���ɂȂ�����A
		if(time == 320){

			// �X�g�[���[���X�g�b�v
			KCtrlSKK kCTrlSKK = (KCtrlSKK)(super.getKPanel().getKCtrl());
			kCTrlSKK.stop();

			// ���b�Z�[�W�\��
			kTextClear = new KText(super.getKPanel(), 230, 250);
			kTextClear.setFont(new Font("HG�ۺ޼��M-PRO", Font.PLAIN, 16));
			super.getKPanel().addText("CLEAR", kTextClear);
			kTextClear.setText("STAGE ".concat(Integer.toString(kCTrlSKK.getStage())).concat(" CLEAR"));

		}

		// �X�e�[�W�N���A�\���I���ɂȂ�����A
		if(time == 500){

			// ���b�Z�[�W���\��
			super.getKPanel().removeText("CLEAR");

			// �X�g�[�����X�^�[�g
			KCtrlSKK kCTrlSKK = (KCtrlSKK)(super.getKPanel().getKCtrl());
			kCTrlSKK.restart();

			super.getKPanel().removeSpriteGroup(this);

			// �X�e�[�W�{�P
			kCTrlSKK.addStage();

		}
	}

}
