package amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.OwnerActivity;
import amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.R;

/**
 * Created by sasiporn on 2/8/2018 AD.
 */

public class OwnerFragment extends Fragment {

    private String[] loginStrings;

    public static OwnerFragment ownerInstance(String[] loginStrings) {
        OwnerFragment ownerFragment = new OwnerFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("Login", loginStrings);
        ownerFragment.setArguments(bundle);

        return ownerFragment;                       //  มาจากการกด Alt+Enter
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Get Login Vale
        loginStrings = getArguments().getStringArray("Login");

//        Create Toolbar
        createToolbar();

//        Customer Controller
        customerController();

//        BuyRubber Contoller
        buyRubberContoller();


    }   // main method

    private void buyRubberContoller() {
        ImageView imageView = getView().findViewById(R.id.imvBuyRubber);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentOwnerFragment, BuyRubberFragment.buyRubberInstance(loginStrings))
                        .addToBackStack(null)
                        .commit();

            }
        });

    }

    private void customerController() {
        ImageView imageView = getView().findViewById(R.id.imvCustomer);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentOwnerFragment, DetailCustomerFragment.detailCustomerInstance(loginStrings))
                        .addToBackStack(null)
                        .commit();
            }
        });

    }

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toobarOwnerHub);
        ((OwnerActivity)getActivity()).setSupportActionBar(toolbar);

        ((OwnerActivity) getActivity()).getSupportActionBar().setTitle(loginStrings[1]);
        ((OwnerActivity) getActivity()).getSupportActionBar().setSubtitle("เจ้าของร้าน");


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_owner, container, false);
        return view;                                                        //  มาจากการกด Alt+Enter
    }
}   // main class
