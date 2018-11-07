package com.naharoo;

import com.naharoo.domain.A;
import com.naharoo.domain.B;

public class Main {

    public static void main(String[] args) throws Exception {
        A a = new A();
        a.setAge(20);
        a.setFirstName("Valodik");
        a.setLastName("Valodikyan");

        B b = Mapper.map(a, B.class);

        System.out.println(b);
    }
}
