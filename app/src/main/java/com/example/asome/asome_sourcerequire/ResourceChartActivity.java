package com.example.asome.asome_sourcerequire;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.anychart.anychart.AnyChart;
import com.anychart.anychart.AnyChartView;
import com.anychart.anychart.Availability;
import com.anychart.anychart.AvailabilityPeriod;
import com.anychart.anychart.DataEntry;
import com.anychart.anychart.Resource;
import com.anychart.anychart.TimeTrackingMode;

import java.util.ArrayList;
import java.util.List;

public class ResourceChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_common);

        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        anyChartView.setProgressBar(findViewById(R.id.progress_bar));

        Resource resource = AnyChart.resource();

        resource.setZoomLevel(1d)
                .setTimeTrackingMode(TimeTrackingMode.ACTIVITY_PER_CHART)
                .setCurrentStartDate("2016-09-30");

        resource.setResourceListWidth(120);

        resource.getCalendar().setAvailabilities(new Availability[] {
                new Availability(AvailabilityPeriod.DAY, (Double) null, 10d, (Double) null, (Double) null, 18d, true),
                new Availability(AvailabilityPeriod.DAY, (Double) null, 14d, (Double) null, (Double) null, 15d, false),
                new Availability(AvailabilityPeriod.WEEK, (Double) null, (Double) null, 5d, (Double) null, 18d, false),
                new Availability(AvailabilityPeriod.WEEK, (Double) null, (Double) null, 6d, (Double) null, 18d, false)
        });

        List<DataEntry> data = new ArrayList<>();

        data.add(new ResourceDataEntry(
                "이경연",
                "개발자",
                "http://cdn.anychart.com/images/resource-chart/developer-romario.png",
                new Activity[]{
                        new Activity(
                                "Gantt timeline",
                                new Interval[]{
                                        new Interval("2016-10-01", "2016-10-11", 120)
                                },
                                "#62BEC1"),
                        new Activity(
                                "Gantt Connectors events/removal + UI customization",
                                new Interval[]{
                                        new Interval("2016-10-01", "2016-10-04", 180)
                                },
                                "#62BEC1"),
                        new Activity(
                                "Chart Facebook sharing",
                                new Interval[]{
                                        new Interval("2016-10-01", "2016-10-04", 120)
                                },
                                "#62BEC1"),
                        new Activity(
                                "Chart animation problems",
                                new Interval[]{
                                        new Interval("2016-10-05", "2016-10-09", 300)
                                },
                                "#62BEC1"),
                        new Activity(
                                "iPad touch problems",
                                new Interval[]{
                                        new Interval("2016-10-12", "2016-10-16", 300),
                                        new Interval("2016-10-17", "2016-10-21", 60)
                                },
                                "#62BEC1"),
                        new Activity(
                                "Some improvements for chart labels",
                                new Interval[]{
                                        new Interval("2016-10-17", "2016-10-22", 240),
                                        new Interval("2016-10-22", "2016-10-26", 240)
                                },
                                "#62BEC1")
                }));
        data.add(new ResourceDataEntry(
                "김연지",
                "디자인",
                "http://cdn.anychart.com/images/resource-chart/developer-antonio.png",
                new Activity[]{
                        new Activity(
                                "Gantt resource list",
                                new Interval[]{
                                        new Interval("2016-09-25", "2016-10-01", 120)
                                },
                                "#EA526F"),
                        new Activity(
                                "Pareto Chart",
                                new Interval[]{
                                        new Interval("2016-09-25", "2016-10-05", 240)
                                },
                                "#EA526F"),
                        new Activity(
                                "Chart bug fixes",
                                new Interval[]{
                                        new Interval("2016-10-08", "2016-10-25", 180)
                                },
                                "#EA526F"),
                        new Activity(
                                "Chart legend",
                                new Interval[]{
                                        new Interval("2016-10-06", "2016-10-12", 120)
                                },
                                "#EA526F")
                }));
        data.add(new ResourceDataEntry(
                "조윤영",
                "기획자",
                "http://cdn.anychart.com/images/resource-chart/developer-alejandro.png",
                new Activity[]{
                        new Activity(
                                "Pie chart improvement",
                                new Interval[]{
                                        new Interval("2016-09-25", "2016-10-02", 120)
                                },
                                "#8789C0"),
                        new Activity(
                                "Pie chart labels problems",
                                new Interval[]{
                                        new Interval("2016-10-05", "2016-11-01", 120)
                                },
                                "#8789C0"),
                        new Activity(
                                "Stock chart minor bugs",
                                new Interval[]{
                                        new Interval("2016-10-01", "2016-10-10", 120)
                                },
                                "#8789C0"),
                        new Activity(
                                "Chart minor bug fixes",
                                new Interval[]{
                                        new Interval("2016-10-20", "2016-11-05", 120)
                                },
                                "#8789C0")
                }));
        data.add(new ResourceDataEntry(
                "황은선",
                "개발자",
                "http://cdn.anychart.com/images/resource-chart/developer-sergio.png",
                new Activity[]{
                        new Activity(
                                "Gantt logo",
                                new Interval[]{
                                        new Interval("2016-09-30", "2016-10-03", 300)
                                },
                                "#E06D06"),
                        new Activity(
                                "Tooltip bug fix",
                                new Interval[]{
                                        new Interval("2016-10-04", "2016-10-10", 300)
                                },
                                "#E06D06"),
                        new Activity(
                                "Chart label",
                                new Interval[]{
                                        new Interval("2016-10-11", "2016-10-15", 300)
                                },
                                "#E06D06"),
                        new Activity(
                                "Map series labels improvement",
                                new Interval[]{
                                        new Interval("2016-10-16", "2016-11-03", 300)
                                },
                                "#E06D06")
                }));

        resource.setData(data);

        anyChartView.setChart(resource);
    }

    private class ResourceDataEntry extends DataEntry {
        ResourceDataEntry(String name, String description, String image, Activity[] activities) {
            setValue("name", name);
            setValue("description", description);
            setValue("image", image);
            setValue("activities", activities);
        }
    }

    private class Activity extends DataEntry {
        Activity(String name, Interval[] intervals, String fill) {
            setValue("name", name);
            setValue("intervals", intervals);
            setValue("fill", fill);
        }
    }

    private class Interval extends DataEntry {
        Interval(String start, String end, Integer minutesPerDay) {
            setValue("start", start);
            setValue("end", end);
            setValue("minutesPerDay", minutesPerDay);
        }
    }

}