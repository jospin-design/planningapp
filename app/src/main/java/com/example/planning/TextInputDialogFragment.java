package com.example.planning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

import com.google.android.material.textfield.TextInputLayout;

public class TextInputDialogFragment extends DialogFragment {

    private TextInputLayout descriptionInputLayout;
    private EditText descriptionEditText;
    private TextInputLayout stateInputLayout;
    private EditText stateEditText;
    private DialogListener listener;

    public interface DialogListener {
        void onTextEntered(String description, String state);
    }

    public static TextInputDialogFragment newInstance(DialogListener listener) {
        TextInputDialogFragment fragment = new TextInputDialogFragment();
        fragment.listener = listener;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text_input_dialog, container, false);

        descriptionInputLayout = view.findViewById(R.id.descriptionInputLayout);
        descriptionEditText = view.findViewById(R.id.descriptionEditText);
        stateInputLayout = view.findViewById(R.id.stateInputLayout);
        stateEditText = view.findViewById(R.id.stateEditText);

        getDialog().setTitle("Enter Details");

        view.findViewById(R.id.buttonOk).setOnClickListener(v -> {
            String description = descriptionEditText.getText().toString();
            String state = stateEditText.getText().toString();
            listener.onTextEntered(description, state);
            dismiss();
        });

        view.findViewById(R.id.buttonCancel).setOnClickListener(v -> dismiss());

        return view;
    }
}