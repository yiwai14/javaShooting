import java.awt.event.*;
import java.awt.image.*;
import java.util.*;

public class KSpriteJ02 extends KSprite implements KConstant {

	/**
	 * �R���X�g���N�^.
	 */
	public KSpriteJ02(KPanel panel, int intX){

		super(panel);

		this.intX = intX;
		intY = -getHeight();

	}

	/**
	 * ���s.
	 * <pre>
	 * ���I�u�W�F�N�g�̂ӂ�܂������肵�܂��B
	 * �p����Œ�`�����Ă��������B
	 * <pre>
	 */
	public void run(){

		intY = intY + 2;

		if(intY > HEIGHT){
			super.removeSprite();
		}

	}

}
