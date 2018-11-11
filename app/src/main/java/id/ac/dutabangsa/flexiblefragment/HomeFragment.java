package id.ac.dutabangsa.flexiblefragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View tampilan = inflater.inflate(R.layout.fragment_home, container, false);
        Button btnkategori = (Button) tampilan.findViewById(R.id.btn_kategori);
        btnkategori.setOnClickListener(this);
        return tampilan;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_kategori) {
            KategoriFragment mKategoriFragment = new KategoriFragment();
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.frame_container, mKategoriFragment, KategoriFragment.class.getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }

    }
}
