import java.awt.event.*;
import java.awt.image.*;
import java.util.*;

public class KSpriteJ02 extends KSprite implements KConstant {

	/**
	 * コンストラクタ.
	 */
	public KSpriteJ02(KPanel panel, int intX){

		super(panel);

		this.intX = intX;
		intY = -getHeight();

	}

	/**
	 * 実行.
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	public void run(){

		intY = intY + 2;

		if(intY > HEIGHT){
			super.removeSprite();
		}

	}

}
