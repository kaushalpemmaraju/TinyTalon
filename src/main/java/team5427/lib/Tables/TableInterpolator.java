package team5427.lib.Tables;

import edu.wpi.first.math.interpolation.Interpolator;
import team5427.lib.detection.tuples.Tuple3Plus;

public class TableInterpolator implements Interpolator<Tuple3Plus<Double, Double, Double>> {

    @Override
    public Tuple3Plus<Double, Double, Double> interpolate(Tuple3Plus<Double, Double, Double> startValue,
            Tuple3Plus<Double, Double, Double> endValue, double t) {
        // TODO Auto-generated method stub
        Double interpolatedDistance = startValue.r+t*(endValue.r-startValue.r);
        Double interpolatedTheta = startValue.t+t*(endValue.t - startValue.t);
        Double interpolatedVelocity = startValue.a+t*(endValue.a - startValue.a);

        return new Tuple3Plus<Double,Double,Double>(interpolatedDistance, interpolatedTheta, interpolatedVelocity)
    }
    
}