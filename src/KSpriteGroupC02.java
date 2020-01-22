import java.awt.*;

public class KSpriteGroupC02 extends KSpriteGroup implements KConstant {

	private		KText		kTextClearScore		= null;
	private		KText		kTextClearScore0	= null;
	private		KText		kTextClearBonus		= null;
	private		KText		kTextClearScore1	= null;

	public KSpriteGroupC02(KPanel panel){
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
			kTextClearScore = new KText(super.getKPanel(), 250, 250);
			kTextClearScore.setFont(new Font("HG�ۺ޼��M-PRO", Font.PLAIN, 16));
			super.getKPanel().addText("CLEAR", kTextClearScore);
			kTextClearScore.setText("ALL CLEAR");

			// ���b�Z�[�W�\��
			kTextClearScore0 = new KText(super.getKPanel(), 150, 350);
			kTextClearScore0.setFont(new Font("HG�ۺ޼��M-PRO", Font.PLAIN, 16));
			super.getKPanel().addText("CLEAR_SCORE_0", kTextClearScore0);
			kTextClearScore0.setText("SCORE       : " + kCTrlSKK.getScore());

			// �h��擾
			int shield = kCTrlSKK.getShield();

			// �h�䕪���Z
			kCTrlSKK.addScore(shield * 10000);

			// ���b�Z�[�W�\��
			kTextClearBonus = new KText(super.getKPanel(), 150, 390);
			kTextClearBonus.setFont(new Font("HG�ۺ޼��M-PRO", Font.PLAIN, 16));
			super.getKPanel().addText("CLEAR_BONUS", kTextClearBonus);
			kTextClearBonus.setText("BONUS SHIELD  " + shield + " X 10,000 = " + shield * 10000);

			// ���b�Z�[�W�\��
			kTextClearScore1 = new KText(super.getKPanel(), 150, 430);
			kTextClearScore1.setFont(new Font("HG�ۺ޼��M-PRO", Font.PLAIN, 16));
			super.getKPanel().addText("CLEAR_SCORE_1", kTextClearScore1);
			kTextClearScore1.setText("CLEAR SCORE : " + kCTrlSKK.getScore());

		}

		// �X�e�[�W�N���A�\���I���ɂȂ�����A
		if(time == 1000){

			// ���b�Z�[�W���\��
			super.getKPanel().removeText("CLEAR");
			super.getKPanel().removeText("CLEAR_SCORE_0");
			super.getKPanel().removeText("CLEAR_BONUS");
			super.getKPanel().removeText("CLEAR_SCORE_1");

			// �X�g�[�����Q�[���I�[�o�[
			KCtrlSKK kCTrlSKK = (KCtrlSKK)(super.getKPanel().getKCtrl());
			kCTrlSKK.gameover();

			super.getKPanel().removeSpriteGroup(this);

		}
	}

}
