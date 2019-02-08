package pers.whe.code.work;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import pers.whe.code.model.TreeNode;

import java.lang.annotation.*;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
@Acess(role = "a")
@Acess(role = "b")
public class Main {
    public static void main(String[] args) {
        Acess[] acesses = Main.class.getAnnotationsByType(Acess.class);
        System.out.println(acesses.length);
    }
}
@Repeatable(Acesses.class)
@Retention(RetentionPolicy.RUNTIME)
@interface Acess {
    String role();
}
@Retention(RetentionPolicy.RUNTIME)
@interface Acesses {
    Acess[] value();
}