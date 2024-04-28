package com.abhi41.demoproject.navigation.bottomNav;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import com.abhi41.demoproject.R;
import com.abhi41.demoproject.databinding.ActivityBottomNavigationBarBinding;
import com.abhi41.demoproject.navigation.bottomNav.ui.home.HomeFragment;
import com.abhi41.demoproject.navigation.bottomNav.ui.profile.ProfileFragment;
import com.abhi41.demoproject.navigation.bottomNav.ui.setting.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationBar extends AppCompatActivity  {
    ActivityBottomNavigationBarBinding binding;
    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = item -> {
        Fragment selectedFragment =  null;
        switch (item.getItemId()){
            case R.id.home:
                selectedFragment = new HomeFragment();
                break;

            case R.id.profile:
                selectedFragment = new ProfileFragment();
                break;

            case R.id.setting:
                selectedFragment = new SettingFragment();
                break;

        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,selectedFragment)
                .commit();
        return true;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBottomNavigationBarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,new HomeFragment())
                .commit();
    }
}