package com.example.admin.designandroid;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class main_main_activity extends AppCompatActivity implements MasterFragment.OnImageClickListener{

    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this,"Position clicked="+ position,Toast.LENGTH_SHORT).show();

        int bodypartno=position/12;
        int listIndex=position-12*bodypartno;

        switch (bodypartno)
        {
            case 0: headIndex=listIndex;
            break;
            case 1: bodyIndex=listIndex;
            break;
            case 2: legIndex=listIndex;
            break;
            default:break;

        }


        Bundle b=new Bundle();
        b.putInt("headIndex", headIndex);
        b.putInt("bodyIndex", bodyIndex);
        b.putInt("legIndex", legIndex);

        final Intent intent= new Intent(this,MainActivity.class);
        intent.putExtras(b);

        Button  button=(Button) findViewById(R.id.next_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
























    }
}
