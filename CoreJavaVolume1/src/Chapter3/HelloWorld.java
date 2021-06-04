package Chapter3;

public class HelloWorld {
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        System.out.println("We will not use 'Hello,World!'");
        String greeting = "Hello";
        int index = greeting.offsetByCodePoints(0,2); // 返回从startIndex代码点开始，位移cpCount后的码点索引
        int cp = greeting.codePointAt(index); // 返回从给定位置开始的码点
        System.out.println(index);
        System.out.print(cp);
        StringBuilder builder = new StringBuilder();
        builder.append("ch");
        builder.append("str");
        String completedString = builder.toString();
    }
}
