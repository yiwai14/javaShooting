import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;

/**
 * ���@.
 */
public class KSpriteShip extends KSprite implements KConstant {

	/**
	 * �ړ���.
	 */
	private float amount = 0.0f;

	/**
	 * �r�[�����ˊԊu.
	 */
	private		int					intervalBeam		= 20;
	/**
	 * �r�[���X�s�[�h.
	 */
	private		int					speedBeam			= 12;
	/**
	 * �r�[������.
	 */
	private		int					timeBeam			= intervalBeam;

	/**
	 * ��e����.
	 */
	private		int					timeHidan			= 0;

	/**
	 * ��e���Ē�������.
	 */
	private final int				HIDAN				= 200;

	/**
	 * �����t���O.
	 */
	private boolean flgBomb = false;

	/**
	 * ��������.
	 */
	private int timeBomb = -1;

	/**
	 * �R���X�g���N�^.
	 */
	public KSpriteShip(KPanel panel){

		super(panel);

	} // end KSpriteShip

	/**
	 * ������.
	 */
	public void init(){

		// �ʒu������
		this.setX(284);
		this.setY(480);

		// �r�[�����ˊԊu
		intervalBeam		= 20;
		// �r�[���X�s�[�h
		speedBeam			= 12;
		// �r�[������.
		timeBeam			= intervalBeam;
		// ��e����.
		timeHidan			= 0;

		// �����t���O
		flgBomb = false;

		// �C���[�W������
		setImage(KSpriteShip.class, 0);

	} // end init

	/**
	 * ���s.
	 * <pre>
	 * ���I�u�W�F�N�g�̂ӂ�܂������肵�܂��B
	 * �p����Œ�`�����Ă��������B
	 * <pre>
	 */
	public void run(){

		// ���Ă��ꂽ�ꍇ�A
		if(flgBomb){

			timeBomb++;

			if(timeBomb == 10){
				setImage(KSpriteShip.class, 2);
			}else if(timeBomb == 30){
				setImage(KSpriteShip.class, 1);
			}

			// ���^�[��
			return;

		} // end if ���Ă��ꂽ�ꍇ

		//
		// �ړ�
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
		// �r�[��
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

			// XY�擾
			int intXSprite = sprite.intX;
			int intYSprite = sprite.intY;

			// �傫���擾
			int intWidthSprite = sprite.getWidth();
			int intHeightSprite = sprite.getHeight();

			// �����蔻��
			if(intX + 4 < (intXSprite + intWidthSprite) && intXSprite < (intX + this.getWidth() - 4) &&
							intY + 4 < (intYSprite + intHeightSprite) && intYSprite < (intY + this.getHeight() - 4) ){

			// �������Ă��Ȃ��ꍇ�A
			}else{
				// �R���e�B�j���[
				continue;
			}

			// �G�̏ꍇ�A
			if(sprite instanceof KSpriteT00){

				// ��e���̏ꍇ�A
				if(timeHidan > 0){
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

				// �G�𔚔�������
				spriteT00.bomb();

				// ��e����
				hidan();

			// �r�[���̏ꍇ�A
			}else if(sprite instanceof KSpriteT99){

				// ��e���̏ꍇ�A
				if(timeHidan > 0){
					// �R���e�B�j���[
					continue;
				}

				// �r�[������������
				sprite.removeSprite();

				// ��e����
				hidan();

			// S�̏ꍇ�A
			}else if(sprite instanceof KSpriteS01){

				// �X�v���C�g���폜
				sprite.removeSprite();

				// �ړ��ʂ𑝂₷
				amount = amount + 0.5f;

			// M�̏ꍇ�A
			}else if(sprite instanceof KSpriteS02){

				// �X�v���C�g���폜
				sprite.removeSprite();

				// �r�[�����ˊԊu���ő�ȊO�̏ꍇ�A
				if(intervalBeam > 5){

					// �r�[�����ˊԊu��Z������
					intervalBeam = intervalBeam - 5;

				}

			// H�̏ꍇ�A
			}else if(sprite instanceof KSpriteS03){

				// �X�v���C�g���폜
				sprite.removeSprite();

				// �r�[���X�s�[�h���ő�ȊO�̏ꍇ�A
				if(intervalBeam < 20){

					// �r�[���X�s�[�h�𑁂�����
					speedBeam = speedBeam + 4;

				}

			// 1�̏ꍇ�A
			}else if(sprite instanceof KSpriteS04){

				// �X�v���C�g���폜
				sprite.removeSprite();

				// �h����Z
				((KCtrlSKK)panel.getKCtrl()).addShield(1);

			}

		} // end for �X�v���C�g�ꗗ�̌������A���[�v

		// ��e���Ԍv�Z
		timeHidan = (timeHidan > 0)?--timeHidan: 0;

	} // end run

	/**
	 * �\���̕K�v������Ύ��s����郁�\�b�h.
	 * <pre>
	 * ��e���͈ꎞ�I�ɕ\�����܂���B
	 * </pre>
	 */
	public void paint(Graphics g){

		// ���Č�̏ꍇ�A
		if(timeBomb >= 40){
			// ���^�[��
			// ���@��\�����Ȃ�
			return;
		}

		// ��e���̏ꍇ�A
		if(timeHidan > 0){

			// �\�����Ȃ��ꍇ�A
			if((timeHidan % 20) > 10){
				// ���^�[��
				// ���@��\�����Ȃ�
				return;
			}

		}

		super.paint(g);

	} // end paint

	/**
	 * ��e����.
	 */
	private void hidan(){

		// �h�䌸�Z
		int shield = ((KCtrlSKK)panel.getKCtrl()).addShield(-1);

		// �h�䂪�����Ȃ����ꍇ�A
		if(shield == 0){

			// ����
			flgBomb = true;

			setImage(KSpriteShip.class, 1);

			// ���^�[��
			return;

		}

		// �ړ��ʂ����炷
		if(amount > 0.0f){
			amount = amount - 0.5f;
		}

		// �r�[�����ˊԊu�𒷂�����
		if(intervalBeam < 20){
			intervalBeam = intervalBeam + 5;
		}

		// �r�[���X�s�[�h��x������
		if(speedBeam > 12){
			speedBeam = speedBeam - 4;
		}

		// ��e����
		timeHidan = HIDAN;

	} // end hidan

}
