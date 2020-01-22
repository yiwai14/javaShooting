//import java.awt.event.*;
//import java.awt.image.*;
import java.util.*;

public class KSpriteBeam1 extends KSprite implements KConstant {

	private		int		mY		= 12;

	/**
	 * �R���X�g���N�^.
	 */
	public KSpriteBeam1(KPanel panel, int mY){

		super(panel);

		this.mY = mY;

	}

	/**
	 * ���s.
	 * <pre>
	 * ���I�u�W�F�N�g�̂ӂ�܂������肵�܂��B
	 * �p����Œ�`�����Ă��������B
	 * <pre>
	 */
	public void run(){

		intY = intY - mY;

		if(intY < -32){
			super.removeSprite();
		}

		//
		// ����
		//

		// �X�v���C�g�ꗗ�擾
		ArrayList<KSprite> spriteLst = panel.getSpriteLst(LAYOUT_TEKI);

		// �X�v���C�g�ꗗ�̌������擾
		int countSpriteLst = spriteLst.size();

		// �X�v���C�g�ꗗ�̌������A���[�v
		for(int i = 0; i < countSpriteLst; i++){

			// �X�v���C�g���擾
			KSprite sprite = spriteLst.get(i);

			// null�̏ꍇ�A
			if(sprite == null){
				// �R���e�B�j���[
				continue;
			}

			// �G�ł͂Ȃ��ꍇ�A
			if(!(sprite instanceof KSpriteT00)){
				// �R���e�B�j���[
				continue;
			}

			// �G�ɃL���X�g
			KSpriteT00 spriteT00 = (KSpriteT00)sprite;

			// �������Ă���ꍇ�A
			if(spriteT00.isBomb()){
				// �R���e�B�j���[
				continue;
			}

			// XY�擾
			int intXT00 = spriteT00.intX;
			int intYT00 = spriteT00.intY;

			// �傫���擾
			int intWidthT00 = spriteT00.getWidth();
			int intHeightT00 = spriteT00.getHeight();

			// �����蔻��
			if(intX < (intXT00 + intWidthT00) && intXT00 < (intX + this.getWidth()) &&
							intY < (intYT00 + intHeightT00) && intYT00 < (intY + this.getHeight()) ){
				// ����
				spriteT00.bomb();
				// �X�v���C�g�폜
				super.removeSprite();
			}

		} // end for �X�v���C�g�ꗗ�̌������A���[�v

	} // end run

}
