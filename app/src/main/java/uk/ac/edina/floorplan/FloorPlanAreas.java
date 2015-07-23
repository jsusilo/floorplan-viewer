package uk.ac.edina.floorplan;

import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by murrayking on 22/07/2015.
 */
public class FloorPlanAreas {
    private static List<Area> areas;

    public static synchronized List<Area> getAreas(Resources resources){
        if(areas != null){

            return areas;
        } else {

            areas = new LinkedList<>();
            String[] titles = resources.getStringArray(R.array.titles);
            String[] descriptions = resources.getStringArray(R.array.descriptions);

            String[] locations = resources.getStringArray(R.array.locations);
            TypedArray icons = resources.obtainTypedArray(R.array.route_list_icons);


            for (int i = 0; i < titles.length; i++) {
                areas.add(new Area(titles[i], icons.getResourceId(i, -1), descriptions[i], locations[i]));
            }
        }

        return areas;


    }
}

