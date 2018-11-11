package id.ac.dutabangsa.flexiblefragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class KategoriFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.btn_detail_kategory)
    Button btnDeatailKategori;

    public KategoriFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View tampilan = inflater.inflate(R.layout.fragment_kategori, container, false);
        ButterKnife.bind(this, tampilan);
        btnDeatailKategori.setOnClickListener(this);
        return tampilan;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_detail_kategory) {
//membuat object mDetailKategoriFragment
            DetailKategoriFragment mDetailKategoriFragment = new DetailKategoriFragment();
//membuat object bundle
            Bundle mbundle = new Bundle();
// membuat atau mengisi data ke bundle dengan tempat tujuan "DetailKategoriFragment.EXTRA_NAMA" berisi "lifestyle"
            mbundle.putString(DetailKategoriFragment.EXTRA_NAMA, "lifestyle");

//mengirim data dari fragement saat ini ke fragment tujuan dengan memakai Bundle
            mDetailKategoriFragment.setArguments(mbundle);

//mengisi data ke "deskripsi"
//  mengirim data ke fragment tujuan memakai setter dari fragment lain atau fargment tujuan
            String deskripsi = "kategori ini berisi lifestyle yang sangat stylish";
            mDetailKategoriFragment.setIniDeskripsi(deskripsi);

//perintah2 standard fragment
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaksi = mFragmentManager.beginTransaction();

//mengganti fragment saat ini
            mFragmentTransaksi.replace(R.id.frame_container, mDetailKategoriFragment, DetailKategoriFragment.class.getSimpleName());

//mengirim fragment ke backstack untuk dipanggil lagi (biasanya dengan tombol back)
            mFragmentTransaksi.addToBackStack(null);
            mFragmentTransaksi.commit();
        }
    }

}

