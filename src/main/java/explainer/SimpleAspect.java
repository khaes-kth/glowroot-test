package explainer;

import org.apache.commons.io.FileUtils;
import org.glowroot.agent.plugin.api.*;
import org.glowroot.agent.plugin.api.weaving.*;

import java.io.File;
import java.io.IOException;

public class SimpleAspect {

    @Pointcut(className = "explainer.SimpleClass", methodName = "isMoreThan",
            methodParameterTypes = {"java.lang.Integer"}, timerName = "process isMoreThan")
    public static class SimpleAdvice {
        private static final TimerName timer = Agent.getTimerName(SimpleAdvice.class);

        @OnBefore
        public static TraceEntry onBefore(ThreadContext context, @BindParameter Object limit) throws IOException {
            System.out.println(limit.toString());
            return context.startTraceEntry(
                    MessageSupplier.create("process invoice: {}", limit.toString()), timer);
        }

        @OnReturn
        public static void onReturn(@BindTraveler TraceEntry traceEntry) {
            traceEntry.end();
        }

    }
}
