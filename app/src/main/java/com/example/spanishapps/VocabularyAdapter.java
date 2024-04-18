package com.example.spanishapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class VocabularyAdapter extends RecyclerView.Adapter<VocabularyAdapter.ViewHolder> {

    private Context context;
    private List<VocabularyItem> vocabularyItems;

    public VocabularyAdapter(Context context, List<VocabularyItem> vocabularyItems) {
        this.context = context;
        this.vocabularyItems = vocabularyItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_vocabulary, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VocabularyItem item = vocabularyItems.get(position);
        holder.wordTextView.setText(item.getWord());
        holder.translationTextView.setText(item.getTranslation());
        if (item.getImageResource() != 0) {
            holder.imageView.setImageResource(item.getImageResource());
            holder.imageView.setVisibility(View.VISIBLE);
        } else {
            holder.imageView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return vocabularyItems.size();
    }

    public void updateData(List<VocabularyItem> newData) {
        vocabularyItems.clear();
        vocabularyItems.addAll(newData);
        notifyDataSetChanged();
    }



    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView wordTextView;
        TextView translationTextView;
        ImageView imageView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            wordTextView = itemView.findViewById(R.id.word_text_view);
            translationTextView = itemView.findViewById(R.id.translation_text_view);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }
}
