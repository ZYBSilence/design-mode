package demo;

/**
 * @description:
 * @author: zyb
 * @date: 2023/8/10 15:44
 */
public class OOMExample {

    public static void recursiveMethod() {
        recursiveMethod();
    }

    public static void main(String[] args) {
        // 栈溢出测试
        recursiveMethod();


    }

}
