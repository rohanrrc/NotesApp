package com.rohan.notes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

import java.util.List;

/**
 * Created by rohan on 7/23/16.
 */
public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {


    private List<Note> notesList;
    Context mContext;

    public NoteAdapter(Context context, List<Note> objects) {
        this.mContext = context;
        this.notesList = objects;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public ListView contents;
        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            contents = (ListView) view.findViewById(R.id.contents);
        }
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Note note = notesList.get(position);
        if (note.getTitle() == "")
            holder.title.setVisibility(View.GONE);
        else
            holder.title.setText(note.getTitle());

        List noteContents = note.getContents();

         class CustomAdapter<String> extends ArrayAdapter<String> {
            private static final int MAX_ROW_DISPLAY = 5;
            private List<String> mItems;
            public CustomAdapter(Context context, int resource, List<String> objects) {
                super(context, resource, objects);
                mItems = objects;
            }
            @Override
            public int getCount() {
                if (mItems == null) return 0;
                return Math.min(MAX_ROW_DISPLAY, mItems.size());
            }
             @Override
             public View getView(int position, View convertView, ViewGroup parent){
                 View view = super.getView(position,convertView,parent);

                 // Get the Layout Parameters for ListView Current Item View
                 LayoutParams params = view.getLayoutParams();

                 // Set the height of the Item View
//                 if (getCount() > 1) {
//                     params.height = 120;
//                     view.setLayoutParams(params);
//                 }
                 return view;
             }
        }
        if (noteContents.size() > 1){
            CustomAdapter adapter = new CustomAdapter<String>(this.mContext, R.layout.simple_list_item, noteContents);
            holder.contents.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
            holder.contents.setAdapter(adapter);
        }
        else{
            ArrayAdapter adapter = new ArrayAdapter(this.mContext, android.R.layout.simple_list_item_1,noteContents);
            holder.contents.setAdapter(adapter);
        }


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int arg1) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_cell, parent, false);
        return new ViewHolder(itemView);
    }

}