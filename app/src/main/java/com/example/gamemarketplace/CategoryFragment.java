package com.example.gamemarketplace;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class CategoryFragment extends Fragment {

    RecyclerView recyclerView;
    List<Product> productList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        productList = getCategoryProducts();
        ProductAdapter productAdapter = new ProductAdapter(getContext(), productList, (ProductAdapter.OnProductClickListener) getActivity());
        recyclerView.setAdapter(productAdapter);

        return view;
    }

    public abstract List<Product> getCategoryProducts();
}
