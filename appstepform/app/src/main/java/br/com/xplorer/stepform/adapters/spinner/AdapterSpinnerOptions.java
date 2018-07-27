package br.com.xplorer.stepform.adapters.spinner;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.xplorer.stepform.R;
import lib.view.stepform.models.options.Option;

public class AdapterSpinnerOptions<T> extends ArrayAdapter<Option<T>> {

    List<Option<T>> options;

    /**
     * @param context
     * @param options
     *
     * layout do spinner quando esta fechado
     * @param spinnerLayout
     * layout do spinner aberto
     * @param dropDownViewLayout
     * */

    @LayoutRes
    private int dropDownViewLayout;

    public AdapterSpinnerOptions(@NonNull Context context
            , @LayoutRes int spinnerLayout, @NonNull List<Option<T>> options, @LayoutRes int dropDownViewLayout) {
        super(context, spinnerLayout, options);
        this.options = options;
        this.dropDownViewLayout = dropDownViewLayout;
    }

    @Nullable
    @Override
    public Option<T> getItem(int position) {
        return options.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(parent, position);
    }


    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(parent, position);
    }


    private View getCustomView(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(dropDownViewLayout, parent, false);
        if (view != null) {
            Option<T> option = options.get(position);
            ((TextView) view.findViewById(R.id.text)).setText(option.getDescription());
        }
        return view;
    }
}
