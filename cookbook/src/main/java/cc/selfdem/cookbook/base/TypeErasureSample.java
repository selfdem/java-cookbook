package cc.selfdem.cookbook.base;

import java.util.List;

/**
 *  类型擦除
 *  这两个函数在编译阶段不会通过
 */
public class TypeErasureSample {

//    public void method(List<String> list){
//        System.out.println("List String");
//    }
    public void method(List<Integer> list){
        System.out.println("List Int");
    }
}
