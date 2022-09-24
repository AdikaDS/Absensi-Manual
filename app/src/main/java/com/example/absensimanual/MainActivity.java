package com.example.absensimanual;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String spinnerText;
    EditText datePicker, timePicker, deskripsi;
    Spinner spinner;
    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.tanggal);
        timePicker = findViewById(R.id.waktu);
        deskripsi = findViewById(R.id.keterangan);
        spinner = findViewById(R.id.presensi);
        confirm = findViewById(R.id.submit);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        if (spinner != null) {
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if (i == 0){
                        deskripsi.setVisibility(View.INVISIBLE);
                    } else {
                        deskripsi.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });

        timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePicker();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(datePicker.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Kolom Masukkan tanggal tidak boleh kosong !",
                    Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(timePicker.getText().toString())) {
                        Toast.makeText(MainActivity.this, "Kolom Masukkan waktu tidak boleh kosong !",
                                Toast.LENGTH_SHORT).show();
                }
                else {
                    showAlertDialog();
                }

            }
        });
    }

    public void showAlertDialog () {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
        alertBuilder.setTitle("Konfirmasi");
        alertBuilder.setMessage("Apakah kamu yakin data yang akan kamu kirim sudah sesuai ?");

        alertBuilder.setPositiveButton("Ya",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Absen Berhasil", Toast.LENGTH_SHORT).show();
                datePicker.getText().clear();
                timePicker.getText().clear();
                spinner.setSelection(0);
                deskripsi.getText().clear();
            }
        });

        alertBuilder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                
            }
        });
        alertBuilder.show();

    }
    public void showDatePicker() {
        DialogFragment dateFragment = new DatePickerFragment();
        dateFragment.show(getSupportFragmentManager(), "date-picker");
    }

    public void processDatePickerResult(int day, int month, int year) {

        String dayString = Integer.toString(day);
        String monthString = Integer.toString(month + 1);
        String yearString = Integer.toString(year);

        String dateMessage = dayString + "-" + monthString + "-" + yearString;
        datePicker.setText(dateMessage);
    }

    public void showTimePicker() {
        DialogFragment timeFragment = new TimePickerFragment();
        timeFragment.show(getSupportFragmentManager(), "time-picker");
    }

    public void processTimePickerResult(int hour, int minute) {

        String hourString = Integer.toString(hour);
        String minuteString = Integer.toString(minute);

        String timeMessage = hourString + " : " + minuteString;
        timePicker.setText(timeMessage);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        spinnerText = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}