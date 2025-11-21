package team5427.lib.Tables;

import edu.wpi.first.math.interpolation.InterpolatingTreeMap;
import edu.wpi.first.math.interpolation.InverseInterpolator;
import team5427.lib.detection.tuples.Tuple2Plus;
import team5427.lib.detection.tuples.Tuple3Plus;

public class TableInverseInterpolator implements InverseInterpolator<Double> {
    // InterpolatingTreeMap<Double, Tuple3Plus<Double, Double, Double>> lookup;
    // public TableInverseInterpolator(InterpolatingTreeMap<Double, Tuple3Plus<Double, Double, Double>> lookup){
    //     this.lookup=lookup;
    // }

    @Override
    public double inverseInterpolate(Double startValue, Double endValue, Double q) {
        if(endValue.equals(startValue)){
            return 0.0;
        }
        return (q-startValue) / (endValue - startValue);
    }

    // public Tuple2Plus<Double, Double> getValuesInBetween(Double q){
    //     Double startValue = 0.0;
    //     Double endValue = 0.0;
    //     LookUpTable.getInverseInterpolator()
    //     for(int i = 0;i<lo

    // }
   
}
