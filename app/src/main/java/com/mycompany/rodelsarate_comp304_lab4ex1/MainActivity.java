package com.mycompany.rodelsarate_comp304_lab4ex1;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String tables[]={"tbl_patient","tbl_test", "tbl_nurse", "tbl_doctor"};

    private static final String tableCreatorString[] = {
            "CREATE TABLE tbl_patient (patient_id INTEGER PRIMARY KEY AUTOINCREMENT , firstname TEXT, lastname TEXT, department TEXT, doctor_id INTEGER, room INTEGER, FOREIGN KEY(doctor_id) REFERENCES tbl_doctor(doctor_id));",
            "CREATE TABLE tbl_test (test_id INTEGER PRIMARY KEY AUTOINCREMENT, patient_id INTEGER, BPL TEXT, BPH TEXT , temperature TEXT, FOREIGN KEY(patient_id) REFERENCES tbl_patient(patient_id));",
            "CREATE TABLE tbl_nurse (nurse_id INTEGER PRIMARY KEY AUTOINCREMENT, firstname TEXT, lastname TEXT, department TEXT);",
            "CREATE TABLE tbl_doctor (doctor_id INTEGER PRIMARY KEY AUTOINCREMENT, firstname TEXT, lastname TEXT, department TEXT);"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DatabaseManager db = new DatabaseManager(this);
        //db.createDatabase(getApplicationContext());

        db.dbInitialize( tables,tableCreatorString);
        final String fields[] = {"patient_id","firstname","lastname", "doctor_id", "department", "room"};
        final ArrayList patient = new ArrayList();
        final String record[] = new String[6];
        // Handle Save button
        final Button btnSavePatientInfo = (Button) findViewById(R.id.savePatientBtn);
        final EditText patientFName = (EditText) findViewById(R.id.patientFName);
        final EditText patientLName = (EditText) findViewById(R.id.patientLName);
        final EditText doctor = (EditText) findViewById(R.id.doctorName);
        final EditText department = (EditText) findViewById(R.id.dept);
        final EditText room = (EditText) findViewById(R.id.room);

        final String dfields[] = {"doctor_id","firstname","lastname", "department"};
        final String drecord[] = new String[4];

        drecord[1] = "doctor1fn";
        drecord[2] = "doctor1ln";
        drecord[3] = "dept1";
        ContentValues values = new ContentValues();

        db.addRecord(values, "tbl_doctor", dfields, drecord);

        btnSavePatientInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


//                patient.add("ROdel");
//                patient.add("Sarate");
//                patient.add(1);
//                patient.add("dept1");
//                patient.add("1");

//                patient.add(patientFName.getText().toString());
//                patient.add(patientLName.getText().toString());
//                patient.add(1);
//                patient.add(department.getText().toString());
//                patient.add(room.getText().toString());
                record[1]= patientFName.getText().toString();
                record[2]=patientLName.getText().toString();
                record[3] = "1";
                record[4] = department.getText().toString();
                record[5] = room.getText().toString();

                Log.d("Name: ", record[1]);
                //populate the row with some values
                ContentValues values = new ContentValues();
                //for (int i=1;i<record.length;i++)
                //values.put(fields[i],record[i]);
                //add the row to the database
                db.addRecord(values, "tbl_patient", fields, record);
            }
        });


    }

//    public void populateDoctor(){
//        final DatabaseManager db = new DatabaseManager(this);
//        //db.createDatabase(getApplicationContext());
//
//        db.dbInitialize( tables,tableCreatorString);
//
//
//
//
//    }
}