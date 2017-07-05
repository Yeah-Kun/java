/*
 * 2017年7月5日15:31:22
 * 判断2013年是否是闰年
 * 判断闰年条件
 * 1. 非整百年数除以4，无余为闰，有余为平
 * 2. 整百年数除以400，无余为闰有余平
 */
package learn_Java;

public class IsLeapYear {
	public static void main(String[] args) {
		int x = 2013;
		if ((x%4 == 0 && x%100 != 0) || (x%400 == 0)){
			System.out.println("2013年是閏年");
		}
		else{
			System.out.println("2013年是平年");
		}
	}
}
