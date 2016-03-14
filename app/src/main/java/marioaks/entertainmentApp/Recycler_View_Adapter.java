package marioaks.entertainmentApp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import marioaks.search.R;

/**
 * Created by rajmehta on 2/23/16.
 */
public class Recycler_View_Adapter extends RecyclerView.Adapter<View_Holder> {
    //List<Data> list = Collections.emptyList();
    List<Data> list;
    Context context;

    public Recycler_View_Adapter(Context context) {
        System.out.println("GETTING HERE");
        list = new ArrayList<>();
        //this.list = list;
        this.context = context;
    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        View_Holder holder = new View_Holder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(View_Holder holder, int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.title.setText(list.get(position).title);
        holder.progress.setText(list.get(position).percentNumber);
        holder.media.setImageResource(list.get(position).imageId);
        holder.pbar.setProgress(list.get(position).progress);
        holder.date.setText(list.get(position).date);

        //animate(holder);

    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, Data data) {
        System.out.println("Adding data");
        list.add(position, data);
        System.out.println("List size: " + list.size());
        notifyDataSetChanged();
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Data data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }
}
