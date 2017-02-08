package info.duhovniy.mathclasses.commons;


import info.duhovniy.mathclasses.dto.Expression;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


public class MathUtils {

    // TODO: alternative rounding implementation - could be replaced with org.apache.commons.math.util.MathUtils.round
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static List<String> evaluateExpressionToList(Expression ex) {

        if (ex.getRank() != 0)
            return ex.getBody().stream()
                    .map(s -> s.matches("[0-9.]*") ? String.valueOf(round(ThreadLocalRandom.current()
                            .nextDouble(ex.getMin(), ex.getMax()), ex.getRank())) : s)
                    .collect(Collectors.toList());
        else
            return ex.getBody().stream()
                    .map(s -> s.matches("[0-9.]*") ? String.valueOf(ThreadLocalRandom.current()
                            .nextInt(ex.getMin(), ex.getMax())) : s)
                    .collect(Collectors.toList());
    }
}
