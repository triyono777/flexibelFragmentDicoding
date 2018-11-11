package id.ac.dutabangsa.flexiblefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailKategoriFragment extends Fragment implements View.OnClickListener {
    public static String EXTRA_NAMA = "extra_nama";
    @BindView(R.id.tv_kategori_deskripsi)
    TextView tv_kategoriDeskripsi;
    @BindView(R.id.tv_kategori_name)
    TextView tv_kategori_name;
    @BindView(R.id.btn_profil)
    Button btnProfil;
    @BindView(R.id.btn_show_dialog)
    Button btnShowDialog;
    private String iniDeskripsi;

    public DetailKategoriFragment() {
        // Required empty public constructor
    }

    public String getIniDeskripsi() {
        return iniDeskripsi;
    }

    public void setIniDeskripsi(String iniDeskripsi) {
        this.iniDeskripsi = iniDeskripsi;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View tampilan = inflater.inflate(R.layout.fragment_detail_kategori, container, false);
        ButterKnife.bind(this, tampilan);
        btnShowDialog.setOnClickListener(this);
        btnProfil.setOnClickListener(this);
        return tampilan;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String kategoriname = getArguments().getString(EXTRA_NAMA);
        tv_kategori_name.setText(kategoriname);
        tv_kategoriDeskripsi.setText(getIniDeskripsi());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_profil:
                break;
            case R.id.btn_show_dialog:
                OptionDialogFragment mOptionDialogFragment = new OptionDialogFragment();
                mOptionDialogFragment.setOnOptionDialogListener(new OptionDialogFragment.OnOptionDialogListener() {
                    @Override
                    public void onOptionTerpilih(String text) {
                        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
                    }
                });
                FragmentManager mFragmentManager = getFragmentManager();
                mOptionDialogFragment.show(mFragmentManager, OptionDialogFragment.class.getSimpleName());
                break;
        }

    }
}
