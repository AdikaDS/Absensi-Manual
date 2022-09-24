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


public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        EditText email2 = view.findViewById(R.id.edit_email2);
        EditText pass2 = view.findViewById(R.id.edit_email2);
        EditText nama = view.findViewById(R.id.edit_nama);

        Button daftar = view.findViewById(R.id.register);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(nama.getText().toString())) {
                    Toast.makeText(getActivity(), "Kolom Nama Lengkap tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }
                else if  (TextUtils.isEmpty(email2.getText().toString())) {
                    Toast.makeText(getActivity(), "Kolom Email tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(pass2.getText().toString())) {
                    Toast.makeText(getActivity(), "Kolom Password tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(),"Daftar Berhasil!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }
}