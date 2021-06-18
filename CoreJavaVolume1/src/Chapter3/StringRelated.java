package Chapter3;

public class StringRelated {
    public static void main(String[] args){
        StringBuilder builder = new StringBuilder();
        builder.append("ch");
        builder.append("str");
        System.out.println(String.format("original string: %s",builder));

        String completedString = builder.toString();
        System.out.println(completedString);

        builder.setCharAt(0,'b');
        System.out.println(String.format("change 0 into 'b': %s",builder));

        builder.insert(1,"c");
        System.out.println(String.format("insert 'c' in position 1: %s",builder));

        builder.delete(1,3);
        System.out.println(String.format("delete range(1,3): %s",builder));
    }

}
