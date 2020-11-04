package org.justice.dodobot;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;

    ViewHolder(View itemView)
    {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView2);

    }


}
