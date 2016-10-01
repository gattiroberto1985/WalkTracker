/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 $user.name
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 *
 */

package it.bob.apps.android.walktracker.app;

import android.app.Activity;
import android.app.ListActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Project : WalkTracker
 * File    : ${FILE_NAME}
 * <p/>
 * Created by roberto on 21/03/16.
 */
public class TestActivity extends ListActivity implements SensorEventListener2
{

    private SensorManager sm = null;

    private List<String> ssensors = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        this.sm = (SensorManager) this.getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = this.sm.getSensorList(Sensor.TYPE_ALL);
        this.ssensors = new ArrayList<String>(sensors.size());
        for ( Sensor sensor : sensors )
        {
            ssensors.add(sensor.getStringType() + " @@ " + sensor.getName() + " @@ " + sensor.getVendor());
        }
        for ( Sensor sensor : this.sm.getSensorList(Sensor.TYPE_STEP_COUNTER))
            ssensors.add("STEP COUNTER: " + sensor.getStringType() + " @@ " + sensor.getName() + " @@ " + sensor.getVendor());

        for ( Sensor sensor : this.sm.getSensorList(Sensor.TYPE_STEP_DETECTOR))
            ssensors.add("STEP DETECTOR: " + sensor.getStringType() + " @@ " + sensor.getName() + " @@ " + sensor.getVendor());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, ssensors);


        // Assign adapter to ListView
        ( (ListView) this.findViewById(android.R.id.list)).setAdapter(adapter);
    }

    @Override
    public void onFlushCompleted(Sensor sensor) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
