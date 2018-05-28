package com.dasturlash.redbook.details;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.dasturlash.redbook.R;
import com.dasturlash.redbook.models.AnimalDbModel;
import com.dasturlash.redbook.room.AnimalDao;
import com.dasturlash.redbook.room.AnimalDatabase;

public class AnimalDetailActivity extends AppCompatActivity implements AnimalDetailsView {
    public static final String ANIMAL_ID = "animalId";

    private AnimalDetailsPresenter presenter;
    private MenuItem menuItem;
    private int animalId;
    private ImageView image;
    private TextView nameText;
    private TextView statusText;
    private TextView propagationText;
    private TextView habitatText;
    private TextView quantityText;
    private TextView lifestyleText;
    private TextView limitingFactorsText;
    private TextView increaseText;
    private TextView securityText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        image = findViewById(R.id.detail_image);
        nameText = findViewById(R.id.detail_name);
        statusText = findViewById(R.id.detail_status_content);
        propagationText = findViewById(R.id.detail_propagation_content);
        habitatText = findViewById(R.id.detail_habitat_content);
        quantityText = findViewById(R.id.detail_quantity_content);
        lifestyleText = findViewById(R.id.detail_lifestyle_content);
        limitingFactorsText = findViewById(R.id.detail_limiting_factories_content);
        increaseText = findViewById(R.id.detail_increasing_content);
        securityText = findViewById(R.id.detail_security_content);


        Toolbar toolbar = findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("");
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        AnimalDao animalDao = AnimalDatabase.getAnimalDatabase(this).animalDao();
        int animalId = getIntent().getIntExtra(ANIMAL_ID, 0);

        presenter = new AnimalDetailsPresenter(this, animalDao);
        presenter.getAnimalDetails(animalId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail, menu);
        menuItem = menu.findItem(R.id.menu_favourite);
        presenter.setFavoriteStatus();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setAnimalDetail(AnimalDbModel model) {
        nameText.setText(model.getName_uz());
        statusText.setText(model.getStatus());
        propagationText.setText(model.getPropagation());
        habitatText.setText(model.getHabibat());
        quantityText.setText(model.getNumerical());
        lifestyleText.setText(model.getLifestyle());
        limitingFactorsText.setText(model.getLimiting());
        increaseText.setText(model.getBreeding());
        securityText.setText(model.getSecurity());
    }

    @Override
    public void setFavoriteIcon(int resId) {
        menuItem.setIcon(resId);
    }
}
