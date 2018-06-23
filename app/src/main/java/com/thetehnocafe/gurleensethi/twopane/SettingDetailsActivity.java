package com.thetehnocafe.gurleensethi.twopane;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SettingDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_SETTING_OPTION = "option";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_details);

        String option = getIntent().getStringExtra(EXTRA_SETTING_OPTION);
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (option == null) {
            finish();
            return;
        }

        switch (option) {
            case "network": {
                fragmentManager.beginTransaction()
                        .add(R.id.settingsContainer, new NetworkSettingsFragment())
                        .commit();
                break;
            }
            case "display": {
                fragmentManager.beginTransaction()
                        .add(R.id.settingsContainer, new DisplaySettingsFragment())
                        .commit();
                break;
            }
            case "storage": {
                fragmentManager.beginTransaction()
                        .add(R.id.settingsContainer, new StorageSettingsFragment())
                        .commit();
                break;
            }
        }
    }
}
