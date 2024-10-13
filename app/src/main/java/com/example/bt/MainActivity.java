package com.example.bt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.bt.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
  private ActivityMainBinding binding;

  @Override
  protected void attachBaseContext(Context newBase) {
    
    Locale localeToSwitch = new Locale(ContextUltis.language);
    Context localeUpdatedContext = ContextUltis.updateLocale(newBase, localeToSwitch);
    super.attachBaseContext(localeUpdatedContext);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    
    replaceFragment(new HomeFragment());

    
    binding.bottomNavigationView.setOnItemSelectedListener(item -> {
      int itemId = item.getItemId();
      if (itemId == R.id.home) {
        replaceFragment(new HomeFragment());
        return true;
      } else if (itemId == R.id.profile) {
        replaceFragment(new ProfileFragment());
        return true;
      } else if (itemId == R.id.settings) {
        replaceFragment(new SettingFragment());
        return true;
      }
      return false;
    });
  }

  
  private void replaceFragment(Fragment fragment) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.frame_layout, fragment);
    fragmentTransaction.addToBackStack(null); 
    fragmentTransaction.commit();
  }

  
  public void restartActivity() {
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
    finish();
  }
}
