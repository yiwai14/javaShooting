/**
 * �X�v���C�g�O���[�v.
 * <pre>
 * �X�v���C�g�𕡐��Ǘ�����N���X�B
 * </pre>
 */
abstract public class KSpriteGroup extends KSpriteObject {

	/**
	 * �p�l��.
	 */
	protected KPanel panel = null;

	/**
	 * ����.
	 */
	public		int		time		= -1;

	/**
	 * �R���X�g���N�^.
	 * @param panel KPanel
	 */
	public KSpriteGroup(KPanel panel){
		this.panel = panel;
	}

	/**
	 * ���s.
	 * <pre>
	 * ���I�u�W�F�N�g�̂ӂ�܂������肵�܂��B
	 * �p����Œ�`�����Ă��������B
	 * <pre>
	 */
	abstract public void run();

	/**
	 * ���Ԃ�i�߂�.
	 */
	public void forward(){
		time++;
	}

	/**
	 * �p�l���擾.
	 */
	public KPanel getKPanel(){
		return panel;
	}

}
