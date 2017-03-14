public class Array
{
	public static void main (String[] args)
	{
		System.out.println("Darray:");

		//int[] a;    //定义数组
		//int[] b; 

		//在声明数组时，数组所需的空间并没有真正分配给数组。我可以在声明的同时，用new来创建数组所需空间：
		int[] a = new int[100];

		//我还可以在声明的同时，给数组赋值。数组的大小也同时确定：
		int[] b = new int[] {1, 3, 5, 7, 9};

		System.out.println(a);//print an integer
		System.out.println(b);
	}
}