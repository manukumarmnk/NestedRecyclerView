package forktech.com.nestedrecyclerviewapp.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import forktech.com.nestedrecyclerviewapp.R;

/**
 * Created by manu on 4/14/16.
 */
public class NestedRecyclerViewAdapter extends RecyclerView.Adapter<NestedRecyclerViewAdapter.ParentViewHolder> {

    private final LayoutInflater inflater;
    String[] _items = new String[]{"ITEM 1", "ITEM 2", "ITEM 3", "ITEM 4"};
    private Context context;

    public NestedRecyclerViewAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ParentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.child_view, viewGroup, false);
        ParentViewHolder rvi = new ParentViewHolder(view);
        return rvi;
    }

    @Override
    public void onBindViewHolder(ParentViewHolder rootViewHolder, int i) {
        rootViewHolder.button1.setOnClickListener(new ClickListener("Button 1"));
        rootViewHolder.button2.setOnClickListener(new ClickListener("Button 2"));
        rootViewHolder.recyclerViewChild.setLayoutManager(new LinearLayoutManager(inflater.getContext()));
        rootViewHolder.recyclerViewChild.setAdapter(new ChildAdapter(inflater));
    }

    @Override
    public int getItemCount() {
        return _items.length;
    }

    class ParentViewHolder extends RecyclerView.ViewHolder {
        Button button1;
        Button button2;
        RecyclerView recyclerViewChild;

        public ParentViewHolder(View itemView) {
            super(itemView);
            button1 = (Button) itemView.findViewById(R.id.button_one);
            button2 = (Button) itemView.findViewById(R.id.button_two);
            recyclerViewChild = (RecyclerView) itemView.findViewById(R.id.recyclerChild);
        }
    }

    private class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildViewHolder> {
        String[] _childItems = new String[]{"child 1"};
        private LayoutInflater _inflater;

        public ChildAdapter(LayoutInflater inflater) {
            _inflater = inflater;
        }

        @Override
        public ChildViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = _inflater.inflate(R.layout.parent_view, viewGroup, false);
            ChildViewHolder rvi = new ChildViewHolder(view);
            return rvi;
        }

        @Override
        public void onBindViewHolder(ChildViewHolder childViewHolder, int i) {
            childViewHolder.imageViewOne.setOnClickListener(new ClickListener("Image 1"));
            childViewHolder.imageViewTwo.setOnClickListener(new ClickListener("Image 2"));
        }

        @Override
        public int getItemCount() {
            return _childItems.length;
        }

        public class ChildViewHolder extends RecyclerView.ViewHolder {
            ImageView imageViewOne;
            ImageView imageViewTwo;

            public ChildViewHolder(View itemView) {
                super(itemView);
                imageViewOne = (ImageView) itemView.findViewById(R.id.image_view_one);
                imageViewTwo = (ImageView) itemView.findViewById(R.id.image_view_two);
            }
        }
    }

    public class ClickListener implements View.OnClickListener {

        String view;

        public ClickListener(String whichOne) {
            this.view = whichOne;
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, view + "is Clicked.", Toast.LENGTH_SHORT).show();
        }
    }
}

