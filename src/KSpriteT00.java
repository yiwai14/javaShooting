/**
 * �G�X�v���C�g.
 * <pre>
 * �G�X�v���C�g�I�u�W�F�N�g�Ƃ��ċ��ʉ��ł��镔�����L�q���܂��B
 * �����������s���܂��B
 * <pre>
 */
public class KSpriteT00 extends KSprite {

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
	public KSpriteT00(KPanel panel){

		super(panel);

	}

	/**
	 * ���s.
	 * <pre>
	 * ���I�u�W�F�N�g�̂ӂ�܂������肵�܂��B
	 * �p����Œ�`�����Ă��������B
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
	 * ����.
	 */
	public void bomb(){
		flgBomb = true;
		setImage(KSpriteT00.class, 0);
	}

	/**
	 * �����擾.
	 */
	public boolean isBomb(){
		return flgBomb;
	}

}
