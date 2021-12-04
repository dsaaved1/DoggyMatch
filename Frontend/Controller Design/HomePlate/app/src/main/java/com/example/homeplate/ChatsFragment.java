package com.example.homeplate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.fragment.app.Fragment;

import com.example.homeplate.model.staticUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * View for List of Chats
 * Shows all Matches:
 * - Name
 * - Most Recent Message
 * @// TODO: 12/2/21 Implement Matches and Messages
 * @author Corbin Graham
 */
public class ChatsFragment extends Fragment {

    // Local Fields
    private ListView chatList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chats, container, false);

        setValues(view);
        interact();

        return view;
    }

    /**
     * Initialize Fields
     * and Values
     * @param view Current View (Fragment)
     */
    private void setValues(View view)
    {
        // ListView
        chatList = view.findViewById(R.id.chatList);

        // Initialize List Values

        // User Information for Matches
        HashMap<String, String> matchInformation = new HashMap<>();

        /* UNCOMMENT WHEN ENABLED
        // for 0 -> Matches.size()
        // Put Name, MOST RECENT MESSAGE
        for(int i : staticUser.getUser().getMatches()) {
            matchInformation.put(staticUser.getUser().getMatches().get(i).getName(), staticUser.getUser().getMatches().get(i).getRecentMessage());
        }
         */

        // EXAMPLE - REMOVE ==============================================
        matchInformation.put("Diana", "Hey!");
        matchInformation.put("Tyga", "Rack City is lit!");
        matchInformation.put("Rich Homie Quan", "Everything goin great");
        matchInformation.put("Donda", "Bless up.");
        matchInformation.put("Bartholomew", "Bruh.");
        matchInformation.put("Alissa", "Aye shorty...");
        // ===============================================================

        // Solution from GitHub for Populating ListView using HashMapping
        // https://github.com/Salyder/ListviewExample/
        List<HashMap<String, String>> listItems = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), listItems, R.layout.list_item,
                new String[]{"First Line", "Second Line"},
                new int[]{R.id.name, R.id.description});

        Iterator it = matchInformation.entrySet().iterator();
        while (it.hasNext())
        {
            HashMap<String, String> resultsMap = new HashMap<>();
            Map.Entry pair = (Map.Entry)it.next();
            resultsMap.put("First Line", pair.getKey().toString());
            resultsMap.put("Second Line", pair.getValue().toString());
            listItems.add(resultsMap);
        }
        chatList.setAdapter(adapter);
    }

    /**
     * Wait for Interaction
     * then Handle interaction
     */
    private void interact()
    {
        chatList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                staticUser.setChatIndex(i);
                getFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .add(R.id.fragment_container_view, UserChatFragment.class, null)
                        .commit();
            }
        });
    }
}
