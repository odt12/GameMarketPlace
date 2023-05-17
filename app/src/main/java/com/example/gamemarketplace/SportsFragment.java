package com.example.gamemarketplace;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SportsFragment extends Fragment {
    // ...
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        // Make sure you have a list of products
        List<Product> productList = new ArrayList<>();
        // Add products to the list
        productList.add(new Product(1, "Soccer", R.drawable.s1));
        productList.add(new Product(2, "Football", R.drawable.s2));
        productList.add(new Product(3, "Tennis", R.drawable.s3));


        ProductAdapter productAdapter = new ProductAdapter(requireContext(), productList, (ProductAdapter.OnProductClickListener) requireActivity());
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        return view;
    }
}

