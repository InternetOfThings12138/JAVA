package Chapter2;

public class Welcome{
    /*
        可以在命令行中直接运行：Welcome.java
            javac -encoding UTF-8 Welcome.java
            java Welcome  // 指定类名即可
        原理：javac是一个Java编译器。将文件Welcome.java编译成Welcome.class
        java程序启动java虚拟机。虚拟机执行编译器放在class文件中的字节码。
     */
    public static void main(String[] args){
        String greeting= "Welcome to Core Java!";
        System.out.println(greeting);
        for(int i =0;i<greeting.length();i++){
            System.out.print("=");}
        System.out.println();
    }
    /*
    可能bug：
        1.javac 报告错误无法找到Welcome.java 检查目录中文件
        2.Bad command or file name Or javac:command not found 安装路径问题
        3.java.lang.NoClassDefFoundError 检查出问题的类的名字   Java区分大小写
        4.java 错误：找不到或无法加载主类 (路径有误)
            D:\learn\JAVA\CoreJavaVolume1\src>java Chapter3.HelloWorld

    */
}
