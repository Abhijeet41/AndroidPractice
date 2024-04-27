package com.abhi41.demoproject.widget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.abhi41.demoproject.R;
import com.abhi41.demoproject.databinding.ActivityDateTimePickerBinding;
import com.abhi41.demoproject.fragment.DatePickerFragment;
import com.abhi41.demoproject.fragment.TimePickerFragment;

public class DateTimePicker extends AppCompatActivity {
    private ActivityDateTimePickerBinding binding;
    String selectedCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDateTimePickerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new DatePickerFragment();
                dialogFragment.show(getSupportFragmentManager(), "Pick A Date");
            }
        });

        binding.btnTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new TimePickerFragment();
                dialogFragment.show(getSupportFragmentManager(), "Pick A Time");
            }
        });

        spinnerExample();
        progressBarExample();
    }

    private void progressBarExample() {
        //binding.progressBar.setProgress(75);

        binding.btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   binding.progressBar.incrementProgressBy(10);
                Handler handler = new Handler();
                for (int i = 1; i <= 10; i++) { // Loop from 1 to 10
                    final int progressStep = i * 10;
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            binding.progressBar.setProgress(progressStep); // Set progress directly
                            // yourMethod(); // Call any additional methods if needed
                        }
                    }, i * 1000); // Increasing delay for sequential execution
                }

            }
        });
    }

    private void spinnerExample() {
        String[] course = {"C++", "Java", "Kotlin", "DevOps"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, course);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spnCourse.setAdapter(adapter);
        binding.spnCourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCourse = course[position];
                Toast.makeText(DateTimePicker.this, "You Selected: " + course[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}