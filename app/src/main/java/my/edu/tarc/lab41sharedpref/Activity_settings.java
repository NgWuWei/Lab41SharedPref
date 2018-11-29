package my.edu.tarc.lab41sharedpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Activity_settings extends AppCompatActivity {

    private static final String PREF_FILE = "my.edu.tarc.lab41sharedpref;";

    private EditText editTextName;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private ImageView imageViewProfile;
    private SharedPreferences sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        editTextName = findViewById(R.id.editTextName);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        imageViewProfile = findViewById(R.id.imageViewProfile);
        sharedPreference = getSharedPreferences(PREF_FILE, MODE_PRIVATE);
    }

    @Override
    protected void onResume(){
        super.onResume();
        String name;
        int gender;
        name = sharedPreference.getString(getString(R.string.user_name), getString(R.string.user_name),getString(R.string.no_name));

        gender = sharedPreference.getInt(getString(R.string.user_gender), defValue:-1);

        editTextName.setText(name);
        if(gender == 1){
            radioButtonMale.setChcked(true);
            imageViewProfile.setImageResource(R.drawable.male);
        }
        else if(gender == 2 ){
            radioButtonFemale.setChecked(true);
            imageViewProfile.setImageResource(R.drawable.female);
        }
        else{
            imageViewProfile.setImageResource((R.drawabe.profile);
        }
    }

    @Override
    protected void onPause() {

        super.onPause();

        SharedPreferences.Editor editor = sharedPreference.edit();

        String name;
        int gender;
        name = editTextName.getText().toString();
        editor.putString("user_name", name);

            gender = radioGroupGender.getCheckedRadioButtonId();
            if(gender == R.id.radioButtonMale){
                editor.putInt("user_gender", 1);
            }else if(gender == R.id.radioButtonFemale){
                editor.putInt("user_gender",0);
            }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.action_settings){
            Intent intent = new Intent(packageContext: this, SettingsAcivity.class);
            startAcvitivity(intent);
            return true;
        }
    }
}
