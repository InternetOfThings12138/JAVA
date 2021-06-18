public class OFFER05 {
    public String replaceSpace(String s) {
        int length = s.length();
        int count = 0;
        char[] charArray = s.toCharArray();
        for(char c:charArray){
            if(c==' '){count++;}
        }
        char[] array = new char[length + count*2];
        int indexOfOld = length-1;
        int indexOfNew = array.length-1;
        System.out.println(s.charAt(0));
        while(indexOfOld>=0 && indexOfNew>indexOfOld){
            char c = s.charAt(indexOfOld);
            System.out.println(c);
            if(c==' '){
                array[indexOfNew--] = '0';
                array[indexOfNew--] = '2';
                array[indexOfNew--] = '%';
                System.out.println(indexOfNew);
                System.out.println("1--------");
            }
            else{
                System.out.println(indexOfNew);
                System.out.println("2--------");
                array[indexOfNew--] = c;
            }
            indexOfOld--;
            System.out.println(indexOfOld);
            System.out.println("3--------");
        }

        String newStr = new String(array);
        return newStr;
    }
    public static void main(String[]args) {
        String str = new String(" We are happy.");
        System.out.println(new OFFER05().replaceSpace(str));
    }
}