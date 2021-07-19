package com.example.menudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtvHello;
    ConstraintLayout constraintLayout;
    Button btnConfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();

        txtvHello.setOnClickListener(this);

        registerForContextMenu(constraintLayout);
        btnConfirm.setOnClickListener(this);




    }

    private void mapping() {
        txtvHello = findViewById(R.id.txtvHello);
        constraintLayout = findViewById(R.id.constraintlayout);
        btnConfirm = findViewById(R.id.btnConfirm);
    }

    ;

    private void showPopupMenu() {
        PopupMenu popupMenu = new PopupMenu(this, txtvHello);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu() );
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.mnuOne:
                        Toast.makeText(MainActivity.this,"ban chon chuc nang mnuOne",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.mnuTwo:
                        Toast.makeText(MainActivity.this,"ban chon chuc nang mnuTwo",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.mnuThree:
                        Toast.makeText(MainActivity.this,"ban chon chuc nang mnuThree",Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

//    cai de menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuAdd:
                Toast.makeText(this, "ban click vao Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnuSearch:
                Toast.makeText(this, "ban click vao mnuSearch",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnuLogin:
                showLogin();
                break;
            case R.id.mnuLogout:
                Toast.makeText(this, "ban click vao mnuLogout",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnuFeedback:
                Toast.makeText(this, "ban click vao mnuFeedback",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnuHelp:
                Toast.makeText(this, "ban click vao mnuHelp",Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void showLogin() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.login);
        dialog.setCanceledOnTouchOutside(false);
        EditText edtUserName = dialog.findViewById(R.id.edtUserName);
        EditText edtPassword = dialog.findViewById(R.id.edtPassword);
        Button btnLogin = dialog.findViewById(R.id.btnLogin);
        Button btnCancel = dialog.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();

            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();
                if (userName.equals("admin")&& password.equals("123456")){
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    

                    }

            }
        });

        dialog.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
        menu.setHeaderTitle("chon mau nen");
        menu.setHeaderIcon(R.mipmap.ic_launcher);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuMauxanh:
                constraintLayout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.mnuMaudo:
                constraintLayout.setBackgroundColor(Color.RED);
                break;
            case R.id.mnuMauvang:
                constraintLayout.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.mnuMautim:
                constraintLayout.setBackgroundColor(Color.MAGENTA);
                break;
            case R.id.mnuMaunau:
                constraintLayout.setBackgroundColor(Color.GRAY);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnConfirm:
                showConfirm();
                break;
            case R.id.txtvHello:
                showPopupMenu();
                break;

        }
    }

    private void showConfirm() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("canh bao");
        builder.setMessage("day la thong bao xac nhan....");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(MainActivity.this, "ban click vao ok", Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(MainActivity.this, "ban click vao no", Toast.LENGTH_SHORT).show();

            }
        });
        builder.show();

    }
}