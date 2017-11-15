package com.example.android.presentor.Domotics;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.android.presentor.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlo on 15/11/2017.
 */

public class DomoticsSwitchAdapter extends ArrayAdapter<DomoticsSwitch> {


    public DomoticsSwitchAdapter(@NonNull Context context, int resource, @NonNull List<DomoticsSwitch> domoticsSwitches) {
        super(context, 0, domoticsSwitches);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_domotics, parent, false);
        }

        final DomoticsSwitch ds = getItem(position);

        CardView cardView = (CardView)itemView.findViewById(R.id.card_view_domotics);
        final TextView applianceName = (TextView) itemView.findViewById(R.id.text_view_appliance_name);
        final TextView applianceStatusTextView = (TextView) itemView.findViewById(R.id.text_view_appliance_status);
        final ImageView applianceStatusImageView = (ImageView) itemView.findViewById(R.id.image_view_appliance_status);
        final Switch applianceStatusSwitch = (Switch) itemView.findViewById(R.id.switch_appliance);

        applianceName.setText(ds.getSwitchName());
        if(ds.getSwitchStatus()){
            applianceStatusTextView.setText(getContext().getResources().
                    getString(R.string.appliance_status_on));
        }else{
            applianceStatusTextView.setText(getContext().getResources().
                    getString(R.string.appliance_status_off));
        }

        applianceStatusSwitch.setChecked(ds.getSwitchStatus());

        applianceStatusSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                ds.setSwitchStatus(!ds.getSwitchStatus());
                if(isChecked){
                    Drawable d =  getContext().getResources().getDrawable(R.drawable.ic_power_bg_on);
                    applianceStatusImageView.setBackground(d);
                    applianceStatusTextView.setText(getContext().getResources().
                            getString(R.string.appliance_status_on));
                }else{
                    Drawable d =  getContext().getResources().getDrawable(R.drawable.ic_power_bg_off);
                    applianceStatusImageView.setBackground(d);
                    applianceStatusTextView.setText(getContext().getResources().
                            getString(R.string.appliance_status_off));
                }
            }
        });

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applianceStatusSwitch.setChecked(!applianceStatusSwitch.isChecked());
            }
        });

        cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.d("DomoticsSwitchAdapter", "Long press click: " + applianceName);
                return true;
            }
        });

        return itemView;
    }

}
