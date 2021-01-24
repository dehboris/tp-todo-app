package bj.esgis.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<String> listeTache;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // les donnnees sont passées dans le constructeur
    Adapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.listeTache = data;
    }

    // associer le viewholder au layout row correspond
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.task_row, parent, false);
        return new ViewHolder(view);
    }

    // lier les  données au textview pour chaque ligne
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String tache = listeTache.get(position);
        holder.myTextView.setText(tache);
    }

    // nombre de lignes
    @Override
    public int getItemCount() {
        return listeTache.size();
    }


    // stocke et recycle les vues lorsqu'elles défilent hors de l'écran
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.taskLine);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // obtenir des données à la position du clic
    String getItem(int id) {
        return listeTache.get(id);
    }

    //permet aux événements de clicks d'être capturés
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    //
    //l'activité parent implémentera cette méthode pour répondre aux événements de click
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
