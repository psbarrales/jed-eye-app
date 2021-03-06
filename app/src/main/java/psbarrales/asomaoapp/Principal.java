package psbarrales.asomaoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;


public class Principal extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null && bundle.getString("LAUNCH") != null) {
            if(bundle.getString("LAUNCH").equals("YES")) {
                startService(new Intent(Principal.this, Asomao.class));
            }
        }

        Button launch = (Button)findViewById(R.id.button1);
        launch.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startService(new Intent(Principal.this, Asomao.class));
            }
        });

        Button stop = (Button)findViewById(R.id.button2);
        stop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                stopService(new Intent(Principal.this, Asomao.class));
            }
        });

    }

    @Override
    protected void onResume() {
        Bundle bundle = getIntent().getExtras();

        if(bundle != null && bundle.getString("LAUNCH") != null) {
            if(bundle.getString("LAUNCH").equals("YES")) {
                startService(new Intent(Principal.this, Asomao.class));
            }
        }
        super.onResume();
    }
}
