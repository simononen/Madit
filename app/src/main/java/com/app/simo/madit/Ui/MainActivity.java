package com.app.simo.madit.Ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.app.simo.madit.Http.RetrofitBuilder;
import com.app.simo.madit.Interface.Endpoint;
import com.app.simo.madit.Prices.PricesCustomAdapter;
import com.app.simo.madit.Produces.Produce;
import com.app.simo.madit.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements Callback<Produce> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Retrofit retrofit = RetrofitBuilder.build();

        Endpoint endpoint = retrofit.create(Endpoint.class);

        Call<Produce> call = endpoint.listProduces();

        call.enqueue(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onResponse(Call<Produce> call, Response<Produce> response) {
        Produce produce = response.body();
        ListView listView = (ListView) findViewById(R.id.list);
        PricesCustomAdapter pricesCustomAdapter = new PricesCustomAdapter(this, R.layout.price_list_item, produce.getPrices());
        listView.setAdapter(pricesCustomAdapter);
    }

    @Override
    public void onFailure(Call<Produce> call, Throwable t) {
        Toast.makeText(getApplicationContext(), "Failed"+t.getCause(), Toast.LENGTH_LONG).show();

    }
}
