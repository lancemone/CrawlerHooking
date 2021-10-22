package com.more.crawlerhooking.app.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.more.crawlerhooking.app.view.DetailInfoView;
import com.more.crawlerhooking.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        initView();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void initView(){
        final DetailInfoView androidIdView = binding.detailAndroidId;
        homeViewModel.getAndroidId().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                androidIdView.setContent(s);
            }
        });
        final DetailInfoView serialNoView = binding.detailSerialNumber;
        homeViewModel.getSerialNum().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                serialNoView.setContent(s);
            }
        });

        final DetailInfoView regionView = binding.detailTiktokRegion;
        homeViewModel.getRegion().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                regionView.setContent(s);
            }
        });

        final DetailInfoView carrierCodeView = binding.detailCarrierCode;
        homeViewModel.getCarrierCode().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                carrierCodeView.setContent(s);
            }
        });
        final DetailInfoView taskTurnView = binding.detailTaskTurn;
        homeViewModel.getTaskTurn().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                taskTurnView.setContent(s);
            }
        });
        taskTurnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeViewModel.updateTaskTurn();
                showToast("update success");
            }
        });
    }

    private void showToast(String msg){
        Toast.makeText(this.getContext(), msg, Toast.LENGTH_LONG).show();
    }
}