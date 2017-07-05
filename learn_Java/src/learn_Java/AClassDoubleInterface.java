/*
 * 2017年7月5日17:23:28
 * 学习interface（接口）
 * 实现一个类多个接口
 * 能玩音乐的水杯
 */
package learn_Java;

// 两个接口
interface MusicPlayer {
	void play();
}

interface Cup {
	void addWater(int w);

	void drinkWater(int w);
}

// MusicCup调用两个接口
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
