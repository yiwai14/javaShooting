import java.awt.image.*;

public class KSpriteBackground extends KSprite {

	/**
	 * コンストラクタ.
	 */
	public KSpriteBackground(KPanel panel){

		super(panel);

	}

	/**
	 * 実行.
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * </pre>
	 */
	public void run(){

		intY = intY + 1;

		if(intY > 600){
			intY = intY - 1200;
		}

	}

}
