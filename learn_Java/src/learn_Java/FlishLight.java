/*
 * 2017��7��5��16:39:18
 * �����ֵ�Ͳ��
 * �е���
 * �п��ƣ�ÿ����һ�ε���-1,���Ʋ����ٿ���
 * �йص�
 * �г�磬ÿ��һ�Σ�����+1
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
	private boolean flag = false; // ���ص�״̬��Ĭ�Ϲأ�falseΪ��
	/*
	 * ����
	 */
	public void Open(){
		if(this.electric == 0){
			System.out.println("�ֵ�Ͳ�Ѿ�û���ˣ�����~");
		}
		else{
			if(!this.flag){
				electric -= 1;
				System.out.println("�ֵ�Ͳ�ɹ�����");
				this.flag = true;
			}
			else{
				System.out.println("�ֵ�Ͳ�Ѿ����ˣ������ظ���");
			}
		}
	}
	/*
	 * �ص�
	 */
	public void Off() {
		if(!this.flag){
			System.out.println("�ֵ�Ͳ�Ѿ����ڹر�״̬");
		}
		else{
			this.flag = false;
			System.out.println("�ֵ�Ͳ�ɹ��رգ�");
		}
	}
	/*
	 * ���
	 */
	public void Charge() {
		this.electric += 1;
		System.out.println("�ֵ�Ͳ���ڳ��...");
	}
}
