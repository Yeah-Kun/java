/*
 * 2017年7月5日15:15:07
 * 31页调试程序（2）
 * 理解print是不换行，println是换行
 */
package learn_Java;

public class OutputData {
	public static void main(String[] args) {
		int x = 234, y = 432;
		System.out.println(x+"<"+(2*x));
		System.out.print("我输出结果后不回车");
		System.out.println("我输出结果后自动回车到下一行");
		System.out.println("x+y="+(x+y));
	}
}
