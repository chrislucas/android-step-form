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

    public AdapterSpinnerOptions(@NonNull Context context, @LayoutRes int resource
            , @NonNull List<Option<T>> options) {
        super(context, resource, options);
        this.options = options;
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
                .inflate(R.layout.custom_layout_simple_adapter_spinner
                , parent, false);
        if (view != null) {
            Option<T> option = options.get(position);
            ((TextView) view).setText(option.getDescription());
        }
        return view;
    }
}
