package com.idankorenisraeli.mysettingsscreen.holder.dialog;

import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.holder.essential.TitleTileHolder;
import com.idankorenisraeli.mysettingsscreen.tile_data.dialog.EditTextTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SettingsTileData;

public class EditTextTileHolder extends TitleTileHolder {

    TextView selectedLabel;

    public EditTextTileHolder(View itemView) {
        super(itemView);
        findViews();
    }

    @Override
    public void findViews(){
        super.findViews();
        selectedLabel = itemView.findViewById(R.id.tile_radio_LBL_selected);

    }

    @Override
    public void setData(SettingsTileData tileObject) {
        super.setData(tileObject);
        EditTextTileData mData = (EditTextTileData) tileObject;

        // Vanishing the text if it is not a labeled setting
        selectedLabel.setText(mData.getSavedValue());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildEditTextDialog(mData);
            }
        });

    }

    private void buildEditTextDialog(EditTextTileData mData){
        TextInputEditText editText = createEditText(mData.getSavedValue());


        LinearLayout innerLayout = new LinearLayout(itemView.getContext());
        innerLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(40, 15, 40, 15);

        innerLayout.addView(editText, params);

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(itemView.getContext())
                .setTitle(mData.getTitle())
                .setView(innerLayout)
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String newString = editText.getText().toString();
                        selectedLabel.setText(newString);
                        mData.saveValue(newString);
                        if(mData.getOnSelectedListener()!=null) {
                            mData.getOnSelectedListener().onOptionSelected(newString);
                        }
                    }
                });
        builder.show();

    }


    @Override
    protected void validateData(SettingsTileData tileData){
        EditTextTileData mData = (EditTextTileData) tileData;
        if(mData.getDefaultValue() == null) {
            logMissedAttribute(getClass().getSimpleName(),"Default Option");
            mData.setDefaultValue("Option");
        }
    }

    private TextInputEditText createEditText(String selectedOption) {
        TextInputEditText editText = new TextInputEditText(itemView.getContext());
        editText.setText(selectedOption);
        editText.setPadding(20,20,20,20);
        return editText;
    }

}
