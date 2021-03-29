package ru.job4j.gc.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

public class JmhArticle {

    @State(Scope.Thread)
    public static class MyState {
        public String origin = "Мой дядя самых честных правил, "
                + "Когда не в шутку занемог, "
                + "Он уважать себя заставил "
                + "И лучше выдумать не мог. "
                + "Его пример другим наука; "
                + "Но, боже мой, какая скука "
                + "С больным сидеть и день и ночь, "
                + "Не отходя ни шагу прочь! "
                + "Какое низкое коварство "
                + "Полуживого забавлять, "
                + "Ему подушки поправлять, "
                + "Печально подносить лекарство, "
                + "Вздыхать и думать про себя: "
                + "Когда же черт возьмет тебя!";
        public String line = "Мой дядя мог думать про тебя и день и ночь";
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void testGenerate(MyState state, Blackhole blackhole) {
        blackhole.consume(Article.generateBy(state.origin, state.line));
    }
}
