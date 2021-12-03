package com.jnu.sp_tickets;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class create_ticket extends AppCompatActivity {

    private RadioButton tickets_new_type_delivery;
    private RadioButton tickets_new_type_takeout;
    private EditText tickets_new_location;
    private EditText tickets_new_time;
    private EditText tickets_new_tip;
    private Button tickets_new_create;
    private Button tickets_new_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_ticket);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        tickets_new_type_delivery = findViewById(R.id.tickets_new_type_delivery);
        tickets_new_type_takeout = findViewById(R.id.tickets_new_type_takeout);
        tickets_new_location = findViewById(R.id.tickets_new_location);
        tickets_new_time = findViewById(R.id.tickets_new_time);
        tickets_new_tip = findViewById(R.id.tickets_new_tip);
        tickets_new_create = findViewById(R.id.tickets_new_create);
        tickets_new_cancel = findViewById(R.id.tickets_new_cancel);

        tickets_new_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = "null";
                if(tickets_new_type_delivery.isChecked()){
                    type = "Delivery";
                }
                else if(tickets_new_type_takeout.isChecked()){
                    type = "Takeout";
                }
                final String finalType = type;
                String location = tickets_new_location.getText().toString();
                String time = tickets_new_time.getText().toString() + "mins";
                String tip = "￥" + tickets_new_tip.getText().toString();

                if((!tickets_new_type_delivery.isChecked()&&!tickets_new_type_takeout.isChecked()) ||
                    "".equals(location)|| "mins".equals(time)|| "￥".equals(tip)){
                        Toast.makeText(create_ticket.this, getString(R.string.ticket_new_notFill), Toast.LENGTH_LONG).show();
                }
                else{
                    AlertDialog.Builder alertClaim = new AlertDialog.Builder(create_ticket.this);
                    alertClaim.setPositiveButton(getString(R.string.ticket_new_create), (dialogInterface, i) -> {
                        Intent intent1 = new Intent();
                        intent1.putExtra("position", position);
                        intent1.putExtra("type", finalType);
                        intent1.putExtra("location", location);
                        intent1.putExtra("time", time);
                        intent1.putExtra("tip", tip);
                        setResult(fragment_tickets.RESULT_CREATE_SUCCESS, intent1);
                        create_ticket.this.finish();
                    });
                    alertClaim.setNegativeButton(getString(R.string.ticket_new_cancel), (dialogInterface, i) -> {

                    });
                    alertClaim.setMessage(getString(R.string.ticket_new_message));
                    alertClaim.setTitle(getString(R.string.ticket_new_dialogtitle)).show();
                }
            }
        });

        tickets_new_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(create_ticket.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}