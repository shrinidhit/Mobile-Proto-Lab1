package lab2.jwoo.lab2;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wooj on 9/14/14.
 */
public class ChatFragment extends Fragment {
    private ArrayList<ChatItem> chatItems;

    public ChatFragment () {
        this.chatItems = new ArrayList<ChatItem>();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ListView myListView = (ListView) rootView.findViewById(R.id.chatbox);

        Button sendButton = (Button) rootView.findViewById(R.id.sendbutton);
        final EditText textBox = (EditText) rootView.findViewById(R.id.textbox);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatItems.add(new ChatItem("me", textBox.getText().toString(), "today"));
                textBox.setText("");
            }
        });

        myListView.setAdapter(new ChatAdapter(getActivity(), this.chatItems));

        return rootView;
    }
}