package com.example.gamemarketplace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductAdapter.OnProductClickListener {
    private List<Product> productList;
    private Handler sliderHandler = new Handler();
    private ViewPager2 sliderViewPager;
    private SliderAdapter sliderAdapter;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeProductList();

        // Initialize the slider ViewPager2
        sliderViewPager = findViewById(R.id.sliderViewPager);
        sliderAdapter = new SliderAdapter(this, productList); // assuming you have productList available
        sliderViewPager.setAdapter(sliderAdapter);

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        CategoryPagerAdapter categoryPagerAdapter = new CategoryPagerAdapter(this);
        viewPager.setAdapter(categoryPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        // Use TabLayoutMediator to connect TabLayout with ViewPager2
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(categoryPagerAdapter.getPageTitle(position))
        ).attach();

        //search options
        AutoCompleteTextView searchView = findViewById(R.id.searchView);
        String[] options = new String[] {"App in purchase", "Popular", "Ads (Yes or No)","Platforms","Age Restrictions","Educational","Combat","First Person Shooter","Action", "Simulation"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, options);
        searchView.setAdapter(adapter);

        //bottom nav
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.navigation_home) {
                    // Intent to Home Activity
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                } else if (id == R.id.navigation_profile) {
                    // Intent to Profile Activity
                    startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                } else if (id == R.id.navigation_wallet) {
                    // Intent to Wallet Activity
                    startActivity(new Intent(MainActivity.this, WalletActivity.class));
                } else if (id == R.id.navigation_search) {
                    // Intent to Library Activity
                    startActivity(new Intent(MainActivity.this, LibraryActivity.class));
                }
                return true;
            }
        });
    }

    private final Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            if (sliderViewPager != null) {
                int currentItem = sliderViewPager.getCurrentItem();
                int nextItem = (currentItem + 1) % sliderAdapter.getItemCount();
                sliderViewPager.setCurrentItem(nextItem);
                sliderHandler.postDelayed(this, 3000); // Change the delay time (in milliseconds) as desired
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 3000); // Start the slider after a delay
    }

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable); // Stop the slider when the activity is not visible
    }

    private void initializeProductList() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Call of Duty", R.drawable.call));
        productList.add(new Product(2, "MiniGun", R.drawable.mini));
        productList.add(new Product(3, "Ram", R.drawable.ram));
        productList.add(new Product(4, "MiniGun", R.drawable.action));
        productList.add(new Product(5, "Ram", R.drawable.alto));
        productList.add(new Product(6, "Call of Duty", R.drawable.s1));
        productList.add(new Product(7, "MiniGun", R.drawable.r1));
        productList.add(new Product(8, "Ram", R.drawable.action1));
        productList.add(new Product(9, "MiniGun", R.drawable.s3));
        productList.add(new Product(10, "Ram", R.drawable.r2));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.search_bar);
        SearchView searchView = (SearchView) searchItem.getActionView();

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.account_icon) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProductClick(int position) {
        // Handle the product click event here
        Intent intent = new Intent(this, ProductDetailsActivity.class);

        // Ensure the product object is put into the intent
        intent.putExtra("product", productList.get(position));
        startActivity(intent);
    }
}
