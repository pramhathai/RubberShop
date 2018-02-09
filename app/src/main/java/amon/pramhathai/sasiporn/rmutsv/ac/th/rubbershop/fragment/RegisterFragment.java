package amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.MainActivity;
import amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.R;
import amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.utility.MyAlert;
import amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.utility.MyConstant;
import amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.utility.PostOwnerToServer;

/**
 * Created by sasiporn on 2/7/2018 AD.
 */

public class RegisterFragment extends Fragment{

    private String nameShopString, idShopString, passwordString;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create Toolber
        createToolber();                                            // มาจากการกด option+command+m

//        create IdShop
        createIdShop();                                             // มาจากการกด option+command+m

//        Save Controller
        saveController();                                           // มาจากการกด option+command+m

    }   // main method



    private void saveController() {
        Button button = getView().findViewById(R.id.btnSave);               //  เสร็จบรรทัดนี้ คุมทั้งบรรทัด กด option+command+m
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText nameShopEditText = getView().findViewById(R.id.edtNameStore);
                EditText passwordEditText = getView().findViewById(R.id.edtPassword);

                nameShopString = nameShopEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();

                if (nameShopString.isEmpty() || passwordString.isEmpty()) {
//                    Have Space
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.normalDialog(getString(R.string.title_have_space),
                            getString(R.string.message_have_space));


                } else {
//                    No Space
                    try {

                        MyConstant myConstant = new MyConstant();
                        PostOwnerToServer postOwnerToServer = new PostOwnerToServer(getActivity());
                        postOwnerToServer.execute(nameShopString, idShopString,
                                passwordString, myConstant.getUrlAddOwner());

                        if (Boolean.parseBoolean(postOwnerToServer.get())) {
//                            Success upload
                            getActivity().getSupportFragmentManager().popBackStack();

                        } else {
//                            Connot upload

                            Toast.makeText(getActivity(),"Connot Upload to Server",
                                    Toast.LENGTH_SHORT).show();
                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }




                }

            }   // onClick
        });

    }

    private void createIdShop() {
        TextView textView = getView().findViewById(R.id.txtIdStore);        //  เสร็จบรรทัดนี้ คุมทั้งบรรทัด กด option+command+m
        Random random = new Random();
        int myInt = random.nextInt(1000);
        idShopString = "rubber" + Integer.toString(myInt);
        textView.setText(idShopString);

    }

    private void createToolber() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarRegister);     //  เสร็จบรรทัดนี้ คุมทั้งบรรทัด กด option+command+m
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);

        ((MainActivity)getActivity()).getSupportActionBar().setTitle("สมัครสมาชิก");
        ((MainActivity)getActivity()).getSupportActionBar().setSubtitle("สำหรับร้านยาง");

        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager().popBackStack();

            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        return view;
    }

}   // main class
