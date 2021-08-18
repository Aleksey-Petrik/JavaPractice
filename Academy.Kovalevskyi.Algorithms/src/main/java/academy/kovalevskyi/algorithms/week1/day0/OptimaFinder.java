package academy.kovalevskyi.algorithms.week1.day0;

import java.util.function.Function;

public class OptimaFinder {

  public static double findOptima(Function<Double, Double> f, double start,
                                  double end, double precision) {
    double cpu = 0;
    while (start <= end) {
      cpu = (end + start) / 2;
      double left = f.apply(cpu - precision);
      double right = f.apply(cpu + precision);
      double current = f.apply(cpu);
      if (left > current && current < right) {
        return cpu;
      } else if (current > right) {
        start = cpu + precision;
      } else if (current > left) {
        end = cpu - precision;
      }
    }
    return cpu;
  }

}
