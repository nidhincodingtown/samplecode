package nidhinkumar.testsamples.farmers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import nidhinkumar.testsamples.R;

/**
 * Created by user on 20-08-2016.
 */
public class Newfarmer extends AppCompatActivity{
   Toolbar mtool;
    TextInputLayout tfarmername,tlocation,tmobno,tlanddetails;
    EditText efarmername,elocation,emobno,elanddet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnewtransaction);
        mtool=(Toolbar)findViewById(R.id.toolbar);
        mtool.setTitle("Farmer");
        setSupportActionBar(mtool);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        init();
    }

    private void init() {
        tfarmername=(TextInputLayout)findViewById(R.id.txtinputfarmername);
        tlocation=(TextInputLayout)findViewById(R.id.txtlocation);
        tmobno=(TextInputLayout)findViewById(R.id.txtmobileno);
        tlanddetails=(TextInputLayout)findViewById(R.id.txtlanddetails);
        
    }
}
