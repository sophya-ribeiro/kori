package com.example.kori.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.example.kori.R;
import com.example.kori.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.cardTokyo.setOnClickListener(view -> navigateToCities());
        binding.cardKyoto.setOnClickListener(view -> navigateToCities());
        binding.cardOsaka.setOnClickListener(view -> navigateToCities());
        binding.cardNara.setOnClickListener(view -> navigateToCities());

        return root;
    }

    private void navigateToCities() {
        ((BottomNavigationView) requireActivity().findViewById(R.id.nav_view))
                .setSelectedItemId(R.id.navigation_cities);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
