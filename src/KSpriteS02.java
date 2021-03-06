import java.awt.event.*;
import java.awt.image.*;
import java.util.*;

public class KSpriteS02 extends KSprite implements KConstant {

	private final int SPRITE_WIDTH = 32;

	private final int MARGIN = 48;

	private final int RANGE = (WIDTH - MARGIN * 2) / 2;

	private final int CENTER = WIDTH / 2 - SPRITE_WIDTH;

	private double doubleY = 0d;

	/**
	 * コンストラクタ.
	 */
	public KSpriteS02(KPanel panel){

		super(panel);

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

		doubleY = doubleY + 1.0;
		intY = (int)doubleY;

		if(intY > HEIGHT){
			super.removeSprite();
		}

		intX = CENTER + (int)(Math.sin(Math.toRadians((double)(doubleY % 360))) * RANGE);

	} // end run

}
