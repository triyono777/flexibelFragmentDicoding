package id.ac.dutabangsa.flexiblefragment;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class OptionDialogFragment extends DialogFragment implements View.OnClickListener {


    @BindView(R.id.rb_react)
    RadioButton rbReact;
    @BindView(R.id.rb_androidstudio)
    RadioButton rbAndroidstudio;
    @BindView(R.id.rb_fluter)
    RadioButton rbFluter;
    @BindView(R.id.rg_pilihan)
    RadioGroup rgPilihan;
    @BindView(R.id.btn_pilih)
    Button btnPilih;
    @BindView(R.id.btn_close)
    Button btnClose;
    Unbinder unbinder;
    private OnOptionDialogListener mOnOptionDialogListener;

    public OptionDialogFragment() {
        // Required empty public constructor
    }

    public OnOptionDialogListener getOnOptionDialogListener() {
        return mOnOptionDialogListener;
    }

    public void setOnOptionDialogListener(OnOptionDialogListener onOptionDialogListener) {
        this.mOnOptionDialogListener = onOptionDialogListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View tampilan = inflater.inflate(R.layout.fragment_open_dialog, container, false);
        unbinder = ButterKnife.bind(this, tampilan);
        return tampilan;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.rb_react, R.id.rb_androidstudio, R.id.rb_fluter, R.id.rg_pilihan, R.id.btn_pilih, R.id.btn_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btn_pilih:
                int radioButtonIdYangDicheck = rgPilihan.getCheckedRadioButtonId();
                if (radioButtonIdYangDicheck != -1) {
                    String mIDEfavorit = null;
                    switch (radioButtonIdYangDicheck) {
                        case R.id.rb_react:
                            mIDEfavorit = rbReact.getText().toString().trim();
                            break;
                        case R.id.rb_androidstudio:
                            mIDEfavorit = rbAndroidstudio.getText().toString().trim();
                            break;
                        case R.id.rb_fluter:
                            mIDEfavorit = rbFluter.getText().toString().trim();
                            break;
                    }
                    getOnOptionDialogListener().onOptionTerpilih(mIDEfavorit);
                    getDialog().cancel();
                }
                break;
            case R.id.btn_close:
                getDialog().cancel();
                break;
        }
    }

    public interface OnOptionDialogListener {
        void onOptionTerpilih(String text);
    }
}
