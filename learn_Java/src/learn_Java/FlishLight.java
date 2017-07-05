/*
 * 2017年7月5日16:39:18
 * 制作手电筒类
 * 有电量
 * 有开灯，每开灯一次电量-1,开灯不能再开灯
 * 有关灯
 * 有充电，每充一次，电量+1
 */
package learn_Java;

public class FlishLight {
	public static void main(String[] args) {
		FlishLight x = new FlishLight();
		x.Off();
		x.Open();
		x.Charge();
		x.Off();
	}
	private int electric = 100;
	private boolean flag = false; // 开关灯状态，默认关，false为关
	/*
	 * 开灯
	 */
	public void Open(){
		if(this.electric == 0){
			System.out.println("手电筒已经没电了！请充电~");
		}
		else{
			if(!this.flag){
				electric -= 1;
				System.out.println("手电筒成功开启");
				this.flag = true;
			}
			else{
				System.out.println("手电筒已经打开了，不能重复打开");
			}
		}
	}
	/*
	 * 关灯
	 */
	public void Off() {
		if(!this.flag){
			System.out.println("手电筒已经处于关闭状态");
		}
		else{
			this.flag = false;
			System.out.println("手电筒成功关闭！");
		}
	}
	/*
	 * 充电
	 */
	public void Charge() {
		this.electric += 1;
		System.out.println("手电筒正在充电...");
	}
}
