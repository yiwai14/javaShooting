import java.awt.image.*;

public class KSpriteBackground extends KSprite {

	/**
	 * �R���X�g���N�^.
	 */
	public KSpriteBackground(KPanel panel){

		super(panel);

	}

	/**
	 * ���s.
	 * <pre>
	 * ���I�u�W�F�N�g�̂ӂ�܂������肵�܂��B
	 * </pre>
	 */
	public void run(){

		intY = intY + 1;

		if(intY > 600){
			intY = intY - 1200;
		}

	}

}
