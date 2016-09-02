package nidhinkumar.testsamples.othercharges;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

import nidhinkumar.testsamples.R;

/**
 * Created by user on 18-08-2016.
 */
public class Sampleexpenses extends AppCompatActivity {
    String ADD_TAg = "sampleexpense";
    ImageButton ptreeminus, ptreeplus, pcostpertreeminus, pcostpertreeplus,
            dcoconutminus, dcoconutplus, dcostpercoconutminus, dcostpercoconutplus,
            lnoofloadsminus, lnoofloadplus, lcostperloadminus, lcostperloadplus;
    EditText edtnotree, edtcostpertree, edthuskcoconutno, edthuskcostpercoconut, edtloadno, edtloadcost;
    TextView pluckertotal, huskertotal, loadingtotal, totalgrand;
    int treenumbers, loadnumbers = 0;
    int costpertree, costperload = 0;
    int coconutnumbers, costpercoconut;
    int i = 1;

    int treeno, treecostno;
    float sptotal, htotal, ltotal, gtotal;
    Toolbar mtool;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sampleexpenses);
        mtool = (Toolbar) findViewById(R.id.toolbar);
        mtool.setTitle("Expense");
        setSupportActionBar(mtool);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        init();

    }

    private void init() {
        ptreeminus = (ImageButton) findViewById(R.id.treeminus);
        ptreeplus = (ImageButton) findViewById(R.id.treeplus);
        pcostpertreeminus = (ImageButton) findViewById(R.id.treecostminus);
        pcostpertreeplus = (ImageButton) findViewById(R.id.treecostplus);
        dcoconutminus = (ImageButton) findViewById(R.id.coconutnominus);
        dcoconutplus = (ImageButton) findViewById(R.id.coconutnoplus);
        dcostpercoconutminus = (ImageButton) findViewById(R.id.costpercoconutminus);
        dcostpercoconutplus = (ImageButton) findViewById(R.id.costpercoconutplus);
        lnoofloadsminus = (ImageButton) findViewById(R.id.noofloadsminus);
        lnoofloadplus = (ImageButton) findViewById(R.id.noofloadsplus);
        lcostperloadminus = (ImageButton) findViewById(R.id.costperloadminus);
        lcostperloadplus = (ImageButton) findViewById(R.id.costperloadplus);
        //Edoittexts to have the numbers
        edtnotree = (EditText) findViewById(R.id.edtreeno);
        edtcostpertree = (EditText) findViewById(R.id.edpertreecost);
        edthuskcoconutno = (EditText) findViewById(R.id.edtcoconutnumbers);
        edthuskcostpercoconut = (EditText) findViewById(R.id.edtcostpercoconut);
        edtloadno = (EditText) findViewById(R.id.edtnumberofloads);
        edtloadcost = (EditText) findViewById(R.id.edtcostperload);

        //Textview to total and grand total amt

        pluckertotal = (TextView) findViewById(R.id.pluckingchargetotal);
        huskertotal = (TextView) findViewById(R.id.dehuskingcharges);
        loadingtotal = (TextView) findViewById(R.id.loadingchargestotal);
        totalgrand = (TextView) findViewById(R.id.grandtotal);

        //plucking charges
        edtnotree.setText("0");
        edthuskcoconutno.setText("0");
        edthuskcostpercoconut.setText("0");
        edtloadno.setText("0");
        edtloadcost.setText("0");
        ptreeminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (treenumbers >= 1) {
                    String value = edtnotree.getText().toString();
                    int value_int = Integer.parseInt(value);
                    int incremento = value_int - 1;
                    edtnotree.setText(String.valueOf(incremento));
                    calculateplucker();
                } else {
                    String value = edtnotree.getText().toString();
                    int value_int = Integer.parseInt(value);
                    int incremento = value_int - 1;
                    edtnotree.setText(String.valueOf(incremento));
                    calculateplucker();

                }

            }
        });
        ptreeplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = edtnotree.getText().toString();
                int value_int = Integer.parseInt(value);
                int incremento = value_int + 1;
                edtnotree.setText(String.valueOf(incremento));
                calculateplucker();


            }
        });
        pcostpertreeminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (costpertree > 0) {
                    String value = edtcostpertree.getText().toString();
                    // int value_int = Integer.parseInt(value);
                    // int incremento = value_int -1 ;
                    float value_int = Float.parseFloat(value);
                    float incremento = value_int - 1;
                    edtcostpertree.setText(String.valueOf(incremento));
                    calculateplucker();
                } else {
                    String value = edtcostpertree.getText().toString();
                    //int value_int = Integer.parseInt(value);
                    //int incremento = value_int -1 ;
                    float value_int = Float.parseFloat(value);
                    float incremento = value_int - 1;
                    edtcostpertree.setText(String.valueOf(incremento));
                    calculateplucker();
                }
            }
        });
        pcostpertreeplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = edtcostpertree.getText().toString();
                // int value_int = Integer.parseInt(value);
                //  int incremento = value_int +1 ;
                float value_int = Float.parseFloat(value);
                float incremento = value_int + 1;
                edtcostpertree.setText(String.valueOf(incremento));
                calculateplucker();
            }
        });

        dcoconutminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (coconutnumbers >= 1) {
                    String value = edthuskcoconutno.getText().toString();
                    int value_int = Integer.parseInt(value);
                    int incremento = value_int - 1;
                    edthuskcoconutno.setText(String.valueOf(incremento));
                    calculatehusker();
                } else {
                    //coconutnumbers--;
                    //edthuskcoconutno.setText(String.valueOf(coconutnumbers));
                    String value = edthuskcoconutno.getText().toString();
                    int value_int = Integer.parseInt(value);
                    int incremento = value_int - 1;
                    edthuskcoconutno.setText(String.valueOf(incremento));
                    calculatehusker();
                }
            }
        });
        dcoconutplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String value = edthuskcoconutno.getText().toString();
                int value_int = Integer.parseInt(value);
                int incremento = value_int + 1;
                edthuskcoconutno.setText(String.valueOf(incremento));
                calculatehusker();
            }
        });
        dcostpercoconutminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (costpercoconut > 0) {
                    String value = edthuskcostpercoconut.getText().toString();
                    float value_int = Float.parseFloat(value);
                    float incremento = value_int - 1;
                    edthuskcostpercoconut.setText(String.valueOf(incremento));
                    calculatehusker();
                } else {
                    //costpercoconut--;
                    //edthuskcostpercoconut.setText(String.valueOf(costpercoconut));
                    String value = edthuskcostpercoconut.getText().toString();
                    float value_int = Float.parseFloat(value);
                    float incremento = value_int - 1;
                    edthuskcostpercoconut.setText(String.valueOf(incremento));
                    calculatehusker();
                }
            }
        });
        dcostpercoconutplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = edthuskcostpercoconut.getText().toString();
                float value_int = Float.parseFloat(value);
                float incremento = value_int + 1;
                edthuskcostpercoconut.setText(String.valueOf(incremento));
                calculatehusker();
            }
        });
        lnoofloadsminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loadnumbers >= 1) {
                    String value = edtloadno.getText().toString();
                    int value_int = Integer.parseInt(value);
                    int incremento = value_int - 1;
                    edtloadno.setText(String.valueOf(incremento));
                    calculateloader();
                } else {
                    //loadnumbers--;
                    //edtloadno.setText(String.valueOf(loadnumbers));
                    String value = edtloadno.getText().toString();
                    int value_int = Integer.parseInt(value);
                    int incremento = value_int - 1;
                    edtloadno.setText(String.valueOf(incremento));
                    calculateloader();
                }
            }
        });
        lnoofloadplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //loadnumbers++;
                // edtloadno.setText(String.valueOf(loadnumbers));
                String value = edtloadno.getText().toString();
                int value_int = Integer.parseInt(value);
                int incremento = value_int + 1;
                edtloadno.setText(String.valueOf(incremento));
                calculateloader();
            }
        });
        lcostperloadminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (costperload > 0) {
                    String value = edtloadcost.getText().toString();
                    float value_int = Float.parseFloat(value);
                    float incremento = value_int - 1;
                    edtloadcost.setText(String.valueOf(incremento));
                    calculateloader();
                } else {
                    // costperload--;
                    // edtloadcost.setText(String.valueOf(costperload));
                    String value = edtloadcost.getText().toString();
                    float value_int = Float.parseFloat(value);
                    float incremento = value_int - 1;
                    edtloadcost.setText(String.valueOf(incremento));
                    calculateloader();
                }
            }
        });
        lcostperloadplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // costperload++;
                //  edtloadcost.setText(String.valueOf(costperload));
                String value = edtloadcost.getText().toString();
                float value_int = Float.parseFloat(value);
                float incremento = value_int + 1;
                edtloadcost.setText(String.valueOf(incremento));
                calculateloader();
            }
        });

        edtnotree.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    calculateplucker();
                }
            }
        });
        edtcostpertree.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    calculateplucker();
                }
            }
        });
        edthuskcostpercoconut.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    calculatehusker();
                }
            }
        });
        edthuskcoconutno.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    calculatehusker();
                }
            }
        });
        edtloadno.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    calculateloader();
                }
            }

        });
        edtloadcost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    calculateloader();
                }
            }
        });
        // gtotal=ltotal+sptotal+htotal;
        // totalgrand.setText(String.valueOf(gtotal));
    }

    private void calculateloader() {
        int one = Integer.parseInt(edtloadno.getText().toString());
        float two = Float.parseFloat(edtloadcost.getText().toString());
        float ptotal = (one * two);
        loadingtotal.setText(String.valueOf(ptotal));
        ltotal = Float.parseFloat(loadingtotal.getText().toString());
        gttotal();
    }


    private void calculatehusker() {
        int one = Integer.parseInt(edthuskcoconutno.getText().toString());
        float two = Float.parseFloat(edthuskcostpercoconut.getText().toString());
        float ptotal = (one * two);
        huskertotal.setText(String.valueOf(ptotal));
        htotal = Float.parseFloat(huskertotal.getText().toString());
        gttotal();
    }

    private void calculateplucker() {
        int one = Integer.parseInt(edtnotree.getText().toString());
        float two = Float.parseFloat(edtcostpertree.getText().toString());
        float ptotal = (one * two);
        pluckertotal.setText(String.valueOf(ptotal));
        sptotal = Float.parseFloat(pluckertotal.getText().toString());
        gttotal();
    }

    private void gttotal() {
        gtotal = sptotal + htotal + ltotal;
        BigDecimal grandtotal;
        grandtotal = BigDecimal.valueOf(Math.round(gtotal));
        totalgrand.setText(String.valueOf(grandtotal));
    }


}
