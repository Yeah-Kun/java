/*
 * 2017��7��5��17:23:28
 * ѧϰinterface���ӿڣ�
 * ʵ��һ�������ӿ�
 * �������ֵ�ˮ��
 */
package learn_Java;

// �����ӿ�
interface MusicPlayer {
	void play();
}

interface Cup {
	void addWater(int w);

	void drinkWater(int w);
}

// MusicCup���������ӿ�
class MusicCup implements MusicPlayer, Cup {
	public void addWater(int w) {
		this.water = this.water + w;
	}

	public void drinkWater(int w) {
		this.water = this.water - w;
	}

	public void play() {
		System.out.println("la...la...la");
	}

	private int water = 0;
}

public class AClassDoubleInterface {
	public static void main(String[] args) {
		MusicCup cup = new MusicCup();
		cup.addWater(10);
		cup.play();
	}
}
