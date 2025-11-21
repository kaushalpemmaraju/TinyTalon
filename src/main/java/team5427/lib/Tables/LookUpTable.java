package team5427.lib.Tables;

import edu.wpi.first.math.interpolation.InterpolatingDoubleTreeMap;
import edu.wpi.first.math.interpolation.InterpolatingTreeMap;
import edu.wpi.first.math.interpolation.Interpolator;
import edu.wpi.first.math.interpolation.InverseInterpolator;
import team5427.lib.detection.tuples.Tuple3Plus;

public class LookUpTable {
    public InterpolatingTreeMap<Double, Tuple3Plus<Double, Double, Double>> lookup;
    public LookUpTable(){
        lookup = new InterpolatingTreeMap<>(new TableInverseInterpolator(), new TableInterpolator())
    }
   

    public void addItem(Double distance, Tuple3Plus<Double,Double,Double>values){
        lookup.put(distance,values);
    }

    public Tuple3Plus<Double,Double,Double> valuesAtDistance(double distance){
        return lookup.get(distance);
    }

}
