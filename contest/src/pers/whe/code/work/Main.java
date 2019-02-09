package pers.whe.code.work;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import pers.whe.code.model.TreeNode;

import java.lang.annotation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2019,2,28);
        LocalDate localDate1 = localDate.plusDays(1);
        System.out.println(localDate1); // 2019-03-01
    }
}
