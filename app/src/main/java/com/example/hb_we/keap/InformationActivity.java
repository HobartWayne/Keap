package com.example.hb_we.keap;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by hb_we on 2017/5/10.
 */

public class InformationActivity extends Activity {

//    private TextView username;
//    private TextView sex;
//    private TextView birthYear;
//    private TextView height;
//    private TextView weight;
    private String name;
    private TextView getUsername;
    private TextView setSex;
    private TextView setBirthYear;
    private TextView setHeight;
    private TextView setWeight;
    private Button healthReportBtn;
    private Button editButton;
    private Button resetPwdButton;
    private Button logoutButton;
    private Button planButton;
    private Button diaryButton;

    private UserDataManager mUserDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_information);

//        username =(TextView) findViewById(R.id.username);
//        sex = (TextView) findViewById(R.id.user_sex);
//        birthYear = (TextView) findViewById(R.id.user_birth_year);
//        height = (TextView) findViewById(R.id.user_height);
//        weight = (TextView) findViewById(R.id.user_weight);
        getUsername = (TextView) findViewById(R.id.username_edit);
        setSex = (TextView) findViewById(R.id.user_set_sex);
        setBirthYear = (TextView) findViewById(R.id.user_set_birth_year);
        setHeight = (TextView) findViewById(R.id.user_set_height);
        setWeight = (TextView) findViewById(R.id.user_set_weight);
        healthReportBtn = (Button) findViewById(R.id.healthReportBtn);
        editButton = (Button) findViewById(R.id.edit_button);
        resetPwdButton = (Button) findViewById(R.id.resetPwd);
        logoutButton = (Button) findViewById(R.id.logout);
        planButton = (Button) findViewById(R.id.plan);
        diaryButton = (Button) findViewById(R.id.diary);

        healthReportBtn.setOnClickListener(mListener);
        editButton.setOnClickListener(mListener);
        resetPwdButton.setOnClickListener(mListener);
        logoutButton.setOnClickListener(mListener);
        planButton.setOnClickListener(mListener);
        diaryButton.setOnClickListener(mListener);

        Intent getName = getIntent();
        name = getName.getStringExtra("extra_name");
        getUsername.setText(name);

        mUserDataManager = new UserDataManager(this);
        Cursor cursor = mUserDataManager.findInfoByName(name);
        if(cursor.moveToFirst()){
            do{
                setSex.setText(cursor.getString(cursor.getColumnIndex(UserDataManager.USER_SEX)));
                setBirthYear.setText(cursor.getString(cursor.getColumnIndex(UserDataManager.USER_BIRTHYEAR)));
                setHeight.setText(cursor.getString(cursor.getColumnIndex(UserDataManager.USER_HEIGHT)));
                setWeight.setText(cursor.getString(cursor.getColumnIndex(UserDataManager.USER_WEIGHT)));
            }while (cursor.moveToNext());

        }

    }

    View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.healthReportBtn:
                    Intent info_to_healthReport = new Intent(InformationActivity.this,
                            HealthReportActivity.class);
                    info_to_healthReport.putExtra("extra_name",name);
                    startActivity(info_to_healthReport);
                    break;
                case R.id.edit_button:
                    Intent info_to_editInfo = new Intent(InformationActivity.this,
                            EditInformationActivity.class);
                    info_to_editInfo.putExtra("extra_name",name);
                    startActivity(info_to_editInfo);
                    break;
                case R.id.resetPwd:
                    Intent info_to_resetPwd = new Intent(InformationActivity.this,
                            ResetPwdActivity.class);
                    info_to_resetPwd.putExtra("extra_name",name);
                    startActivity(info_to_resetPwd);
                    break;
                case R.id.logout:
                    Intent info_to_main = new Intent(InformationActivity.this,
                            LoginActivity.class);
                    startActivity(info_to_main);
                    break;
                case R.id.plan:
                    Intent info_to_plan = new Intent(InformationActivity.this,
                            Plan_MainActivity.class);
                    info_to_plan.putExtra("extra_name",name);
                    startActivity(info_to_plan);
                    break;
                case R.id.diary:
                    Intent info_to_diary = new Intent(InformationActivity.this,
                            Move_MainActivity.class);
                    info_to_diary.putExtra("extra_name",name);
                    startActivity(info_to_diary);
                    break;
                default:
                    break;
            }
        }
    };
}
