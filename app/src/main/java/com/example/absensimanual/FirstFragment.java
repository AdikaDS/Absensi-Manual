package com.example.absensimanual;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        EditText email1 = view.findViewById(R.id.edit_email1);
        EditText pass1 = view.findViewById(R.id.edit_sandi1);

        Button login = view.findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(email1.getText().toString())) {
                    Toast.makeText(getActivity(), "Kolom Email tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(pass1.getText().toString())) {
                    Toast.makeText(getActivity(), "Kolom Password tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(),"Login Berhasil!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });


        return view;
    }
}