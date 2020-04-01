package fr.uvsq._1;

import java.time.LocalDate;

import fr.uvsq._1.Personnel.builder;

public class test {

    public static void main(String[] args) {
        builder b = new builder("bow","ser",LocalDate.of(1, 1, 1));
        b.setfonction("roi");
        b.settelephone("0000000000");
        Personnel p = b.build();
        System.out.println(p.toString());
    }
}
