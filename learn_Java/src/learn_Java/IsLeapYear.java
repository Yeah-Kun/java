/*
 * 2017��7��5��15:31:22
 * �ж�2013���Ƿ�������
 * �ж���������
 * 1. ��������������4������Ϊ������Ϊƽ
 * 2. ������������400������Ϊ������ƽ
 */
package learn_Java;

public class IsLeapYear {
	public static void main(String[] args) {
		int x = 2013;
		if ((x%4 == 0 && x%100 != 0) || (x%400 == 0)){
			System.out.println("2013�����c��");
		}
		else{
			System.out.println("2013����ƽ��");
		}
	}
}
