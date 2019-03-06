package com.mamadou.diallo.healthapp.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mamadou.diallo.healthapp.R;
import com.mamadou.diallo.healthapp.model.Disponibilite;
import com.mamadou.diallo.healthapp.model.DisponibiliteHelper;
import com.mamadou.diallo.healthapp.model.Medecin;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidationRDVActivity extends AppCompatActivity {

    private TextView mMedecinTxt;
    private TextView mSpecialiteTxt;
    private TextView mMotifTxt;
    private TextView mDateTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation_rdv);

        mMedecinTxt = (TextView) findViewById(R.id.activity_validation_rdv_medecin_txt);
        mSpecialiteTxt = (TextView) findViewById(R.id.activity_validation_rdv_specialite_txt);
        mMotifTxt = (TextView) findViewById(R.id.activity_validation_rdv_motif_txt);
        mDateTxt = (TextView) findViewById(R.id.activity_validation_rdv_date_txt);


        Long date = getIntent().getExtras().getLong("dateValue");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        DisponibiliteHelper disponibiliteHelper= new DisponibiliteHelper(this.getApplicationContext());

        Intent intent = new Intent(getApplicationContext(), ValidationRDVActivity.class);

        Medecin medecin = Medecin.getMedecin(getIntent().getExtras().getInt("medecin"));
        int dispoId =getIntent().getExtras().getInt("idDisponibilite");
        Date dateDisponibilite = new Date(getIntent().getExtras().getLong("dateValue"));
        intent.putExtra("dateValue", date);

        String strMedecin = medecin.getPrenomMedecin()+" "+medecin.getNomMedecin();
        String strSpecialite = medecin.getSpecialiteMedecin().getLibelleSpecialite();
        String strMotif = "Mal de coeur";
        String strDate = dateFormat.format(date);

        mMedecinTxt.setText("Medecin : "+ strMedecin);
        mSpecialiteTxt.setText("Spécialité : "+ strSpecialite);
        mMotifTxt.setText("Motif : "+ strMotif);
        mDateTxt.setText("Date : "+ strDate);









    }


    @Override
    protected void onRestart() {
        super.onRestart();  // Always call the superclass method first
        recreate();
    }

    private void language_setting(){
        Intent intent = new Intent(getApplicationContext(),SettingLanguageActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        getMenuInflater().inflate(R.menu.menu_app, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_language:
                language_setting();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //disponibiliteHelper.ajouterDisponibilite(new Date(),1);

    //disponibiliteHelper.ajouterDisponibilite(new Date(),1);
    //disponibiliteHelper.ajouterDisponibilite(new Date(),1);
    //disponibiliteHelper.ajouterDisponibilite(new Date(),3);

    //disponibiliteHelper.prendreRendezVous(1,1); ici le second parametre correspond à l'identifiant de l'utilisateur connecté

    // Toast.makeText(getApplicationContext(), ""+disponibiliteHelper.getAllDisponibilite().get(0).getUtilisateur().getId(),Toast.LENGTH_LONG).show();


    //for(Disponibilite disponibilite :disponibiliteHelper.getNextUserDisponibilite(1)) pour avoir la liste des prochains rdv de l'utilisateur


    // for(Disponibilite disponibilite :disponibiliteHelper.getPreviousUserDisponibilite(1)) pour avoir la liste des precedent rdv de l'utilisateur

}