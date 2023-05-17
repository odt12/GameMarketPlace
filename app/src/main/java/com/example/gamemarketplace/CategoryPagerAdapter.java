package com.example.gamemarketplace;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CategoryPagerAdapter extends FragmentStateAdapter {

    public CategoryPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new ArcadeFragment();
            case 1:
                return new ActionFragment();
            case 2:
                return new AdventureFragment();
            case 3:
                return new RPGFragment();
            case 4:
                return new SportsFragment();
            default:
                return new ArcadeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Nullable
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Arcade";
            case 1:
                return "Action";
            case 2:
                return "Adventure";
            case 3:
                return "RPG";
            case 4:
                return "Sports";
            default:
                return "Arcade";
        }
    }
}
