package Chapter3;
import java.io.Console;
import java.util.*;

public class InOut {
    public static void main(String[] args){
        /*
        Scanner in = new Scanner(System.in);//构造一个Scanner对象，与“标准输入流”System.in关联
        System.out.println("What`s your name?");
        String name = in.nextLine();//输入可能包含空格
        System.out.println("What`s your first name?");
        String firstName = in.next(); //读取一个单词（以空白符作为分隔符）
        System.out.println("How old are you");
        int age = in.nextInt(); //调用整数
        System.out.println("hello,"+firstName+name+".Next year,you`ll be "+(age+1));

//        Console cons =System.console();
//        String username =cons.readLine("User name:");
//        char[] passwd = cons.readPassword("Password:");

         */
        //格式化输出  page 58
        double x = 10000.0/3.0;
        System.out.println(x);
        System.out.printf("%n %8.2f",x);
        System.out.printf("%n %tc",new Date()); //t开始，表格中任意结束
        System.out.printf("%n %1$s %2$tB %2$te %2$tY","Due date:", new Date());  // %+被格式化的参数索引+$
        System.out.printf("%n %s %tB %<te %<tY","Due date:",new Date());

    }
}
