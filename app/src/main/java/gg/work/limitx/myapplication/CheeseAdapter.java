package gg.work.limitx.myapplication;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import gg.work.limitx.myapplication.data.Cheese;

public class CheeseAdapter extends RecyclerView.Adapter<CheeseAdapter.ViewHolder> {

    private Cursor mCursor;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (mCursor.moveToPosition(position)) {
            holder.mText.setText(
                    mCursor.getString(
                    mCursor.getColumnIndexOrThrow(Cheese.COLUMN_ID)) +
                            " " +
                    mCursor.getString(
                    mCursor.getColumnIndexOrThrow(Cheese.COLUMN_NAME)));
        }
    }

    @Override
    public int getItemCount() {
        return mCursor == null ? 0 : mCursor.getCount();
    }

    void setCheeses(Cursor cursor) {
        mCursor = cursor;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mText;

        ViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(
                    android.R.layout.simple_list_item_1, parent, false));
            mText = itemView.findViewById(android.R.id.text1);
        }

    }

}