package sg.edu.rp.c346.id22023689.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvGenre;
    TextView tvYear;

    EditText edTitle;
    EditText edGenre;
    EditText edYear;

    Spinner spinRating;
    String spinValue;

    Button btnInsert;
    Button btnShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle.findViewById(R.id.tvTitle);
        tvGenre.findViewById(R.id.tvGenre);
        tvYear.findViewById(R.id.tvYear);

        edTitle.findViewById(R.id.edTitle);
        edGenre.findViewById(R.id.edGenre);
        edYear.findViewById(R.id.edYear);

        spinRating.findViewById(R.id.spinRating);

        btnInsert.findViewById(R.id.btnInsert);
        btnShowList.findViewById(R.id.btnShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MoviesList.class);

                startActivity(intent);
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