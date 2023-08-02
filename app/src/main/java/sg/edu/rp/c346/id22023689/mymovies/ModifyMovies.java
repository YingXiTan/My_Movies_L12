package sg.edu.rp.c346.id22023689.mymovies;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ModifyMovies extends AppCompatActivity {
    TextView tvTitle;
    TextView tvGenre;
    TextView tvYear;

    EditText edTitle;
    EditText edGenre;
    EditText edYear;

    Spinner spinRating;
    String spinValue;

    Button btnUpdate;
    Button btnDelete;
    Button btnCancel;

    Movies data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_movies);

        tvTitle.findViewById(R.id.tvTitle);
        tvGenre.findViewById(R.id.tvGenre);
        tvYear.findViewById(R.id.tvYear);

        edTitle.findViewById(R.id.edTitle);
        edGenre.findViewById(R.id.edGenre);
        edYear.findViewById(R.id.edYear);

        spinRating.findViewById(R.id.spinRating);

        btnUpdate.findViewById(R.id.btnUpdate);
        btnDelete.findViewById(R.id.btnDelete);
        btnCancel.findViewById(R.id.btnCancel);

        Intent intent = getIntent();
        data = (Movies) intent.getSerializableExtra("data");

        edTitle.setText(String.valueOf(data.getTitle()));
        edGenre.setText(String.valueOf(data.getGenre()));
        edYear.setText(String.valueOf(data.getYear()));

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHelper = new DBHelper(ModifyMovies.this);
                data.setTitle(edTitle.getText().toString());
                data.setGenre(edGenre.getText().toString());
                data.setYear(Integer.valueOf(edYear.getText().toString()));
                data.setRating(spinValue);
                dbHelper.updateMovies(data);
                dbHelper.close();
                finish();

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(ModifyMovies.this);

                myBuilder.setTitle("Danger");
                myBuilder.setMessage("Are you sure you want to delete the movie\n" +data.getTitle());
                myBuilder.setCancelable(false);
                myBuilder.setNeutralButton("CANCEL", null);
                myBuilder.setNegativeButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DBHelper dbHelper = new DBHelper(ModifyMovies.this);
                        dbHelper.deleteMovies(data.getId());
                        finish();
                    }
        });


                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder myBuilder = new AlertDialog.Builder(ModifyMovies.this);
                        myBuilder.setTitle("Danger");
                        myBuilder.setMessage("Are you sure you want discard the changes");
                        myBuilder.setCancelable(false);
                        myBuilder.setNeutralButton("DO NOT DISCARD",null);

                        myBuilder.setNegativeButton("DISCARD", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                        AlertDialog myDialog = myBuilder.create();
                        myDialog.show();
                    }
                });

        spinRating.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        spinValue = "G";
                        break;
                    case 1:
                        spinValue = "M18";
                        break;
                    case 2:
                        spinValue = "NC16";
                        break;
                    case 3:
                        spinValue = "PG";
                        break;
                    case 4:
                        spinValue = "PG13";
                        break;
                    case 5:
                        spinValue = "R21";
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }
}