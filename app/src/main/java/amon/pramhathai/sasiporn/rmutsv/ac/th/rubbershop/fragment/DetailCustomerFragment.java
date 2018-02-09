package amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.OwnerActivity;
import amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.R;

/**
 * Created by sasiporn on 2/8/2018 AD.
 */

public class DetailCustomerFragment extends Fragment{

    private String[] loginStrings;


    public static DetailCustomerFragment detailCustomerInstance(String[] loginStrings) {
        DetailCustomerFragment detailCustomerFragment = new DetailCustomerFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("Login", loginStrings);
        detailCustomerFragment.setArguments(bundle);
        return detailCustomerFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loginStrings = getArguments().getStringArray("Login");

//        Create Toolbar
        createToolbar();


    }   // main method

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_add, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.itemAddNewCustoemr) {

            getActivity().getSupportFragmentManager()
                    .beginTransaction().replace(R.id.contentOwnerFragment, AddNewCustomerFragment.addNewCustomerInstance(loginStrings))
                    .addToBackStack(null)
                    .commit();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toobarDetailCustomer);
        ((OwnerActivity)getActivity()).setSupportActionBar(toolbar);

        ((OwnerActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.detail_customer));
        ((OwnerActivity) getActivity()).getSupportActionBar().setSubtitle(getString(R.string.user_login) + loginStrings[1]);

        ((OwnerActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((OwnerActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });


        setHasOptionsMenu(true);


    }





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_customer, container, false);
        return view;                                            //  มาจากการกด Alt+Enter
    }





}   // main class
