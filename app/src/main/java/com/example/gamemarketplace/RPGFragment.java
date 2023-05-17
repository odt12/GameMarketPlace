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

public class RPGFragment extends Fragment {
    // ...
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        // Make sure you have a list of products
        List<Product> productList = new ArrayList<>();
        // Add products to the list
        productList.add(new Product(1, "Call of Dragons", R.drawable.rp1));
        productList.add(new Product(2, "Ever Legion", R.drawable.rp2));
        productList.add(new Product(3, "Shadow Fight 3", R.drawable.rp3));


        ProductAdapter productAdapter = new ProductAdapter(requireContext(), productList, (ProductAdapter.OnProductClickListener) requireActivity());
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        return view;
    }
}

