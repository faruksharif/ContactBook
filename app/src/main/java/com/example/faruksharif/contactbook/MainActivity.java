package com.example.faruksharif.contactbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSave,btnView,btnUpdate,btnDelete;

    EditText txtID,txtName,txtCell;
    MySqliteDB myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave=findViewById(R.id.btn_save);
        btnView=findViewById(R.id.btn_view);
        btnUpdate=findViewById(R.id.btn_update);
        btnDelete=findViewById(R.id.btn_delete);


        txtID=findViewById(R.id.txt_id);
        txtName=findViewById(R.id.txt_name);
        txtCell=findViewById(R.id.txt_cell);

        myDB=new MySqliteDB(MainActivity.this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=txtID.getText().toString();
                String name=txtName.getText().toString();
                String cell=txtCell.getText().toString();

                if (id.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"ID can't be empty!", Toast.LENGTH_SHORT);
                }
                else if (name.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Name can't be empty!", Toast.LENGTH_SHORT);
                }
                else if(cell.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"cell can't be empty!", Toast.LENGTH_SHORT);
                }
                else
                {
                    boolean check= myDB.addToTable(id,name,cell);
                    if(check==true)
                    {
                        Toast.makeText(MainActivity.this,"Data saved", Toast.LENGTH_SHORT);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Data not saved", Toast.LENGTH_SHORT);
                    }

                }

            }
        });

    }
}
