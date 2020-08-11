package pooja.borkar.favapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
FloatingActionButton floatingActionButton;
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     floatingActionButton=findViewById(R.id.fabbutton);
     toolbar=findViewById((R.id.toolbar));
     setSupportActionBar(toolbar);
     floatingActionButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             displaycreatecategorydialog();

         }
     });

    }

    private void displaycreatecategorydialog() {
        final EditText itemEditText=new EditText(this);
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("Enter the item name Here:");
        alertDialog.setView(itemEditText);
        alertDialog.setPositiveButton("Create", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String item=itemEditText.getText().toString();
               System.out.println(item);
                dialogInterface.dismiss();
            }
        });
        alertDialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.ActionSetting:
                startActivity(new Intent(Settings.ACTION_SETTINGS));

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}



