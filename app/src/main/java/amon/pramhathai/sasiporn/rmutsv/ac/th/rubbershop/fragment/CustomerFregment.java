package amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.R;

/**
 * Created by sasiporn on 2/9/2018 AD.
 */

public class CustomerFregment extends Fragment{

    private String[] loginString;

    public static CustomerFregment customerFregment(String[] loginStrings) {
        CustomerFregment customerFregment = new CustomerFregment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("Login", loginStrings);
        customerFregment.setArguments(bundle);
        return customerFregment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loginString = getArguments().getStringArray("Login");

    }    // mime method

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer, container, false);
        return view;
    }
}
